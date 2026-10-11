package session_7_abstract_classes_and_interfaces.assignment_problem;

public abstract class ArtPiece {
    private static int counter = 1001;
    private final String pieceId;
    protected String title;

    public ArtPiece() {
        this.pieceId = "ART-" + (counter++);
    }

    public ArtPiece(String title) {
        this();
        this.title = title;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    public Painting(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    public Sculpture(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}
