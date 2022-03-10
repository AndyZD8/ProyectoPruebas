package ProyectoPruebas.controler;

import ProyectoPruebas.domain.Juguete;
import ProyectoPruebas.service.JugueteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class IndexController {

    @Autowired
    private JugueteService jugueteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVS");

        var mensaje = "Mensaje desde el controlador";
        model.addAttribute("TextoSaludo", mensaje);
        
        Juguete juguete = new Juguete( "Bola", "Nike", "Bola para niños menores de 5");
        model.addAttribute(juguete);

         Juguete juguete2 = new Juguete( "Muñeca", "Barbie", "Niña de 5");
        model.addAttribute(juguete);

       
        var juguetes = Arrays.asList(juguete, juguete2);
        model.addAttribute("juguetes", juguetes);

        var juguetesDB = jugueteService.getJuguetes();
        model.addAttribute("juguetesDB", juguetesDB);

        
        return "index";

    }
    
    @GetMapping("/nuevoJuguete")
    public String nuevoJuguete(Juguete juguete) {
        return "modificarJuguete";
    }

    @PostMapping("/guardarJuguete")
    public String guardarJuguete(Juguete juguete) {
        jugueteService.save(juguete);
        return "redirect:/";
    }

    @GetMapping("/modificarJuguete/{idjuguete}")
    public String modificarJuguete(Juguete juguete, Model model) {
        var respuesta = jugueteService.getJuguete(juguete);
        model.addAttribute("juguete", respuesta);
        return "modificarJuguete";
    }

    @GetMapping("/eliminarJuguete/{idjuguete}")
    public String eliminarJuguete(Juguete juguete) {
        jugueteService.delete(juguete);
        return "redirect:/";
    }
}
