package time.example;

public class EntradaSaida {
    static public int LerInteiro(String mensagem) {//ler input inteiro
        int inteiro = Integer.parseInt(mensagem);
        return inteiro;
    }

    static public String LerString(String mensagem) {//ler input String
        return mensagem;
    }

    static public Double LerDouble(String mensagem) {//ler inputDouble
        Double numero = Double.parseDouble(mensagem);
        return numero;
    }

    static public void ExibirMensagem(String mensagem) {//mostrar mensagens para resultado ou exceção
        System.out.println(mensagem);
    }
}
