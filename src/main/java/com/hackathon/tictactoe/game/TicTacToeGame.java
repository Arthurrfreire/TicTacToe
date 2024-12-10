package com.hackathon.tictactoe.game;

import java.util.Random;
import java.util.Scanner;

import com.hackathon.tictactoe.ui.ConsoleUI;

import net.jorgedev.ConsoleClear;

public class TicTacToeGame {

   public static int[] converterJogadaStringParaVetorInt(String jogada) {
      int[] vetorJogada = new int[2];
      vetorJogada[0] = Character.getNumericValue(jogada.charAt(0));
      vetorJogada[1] = Character.getNumericValue(jogada.charAt(1));
      return vetorJogada;
   }

   public static void exibirEmpate() {
      System.out.println("Ocorreu um empate!");

      System.out.println(" _______       _______ ");
      System.out.println("|       |     |       |");
      System.out.println("|   0   |  x  |   0   |");
      System.out.println("|_______|     |_______|");
   }

   public static char[][] inicializarTabuleiro(char[][] tabuleiro) {
      for (int i = 0; i < tabuleiro.length; i++) {
         for (int j = 0; j < tabuleiro[i].length; j++) {
            tabuleiro[i][j] = ' ';
         }
      }
      return tabuleiro;
   }

   public static void exibirTabuleiro() {
      Scanner teste = new Scanner(System.in);

      ConsoleClear.run();
      char[][] tabuleiro = new char[3][3];
      inicializarTabuleiro(tabuleiro);

      System.out.println(ConsoleUI.Logo());
      for (char[] linha : tabuleiro) {
         for (char celula : linha) {
            System.out.print("[" + celula + "]");
         }
         System.out.println();
      }
      teste.nextLine();
      teste.close();
   }

   public static String retornarPosicoesLivres(char[][] tabuleiro) {
      StringBuilder posicoesLivres = new StringBuilder();

      for (int i = 0; i < tabuleiro.length; i++) {
         for (int j = 0; j < tabuleiro[i].length; j++) {
            if (tabuleiro[i][j] == ' ') {
               posicoesLivres.append(i).append(j).append(";");
            }
         }
      }

      if (posicoesLivres.length() > 0) {
         posicoesLivres.setLength(posicoesLivres.length() - 1);
      }

      return posicoesLivres.toString();
   }

   public static boolean teveGanhador(char[][] tabuleiro, char caractereJogador) {
      return teveGanhadorLinha(tabuleiro, caractereJogador) ||
            teveGanhadorColuna(tabuleiro, caractereJogador) ||
            teveGanhadorDiagonalPrincipal(tabuleiro, caractereJogador) ||
            teveGanhadorDiagonalSecundaria(tabuleiro, caractereJogador);
   }

   public static boolean teveGanhadorLinha(char[][] tabuleiro, char caractereJogador) {
      for (int i = 0; i < tabuleiro.length; i++) {
         boolean venceu = true;
         for (int j = 0; j < tabuleiro[i].length; j++) {
            if (tabuleiro[i][j] != caractereJogador) {
               venceu = false;
               break;
            }
         }
         if (venceu)
            return true;
      }
      return false;
   }

   public static boolean teveGanhadorColuna(char[][] tabuleiro, char caractereJogador) {
      for (int j = 0; j < tabuleiro[0].length; j++) {
         boolean venceu = true;
         for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][j] != caractereJogador) {
               venceu = false;
               break;
            }
         }
         if (venceu)
            return true;
      }
      return false;
   }

   public static boolean teveGanhadorDiagonalPrincipal(char[][] tabuleiro, char caractereJogador) {
      for (int i = 0; i < tabuleiro.length; i++) {
         if (tabuleiro[i][i] != caractereJogador) {
            return false;
         }
      }
      return true;
   }

   public static boolean teveGanhadorDiagonalSecundaria(char[][] tabuleiro, char caractereJogador) {
      int n = tabuleiro.length;
      for (int i = 0; i < n; i++) {
         if (tabuleiro[i][n - 1 - i] != caractereJogador) {
            return false;
         }
      }
      return true;
   }

   public static int[] obterJogadaComputador(String posicoesLivres, Scanner teclado) {
      String[] jogadasLivres = posicoesLivres.split(";");

      Random random = new Random();
      int indiceSorteado = random.nextInt(jogadasLivres.length);

      String jogadaSorteada = jogadasLivres[indiceSorteado];

      return converterJogadaStringParaVetorInt(jogadaSorteada);
   }

   static boolean teveEmapte(char[][] tabuleiro) {
      for (int i = 0; i < tabuleiro.length; i++){
         for (int j  = 0; j < tabuleiro[i].length; j++){

            if (tabuleiro[i][j] == ' ') {
               return false;

            }
         }
      }
      return true;
   }
}

