package br.edu.ifet.atividade3;

public class Main{

  public static double[] numeros = {3, 5, 7, 9, 10, 12, 17};

  public static void main(String[] args){
    System.out.println("Somatório: " + SomarValores(numeros));
    System.out.println("Média Aritimetica: " + MediaAritimetica(numeros));
    System.out.println("Variancia: " + Variancia(numeros));
    System.out.println("Desvio Padrão: " + DesvioPadrao(numeros));
  }

  public static double SomarValores(double[] numeros){
    var total = 0;
    
    for(double numero : numeros) total += numero;

    return total;
  }

  public static double MediaAritimetica(double[] numeros){
    if(numeros.length == 0) return 0;
    return (SomarValores(numeros) / numeros.length);
  }

  public static double Variancia(double[] numeros){
    double tamanho = numeros.length;
    double media = MediaAritimetica(numeros);

    double quadradoDiferenca = 0;
    for(double numero : numeros) quadradoDiferenca += (numero - media) * (numero - media);

    return (quadradoDiferenca / tamanho);
  }

  public static double DesvioPadrao(double[] numeros) {
    return Math.sqrt(Variancia(numeros));
  }
}
