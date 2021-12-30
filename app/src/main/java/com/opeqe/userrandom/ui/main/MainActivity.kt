package com.opeqe.userrandom.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bilerplatemvvm.R
import com.example.bilerplatemvvm.databinding.ActivityMainBinding
import com.opeqe.userrandom.ui.base.BaseActivity
import com.opeqe.userrandom.ui.main.user_detail.UserDetailFragment
import com.opeqe.userrandom.utility.Commons.showErrorMessage
import com.opeqe.userrandom.utility.CustomResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
        setUpRecycler()

    }

    private fun observeData() {
        viewModel.resultData.observe(this, {
            when (it.status) {
                CustomResponse.Status.SUCCESS -> {
                    adapter.updateList(it.data?.results!!)
                }
                CustomResponse.Status.ERROR -> {
                    showErrorMessage(it.message!!, this)
                }
                else -> {
                    showErrorMessage(getString(R.string.NetWork_error), this)
                }
            }
        })
    }

    private fun setUpRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        adapter = UserAdapter {
            val fragment=UserDetailFragment()
            val bundle=Bundle()
            bundle.putSerializable("result",it)
            fragment.arguments=bundle
            supportFragmentManager.beginTransaction().add(R.id.root_layout,fragment,"detail_fragment").addToBackStack(null).commitAllowingStateLoss()
        }
        binding.rvUser.adapter = adapter
        binding.rvUser.layoutManager = linearLayoutManager
    }

}