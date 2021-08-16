package softing.ubah4ukdev.popularlibrary.domain.api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import softing.ubah4ukdev.populatelibrary.BuildConfig


/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.api

Created by Ivan Sheynmaer

2021.08.16
v1.0
 */
object GitHubApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header(
                    "Authorization",
                    Credentials.basic(BuildConfig.API_LOGIN, BuildConfig.API_TOKEN)
                )
                .build()
        )
}