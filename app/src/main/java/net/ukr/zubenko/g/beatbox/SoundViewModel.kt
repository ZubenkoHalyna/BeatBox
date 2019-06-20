package net.ukr.zubenko.g.beatbox

import android.databinding.BaseObservable
import android.databinding.Bindable

class SoundViewModel(private val mBeatBox: BeatBox): BaseObservable() {
    private lateinit var mSound: Sound

    fun setSound(value: Sound)
    {
        mSound=value
        notifyChange()

    }

    @Bindable
    fun getTitle() = mSound.mName

    fun onButtonClicked() {
        mBeatBox.play(mSound)
    }

}