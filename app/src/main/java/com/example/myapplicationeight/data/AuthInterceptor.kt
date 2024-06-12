package com.example.myapplicationeight.data

import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

            val request = chain.request().newBuilder()
                .addHeader("Authorization","3acddc5d-0eaf-4f51-a495-b8061f8aea83")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build()

            return chain.proceed(request)
    }
}
