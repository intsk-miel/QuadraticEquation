package databases.services.batiservices.batisinterfaces;

public interface IBatisService <B> {         // interface for base services (use services separately)
    B getById(Long id);     //select column by id
    void insert(B object);    //insert column
    void update(B object,Long id);    //update column by object and by id
    void delete(Long id);            //delete column by id
}
