package dev.mariag.billz2.model

import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message:String,
    @SerializedName("access_token")var accessToken:String,
    @SerializedName("user_id") var userId: String
)
