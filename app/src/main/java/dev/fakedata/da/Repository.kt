package dev.fakedata.da

import androidx.paging.DataSource
import dev.fakedata.bo.UsersAPIOptions
import dev.fakedata.da.local.room.RoomDao
import dev.fakedata.da.web.FakeDataAPI
import dev.fakedata.model.UserInfo
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Acts as a single interface to data throughout the app. However, calls to backend APIs should only be made by the service as it coordinates
 * multiple API calls and runs asynchronously to calls to the Room database.
 */
@Singleton
class Repository @Inject constructor(
    private val mFakeDataAPI: FakeDataAPI,
    private val mAppDao: RoomDao
) {
    fun getUsersFromLocalDB(options: UsersAPIOptions): DataSource.Factory<Int, UserInfo> {
        if (options.sortDesc)
            return mAppDao.getUsersDesc()
        else
            return mAppDao.getUsersAsc()
    }

    fun getUsersFromServer(options: UsersAPIOptions): Observable<List<UserInfo>> {
        return mFakeDataAPI.getUsers(options.startPos, options.pageSize, if (options.sortDesc) "desc" else "asc", options.imageSize)
    }
}