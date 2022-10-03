package databases.services.mappers;

import databases.models.Equation;
import java.util.List;

public interface IEquationMapper extends IBatisMapper<Equation> {
    List<Equation> getAllEquation();  // get every Equation data
}
