package com.example.restservice.model;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class EstadoDAO {
    private static List<Estado> listaEstados;

    @Autowired
    public EstadoDAO() {
        listaEstados = new ArrayList<Estado>();
    }

    public void create(Estado e) {
        listaEstados.add(e);
    }

    public List<Estado> read() {
        return listaEstados;
    }

    public void update(Estado e) {
        listaEstados.set(e);
    }

    public void delete(int id) {
        Estado e = this.read().stream().filter(e -> e.getId().equals(id)).findAny().get();
        listaEstados.remove(e);
    }
}