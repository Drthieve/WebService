package gov.iti.jets.soap.services.dtos;

import gov.iti.jets.domain.models.Category;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

@XmlRootElement(name = "category")
@XmlType(propOrder = {"identifier", "name"})
public class CategoryDto implements Serializable {
    private Integer identifier;
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(int identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public CategoryDto(Category category) {
        this.identifier = category.getId();
        this.name = category.getName();
    }

    @XmlElement(name = "id")
    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + identifier + ", " +
                "name = " + name + ")";
    }
}
