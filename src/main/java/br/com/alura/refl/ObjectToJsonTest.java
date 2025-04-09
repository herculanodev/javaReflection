package br.com.alura.refl;

import br.com.alura.Pessoa;

public class ObjectToJsonTest {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1, "João", "1234");

        String json = ObjectToJson.convert(pessoa);
        System.out.println(json);
    }
}
