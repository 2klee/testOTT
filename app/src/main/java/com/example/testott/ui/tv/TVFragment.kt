package com.example.testott.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testott.R
import com.example.testott.common.TV
import com.example.testott.common.TVRepository

class TVFragment : Fragment() {
    lateinit var root : View

    private lateinit var popularTV: RecyclerView
    private lateinit var popularTVAdapter: TVAdapter
    private lateinit var popularTVLayoutMgr: LinearLayoutManager
    private var popularTVPage = 1

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): View? {

        root = inflater.inflate(R.layout.fragment_tv, container, false)

        popularTV = root.findViewById(R.id.popular_tv)
        popularTVLayoutMgr = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        popularTV.layoutManager = popularTVLayoutMgr
        popularTVAdapter = TVAdapter(mutableListOf()) { tv -> showTVDetails(tv) }
        popularTV.adapter = popularTVAdapter


        getPopularTV()

        return root
    }


    private fun getPopularTV() {
        TVRepository.getPopularTV(
            popularTVPage,
            ::onPopularTVFetched,
            ::onError
        )
    }

    private fun onPopularTVFetched(tvlist: List<TV>) {
        popularTVAdapter.appendTV(tvlist)
        attachPopularTVOnScrollListener()
    }

    private fun attachPopularTVOnScrollListener() {
        popularTV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = popularTVLayoutMgr.itemCount
                val visibleItemCount = popularTVLayoutMgr.childCount
                val firstVisibleItem = popularTVLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    popularTV.removeOnScrollListener(this)
                    popularTVPage++
                    getPopularTV()
                }
            }
        })
    }


    private fun onError() {
        Toast.makeText(activity, "error Movies", Toast.LENGTH_SHORT).show()
    }

    private fun showTVDetails(tv: TV) {
    }
}
