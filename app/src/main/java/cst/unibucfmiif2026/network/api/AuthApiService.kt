package cst.unibucfmiif2026.network.api

import cst.unibucfmiif2026.network.dto.LoginRequestDTO
import cst.unibucfmiif2026.network.dto.LoginResponseDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("api/login")
    suspend fun login(@Body requestModel : LoginRequestDTO) : LoginResponseDTO
}