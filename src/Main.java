void main() {
    List<Movie> movies = MovieData.load();

    // 1. Predicate: a test that returns true or false
    Predicate<Movie> isRecent = m -> m.year() >= 2015;
    Predicate<Movie> isGood = m -> m.rating() >= 8.0;

    // 2. Function: turns a Movie into a String
    Function<Movie, String> label = m -> m.title() + " (" + m.year() + ")";

    // 3. Consumer: receives a value and does something with it
    Consumer<String> printer = text -> IO.println(" - " + text);

    IO.println("Recent movies:");
    printMatching(movies, isRecent, label, printer);

    IO.println("Recent AND good:");
    printMatching(movies, isRecent.and(isGood), label, printer);

    IO.println("Not recent (method reference to print):");
    printMatching(movies, isRecent.negate(), Movie::title, System.out::println);

    // 4. Supplier: creates a value only when get() is called
    Supplier<Movie> defaultMovie = () -> new Movie("Unknown", "None", 0, 0.0, 0);
    Movie movie = defaultMovie.get();
    IO.println("Default movie: " + movie.title());

    // Extra: a Function chained with andThen
    Function<Movie, String> upperLabel = label.andThen(String::toUpperCase);
    IO.println("Extra: " + upperLabel.apply(movies.get(0)));
}

// one method, many behaviours: the lambdas decide what to filter, format and print
static void printMatching(List<Movie> movies, Predicate<Movie> filter,
                          Function<Movie, String> formatter, Consumer<String> output) {
    for (Movie movie : movies) {
        if (filter.test(movie)) {
            output.accept(formatter.apply(movie));
        }
    }
}
