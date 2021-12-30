package com.opeqe.userrandom.ui.main.user_detail

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.bilerplatemvvm.R
import com.example.bilerplatemvvm.databinding.FragmentUserDetailBinding
import com.opeqe.userrandom.data.model.Result
import com.opeqe.userrandom.ui.base.BaseFragment

class UserDetailFragment:BaseFragment<FragmentUserDetailBinding>(FragmentUserDetailBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result=arguments?.getSerializable("result") as Result
        binding.tvAge.text=getString(R.string.age,result.dob.age.toString())
        binding.tvName.text=getString(R.string.name,result.name.first.plus(result.name.last))
        binding.tvEmail.text=getString(R.string.email,result.email)
        binding.tvGender.text=getString(R.string.gender,result.gender)
        binding.tvUserName.text=getString(R.string.username,result.login.username)
        binding.tvPassword.text=getString(R.string.password,result.login.password)
        binding.tvLocation.text=getString(R.string.location,result.location.state)
        binding.tvPasscode.text=getString(R.string.postcode,result.location.postcode.toString())
        binding.tvPhone.text=getString(R.string.phone,result.phone)
        Glide
            .with(requireContext())
            .load(result.picture.large)
            .error(R.drawable.ic_web_cloud)
            .into(binding.imgPerson)
    }

}