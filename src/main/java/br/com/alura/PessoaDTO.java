package br.com.alura;

public class PessoaDTO {
    private Integer id;
    private String nome;
    private String cpf;

    // Construtor padrão necessário para reflection
    public PessoaDTO() {}

    // Construtor com campos
    public PessoaDTO(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }


    // Getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}