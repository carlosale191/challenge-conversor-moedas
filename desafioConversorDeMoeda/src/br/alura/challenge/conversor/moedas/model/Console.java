package br.alura.challenge.conversor.moedas.model;

import br.alura.challenge.conversor.moedas.exception.InvalidCommandException;
import br.alura.challenge.conversor.moedas.service.DataApi;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    Scanner reader = new Scanner(System.in);
    DataApi api = new DataApi();
    private int option;
    private double value;
    private boolean validation = false;

    public int getOption() {
        return option;
    }

    public double getValue() {
        return this.value;
    }

    String text = """
            Bem-vindo(a) ao conversor de moedas! Digite o número referente a conversão que você deseja fazer:
            1 - Real para Dólar.
            2 - Dólar para Real.
            3 - Real para Euro.
            4 - Euro para Real.
            5 - Real para Libra.
            6 - Libra para Real.
            7 - Real para Iene.
            8 - Iene para real.
            9 - Finalizar.
            """;

    public void callConsole() throws IOException, InterruptedException {
        //double res = conversion.getConversion_rate();
        while (option != 9) {
            System.out.println(text);
            System.out.println("Digite seu comando: ");
            option = reader.nextInt();
            if (option > 9) {
                throw new InvalidCommandException("Comando inválido, digite outro disponível.");
                //System.out.println("comando n vai");
            } else if (option == 9) {
                break;
            }
            System.out.println("Digite o valor a ser convertido");
            value = reader.nextDouble();
            if (value <= 0) {
                System.out.println("Valor inválido.");
            } else {
                validation = true;
                if (validation) {
                    api.searchApi(getSelectedOption(), getInputValue());

                }
            }

        }

    }


    public int getSelectedOption(){
        return this.option;
    }

    public double getInputValue(){
        return this.value;
    }
    


}

