package br.com.alura.refl;

import br.com.alura.Endereco;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {
    Pessoa pessooa = new Pessoa(1, "João", "1234");
    Endereco endereco = new Endereco("Rua 1", "123");

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {

        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessooa);
        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoaDTO.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoaDTO.getCpf(), pessoaDTO.getCpf());
        Assertions.assertEquals(pessoaDTO.getClass(), PessoaDTO.class);


    }
    @Test
    public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {

        Pessoa pessoaSemCpf = new Pessoa(1, "João", null);
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);
        Assertions.assertEquals(pessooa.getNome(), pessoaSemCpf.getNome());
        Assertions.assertNull(pessoaDTOSemCpf.getCpf());
    }
}