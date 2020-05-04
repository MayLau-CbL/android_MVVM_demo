package com.demo.rxjava3.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.demo.rxjava3.R
import com.demo.rxjava3.viewmodel.DataViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val dataViewModel: DataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()
        initViewModel()
    }

    private fun initViewModel() {
        dataViewModel.dataLiveData.observe(this.viewLifecycleOwner, Observer {
            tv_home_title.text = it
        })
    }
}