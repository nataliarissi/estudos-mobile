package com.mycompany.aula01;

//ponto inicial que incia a aplicação - método main - duplo click no executável

import com.mycompany.Aula01.Conta;
import java.util.ArrayList;

public class Main {
    //criar função para ter as informações para incializar
    public static void main(String [] a){ //a é nome de variável - colocar qualquer coisa até args - argumentos ou parâmetros
        Conta conta1 = new Conta();
    //  classe variável = new repete nome da classe fecha () e ; - instanciar
        conta1.saldo = 500; // atribuir valores aos objetos 
        conta1.nomeCorrentista = "Natália";
    //atribuir dados as caracteristicas 
        
        Conta conta2 = new Conta(); //criando objeto conta
        conta2.saldo = 1000;
        conta2.nomeCorrentista = "Luke";
    //executar com botão direito em cima da main - botão run file ou shift + F6
    
    System.out.println("Nome Correntista da conta1: " + conta1.nomeCorrentista);
    //concatenar - juntar o texto string com o valor atribuido - retornar o valor do nomeCorrentista
    System.out.println("Nome Correntista" + " da conta2: " + conta2.nomeCorrentista);

        ArrayList<Conta> lista = new ArrayList<Conta>();
    //        classe   variável-objeto
    lista.add(conta1); //método/função add para adicionar as contas na lista
    lista.add(conta2);
    lista.get(0); //ele vai retornar qualquer conta
    }
}

