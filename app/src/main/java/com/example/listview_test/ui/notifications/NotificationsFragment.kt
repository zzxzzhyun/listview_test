package com.example.listview_test.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listview_test.*
import com.example.listview_test.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var lstBook = listOf<Book>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val context = context as MainActivity

        val adapter = ImageAdapter(context)

        val girdView: GridView = root.findViewById(R.id.gridView)
        girdView.adapter = adapter

        girdView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(context, FullImageActivity::class.java).apply{
                putExtra("id",id.toInt())
            }
            startActivity(intent)
        }
*/
        lstBook = lstBook.plus(Book("one", "Category", "Description", R.mipmap.beach0))
        lstBook = lstBook.plus(Book("two", "Category", "Description", R.mipmap.beach4))
        lstBook = lstBook.plus(Book("three", "Category", "Description", R.mipmap.tree8))
        lstBook = lstBook.plus(Book("four", "Category", "Description", R.mipmap.beach0))
        lstBook = lstBook.plus(Book("five", "Category", "Description", R.mipmap.beach4))
        lstBook = lstBook.plus(Book("one", "Category", "Description", R.mipmap.beach0))
        lstBook = lstBook.plus(Book("two", "Category", "Description", R.mipmap.beach4))
        lstBook = lstBook.plus(Book("three", "Category", "Description", R.mipmap.tree8))
        lstBook = lstBook.plus(Book("four", "Category", "Description", R.mipmap.beach0))
        lstBook = lstBook.plus(Book("five", "Category", "Description", R.mipmap.beach4))

        val myrv: RecyclerView = root.findViewById(R.id.recyclerview_id)
        val myAdapter = RecyclerViewAdapter(context,lstBook)
        myrv.layoutManager = GridLayoutManager(context, 3)
        myrv.adapter = myAdapter

        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}