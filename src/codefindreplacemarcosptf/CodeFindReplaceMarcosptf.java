/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefindreplacemarcosptf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author marcossantana
 */
public class CodeFindReplaceMarcosptf {

    private static final String HOME_PATH_XML = "/home/marcossantana/develop/marcosptf/arquivos/mapa-site-rpm/";
    private static final String HOME_PATH_NOVOSITE = "/home/marcossantana/develop/marcosptf/arquivos/novosite/";

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File directory;
        FileReader fr;
        FileWriter fw;
        BufferedReader br;
        BufferedWriter bw;
        String line = null;

        directory = new File(HOME_PATH_XML);

        System.out.println("abrindo diretorio;");

        if (directory.exists()) {
            System.out.println("diretorio existe");

            for (String listFiles : directory.list()) {

                String sb = null;
                System.out.println("print nome do arquivo");
                System.out.println(listFiles.toString());

                if (!listFiles.endsWith(".xml")) {
                    continue;
                }

                System.out.println("print-fileReader=>");
//                fr = new FileReader(HOME_PATH + listFiles.toString());
                fw = new FileWriter(HOME_PATH_NOVOSITE + listFiles.toString());
                sb = "";
                br = new BufferedReader(new FileReader(HOME_PATH_XML + listFiles.toString()));
//                bw = new BufferedWriter(new FileWriter(HOME_PATH + "novosite-" + listFiles.toString(), true));
//                fl = new Files(new File(HOME_PATH + "novosite-" + listFiles.toString()));
                line = br.readLine();

//                while ((line != null) || (!"null".equals(line))) {
//                while (line.toString() != null) {
                try {
                    while (line != null || line.equals("")) {
                        System.out.println("print-debugger=>");
                        System.out.println(line);
                        System.out.println("print-length-debugger=>");
                        System.out.println(line.length());

                        if (line.contains("rpmdobrasil")) {
                            System.out.println("print-debugger-before-replace=>");
                            System.out.println(line);
                            line = line.replace("rpmdobrasil", "rpmrolamentos");
                            System.out.println("print-debugger-after-replace=>");
                            System.out.println(line);
                        }

                        if ((line.contains("2018-11-26")) || (line.contains("2016-09-21"))) {
                            System.out.println("print-debugger-before-replace=>");
                            System.out.println(line);
                            line = line.replace("2018-11-26", "2019-08-08");
                            line = line.replace("2016-09-21", "2019-08-08");
                            System.out.println("print-debugger-after-replace=>");
                            System.out.println(line);
                        }

                        if (line.length() > 0) {
                            System.out.println("BufferWriter===>>>>");
                            fw.write((String) line.toString() + "\n");
                        }

                        line = br.readLine();
                    }

                } catch (NullPointerException err) {
                    System.out.println("error null pointer exception =>" + err.getMessage());

                } catch (Exception err) {
                    System.out.println("error exception =>" + err.getMessage());
                }

//
                fw.flush();
                fw.close();
                br.close();

//                break;
//                fw = new fileWriter();
//                System.out.println(listFiles);
            }

        } else {
            System.out.println("diretorio nao existe=>");
        }

    }

}
