package net.ukr.zubenko.g.beatbox

import net.ukr.zubenko.g.criminalintent.SingleFragmentActivity

class BeatBoxActivity : SingleFragmentActivity() {
    override fun createFragment() = BeatBoxFragment.newInstance()
}
