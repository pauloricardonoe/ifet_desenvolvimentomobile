package com.example.atividade1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class PhotosAdapter extends ArrayAdapter<Photo>{

  public PhotosAdapter(@NonNull Context context, int resource){
    super(context, resource);
  }

  @Override
  public View getView(int position, View view, ViewGroup parent){
    if(view == null){
      view = LayoutInflater.from(this.getContext()).inflate(R.layout.item_photo, null);
    }

    TextView tvtitle = view.findViewById(R.id.tvTitulo);
    tvtitle.setText(String.valueOf(this.getItem(position).title));

    TextView tvurl = view.findViewById(R.id.tvURL);
    tvurl.setText(String.valueOf(this.getItem(position).url));
    return view;
  }
}
