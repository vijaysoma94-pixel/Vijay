package com.example.incomeexpense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddIncomeActivity extends AppCompatActivity {

    EditText edtAmount;
    Button btnSave;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);

        edtAmount = findViewById(R.id.edtIncomeAmount);
        btnSave = findViewById(R.id.btnSaveIncome);

        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amountStr = edtAmount.getText().toString().trim();

                if (amountStr.isEmpty()) {
                    Toast.makeText(AddIncomeActivity.this,
                            "Please enter income amount",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int amount = Integer.parseInt(amountStr);
                    db.addRecord("income", amount);

                    Toast.makeText(AddIncomeActivity.this,
                            "Income Added Successfully",
                            Toast.LENGTH_SHORT).show();

                    edtAmount.setText("");
                }
            }
        });
    }
}
