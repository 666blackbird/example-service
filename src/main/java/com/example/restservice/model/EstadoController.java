package com.example.restservice.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class EstadoController {
    private EstadoDAO dao;

    @Autowired
    public EstadoController(EstadoDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/estados")
    public String listaEstado(Model model) {
        model.addAttribute("estadoLista", dao.read());
        return "estados";
    }

    @PostMapping("/estados/new")
    public void newEstado(Estado estado) {
        try {
            Estado e = new Estado();
            e.setNome(estado.getNome());
            dao.create(e);
        } catch(Exception e) {

        }
        return "redirect:/estados";
    }

    @PutMapping("/estados/edit")
    public void editEstado(Estado estado) {
        try {
            Estado e = new Estado();
            e.setNome(estado.getNome());
            dao.update(e);
        } catch(Exception e) {

        }
        return "redirect:/estados";
    }

    @DeleteMapping("/estados/{id}")
    public void removeEstado(@RequestParam int id) {
        dao.delete(id);
        return "200";
    }
}