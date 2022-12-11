def problem1_alt(file: str) -> int:
    """
    A alternate solution to problem 1 which doesn't translate well to problem2 but it works, written in vscode, I know I'm not supposed to but you can already see my original solution anyways
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    score = 0

    """
    The main difference here is that instead of separating all variables and checking them, we can just see the presence of x y and z, and check the 6 cases of rock paper scissors.
    """
    for item in lines:
        meta = 0
        if "X" in item:
            meta += 1
        elif "Y" in item:
            meta += 2
        else:
            meta += 3

        if item == "A X" or item == "B Y" or "C Z":
            meta += 3
        elif item == "A Y" or item == "B Z" or "C X":
            meta += 6

        score += meta

        return score


def problem1(file: str) -> int:
    f = open(file, "r")

    lines = []
    for line in f:
        lines.append(line.strip())

    # Create a var to hold the score
    score = 0

    for line in lines:
        # Set what the elf and you play
        elf, me = line.split(" ")

        # Define a meta score
        meta = 0

        # Add the small bonuses
        if me == "X":
            meta += 1
        elif me == "Y":
            meta += 2
        else:
            meta += 3

        # Find the winner
        # First we do the draws
        if (
            (elf == "A" and me == "X")
            or (elf == "B" and me == "Y")
            or (elf == "C" and me == "Z")
        ):
            meta += 3
        # Then we do wins
        elif (
            (elf == "A" and me == "Y")
            or (elf == "B" and me == "Z")
            or (elf == "C" and me == "X")
        ):
            meta += 6
        # We can assume every other score is a loss and therefore invalid
        score += meta

    f.close()
    return score


def problem2(file: str) -> int:
    """
    Problem2
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    # Define a score variable
    score = 0

    for line in lines:
        # Again set what you and the elf will have
        elf, me = line.split(" ")

        # Now I think the best way to just be to set-up the same thing before except add logic to find the correct play

        if me == "X":
            if elf == "A":
                me = "Z"
            elif elf == "B":
                me = "X"
            else:
                me = "Y"
        elif me == "Y":
            if elf == "A":
                me = "X"
            elif elf == "B":
                me = "Y"
            else:
                me = "Z"
        else:
            if elf == "A":
                me = "Y"
            elif elf == "B":
                me = "Z"
            else:
                me = "X"

        # Below is copy pasted from my code in problem 1
        # Define a meta score
        meta = 0

        # Add the small bonuses
        if me == "X":
            meta += 1
        elif me == "Y":
            meta += 2
        else:
            meta += 3

        # Find the winner
        # First we do the draws
        if (
            (elf == "A" and me == "X")
            or (elf == "B" and me == "Y")
            or (elf == "C" and me == "Z")
        ):
            meta += 3
        # Then we do wins
        elif (
            (elf == "A" and me == "Y")
            or (elf == "B" and me == "Z")
            or (elf == "C" and me == "X")
        ):
            meta += 6
        # We can assume every other score is a loss and therefore invalid
        score += meta

    f.close()
    return score


print(problem1("data.txt"))
print(problem2("data.txt"))
