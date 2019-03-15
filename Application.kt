package com.jino.documentsearch

import android.app.Application

import com.jino.documentsearch.api.APIClient
import com.jino.documentsearch.utils.Logger

open class Application : Application() {

    private val clientId = "_WRT9sR_Z05lB7lfxtRI"
    private val clientSecret = "Mjw5IG9a2K"

    override fun onCreate() {
        super.onCreate()
        Logger.init(BuildConfig.DEBUG, javaClass.name)
        APIClient.init(clientId, clientSecret)
    }
}