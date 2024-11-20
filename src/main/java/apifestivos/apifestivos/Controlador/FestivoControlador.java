package apifestivos.apifestivos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apifestivos.apifestivos.Entidades.Festivo;
import apifestivos.apifestivos.Repositorios.FestivoRepositorio;

@RestController
public class FestivoControlador {

    @Autowired
    private FestivoRepositorio festivoRepository;

    @GetMapping("/festivos")
    public List<Festivo> obtenerFestivos() {
        return festivoRepository.findAll();
    }

    @GetMapping("/esFestivo")
    public boolean esFestivo(@RequestParam int dia, @RequestParam int mes) {
        return festivoRepository.findAll()
                .stream()
                .anyMatch(f -> f.getDia() == dia && f.getMes() == mes);
    }
}
