/*
 * This file is generated by jOOQ.
*/
package task.db.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;

import task.db.enums.TaskStatus;
import task.db.tables.Task;


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
public class TaskRecord extends UpdatableRecordImpl<TaskRecord> implements Record11<Long, String, String, TaskStatus, Boolean, Boolean, Boolean, Long, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = -1413986215;

    /**
     * Setter for <code>public.task.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.task.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.task.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.task.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.task.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.task.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.task.status</code>.
     */
    public void setStatus(TaskStatus value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.task.status</code>.
     */
    public TaskStatus getStatus() {
        return (TaskStatus) get(3);
    }

    /**
     * Setter for <code>public.task.urgent</code>.
     */
    public void setUrgent(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.task.urgent</code>.
     */
    public Boolean getUrgent() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>public.task.appeal</code>.
     */
    public void setAppeal(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.task.appeal</code>.
     */
    public Boolean getAppeal() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>public.task.template</code>.
     */
    public void setTemplate(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.task.template</code>.
     */
    public Boolean getTemplate() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>public.task.section_id</code>.
     */
    public void setSectionId(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.task.section_id</code>.
     */
    public Long getSectionId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.task.creation_time</code>.
     */
    public void setCreationTime(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.task.creation_time</code>.
     */
    public Timestamp getCreationTime() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>public.task.duetime</code>.
     */
    public void setDuetime(Timestamp value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.task.duetime</code>.
     */
    public Timestamp getDuetime() {
        return (Timestamp) get(9);
    }

    /**
     * Setter for <code>public.task.creator_username</code>.
     */
    public void setCreatorUsername(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.task.creator_username</code>.
     */
    public String getCreatorUsername() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, TaskStatus, Boolean, Boolean, Boolean, Long, Timestamp, Timestamp, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, TaskStatus, Boolean, Boolean, Boolean, Long, Timestamp, Timestamp, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Task.TASK.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Task.TASK.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Task.TASK.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<TaskStatus> field4() {
        return Task.TASK.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return Task.TASK.URGENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field6() {
        return Task.TASK.APPEAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return Task.TASK.TEMPLATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return Task.TASK.SECTION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return Task.TASK.CREATION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field10() {
        return Task.TASK.DUETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Task.TASK.CREATOR_USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskStatus value4() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getUrgent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value6() {
        return getAppeal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getTemplate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getSectionId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getCreationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value10() {
        return getDuetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getCreatorUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value4(TaskStatus value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value5(Boolean value) {
        setUrgent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value6(Boolean value) {
        setAppeal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value7(Boolean value) {
        setTemplate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value8(Long value) {
        setSectionId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value9(Timestamp value) {
        setCreationTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value10(Timestamp value) {
        setDuetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord value11(String value) {
        setCreatorUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskRecord values(Long value1, String value2, String value3, TaskStatus value4, Boolean value5, Boolean value6, Boolean value7, Long value8, Timestamp value9, Timestamp value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TaskRecord
     */
    public TaskRecord() {
        super(Task.TASK);
    }

    /**
     * Create a detached, initialised TaskRecord
     */
    public TaskRecord(Long id, String name, String description, TaskStatus status, Boolean urgent, Boolean appeal, Boolean template, Long sectionId, Timestamp creationTime, Timestamp duetime, String creatorUsername) {
        super(Task.TASK);

        set(0, id);
        set(1, name);
        set(2, description);
        set(3, status);
        set(4, urgent);
        set(5, appeal);
        set(6, template);
        set(7, sectionId);
        set(8, creationTime);
        set(9, duetime);
        set(10, creatorUsername);
    }
}
