package com.example.restservice.model;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Estado implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @Override
    public int hashCode() {
        return this.getNome().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Estado otr = (Estado) obj;
        return this.getNome().equalsIgnoreCase(otr.getNome());
    }
}