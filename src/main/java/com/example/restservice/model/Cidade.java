package com.example.restservice.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Cidade implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Estado estado;
    
    @Override
    public int hashCode() {
        return this.getNome().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Cidade otr = (Cidade) obj;
        return this.getNome().equalsIgnoreCase(otr.getNome());
    }
}