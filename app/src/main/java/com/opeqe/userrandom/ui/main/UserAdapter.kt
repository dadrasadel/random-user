package com.opeqe.userrandom.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bilerplatemvvm.R
import com.example.bilerplatemvvm.databinding.UserItemBinding
import com.opeqe.userrandom.data.model.Result
import com.opeqe.userrandom.data.model.User
import java.sql.Statement


class UserAdapter constructor(val detailClick: (Result) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolderNormal>() {
    var list: List<Result> = arrayListOf()
    private lateinit var context: Context

    class ViewHolderNormal(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNormal{
        context = parent.context
        val binding = UserItemBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item, parent, false)
        )
        return ViewHolderNormal(binding)
    }


    override fun onBindViewHolder(holder: ViewHolderNormal, position: Int) {
        with(holder){
            Glide
                .with(context)
                .load(list[position].picture.large)
                .error(R.drawable.ic_web_cloud)
                .into(binding.imgPerson)
            binding.tvEmail.text=list[position].email
            binding.tvPersonName.text= list[position].name.first.plus(list[position].name.last)
            binding.root.setOnClickListener {
                detailClick(list[position])
            }
        }


    }

    override fun getItemCount(): Int {
        return list.size

    }

    fun updateList(list: List<Result>) {
        this.list = list
        notifyDataSetChanged()
    }

}