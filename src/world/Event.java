package world;

import java.util.Random;
import java.util.Scanner;
import player.*;

public enum Event {
    DIALOGUE(new DialogueInteraction[]{
            new DialogueInteraction
                (
                    "(you meet Azmuth, the creator of the Omnitrix - he's here checking on how Ben is using his construction)" +
                    "\nAzmuth: (sternly) Hello, Ben Tennyson. I am not here to bask in the glory of my own genius. " +
                    "\nI am here because you are in possession of a device that should never have fallen into the hands of a mere child.",
                    new String[]{
                            "Ben: (defensively) Hey, I may be a kid, but I've never misused this thing. The Omnitrix is in good hands." +
                            "\nGwen: (calmly) Azmuth, we understand your concerns, but Ben has proven himself as a responsible and capable hero. He's been a big help fighting aliens here on Earth." +
                            "\nAzmuth: (reluctantly) I suppose actions do speak louder than words. But let me remind you, Ben Tennyson, the Omnitrix is a tool of immense power. It should be treated with utmost care and respect.",
                            "Ben: (nodding) I know, Azmuth. I've learned that the hard way. I've seen firsthand how the Omnitrix can cause chaos if not used responsibly. I've made mistakes, but I've also learned from them." +
                            "\nGwen: (supportively) We'll make sure to use the Omnitrix responsibly, Azmuth. We understand the weight of its power and the responsibility that comes with it." +
                            "\nAzmuth: (grudgingly) See that you do. The fate of the universe often hangs in the balance, and it is up to heroes like you to keep it safe. " +
                            "\nShould you ever lose sight of that, I will personally ensure the Omnitrix is removed from your possession."
                    }, "Azmuth: I will depart now, but if we meet again I'll be lecturing yet again..." +
                        "\n(Azmuth disappears, Ben and the rest get on moving too)"
            ),
            new DialogueInteraction
                    (
                            "(you meet Professor Paradox, a time traveler from the future - he's here keeping timeline in check)" +
                                    "\nProfessor Paradox: (smiling warmly) Ah, Benjamin Tennyson. Time has a funny way of bringing us together, doesn't it?",
                            new String[]{
                                    "Gwen: (curious) Professor, we've heard tales of your mastery over time. It's fascinating. How do you navigate through different timelines so effortlessly?" +
                                            "\nProfessor Paradox: (chuckling) Time is a puzzle, my dear Gwen. I've spent eons studying its intricate patterns and unlocking its secrets. But I must say, young Benjamin here has a unique relationship with time himself." +
                                            "\nBen: (grinning) Yeah, with the Omnitrix, I can travel through time and space. It's like having my own personal time machine." +
                                            "\nProfessor Paradox: (wise tone) Ah, the Omnitrix. A device with powers that extend far beyond what you comprehend, Benjamin...",
                                    "Professor Paradox: (smiling approvingly) I have faith in your growth and understanding, Benjamin. Time has a way of teaching us valuable lessons. Just remember, every action you take in the past affects the future in ways you may not anticipate." +
                                            "\nGwen: (thoughtfully) It's like a ripple effect, isn't it? One small change can create a tidal wave of consequences." +
                                            "\nProfessor Paradox: (nodding) Precisely, Gwen. Time is a delicate balance, and we must strive to preserve it. But fear not, for I am here to guide you, should you ever find yourselves tangled within the intricacies of temporal paradoxes." +
                                            "\nBen: (grateful) Thanks, Professor. It's reassuring to know that we have someone like you watching our backs."
                            }, "Professor Paradox: I will depart now, but we will meet again..." +
                            "\n(Ben, Gwen, and Professor Paradox part ways, continuing their adventures)"
                    )
    }),
    RIDDLE(new RiddleInteraction[]{
            new RiddleInteraction("What has to be broken before you can use it?", "Egg", "Sumo Card"),
            new RiddleInteraction("What is full of holes but still holds water?", "Sponge", "Sumo Card"),
            new RiddleInteraction("What goes up but never comes down?", "Age", "Sumo Card"),
            new RiddleInteraction("What gets bigger when more is taken away?", "Hole", "Sumo Card"),
            new RiddleInteraction("Where does today come before yesterday?", "Dictionary", "Sumo Card"),
            new RiddleInteraction("What goes up and down but doesn’t move?", "Staircase", "Sumo Card"),
            new RiddleInteraction("What can you catch, but not throw?", "Cold", "Sumo Card"),
            new RiddleInteraction("What has a head and a tail, but no body?", "Coin", "Sumo Card")
    }),
    FOUND_ITEM(new ItemInteraction[]{
            new ItemInteraction("Alien Device", "An unknown Alien Device. It's use is unkown yet, but it's better to keep it for now."),
            new ItemInteraction("Sumo Card", "A collectible Sumo Card. It's a part of the new series, which Ben is a fan of."),
            new ItemInteraction("Magic Artifact", "A strange Magic Artifact. Its power can be felt by just touching it, Gwen is collecting these."),
            new ItemInteraction("Void Shard", "A dangerous Void Shard. It's a remnant of using a Void Gun, used to store dangerous individuals in another dimension. \n" +
                    "Shards need to be stored safely or else someone might open a way back here for them.")
    });

    private Object interactions;

    Event(Object interactions) {
        this.interactions = interactions;
    }

    public Object getInteractions() {
        return interactions;
    }

    public void playInteraction() {
        if (interactions instanceof DialogueInteraction[]) {
            DialogueInteraction[] dialogueInteractions = (DialogueInteraction[]) interactions;
            if (dialogueInteractions.length > 0) {
                Random random = new Random();
                int index = random.nextInt(dialogueInteractions.length);
                DialogueInteraction interaction = dialogueInteractions[index];
                playDialogueInteraction(interaction);
            }
        } else if (interactions instanceof RiddleInteraction[]) {
            RiddleInteraction[] riddleInteractions = (RiddleInteraction[]) interactions;
            if (riddleInteractions.length > 0) {
                Random random = new Random();
                int index = random.nextInt(riddleInteractions.length);
                RiddleInteraction interaction = riddleInteractions[index];
                playRiddleInteraction(interaction);
            }
        } else if (interactions instanceof ItemInteraction[]) {
            ItemInteraction[] itemInteractions = (ItemInteraction[]) interactions;
            if (itemInteractions.length > 0) {
                Random random = new Random();
                int index = random.nextInt(itemInteractions.length);
                ItemInteraction interaction = itemInteractions[index];
                playItemInteraction(interaction);
            }
        }
    }

    private void playDialogueInteraction(DialogueInteraction interaction) {
        System.out.println("\n" + interaction.getDialogue());
        for (String question : interaction.getQuestions()) {
            System.out.println("\n" + question);
        }
        System.out.println("\n" + interaction.getEndDialogue());
    }

    private void playRiddleInteraction(RiddleInteraction interaction) {
        System.out.println("(You meet alien resembling a Sphinx, who travels the world asking riddles.) \nIt gives you a riddle:\n" + interaction.getRiddle());
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        if (userAnswer.equalsIgnoreCase(interaction.getAnswer())) {
            System.out.println("You solved the riddle. Your reward: " + interaction.getItem());
        } else {
            System.out.println("That is not the answer. Seek me again for another one.");
        }
    }

    private void playItemInteraction(ItemInteraction interaction) {
        System.out.println("You found an item: " + interaction.getItem());
        System.out.println("Description: " + interaction.getDescription());

        Item item = new Item(interaction.getItem(), interaction.getDescription());
    }


    private static class DialogueInteraction {
        private String dialogue;
        private String[] questions;
        private String endDialogue;

        public DialogueInteraction(String dialogue, String[] questions, String endDialogue) {
            this.dialogue = dialogue;
            this.questions = questions;
            this.endDialogue = endDialogue;
        }

        public String getDialogue() {
            return dialogue;
        }

        public String[] getQuestions() {
            return questions;
        }

        public String getEndDialogue() {
            return endDialogue;
        }
    }

    private static class RiddleInteraction {
        private String riddle;
        private String answer;
        private String item;

        public RiddleInteraction(String riddle, String answer, String item) {
            this.riddle = riddle;
            this.answer = answer;
            this.item = item;
        }

        public String getRiddle() {
            return riddle;
        }

        public String getAnswer() {
            return answer;
        }

        public String getItem() {
            return item;
        }
    }

    private static class ItemInteraction {
        private String item;
        private String description;

        public ItemInteraction(String item, String description) {
            this.item = item;
            this.description = description;
        }

        public String getItem() {
            return item;
        }

        public String getDescription() {
            return description;
        }
    }
}
