package com.bemtevi.app.interfaces;

import java.util.List;

// Interface genérica para gerenciamento de objetos
public interface Gerenciavel<T> {
    void cadastrar(T item, List<T> lista);
    List<T> listar(List<T> lista);
}
