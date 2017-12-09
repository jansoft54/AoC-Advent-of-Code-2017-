with open("day9.txt") as file:
    garbage, jump = False, False;
    score, garbagecounter, counter = 0, 0 , 0;
    for x in file.read():
        if jump:
            jump = False
            continue
        if x == "!" :
            jump = True
        elif x == "<" and not garbage:
            garbage = True;
        elif x == ">":
            garbage = False;
        elif x == "{" and not garbage:
            counter += 1
            score += counter
        elif x == "}" and not garbage:
            counter -= 1
        elif garbage :
            garbagecounter += 1
    print("Part one "+ str(score))
    print("Part two "+str(garbagecounter))