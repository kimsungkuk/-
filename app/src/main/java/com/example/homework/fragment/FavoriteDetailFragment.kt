package com.example.homework.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.MainActivityViewModel
import com.example.homework.R
import com.example.homework.RecyclerViewAdapter


class FavoriteDetailFragment : Fragment() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.favorate_recyclerview)

        initRecyclerView()
        initViewModel()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_detail, container, false)
    }

    private fun initRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter

    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getLiveDataObserver().observe(viewLifecycleOwner,
            { t ->
                if (t != null) {
                    t.list?.let { recyclerViewAdapter.setUpdatedData(it) }
                    recyclerViewAdapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "서버와의 통신이 불안정합니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        mainActivityViewModel.makeApicall("save")
    }
}