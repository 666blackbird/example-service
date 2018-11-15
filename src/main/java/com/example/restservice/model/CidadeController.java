package com.example.restservice.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class CidadeController {
    private CidadeDAO dao;
    private EstadoDAO ed;

    @Autowired
    public CidadeController(CidadeDAO dao, EstadoDAO ed) {
        this.dao = dao;
        this.ed = ed;
    }

    @GetMapping("/cidades")
    public String listaCidade(Model model) {
        model.addAttribute("cidadeLista", dao.read());
        model.addAttribute("estadoLista", ed.read());
        return "cidades";
    }

    @PostMapping("/cidades/new")
    public void newCidade(Cidade cidade) {
        try {
            Cidade c = new Cidade();
            c.setNome(cidade.getNome());
            Estado e = ed.read().stream().filter(e -> cidade.getEstado().equalsIgnoreCase(e.getNome())).findFirst().get();
            c.setEstado(e);
            dao.create(c);
        } catch(Exception e) {

        }
        return "redirect:/cidades";
    }

    @PostMapping("/cidades/edit")
    public void editCidade(Cidade cidade) {
        try {
            Cidade c = new Cidade();
            c.setNome(cidade.getNome());
            Estado e = ed.read().stream().filter(e -> cidade.getEstado().equalsIgnoreCase(e.getNome())).findFirst().get();
            c.setEstado(e);
            dao.update(c);
        } catch(Exception e) {

        }
        return "redirect:/cidades";
    }

    @DeleteMapping("/cidades/{id}")
    public void removeEstado(@RequestParam int id) {
        dao.delete(id);
        return "200";
    }
}