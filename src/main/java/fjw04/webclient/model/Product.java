package fjw04.webclient.model;

public class Product {

    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;  // Nested class for rating

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Rating getRating() { return rating; }
    public void setRating(Rating rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", title='" + title + "', price=" + price +
                ", description='" + description + "', category='" + category +
                "', image='" + image + "', rating=" + rating + "}";
    }

    // Nested Rating class
    public static class Rating {
        private double rate;
        private int count;

        public double getRate() { return rate; }
        public void setRate(double rate) { this.rate = rate; }

        public int getCount() { return count; }
        public void setCount(int count) { this.count = count; }

        @Override
        public String toString() {
            return "Rating{rate=" + rate + ", count=" + count + "}";
        }
    }
}

