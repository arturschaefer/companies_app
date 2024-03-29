package com.schaefer.companiesapp.interactor.service

import okhttp3.Interceptor
import okhttp3.Response

object CompaniesInterceptor : Interceptor {
    var accessToken: String? = null
    var client: String? = null
    var uid: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        accessToken?.let { builder.header("access-token", it) }
        client?.let { builder.header("client", it) }
        uid?.let { builder.header("uid", it) }
        return chain.proceed(builder.build())
    }
}
