package com.example.gorunov.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int oneCupPrice = 5;
    Editable name;
    boolean hasWhippedCream;
    boolean hasChocolate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        int price = calculatePrice(quantity);
        displayMessage(createOrderSummary(price));

    }

    public void chekCream (View view){
        addWhippedCream();
    }

    public void chekChocolate (View view){
        addChocolate();
    }

    private String createOrderSummary (int price) {
        tName();
        String message = "Name: " + name + "\nAdd whipped cream? " + hasWhippedCream + "\nAdd chocolate? " + hasChocolate + "\nQuantity: " + quantity + "\nTotal: " + price + " $" + "\nThank you!";
        return message;
    }

    private int calculatePrice(int quantity) {
        if (hasChocolate == false && hasWhippedCream == false) {
            quantity = quantity * oneCupPrice;
        }else if (hasChocolate == true && hasWhippedCream == false){
            quantity = quantity * (oneCupPrice + 2);
        }else if (hasChocolate == false && hasWhippedCream == true){
            quantity = quantity * (oneCupPrice + 1);
        }else quantity = quantity * (oneCupPrice + 3);
        return quantity;
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayIncrement(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            displayDecrement(quantity);
        }
    }


    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    private void displayIncrement(int number) {
        TextView quantityTextView = findViewById(R.id.QUA);
        quantityTextView.setText("" + number);
    }

    private void displayDecrement(int number) {
        TextView quantityTextView = findViewById(R.id.QUA);
        quantityTextView.setText("" + number);
    }

    private boolean addWhippedCream (){
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream);
        return hasWhippedCream = whippedCreamCheckBox.isChecked();

    }

    private boolean addChocolate (){
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate);
        return  hasChocolate = chocolateCheckBox.isChecked();
    }

    private Editable tName (){
        EditText editTextName = findViewById(R.id.text_name);
        return name = editTextName.getText();
    }


}