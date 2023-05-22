package com.maskalor.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.maskalor.myapplication.R
import com.maskalor.myapplication.databinding.FragmentTaskListBinding


class TaskListFragment(private val taskListId: Int) : Fragment() {

    private lateinit var binding: FragmentTaskListBinding
    private lateinit var viewModel: TaskListViewModel

//    val taskListId by lazy {
//        arguments?.getInt(ARG_TASK_LIST_ID)!!
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TaskListViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TaskListAdapter()

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.list.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        viewModel.getTasksFromTaskList(taskListId)
    }

//    companion object {
//        private const val ARG_TASK_LIST_ID = "task_list_id"
//
//        fun newInstance(idTaskList: Int) =
//            TaskListFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_TASK_LIST_ID, idTaskList)
//                }
//            }
//    }
}