import re

run = True
previous = 0
print("You can enter \'quit\'to exit")
print("")
def my_cal():
    global run
    global previous
    equation = ""
    if previous == 0:
        equation = input("Enter your input : \n")
    else:
        equation = input(str(previous))

    if equation == " ":
        equation = input(str(previous))

    if equation == "quit" or equation == "Quit" or equation == "QUIT" :
        print("Thank you for using My Calculator!, See you soon")
        run = False
    else:
        equation = re.sub('[a-zA-Z,.()" ":]','',equation)
        # if equation == '[a-zA-Z,."()]':
        #     print("Enter valid input")
        #     run = False
        if previous == 0:
            previous = eval(equation)
        else:
            previous = eval(str(previous)+equation)
        print("Ouput for your input : ",previous)

while (run):
    my_cal()
