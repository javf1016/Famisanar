package entidad;

import javax.persistence.*;

@Entity
@Table(name = "afiliado")
public class Afiliado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String nombres;
    private String apellidos;
    private String email;
    private String direccion;
    private String telefono;
    private char genero;

    @ManyToOne
    @JoinColumn(name = "idtipoiden", nullable = false)
    private TipoIdentific tipoIdentific;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public TipoIdentific getTipoIdentific() {
        return tipoIdentific;
    }

    public void setTipoIdentific(TipoIdentific tipoIdentific) {
        this.tipoIdentific = tipoIdentific;
    }

    public Afiliado(String numero, String nombres, String apellidos, String email, String direccion, String telefono, char genero, TipoIdentific tipoIdentific) {
        this.numero = numero;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
        this.tipoIdentific = tipoIdentific;
    }

    public Afiliado() {
    }
}
