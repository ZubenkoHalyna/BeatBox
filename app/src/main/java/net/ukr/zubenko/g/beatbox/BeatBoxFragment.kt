package net.ukr.zubenko.g.beatbox

import android.support.v4.app.Fragment
import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.inflate
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import net.ukr.zubenko.g.beatbox.databinding.FragmentBeatBoxBinding
import android.support.v7.widget.GridLayoutManager
import net.ukr.zubenko.g.beatbox.databinding.ListItemSoundBinding
import android.support.v7.widget.RecyclerView


class BeatBoxFragment: Fragment() {
    private inner class SoundHolder(private val mBinding: ListItemSoundBinding) :
        RecyclerView.ViewHolder(mBinding.root)
    {
        init {
            mBinding.viewModel = SoundViewModel(mBeatBox)
        }

        fun bind(sound: Sound) {
            mBinding.viewModel?.setSound(sound)
            mBinding.executePendingBindings()
        }
    }

    private inner class SoundAdapter(private val mSounds: List<Sound>) : RecyclerView.Adapter<SoundHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val inflater = LayoutInflater.from(requireActivity())
            val binding = inflate<ListItemSoundBinding>(inflater, R.layout.list_item_sound, parent, false)

            return SoundHolder(binding)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            val sound = mSounds[position]
            holder.bind(sound)
        }

        override fun getItemCount() = mSounds.size
    }

    companion object {
        fun newInstance(): BeatBoxFragment {
            return BeatBoxFragment()
        }
    }

    private lateinit var mBeatBox: BeatBox

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = inflate<FragmentBeatBoxBinding>(inflater, R.layout.fragment_beat_box, container, false)
        binding.recyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
        binding.recyclerView.adapter = SoundAdapter(mBeatBox.sounds)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBeatBox = BeatBox(requireActivity())
    }
}