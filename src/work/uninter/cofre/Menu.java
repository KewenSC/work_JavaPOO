// Essa classe contém o método principal e constrói o menu para o usuário

package work.uninter.cofre;

import work.uninter.cofre.money.Cofre;
import work.uninter.cofre.money.stateMoney.Dolar;
import work.uninter.cofre.money.stateMoney.Euro;
import work.uninter.cofre.money.stateMoney.Real;

import java.util.Scanner;

public class Menu {

    static Scanner userInput = new Scanner(System.in);
    static Cofre cofre = new Cofre();

    public static void main(String[] args) {
        homePage();
    }

    // Introdução ao cofre
    private static void homePage() {
        System.out.println("Bem vindo ao Cofre!");
        System.out.println("Desenvolvido por Gabriel Kewen");
        System.out.println("RU: 4059359");
        waitUserConfirm(); // Mostra mensagem para usuário confirmar, essa função é ultima definida nesssa classe
        mainMenuPage(); // Encaminha o programa para o menu principal
    }

    // Menu principal, onde estão as opções para operar o programa
    private static void mainMenuPage() {
        int option;

        //Repete o menu enquanto o usuário não digitar uma opção válida ou de sáida
        do {
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Adicionar Moeda");
            System.out.println("2 - Remover Moeda");
            System.out.println("3 - Listar Moedas");
            System.out.println("4 - Calcular Moedas");
            System.out.println("0 - Finalizar");

            option = userInput.nextInt();

            // Encaminha o programa para o menu desejado pelo usuário
            switch (option) {
                case 1:
                    addCoinPage(); // Para adicionar uma moeda
                    break;

                case 2:
                    removeCoinPage(); // Para remover uma moeda
                    break;

                case 3:
                    listCoinPage(); // Para ver a lista de moeas
                    break;

                case 4:
                    convertCoinPage(); // Para mostrar o valor depositado convetido em real
                    break;

                case 0:
                    System.out.println("Finalizando programa..."); // Para finalizar o programa
                    break;

                default:
                    System.out.println("Digite uma opção válida!"); // Quando a opção não for válida.
                    waitUserConfirm();
                    break;
            }
        } while (option != 0); // A opção zero encerra o loop corretamente

    }

    // Essa função redefine a variavel currentCoin da classe Cofre de acordo com as opções
    private static void selectState() {
        int defined;

        do {
            System.out.println("Defina o tipo da moeda:");
            System.out.println("1 - Real");
            System.out.println("2 - Dolar");
            System.out.println("3 - Euro");

            defined = userInput.nextInt();

            switch (defined) {
                case 1:
                    cofre.currentCoin = new Real(); // Instancia a moeda como subclasse Real
                    break;

                case 2:
                    cofre.currentCoin = new Dolar(); // Instancia a moeda como subclasse Dolar
                    break;

                case 3:
                    cofre.currentCoin = new Euro(); // Instancia a moeda como subclasse Euro
                    break;

                default:
                    System.out.println("Digite uma opção válida!"); // Caso o usuario digite um numero não valído
                    defined = 0; // define a variavel como 0 para repetir o loop
                    waitUserConfirm(); // Espera a confirmação do usuario
                    break;
            }
        } while (defined == 0);

    }

    // Adiona uma moeda, com base em seu tipo e valor
    private static void addCoinPage() {
        selectState(); // Antes de definir o valor da moeda é preciso a instanciar
        double value;

        System.out.println("Digite o valor da moeda: ");
        value = userInput.nextDouble();

        cofre.addCoin(value); // Adiciona a moeda

        System.out.println("Moeda adicionada!");

        waitUserConfirm(); // Aguarda confirmação do usuário
    }

    // Remove uma moeda de acordo com o tipo e valor correspondentes.
    private static void removeCoinPage() {
        selectState(); // Menu Para definir o tipo de moeda
        double value;

        System.out.println("Digite seu valor:");
        value = userInput.nextDouble();

        if (cofre.remove(value))
            System.out.println("Moeda removida!"); // Moeda encontrada
         else
            System.out.println("Essa moeda não existe"); // Moeda não encontrada

        waitUserConfirm(); // Aguarda confirmação do usuário
    }

    // Mostra a lista de moedas adiocionadas
    private static void listCoinPage() {
        System.out.println("Lista de moedas: ");
        cofre.list(); //Mostra lista de moedas
        waitUserConfirm(); // Aguarda confirmação do usuário
    }

    // Mostra o valor das moedas convertido para real
    private static void convertCoinPage() {
        System.out.println("Convertendo moedas para real:");
        System.out.println("O cofre possui R$" + cofre.valorTotalReal());
        waitUserConfirm(); // Aguarda confirmação do usuário
    }

    // Função para aguardar confirmação do usuário
    private static void waitUserConfirm() {
        userInput = new Scanner(System.in); // Re-instancia o scanner para evtar alguns erros
        System.out.println("Pressione enter para continuar...");
        userInput.nextLine(); // Lẽ a tecla enter
    }

}

