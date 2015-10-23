package ppl.da.core.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by greg on 18.10.15.
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,columnDefinition = "bigserial")
    protected Long id;
    @Column(name = "version")
    @Version
    private Long version;

    public void setId(Long id) {
        this.id = id;
    }


    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public BaseEntity(){}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);


        return hash;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;


        BaseEntity other = (BaseEntity) object;
        return !(this.getId() != other.getId() && (this.getId() == null || !this.id
                .equals(other.id)));
    }


    @Override
    public String toString() {
        return this.getClass().getName() + " [ID=" + id + "]";
    }
}
