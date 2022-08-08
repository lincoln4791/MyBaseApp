package com.example.mybaseproject2.di

import android.content.Context
import com.example.mybaseproject2.data.UserPreferences
import com.example.mybaseproject2.data.network.AuthApi
import com.example.mybaseproject2.data.network.RemoteDataSource
import com.example.mybaseproject2.data.network.UserApi
import com.example.mybaseproject2.data.repository.UserRepository
import com.example.mybaseproject2.data.roomdb.MyRoomDB
import com.example.mybaseproject2.data.roomdb.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAuthApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): AuthApi {
        return remoteDataSource.buildApi(AuthApi::class.java, context)
    }

    @Singleton
    @Provides
    fun provideUserApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): UserApi {
        return remoteDataSource.buildApi(UserApi::class.java, context)
    }


//
    @Singleton
    @Provides
    fun provideUserDao(
        myDB : MyRoomDB
    ): UserDao {
        return myDB.myDao()
    }

    @Singleton
    @Provides
    fun provideRoomDB(
        @ApplicationContext context: Context
    ): MyRoomDB {
        return MyRoomDB.getDatabase(context)
    }


    @Singleton
    @Provides
    fun provideUserPreferences(
        @ApplicationContext context: Context
    ): UserPreferences {
        return UserPreferences(context)
    }


    @Singleton
    @Provides
    fun provideUserRepository(
        @ApplicationContext context: Context,
        userApi : UserApi,
        userDao: UserDao
    ): UserRepository {
        return UserRepository(userApi,userDao)
    }




}