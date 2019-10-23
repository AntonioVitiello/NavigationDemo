package com.ant.vit.myapp.ui.amount

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
import com.ant.vit.myapp.ui.receiver.MoneyReceiverFragment.Companion.RECIPIENT_NAME
import kotlinx.android.synthetic.main.fragment_money_amount.*

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class MoneyAmountFragment : Fragment() {

    private lateinit var moneyAmountModel: MoneyAmountModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_money_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        moneyAmountModel = ViewModelProviders.of(this).get(MoneyAmountModel::class.java)
        moneyAmountModel.text.observe(this, Observer { topText.text = it })

        initComponents(view)
    }

    private fun initComponents(rootView: View) {
        val recipientName = arguments!!.getString(RECIPIENT_NAME)
        recipient.setText(getString(R.string.send_to_name, recipientName))

        executeBtn.setOnClickListener { navController.navigate(R.id.action_nav_amount_to_money_send) }
        cancelBtn.setOnClickListener { navController.navigate(R.id.action_nav_money_amount_to_home) }
    }

}