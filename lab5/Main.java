package lab5;

import java.util.Scanner;

class Weapon {
    private final String name;
    private final int attackBonus;

    public Weapon(String name, int attackBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
    }

    public String getName() {
        return name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}

class Potion {
    private final String name;
    private final int healPower;

    public Potion(String name, int healPower) {
        this.name = name;
        this.healPower = healPower;
    }

    public String getName() {
        return name;
    }

    public int getHealPower() {
        return healPower;
    }
}

class Hero {
    private final String name;
    private int health;
    private final int maxHealth;
    private final int baseAttack;
    private Weapon weapon;

    public Hero(String name, int health, int baseAttack) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.baseAttack = baseAttack;
        this.weapon = new Weapon("Звичайний меч", 5);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public int attack() {
        return baseAttack + weapon.getAttackBonus();
    }

    public void equipWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println("Герой озброївся: " + newWeapon.getName() + " (+ " + newWeapon.getAttackBonus() + " атаки)");
    }

    public void displayStatus() {
        System.out.printf("Герой: %s | Здоров'я: %d/%d | Атака: %d (Зброя: %s)%n",
                name, health, maxHealth, attack(), weapon.getName());
    }
}

class Monster {
    private final String name;
    private int health;
    private final int attackPower;

    public Monster(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public int attack() {
        return attackPower;
    }

    public boolean isAlive() {
        return health > 0;
    }
}

class GameEngine {
    private Hero hero;
    private final Scanner scanner;

    public GameEngine() {
        this.scanner = new Scanner(System.in, "UTF-8");
    }

    public void start() {
        System.out.print("Введіть ім'я вашого героя: ");
        String heroName = scanner.next();
        hero = new Hero(heroName, 100, 15);

        System.out.println("\nГра розпочинається! Попереду на вас чекають битви з монстрами.");

        playBattle(new Monster("Гоблін", 40, 10), new Weapon("Іржавий кинджал", 8), new Potion("Мале зілля", 25));

        if (hero.getHealth() <= 0) {
            System.out.println("\nГру закінчено. Ви загинули...");
            return;
        }

        playBattle(new Monster("Вогняний Дракон", 80, 20), new Weapon("МЕЧ СВІТЛА", 20), new Potion("Велике зілля", 50));

        if (hero.getHealth() > 0) {
            System.out.println("\nВІТАЮ! Ви перемогли всіх монстрів і врятували королівство!");
        } else {
            System.out.println("\nГру закінчено. Ви загинули у фінальній битві...");
        }
    }

    private void playBattle(Monster monster, Weapon rewardWeapon, Potion rewardPotion) {
        System.out.println("\n-----------------------------------------");
        System.out.println("З'явився дикий ворог: " + monster.getName() + " (Здоров'я: " + monster.getHealth() + ")!");

        while (monster.isAlive() && hero.getHealth() > 0) {
            System.out.println("\nОберіть дію:");
            System.out.println("1. Атакувати мечем");
            System.out.println("2. Випити зілля здоров'я");
            System.out.println("3. Подивитися статус героя");
            System.out.print("Ваш вибір: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    int heroDamage = hero.attack();
                    monster.takeDamage(heroDamage);
                    System.out.println("Ви вдарили монстра і завдали " + heroDamage + " шкоди!");

                    if (monster.isAlive()) {
                        int monsterDamage = monster.attack();
                        hero.takeDamage(monsterDamage);
                        System.out.println("Монстр контратакує і завдає вам " + monsterDamage + " шкоди!");
                    }
                }
                case 2 -> {
                    hero.heal(rewardPotion.getHealPower());
                    System.out.println("Ви використали " + rewardPotion.getName() + " та відновили здоров'я!");
                }
                case 3 -> hero.displayStatus();
                default -> System.out.println("Неправильний вибір. Спробуйте знову.");
            }

            if (monster.isAlive()) {
                System.out.println("Здоров'я монстра: " + monster.getHealth());
            }
        }

        if (hero.getHealth() > 0) {
            System.out.println("\nВи перемогли монстра " + monster.getName() + "!");
            hero.equipWeapon(rewardWeapon);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        game.start();
    }
}