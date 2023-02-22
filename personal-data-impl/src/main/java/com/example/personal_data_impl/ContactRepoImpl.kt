package com.example.personal_data_impl

import com.example.personal_data_api.ContactRepo
import com.example.personal_data_api.model.Contact
import kotlinx.coroutines.delay
import javax.inject.Inject

class ContactRepoImpl @Inject constructor() : ContactRepo {
    override suspend fun all(): List<Contact> {
        delay(2_000)
        val list = ArrayList<Contact>()
        repeat(100){
            list.add(
                Contact(
                    id = it.toString(),
                    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
                    name = "name"
                )
            )
        }
        return list
    }
}