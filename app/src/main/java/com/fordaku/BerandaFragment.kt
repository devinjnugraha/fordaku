package com.fordaku

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BerandaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BerandaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var posts: ArrayList<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BerandaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BerandaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        adapter = PostAdapter(posts)
        recyclerView = view.findViewById(R.id.rvBeranda)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    private fun dataInitialize() {
        // TODO: Integrate with database and add profile photo to FORDA data class and RecyclerView
        posts = arrayListOf<Post>()

        posts.add(Post("Jombang Menjadi Kota yang Paling Berdesa", "", "", "05/12/2022 19:30", "Jombang Merdeka"))
        posts.add(Post("Pantai Pulau Merah Semakin Ramai Pengunjung!", "", "", "03/12/2022 20:30", "Banyuwangi Maju"))
        posts.add(Post("Etika Profesi Malang Semakin Bobrok!", "", "", "05/12/2022 19:30", "Forum Malang Raya"))
        posts.add(Post("Tanah Bumbu Membumbu Buta di Tanah yang Berbumbu Sangat Banyak", "", "", "05/12/2022 21:30", "Warga Banua Berbumbu Raya"))
        posts.add(Post("Etika Profesi Malang Semakin Bobrok!", "", "", "05/12/2022 19:30", "Forum Malang Raya"))
        posts.add(Post("Pantai Pulau Merah Semakin Ramai Pengunjung!", "", "", "03/12/2022 20:30", "Banyuwangi Maju"))
        posts.add(Post("Jombang Menjadi Kota yang Paling Berdesa", "", "", "05/12/2022 19:30", "Jombang Merdeka"))
        posts.add(Post("Etika Profesi Malang Semakin Bobrok!", "", "", "05/12/2022 19:30", "Forum Malang Raya"))
    }

}