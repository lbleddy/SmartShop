package com.example.smartshop

interface Communicator {
    var message:String
    fun sendMessage(message: String){
        this.message = message
    }
}