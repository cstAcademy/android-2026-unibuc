package cst.unibucfmiif2026.network.dto

data class LoginRequestDTO(val email: String, val password: String)

data class LoginResponseDTO(val token: String?)