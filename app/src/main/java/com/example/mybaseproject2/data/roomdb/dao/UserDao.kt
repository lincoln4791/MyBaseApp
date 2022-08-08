package com.example.mybaseproject2.data.roomdb.dao
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.mybaseproject2.data.responses.User

/**
 * Created By Lincoln
 */

@Dao
interface UserDao {

    //User
    @Query("SELECT * FROM user")
    fun getAllUser(): MutableList<User>

    @Insert(onConflict = REPLACE)
    fun insertUser(user : User)

    @Query("Delete from user")
    fun deleteAllUser()


}