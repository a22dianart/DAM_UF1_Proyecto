package com.example.uf1_proyecto.how


import android.content.Intent
import android.net.Uri
import com.example.uf1_proyecto.databinding.ItemButtonBinding
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class HowViewHolder(view:View): RecyclerView.ViewHolder(view){

    val binding = ItemButtonBinding.bind(view)
    val view2 = view


    fun render(companyModel: Company){
        Glide.with(binding.butttonImageView.context).load(companyModel.image).into(binding.butttonImageView)

        binding.butttonImageView.setOnClickListener {
            binding.butttonImageView.setOnClickListener {
                abrirPaginaWeb(companyModel.page)
            }

        }


    }
    private fun abrirPaginaWeb(enlace: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(enlace))
        view2.context.startActivity(intent)
    }
}