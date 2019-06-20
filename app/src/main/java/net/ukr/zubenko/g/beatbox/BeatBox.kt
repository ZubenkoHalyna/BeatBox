package net.ukr.zubenko.g.beatbox

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import java.io.IOException
import android.media.SoundPool
import android.widget.Toast

open class BeatBox(private val context: Context, val settings: Settings) {
    companion object {
        private val TAG = "BeatBox"
        private val SOUNDS_FOLDER = "sample_sounds"
        private val MAX_SOUNDS = 5
    }

    private val mAssets: AssetManager = context.assets
    private val mSounds = mutableListOf<Sound>()
    private var mSoundPool: SoundPool

    val sounds
        get() = mSounds.toList()

    init {
        mSoundPool = SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build()

        loadSounds()
    }

    private fun load(sound: Sound) {
        val afd = mAssets.openFd(sound.mAssetPath)
        val soundId = mSoundPool.load(afd, 1)
        sound.mSoundId = soundId
    }

    private fun loadSounds() {
        val soundNames: Array<String>
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER) ?: arrayOf()
            Log.i(TAG, "Found " + soundNames.size + " sounds")
        } catch (ioe: IOException) {
            Log.e(TAG, "Could not list assets", ioe)
            return
        }

        for (filename in soundNames) {
            try {
                val assetPath = "$SOUNDS_FOLDER/$filename"
                val sound = Sound(assetPath)
                load(sound)
                mSounds.add(sound)
            }
            catch (ioe: IOException) {
                Log.e(TAG, "Could not load sound $filename", ioe)
            }

        }
    }

    open fun play(sound: Sound) {
        sound.mSoundId?.let {
            mSoundPool.play(it, 1.0f, 1.0f, 1, 0, settings.playbackSpeed / 100f)
        }
    }

    fun release() {
        mSoundPool.release()
    }
}