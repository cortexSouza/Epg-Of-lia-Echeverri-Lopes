package br.com.eduerp.aluno;

public class AlunoNaoEncontradoException extends RuntimeException {
    public AlunoNaoEncontradoException(Long id) {
        super("Aluno não encontrado com id: " + id);
    }
}
