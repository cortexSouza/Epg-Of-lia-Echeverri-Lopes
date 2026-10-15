package br.com.eduerp.aluno;

import java.time.LocalDate;

public record AlunoResponse(
        Long id,
        String nome,
        String email,
        LocalDate dataNascimento,
        boolean ativo
) {
    public static AlunoResponse from(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getDataNascimento(),
                aluno.isAtivo()
        );
    }
}
