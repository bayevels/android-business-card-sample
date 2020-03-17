package com.bayevels.testandroid.ui.users

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.bayevels.testandroid.R
import com.bayevels.testandroid.data.model.User
import com.bayevels.testandroid.data.repository.utils.Result
import com.bayevels.testandroid.ui.users.adapters.UserListAdapter
import kotlinx.android.synthetic.main.user_list_fragment.*

class UserListFragment : Fragment() {

    companion object {
        fun newInstance() = UserListFragment()
    }

    private lateinit var viewModel: UserListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_list_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        shimmmer_view_container.startShimmer()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.users.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Result.Status.SUCCESS -> {
                    Toast.makeText(context,"Success ${it.data!!.size}",Toast.LENGTH_LONG).show()
                    initView(it.data)
                }
                Result.Status.LOADING-> {
                    shimmmer_view_container.startShimmer()
                    Toast.makeText(context,"Loading",Toast.LENGTH_LONG).show()
                }
                Result.Status.ERROR -> {
                    Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
                    shimmmer_view_container.stopShimmer()
                }
            }
        })
    }

    fun initView(users: List<User>?) {
        shimmmer_view_container.stopShimmer()
        shimmmer_view_container.visibility = View.GONE
        users?.let {
            recycler_view.apply {
                adapter = UserListAdapter(it)
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}
