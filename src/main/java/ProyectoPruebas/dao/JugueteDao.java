
package ProyectoPruebas.dao;

import ProyectoPruebas.domain.Juguete;
import org.springframework.data.repository.CrudRepository;


public interface JugueteDao extends CrudRepository<Juguete, Long> {
    
}
