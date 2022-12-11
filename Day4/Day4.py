def problem1(file: str) -> str:
    """
    Solution to problem1
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    # I think the best way to go about this will be to check if the first number is smaller then the other and so on
    def check(pairs: list) -> bool:
        """
        Check pairs
        """
        x, y = pairs[0].split("-")
        a, b = pairs[1].split("-")
        return (int(x) <= int(a) and int(y) >= int(b)) or (
            int(x) >= int(a) and int(y) <= int(b)
        )

    total = 0
    for line in lines:
        if check(line.split(",")):
            total += 1

    return total


def problem2(file: str) -> str:
    """
    Solution to problem2
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    def overlap(pairs: list) -> bool:
        """
        Check if the pairs overlap, we just have to edit my code before a bit
        """
        x, y = pairs[0].split("-")
        a, b = pairs[1].split("-")
        x = int(x)
        y = int(y)
        a = int(a)
        b = int(b)

        # For this logic, we can just check if the bigger number of x and y are smaller than the biggest of a or b and reverse it
        if max(x, y) < min(a, b) or min(x, y) > max(a, b):
            return False
        return True

    total = 0
    for line in lines:
        if overlap(line.split(",")):
            total += 1

    return total


print(problem1("data.txt"))
print(problem2("data.txt"))
