package pl.koleszko.software.uma.application.domain.model.entity;

import org.springframework.data.domain.Persistable;
import pl.koleszko.software.uma.application.domain.model.listener.BaseEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(value = {BaseEntityListener.class})
public class BaseEntity implements Persistable<Long> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "MODIFICATION_DATE")
    private Date modificationDate;

    @Override
    public Long getId() {
        return id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getModificationDate() {
        return modificationDate;
    }

    @Override
    @Transient
    public boolean isNew() {
        return getId() == null;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
