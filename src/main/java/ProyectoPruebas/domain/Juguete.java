
package ProyectoPruebas.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data  //Creacion set y get automatico
@Entity
@Table(name="juguete")
public class Juguete implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idjuguete;
    private String nombrejuguete;
    private String marca;
    private String descripcion;

    public Juguete() {
    }

    public Juguete(String nombrejuguete, String marca, String descripcion) {
        this.nombrejuguete = nombrejuguete;
        this.marca = marca;
        this.descripcion = descripcion;
    }
    
    
}
