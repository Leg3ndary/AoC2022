def problem1(file: str) -> str:
    """
    Solution to problem1
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    # Create two variables, one to hold the highest amt of calories, the other to temporarily hold the amount of calories the current elf is holding
    max = 0
    temp = 0

    # Loop through all items
    for item in lines:
        # If the item is not blank, we can keep adding it to temp
        if item.strip() != "":
            temp += int(item)
        # Otherwise we see if it's bigger than the max, and set temp to 0
        else:
            if temp > max:
                max = temp
            temp = 0

    return max


def problem2(file: str) -> str:
    """
    Solution to problem2
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    # First we create a list to hold the top three elves calories
    top = []
    # We create another temp var
    temp = 0

    # Then we use the same logic, with a bit of tweaking
    for line in lines:
        if line.strip() != "":
            temp += int(line)
        else:
            # If top has less than 3 calories
            if len(top) < 3:
                top.append(temp)
            else:
                # Keep a "leaderboard" of calories
                if temp > top[2]:
                    top.append(temp)
                    temp = top.pop(2)
                if temp > top[1]:
                    top.append(temp)
                    temp = top.pop(1)
                if temp > top[0]:
                    top.pop(0)
                    top.append(temp)
            temp = 0

    return top[0] + top[1] + top[2]


print(problem1("data.txt"))
print(problem2("data.txt"))
