package com.foo.gagofarm.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foo.gagofarm.MainActivity
import com.foo.gagofarm.R
import com.foo.gagofarm.SearchRecyclerViewAdapter
import com.foo.gagofarm.data.SearchViewItem
import com.foo.gagofarm.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private val data = mutableListOf<SearchViewItem>()
    private lateinit var searchRecyclerViewAdapter:SearchRecyclerViewAdapter

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container,false)

        binding.mapButton.setOnClickListener{
            Toast.makeText(mainActivity, "image", Toast.LENGTH_SHORT).show()
        }
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchRecyclerViewAdapter = SearchRecyclerViewAdapter(mainActivity)
        makeDummyData()
        searchRecyclerViewAdapter.list = data

        binding.searchRecyclerView.adapter = searchRecyclerViewAdapter
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun makeDummyData(){
        data.add(SearchViewItem("","title1","1~1","12",12,false))
        data.add(SearchViewItem("","title1","1~1","12",12,false))
        data.add(SearchViewItem("","title1","1~1","12",12,false))
        data.add(SearchViewItem("","title1","1~1","12",12,false))
        data.add(SearchViewItem("","title1","1~1","12",12,false))
        data.add(SearchViewItem("","title1","1~1","12",12,false))
        data.add(SearchViewItem("","title1","1~1","12",12,false))

    }



}