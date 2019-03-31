package com.example.mysample.data.mapper.util

interface Mapper<ENTITY, DATA_OBJECT> {

    fun translate(entity: ENTITY): DATA_OBJECT
}