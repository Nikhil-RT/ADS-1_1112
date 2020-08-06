from Game.game import Person,bcolors
from Game.magic import Spell
from Game.inventory import Item
import random

#This is Black Magic
fire = Spell("Fire",25,600,"black")
thunder = Spell("Thunder",28,630,"black")
water = Spell("Water",22,580,"black")
earth = Spell("Earth",26,610,"black")

#This is White Magic
cure = Spell("Cure",25,630,"white")
cura = Spell("Cura",35,1500,"white")

#Create some items
potion = Item("Potion","potion","Heals 50 HP", 50)
hipotion = Item("Hi-Potion","potion", "Heals 100 HP",100)
superpotion = Item("Super_Potion","potion","Heals 500 HP",500)
elixer = Item("Elixer","elixer","Restores Full HP/MP of one member",8888)
hielixer = Item("MegaElixer","elixer","Restores Full HP/MP",8888)
grenade = Item("Grenade","attack","Deals 500 damage", 500)

player_spells = [fire, thunder, water, earth, cure, cura]
player_items = [{"item": potion, "quantity": 15}, {"item": hipotion, "quantity": 5}, 
                {"item": superpotion, "quantity": 5}, {"item": elixer, "quantity": 5}, 
                {"item": hielixer, "quantity": 2}, {"item": grenade, "quantity": 5}]

#Instantiate People 
player1 = Person("A:", 3260, 150, 300, 34, player_spells, player_items)
player2 = Person("B:", 4160, 130, 310, 34, player_spells, player_items)
player3 = Person("C:", 3089, 155, 280, 34, player_spells, player_items)

enemy1 = Person("D", 1250, 130, 520, 325, [], [])
enemy2 = Person("E", 11250, 701, 515, 25, [], [])
enemy3 = Person("F", 1250, 130, 520, 325, [], [])

players = [player1, player2, player3]
enemies = [enemy1, enemy2, enemy3]

run = True
i = 0
print("\n")
print(bcolors.FAIL + bcolors.BOLD + "We are under ENEMY ATTACK!" + bcolors.ENDC)

while run:

    print("===================================")
    print("\n\n")
    print("NAME              HP                                    MP")

    for player in players:

        player.get_stats()
    print("\n")
    
    for enemy in enemies:
        enemy.get_enemy_stats()

    for player in players:

        player.choose_action()
        choice = input("Choose an action: ")
        index = int(choice) - 1

        if index == 0:
            dmg = player.generate_damage()
            enemy = player.choose_target(enemies)
            enemies[enemy].take_damage(dmg)
            print("You attacked "+ enemies[enemy].name +" for a damage of",dmg)

            if enemies[enemy].get_hp() == 0:
                print(enemies[enemy].name.replace(" ",""), "has died.")
                del enemies[enemy]

        elif index == 1:
            player.choose_magic()
            magic_choice = int(input("Choose magic: ")) - 1

            if magic_choice == -1:
                continue

            spell = player.magic[magic_choice]
            magic_dmg = spell.generate_damage()

            current_mp = player.get_mp()

            if spell.cost > current_mp:
                print(bcolors.FAIL + "\n Not Enough MP\n" + bcolors.ENDC)
                continue

            player.reduce_mp(spell.cost)

            if spell.type == "white":
                player.heal(magic_dmg)
                print(bcolors.OKBLUE + "\n" + spell.name + " heals for", str(magic_dmg), "HP." + bcolors.ENDC)
            elif spell.type =="black":
                enemy = player.choose_target(enemies)
                enemies[enemy].take_damage(magic_dmg)
                print(bcolors.OKBLUE + "\n" + spell.name + " deals", str(magic_dmg), "points of damage to "+ enemies[enemy].name + bcolors.ENDC)
            
                if enemies[enemy].get_hp() == 0:
                    print(enemies[enemy].name.replace(" ",""),"has died.")
                    del enemies[enemy]

        elif index == 2:
            player.choose_item()
            item_choice = int(input("Choose item: ")) - 1

            if item_choice == -1:
                continue

            item = player.items[item_choice]["item"]

            if player.items[item_choice]["quantity"] == 0:
                print(bcolors.FAIL + "\n" + "None Left" + bcolors.ENDC)
                continue

            player.items[item_choice]["quantity"] -= 1

            if item.type == "potion":
                player.heal(item.prop)
                print(bcolors.OKGREEN + "\n" + item.name + " heals for", str(item.prop),"HP" + bcolors.ENDC)

            elif item.type == "elixer":
                if item.name == "MegaElixer":
                    for i in players:
                        i.hp = i.maxhp
                        i.mp = i.maxhp
                else:    
                    player.hp = player.maxhp
                    player.mp = player.maxmp
                    print(bcolors.OKGREEN + "\n" + item.name + " fully restores HP/MP"+ bcolors.ENDC)

            elif item.type == "attack":
                enemy = player.choose_target(enemies)
                enemies[enemy].take_damage(item.prop)
                print(bcolors.FAIL + "\n" + item.name + " deals", str(item.prop),"damage to "+ enemies[enemy].name + bcolors.ENDC)

                if enemies[enemy].get_hp() == 0:
                    print(enemies[enemy].name.replace(" ","")," has died.")
                    del enemies[enemy]

    
    # players[target].take_damage(enemy_dmg)

    # print("===============================")
    # print("Enemy HP:", bcolors.FAIL + str(enemy.get_hp()) + "/" + str(enemy.get_max_hp()) + bcolors.ENDC + "\n")
    
    # print("Your HP:", bcolors.OKGREEN + str(player.get_hp()) + "/" + str(player.get_max_hp()) + bcolors.ENDC)
    # print("Your MP:", bcolors.OKGREEN + str(player.get_mp()) + "/" + str(player.get_max_mp()) + bcolors.ENDC + "\n")

    '''
        TO check if battle is over 
    '''
    defeated_enemies = 0
    defeated_players = 0

    for player in players:
        if  player.get_hp() == 0:
            defeated_players += 1

    for enemy in enemies:
        if enemy.get_hp() == 0:
            defeated_enemies += 1

    '''
        Check if player Won
    '''
    if defeated_enemies == 2:
        print(bcolors.OKGREEN + "YOU WIN!" + bcolors.ENDC)
        run = False
    
    # TO Check if eneny Won
    elif defeated_players == 2:
        print(bcolors.FAIL + "You got defeated by your enemies" + bcolors.ENDC)
        run = False

    ''' Enemy attack phase'''
    for enemy in enemies:
        enemy_choice = random.randrange(0,3)

        if enemy_choice == 0:
            # Choose attack
            target = random.randrange(0,3)
            enemy_dmg = enemy.generate_damage()

            players[target].take_damage(enemy_dmg)
            print(enemy.name.replace(" ","") + " attacks " + players[target].name.replace(" ","") + " for",dmg)

        '''
            Can Add Spell and Items for enemies
        '''