
@file:Suppress("UnstableApiUsage")
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import kotlinx.benchmark.gradle.*
import org.jetbrains.kotlin.allopen.gradle.*
import org.jetbrains.kotlin.gradle.tasks.*

plugins {
    java
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.allopen") version "1.4.0"
    id("org.jetbrains.kotlinx.benchmark") version "0.3.0"
}

sourceSets.all {
    java.setSrcDirs(listOf("$name/src"))
    resources.setSrcDirs(listOf("$name/resources"))
}

configure<AllOpenExtension> {
    annotation("org.openjdk.jmh.annotations.State")
}

group = "ch8n.bigbrain.problem_solving"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.3.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

benchmark {
    configurations {
        named("main") {
            warmups = 5
            iterations = 5
            iterationTime = 300
            iterationTimeUnit = "ms"
        }
    }
    targets {
        register("main") {
            this as JvmBenchmarkTarget
            jmhVersion = "1.21"
        }
    }
}

