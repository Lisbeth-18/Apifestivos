package apifestivos.apifestivos.Controlador;

import apifestivos.apifestivos.Servicios.FechaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/festivos")
public class FechaControlador {

    private final FechaServicio servicioDeFechas;

   
    public FechaControlador(FechaServicio servicioDeFechas) {
        this.servicioDeFechas = servicioDeFechas;
    }

    
    @GetMapping("/es-festivo")
    public ResponseEntity<String> esFestivo(@RequestParam int año, @RequestParam String fecha) {
        try {
            boolean resultado = servicioDeFechas.esFestivo(año, fecha);
            return ResponseEntity.ok(resultado ? "La fecha es festiva" : "La fecha no es festiva");
        } catch (Exception excepcion) {
            return ResponseEntity.badRequest().body("Error: " + excepcion.getMessage());
        }
    }
}

