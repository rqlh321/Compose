package com.example.personal_data_api

import com.example.personal_data_api.model.Contact

interface ContactRepo {
    suspend fun all(): List<Contact>
}