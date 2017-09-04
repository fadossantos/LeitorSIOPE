package br.gov.sp.policiamilitar.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class leitorArquivoFolha {

    public static void main(String... args){
        identificarProfessores();
    }

    public static void identificarProfessores()
    {
        try {
            FileReader arq = new FileReader("D:\\Users\\Fernando\\Desktop\\Arquivos Fernanda\\90740-03-012017");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                if (linha.matches("^\\*\\d{2}\\.\\d{3}\\.\\d{1}.*")){
                    String registro = linha.substring(1,9).trim();
                    String nome = linha.substring(10,51).trim();
                    String cargo = linha.substring(51,79).trim();
                    String SalarioBase = linha.substring(79,89).replace(".","").trim();
                    String SalarioBruto = linha.substring(89,100).replace(".","").trim();
                    String AuxilioAlimentacao = linha.substring(101,110).replace(".","").trim();
                    String SalarioSemAuxilioAlimentacao = linha.substring(111,122).replace(".","").trim();
                    String IPR = linha.substring(123,133).replace(".","").trim();
                    String CAPEP = linha.substring(134,144).replace(".","").trim();
                    String INSS = linha.substring(145,155).replace(".","").trim();
                    String FGTS = linha.substring(156,166).replace(".","").trim();
                    System.out.printf("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;\n", registro,nome,cargo,SalarioBase,SalarioBruto,AuxilioAlimentacao,SalarioSemAuxilioAlimentacao,
                            IPR,CAPEP,INSS,FGTS);
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
    }

    public static void identificarEscolas()
    {
        try {
            FileReader arq = new FileReader("D:\\Users\\Fernando\\Desktop\\Arquivos Fernanda\\90740-03-012017");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            List<String> listaString = new ArrayList<String>();
            while (linha != null) {
                if (linha.matches(".*\\d{2}\\.\\d{2}\\.\\d{2}\\.\\d{2}.*")){
                    //System.out.printf("%s\n", linha);
                    listaString.add(linha);
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
            List<String> listaStringDistincted = listaString.stream().distinct().collect(Collectors.toList());
            for(String str: listaStringDistincted){
                System.out.printf("%s\n", str);
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();
    }
}
