package me.app

data class Auth(
    val login_name: String,
    val login_hash: String,
    val is_expired: String,
)