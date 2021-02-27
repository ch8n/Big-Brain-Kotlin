package leetcode

fun defangIPaddr(address: String): String {
    return address.map {
        if (it == '.') {
            "[.]"
        } else {
            it.toString()
        }
    }.joinToString(separator = "")
}
