package com.example.restservice.model;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CidadeDAO {
    private static List<Cidade> listaCidades;

    @Autowired
    public CidadeDAO() {
        listaCidades = new ArrayList<Cidade>();
    }

    public void create(Cidade c) {
        listaCidades.add(c);
    }

    public List<Cidade> read() {
        return listaCidades;
    }

    public void update(Cidade c) {
        listaCidades.set(c);
    }

    public void delete(int id) {
        Cidade c = this.read().stream().filter(e -> e.getId().equals(id)).findAny().get();
        listaCidades.remove(c);
    }
}