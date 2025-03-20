package BilheteUnico;
import org.w3c.dom.ls.LSOutput;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Long.parseLong;
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
                    }
                }

            }

        }while (opcao != 3) ;

    }
    private void menuAdministrador() {
        int opcao=0;
        String menuAdm = "1.Emitir bilhete\n2.Listar bilhete\n3.Remover bilhete\n4.Sair";

        do{
           opcao = parseInt(showInputDialog(menuAdm));
           if (opcao<1||opcao<4){
               showMessageDialog(null, "Opção inválido");
           }
           else{
               switch (opcao){
                   case 1:
                       emitirBilhete();
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
    }


