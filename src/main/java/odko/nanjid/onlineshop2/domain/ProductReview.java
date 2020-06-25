package odko.nanjid.onlineshop2.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Buyer buyer;

    @Min(0)
    @Max(5)
    private int rating;

    @NotEmpty(message = "{Review.comment.validation}")
    @Size(min=10,message = "{Review.comment.size}")
    @Lob
    private String comment;

    private boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public ProductReview(){}

    public ProductReview(int rating, String comment, Buyer buyer) {
        this.rating = rating;
        this.comment = comment;
        this.buyer = buyer;
        this.enabled = false;
        this.createDate = new Date();
    }
    public ProductReview(int rating, String comment, Buyer buyer, Boolean enabled) {
        this.rating = rating;
        this.comment = comment;
        this.buyer = buyer;
        this.enabled = enabled;
        this.createDate = new Date();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int star) {
        this.rating = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
