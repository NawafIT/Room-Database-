package com.example.roomdatabase.data

// to fitch the data from database //
class UserRepository(private val userDao: UserDao) {
    // to get all data from the database //
    val readAllData = userDao.readAllData()

    // to insert user to the database
    suspend fun addUser(user: User) {
        userDao.addUser(user = user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user = user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user = user)
    }

    suspend fun deleteAllUser() {
        userDao.deleteAllUser()
    }
}