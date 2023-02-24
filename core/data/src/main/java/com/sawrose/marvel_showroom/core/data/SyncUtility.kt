package com.sawrose.marvel_showroom.core.data

/**
 * Interface marker for a class that manages data synchronization between
 * the local and remote data.
 */
interface Synchronizer {
    suspend fun Syncable.sync() = this@sync.syncWith(this@Synchronizer)
}

/**
 * Interface marker for a class that can be synchronized with a [Synchronizer].
 * Syncing must be performed concurrently & [Synchronizer] is responsible for this.
 */
interface Syncable {
    suspend fun syncWith(synchronizer: Synchronizer): Boolean
}