package dev.fakedata.da.local.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import dev.fakedata.model.UserInfo


@Dao
interface RoomDao {
    // Users
    @Query("SELECT * FROM Users ORDER BY firstName COLLATE NOCASE ASC, lastName COLLATE NOCASE ASC")
    fun getUsers(): DataSource.Factory<Int, UserInfo>
}