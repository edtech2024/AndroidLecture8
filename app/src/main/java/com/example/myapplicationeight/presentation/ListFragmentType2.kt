package com.example.myapplicationeight.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationeight.databinding.FragmentListT2Binding
import com.example.myapplicationeight.domain.Item

class ListFragmentType2 : Fragment() {

    // Creates a new fragment given parameters
    // ListFragmentType2.newInstance()
    companion object {

        private const val TYPE = "Type"

        fun newInstance(type: Int?): ListFragmentType2 {
            val fragmentListT2 = ListFragmentType2()
            val args = Bundle()
            args.putInt(TYPE, type!!)
            fragmentListT2.arguments = args
            return fragmentListT2
        }
    }

    // Define the events that the fragment will use to communicate
    interface OnItemEditType2Listener{
        // This can be any number of events to be sent to the activity
        fun onEditItemType2(edit: Bundle)
    }

    // Define the listener of the interface type
    // listener will the activity instance containing fragment
    private var listenerEdit: OnItemEditType2Listener? = null

    private lateinit var itemAdapterType2: ItemAdapter

    val listViewModel: ListViewModel by viewModels( ownerProducer = { requireParentFragment() })

    private var _binding: FragmentListT2Binding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listenerEdit = context as ListFragmentType2.OnItemEditType2Listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentListT2Binding.inflate( inflater, container, false)
        _binding!!.lifecycleOwner = this
        _binding!!.listViewModel = listViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvListType2.layoutManager = LinearLayoutManager(this.context)
        this.itemAdapterType2 = ItemAdapter(){ item -> onItemClicked(item) }
        binding.rvListType2.adapter = itemAdapterType2
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDetach() {
        super.onDetach()
        listenerEdit  = null
    }

    // Now we can fire the event when the user selects something in the fragment
    private fun onEditClicked(bundle: Bundle){
        listenerEdit?.onEditItemType2(bundle)
    }

    private fun onItemClicked(item: Item){

        val args = Bundle()
        args.putString("Action", "Edit")
        args.putInt("Id", item.id!!)
        args.putString("Title", item.title!!.toString())
        args.putString("Description", item.description!!.toString())
        args.putString("Priority", item.priority!!.toString())
        args.putString("Type", item.type!!.toString())
        args.putString("Count", item.count!!.toString())
        args.putString("Frequency", item.frequency!!.toString())
        args.putString("Uid", item.uid!!.toString())
        args.putString("Date", item.date!!.toString())
        args.putString("Color", item.color!!.toString())

        onEditClicked(args)
    }

}