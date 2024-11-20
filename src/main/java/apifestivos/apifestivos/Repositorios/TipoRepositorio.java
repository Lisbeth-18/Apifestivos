package apifestivos.apifestivos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import apifestivos.apifestivos.Entidades.Tipo;

public interface TipoRepositorio extends JpaRepository<Tipo, Long> {
}

