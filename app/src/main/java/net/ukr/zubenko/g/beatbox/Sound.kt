package net.ukr.zubenko.g.beatbox

class Sound(val mAssetPath: String) {
    val mName: String
    var mSoundId: Int? = null

    init {
        val components = mAssetPath.split("/")
        val filename = components[components.size - 1]
        mName = filename.replace(".wav", "")
    }
}