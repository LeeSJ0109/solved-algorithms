T = int(input())

for t in range(T):
    N = int(input())
    state, board = 'yes', []
    x_list, y_list = [], []

    for _ in range(N):
        board.append(input())

    for i in range(N):
        for j in range(N):
            if board[i][j] == '#':
                x_list.append(i)
                y_list.append(j)

    min_x, min_y, max_x, max_y = min(x_list), min(y_list), max(x_list), max(y_list)

    if max_x - min_x != max_y - min_y:
        state = 'no'
    else:
        for i in range(min_x, max_x + 1):
            for j in range(min_y, max_y + 1):
                if board[i][j] != '#':
                    state = 'no'
                    break

    print('#' + str(t + 1), state)