package com.ant.vit.myapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ant.vit.myapp.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.text.observe(this, Observer { topText.text = it })

        initComponents(view)
    }

    private fun initComponents(rootView: View) {
        navGallery.setOnClickListener{ navController.navigate(R.id.action_nav_home_to_gallery) }
        navSlideshow.setOnClickListener{ navController.navigate(R.id.action_nav_home_to_slideshow) }
        navSendMoney.setOnClickListener{ navController.navigate(R.id.action_nav_home_to_money_send) }
    }

}