package com.example.exerces1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            calLoan()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            reset()
        }

    }
    private fun calLoan (){
        val carPrice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toInt()
        val downPayment = findViewById<EditText>(R.id.editTextDownPayment).text.toString().toInt()
        val loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt()
        val interestRate = findViewById<EditText>(R.id.editTextInterestRate).text.toString().toDouble()

        val loan: Int
        loan =  carPrice - downPayment
        val interest = loan * interestRate * loanPeriod
        val monthlyRep = (loan + interest) / loanPeriod / 12

        textViewInterest.text = interest.toString()
        textViewLoan.text = loan.toString()
        textViewMonthlyRepayment.text = monthlyRep.toString()
    }
    private fun reset(){
        textViewMonthlyRepayment.text = null
        textViewLoan.text = null
        textViewInterest.text = null
        editTextCarPrice.text = null
        editTextDownPayment.text = null
        editTextInterestRate.text = null
        editTextLoanPeriod.text = null
    }
}
