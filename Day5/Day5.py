def problem1(file: str) -> str:
    """
    Problem 1 Solution
    """

    with open(file, "r") as f:
        lines = []
        for line in f:
            lines.append(line.strip())

    # Best way in my opinion to do this is to create the scenario in a 2d array and then just apply and join the first letter of every stack
    stacks = []

    # Getting some basic variables that we'll need
    split = lines.index("")
    stack_length = int(lines[split - 1].strip().split(" ")[-1])

    for i in range(stack_length):
        stacks.append([])

    for stack in lines[: split - 1]:
        for i in range(stack_length):
            if stack[i * 4 + 1].strip() != "":
                stacks[i].append(stack[i * 4 + 1])

    for line in lines[split + 1 :]:
        quantity = int(line.split(" ")[1])
        stack_from = int(line.split(" ")[3]) - 1
        stack_to = int(line.split(" ")[5]) - 1

        for i in range(quantity):
            stacks[stack_to].insert(0, stacks[stack_from].pop(0))

    answer = ""

    for stack in stacks:
        answer += stack[0]

    return answer  # Return your answer here.


def problem2(file: str) -> str:
    """
    I copied over my solution from problem1 as I just have to change it a bit to work...
    """
    with open(file, "r") as f:
        lines = []
        for line in f:
            lines.append(line.strip())

    stacks = []

    # Getting some basic variables that we'll need
    split = lines.index("")
    stack_length = int(lines[split - 1].strip().split(" ")[-1])

    for i in range(stack_length):
        stacks.append([])

    for stack in lines[: split - 1]:
        for i in range(stack_length):
            if stack[i * 4 + 1].strip() != "":
                stacks[i].append(stack[i * 4 + 1])

    for line in lines[split + 1 :]:
        quantity = int(line.split(" ")[1])
        stack_from = int(line.split(" ")[3]) - 1
        stack_to = int(line.split(" ")[5]) - 1

        # We can just pop the item in nth place and then n-1, n-2 and so on till we reach 0

        for i in range(quantity):
            stacks[stack_to].insert(0, stacks[stack_from].pop(quantity - 1 - i))

    answer = ""

    for stack in stacks:
        answer += stack[0]

    return answer  # Return your answer here.


print(problem1("data.txt"))
print(problem2("data.txt"))
