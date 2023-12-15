    package com.example.uf1_proyecto

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.activityViewModels
    import androidx.lifecycle.lifecycleScope
    import com.example.uf1_proyecto.data.TripApplication
    import com.example.uf1_proyecto.data.TripViewModel
    import com.example.uf1_proyecto.data.TripViewModelFactory
    import com.example.uf1_proyecto.databinding.FragmentInfoBinding

    class InfoFragment : Fragment() {
        private var _binding: FragmentInfoBinding? = null
        private val binding get() = _binding!!
        private val viewModel: TripViewModel by activityViewModels {
            TripViewModelFactory(
                (activity?.application as TripApplication).database
                    .tripDao()
            )
        }


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentInfoBinding.inflate(inflater, container, false)
            val view = binding.root


            val appInstance = requireActivity().application
            if (appInstance is TripApplication) {
                println("Application type is TripApplication")

            } else {
                throw IllegalArgumentException("Application is not TripApplication")
            }

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.trips.collect { trips ->
                    binding.texto.text = trips.size.toString()
                }
            }



            return view
        }






    }