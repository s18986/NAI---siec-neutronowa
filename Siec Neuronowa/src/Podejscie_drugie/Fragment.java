package Podejscie_drugie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class Fragment {
    File file;
    String Prawidlowy;
    Vector<Double> wektor_wejsciowy = new Vector<>();

    Fragment(String nazwa, File file) {
        this.file = file;
        this.Prawidlowy = nazwa;
        inicjujWektor(wektor_wejsciowy);
        zliczWektor();
    }

    public String toString() {
        return Prawidlowy + "     " + file.getName() + " Wektor wejsciowy: " + wektor_wejsciowy.toString();
    }

    public void inicjujWektor(Vector<Double> wektor) {
        for (int i = 0; i < 26; i++) {
            wektor.add(0.0);
        }
    }

    public void inicjujWektorIntami(Vector<Integer> wektor) {
        for (int i = 0; i < 26; i++) {
            wektor.add(0);
        }
    }

    public void zliczWektor() {
        int liczba_znakow_w_tekscie = 0;
        Vector<Integer> temp = new Vector<>();
        inicjujWektorIntami(temp);
        File file = this.file;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int c;
            while ((c = fileInputStream.read()) != -1) {

                if (c < 90 && c != 32) {
                    temp.set(c - 65, temp.get(c - 65) + 1);
                    liczba_znakow_w_tekscie++;
                } else if (c > 90) {
                    temp.set(c - 97, temp.get(c - 97) + 1);
                    liczba_znakow_w_tekscie++;
                }
            }
            for(int i=0;i<26;i++)
            {
                Double temp2 = Double.valueOf(temp.get(i));
                wektor_wejsciowy.set(i,temp2/liczba_znakow_w_tekscie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void nauczaj(Język język)
    {
        Double net;
        int przewidywana;
        boolean prawda =this.Prawidlowy.equals(język.NAZWA_JEZYKA);
        int y_oczekiwana;
        int y;
        if(prawda==true)
        {
            y_oczekiwana=1;
        }else
        {
            y_oczekiwana=0;
        }
        System.out.println(y_oczekiwana+ " "+język.NAZWA_JEZYKA);
        net=obliczNet(język.WEKTOR_JEZYKA,this.wektor_wejsciowy,język.PROG_T);
        //System.out.println(język.WEKTOR_JEZYKA);
        if(net<0)
        {
            y=1;
        }else
        {
            y=0;
        }
        if(y!=y_oczekiwana)
        {
            przewidywana=y_oczekiwana-y;
            język.WEKTOR_JEZYKA=naukaPerceptonu(język.WEKTOR_JEZYKA,wektor_wejsciowy,język.PROG_T,przewidywana);
            język.PROG_T=obliczNoweT(język.PROG_T,przewidywana);
            System.out.println("przeprowadzono uczenie");
        }

    }
    public Double obliczNet(Vector<Double> wektor_wag, Vector<Double> wejsciowy, Double T)
    {
        Double net =0.0;
        for(int i=0;i<26;i++)
        {
            net=net+(wejsciowy.get(i)*wektor_wag.get(i));
        }
        net=net-T;
        //System.out.println(net);
        return net;
    }
    public Vector<Double> naukaPerceptonu(Vector<Double> wektor_wag, Vector<Double> wejsciowy, Double T, int zmianna)
    {
        Vector<Double> nowy_wektor = new Vector<>();
        for(int i=0;i<26;i++)
        {
            nowy_wektor.add(wektor_wag.get(i)+wejsciowy.get(i)*Algorytm.ALPHA*zmianna);
        }
        return nowy_wektor;
    }
    public Double obliczNoweT(Double T, int zmienna)
    {
        Double zwracana;
        zwracana=T+zmienna*Algorytm.ALPHA*(-1);
        return zwracana;
    }
}
