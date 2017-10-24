/*
 * This file is generated by jOOQ.
*/
package task.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import task.db.Keys;
import task.db.Public;
import task.db.tables.records.StoreSectionRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StoreSection extends TableImpl<StoreSectionRecord> {

    private static final long serialVersionUID = -2056700352;

    /**
     * The reference instance of <code>public.store_section</code>
     */
    public static final StoreSection STORE_SECTION = new StoreSection();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StoreSectionRecord> getRecordType() {
        return StoreSectionRecord.class;
    }

    /**
     * The column <code>public.store_section.id</code>.
     */
    public final TableField<StoreSectionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.store_section.name</code>.
     */
    public final TableField<StoreSectionRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(80).nullable(false), this, "");

    /**
     * Create a <code>public.store_section</code> table reference
     */
    public StoreSection() {
        this("store_section", null);
    }

    /**
     * Create an aliased <code>public.store_section</code> table reference
     */
    public StoreSection(String alias) {
        this(alias, STORE_SECTION);
    }

    private StoreSection(String alias, Table<StoreSectionRecord> aliased) {
        this(alias, aliased, null);
    }

    private StoreSection(String alias, Table<StoreSectionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StoreSectionRecord> getPrimaryKey() {
        return Keys.STORE_SECTION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StoreSectionRecord>> getKeys() {
        return Arrays.<UniqueKey<StoreSectionRecord>>asList(Keys.STORE_SECTION_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreSection as(String alias) {
        return new StoreSection(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StoreSection rename(String name) {
        return new StoreSection(name, null);
    }
}
