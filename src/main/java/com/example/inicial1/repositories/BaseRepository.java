package com.example.inicial1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.example.inicial1.entities.Base;
import java.io.Serializable;

@NoRepositoryBean // de esta interface no se pueden crear instancias
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E,ID> {

}
