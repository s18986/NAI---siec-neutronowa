package Podejscie_drugie;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        File file = new File(dir.toString());
        if(!file.getName().equals("Jezyki"))
        {
           // System.out.println(file.getName());
            Main.algorytm.JEZYKI.add(new Język(file.getName()));

        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isDirectory())
        { System.out.println(file.toString());
        }else
            {
                Algorytm.prepareText(file.toString());
           // System.out.println(Main.JEZYKI.get(Main.JEZYKI.size()-1).NAZWA_JEZYKA+"   "+new File(file.toString()).getName());
                Main.algorytm.DANE.add(new Fragment(Main.algorytm.JEZYKI.get(Main.algorytm.JEZYKI.size()-1).NAZWA_JEZYKA,new File(file.toString())));
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}