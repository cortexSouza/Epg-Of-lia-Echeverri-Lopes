package br.com.eduerp.aluno;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public AlunoResponse criar(AlunoRequest request) {
        if (repository.existsByEmail(request.email())) {
            throw new EmailJaCadastradoException();
        }
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setEmail(request.email());
        aluno.setDataNascimento(request.dataNascimento());
        return AlunoResponse.from(repository.save(aluno));
    }

    @Transactional(readOnly = true)
    public List<AlunoResponse> listar() {
        return repository.findAll().stream()
                .map(AlunoResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new AlunoNaoEncontradoException(id));
        return AlunoResponse.from(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new AlunoNaoEncontradoException(id));
        if (repository.existsByEmailAndIdNot(request.email(), id)) {
            throw new EmailJaCadastradoException();
        }
        aluno.setNome(request.nome());
        aluno.setEmail(request.email());
        aluno.setDataNascimento(request.dataNascimento());
        return AlunoResponse.from(aluno);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new AlunoNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }
}
