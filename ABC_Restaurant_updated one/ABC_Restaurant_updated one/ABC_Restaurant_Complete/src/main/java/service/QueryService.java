
package service;

import model.Query;
import repository.QueryRepository;

import java.sql.SQLException;
import java.util.List;

public class QueryService {
    private QueryRepository queryRepository = new QueryRepository();

    public List<Query> getAllQueries() throws SQLException {
        return queryRepository.getAllQueries();
    }

    public void saveQuery(Query query) throws SQLException {
        queryRepository.saveQuery(query);
    }
}
