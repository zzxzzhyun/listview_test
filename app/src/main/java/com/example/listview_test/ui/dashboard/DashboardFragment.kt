package com.example.listview_test.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.listview_test.MainActivity
import com.example.listview_test.R
import com.example.listview_test.databinding.FragmentDashboardBinding
import com.example.listview_test.PhoneNumberActivity
import org.json.JSONArray

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var array = arrayOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val jsonString = activity?.assets?.open("phoneNumber.json")?.reader()?.readText()
        val jsonarray = JSONArray(jsonString)
        for (i in 0 until jsonarray.length()){
            val person = jsonarray.getJSONObject(i)
            array = array.plus(person.getString("Display Name"))
        }
        val context = context as MainActivity

        val adapter = ArrayAdapter(context, R.layout.listview_item,array)

        val listView: ListView = root.findViewById(R.id.list_item)
        listView.adapter = adapter


        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(context, PhoneNumberActivity::class.java).apply{
                putExtra("id",id.toInt())
            }
            startActivity(intent)
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}