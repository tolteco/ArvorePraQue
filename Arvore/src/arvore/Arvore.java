/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Maycon
 */
public class Arvore {

  static BufferedWriter wfavl;
  static BufferedWriter wfbin;
  static String namefile;
  static int[] V = {100, 200, 500, 1000, 2000, 5000, 7500, 10000, 15000, 30000, 50000, 70000, 75000, 100000, 200000, 500000, 750000, 1000000, 1250000, 1500000, 2000000, 5000000, 7500000, 10000000};
  static ArrayList<Integer> FT;
  static long startTime;
  static long endTime;
  static File favl;
  static File fbin;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws FileNotFoundException, IOException {
    int i;
    Binaria b;
    AVL a;
    favl = new File("favl.txt");
    wfavl = new BufferedWriter(new FileWriter(favl, true));
    fbin = new File("fbin.txt");
    wfbin = new BufferedWriter(new FileWriter(fbin, true));
    
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    wfavl.write(dateFormat.format(date) + "\n");
    wfbin.write(dateFormat.format(date) + "\n");
    
    for (i = 0; i < 24; i++) {
      b = new Binaria();
      a = new AVL();
      System.out.println("Teste para " + V[i]);
      /////////////////////////////////////////////Aleatorio
      FT = new ArrayList<Integer>();
      namefile = "a" + V[i] + ".txt";
      BufferedReader reader = new BufferedReader(new FileReader(namefile));
      String L;
      int Ch;
      while ((L = reader.readLine()) != null) {
        Ch = Integer.parseInt(L);
        FT.add(Ch);
      }
      reader.close();
      //Insercao na Binaria
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        b.insere(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfbin.write("I " + namefile + " "  + endTime + " " + b.COUNTIF + "\n");
      b.COUNTIF = 0;
      //Insercao na AVL
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        a.insere(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfavl.write("I " + namefile + " "  + endTime + " " + a.COUNTIF + "\n");
      a.COUNTIF = 0;
      //Busca
      FT = new ArrayList<Integer>();
      namefile = "b" + V[i] + ".txt";
      reader = new BufferedReader(new FileReader(namefile));
      while ((L = reader.readLine()) != null) {
        Ch = Integer.parseInt(L);
        FT.add(Ch);
      }
      reader.close();
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        b.consulta(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfbin.write("C " + namefile + " "  + endTime + " " + b.COUNTIF + "\n");
      b.COUNTIF = 0;
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        a.consulta(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfavl.write("C " + namefile + " "  + endTime + " " + a.COUNTIF + "\n");
      a.COUNTIF = 0;

      /////////////////////////////////////////////Ordenado
      b = new Binaria();
      a = new AVL();
      FT = new ArrayList<Integer>();
      namefile = "o" + V[i] + ".txt";
      reader = new BufferedReader(new FileReader(namefile));
      while ((L = reader.readLine()) != null) {
        Ch = Integer.parseInt(L);
        FT.add(Ch);
      }
      reader.close();
      //Insercao na Binaria
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        b.insere(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfbin.write("I " + namefile + " "  + endTime + " " + b.COUNTIF + "\n");
      b.COUNTIF = 0;
      //Insercao na AVL
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        a.insere(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfavl.write("I " + namefile + " "  + endTime + " " + a.COUNTIF + "\n");
      a.COUNTIF = 0;
      //Busca
      FT = new ArrayList<Integer>();
      namefile = "b" + V[i] + ".txt";
      reader = new BufferedReader(new FileReader(namefile));
      while ((L = reader.readLine()) != null) {
        Ch = Integer.parseInt(L);
        FT.add(Ch);
      }
      reader.close();
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        b.consulta(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfbin.write("C " + namefile + " "  + endTime + " " + b.COUNTIF + "\n");
      b.COUNTIF = 0;
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        a.consulta(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfavl.write("C " + namefile + " "  + endTime + " " + a.COUNTIF + "\n");
      a.COUNTIF = 0;

      /////////////////////////////////////////////Parcialmente Ordenado
      b = new Binaria();
      a = new AVL();
      FT = new ArrayList<Integer>();
      namefile = "p" + V[i] + ".txt";
      reader = new BufferedReader(new FileReader(namefile));
      while ((L = reader.readLine()) != null) {
        Ch = Integer.parseInt(L);
        FT.add(Ch);
      }
      reader.close();
      //Insercao na Binaria
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        b.insere(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfbin.write("I " + namefile + " "  + endTime + " " + b.COUNTIF + "\n");
      b.COUNTIF = 0;
      //Insercao na AVL
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        a.insere(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfavl.write("I " + namefile + " "  + endTime + " " + a.COUNTIF + "\n");
      a.COUNTIF = 0;
      //Busca
      FT = new ArrayList<Integer>();
      namefile = "b" + V[i] + ".txt";
      reader = new BufferedReader(new FileReader(namefile));
      while ((L = reader.readLine()) != null) {
        Ch = Integer.parseInt(L);
        FT.add(Ch);
      }
      reader.close();
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        b.consulta(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfbin.write("C " + namefile + " "  + endTime + " " + b.COUNTIF + "\n");
      b.COUNTIF = 0;
      startTime = System.currentTimeMillis();
      for (Integer j : FT) {
        a.consulta(j);
      }
      endTime = System.currentTimeMillis() - startTime;
      wfavl.write("C " + namefile + " "  + endTime + " " + a.COUNTIF + "\n");
      a.COUNTIF = 0;
    }
    wfavl.close();
    wfbin.close();
  }
}
