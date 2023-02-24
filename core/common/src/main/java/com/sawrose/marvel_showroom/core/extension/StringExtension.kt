package com.sawrose.marvel_showroom.core.extension

import java.security.MessageDigest

/**
 *  Convert any string to Message-Digest Algorithm 5 (MD5)
 *
 *  @return MD5 string.
 */
fun String.toMD5() =
    MessageDigest
        .getInstance("MD5")
        .digest(toByteArray())
        .toHex()