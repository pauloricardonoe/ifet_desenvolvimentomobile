package com.example.atividade1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.snackbar.Snackbar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity{

  public static final int RETORNO_CAD_PHOTO = 1;
  private Button BtConsultar, BtIncluir;
  private PhotosAdapter photosAdapter;
  private ListView ListPhotos;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    InicializarComponentes();
    Eventos();
  }

  private void InicializarComponentes(){
    ListPhotos = findViewById(R.id.listaFotos);
    this.photosAdapter = new PhotosAdapter(this, R.layout.item_photo);
    ListPhotos.setAdapter(this.photosAdapter);

    BtConsultar = findViewById(R.id.BotaoBuscar);
    BtIncluir = findViewById(R.id.BotaoIncluir);
  }

  private void Eventos(){

    BtConsultar.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {

        AsyncTask<Void, Integer, String> task = new AsyncTask<Void, Integer, String>() {

          private List<Photo> photoList;
          private ProgressDialog progressBar;

          @Override
          protected void onPreExecute() {

            photoList = new ArrayList<>();

            progressBar = new ProgressDialog(MainActivity.this);
            progressBar.setCancelable(false);
            progressBar.setTitle("Progresso");
            progressBar.setMessage("Carregando Itens ...");
            progressBar.show();
          }

          @Override
          protected String doInBackground(Void... params) {
            try {
              RestTemplate restTemplate = new RestTemplate();
              restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
              restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
              ResponseEntity<Photo[]> entity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/photos", Photo[].class);

              if(entity.getStatusCode() == HttpStatus.OK){
                for(int i = 0; i < 10; i++){
                  photoList.add(entity.getBody()[i]);
                }
              }
            } catch (Exception e) {
              e.printStackTrace();
              return e.getMessage();
            }

            return "";
          }

          protected void onPostExecute(final String error) {
            progressBar.dismiss();

            if (TextUtils.isEmpty(error)) {
              MainActivity.this.photosAdapter.addAll(photoList);
            } else Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
          }

        };

        task.execute();
      }
    });

    BtIncluir.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        Intent intent = new Intent(MainActivity.this, CadPhoto.class);
        startActivityForResult(intent, RETORNO_CAD_PHOTO);
      }
    });

    this.ListPhotos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
      @Override
      public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
        Photo item = photosAdapter.getItem(position);
        photosAdapter.remove(item);
        return true;
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(data == null) return;

    if (requestCode == RETORNO_CAD_PHOTO) {
      String      photo       = data.getStringExtra("photo");
      ObjectMapper objectMapper = new ObjectMapper();
      Photo photo1;
      try{
        photo1 = objectMapper.readValue(photo, Photo.class);
        this.photosAdapter.add(photo1);
      }catch(IOException e){
        e.printStackTrace();
      }
    }
    super.onActivityResult(requestCode, resultCode, data);
  }

}