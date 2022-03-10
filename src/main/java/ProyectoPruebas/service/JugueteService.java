
package ProyectoPruebas.service;

import ProyectoPruebas.domain.Juguete;
import java.util.List;



public interface JugueteService {
    
    public List<Juguete> getJuguetes();
    
    public void save(Juguete juguete);
    
    public void delete(Juguete juguete);
    
    public Juguete getJuguete(Juguete juguete);
    
}
