"""
Had an fpt plus 2 other important unit tests for physics and chemistry
"""


def traverse(tree: dict) -> int:
    """
    Find everything with less then 100000 size or whatever
    """
    for key, value in tree.items():
        if key == "size":
            yield value if value < 100000 else 0
        if isinstance(value, dict):
            yield from traverse(value)


def second_traverse(tree: dict) -> int:
    """
    Return all values in a dict even if nested.
    """
    for key, value in tree.items():
        if key == "size":
            yield value
        if isinstance(value, dict):
            yield from second_traverse(value)


def problem1(file: str) -> int:
    """
    problem1
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    tree = {"size": 0}
    current = tree
    dir = "/"

    for line in lines:
        f, s, *t = line.split(" ")

        if f == "$" and s == "cd":
            cd = t[0]

            if cd == "/":
                current = tree
                dir = "/"

            elif cd == "..":
                dirs = dir.split("/")[:-1]
                current = tree
                for back in dirs:
                    if back != "":
                        current = current.get(back)
                dir = "/".join(dirs)

            else:
                dir += "/" + cd if dir != "/" else cd
                if not current.get(cd):
                    current.update({cd: {"size": 0}})

                current = current.get(cd)

        elif f == "dir":
            if s not in current:
                current.update({s: {"size": 0}})

        elif f.isnumeric():
            current = tree
            current["size"] += int(f)
            for back in dir.split("/"):
                if back != "":
                    current = current.get(back)
                    current["size"] += int(f)

    total = 0
    for i in traverse(tree):
        total += i

    return total


def problem2(file: str) -> int:
    """
    Problem2, copied my code from part 1 again.
    """
    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    lines = []
    with open(file, "r") as f:
        for line in f:
            lines.append(line.strip())

    tree = {"size": 0}
    current = tree
    dir = "/"

    for line in lines:
        f, s, *t = line.split(" ")

        if f == "$" and s == "cd":
            cd = t[0]

            if cd == "/":
                current = tree
                dir = "/"

            elif cd == "..":
                dirs = dir.split("/")[:-1]
                current = tree
                for back in dirs:
                    if back != "":
                        current = current.get(back)
                dir = "/".join(dirs)

            else:
                dir += "/" + cd if dir != "/" else cd
                if not current.get(cd):
                    current.update({cd: {"size": 0}})

                current = current.get(cd)

        elif f == "dir":
            if s not in current:
                current.update({s: {"size": 0}})

        elif f.isnumeric():
            current = tree
            current["size"] += int(f)
            for back in dir.split("/"):
                if back != "":
                    current = current.get(back)
                    current["size"] += int(f)

    total = []
    unused = 70000000 - tree["size"]
    for i in second_traverse(tree):
        if i != 0:
            if i > 30000000 - unused:
                total.append(i)

    return sorted(total)[0]


print(problem1("data.txt"))
print(problem2("data.txt"))
