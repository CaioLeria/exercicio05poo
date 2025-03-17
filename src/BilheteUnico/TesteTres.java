package BilheteUnico;

import java.sql.SQLOutput;

public class TesteTres {
    public static void main(String[] args) {
        BilheteUnico[] a =new BilheteUnico[3];

        Usuario u1 = new Usuario("Caio",213,"e");
        a[0]= new BilheteUnico(u1);
        a[1] = new BilheteUnico(new Usuario("selmimi",123,"p"));
        a[2] = new BilheteUnico(new Usuario("Cesão",143,"e"));

        for(BilheteUnico b : a){
            System.out.println(b.usuario.cpf);
        }
    }
}
