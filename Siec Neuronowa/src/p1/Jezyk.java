package p1;

import javafx.scene.web.WebEngine;
import sun.dc.pr.PRError;

import java.beans.VetoableChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Jezyk {
    String nazwa;
    Vector<Double> wektor_wag = new Vector<>();
    ArrayList<File> pliki_zrodlowe = new ArrayList<>();
    double Prog_T;
    Jezyk()
    {
        inicjujParametry(wektor_wag);
    }
    Jezyk(String nazwa)
    {
        inicjujParametry(wektor_wag);
        this.nazwa=nazwa;
        System.out.println("Dodano język jakim jest: "+this.nazwa);
    }
    public void inicjujParametry(Vector<Double> wektor_wag)
    {
        for(int i=0;i<26;i++)
        {
            wektor_wag.add((Math.random()*6)-3);
        }
        Prog_T=(Math.random()*6)-3;
    }
    public void ucz(File file)
    {
        pliki_zrodlowe.add(file);
        System.out.println("Rozpoczeto nauczanie za pomoca pliku "+file.getName()+" jezyka znanego jako "+this.nazwa);
        setNewWektor_wag(utworzWektorwejsciowy(file), file);
        pokazWektor(wektor_wag);
    }
    public Vector<Double> utworzWektorwejsciowy(File file) {
        int liczba_znakow_w_tekscie=0;
        Vector<Double> wektor_Wejsciowy = inicjujWektorZerami();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int c;
            while ((c = fileInputStream.read()) != -1) {

                if (c < 90 && c != 32) {
                    wektor_Wejsciowy.set(c - 65, wektor_Wejsciowy.get(c - 65) + 1);
                    liczba_znakow_w_tekscie++;
                    System.out.println("XD");
                } else if (c > 90) {
                    wektor_Wejsciowy.set(c - 97, wektor_Wejsciowy.get(c - 97) + 1);
                    liczba_znakow_w_tekscie++;
                }
            }
            for(int i=0;i<26;i++)
            {
                Double temp2 = Double.valueOf(wektor_Wejsciowy.get(i));
                wektor_Wejsciowy.set(i, (double) (temp2/liczba_znakow_w_tekscie));
                //System.out.println((char)(i+65)+" "+wektor_Wejsciowy.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(liczba_znakow_w_tekscie);
        return wektor_Wejsciowy;
    }
    public Vector<Double> inicjujWektorZerami()
    {
        Vector<Double> Wektor = new Vector<>();
        for(int i=0;i<26;i++)
        {
            Wektor.add(0.0);
        }
        return Wektor;
    }
    public void pokazWektor( Vector wektor)
    {
        for(int i=0;i<wektor.size();i++)
        {
            System.out.print(wektor.get(i).toString().substring(0,5)+" ");;
        }
        System.out.println();
    }
    public void setNewWektor_wag(Vector<Double> wejsciowy, File file)
    {
        int expected;
        System.out.println(file.getName().toString().substring(0,1));
        Vector<Double> nowy = new Vector<>();
        double net=obliczNet(wejsciowy);
        int y=0;
        if(net<0)
        {
            for(int i=0;i<26;i++)
            {
                nowy.add(wektor_wag.get(i)+Main.ALPHA*wejsciowy.get(i));
            }
            Prog_T= Prog_T+Main.ALPHA*(-1);
            System.out.println("Zaktualizowano wektor wag");
            wektor_wag=nowy;
        }
    }
    public double obliczNet(Vector<Double> wejsciowy)
    {
        double net=0;
        for(int i=0;i<wejsciowy.size();i++)
        {
           net=net+wejsciowy.get(i)*wektor_wag.get(i);
        }
        net=net-Prog_T;
        System.out.println("Parametr Net: "+net);
        return net;
    }
}
