package com.example.petrolcalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerPetrolType;
    EditText etPrice, etUsage;
    RadioGroup rgBudi;
    RadioButton rbYes, rbNo;
    Button btnCalculate, btnReset;
    LinearLayout layoutResults;
    TextView tvTotalCost, tvBudiRebate, tvTotalSaving, tvFinalPayable;
    LinearLayout rowRebate, rowSaving, rowFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Smart Petrol Calculator");

        spinnerPetrolType = findViewById(R.id.spinnerPetrolType);
        etPrice = findViewById(R.id.etPrice);
        etUsage = findViewById(R.id.etUsage);
        rgBudi = findViewById(R.id.rgBudi);
        rbYes = findViewById(R.id.rbYes);
        rbNo = findViewById(R.id.rbNo);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);
        layoutResults = findViewById(R.id.layoutResults);
        tvTotalCost = findViewById(R.id.tvTotalCost);
        tvBudiRebate = findViewById(R.id.tvBudiRebate);
        tvTotalSaving = findViewById(R.id.tvTotalSaving);
        tvFinalPayable = findViewById(R.id.tvFinalPayable);
        rowRebate = findViewById(R.id.rowRebate);
        rowSaving = findViewById(R.id.rowSaving);
        rowFinal = findViewById(R.id.rowFinal);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.petrol_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPetrolType.setAdapter(adapter);

        rbNo.setChecked(true);

        btnCalculate.setOnClickListener(v -> calculate());
        btnReset.setOnClickListener(v -> reset());
    }

    void calculate() {
        String priceStr = etPrice.getText().toString().trim();
        String usageStr = etUsage.getText().toString().trim();

        if (priceStr.isEmpty()) { etPrice.setError("Enter price"); return; }
        if (usageStr.isEmpty()) { etUsage.setError("Enter usage"); return; }

        double price = Double.parseDouble(priceStr);
        double usage = Double.parseDouble(usageStr);

        if (price <= 0) { etPrice.setError("Must be > 0"); return; }
        if (usage <= 0) { etUsage.setError("Must be > 0"); return; }

        String petrolType = spinnerPetrolType.getSelectedItem().toString();
        boolean budiEligible = rbYes.isChecked();
        boolean isRon95 = petrolType.equals("RON95");

        double totalCost = usage * price;
        double budiRebate = 0, totalSaving = 0, finalPayable = totalCost;

        if (budiEligible && isRon95) {
            budiRebate = usage * 1.99;
            totalSaving = totalCost - budiRebate;
            finalPayable = totalSaving;
            rowRebate.setVisibility(View.VISIBLE);
            rowSaving.setVisibility(View.VISIBLE);
            tvBudiRebate.setText(String.format("RM %.2f", budiRebate));
            tvTotalSaving.setText(String.format("RM %.2f", totalSaving));
        } else {
            rowRebate.setVisibility(View.GONE);
            rowSaving.setVisibility(View.GONE);
            if (budiEligible) {
                Toast.makeText(this, "BUDI MADANI rebate applies to RON95 only", Toast.LENGTH_LONG).show();
            }
        }

        tvTotalCost.setText(String.format("RM %.2f", totalCost));
        tvFinalPayable.setText(String.format("RM %.2f", finalPayable));
        rowFinal.setVisibility(View.VISIBLE);
        layoutResults.setVisibility(View.VISIBLE);
    }

    void reset() {
        spinnerPetrolType.setSelection(0);
        etPrice.setText("");
        etUsage.setText("");
        rbNo.setChecked(true);
        layoutResults.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_home) {
            reset(); return true;
        } else if (item.getItemId() == R.id.menu_about) {
            startActivity(new Intent(this, AboutActivity.class)); return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
