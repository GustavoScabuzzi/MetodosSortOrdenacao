package MetodosSort;

import java.util.ArrayList;
import java.util.Arrays;

public class Ordenacao {

    Heap heap = new Heap();
    Bucket bucket = new Bucket();
    Merge merge = new Merge();
    Quick quick = new Quick();
    
    int compaHeap = 0;

    public int[] criarVetor(int num) {
        int[] vetor = new int[num];
        for (int i = 0; i < vetor.length; i++) {
            int rnd = (int) (1 + Math.random() * 1000);
            vetor[i] = rnd;
        }

        System.out.println("---Vetor desordenado: " + Arrays.toString(vetor));

        return vetor;
    }

    public void radixSort(int vetor[]) {
        int qntDigito = 0;
        String qntCaracter;
        int consultasVetor = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > qntDigito) {
                qntDigito = vetor[i];
            }
        }
        qntCaracter = Integer.toString(qntDigito);
        qntDigito = qntCaracter.length();
        //System.out.println("---Qnt max de digitos: " + qntDigito);

        for (int digit = 0; digit < qntDigito; digit++) {
            int power = (int) Math.pow(10, digit + 1);

            int z[][] = new int[vetor.length][10];
            int n[] = new int[10];

            for (int i = 0; i < vetor.length; i++) {            //Passar os valores do vetor para a matriz
                int num = vetor[i];
                z[n[(num % power) / (power / 10)]][(num % power) / (power / 10)] = num; //matriz na linha
                n[(num % power) / (power / 10)]++;
                consultasVetor++;
            }

            int c = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < vetor.length; j++) {
                    if (j < n[i]) {
                        vetor[c] = z[j][i];
                        c++;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println("Vet Radix: " + Arrays.toString(vetor));
        System.out.println("---Qnt compara Radix: " + consultasVetor);
    }

    public void selection(int vetor[]) {
        int consultasVetor = 0;

        // Verifica com o menor indice no inicio do vetor
        for (int i = 0; i < vetor.length; i++) {                                //percorre o vetor
            int menor = i;
            for (int seguinte = i + 1; seguinte < vetor.length; ++seguinte) {   // enquanto o Seguinte for menor que o tamanho do vetor
                consultasVetor++;
                if (vetor[seguinte] < vetor[menor]) {                           // se o vetor na posicao Seguinte for menor que o vetor na posicao menor
                    menor = seguinte;                                           // Entao o menor valor recebe o valor da variavel seguinte
                }
            }
            int aux = vetor[i];                                                 // AUX armazenará o valor do vetor na posicao i
            vetor[i] = vetor[menor];                                            // vetor na posicao i recebe o vetor na posicao da variavel menor
            vetor[menor] = aux;                                                 // e armazena no vetor na variavel menor o valor de AUX 
        }

        System.out.println("Vet Selection: " + Arrays.toString(vetor));           // imprime o vetor
        System.out.println("---Qnt compara Selection: " + consultasVetor);      // exibe o numero de comparacoes
    }

    public void insertionTeste(int vetor[]) {
        int consultasVetor = 0;

        for (int i = 1; i < vetor.length; ++i) {
            int aux = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > aux) {
                consultasVetor++;
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = aux;

            consultasVetor++;
        }

        System.out.println("Vet Insertion: " + Arrays.toString(vetor));
        System.out.println("---Qnt compara Insertion: " + consultasVetor);
    }

    public void insertion(int vetor[]) {
        int consultasVetor = 0;

        for (int i = 1; i < vetor.length; i++) {

            int aux = vetor[i];
            int j = i;

            while (j > 0) {
                consultasVetor++;
                if (vetor[j - 1] > aux) {
                    vetor[j] = vetor[j - 1]; //metodo de troca
                    vetor[j - 1] = aux;
                    j -= 1;
                } else {
                    j--;
                }
            }
        }

        System.out.println("Vet Insertion: " + Arrays.toString(vetor));
        System.out.println("---Qnt compara Insertion: " + consultasVetor);

    }

    public void bubble(int vetor[]) {
        int consultasVetor = 0;
        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                consultasVetor++;
                if (vetor[j - 1] > vetor[j]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }

        System.out.println("Vet Bubble: " + Arrays.toString(vetor));
        System.out.println("---Qnt compara Bubble: " + consultasVetor);
    }

    public void heap(int vetor[]) {
        int n = vetor.length;

        //Construir a arvore Heap a partir do vetor
        heap.buildMaxHeap(vetor);

        for (int i = vetor.length - 1; i > 0; i--) {
            heap.troca(vetor, i, 0);
            heap.maxHeap(vetor, 0, --n);
        }

        System.out.println("Vet Heap: " + Arrays.toString(vetor));
        System.out.println("---Qnt compara Bubble: " + heap.getConsultasVetor());
        compaHeap = heap.getConsultasVetor();
    }

    public void merge(int vetor[]) {

        merge.ordenar(vetor, 0, vetor.length - 1);

        System.out.println("Vet Merge: " + Arrays.toString(vetor));
        //System.out.println("---Qnt compara merge: " + merge.consultasVetor);
        
        WriteFile file = new WriteFile();
        file.gravar("merge", merge.consultasVetor);
    }

    public void quick(int vetor[]) {
            quick.quickSort(vetor, 0, vetor.length - 1);
        
            quick.mostrarVetor(vetor);
            WriteFile file = new WriteFile();
            
            file.gravar("quick", quick.consultaVetores);
    }

    public void count(int vetor[]) {
        int consultasVetor = 0;
        int maior = 0;
        int numVetor = 0;
        int indice = 0;

        //funçao para achar o maior valor do vetor
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i] + 1;                                   //Armazena em maior o maior valor do vetor
            }
        }

        //cria o vetor novo com o maior valor do vetor
        int vetCount[] = new int[maior];

        // Inserir os valores no vetor principal para o vetorCount
        for (int i = 0; i < vetor.length; i++) {
            numVetor = vetor[i];                                        // numVetor recebe o valor atual do vetor
            vetCount[numVetor]++;                                       // vetorCount na posicao numVetor(valor atual do vetor ao ser analisado) imcrenta 1 no seu valor atual
        }                                                               // ou seja, se na posicao numVetor estiver 4, entao ficara 5. 

        // Organiza agora os valores no vetor Principal
        for (int i = 0; i < vetCount.length; i++) {
            while (vetCount[i] > 0) {                                   // Enquanto o valor atual do vetor for maior que 0
                consultasVetor++;
                vetor[indice] = i;                                      // Vetor principal recebe o indice do VetorCount
                indice++;
                vetCount[i]--;                                          // valor na posicao i diminiu em 1
            }
        }

        System.out.println("Vet Count: " + Arrays.toString(vetor));       // Imprime o vetor organizado
        System.out.println("---Qnt compara Count: " + consultasVetor);  // numero de comparacoes

    }

    public void bucket(int vetor[]) {
        int maior = 0;
        int posVetor = 0;
        int consultasVetor = 0;

        //Criar ArrayList Principal e armazenar em cada posiçao uma Array[i]
        ArrayList[] matriz = new ArrayList[vetor.length]; // criar arraylist principal
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new ArrayList<Integer>();   // e em cada posicao da arrayList cria uma nova Array
        }

        //Encontra o maior valor do vetor para usar no calculo dos "Baldes"
        for (int i = 0; i < vetor.length; i++) { // procura o maior item do vetor para fazer a equaçao para inserçao nos ArraysLists
            if (vetor[i] > maior) {
                maior = vetor[i];   //Encontrou o maior e armazenou em Maior
            }
        }

        //Alimentaçao da nossa "Matriz" de Arrays
        for (int i = 0; i < vetor.length; i++) {                // alimenta a partir do vetor inicial a nossa Array Principal
            int temp = vetor[i];                                // Temp recebe o valor da posiçao atual do vetor
            int aux = (vetor[i] * vetor.length) / (maior + 1);  // equacao para classificar o numero na Array Principal com base no maior valor
            matriz[aux].add(temp);                              // insere no array na posicao aux, o valor atual do vetor
        }

        // metodo imprime matriz
        bucket.printMatriz(matriz);                             // Imprime a matriz com valores do vetor, porem ainda desorganizados

        //usar o BubbleSort Array para organizar
        for (int i = 0; i < matriz.length; i++) {
            bucket.bubbleArray(matriz[i]);                      // Utiliza o metodo Bubble Sort para ordenar os arrays na posicao i
            consultasVetor = consultasVetor + bucket.getConsultasVetor();
        }

        System.out.println("");

        // metodo imprime matriz
        bucket.printMatriz(matriz);                             // imprime a matriz ja organizada

        // Armazena os valores dos Arrays de volta no Vetor
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].size(); j++) {
                vetor[posVetor] = (Integer) matriz[i].get(j);   // vetor principal na posicao com o valor de posVetor recebe o valor da array[i]
                posVetor++;                                     // PosVetor recebe +1 para armazenar no indice correto do vetor
            }
        }

        System.out.println("Vet Bucket: " + Arrays.toString(vetor));              // imprime o vetor com os valores um do lado do outro
        System.out.println("---Qnt comparacoes Bucket: " + consultasVetor);

    }

}
