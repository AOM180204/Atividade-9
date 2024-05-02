package time.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int escolha = 0;
        boolean sucesso1 = false;//flag pra procura do time um
        boolean sucesso2 = false;//flag pra procura do time dois
        Campeonato campeonato = new Campeonato();
        while (escolha != 3) {
            escolha = Integer.parseInt(JOptionPane.showInputDialog("1)Cadastrar time \n2)Simular jogo\n3)Sair"));
            switch (escolha) {
                case 1:
                    try {
                        campeonato.cadastrarTime();
                    } catch (Exception e) {
                        EntradaSaida.ExibirMensagem("Numero máximo de times atingido");
                    }
                    break;

                case 2:
                    String time1 = JOptionPane.showInputDialog("Insira o nome do primeiro time");
                    String time2 = JOptionPane.showInputDialog("Insira o nome do segundo time");
                    try {
                        campeonato.procurarTime(time1);
                        sucesso1 = true;
                    } catch (Exception e) {
                        EntradaSaida.ExibirMensagem("Time não existe");
                        sucesso1 = false;
                    }
                    try {
                        campeonato.procurarTime(time2);
                        sucesso2 = true;
                    } catch (Exception e) {
                        EntradaSaida.ExibirMensagem("Time não existe");
                        sucesso2 = false;
                    }
                    if (sucesso1 == true && sucesso2 == true) {
                        try {
                            campeonato.simularJogo(campeonato.procurarTime(time1), campeonato.procurarTime(time2));
                        } catch (Exception e) {
                            EntradaSaida.ExibirMensagem("Times já se enfrentaram");
                        }
                    }
                    break;
                case 3:
                    System.exit(0);

                default:
                    System.out.println("Opção inválida");

            }
        }
    }
}