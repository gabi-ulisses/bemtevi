package com.bemtevi.app.interfaces;

import java.util.List;

/**
 * Interface genérica para o gerenciamento de objetos de tipo genérico `T`.
 * Fornece os métodos essenciais para cadastro e listagem de itens.
 * 
 * Métodos principais:
 * - **cadastrar**: Adiciona um item à lista fornecida.
 * - **listar**: Retorna a lista de itens cadastrados.
 * 
 * A interface pode ser implementada por classes que necessitam de funcionalidades de gerenciamento
 * de dados, como adicionar ou listar objetos.
 */
public interface Gerenciavel<T> {
    void cadastrar(T item, List<T> lista);
    List<T> listar(List<T> lista);
}
