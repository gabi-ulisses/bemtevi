package com.bemtevi.model;

public interface Gerencimanento<T> {

    public void cadastrar(List<T> item);
    
    public void listar(List<T> item);

}
