package com.hypersoft.baseproject.presentation.mediaVideoDetails.factory

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MediaPlayerFactory @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun create(uri: Uri): MediaPlayer {
        return MediaPlayer().apply {
            setDataSource(context, uri)
        }
    }
}