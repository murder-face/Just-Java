package com.example.gorunov.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int oneCupPrice = 5;
    String name = "Evgeniy";


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
        displayMessage(createOrderSummary(price, name));

    }

    private String createOrderSummary (int price, String name) {

        String message = "Name: " + name + "\nQuantity: " + quantity + "\nTotal: " + price + " $" + "\nThank you!";
        return message;
    }

    private int calculatePrice(int quantity) {
        quantity = quantity * oneCupPrice;
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
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    private void displayIncrement(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.QUA);
        quantityTextView.setText("" + number);
    }

    private void displayDecrement(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.QUA);
        quantityTextView.setText("" + number);
    }


}