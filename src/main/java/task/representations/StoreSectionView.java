package task.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import task.db.tables.pojos.StoreSection;

/**
 * Created by aleksandr on 21.10.2017.
 */
public class StoreSectionView {
    private final Long id;
    private final String name;

    @JsonCreator
    public StoreSectionView(@JsonProperty Long id, @JsonProperty String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public static StoreSectionView fromEntity(StoreSection section) {
        return new StoreSectionView(
                section.getId(),
                section.getName()
        );
    }
}
