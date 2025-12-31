package com.example.incomeexpense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddExpenseActivity extends AppCompatActivity {

    EditText edtAmount;
    Button btnSave;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        edtAmount = findViewById(R.id.edtExpenseAmount);
        btnSave = findViewById(R.id.btnSaveExpense);

        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amountStr = edtAmount.getText().toString().trim();

                if (amountStr.isEmpty()) {
                    Toast.makeText(AddExpenseActivity.this,
                            "Please enter expense amount",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int amount = Integer.parseInt(amountStr);
                    db.addRecord("expense", amount);

                    Toast.makeText(AddExpenseActivity.this,
                            "Expense Added Successfully",
                            Toast.LENGTH_SHORT).show();

                    edtAmount.setText("");
                }
            }
        });
    }
}
