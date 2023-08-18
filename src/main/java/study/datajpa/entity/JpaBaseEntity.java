package study.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
public class JpaBaseEntity {

    @Column(updatable = false)
    private LocalDateTime createDate;
    private LocalDateTime updatedDate;

    @PrePersist //저장 하기 전에 반영 됨
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        createDate = now;
        updatedDate = now;
    }

    @PreUpdate //업데이트 치기 전에 반영
    public void preUpdate(){
        updatedDate = LocalDateTime.now();
    }

}
