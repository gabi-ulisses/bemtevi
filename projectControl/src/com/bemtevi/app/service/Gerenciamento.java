package com.bemtevi.app.service;

import java.util.List;

// Interface genérica para gerenciamento de objetos
public interface Gerenciamento<T> {
    void cadastrar(List<T> items);
    void listar(List<T> items);
}