    package com.example.uf1_proyecto

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import com.bumptech.glide.Glide

    import com.example.uf1_proyecto.databinding.FragmentInfoBinding

    class InfoFragment : Fragment() {
        private var _binding: FragmentInfoBinding? = null
        private val binding get() = _binding!!


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentInfoBinding.inflate(inflater, container, false)
            val view = binding.root

            Glide.with(binding.profile.context).load("https://avatars.githubusercontent.com/u/114477134?v=4").into(binding.profile)


            return view
        }






    }