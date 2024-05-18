package main;

import biblioteca.Biblioteca;
import entidad.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor();
        autor.setFechaNacimiento(LocalDate.of(1547, 9, 29));
        autor.setFechaFallecimiento(LocalDate.of(1616, 4, 23));

        Libro libro = new Libro();
        libro.setISBN("1234567890");
        libro.setTitulo("El Quijote");
        libro.setAutor(autor);
        libro.setGenero("Novela");
        libro.setEstado("disponible");

        Cliente cliente = new Cliente();
        cliente.setIdPersona(1);
        cliente.setNombre("Jackson");
        cliente.setApellido("Toro");
        cliente.setDireccion("Cra #12-23");
        cliente.setTelefono("310567265");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarLibro(libro);

        Prestamo prestamo = biblioteca.prestarLibro(libro, cliente);
        System.out.println("Prestamo realizado: " + prestamo);

        biblioteca.devolverLibro(prestamo);
        System.out.println("Prestamo después de devolver el libro: " + prestamo);

        System.out.println("Libros por autor: " + biblioteca.consultarLibrosPorAutor(autor));

        System.out.println("Prestamos activos: " + biblioteca.consultarPrestamosActivos());

        System.out.println("Prestamos por cliente: " + biblioteca.consultarPrestamosPorCliente(cliente));
    }
}
