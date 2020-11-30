package br.edu.ifsudestemg.avaliacao1.Num3;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;

public class PalavrasCruzadas{

  private static List<String> Letras10Pontos = Arrays.asList("Q", "Z");
  private static List<String> Letras8Pontos = Arrays.asList("J", "X");
  private static List<String> Letras5Pontos = Arrays.asList("K");
  private static List<String> Letras4Pontos = Arrays.asList("F", "H", "V", "W", "Y");
  private static List<String> Letras3Pontos = Arrays.asList("B", "C", "M", "P");
  private static List<String> Letras2Pontos = Arrays.asList("D", "G");

  public static Integer getPontuacao(String palavra){
    String s = Normalizer.normalize(palavra, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();

    int pontuacao = 0;

    for(int i = 0; i < s.length(); i++){
      char caracter = s.charAt(i);
      if(Character.isLetter(caracter)){
        if(Letras10Pontos.contains(String.valueOf(caracter))) pontuacao = pontuacao + 10;
        else if(Letras8Pontos.contains(String.valueOf(caracter))) pontuacao = pontuacao + 8;
        else if(Letras5Pontos.contains(String.valueOf(caracter))) pontuacao = pontuacao + 5;
        else if(Letras4Pontos.contains(String.valueOf(caracter))) pontuacao = pontuacao + 4;
        else if(Letras3Pontos.contains(String.valueOf(caracter))) pontuacao = pontuacao + 3;
        else if(Letras2Pontos.contains(String.valueOf(caracter))) pontuacao = pontuacao + 2;
        else pontuacao = pontuacao + 1;
      }
    }

    System.out.println(s);
    return pontuacao;
  }
}
