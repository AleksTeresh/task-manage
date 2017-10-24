package task.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import task.db.tables.daos.EmployeeDao;

/**
 * Created by aleksandr on 21.10.2017.
 */
@Repository
public class ExEmployeeDao extends EmployeeDao {
    // private final DSLContext dsl;

    @Autowired
    public ExEmployeeDao(DSLContext dsl) {
        super(dsl.configuration());
    }
}
