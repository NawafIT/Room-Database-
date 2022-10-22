package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update(entity = User::class)
    suspend fun updateUser(user: User)

    @Delete(entity = User::class)
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE firstName OR lastName = :name ")
    fun getByName(name: String): User

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUser()

}