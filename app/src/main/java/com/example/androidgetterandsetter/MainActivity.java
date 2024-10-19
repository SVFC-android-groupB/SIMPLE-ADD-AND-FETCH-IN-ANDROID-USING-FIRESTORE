package com.example.androidgetterandsetter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText id, name, category, price;
    Button add, getList;
    TextView list;

    List<Product> productList = new ArrayList<>();
    Product productObject;

    StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        stringBuilder = new StringBuilder();
        productObject = new Product();

        id = findViewById(R.id.et_productId);
        name = findViewById(R.id.et_productName);
        category = findViewById(R.id.et_productCategory);
        price = findViewById(R.id.et_productPrice);
        add = findViewById(R.id.btn_Add);
        getList = findViewById(R.id.btn_GetProduct);
        list = findViewById(R.id.tv_ProductList);

        //btn function when clicked
        add.setOnClickListener(v ->toAdd());
    }

    public void toAdd(){
        productObject.setId(Integer.parseInt(id.getText().toString()));
        productObject.setName(name.getText().toString());
        productObject.setCategory(category.getText().toString());
        productObject.setPrize(Integer.parseInt(price.getText().toString()));

        stringBuilder.append("\n\n Name: " + productObject.getName());
        stringBuilder.append("\n Id: " + productObject.getId());
        stringBuilder.append("\n Category: " + productObject.getCategory());
        stringBuilder.append("\n Price: " + productObject.getPrize());

        list.setText(stringBuilder.toString());
    }
}