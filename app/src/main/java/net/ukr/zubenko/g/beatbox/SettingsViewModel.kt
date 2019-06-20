package net.ukr.zubenko.g.beatbox

import android.content.res.Resources
import android.databinding.BaseObservable
import android.databinding.Bindable

class SettingsViewModel(val settings: Settings = Settings(), private val resources: Resources): BaseObservable() {
    var playbackSpeed: Int
    get() = settings.playbackSpeed
    set(value) {
        settings.playbackSpeed = value
        notifyChange()
    }

    @Bindable
    fun seekBarLbl() = resources.getString(R.string.playback_speed, playbackSpeed)
}