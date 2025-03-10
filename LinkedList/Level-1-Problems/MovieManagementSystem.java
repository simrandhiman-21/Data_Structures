class Movie{

    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;
    
    Movie(String title,String director,int year,double rating){
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;  
        this.next=null;
        this.prev=null;
    }
}

class MovieDoubleLinkedList{

    Movie head;
    Movie tail;

    // Add movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) head = tail = newMovie;
        else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Movie added at the beginning: " + title);
    }

    // Add movie at the end
    public void add(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) head = tail = newMovie;
        else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Movie added: " + title);
    }

    // Add movie at a specific position
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            add(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            if (temp.next != null) temp.next.prev = newMovie;
            temp.next = newMovie;
            newMovie.prev = temp;
            if (newMovie.next == null) tail = newMovie;
        }
        System.out.println("Movie added at position " + position + ": " + title);
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found: " + title);
    }

    // Display movies in forward order
    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.director + " - " + temp.year + " - " + temp.rating);
            temp = temp.next;
        }
    }

    // Display movies in reverse order
    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.director + " - " + temp.year + " - " + temp.rating);
            temp = temp.prev;
        }
    }

    // Search by Director or Rating
    public void searchByDirectorOrRating(String director, double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println(temp.title + " - " + temp.director + " - " + temp.year + " - " + temp.rating);
            }
            temp = temp.next;
        }
    }

    // Update movie rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for " + title + " to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found: " + title);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoubleLinkedList movieList = new MovieDoubleLinkedList();

        movieList.add("Movie1", "Director1", 2022, 9.0);
        movieList.addAtBeginning("Movie2", "Director2", 2021, 8.5);
        movieList.addAtPosition("Movie3", "Director3", 2020, 8.8, 1);

        System.out.println("\nMovies in Forward Order:");
        movieList.displayForward();

        System.out.println("\nMovies in Reverse Order:");
        movieList.displayReverse();

        System.out.println("\nSearching for movies by Director2 or rating 8.5:");
        movieList.searchByDirectorOrRating("Director2", 8.5);

        movieList.updateRating("Movie1", 9.5);
        movieList.removeByTitle("Movie2");

        System.out.println("\nFinal Movie List:");
        movieList.displayForward();
    }
}