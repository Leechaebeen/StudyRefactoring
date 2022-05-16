package me.whiteship.refactoring._03_long_function._13_replace_conditional_with_polymorphism;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MarkdownPrinter extends StudyPrinter
{

    public MarkdownPrinter(int totalNumberOfEvents, List<Participant> participants)
    {
        super(totalNumberOfEvents, participants);
    }

    @Override
    public void execute() throws IOException
    {
        try (FileWriter fileWriter = new FileWriter("participants.md");
             PrintWriter writer = new PrintWriter(fileWriter)) {

            writer.print(header(this.participants.size()));

            this.participants.forEach(p -> {
                String markdownForHomework = getMarkdownForParticipant(p);
                writer.print(markdownForHomework);
            });
        }
    }

    private String getMarkdownForParticipant(Participant p) {
        return String.format("| %s %s | %.2f%% |\n", p.username(), checkMark(p),
                p.getRate(this.totalNumberOfEvents));
    }
}
