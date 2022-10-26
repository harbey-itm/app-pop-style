package edu.itm.especializacion.sofware.apppopstyle.repository;


import edu.itm.especializacion.sofware.apppopstyle.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepositorio extends JpaRepository<ProductoEntity, Long> {

}
