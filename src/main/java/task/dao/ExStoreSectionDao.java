package task.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import task.db.tables.daos.StoreSectionDao;

/**
 * Created by aleksandr on 21.10.2017.
 */
@Repository
public class ExStoreSectionDao extends StoreSectionDao {

    @Autowired
    public ExStoreSectionDao(DSLContext dsl) {
        super(dsl.configuration());
    }
}
