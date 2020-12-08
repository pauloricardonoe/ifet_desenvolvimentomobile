package com.example.atividade1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import java.util.Objects;

public class CadPhoto extends AppCompatActivity{

  private EditText EdtAlbumId;
  private EditText EdtId;
  private EditText EdtThumb;
  private EditText EdtUrl;
  private View     fab;
  private EditText EdtTitulo;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cad_photo);

    InicializarComponentes();

    Eventos();
  }

  private void Eventos(){
    fab.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View view){
        Photo photo = new Photo();
        if(EdtId.getText().toString().length() > 0)
          photo.id = Integer.parseInt(EdtId.getText().toString());

        if(EdtTitulo.getText().toString().length() > 0)
          photo.title = EdtTitulo.getText().toString();

        if(EdtId.getText().toString().length() > 0)
          photo.id = Integer.parseInt(EdtId.getText().toString());

        if(EdtAlbumId.getText().toString().length() > 0)
          photo.albumId = Integer.parseInt(EdtAlbumId.getText().toString());

        if(EdtThumb.getText().toString().length() > 0)
          photo.thumbnailUrl = EdtThumb.getText().toString();

        if(EdtUrl.getText().toString().length() > 0)
          photo.url = EdtUrl.getText().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        String       jsonPhoto    = null;
        try{
          jsonPhoto = objectMapper.writeValueAsString(photo);
          Intent it = new Intent();
          it.putExtra("photo", jsonPhoto);
          setResult(1, it);
          finish();
        }catch(JsonProcessingException e){
          e.printStackTrace();
          Snackbar.make(view, Objects.requireNonNull(e.getMessage()), Snackbar.LENGTH_LONG).show();
        }
      }
    });
  }

  private void InicializarComponentes(){
    EdtAlbumId = findViewById(R.id.Edtalbum_id);
    EdtTitulo = findViewById(R.id.EdtTitulo);
    EdtId = findViewById(R.id.Edtid);
    EdtThumb = findViewById(R.id.Edtthumbnail_url);
    EdtUrl = findViewById(R.id.Edturl);

    fab = findViewById(R.id.fab);
  }
}