package databases.services.batiservices.batisinterfaces;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.Reader;

public class MyBatisMain {
    private final static Logger LOGGER = LogManager.getLogger(MyBatisMain.class);  //loggers
    private static SqlSessionFactory factory; //creating sql session factory

    private MyBatisMain(){}   //creating private constructor
    static
    {
        Reader reader = null;  // using reader to read information from mybatis-config.xml
        try {
            reader = Resources.getResourceAsReader("mybatisfiles/mybatis-config.xml");
        }catch (IOException e){
            LOGGER.error(e);
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return factory;
    }   //writing static getSqlSessionFactory to use without creating many objects
}

