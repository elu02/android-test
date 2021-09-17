package com.example.learning.todo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.learning.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class TodoFragment : Fragment() {

    private var items: ArrayList<String> = arrayListOf()
    private lateinit var itemsAdapter: ArrayAdapter<String>
    private lateinit var listView: ListView
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            val prefs: SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
            val json: String? = prefs.getString("items", null)
            val type: Type = object : TypeToken<ArrayList<String>>() {}.type
            items = Gson().fromJson(json, type)
        } catch(e: Exception) {

        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById<ListView>(R.id.list_view)
        button = view.findViewById<Button>(R.id.add_button)

        button.setOnClickListener {
            var input: EditText = view.findViewById(R.id.add_note)
            var text = input.text.toString()

            if (text != "") {
                items.add(text)
                itemsAdapter.notifyDataSetChanged()
                input.setText("")
                savePreferences()
            }
        }

        itemsAdapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_list_item_1, items)
        listView.setAdapter(itemsAdapter)

        listView.setOnItemLongClickListener { parent, view, position, id ->
            Toast.makeText(context, getString(R.string.item_removed_text), Toast.LENGTH_LONG).show()
            items.removeAt(position)
            itemsAdapter.notifyDataSetChanged()
            savePreferences()
            true
        }
    }

    fun savePreferences() {
        val prefs: SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = prefs.edit()
        val json: String = Gson().toJson(items)
        editor.putString("items", json)
        editor.apply()
    }
}