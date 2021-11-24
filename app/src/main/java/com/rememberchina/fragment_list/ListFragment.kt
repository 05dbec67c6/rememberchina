package com.rememberchina.list2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rememberchina.databinding.FragmentListBinding
import com.rememberchina.e_RemoteDataSource.network.ListFragmentAdapter


class ListFragment : Fragment() {

    private val viewModel: ListViewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel

        binding.viewModel
        binding.viewModel = viewModel

        binding.photosGrid.adapter = ListAdapter()

        return binding.root
    }


}

class ListFragment : Fragment() {

    private val viewModel: com.rememberchina.list_wefw.ListViewModel by lazy {
        ViewModelProvider(this).get(com.rememberchina.list_wefw.ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.photosGrid.adapter = ListFragmentAdapter()

        return binding.root
    }


}