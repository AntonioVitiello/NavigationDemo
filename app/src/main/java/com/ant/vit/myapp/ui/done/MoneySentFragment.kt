package com.ant.vit.myapp.ui.done

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ant.vit.myapp.R
import kotlinx.android.synthetic.main.fragment_money_sent.*

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class MoneySentFragment : Fragment() {

    private lateinit var moneySentViewModel: MoneySentViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_money_sent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ext: findNavController()
        navController = Navigation.findNavController(view)
        moneySentViewModel = ViewModelProviders.of(this).get(MoneySentViewModel::class.java)
        moneySentViewModel.text.observe(this, Observer { topText.text = it })

        initComponents(view)
    }

    private fun initComponents(rootView: View) {
        executeBtn.setOnClickListener { navController.navigate(R.id.action_nav_money_sent_to_home) }

        //Back management
        requireActivity().onBackPressedDispatcher.addCallback(
            this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    navController.popBackStack(R.id.nav_home, false)
                }
            })

        //NavigateUp management
//        navController.addOnDestinationChangedListener { navController, destination, arguments ->
//            if (navController.currentDestination!!.id != R.id.nav_sending_money && destination.id == R.id.nav_sending_money) {
//                navController.popBackStack(R.id.nav_home, false)
//            }
//        }
    }

}