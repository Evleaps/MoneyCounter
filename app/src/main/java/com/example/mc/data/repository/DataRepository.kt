package com.example.mc.data.repository


import com.example.mc.data.repository.async.IAsyncRepository

class DataRepository(private val asyncRepository: IAsyncRepository) : IRepository {


}