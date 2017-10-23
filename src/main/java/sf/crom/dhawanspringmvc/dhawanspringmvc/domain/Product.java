package sf.crom.dhawanspringmvc.dhawanspringmvc.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class Product {
    Integer id;
    String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    BigDecimal price;
    String imageURL;

}
