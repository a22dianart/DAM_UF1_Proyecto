    package com.example.uf1_proyecto

    import android.content.Intent
    import android.net.Uri
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

            binding.profile.setOnClickListener {
                // Crear un Intent para abrir el navegador web con la URL
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/a22dianart"))

                // Iniciar la actividad del navegador web
                startActivity(intent)
            }

            return view
        }






    }