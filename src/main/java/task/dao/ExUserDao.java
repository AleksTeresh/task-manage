package task.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import task.db.tables.daos.UserDao;

/**
 * Created by aleksandr on 21.10.2017.
 */
@Repository
public class ExUserDao extends UserDao {

    @Autowired
    public ExUserDao(DSLContext dsl) {
        super(dsl.configuration());
    }
}
