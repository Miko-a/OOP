import java.util.ArrayList;

public class Salesitem {
    String itemName;
    int itemPrice;
    ArrayList<CommentType> commentVar;

    public Salesitem(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice; 
        commentVar = new ArrayList<>();
    }

    public boolean addComment(String author, String text, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Sorry '" + author + "', the rating " + rating + " is invalid, please enter between 1 - 5");
            return false;
        }
        
        // Check if the author has commented
        
        if (!commentVar.isEmpty()){
            for (CommentType i : commentVar) {
                if (i.getAuthor().equals(author)) {
                    System.out.println("I'm sorry '" + author + "', you've already left a comment.");
                    return false;
                }
            }
        }

        CommentType newComment = new CommentType(author, text, rating);
        commentVar.add(newComment);

        return true;
    }

    public boolean removeComment(CommentType commentWantToDelete) {
        System.out.println("Comment removed!");
        return commentVar.remove(commentWantToDelete);
    }

    public int getNumberOfComments() {
        return commentVar.size();
    }

    public void showInfo() {
        System.out.println("=======================================");
        System.out.println("Item name: " + itemName);
        System.out.println("Price: " + itemPrice);
        System.out.println("Number of comments: " + getNumberOfComments());
        for (CommentType i : commentVar) {
            i.print();
            System.out.println();
        }
        System.out.println("=======================================");
    }

    public CommentType findMostHelpfulComment() {
        if (commentVar.isEmpty()) { return null;}

        CommentType best = commentVar.get(0);
        for (CommentType i : commentVar) {
            if (i.getVotesBalance() > best.getVotesBalance()) {
                best = i;
            }
        }
        return best;
    }
}
