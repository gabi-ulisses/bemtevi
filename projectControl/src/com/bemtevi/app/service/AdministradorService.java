package com.bemtevi.app.service;

import java.util.List;
import com.bemtevi.app.interfaces.Gerenciavel;
import com.bemtevi.app.model.Administrador;

public class AdministradorService implements Gerenciavel<Administrador> {
    @Override
    public void cadastrar(Administrador admin, List<Administrador> lista) {
        lista.add(admin);
        System.out.println("Administrador cadastrado com sucesso!");
    }

    @Override
    public List<Administrador> listar(List<Administrador> lista) {
        return lista;
    }
}