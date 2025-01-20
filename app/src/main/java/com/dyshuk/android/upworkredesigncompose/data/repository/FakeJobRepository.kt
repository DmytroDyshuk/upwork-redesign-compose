package com.dyshuk.android.upworkredesigncompose.data.repository

import com.dyshuk.android.upworkredesigncompose.data.model.Job

object FakeJobRepository {
    fun getJobList(): List<Job> {
        return fakeJobList
    }

    fun getJobById(id: Int): Job? {
        return fakeJobList.find { it.id == id }
    }
}