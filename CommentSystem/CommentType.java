public class CommentType {
    private String Author;
    private String text;
    private int rating;
    private int upVotes;
    private int downVotes;

    public CommentType(String Author, String text, int rating) {
        this.Author = Author;
        this.text = text;
        this.rating = rating;

        upVotes = downVotes = 0;
    }

    public String getAuthor() { return Author;}

    public void upvote() {
        upVotes++;
    }

    public void downvote() {
        downVotes++;
    }

    public int getVotesBalance() {
        return upVotes - downVotes;
    }

    public void print() {
        System.out.println("\tAuthor: " + Author);
        System.out.println("\tRating: " + rating);
        System.out.println("\tComent: " + text);
        System.out.println("\tVotes: " + getVotesBalance());
    }
}
