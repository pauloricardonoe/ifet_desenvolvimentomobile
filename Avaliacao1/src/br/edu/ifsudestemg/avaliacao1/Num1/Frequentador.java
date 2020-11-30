package br.edu.ifsudestemg.avaliacao1.Num1;

import java.util.ArrayList;

public class Frequentador{
  private ArrayList<Aluno> alunos;

  public Frequentador(){
    this.alunos = new ArrayList<>();
  }

  public boolean addAluno(Aluno aluno) throws Exception{
    if(aluno == null) throw new Exception("O Aluno não foi preenchido corretamente");

    if((aluno.getNome() == null) || (aluno.getNome().isEmpty()))
      throw new Exception("Nome do aluno não foi preenchido corretamente!");

    if((aluno.getEmail() == null) || (aluno.getEmail().isEmpty()))
      throw new Exception("Email do aluno não foi preenchido corretamente!");

    if(getAluno(aluno.getNome()) != null)
      throw new Exception("Aluno: " + aluno.getNome() + " já adicionado!");

    return this.alunos.add(aluno);
  }

  public Aluno getAluno(String nome) throws Exception{
    if((nome == null) || (nome.isEmpty())) throw new Exception("Parametro não informado corretamten!");

    for(Aluno aluno : alunos){
      if(aluno.getNome().equals(nome))
        return aluno;
    }

    return null;
  }

  public boolean removeAluno(String nome) throws Exception{
    Aluno aluno = getAluno(nome);
    return this.alunos.remove(aluno);
  }
}
