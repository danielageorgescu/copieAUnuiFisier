package com.itfactory;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static java.nio.file.Files.write;

public class Main {

    public static void main(String[] args) {
        System.out.println("Introduceti numele fisierului pe care doriti sa il copiati cu terminatia \".txt\": ");

       try{
           Scanner scanner= new Scanner(System.in);
           String numeFisier = scanner.nextLine();
           Path path = Paths.get(numeFisier);

            String verificareFisier = "verificare Fisier";
                write (path, verificareFisier.getBytes(), StandardOpenOption.APPEND);

            Path path1 = Paths.get("Copy "+ path);
            System.out.println(path1);
            while( write(path, verificareFisier.getBytes(), StandardOpenOption.APPEND).toAbsolutePath().toFile().exists()){
               Scanner scanner1= new Scanner(System.in);
               String numeFisier2= scanner1.nextLine();
               Path path2 = Paths.get("Copy "+numeFisier2);
               System.out.println(path2);
               path1 = path2;
            }
       }catch (IOException e ){
            System.out.println("Nu exista fisierul mentionat. Va rugam mai incercati.");
       }
    }
}
