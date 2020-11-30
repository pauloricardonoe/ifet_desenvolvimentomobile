package br.edu.ifsudestemg.avaliacao1.Num1;

public class Main {

    public static void main(String[] args) throws Exception{
	      Frequentador frequentador = new Frequentador();

	      frequentador.addAluno(new Aluno("Paulo Ricardo", "pauloricardonoe@gmail.com"));
	      frequentador.addAluno(new Aluno("Danilo", "Danilo@gmail.com"));
	      frequentador.addAluno(new Aluno("Denis", "Denis@gmail.com"));
	      frequentador.addAluno(new Aluno("Marcos", "Marcos@gmail.com"));
	      frequentador.addAluno(new Aluno("Jairo", "Jairo@gmail.com"));

        System.out.println("Buscando Aluno Paulo Ricardo");
        Aluno aluno = frequentador.getAluno("Paulo Ricardo");
        System.out.println("Aluno Encontrado: " + aluno);

        System.out.println("Buscando Aluno Marcos");
        Aluno aluno2 = frequentador.getAluno("Marcos");
        System.out.println("Aluno Encontrado: " + aluno2);


        System.out.println("Removendo Aluno Denis");
        frequentador.removeAluno("Denis");

        if(frequentador.getAluno("Denis") != null){
            System.out.println("Erro! o aluno não foi removido");
        }else{
            System.out.println("Aluno Removido com sucesso!");
        }

    }
}
