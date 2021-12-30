package com.opeqe.userrandom.ui.base
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.bilerplatemvvm.R
import com.opeqe.userrandom.utility.Commons.showErrorMessage
import dagger.hilt.android.AndroidEntryPoint
typealias Inflate<T> = (LayoutInflater)->T
@AndroidEntryPoint
open class hiltActivity: AppCompatActivity()
open class BaseActivity<VB: ViewBinding>(val inflate: Inflate<VB>) : hiltActivity() {
    private val viewModel:BaseViewModel by viewModels()
    var _binding: VB? = null
    val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=inflate.invoke(layoutInflater)
        setContentView(binding.root)
        if(viewModel.useHooking()){
            showErrorMessage(getString(R.string.use_hooking),this)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            changeStatusColor()
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    open fun changeStatusColor() {
        val window = window
        // clear FLAG_TRANSLUCENT_STATUS flag:
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    // finally change the color
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
    }
    open fun initGridRecycler(recyclerView: RecyclerView): RecyclerView {
        recyclerView.layoutManager = GridLayoutManager(this,3)
        return recyclerView
    }
    open fun initVerticalRecycler(recyclerView: RecyclerView): RecyclerView {
        recyclerView.layoutManager = LinearLayoutManager(this)
        return recyclerView
    }
}






