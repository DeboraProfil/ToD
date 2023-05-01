package com.deb.tod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.deb.tod.databinding.NewTaskLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewTaskBottomSheet:BottomSheetDialogFragment() {

    var newTaskLayoutBinding: NewTaskLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newTaskLayoutBinding = NewTaskLayoutBinding.inflate(inflater,container, false  )
        return newTaskLayoutBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        newTaskLayoutBinding?.saveTaskButton?.setOnClickListener {
            val task = newTaskLayoutBinding?.taskText?.text
            task?.let {
                Toast.makeText(requireContext(), "New task - > ${it.toString()}",  Toast.LENGTH_SHORT).show()
            }
        }


    }


}