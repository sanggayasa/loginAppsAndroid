package com.example.login.ui.gallery
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.login.BuildConfig
import com.example.login.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        val tvCod: TextView  = root.findViewById(R.id.textvers)
        //val label = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {

            textView.text = it
            val nameApp = getString(R.string.app_name)
            tvCod.setText("version "+BuildConfig.VERSION_NAME + nameApp)




        })

        return root

    }
}


