import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.*;

public class Game {
    private static int trollHealth = 100;
    private static int vertusHealth = 140;
    private static int urnilHealth=180;
    private static int playerLevel=1;
    private static int playerHealth = 100 ;
    private static String playerWeapon="fists";
    private static int knifeDamage=30;
    private static int basicDamage=5;
    private static int swordDamage=40;
    private static boolean v=true;

    public void playerSetUp() {

        System.out.println("Welcome to Zork1.2.2");
        System.out.println("Your Level:"+ playerLevel);
        System.out.println("Your HP: " + playerHealth);
        System.out.println("Your Weapon: " + playerWeapon);

    }
    public int saveloadgame()throws IOException{
        File file = new File("C:\\Users\\pan_d\\Documents\\Zork\\savefilezork.txt");
        Scanner sc = new Scanner(file);
        Scanner input = new Scanner(System.in);
        String answer;
        int iout=0;
        if (file.length()!=0){
            System.out.println("There is save file...Do you want to load previous game ??");
            answer = input.nextLine();
            if (answer.equals("Yes")||answer.equals("yes")){
                iout=load();
            }
            else
                System.out.println("Ok then we start a new game !! Good luck <3");
        }
        return iout;

    }

    public static void main(String[] args) throws IOException{

        int room;
        Game game;
        game = new Game();
        game.startingtitle();
        room=game.saveloadgame();
        game.playerSetUp();
        do {
            switch (room) {
                case 0:
                    room = game.house();
                    break;
                case 1:
                    room = game.forest();
                    break;
                case 2:
                    room = game.cave();
                    break;
                case 3:
                    room = game.city();
                    break;
                case 4:
                    room=game.tavern();
                    break;
                case 5:
                    room=game.castle();
                    break;
                case 6:
                    room=game.swamps();
                    break;
                case 7:
                    room=game.darkcave();
                    break;
                case 8:
                    room=game.vertus();
                    break;
                case 9:
                    room=game.village();
                    break;
                case 10:
                    room=game.tavernv();
                    break;
                case 11:
                    room=game.harbor();
                    break;
                case 12:
                    room=game.punika();
                    break;
                case 13:
                    room=game.urnil();
                    break;
            }
        } while (room != 14);
    }


    public static void startingtitle(){
        System.out.println("For 500 years Arkesia and its people have enjoyed peace.");
        System.out.println("The have forgotten the war between gods and demons that tore their world apart");
        System.out.println("But the peace dont last forever.");
        System.out.println("Creatures of the Darkness are rising again!");
        System.out.println("You are are the only one who can help Queen Ealyn of Vern");
        System.out.println("Lets start your journey in the land of Arkesia");
        System.out.println(" ");
        System.out.println("You can save the game in the Forest, City of Vern, Swamps and the Village.");
        System.out.println("Just type save or save game");
        System.out.println(" ");

    }

    public static int house() {
        boolean key = false;
        boolean locked = true;
        boolean next = true;
        Scanner input = new Scanner(System.in);
        String answer;
        String face="c";
        System.out.println("You are in a very old house");
        System.out.println("The smell is really bad in here!");
        System.out.println("Find a way to get out");
        System.out.println(" ");
        while (next) {
            answer = input.nextLine();
            if (answer.equals("go west") || answer.equals("go east") || answer.equals("go south") || answer.equals("go north")) {
                if (answer.equals("go west")) {
                    System.out.println("You are in front of a window");
                    System.out.println("You look outside and its raining");
                    System.out.println("The sound of thunder gaze the land");
                    System.out.println(" ");
                    face = "w";
                }
                if (answer.equals("go south")) {
                    System.out.println("Its just a wall.Nothing to see here!");
                    System.out.println("Oh wait something is shining... \n "+"It's a knife!");
                    System.out.println("Do you want to pick it up? ");
                    System.out.println(" ");
                    face = "s";
                }
                if (answer.equals("go east")) {
                    System.out.println("The is a drawer in front of you.");
                    System.out.println("The is a photo of a family with 3 kids");
                    System.out.println("Also there is a golden key");
                    System.out.println(" ");
                    face = "e";
                }
                if (answer.equals("go north")) {
                    System.out.println("You are on front of a wooden door");
                    System.out.println(" ");
                    face = "n";
                }
            } else if (answer.equals("take key") && face.equals("e")) {
                System.out.println("You put the key in you pocket");
                System.out.println("It may useful for later.");
                System.out.println(" ");
                key = true;
            } else if (answer.equals("use key") && face.equals("n")) {
                if (key) {
                    System.out.println("You have unlocked the door");
                    System.out.println(" ");
                    locked = false;
                } else
                    System.out.println("You dont have a key on you");

            } else if (answer.equals("open door")) {
                if (locked) {
                    System.out.println("You cant open the door");
                    System.out.println("The door is locked!");
                    System.out.println("You need a key to open the door");
                    System.out.println(" ");
                } else {
                    System.out.println("You are leaving the house");
                    System.out.println(" ");
                    next = false;
                }
            }
            else if (answer.equals("pick knife")&&(face.equals("s"))) {
                System.out.println("You picked up the knife");
                playerWeapon = "knife";
                System.out.println("Your current weapon is " + playerWeapon + " and the damage it's dealing is 30 ");
                System.out.println(" ");
            }
            else
                System.out.println("This command is not valid!");
        }
        return 1;
    }



    public static int forest() throws IOException {
        Scanner input = new Scanner(System.in);
        String answer;
        boolean next = true;
        int iout=50;
        String face = "c";
        System.out.println("You are now in a forest");
        System.out.println("It is raining.");
        System.out.println("");
        while (next) {
            answer = input.nextLine();
            if (answer.equals("go west") || answer.equals("go east") || answer.equals("go south") || answer.equals("go north")) {
                if (answer.equals("go west")) {
                    System.out.println("You see tall trees around you");
                    System.out.println("There is a sign hanging from a tree");
                    face = "w";
                }
                if (answer.equals("go south")) {
                    System.out.println("Do you want return to the house?");
                    face = "s";
                }
                if (answer.equals("go east")) {
                    System.out.println("You see a entrace of a cave");
                    System.out.println("Do you enter? Yes or No ?");
                    face = "e";
                }
                if (answer.equals("go north")) {
                    System.out.println("You see a Castle in the near distance");
                    System.out.println("Do you want to go to the city? Yes or No ?");
                    face = "n";
                }
            }
            else if (answer.equals("read sign") && face.equals("w")) {
                System.out.println("DANGER");
                System.out.println("Do not enter the cave");
                System.out.println("Something bad is living there!");
            }
            else if (answer.equals("Yes") && face.equals("s")) {
                System.out.println("You are entering the house.");
                next = false;
                iout = 0;
            }
            else if (answer.equals("No") &&  face.equals("s")) {
                System.out.println("You are staying in the forest center");
                face = "c";
            }
            else if (answer.equals("Yes") &&  face.equals("e")) {
                System.out.println("You are entering the Cave!");
                iout = 2;
                next=false;
            }
            else if (answer.equals("No") &&  face.equals("e")) {
                System.out.println("You are staying in the forest center");
                face = "c";
            }
            else if (answer.equals("Yes") &&  face.equals("n")) {
                System.out.println("You are headed to the Castle");
                iout = 3;
                next=false;
            }
            else if (answer.equals("No") &&  face.equals("n")) {
                System.out.println("You are staying in the forest center");
                face = "c";
            }
            else if (answer.equals("save")||answer.equals("save game")){
                FileWriter fstream = new FileWriter ("C:\\Users\\pan_d\\Documents\\Zork\\savefilezork.txt");
                BufferedWriter info = new BufferedWriter(fstream);
                info.write(String.valueOf(1));
                info.newLine();
                info.write(String.valueOf(playerHealth));
                info.newLine();
                info.write(String.valueOf(playerLevel));
                info.newLine();
                info.write(playerWeapon);
                info.close();
                System.out.println("Your progress has saved!");
            }
            else
                System.out.println("This command is not valid!");
        }
        return iout;
    }

    public static int cave() {
        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("You are now in the Cave");
        System.out.println("A smell of rotten bodies is in your nose");
        System.out.println("Sound of a growling creature is coming towards you");
        System.out.println("A troll came from the dark!!");
        System.out.println("Are you brave enough to atack the monster or you run away?");
        int hp=playerHealth;
        do {
            System.out.println("What are you gonna do? : ");
            answer = input.nextLine();
            if (answer.startsWith("run")){
                System.out.println("You chickened out!!");
                break;
            }
            if (answer.startsWith("attack")){
                if (playerWeapon.equals("fists")) {
                    System.out.println("You attack the troll with your fists!");
                    System.out.println("You have done :" + basicDamage + " damage");
                    trollHealth = trollHealth - basicDamage;
                    System.out.println("The troll has" + trollHealth + "HP left! \n");
                }
                else if (playerWeapon.equals("knife")){
                    System.out.println("You attack the troll with your knife!");
                    System.out.println("You have done: "+knifeDamage+" damage");
                    trollHealth =  trollHealth - knifeDamage;
                    System.out.println("The troll has : "+trollHealth+" HP left! \n");
                }
                if (trollHealth>0){
                    int dmg = (int)(Math.random()*(10-5)+5);
                    hp= hp-dmg;
                    System.out.println("The troll has done: "+dmg+"damage to you! \n"+"You have : "+hp
                            +"HP left! \n");
                }
                if (hp<=0){
                    System.out.println("You have died! \n"+"Game Over!");
                    System.exit(0);
                }
            }
            else
                System.out.println("This command is not valid");

        } while (trollHealth>=1);
        if (trollHealth<=0) {
            playerLevel = playerLevel + 1;
            System.out.println("You have defeated the troll of the Cave! \n" + " Your level now is : " + playerLevel);
            playerHealth = playerHealth + 20;
            System.out.println("Your Health is now :" + playerHealth);
            trollHealth = 100;
        }
        return 1;
    }

    public static int city()throws IOException{
        Scanner input = new Scanner(System.in);
        String answer;
        boolean next= true;
        String face= "c";
        int iout=50;
        System.out.println("You are in front of the main gate of the Castle.");
        System.out.println("The are no guards.");
        System.out.println("You entered the Castle of Vern");
        System.out.println("The Castle is under the leadership of Queen Ealyn");
        System.out.println("This place is welcome to all the races of Arkesia");
        while (next){
            answer=input.nextLine();
            if (answer.equals("go west") || answer.equals("go east") || answer.equals("go south") || answer.equals("go north")) {
                if (answer.equals("go west")) {
                    System.out.println("You are in front of a tavern");
                    System.out.println("Do you want to enter? Yes or No ? ");
                    face = "w";
                }
                if (answer.equals("go south")) {
                    System.out.println("Do you want return to the forest ?? Yes or No ?");
                    face = "s";
                }
                if (answer.equals("go east")) {
                    System.out.println("You see a way that leads to the swamps");
                    System.out.println("Do you continue ? Yes or No ?");
                    face = "e";
                }
                if (answer.equals("go north")) {
                    System.out.println("You are in front of the Castle Gate");
                    System.out.println("Do you want to go to the Castle? Yes or No ?");
                    face = "n";
                }
            }
            else if (answer.equals("Yes") && face.equals("s")) {
                System.out.println("You are returning to the forest");
                next = false;
                iout = 1;
            }
            else if (answer.equals("No") &&  face.equals("s")) {
                System.out.println("You are staying in the city center");
                face = "c";
            }
            else if (answer.equals("Yes") &&  face.equals("e")) {
                System.out.println("You are headed to the swamps");
                iout = 6;
                next=false;
            }
            else if (answer.equals("No") &&  face.equals("e")) {
                System.out.println("You are staying in the city center");
                face = "c";
            }
            else if (answer.equals("Yes") &&  face.equals("n")) {
                System.out.println("You are entering the Castle");
                iout = 5;
                next=false;
            }
            else if (answer.equals("No") &&  face.equals("n")) {
                System.out.println("You are staying in the city center");
                face = "c";
            }
            else if (answer.equals("Yes") &&  face.equals("w")) {
                System.out.println("You are entering the tavern");
                iout = 4;
                next=false;
            }
            else if (answer.equals("No") &&  face.equals("w")) {
                System.out.println("You are staying in the city center");
                face = "c";
            }
            else if (answer.equals("save")||answer.equals("save game")){
                FileWriter fstream = new FileWriter ("C:\\Users\\pan_d\\Documents\\Zork\\savefilezork.txt");
                BufferedWriter info = new BufferedWriter(fstream);
                info.write(String.valueOf(3));
                info.newLine();
                info.write(String.valueOf(playerHealth));
                info.newLine();
                info.write(String.valueOf(playerLevel));
                info.newLine();
                info.write(playerWeapon);
                info.close();
            }
            else
                System.out.println("This command is not valid!");

        }
        return iout;
    }
    public static int tavern(){
        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("You entered a tavern full of people drinking and singing");
        System.out.println("You look around and you spot a empty spot near a mystresious person");
        System.out.println("Mysterious person: Please take a seat.Let me talk about the tragedy of our Queen ");
        System.out.println("Her daughter is been taken from a routhless monster");
        System.out.println("You should go the Castle and try to help");
        System.out.println("I am sure that the reward is worth your trouble");
        System.out.println("Do you want a drink first??");
        answer=input.nextLine();
        if (answer.equals("Yes")){
            System.out.println("The stanger gave you a sword");
            playerWeapon = "sword";
            System.out.println("Your current weapon is " + playerWeapon + " and the damage it's dealing is 40 ");
            System.out.println(" ");
            System.out.println("You drink the beer and you go back to the city center");
        }
        else if (answer.equals("No")){
            System.out.println("You are returning to the city center");
        }
        else
            System.out.println("This command is not valid");
        return 3;
    }

    public static int castle(){
        Scanner input = new Scanner(System.in);
        String answer;
        System.out.println("A woman in white is approaching you");
        System.out.println("The queen is expecting you");
        System.out.println("You are in a beautiful castle full of flowers everywhere");
        System.out.println("Butterflies and Birds are flying around");
        System.out.println("The sound of the birds is almost the perfect melody");
        System.out.println("You are seeing a beautiful and shinning woman in a fabulous dress");
        System.out.println("She looks at you and she smilles");
        System.out.println("Her smille is like a sunshine ");
        System.out.println("You are kneeling in front of the Queen out of respect");
        System.out.println("Well it took you some time she said to you");
        System.out.println("I hope that your journey to here was good ");
        System.out.println("I was watching you the whole time and praying for you to come");
        System.out.println("I was hopping that you can bring my daughter back to me");
        System.out.println("You want to hear some details ? Yes or No ?");
        answer= input.nextLine();
        if (answer.equals("Yes")){
            System.out.println("Well it was a summer night");
            System.out.println("My daughter was playing in the city center");
            System.out.println("There was 5 guards watching her");
            System.out.println("But no one could help her");
            System.out.println("The vicious monster came from the sky");
            System.out.println("He grapped my precious little daughter and took her away from me");
        }
        System.out.println("So i was wondering if you can help me take her back");
        System.out.println("The reward is something really good");
        System.out.println("You stand and say:");
        System.out.println("I would do anything for you my Queen");
        System.out.println("Queen: You made me the happiest person");
        System.out.println("I give you this torch to shine light to all the dark places you enter!");
        System.out.println("Thank you so much !");
        System.out.println("Your name will never be forgotten");
        System.out.println("I will leave you to your Quest.");
        System.out.println("I wish you safe return. Please bring the princess back!");
        return 3;

    }
    public static int swamps()throws IOException{
        Scanner input = new Scanner(System.in);
        String answer;
        boolean next= true;
        String face= "c";
        int iout=50;
        while(next){
            answer=input.nextLine();
            if (answer.equals("go west") || answer.equals("go east") || answer.equals("go south") || answer.equals("go north")) {
                if (answer.equals("go west")) {
                    System.out.println("Do you want to return to the city ??? Yes or No ??");
                    face = "w";
                }
                if (answer.equals("go south")) {
                    System.out.println("A dark cave is in front of you. Do enter Yes or No ?");
                    face = "s";
                }
                if (answer.equals("go east")) {
                    System.out.println("Opps you fell down in a swamp hole");
                    System.out.println("You are sinking every time you move");
                    System.out.println("Its getting extremely dangerous");
                    System.out.println("You see a rope");
                    System.out.println("Mabe its your only way out of this mess");
                    face = "e";
                }
                if (answer.equals("go north")) {
                    System.out.println("You see a little village far from you");
                    System.out.println("Do you want to go to the village? Yes or No ?");
                    face = "n";
                }
            }
            else if (answer.equals("Yes") && face.equals("s")) {
                System.out.println("You are entering the cave");
                next = false;
                iout = 7;
            }
            else if (answer.equals("No") &&  face.equals("s")) {
                System.out.println("You are staying in the swamps");
                face = "c";
            }
            else if (answer.equals("use rope") && face.equals("e")){
                System.out.println("It was a close one but you got out. You are safe!");
            }
            else if (answer.equals("Yes") &&  face.equals("n")) {
                System.out.println("You are headed to the village");
                iout = 9;
                next=false;
            }
            else if (answer.equals("No") &&  face.equals("n")) {
                System.out.println("You are staying in the swamp");
                face = "c";
            }
            else if (answer.equals("Yes") &&  face.equals("w")) {
                System.out.println("You are returning to the city");
                iout = 3;
                next=false;
            }
            else if (answer.equals("No") &&  face.equals("w")) {
                System.out.println("You are staying in the swamp");
                face = "c";
            }
            else if (answer.equals("save")||answer.equals("save game")){
                FileWriter fstream = new FileWriter ("C:\\Users\\pan_d\\Documents\\Zork\\savefilezork.txt");
                BufferedWriter info = new BufferedWriter(fstream);
                info.write(String.valueOf(6));
                info.newLine();
                info.write(String.valueOf(playerHealth));
                info.newLine();
                info.write(String.valueOf(playerLevel));
                info.newLine();
                info.write(playerWeapon);
                info.close();
            }
            else
                System.out.println("This command is not valid");
        }
        return iout;

    }
    public static int darkcave(){
        Scanner input = new Scanner(System.in);
        String answer;
        boolean dark=true;
        int iout=50;
        System.out.println("It is dark. You dont see anything!");
        System.out.println("Use something to light up the cave");
        while(dark) {
            answer = input.nextLine();
            if (answer.equals("use torch")) {
                dark = false;
                System.out.println("You can now see the cave");
            } else
                System.out.println("The command is not valid");
        }
        System.out.println("You see an entrance of another cave");
        System.out.println("Do you want to go in the cave or go back ? go in or go back ??");
        answer=input.nextLine();
        if (answer.equals("go in")){
            iout=8;
            System.out.println("You are headed to the next Cave!");
        }
        else if (answer.equals("go back")){
            iout=6;
            System.out.println("You are going back to the swamps");
        }
        return iout;
    }

    public static int vertus() {
        Scanner input = new Scanner(System.in);
        String answer;
        boolean fight=true;
        System.out.println("You entered a snowy cave");
        System.out.println("Ice and snow is all around you");
        System.out.println("You hear the ice under your feet braking");
        System.out.println("A giant monster brakes from the ice");
        System.out.println("His glowing eyes are starring at you");
        System.out.println("He is ready to charge at you !!");
        int hp = playerHealth;
        do {
            System.out.println("What are you gonna do? : ");
            answer = input.nextLine();
            if (answer.startsWith("run")) {
                System.out.println("You chickened out!!");
                fight=false;
                vertusHealth=0;
            }
            if (answer.startsWith("attack")) {
                if (playerWeapon.equals("fists")) {
                    System.out.println("You attack the troll with your fists!");
                    System.out.println("You have done :" + basicDamage + " damage");
                    vertusHealth = vertusHealth - basicDamage;
                    System.out.println("The troll has" + vertusHealth + "HP left! \n");
                } else if (playerWeapon.equals("knife")) {
                    System.out.println("You attack the troll with your knife!");
                    System.out.println("You have done: " + knifeDamage + " damage");
                    vertusHealth = vertusHealth - knifeDamage;
                    System.out.println("The monster has : " + vertusHealth + " HP left! \n");
                } else if (playerWeapon.equals("sword")) {
                    System.out.println("You attack the troll with your knife!");
                    System.out.println("You have done: " + swordDamage + " damage");
                    vertusHealth = vertusHealth - swordDamage;
                    System.out.println("The monster has : " + vertusHealth + " HP left! \n");
                }
                    if (vertusHealth > 0) {
                        int dmg = (int) (Math.random() * (10 - 5) + 5);
                        hp = hp - dmg;
                        System.out.println("The troll has done: " + dmg + "damage to you! \n" + "You have : " + hp
                                + "HP left! \n");
                    }
                    if (hp <= 0) {
                        System.out.println("You have died! \n" + "Game Over!");
                        System.exit(0);
                    }
                } else
                    System.out.println("This command is not valid");

            }while (vertusHealth >= 1) ;
        if (fight) {
            playerLevel = playerLevel + 1;
            System.out.println("You have defeated the troll of the Cave! \n" + " Your level now is : " + playerLevel);
            playerHealth = playerHealth + 20;
            System.out.println("Your Health is now :" + playerHealth);
        }
        vertusHealth=140;
        return 6;
        }

        public static int village()throws IOException {
            Scanner input = new Scanner(System.in);
            String answer;
            int iout=50;
            String face = "c";
            boolean next=true;
            if (v){
                System.out.println("Hello fellow traveler!");
                System.out.println("Welcome to our village");
                System.out.println("The monsters in the west are stealing our food");
                System.out.println("We barely make it!");
                System.out.println("Please help us!");
                System.out.println("We cant offer much...");
                System.out.println("At least we can help you with your jorney");
                System.out.println("If you need some equipment go to the tavern in the east of the village");
            }
            while (next) {
                answer=input.nextLine();
                if (answer.equals("go west") || answer.equals("go east") || answer.equals("go south") || answer.equals("go north")) {
                    if (answer.equals("go west")) {
                        System.out.println("You are in front of the entrance of the field where monsters reside");
                        System.out.println("One's you enter you cant go back!");
                        System.out.println("It's either Death Or Victory!!");
                        System.out.println("Do you want to  fight Yes or No ? ");
                        face = "w";
                    }
                    if (answer.equals("go south")) {
                        System.out.println("Do you want return to the swamps?");
                        face = "s";
                    }
                    if (answer.equals("go east")) {
                        System.out.println("You see a entrace of a tavern");
                        System.out.println("Do you enter? Yes or No ?");
                        face = "e";
                    }
                    if (answer.equals("go north")) {
                        System.out.println("You see a Harbor in the near distance");
                        System.out.println("Do you want to go to the Harbor? Yes or No ?");
                        face = "n";
                    }
                }
                else if (answer.equals("Yes") && face.equals("s")) {
                    System.out.println("You are entering the cave");
                    next = false;
                    iout = 6;
                }
                else if (answer.equals("No") &&  face.equals("s")) {
                    System.out.println("You are staying in the center of the  village");
                    face = "c";
                }
                else if (answer.equals("Yes") && face.equals("e")){
                    System.out.println("You enter the Tavern");
                    next=false;
                    iout=10;
                }
                else if (answer.equals("No") &&  face.equals("e")) {
                    System.out.println("You are staying in the center of the  village");
                    face = "c";
                }
                else if (answer.equals("Yes") &&  face.equals("n")) {
                    System.out.println("You are headed to the harbor");
                    iout = 11;
                    next=false;
                }
                else if (answer.equals("No") &&  face.equals("n")) {
                    System.out.println("You are staying in the center of the village");
                    face = "c";
                }
                else if (answer.equals("Yes") &&  face.equals("w")) {
                    System.out.println("You are returning to the city");
                    iout = 13;
                    next=false;
                }
                else if (answer.equals("No") &&  face.equals("w")) {
                    System.out.println("You are such a chicken but ok!:P");
                    System.out.println("You stay at the village center");
                    face = "c";
                }
                else if (answer.equals("save")||answer.equals("save game")){
                    FileWriter fstream = new FileWriter ("C:\\Users\\pan_d\\Documents\\Zork\\savefilezork.txt");
                    BufferedWriter info = new BufferedWriter(fstream);
                    info.write(String.valueOf(9));
                    info.newLine();
                    info.write(String.valueOf(playerHealth));
                    info.newLine();
                    info.write(String.valueOf(playerLevel));
                    info.newLine();
                    info.write(playerWeapon);
                    info.close();
                }
                else
                    System.out.println("This command is not valid");
            }
            v=false;
            return iout;
        }

        public static int urnil(){
            Scanner input = new Scanner(System.in);
            String answer;
            boolean fight=true;
            System.out.println("You entered an open field");
            System.out.println("The ground is full of human and animal skeletons");
            System.out.println("The earth is shaking!!");
            System.out.println("You hear large foot steps from far away!");
            System.out.println("A large bear like creature appears!");
            System.out.println("He wears a thick armour!!");
            System.out.println("He sees you and charge at you!");
            System.out.println("The is no escape!");
            System.out.println("You need to atack NOW!");
            int hp = playerHealth;
            do {
                answer = input.nextLine();
                if (answer.startsWith("attack")) {
                    if (playerWeapon.equals("fists")) {
                        System.out.println("You attack the troll with your fists!");
                        System.out.println("You have done :" + basicDamage + " damage");
                        urnilHealth = urnilHealth - basicDamage;
                        System.out.println("The troll has" + urnilHealth + "HP left! \n");
                    } else if (playerWeapon.equals("knife")) {
                        System.out.println("You attack the troll with your knife!");
                        System.out.println("You have done: " + knifeDamage + " damage");
                        urnilHealth = urnilHealth - knifeDamage;
                        System.out.println("The monster has : " + vertusHealth + " HP left! \n");
                    } else if (playerWeapon.equals("sword")) {
                        System.out.println("You attack the troll with your knife!");
                        System.out.println("You have done: " + swordDamage + " damage");
                        urnilHealth = urnilHealth - swordDamage;
                        System.out.println("The monster has : " + urnilHealth + " HP left! \n");
                    }
                    if (urnilHealth > 0) {
                        int dmg = (int) (Math.random() * (15 - 10) + 10);
                        hp = hp - dmg;
                        System.out.println("The troll has done: " + dmg + "damage to you! \n" + "You have : " + hp
                                + "HP left! \n");
                    }
                    if (hp <= 0) {
                        System.out.println("You have died! \n" + "Game Over!");
                        System.exit(0);
                    }
                } else
                    System.out.println("This command is not valid");

            }while (vertusHealth >= 1) ;
            if (fight) {
                playerLevel = playerLevel + 1;
                System.out.println("You have defeated the troll of the Cave! \n" + " Your level now is : " + playerLevel);
                playerHealth = playerHealth + 20;
                System.out.println("Your Health is now :" + playerHealth);
            }
            urnilHealth=180;
            return 9;
        }

        public static int tavernv()
        {
            System.out.println("Hello my champion!");
            System.out.println("Welcome to my humble tavern!!");
            System.out.println("I dont know if you want to help us");
            System.out.println("But drink this health potion");
            System.out.println("The potion will increase your max health!");
            System.out.println("I hope that you will help us save our village");
            Scanner input = new Scanner(System.in);
            String answer;
            System.out.println("Do you drink the potion?");
            answer = input.nextLine();
            if (answer.equals("drink potion")){
                System.out.println("You health has increased by 50");
                playerHealth=playerHealth+50;
            }
            else if (answer.equals("no")||answer.equals("No")) {
            System.out.println("Your loss!!");
            System.out.println("Take care!");
            }
            System.out.println("You return to the village center!");
            return 9;
        }

        public static int harbor()
        {
            Scanner input = new Scanner(System.in);
            String answer;
            boolean next=true;
            int iout=50;
            System.out.println("You entered the harbor!");
            System.out.println("A man with a sailors hat is approaching..");
            System.out.println("Hello dear traveler");
            System.out.println("Are you interested on the ship to traver to Punika??");
            System.out.println("Since the Night Fox came in Punika with the princess");
            System.out.println("Day after day brave warriors crossed the dark sea to fight him!");
            System.out.println("But no one has returned");
            System.out.println("Do you wish to travel to Punika ?? Yes or No ??");
            answer = input.nextLine();
            while(next) {
                if (answer.equals("Yes") || answer.equals("yes")) {
                    System.out.println("Nice!!You have my blessing..Have a safe journey!");
                    iout = 12;
                    next=false;
                } else if (answer.equals("No") || answer.equals("no")) {
                    System.out.println("Well we cant be all heroes...You will return to the village");
                    iout = 9;
                    next=false;
                } else
                    System.out.println("This command is not valid!");
            }
            return iout;
        }
        public static int punika()
        {
            System.out.println("You traveled through the harsh sea of Arkesia");
            System.out.println("So many storms and thunders in the way to Punika");
            System.out.println("The ship was close to get damaged from the terrible weather conditions!");
            System.out.println("Hopefully all went right and you made it to Punika!");
            System.out.println("Ones you stepped foot in Punika you make a big realisation");
            System.out.println("All the nice stories with dances and music on the streets are in the past");
            System.out.println("You see around and there is only sad people and childs without parents..");
            System.out.println("To be continued!!");
            return 14;
        }
        public static int load() throws IOException
        {
            File file = new File("C:\\Users\\pan_d\\Documents\\Zork\\savefilezork.txt");
            Scanner sc = new Scanner(file);
            int iout = Integer.parseInt(sc.nextLine());
            playerHealth = Integer.parseInt(sc.nextLine());
            playerLevel = Integer.parseInt(sc.nextLine());
            playerWeapon = sc.nextLine();
            return iout;
        }



    }




























































