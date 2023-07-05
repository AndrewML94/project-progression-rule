package com.trybe.java.regraprogressao;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraAprovacao {

  /** 
   * Method.
  */

  public static void atividadesCadastro() {
    Scanner scanner = new Scanner(System.in);
  
    System.out.println("Digite a quantidade de atividades para cadastrar:");
    byte totalAtividades = scanner.nextByte();
    scanner.nextLine();
    insercaoNotas(scanner, totalAtividades);

    scanner.close();
  }

  /** 
   * Method.
  */

  public static void insercaoNotas(Scanner scanner, byte totalAtividades) {
    byte comparador = 1;
    ArrayList<String> notas = new ArrayList<String>();
    ArrayList<String> pesos = new ArrayList<String>();

    do {
      System.out.println("Digite o nome da atividade " + comparador + ":");
      String atividade = scanner.nextLine();

      System.out.println("Digite o peso da atividade " + comparador + ":");
      pesos.add(scanner.nextLine());

      System.out.println("Digite a nota obtida para " + atividade + ":");
      notas.add(scanner.nextLine());

      comparador++;

    } while (comparador <= totalAtividades);

    calculadoraNotas(notas, pesos);
  }

  /** 
   * Method.
  */

  public static void calculadoraNotas(ArrayList<String> notas, ArrayList<String> pesos) {
    double notaFinal = 0;
    double notasConv = 0;
    double pesosConv = 0;
    double totalPesos = 0;
    double mult = 0;

    for (short i = 0; i < notas.size(); i++) {
      notasConv = Double.parseDouble(notas.get(i));
      pesosConv = Double.parseDouble(pesos.get(i));
      totalPesos += pesosConv;
      mult += notasConv * pesosConv;
    }

    notaFinal = mult / totalPesos;

    if (notaFinal >= 85.0) {
      System.out.println("Parabéns! Você alcançou "
          + 
          notaFinal
          +
          "%! E temos o prazer de informar que você obteve aprovação!"
      );
    } else {
      System.out.println(
          "Lamentamos informar que, com base na sua pontuação alcançada neste período, "
          +
          notaFinal
          +
          "%, você não atingiu a pontuação mínima necessária para sua aprovação."
      );
    }
  }
}
