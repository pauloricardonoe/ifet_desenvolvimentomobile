package br.edu.ifsudestemg.avaliacao1.Num2;

import java.util.*;

public class Num2{

    public static void main(String[] args) throws Exception{
      Scanner scanner = new Scanner(System.in);
      List<Integer> raspadinha = new ArrayList<>();
      int valorPagar = 0;

      for(int i = 0; i <= 5; i++){
        System.out.println("Digite o valor " + String.valueOf(i+1) + " da raspadinha: ");
        int numero = scanner.nextInt();
        raspadinha.add(numero);

        int frequency = Collections.frequency(raspadinha, numero);
        if(frequency == 3) {
          valorPagar = valorPagar + numero;
        }
      }

      System.out.println("O valor a pagar é: " + String.valueOf(valorPagar));
    }
}
