package br.edu.ifsudestemg.avaliacao1.Num5;

public class HashP{

  private String[] valores;
  private int tamanho;

  public HashP(int tamanho){
    this.tamanho = tamanho;

    this.valores = new String[tamanho];
  }

  private int hash(String key){
    return (key.hashCode() & 0x7fffffff) % tamanho;
  }

  public void put(String key, String value){
    int posicao = hash(key);
    valores[posicao] = value;
  }

  public String get(String key){
    return valores[hash(key)];
  }

  public boolean remove(String key){
    valores[hash(key)] = null;
    return true;
  }

  public boolean containsKey(String key){
    return valores[hash(key)] != null;
  }

  public int size(){
    int qtd = 0;
    for(String valor : valores){
      if(valor != null) qtd++;
    }

    return qtd;
  }
}
