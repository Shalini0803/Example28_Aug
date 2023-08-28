package com.djax.amazon.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.djax.amazon.R;
import com.djax.amazon.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Product> productList;
    Product product;
    TextView singleViewTotal;
    //    int sum = 0;
    int quantity;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_cart_page, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.productImage.setImageResource(productList.get(position).getProductImage());
        holder.productName.setText(productList.get(position).getProductName());
        holder.recppricen.setText(String.valueOf(productList.get(position).getPrice()));
        holder.productId.setText(productList.get(position).getProductId());
//        holder.recppricen.setText(productList.get(position).getPrice());
//        sum = Integer.parseInt(sum + productList.get(position).getPrice());
//        holder.recppricen.setText(sum);


//        for(int i=0;i< productList.size();i++)
//            sum=sum+Integer.parseInt(productList.get(i).getPrice())*productList.get(i).getQnt();

//       holder.recppricen.setText(String.valueOf(sum));
        if (quantity == 1) {
            holder.recqnt.setText(String.valueOf(quantity));
        }

        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productList.remove(position);

                notifyDataSetChanged();
            }
        });

        holder.incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                quantity++;
//                holder.recqnt.setText(String.valueOf(quantity));
//                updateprice();

                int quantity = Integer.parseInt(String.valueOf(holder.recqnt.getText()));
                quantity++;
                holder.recqnt.setText(String.valueOf(quantity));
                int totalPrice=0;


                int total_sum=0;
                for(int i=0;i<productList.size();i++) {
                    Product food_items = productList.get(i);
                    int price = food_items.getPrice();//getPrice() is a getter method in your POJO class.
                    total_sum += price;




//                for (int i = 0; i < productList.size(); i++) {
//                    if(productLis)

//                    totalPrice += productList.get(i).getPrice();
////                    total = total+productList.get(i).getPrice();
//                    Log.i("TAGGGG", String.valueOf(totalPrice));
////                    totalPrice =totalPrice+(productList.get(i).getPrice()*productList.get(i).getQnt());
////                    int sum = 0;
////                    sum = sum + productList.get(i).getPrice() * productList.get(i).getQnt();



                    SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    // write all the data entered by the user in SharedPreference and apply
                    myEdit.putString("name", String.valueOf(total_sum));

                    myEdit.apply();


// Once the changes have been made, we need to commit to apply those changes made,
// otherwise, it will throw an error
                    myEdit.commit();

//                    sum = sum + productList.get(i).getPrice() * productList.get(i).quantity;
//                     Log.i("TOTALLLLLL PRICEEE" ,String.valueOf(sum));

                    holder.singleViewTotal.setText(String.valueOf(totalPrice));
                    Log.i("TAG SUMMMMM",String.valueOf(totalPrice));

                }

            }
        });

        holder.decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int quantity= Integer.parseInt(String.valueOf(holder.recqnt.getText()));

//                if (quantity>1)
//
//                    quantity--;
//                holder.recqnt.setText(String.valueOf(quantity));

                int quantity = Integer.parseInt(String.valueOf(holder.recqnt.getText()));
                if (quantity == 1) {
                    holder.recqnt.setText("1");
                } else {
                    quantity -= 1;
                    holder.recqnt.setText(String.valueOf(quantity));
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {


        TextView recqnt, recppricen, productName, productId, singleViewTotal;
        ImageButton delbtn;
        ImageView incr, decr, productImage;


        @SuppressLint("CutPasteId")
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productId = itemView.findViewById(R.id.recid);
            productImage = itemView.findViewById(R.id.ImageView);
            productName = itemView.findViewById(R.id.productName);
            recppricen = itemView.findViewById(R.id.recpprice);
            incr = itemView.findViewById(R.id.incbtn);
            decr = itemView.findViewById(R.id.decbtn);
            recqnt = itemView.findViewById(R.id.recqnt);
            delbtn = itemView.findViewById(R.id.delbtn);
            singleViewTotal = itemView.findViewById(R.id.totalPrice);


        }
    }

//    public void updateprice()
//    {
//
//        int sum=0;
//        for(int i=0;i< productList.size();i++)
//            sum=sum+Integer.parseInt(productList.get(i).getPrice()*productList.get(i).getQnt());
//
//        singleViewTotal.setText(sum);
//    }
}
