package br.edu.ifsudestemg.avaliacao1.Num5;

import java.util.Scanner;

class Num5{

  public static void main(String[] args) throws Exception{
    Scanner scanner = new Scanner(System.in);

    System.out.println("Informe o tamanho da lista a ser verificada pelo Crivo de Erastónes:");
    int tamanhoarray = scanner.nextInt();

    HashP hashP = new HashP(tamanhoarray);
    hashP.put("paulo ricardo", "PAULO RICARDO GREGÓRIO NOÉ");
    hashP.put("MARCOS", "MARCOS PEIXOTO");

    String paulo = hashP.get("paulo ricardo");
    System.out.println(paulo);

    String marcos = hashP.get("MARCOS");
    System.out.println(marcos);

    System.out.println("Quantidade total: " + hashP.size());

    System.out.println(hashP.containsKey("MARCOS") ? "Contém chave MARCOS" : "Não contém chave MARCOS");

    hashP.remove("MARCOS");
    System.out.println("Quantidade após remoção: " + hashP.size());

    System.out.println(hashP.containsKey("MARCOS") ? "Contém chave MARCOS" : "Não contém chave MARCOS");
  }

}
