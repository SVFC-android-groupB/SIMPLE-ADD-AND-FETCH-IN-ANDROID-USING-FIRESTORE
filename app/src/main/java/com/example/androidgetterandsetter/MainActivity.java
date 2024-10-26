package com.example.androidgetterandsetter;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    EditText id, name, category, price;
    Button add, getList;
    TextView list;

    List<Product> productList = new ArrayList<>();
    Product productObject;

    StringBuilder stringBuilder;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        stringBuilder = new StringBuilder();
        productObject = new Product();
        firestore = FirebaseFirestore.getInstance();

        id = findViewById(R.id.et_productId);
        name = findViewById(R.id.et_productName);
        category = findViewById(R.id.et_productCategory);
        price = findViewById(R.id.et_productPrice);
        add = findViewById(R.id.btn_Add);
        getList = findViewById(R.id.btn_GetProduct);
        list = findViewById(R.id.tv_ProductList);

        //btn add function when clicked
        add.setOnClickListener(v ->toAdd());


        //btn get list function
        getList.setOnClickListener(v ->getList());
    }

    //add function
    public void toAdd(){
        productObject.setId(Integer.parseInt(id.getText().toString()));
        productObject.setName(name.getText().toString());
        productObject.setCategory(category.getText().toString());
        productObject.setPrize(Integer.parseInt(price.getText().toString()));

        firestore.collection("Product").add(productObject).addOnSuccessListener(document -> {
            stringBuilder.append("\n\n Name: " + productObject.getName());
            stringBuilder.append("\n Id: " + productObject.getId());
            stringBuilder.append("\n Category: " + productObject.getCategory());
            stringBuilder.append("\n Price: " + productObject.getPrize());

            list.setText(stringBuilder.toString());
        }).addOnFailureListener(e->{
            Log.e("MAIN", e.getMessage());
        });
    }

    //getList function
    private void getList(){

    }
}