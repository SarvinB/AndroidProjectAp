package com.example.mainapplication.adapter;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mainapplication.objects.CommodityObject;
import com.example.mainapplication.R;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdaptor extends RecyclerView.Adapter<ProductListAdaptor.ProductHolder> {


    List<CommodityObject> mProducts = new ArrayList<>();
    Context mContext;
    View mView;

    public void setmProducts(List<CommodityObject> products,Context context) {
        mProducts = products;
        mContext=context;
    }
    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);
        return new ProductHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductListAdaptor.ProductHolder holder, int position) {
        holder.bind(mProducts.get(position));

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        CommodityObject mProduct;
        ImageView img;
        TextView price;
        TextView title;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_product_item);
            title = itemView.findViewById(R.id.title_product_item);
            price = itemView.findViewById(R.id.price_product_item);
        }

        public void bind(CommodityObject product) {
            mProduct = product;
            //Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"+mContext.getPackageName()+"/drawable/" + mProduct.getImage());
           // Picasso.get().load(uri).resize(160,160).into(img);
            img.setImageResource(Integer.parseInt(mProduct.getImage()));
            //Picasso.with(mContext).load(mProduct.getImage()).into(img);
            //mView.imgProductItem.setImageBitmap(product.getImages().get(0).getAlt());
            title.setText(mProduct.getName());
            price.setText(String.valueOf(mProduct.getPrice()));

        }
    }
}
