package com.example.incomeexpense;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView incomeTxt, expenseTxt, balanceTxt;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeTxt = findViewById(R.id.totalIncome);
        expenseTxt = findViewById(R.id.totalExpense);
        balanceTxt = findViewById(R.id.balance);

        db = new DatabaseHelper(this);

        int income = db.getTotalIncome();
        int expense = db.getTotalExpense();

        incomeTxt.setText("Income: ₹" + income);
        expenseTxt.setText("Expense: ₹" + expense);
        balanceTxt.setText("Balance: ₹" + (income - expense));
    }
}
