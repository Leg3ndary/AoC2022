def problem1(file: str) -> int:
    """
    problem1
    """
    grid = []
    with open(file, "r") as f:
        stuff = f.read().splitlines()
        for i in range(len(stuff)):
            grid.append([])
            for j in range(len(stuff[i])):
                grid[i].append(int(stuff[i][j]))

    answer = 0
    for x in range(len(grid)):
        for y in range(len(grid[x])):
            if x in (0, len(grid)) or y in (0, len(grid[x])):
                answer += 1
            else:
                left = all(grid[coord][y] < grid[x][y] for coord in range(0, x))
                right = all(
                    grid[coord][y] < grid[x][y] for coord in range(x + 1, len(grid[x]))
                )
                up = all(grid[x][coord] < grid[x][y] for coord in range(0, y))
                down = all(
                    grid[x][coord] < grid[x][y] for coord in range(y + 1, len(grid))
                )
                answer += 1 if any([left, right, up, down]) else 0
    return answer


def problem2(file: str) -> int:
    """
    problem2
    """
    with open(file, "r") as f:
        grid = f.read().splitlines()

    def find_scenic(trees: list, height: int) -> int:
        """
        Find the scenic value.
        """
        for count, tree in enumerate(trees, 1):
            if tree >= height:
                return count
        return len(trees)

    scene = 0

    for count_y, y in enumerate(grid):
        for count_x, x in enumerate(y):
            if not (count_x in (0, len(y)) or count_y in (0, len(grid) - 1)):
                right = find_scenic(
                    [grid[count_y][coord] for coord in range(count_x + 1, len(y))], x
                )
                left = find_scenic(
                    list(
                        reversed([grid[count_y][coord] for coord in range(0, count_x)])
                    ),
                    x,
                )

                up = find_scenic(
                    list(
                        reversed([grid[coord][count_x] for coord in range(0, count_y)])
                    ),
                    x,
                )
                down = find_scenic(
                    [grid[coord][count_x] for coord in range(count_y + 1, len(y))], x
                )

                scene = max(scene, left * down * right * up)
    return scene


print(problem1("data.txt"))
print(problem2("data.txt"))
