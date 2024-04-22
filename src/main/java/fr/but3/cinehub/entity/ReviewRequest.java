package fr.but3.cinehub.entity;

public class ReviewRequest {
    private Long userId;
    private float rating;
    private String comment;
    
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "ReviewRequest [userId=" + userId + ", rating=" + rating + ", comment=" + comment + "]";
    }

    
}
