package modelo;

public class Pelicula {

    private String titulo;
    private String genero;
    private int duracion;
    private double puntuacion;

    public Pelicula(String titulo, String genero, int duracion, double puntuacion) {

        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.puntuacion = puntuacion;
    }

    public Pelicula() {
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
