package project.dsprojectwebapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

public class Card {

    private final UUID id;
    private String description;
    private String imagePath;
    private List<String> tagsList;

    public static String DEFAULT_IMAGE_PATH = "/images/default.jpg";

    public Card(UUID id, String description, String path, List<String> tags) {
        this.id = id;
        this.description = description;
        imagePath = path;
        tagsList = tags;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List getTagsList() {
        return tagsList;
    }
}
