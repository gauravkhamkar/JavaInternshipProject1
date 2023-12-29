import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Question class to represent quiz questions
class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

// Quiz class to manage a collection of questions
class Quiz {
    private List<Question> questions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
            List<String> options = currentQuestion.getOptions();

            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectOption() + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + " out of " + questions.size());
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        // Sample questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                List.of("Berlin", "Madrid", "Paris", "Rome"), 3));
        questions.add(new Question("Which programming language is this quiz written in?",
                List.of("Java", "Python", "C++", "JavaScript"), 1));
        questions.add(new Question("What is the largest mammal?",
                List.of("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 2));

        // Create a quiz
        Quiz quiz = new Quiz(questions);

        // Start the quiz
        quiz.startQuiz();
    }
}
