package com.example.newapp.view.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.newapp.R
import com.example.newapp.databinding.FragmentDetailsBinding
import com.example.newapp.model.Article
import com.example.newapp.viewModel.OfflineViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    val viewModel: OfflineViewModel by viewModels()

    private lateinit var binding: FragmentDetailsBinding
    val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.articleData
        binding = FragmentDetailsBinding.bind(view)
        binding.webview.apply {
            webChromeClient = WebChromeClient()
            article?.let { data: Article ->
                loadUrl(data.url!!)
            }
        }

        binding.fab.setOnClickListener {
            if (article != null) {
                viewModel.insertArticle(article)
            }
            Snackbar.make(binding.root, "Your text has been saved ", Snackbar.LENGTH_LONG).show()
        }
    }
}