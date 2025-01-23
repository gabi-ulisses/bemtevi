package com.bemtevi.app.service;

import java.util.List;

// Interface genérica para gerenciamento de objetos
public interface Gerenciamento<T> {
    public void cadastrar(List<T> items);
    public void listar(List<T> items);
}