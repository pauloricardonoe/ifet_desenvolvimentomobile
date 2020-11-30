package br.edu.ifsudestemg.avaliacao1.Num1;

public class Aluno
{
  private String nome;
  private String email;

  public Aluno(String nome, String email){
    this.nome  = nome;
    this.email = email;
  }

  public String getNome(){
    return nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  @Override
  public boolean equals(Object o){
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;

    Aluno aluno = (Aluno) o;

    if(nome != null ? !nome.equals(aluno.nome) : aluno.nome != null) return false;
    return email != null ? email.equals(aluno.email) : aluno.email == null;
  }

  @Override
  public int hashCode(){
    int result = nome != null ? nome.hashCode() : 0;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

  @Override
  public String toString(){
    return "Aluno{" + "nome='" + nome + '\'' + ", email='" + email + '\'' + '}';
  }
}
