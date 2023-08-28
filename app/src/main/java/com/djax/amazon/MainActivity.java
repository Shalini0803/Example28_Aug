package com.djax.amazon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.djax.amazon.adapter.ProductAdapter;
import com.djax.amazon.model.Product;
import com.djax.amazon.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  ProductAdapter productAdapter ;
  RecyclerView productRecycler,productItemCycler;
  Product product;
  TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = findViewById(R.id.orderTotalTextView);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("1","Belt",230,R.drawable.belt,0));
        productList.add(new Product("2","Denim",500,R.drawable.denim,0));
        productList.add(new Product("3","Jump suit",500,R.drawable.jump,0));
        productList.add(new Product("4","shirt",330,R.drawable.maxi,0));
        productList.add(new Product("5","shoe",390,R.drawable.shoe,0));

        setProductRecycler(productList);

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("name", "");



        total.setText(s1);






    }


    public void setProductRecycler(List<Product> productList) {
        productRecycler = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        productRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productList);
        productRecycler.setAdapter(productAdapter);

    }






//   public void totalAmount(){
//
//       TextView total;
//
//       total = findViewById(R.id.orderTotalTextView);
//    int sum = 0,i;
//       List<Product> productList = new ArrayList<>();
//
//       for(i=0;i<productList.size();i++){
//
//        sum = sum+(productList.get(i).getPrice()*productList.get(i).getQnt());
//
//        total.setText(String.valueOf(sum));
//           Log.i("TAGGGGG", String.valueOf(sum));
//
//    }




   }


