package net.ukr.zubenko.g.beatbox

import org.hamcrest.core.Is
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class SoundViewModelTest {
    private lateinit var mBeatBox: BeatBox
    private lateinit var mSound: Sound
    private lateinit var mSubject: SoundViewModel

    @Before
    fun setUp() {
        mBeatBox = mock(BeatBox::class.java)
        mSound = Sound("assetPath")
        mSubject = SoundViewModel(mBeatBox)
        mSubject.setSound(mSound)
    }

    @Test
    fun exposesSoundNameAsTitle() {
        assertEquals(mSubject.getTitle(), mSound.mName)
    }

    @Test
    fun callsBeatBoxPlayOnButtonClicked() {
        mSubject.onButtonClicked()
        verify(mBeatBox).play(mSound)
    }
}