package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Algoritm {
    String PATH;
     ArrayList<Jezyk> JEZYKI = new ArrayList<>();

    Algoritm()
    {

    }
    Algoritm(String path)
    {
        PATH=path;
    }
    /*
    public void prepareText(String Path)
    {
        try
        {
            File file = new File(Path);
            FileInputStream fileInputStream = new FileInputStream(file);
            StringBuffer stringBuffer =new StringBuffer();
            System.out.println("XD");
            int znak;
            while((znak=fileInputStream.read())!=-1)
            {
                if((znak<91 && znak>64) ||(znak>96 && znak<123) || znak==32)
                {
                    stringBuffer.append((char)znak);
                }
            }
            System.out.println("XD");
            byte bajty[] =stringBuffer.toString().getBytes();
            FileOutputStream fileOutputStream = new FileOutputStream(Path);
            fileOutputStream.write(bajty);
            fileOutputStream.close();
        }catch (IOException e)
        {
            System.out.println(e);
        }
    }
    public void addJezyk(String nazwa)
    {
        JEZYKI.add(new Jezyk(nazwa));
    }
    */
}
