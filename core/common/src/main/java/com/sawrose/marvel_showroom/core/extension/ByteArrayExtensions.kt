package com.sawrose.marvel_showroom.core.extension

/**
 * Convert any byte array to hexadecimal string.
 *
 * @return Hexadecimal string.
 */
fun ByteArray.toHex() = joinToString("") {
    "%02x".format(it)
}