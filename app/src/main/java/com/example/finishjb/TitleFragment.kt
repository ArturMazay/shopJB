package com.example.finishjb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class TitleFragment : Fragment() {

    companion object {
        fun newInstance() = TitleFragment()
    }
    private val onClick: OnClickTo? = null
    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.title_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)


        val rv: RecyclerView? = view.findViewById(R.id.image_list)
        val myAdapter = MyAdapter(onClickTo = object :OnClickTo{
            override fun onClickAddCart() {
                onClick?.onClickAddCart()
            }
        })
        rv?.adapter = myAdapter

        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        viewModel.product.observe(viewLifecycleOwner, Observer {
            it?.let {
                myAdapter.data = it
                myAdapter.notifyDataSetChanged()
            }
        })

    }

}

