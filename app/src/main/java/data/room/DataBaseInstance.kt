package data.room

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

object DataBaseInstance {

    private var instance: TransactionDatabase? = null

    @OptIn(InternalCoroutinesApi::class)
    fun getInstance(context: Context): TransactionDatabase {
        if (instance == null) {
    synchronized(TransactionDatabase::class.java){
        instance = roomBuild(context)
}
        }
    return instance!!
    }

    private fun roomBuild(context: Context): TransactionDatabase =
        Room.databaseBuilder(context,
            TransactionDatabase::class.java, "transaction_database")
            .fallbackToDestructiveMigration()
            .build()
}