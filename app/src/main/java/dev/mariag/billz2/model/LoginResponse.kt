package dev.mariag.billz2.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class LoginResponse(
    var email: String,
    var password: String
)
