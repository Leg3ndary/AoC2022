def problem1(file: str) -> str:
    """
    Sol to problem 1
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    total = 0

    # Loop through and compare.
    for i in range(len(lines[0])):
        one = lines[0][i]
        two = lines[0][i + 1]
        three = lines[0][i + 2]
        four = lines[0][i + 3]
        if (
            one == two
            or one == three
            or one == four
            or two == three
            or two == four
            or three == four
        ):
            total += 1
        else:
            return (
                total + 4
            )  # This is needed to compensate for the fact we have to return the end pos and not the start due to characters processed.


def problem2(file: str) -> str:
    """
    Sol to problem2
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    total = 0

    for i in range(len(lines[0])):
        temp = {}
        for j in range(14):
            if temp.get(lines[0][i + j]):
                temp[lines[0][i + j]] += 1
            else:
                temp[lines[0][i + j]] = 1
        if len(temp) != 14:
            total += 1
        else:
            return (
                total + 14
            )  # Need to add 14 again instead of start, this way we do not have to keep track of characters processed.


print(problem1("data.txt"))
print(problem2("data.txt"))
