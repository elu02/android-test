package com.example.learning.tab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learning.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tab2Fragment : Fragment() {
    private lateinit var searchView : SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_view).layoutManager = LinearLayoutManager(requireActivity())
        view.findViewById<RecyclerView>(R.id.recycler_view).setHasFixedSize(true)

        searchView = view.findViewById<SearchView>(R.id.search_bar)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                view.clearFocus()
                if (p0!!.length < 3) {
                    Toast.makeText(requireActivity(), "Please enter at least 3 characters", Toast.LENGTH_LONG).show()
                    return true
                }
                val apiService = JikanApiService.getInstance().create(JikanApiInterface::class.java)
                apiService.getAnimeList(p0!!).enqueue(object : Callback<AnimeResults>{
                    override fun onResponse(
                        call: Call<AnimeResults>,
                        response: Response<AnimeResults>
                    ) {
                        view.findViewById<RecyclerView>(R.id.recycler_view).adapter = AnimeAdapter(response.body()!!.results)
                    }

                    override fun onFailure(call: Call<AnimeResults>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean = true

        })

    }
}







