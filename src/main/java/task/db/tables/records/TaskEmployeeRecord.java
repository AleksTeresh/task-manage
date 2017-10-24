/*
 * This file is generated by jOOQ.
*/
package task.db.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;

import task.db.tables.TaskEmployee;


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
public class TaskEmployeeRecord extends TableRecordImpl<TaskEmployeeRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = -708501620;

    /**
     * Setter for <code>public.task_employee.task_id</code>.
     */
    public void setTaskId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.task_employee.task_id</code>.
     */
    public Long getTaskId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.task_employee.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.task_employee.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return TaskEmployee.TASK_EMPLOYEE.TASK_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TaskEmployee.TASK_EMPLOYEE.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getTaskId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskEmployeeRecord value1(Long value) {
        setTaskId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskEmployeeRecord value2(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskEmployeeRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TaskEmployeeRecord
     */
    public TaskEmployeeRecord() {
        super(TaskEmployee.TASK_EMPLOYEE);
    }

    /**
     * Create a detached, initialised TaskEmployeeRecord
     */
    public TaskEmployeeRecord(Long taskId, String username) {
        super(TaskEmployee.TASK_EMPLOYEE);

        set(0, taskId);
        set(1, username);
    }
}