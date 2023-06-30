package world;

import java.util.Random;
import java.util.Scanner;
import player.Item;

public enum Event {
    DIALOGUE(new DialogueInteraction[]{
            new DialogueInteraction
                (
                    "(you meet Azmuth, the creator of the Omnitrix - he's here checking on how Ben is using his construction)" +
                    "\nAzmuth: (sternly) Hello, Ben Tennyson. I am not here to bask in the glory of my own genius. " +
                    "\n        I am here because you are in possession of a device that should never have fallen into the hands of a mere child.",
                    new String[]{
                            "   Ben: (defensively) Hey, I may be a kid, but I've never misused this thing. The Omnitrix is in good hands." +
                            "\n  Gwen: (calmly) Azmuth, we understand your concerns, but Ben has proven himself as a responsible and capable hero. He's been a big help fighting aliens here on Earth." +
                            "\nAzmuth: (reluctantly) I suppose actions do speak louder than words. But let me remind you, Ben Tennyson, the Omnitrix is a tool of immense power. It should be treated with utmost care and respect.",
                            "   Ben: (nodding) I know, Azmuth. I've learned that the hard way. I've seen firsthand how the Omnitrix can cause chaos if not used responsibly. I've made mistakes, but I've also learned from them." +
                            "\n  Gwen: (supportively) We'll make sure to use the Omnitrix responsibly, Azmuth. We understand the weight of its power and the responsibility that comes with it." +
                            "\nAzmuth: (grudgingly) See that you do. The fate of the universe often hangs in the balance, and it is up to heroes like you to keep it safe. " +
                            "\n        Should you ever lose sight of that, I will personally ensure the Omnitrix is removed from your possession."
                    }, "Azmuth: I will depart now, but if we meet again I'll be lecturing yet again..." +
                        "\n(Azmuth disappears, Ben and the rest get on moving too)"
            ),
            new DialogueInteraction
                    (
                            "(you meet Professor Paradox, a time traveler from the future - he's here keeping timeline in check)" +
                                    "\nProfessor Paradox: (smiling warmly) Ah, Benjamin Tennyson. Time has a funny way of bringing us together, doesn't it?",
                            new String[]{
                                    "             Gwen: (curious) Professor, we've heard tales of your mastery over time. It's fascinating. How do you navigate through different timelines so effortlessly?" +
                                            "\nProfessor Paradox: (chuckling) Time is a puzzle, my dear Gwen. I've spent eons studying its intricate patterns and unlocking its secrets. But I must say, young Benjamin here has a unique relationship with time himself." +
                                            "\n              Ben: (grinning) Yeah, with the Omnitrix, I can travel through time and space. It's like having my own personal time machine." +
                                            "\nProfessor Paradox: (wise tone) Ah, the Omnitrix. A device with powers that extend far beyond what you comprehend, Benjamin...",
                                    "Professor Paradox: (smiling approvingly) I have faith in your growth and understanding, Benjamin. Time has a way of teaching us valuable lessons. Just remember, every action you take in the past affects the future in ways you may not anticipate." +
                                            "\n             Gwen: (thoughtfully) It's like a ripple effect, isn't it? One small change can create a tidal wave of consequences." +
                                            "\nProfessor Paradox: (nodding) Precisely, Gwen. Time is a delicate balance, and we must strive to preserve it. But fear not, for I am here to guide you, should you ever find yourselves tangled within the intricacies of temporal paradoxes." +
                                            "\n              Ben: (grateful) Thanks, Professor. It's reassuring to know that we have someone like you watching our backs."
                            }, "Professor Paradox: I will depart now, but we will meet again..." +
                            "\n(Ben, Gwen, and Professor Paradox part ways, continuing their adventures)"
                    ),
            new DialogueInteraction
                    (
                    "     Ben 10: Hey, Grandpa Max. I've always admired your wisdom and experience. I know you've had your fair share of adventures before I even found the Omnitrix. Can you tell me more about your past?\n" +
                            "Grandpa Max: Ah, my past. Well, Ben, I've been involved in quite a few extraordinary situations throughout my life. " +
                            "\n             Before we embarked on our current journey, I was a part of a secret organization known as the Plumbers.\n" +
                            "     Ben 10: The Plumbers? That sounds mysterious. What exactly did they do?\n" +
                            "Grandpa Max: The Plumbers were a group of highly skilled individuals dedicated to protecting the Earth from extraterrestrial threats." +
                            "             We dealt with everything from rogue aliens to interdimensional anomalies. It was a dangerous but fulfilling line of work.",
                        new String[]{
                                        "     Ben 10: That's amazing, Grandpa! You were like a superhero even before I became Ben 10. What kind of adventures did you have?\n" +
                                        "Grandpa Max: Oh, we had countless adventures, Ben. From investigating alien artifacts to foiling the plans of intergalactic criminals. " +
                                        "\n             We traveled to different parts of the world and beyond, encountering all sorts of creatures and phenomena.\n" +
                                        "     Ben 10: Did you have any favorite or memorable encounters during your time as a Plumber?\n" +
                                        "Grandpa Max: There are so many to choose from, but one of the most memorable was when I faced off against a powerful interdimensional warlord named Vilgax. " +
                                        "\n             He was a formidable opponent, and it took everything we had to stop him.\n" +
                                        "Grandpa Max: That's right, Ben. Vilgax was a constant threat, and he had his sights set on Earth. I spent years " +
                                        "\n             trying to thwart his plans and protect our planet. It was a battle of wits and strength, but we managed to outsmart him time and time again.\n" +
                                        "     Ben 10: Wow, Grandpa. You're a true hero. It's incredible to think that you've been fighting the good fight for so long. I feel honored to carry on the legacy.\n" +
                                        "Grandpa Max: Thank you, Ben. But remember, heroism isn't just about battles and victories. It's about making a positive impact," +
                                        "\n             no matter how small. The world needs heroes like you, who can face challenges with courage and compassion.\n" +
                                        "     Ben 10: I won't let you down, Grandpa. I'll do my best to live up to the legacy you've created and protect the Earth just like you did. Together, we'll continue to make a difference.\n" +
                                        "Grandpa Max: I have no doubt about that, Ben. Our family's legacy is built on bravery, compassion, " +
                                        "\n             and the belief that one person can change the world. I'm proud to have you as my partner in this journey."
                        },
                            "     Ben 10: And I'm proud to have you as my grandpa and mentor. " +
                            "\n             Thanks for sharing your past with me, Grandpa Max. Let's keep making memories and facing new adventures together.\n" +
                            "Grandpa Max: Absolutely, Ben. The future is full of possibilities, and I can't wait to see what lies ahead for us. " +
                            "\n             Let's go out there and show the world what we're capable of."
                        )
    }),
    RIDDLE(new RiddleInteraction[]{
            new RiddleInteraction("What has to be broken before you can use it?", "Egg", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What is full of holes but still holds water?", "Sponge", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What goes up but never comes down?", "Age", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What gets bigger when more is taken away?", "Hole", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("Where does today come before yesterday?", "Dictionary", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What goes up and down but doesn’t move?", "Staircase", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What can you catch, but not throw?", "Cold", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What goes all the way around the world but stays in a corner?", "Stamp", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What has a head and a tail, but no body?", "Coin", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx."),
            new RiddleInteraction("What gets wet when drying?", "Towel", "Sumo Card", "A collectible Sumo Card, reward for completing riddles of Sphinx.")
    }),
    FOUND_ITEM(new ItemInteraction[]{
            new ItemInteraction("Alien Device", "An unknown Alien Device. It's use is unkown yet, but it's better to keep it for now."),
            new ItemInteraction("Action-Man Figure MK1", "A collectible Action-Man figure. It's a part of the new MK series, which Ben is a fan of."),
            new ItemInteraction("Action-Man Figure MK2", "A collectible Action-Man figure. It's a part of the new MK series, which Ben is a fan of."),
            new ItemInteraction("Action-Man Figure MK3", "A collectible Action-Man figure. It's a part of the new MK series, which Ben is a fan of."),
            new ItemInteraction("Magic Power Artifact", "A strange Magic Power Artifact. Its power can be felt by just touching it, Gwen is collecting these."),
            new ItemInteraction("Magic Endurance Artifact", "A strange Magic Endurance Artifact. Its power can be felt by just touching it, Gwen is collecting these."),
            new ItemInteraction("Magic Perception Artifact", "A strange Magic Perception Artifact. Its power can be felt by just touching it, Gwen is collecting these."),
            new ItemInteraction("Magic Intelligence Artifact", "A strange Magic Intelligence Artifact. Its power can be felt by just touching it, Gwen is collecting these."),
            new ItemInteraction("Magic Charisma Artifact", "A strange Magic Charisma Artifact. Its power can be felt by just touching it, Gwen is collecting these."),
            new ItemInteraction("Magic Luck Artifact", "A strange Magic Luck Artifact. Its power can be felt by just touching it, Gwen is collecting these."),
            new ItemInteraction("Void Shard", "A dangerous Void Shard. It's a remnant of using a Void Gun, used to store dangerous individuals in another dimension."),
            new ItemInteraction("Stabilised Void Shard", "A stabilised Void Shard. It's a remnant of using a Void Gun, used to store dangerous individuals in another dimension."),
            new ItemInteraction("Unstable Void Shard", "An unstable Void Shard. It's a remnant of using a Void Gun, used to store dangerous individuals in another dimension."),
            new ItemInteraction("Mango Smoothie", "A mango flavored smoothie from Mr. Smoothie, Ben 10's favorite!"),
            new ItemInteraction("Banana Smoothie", "A banana flavored smoothie from Mr. Smoothie, Ben 10's favorite!"),
            new ItemInteraction("Peach Smoothie", "A peach flavored smoothie from Mr. Smoothie, Ben 10's favorite!"),
            new ItemInteraction("Pineapple Smoothie", "A pineapple flavored smoothie from Mr. Smoothie, Ben 10's favorite!"),
            new ItemInteraction("Watermelon Smoothie", "A watermelon flavored smoothie from Mr. Smoothie, Ben 10's favorite!"),
            new ItemInteraction("Orange Smoothie", "A orange flavored smoothie from Mr. Smoothie, Ben 10's favorite!"),
            new ItemInteraction("Regular Chili Fries", "Regular chili fries, Ben 10's favorite!"),
            new ItemInteraction("Hot Chili Fries", "Hot chili fries, Ben 10's favorite!"),
            new ItemInteraction("Super Hot Chili Fries", "Super Hot chili fries, Ben 10's favorite!"),
            new ItemInteraction("Magma Hot Chili Fries", "Magma Hot chili fries, Ben 10's favorite!"),
            new ItemInteraction("Infernal Hell Chili Fries", "Infernal Hell chili fries, Ben 10's favorite!")
    });

    private Object interactions;

    Event(Object interactions) {
        this.interactions = interactions;
    }

    public Object getInteractions() {
        return interactions;
    }

    /**
     * Obsługuje rodzaje interakcji ze światem
     */
    public Item playInteraction() {
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
                Item item = new Item(interaction.getItem(), interaction.getDescription());
                if(playRiddleInteraction(interaction) == true) {
                    return item;
                }
                else {
                    return new Item("Tear of Sphinx", "Magic tears of Sphinx, a 'reward' for not completing Sphinx's riddles.");
                }
            }
        } else if (interactions instanceof ItemInteraction[]) {
            ItemInteraction[] itemInteractions = (ItemInteraction[]) interactions;
            if (itemInteractions.length > 0) {
                Random random = new Random();
                int index = random.nextInt(itemInteractions.length);
                ItemInteraction interaction = itemInteractions[index];
                playItemInteraction(interaction);
                Item item = new Item(interaction.getItem(), interaction.getDescription());
                return item;
            }
        }
        //testing item
        return new Item("Null", "Literally nothing.");
    }

    private void playDialogueInteraction(DialogueInteraction interaction) {
        System.out.println("\n" + interaction.getDialogue());
        for (String question : interaction.getQuestions()) {
            System.out.println("\n" + question);
        }
        System.out.println("\n" + interaction.getEndDialogue());
    }

    private boolean playRiddleInteraction(RiddleInteraction interaction) {
        System.out.println("(You meet alien resembling a Sphinx, who travels the world asking riddles.) \nIt gives you a riddle:\n" + interaction.getRiddle());
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        if (userAnswer.equalsIgnoreCase(interaction.getAnswer())) {
            System.out.println("You solved the riddle. Your reward: " + interaction.getItem());
            return true;
        } else {
            System.out.println("That is not the answer. Seek me again for another one.");
            return false;
        }
    }

    private void playItemInteraction(ItemInteraction interaction) {
        System.out.println("You found an item: " + interaction.getItem());
        System.out.println("Description: " + interaction.getDescription());
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
        private String description;

        public RiddleInteraction(String riddle, String answer, String item, String description) {
            this.riddle = riddle;
            this.answer = answer;
            this.item = item;
            this.description = description;
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
        public String getDescription() {
            return description;
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
