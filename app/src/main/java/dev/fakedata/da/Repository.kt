package dev.fakedata.da

import dev.fakedata.da.local.room.RoomDao
import dev.fakedata.da.web.FakeDataAPI
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Acts as a single interface to data throughout the app. However, calls to backend APIs should only be made by the service as it coordinates
 * multiple API calls and runs asynchronously to calls to the Room database.
 */
@Singleton
class Repository @Inject constructor(
    private val linkedInAPI: FakeDataAPI,
    private val appDao: RoomDao
) {

}