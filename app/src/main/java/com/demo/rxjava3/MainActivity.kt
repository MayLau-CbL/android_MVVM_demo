package com.demo.rxjava3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.demo.rxjava3.fragment.BottomFragment
import com.demo.rxjava3.fragment.HomeFragment
import com.demo.rxjava3.viewmodel.DataViewModel
import com.demo.rxjava3.viewmodel.factory.GeneralViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataViewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initFragment()

        btn_refresh.setOnClickListener {
            dataViewModel.fetchNewData()
        }
    }

    private fun initFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_fragment_top, HomeFragment())
        fragmentTransaction.replace(R.id.fl_fragment_bottom, BottomFragment())
        fragmentTransaction.commit()
    }

    private fun initViewModel() {
        dataViewModel =
            ViewModelProvider(this, GeneralViewModelFactory()).get(DataViewModel::class.java)
    }

}
