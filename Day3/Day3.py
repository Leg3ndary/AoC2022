def problem1(file: str) -> int:
    """
    Problem 1 Solution"""
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    # First let's find the only items that are in both compartments
    def find_item(compartment: str) -> str:
        """
        Find the item that appears in the compartment thing twice

        We can just use some iteration to find it
        """
        over, under = (
            compartment[: round(len(compartment) / 2)],
            compartment[round(len(compartment) / 2) :],
        )
        for char in over:
            for second_char in under:
                if char == second_char:
                    return char

    def get_priority(item: str) -> int:
        """
        Return the priority number

        The best way to go about this is probably ordinals
        """
        return ord(item) - 96 if item.islower() else ord(item) - 38  # 64 - 26

    total = 0
    for line in lines:
        total += get_priority(find_item(line))

    f.close()
    return total


def problem2(file: str) -> int:
    """
    Problem2 Solution
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    # Here we just have to modify our find function by a bit, let's rewrite it
    def find_badge(lines: list) -> str:
        """
        Find the badge of a group of 3 elves
        """
        for char in lines[0]:
            for second_char in lines[1]:
                for third_char in lines[2]:
                    if char == second_char and char == third_char:
                        return char

    # Luckily we can just use the same get_priority function
    def get_priority(item: str) -> int:
        """
        Return the priority number
        """
        return ord(item) - 96 if item.islower() else ord(item) - 38

    # Now we just have to provide all the correct items to the functions
    total = 0
    temp = []

    for line in lines:
        temp.append(line)
        if len(temp) == 3:
            total += get_priority(find_badge(temp))
            temp = []

    f.close()
    return total


print(problem1("data.txt"))
print(problem2("data.txt"))
