
package ProyectoPruebas.service;

import ProyectoPruebas.dao.JugueteDao;
import ProyectoPruebas.domain.Juguete;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JugueteSeriviceImpl implements JugueteService {
    
        @Autowired
    private JugueteDao jugueteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Juguete> getJuguetes() {
        return (List<Juguete>) jugueteDao.findAll();
    }

    @Override
   @Transactional
    public void save(Juguete juguete) {
     jugueteDao.save(juguete);
    }

    @Override
    @Transactional
    public void delete(Juguete juguete) {
       jugueteDao.delete(juguete);
    }

    @Override
    public Juguete getJuguete(Juguete juguete) {
       return jugueteDao.findById(juguete.getIdjuguete()).orElse(null);
    }
    
}
