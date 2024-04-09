# Ben 10 - Text Game

## Story
The game is based on TV series *Ben 10*. You play as Ben Tennyson, who departs with his grandpa Max and cousin Gwen on a summer trip. One day, while camping in a forest, he finds an alien device. The device looks like a watch and it enables the boy to change into any alien he chooses. He uses this power to fight hostile aliens and other adversaries, who threaten safety of Earth.   

## Game
You can start playing the game by running `Game.java` file.

### Gameplay
The game is entirely text-based. Each time you want to do something, you need to type in the desired action. 

#### **Examples of actions**
At the start you are choosing your starter alien by typing in the name from the shown list:
`[Heatblast, Fourarms, Stinkfly, Upchuck, Cannonbolt, Wildmutt, Diamondhead, XLR8, Ghostfreak, Ripjaws]`

Then you can pick between any of the main actions from the list:
`[Battle, Omnitrix, Heal, Explore, Backpack, Tutorial, Quit]`

#### **Actions describtion**
> Choosing **TUTORIAL** shows below describtion
Game has simple mechanics. You choose a starter alien and as you progress through the game you to scan more of them, 
enabling you to change into them and use them in a fight. Each alien has their own strengths and weaknesses, so choose them wisely.

**BATTLE**
During your travel you're constantly transformed into your starter alien. So, whenever you start a BATTLE, if you wish to fight as any other
alien you scanned before (different from your starter) you should input YES when prompted about transforming.

Attacks of aliens you use should be written in one word on input, for example: 'DIAMOND CAGE' attack should be written as 'DIAMONDCAGE'.
On the other hand, the names of aliens you wish to BATTLE as and states you wish to EXPLORE should be written with appropriate space, 
for example 'GREY MATTER' or 'NEW YORK' should be written with the space.

**TYPES**
Each alien has a type. Type defines the nature of an alien, some natures are stronger against other and vice versa.
For example: Heatblast is a FIRE type alien, so he is naturally stronger against WILDVINE, who is GRASS type and so on. 
Every alien should have a type countering him, but what are those counters you'll find out while playing.

**STATUS**
Some attacks may apply STATUSes on other aliens. Those STATUSes last only one attack (the one assigned to giving a status). 
Each one has a following effect:
- BURN         - target loses SPECIAL DEFENSE and user gains SPECIAL ATTACK
- FREEZE       - target loses SPECIAL ATTACK and user gains SPECIAL ATTACK
- CONFUSION    - target loses ATTACK and user gains DEFENSE
- PARALYZE     - target loses SPECIAL ATTACK and user gains SPECIAL DEFENSE
- POISON       - target loses ATTACK and user gains ATTACK
- SEED         - target loses SPECIAL DEFENSE and user gains SPECIAL DEFENSE
- SLEEP        - target loses SPECIAL DEFENSE and user keeps his stats

In the main menu of the game there are several options available:
- BATTLE   - finds you an enemy whom you might fight,
- OMNITRIX - displays your current Omnitrix data, in other words - the aliens you're able to transform into,
- HEAL     - heals your whole party, although your starter is automatically healed after each battle,
- EXPLORE  - makes you explore the nearby area in order to find items or NPCs to talk to,
- BACKPACK - opens your backpack, collectibles are stored there (they're not unique - so you can have multiple of same items),
- TUTORIAL - (you're here) short explanation of your options in the game,
- QUIT     - quits the game.

## Technical Details
Classes, functions, etc. are described in the `ben10_opis.pdf` (in polish), the class diagram can be seen in `ben10_diagram.png`. 

![ben10_diagram](https://github.com/czarekmilek/Ben10_TextGame/blob/main/ben10_diagram.png)
