package com.example.testott.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testott.R
import com.example.testott.common.Movie
import com.example.testott.common.MoviesRepository

class MovieFragment : Fragment() {
    lateinit var root: View

    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager
    private var popularMoviesPage = 1


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle? ): View? {
        root = inflater.inflate(R.layout.fragment_movie, container, false)

        popularMovies = root.findViewById(R.id.popular_movies)
        popularMoviesLayoutMgr = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        popularMovies.layoutManager = popularMoviesLayoutMgr

        popularMoviesAdapter = MoviesAdapter(mutableListOf())
        popularMovies.adapter = popularMoviesAdapter

        getPopularMovies()


        return root
    }

    private fun getPopularMovies() {
        Log.d("MovieFragment", "getPopularMovies() called for page $popularMoviesPage")
        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        popularMoviesAdapter.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = popularMoviesLayoutMgr.itemCount
                val visibleItemCount = popularMoviesLayoutMgr.childCount
                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    popularMoviesPage++
                    getPopularMovies()
                }
            }
        })
    }


    private fun onError() {
        Toast.makeText(activity, "error Movies", Toast.LENGTH_SHORT).show()
    }

}

