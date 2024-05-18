package biblioteca;

import entidad.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Biblioteca {
    private List<Libro> catalogoLibros;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.catalogoLibros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        catalogoLibros.add(libro);
    }

    public Libro consultarLibroPorISBN(String ISBN) {
        for (Libro libro : catalogoLibros) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    public Prestamo prestarLibro(Libro libro, Cliente cliente) {
        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setCliente(cliente);
        prestamo.setFechaPrestamo(java.time.LocalDate.now());
        prestamos.add(prestamo);
        libro.setEstado("prestado");
        return prestamo;
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamo.setFechaDevolucion(java.time.LocalDate.now());
        prestamo.getLibro().setEstado("disponible");
    }

    public List<Prestamo> consultarPrestamosActivos() {
        List<Prestamo> prestamosActivos = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getFechaDevolucion() == null) {
                prestamosActivos.add(prestamo);
            }
        }
        return prestamosActivos;
    }

    public List<Prestamo> consultarPrestamosPorCliente(Cliente cliente) {
        List<Prestamo> prestamosCliente = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCliente().equals(cliente)) {
                prestamosCliente.add(prestamo);
            }
        }
        return prestamosCliente;
    }

    public List<Libro> consultarLibrosPorAutor(Autor autor) {
        return catalogoLibros.stream()
                .filter(libro -> libro.getAutor().equals(autor))
                .collect(Collectors.toList());
    }
}
