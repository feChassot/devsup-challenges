package PlataformaDeEnsino.entities;

public class Task extends Lesson {
    private String description;
    private int questionCount;

    public Task() {
        super();
    }

    public Task(String title, String description, int questionCount) {
        super(title);
        this.description = description;
        this.questionCount = questionCount;
    }

    public String getDescription() {
        return description;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    @Override
    public int duration(){
        final int FIVE_MINUTES_TO_SECONDS = 300;
        return (FIVE_MINUTES_TO_SECONDS * questionCount);
    }
}
