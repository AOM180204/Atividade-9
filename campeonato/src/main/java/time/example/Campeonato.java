package time.example;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Campeonato {
    ArrayList<Time> times = new ArrayList<Time>();
    String campeao;
    Random numero=new Random();

    public void cadastrarTime() throws Exception {//adicionar time, exceto se for acima do número máximo
        if (times.size() == 10) {
            throw new Exception();
        } else {
            String mensagem = JOptionPane.showInputDialog("Insira o nome do time");//cria o time, recebendo nome como parametro
            Time time = new Time(EntradaSaida.LerString(mensagem));
            times.add(time);
        }
    }

    public void printResultado() {
        for (int i = 0; i < times.size(); i++) {
            System.out.println("\nNome: " + times.get(i).nome);
            System.out.println("\nTotal de jogos: " + times.get(i).totalJogos);
            System.out.println("\nVitorias: " + times.get(i).vitorias);
            System.out.println("\nEmpates: " + times.get(i).empates);
            System.out.println("\nDerrotas: " + times.get(i).derrotas);
            System.out.println("\nPontos: " + times.get(i).pontos);
            System.out.println("\nGols Marcados: " + times.get(i).golsFeitos);
            System.out.println("\nGols Sofridos: " + times.get(i).golsSofridos);
            System.out.println("\nSaldo de gols: " + times.get(i).saldoGols);
        }
    }

    public Time procurarTime(String procura) throws Exception {//checa se o time existe
        boolean isFound = false;
        int i = 0;
        for (i = 0; i < times.size(); i++) {
            if (times.get(i).nome.equals(procura)) {
                isFound = true;
                break;
            } else {
                isFound = false;
            }
        }
        if (isFound == false) {
            throw new Exception();
        } else {
            return times.get(i);
        }
    }

    public void mostrarCampeao() {//printa o time campeão, teoricamente quando não for possível ter mais jogos
        int g = 0;
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).timesEnfrentados.size() == times.size() - 1) {
                g++;
            }
        }
        if (g == times.size()) {
            for (int i = 0; i < times.size() - 1; i++) {
                if (i == 0) {
                    campeao = times.get(i).nome;
                }
                if (times.get(i).pontos < times.get(i + 1).pontos) {
                    campeao = times.get(i + 1).nome;
                }
            }
            System.out.println("\nO campeão foi " + campeao);
        }
    }

    public void simularJogo(Time time1, Time time2) throws Exception {//simula o jogo
        boolean enfrentado = false;
        int i=0;
        for (i = 0; i < time1.timesEnfrentados.size(); i++) {//multiplos testes para ver se os times nunca se enfrentaram, com uma flag caso já se enfrentaram
            if (time1.timesEnfrentados.get(i).equals(time2.nome)) {//provavelmente não precisava de tudo isso, pode ser redundante
                enfrentado = true;
                break;
            } else if (time1.timesEnfrentados.isEmpty()) {
                if (time2.timesEnfrentados.isEmpty()) {
                    time1.timesEnfrentados.add(time2.nome);
                    time2.timesEnfrentados.add(time1.nome);
                    break;
                } else {
                    time1.timesEnfrentados.add(time2.nome);
                    break;
                }

            } else if (time2.timesEnfrentados.isEmpty()) {
                if (time1.timesEnfrentados.isEmpty()) {
                    time1.timesEnfrentados.add(time2.nome);
                    time2.timesEnfrentados.add(time1.nome);
                    break;
                } else {
                    time2.timesEnfrentados.add(time1.nome);
                    break;
                }
            }
        }
        if (enfrentado==true) {
            
            throw new Exception();
            
        }

        int gols1 = numero.nextInt(5);//dois randoms para número de gols
        int gols2 = numero.nextInt(5);
        if (gols1 > gols2) {//caso o time 1 vence, muda a pontuação
            time1.vitorias++;
            time1.pontos = time1.pontos + 3;
            time2.derrotas++;
            String mensagem = time1.nome + " venceu";
            EntradaSaida.ExibirMensagem("\n"+mensagem);
        } else if (gols1 == gols2) {//caso empate
            time1.empates++;
            time1.pontos = time1.pontos + 1;
            time2.empates++;
            time2.pontos = time2.pontos + 1;
            EntradaSaida.ExibirMensagem("\nEmpate");
        } else {//caso time 1 seja derrotado
            time1.derrotas++;
            time2.vitorias++;
            time2.pontos = time2.pontos + 3;
            String mensagem = time2.nome + " venceu";
            EntradaSaida.ExibirMensagem("\n"+mensagem);
        }
        time1.timesEnfrentados.add(time2.nome);//adiciona para não se enfrentarem novamente
        time2.timesEnfrentados.add(time1.nome);
        time1.totalJogos++;//mudanças gerais de acordo com o número de gols, sem importância para a pontuação
        time1.golsFeitos = time1.golsFeitos + gols1;
        time1.golsSofridos = time1.golsSofridos + gols2;
        time1.saldoGols = time1.golsFeitos - time1.golsSofridos;
        time2.totalJogos++;
        time2.golsFeitos = time2.golsFeitos + gols2;
        time2.golsSofridos = time2.golsSofridos + gols1;
        time2.saldoGols = time2.golsFeitos - time2.golsSofridos;
        mostrarCampeao();
        printResultado();
    }

}
