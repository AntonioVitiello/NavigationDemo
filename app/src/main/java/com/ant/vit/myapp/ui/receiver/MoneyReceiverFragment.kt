package com.ant.vit.myapp.ui.receiver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ant.vit.myapp.R
import kotlinx.android.synthetic.main.fragment_money_receiver.*

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class MoneyReceiverFragment : Fragment() {

    private lateinit var moneyReceiverViewModel: MoneyReceiverViewModel
    private lateinit var navController: NavController

    companion object {
        val RECIPIENT_NAME = "recipient_name"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_money_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        moneyReceiverViewModel = ViewModelProviders.of(this).get(MoneyReceiverViewModel::class.java)
        moneyReceiverViewModel.text.observe(this, Observer { topText.text = it })

        initComponents(view)
    }

    private fun initComponents(rootView: View) {
        nextBtn.setOnClickListener { navigateToNextView() }
        cancelBtn.setOnClickListener { navController.navigateUp() }
    }

    private fun navigateToNextView() {
        if (!recipientName.text.isNullOrEmpty()) {
            val args = bundleOf(RECIPIENT_NAME to recipientName.text.toString())
            navController.navigate(R.id.action_nav_receiver_to_amount, args)
        }
    }

}