package com.dyshuk.android.upworkredesigncompose.data.repository

import com.dyshuk.android.upworkredesigncompose.data.model.Job

object FakeJobRepository {
    fun getJobs(): List<Job> {
        return fakeJobList
    }
}