package com.example.atividade1;

public class Photo{

  public String thumbnailUrl;
  public String url;
  public String title;
  public int    id;
  public int    albumId;


  public Photo(String thumbnailUrl, String url, String title, int id, int albumId){
    this.thumbnailUrl = thumbnailUrl;
    this.url = url;
    this.title = title;
    this.id = id;
    this.albumId = albumId;
  }

  public Photo(){
  }
}
