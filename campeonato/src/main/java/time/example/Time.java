package time.example;

import java.util.ArrayList;

public class Time {
    String nome;
    int totalJogos;
    int vitorias;
    int empates;
    int derrotas;
    int pontos;
    int golsSofridos;
    int golsFeitos;
    int saldoGols;
    ArrayList<String> timesEnfrentados= new ArrayList<String>();//array para marcar quais times já foram enfrentados

    Time(String nome){
        this.nome=nome;
        totalJogos=0;
        vitorias=0;
        empates=0;
        derrotas=0;
        pontos=0;
        golsSofridos=0;
        golsFeitos=0;
        saldoGols=0;
    }

}
