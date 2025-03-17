package BilheteUnico;

import java.util.Random;

public class TesteVetor {
    public static void main(String[] args) {
        //declarar vetor de iteiros

            int [] i = new int[5];
            preencheVetor(i);
            imprimirVetor(i);
        //metodo para preencher o vetor


        }
    public static void preencheVetor (int[] i) {
        Random random = new Random();
        for (int j = 0; j < i.length; j++) {
            i[j] = random.nextInt(15);
        }
    }
        //método para imprimir o valor;
        public static void imprimirVetor(int[]i){
            for (int j = 0; j < i.length; j++){
                System.out.print(i[j]+" ");
            }
            System.out.println(" ");
            for(int j : i){
                System.out.print (j +" ");
            }

    }
}
