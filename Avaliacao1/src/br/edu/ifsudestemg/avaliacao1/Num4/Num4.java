package br.edu.ifsudestemg.avaliacao1.Num4;

import java.util.Scanner;

public class Num4{

    public static void main(String[] args) throws Exception{
      Scanner scanner = new Scanner(System.in);

      System.out.println("Informe o tamanho da lista a ser verificada pelo Crivo de Erastónes:");
      int tamanhoarray = scanner.nextInt();

      boolean[] arrayPrimos = new boolean[tamanhoarray];

      for(int i = 1; i < arrayPrimos.length; i++){
        arrayPrimos[i] = true;
      }

      arrayPrimos[0] = false;

      for(int i = 1; i < arrayPrimos.length; i++){
        if(arrayPrimos[i]) marcarFalse(i+1, arrayPrimos);
      }

      int qtdprimos = 0;
      for(boolean arrayPrimo : arrayPrimos){
        if(arrayPrimo) qtdprimos++;
      }

      System.out.println("Números primos: " + String.valueOf(qtdprimos));

    }

    private static void marcarFalse(int numero, boolean[] array){
      for(int i = numero; i < array.length; i++){
        if(array[i]){
          if((i + 1) % numero == 0) array[i] = false;
        }
      }
    }
}
