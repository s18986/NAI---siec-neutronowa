package p1;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        File file = new File(dir.toString());
        System.out.println(file.getName());
        if(!file.getName().equals("Jezyki"))
        {
           // Main.algoritm.addJezyk(file.getName());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isDirectory())
        {
            System.out.println(file.toString());
        }else {
            //System.out.println("plik tekstowy "+file );
         //   Main.algoritm.prepareText(file.toString());
            //Main.algoritm.JEZYKI.get(Main.algoritm.JEZYKI.size()-1).ucz(new File(file.toString()));

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