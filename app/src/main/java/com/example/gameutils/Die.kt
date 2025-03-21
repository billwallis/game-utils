package com.example.gameutils


class Die (
    private val faces: Int = 6
){
    private fun assert_positive_integer(value: Any) {
        if (value !is Int) {
            error("Argument is not of type Int")
        } else if (value < 1) {
            error("Argument is not positive")
        }
    }

    fun roll(): Int {
        return (1..faces).random()
    }
}