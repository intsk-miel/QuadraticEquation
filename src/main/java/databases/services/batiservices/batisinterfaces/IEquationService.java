package databases.services.batiservices.batisinterfaces;

import databases.models.Equation;
import java.util.List;

public interface IEquationService extends IBatisService<Equation>{
    List<Equation> getAllEquation();    // get every Equation data
}
