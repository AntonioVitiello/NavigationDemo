package com.ant.vit.myapp.ui.send

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
import kotlinx.android.synthetic.main.fragment_send_money.*

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class SendingMoneyFragment : Fragment() {

    private lateinit var sendingMoneyViewModel: SendingMoneyViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_send_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        sendingMoneyViewModel = ViewModelProviders.of(this).get(SendingMoneyViewModel::class.java)
        sendingMoneyViewModel.text.observe(this, Observer { topText.text = it })

        initComponents(view)
    }

    private fun initComponents(rootView: View) {
        executeBtn.setOnClickListener{ navController.navigate(R.id.action_nav_sending_money_to_money_sent) }
        cancelBtn.setOnClickListener{ navController.navigate(R.id.action_nav_sending_money_to_home) }
    }

}