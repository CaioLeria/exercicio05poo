package BilheteUnico;
import org.w3c.dom.ls.LSOutput;

import java.text.DecimalFormat;
import java.util.Scanner;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.showInputDialog;

public class Util {
    private BilheteUnico [] bilhete =new BilheteUnico[5];
    private int index=0;
    public void menuPrincial() {
        int opcao = 0;
        String menu = "1. Administrador\n2.Usuário\n3.Finalizar";

        int opcaoAdm = 0;
        do {
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 1) {
                showInputDialog(menu);
                if (opcao < 1 || opcao > 3) {
                    showMessageDialog(null, "opação inválida");
                } else {
                    switch (opcao) {
                        case 1:
                            menuAdministrador();
                            break;
                        case 2:
                            menuUsuario();
                            break;
                    }
                }
            }
        }while (opcao != 3) ;
    }
    private void menuUsuario(){
        Scanner sc= new Scanner(System.in);
        int opcao=0;
        String menuUsuario = "1.Consular saldo\n2.Caregar bilhete\n3.Passar a catraca\n4.Sair";

        do{
            opcao = parseInt(showInputDialog(menuUsuario));
            if (opcao<1||opcao>4){
                showMessageDialog(null, "Opção inválido");
            }
            else{

                switch (opcao){
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        carregarBilhete();
                        break;
                }
            }
        }while(opcao!=4);
    }
    private int pesquisa (){
        int posicao=0;
        long cpf = parseLong(showInputDialog("CPF"));
        for(int i =0; i<index;i++) {
            if (cpf == bilhete[i].usuario.cpf) {
                posicao = i;
            } else{
                showMessageDialog(null , cpf+ "não encontrado");
                posicao =-1;
            }
        }
        return posicao;
    }
    private void consultarSaldo(){
        int posicao=pesquisa();
        if (posicao!= -1){
            showMessageDialog(null, "saldo: "+bilhete[posicao].saldo);
        }
    }
    private void carregarBilhete(){
        int posicao=pesquisa();
        double valor;
        if (posicao!=-1){
            valor = parseDouble(showInputDialog("valor da recarga"));
            bilhete[posicao].carregar(valor);
        }
    }
    private void passarNaCatraca(){
        int posicao=pesquisa();
        if (posicao!=-1){
            bilhete[posicao].passarNaCatraca();
        }
    }
    private void menuAdministrador() {
        int opcao=0;
        String menuAdm = "1.Emitir bilhete\n2.Listar bilhete\n3.Remover bilhete\n4.Sair";

        do{
           opcao = parseInt(showInputDialog(menuAdm));
           if (opcao<1||opcao>4){
               showMessageDialog(null, "Opção inválido");
           }
           else{
               switch (opcao){
                   case 1:
                       emitirBilhete();
                       break;
                   case 2:
                       listarBilhete();
                       break;
                   case 3:
                       removerBilhete();
                       break;
               }
           }
        }while(opcao!=4);
    }
    private void emitirBilhete(){
        String nome;
        long cpf;
        String perfil;

        if(index< bilhete.length){
            nome=showInputDialog("Nome:");
            cpf= parseLong(showInputDialog("cpf: "));
            perfil = showInputDialog("Estudante ou Professor ou Comum");

            bilhete[index++]=new BilheteUnico(new Usuario(nome,cpf,perfil));
        }
    }
    private void listarBilhete(){
        DecimalFormat df = new DecimalFormat("0.00");
        String mensagem = "";
        for(int i =0;i<index;i++){
           mensagem+="número do bilhete: " + bilhete[i].numero + "\n";
            mensagem+="nome do usuário: " + bilhete[i].usuario.nome + "\n";
            mensagem+="saldo do bilhete: " + df.format(bilhete[i].consultarSaldo()) + "\n";
            mensagem+="tipo de tarifa: " + bilhete[i].usuario.tipoTarifa + "\n";
            mensagem+="--------------------------------------------------------------------"+"\n";
        }
    showMessageDialog(null,mensagem);
    }
    private void removerBilhete(){
        int posicao = pesquisa();
        int resposta;
        if (posicao!=-1){
            resposta = showConfirmDialog(null, "tem certeza que deseja remover?");
            if (resposta == YES_OPTION){
                bilhete[posicao]=bilhete[index-1];
                index--;
            }
        }
    }
    }


