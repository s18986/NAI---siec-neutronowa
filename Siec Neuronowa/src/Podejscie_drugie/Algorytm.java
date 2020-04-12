package Podejscie_drugie;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Algorytm {
    static double ALPHA = 0.5;
    static ArrayList<Język> JEZYKI = new ArrayList<>();
    static ArrayList<Fragment> DANE = new ArrayList<>();
    Algorytm()
    {
        File file = new File("Jezyki");
        MyVisitor filevisitor =new MyVisitor();
        try {
            Files.walkFileTree(file.toPath(),filevisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(DANE);
        for(int i=0;i<JEZYKI.size();i++)
        {
            System.out.println(JEZYKI.get(i));
        }
        for(int i=0;i<DANE.size();i++)
        {
            System.out.println(DANE.get(i));
        }
        nauczanie();

        for(int i=0;i<DANE.size();i++)
        {
            System.out.println(DANE.get(i));
        }

    }
    public static void prepareText(String Path) {
        try {
            File file = new File(Path);
            FileInputStream fileInputStream = new FileInputStream(file);
            StringBuffer stringBuffer = new StringBuffer();

            int znak;
            while ((znak = fileInputStream.read()) != -1) {
                if ((znak < 91 && znak > 64) || (znak > 96 && znak < 123) || znak == 32) {
                    stringBuffer.append((char) znak);
                }
            }
            byte bajty[] = stringBuffer.toString().getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(Path);
            fileOutputStream.write(bajty);
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void nauczanie()
    {
        for(int i=0;i<DANE.size();i++)
        {
            for(int j=0;j<JEZYKI.size();j++)
            {
                //System.out.print(i+" "+j+" ");
                DANE.get(i).nauczaj(JEZYKI.get(j));
            }
        }
    }
}
