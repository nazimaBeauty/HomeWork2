package com.example.homework2

fun isPhoto(photo: String): Boolean {

    return if (photo.length == 3) {
        false
    } else {
        val checker = photo.substring(photo.length - 3)
        checker == "png" || checker == "jpg"
    }
}