package pl.koleszko.software.uma.application.domain.model.listener;

import org.joda.time.LocalDateTime;
import pl.koleszko.software.uma.application.domain.model.entity.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class BaseEntityListener {

    @PrePersist
    @PreUpdate
    public void setModificationDate(Object object){
        BaseEntity baseEntity = (BaseEntity) object;
        baseEntity.setModificationDate(LocalDateTime.now().toDate());
    }
}