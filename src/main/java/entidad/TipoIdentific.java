package entidad;

import javax.persistence.*;

@Entity
@Table(name = "tipoidentific")
public class TipoIdentific {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoIdentific(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoIdentific() {

    }
}
