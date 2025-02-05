package com.bemtevi.app.model;

/**
 * Classe responsável por representar uma ONG (Organização Não Governamental).
 * 
 * Esta classe estende a classe {@link Usuario} e adiciona o atributo específico
 * de uma ONG, que é o CNPJ (Cadastro Nacional da Pessoa Jurídica). Além disso, 
 * implementa o método de validação de senha, permitindo que a ONG valide sua 
 * senha no sistema.
 * 
 * A classe oferece os seguintes métodos:
 * - **getCnpj**: Retorna o CNPJ da ONG.
 * - **setCnpj**: Permite atualizar o CNPJ da ONG.
 * - **validarSenha**: Valida se a senha fornecida é igual à senha da ONG.
 * 
 * Construtores:
 * - O construtor principal recebe os parâmetros de nome, email, telefone, senha
 *   e CNPJ.
 * - O construtor padrão inicializa a ONG com valores fictícios, útil para testes.
 * 
 * A classe é uma parte do sistema de gestão de usuários, permitindo que uma ONG
 * interaja com o sistema como um tipo de usuário específico.
 */
public class Ong extends Usuario {

    private String cnpj;

    public Ong(String nome, String email, String telefone, String senha, String cnpj) {
        super(nome, email, telefone, senha);
        this.cnpj = cnpj;
    }

    public Ong(){
        super("ong1", "ong@", "1234", "12");
        this.cnpj = "1234567";
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean validarSenha(String senha) {
        return this.getSenha().equals(senha);
    }

}
