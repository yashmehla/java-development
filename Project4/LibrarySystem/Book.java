public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String toFileString() {
        return title + "|" + author;
    }
    public static Book fromFileString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 2) {
            return new Book(parts[0], parts[1]);
        }
        return null;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}
