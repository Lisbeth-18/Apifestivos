package apifestivos.apifestivos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import apifestivos.apifestivos.Entidades.Festivo;

public interface FestivoRepositorio extends JpaRepository<Festivo, Long> {
}
