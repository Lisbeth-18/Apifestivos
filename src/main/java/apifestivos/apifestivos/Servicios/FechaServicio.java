package apifestivos.apifestivos.Servicios;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FechaServicio {

    public boolean esFestivo(int año, String fechaString) throws ParseException {
  
        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);


        Date domingoDeRamos = calcularSemanaSanta(año);
        Date domingoDePascua = incrementarDias(domingoDeRamos, 7);
        Date fiestaDelSagradoCorazon = incrementarDias(domingoDePascua, 68);

       
        List<Date> diasFestivos = Arrays.asList(
                domingoDeRamos,
                domingoDePascua,
                fiestaDelSagradoCorazon
             
        );

     
        Calendar fechaNormalizada = Calendar.getInstance();
        fechaNormalizada.setTime(fecha);
        normalizarFecha(fechaNormalizada);

      
        for (Date festivo : diasFestivos) {
            Calendar festivoNormalizado = Calendar.getInstance();
            festivoNormalizado.setTime(festivo);
            normalizarFecha(festivoNormalizado);

            if (fechaNormalizada.equals(festivoNormalizado)) {
                return true; // La fecha coincide con un festivo.
            }
        }
        return false; // La fecha no es festiva.
    }

    private void normalizarFecha(Calendar calendario) {
        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.MILLISECOND, 0);
    }

    public Date calcularSemanaSanta(int año) {
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;
        int dia = 15 + dias;
        int mes = 3; // Marzo
        return new Date(año - 1900, mes - 1, dia);
    }

    public Date incrementarDias(Date fecha, int dias) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE, dias);
        return calendario.getTime();
    }
}
