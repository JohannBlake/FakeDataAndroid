package dev.fakedata.ui.main.fragments.users

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.fakedata.R
import dev.fakedata.databinding.FragmentUsersBinding

class UsersFragment : Fragment() {

    companion object {
        fun newInstance() = UsersFragment()
    }

    private lateinit var viewModel: UsersViewModel

    private var mContext: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.fragment_users, container, false)

        mContext = context

        val binding = FragmentUsersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
