package databases.services.mappers;

public interface IBatisMapper <M>{        //base interface for mapper
    M getById(Long id);       //select column by id
    void insert(M object);   //insert column
    void update(M equation);   //update column
    void delete(Long id);   //delete column by id
}
