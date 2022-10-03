package databases.services.batiservices;

import databases.services.batiservices.batisinterfaces.IEquationService;
import databases.services.batiservices.batisinterfaces.MyBatisMain;
import databases.services.mappers.IEquationMapper;
import databases.models.Equation;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class EquationService implements IEquationService {
    private final static Logger LOGGER = LogManager.getLogger(EquationService.class); //loggers
    @Override                                      //overriding getById
    public Equation getById(Long id) {
        SqlSession session = MyBatisMain.getSqlSessionFactory().openSession();
        try {
            IEquationMapper iEquationMapper = session.getMapper(IEquationMapper.class);  //using IEquationMapper
            return iEquationMapper.getById(id);
        }finally {
            session.rollback();  //returning
            session.close();  //closing
        }
    }

    @Override                                //overriding insert
    public void insert(Equation object) {
        SqlSession session  = MyBatisMain.getSqlSessionFactory().openSession();
        try {
            IEquationMapper iEquationMapper = session.getMapper(IEquationMapper.class);
            iEquationMapper.insert(object);
            session.commit();
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override        //overriding update
    public void update(Equation object, Long id) {
        SqlSession session = MyBatisMain.getSqlSessionFactory().openSession();
        try {
            object.setId(id);   //using setId and putting id inside setId method because we need to specify column by id
            IEquationMapper iEquationMapper = session.getMapper(IEquationMapper.class); //using IEquationMapper
            iEquationMapper.update(object);  //using interface method which is connected to sql updating
            session.commit();
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override      //overriding delete
    public void delete(Long id) {
        SqlSession session = MyBatisMain.getSqlSessionFactory().openSession();
        try {
            IEquationMapper iEquationMapper = session.getMapper(IEquationMapper.class);
            iEquationMapper.delete(id);
            session.commit();
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Override   //overriding getAllEquation
    public List<Equation> getAllEquation() {
        SqlSession session = MyBatisMain.getSqlSessionFactory().openSession();
        try {
            IEquationMapper iEquationMapper = session.getMapper(IEquationMapper.class);
            return iEquationMapper.getAllEquation();
        }finally {
            session.rollback();
            session.close();
        }
    }
}
