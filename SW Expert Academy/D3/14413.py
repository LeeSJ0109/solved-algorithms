T = int(input())

for t in range(T):
    N, M = map(int, input().split())
    state, board = 'possible', []

    for i in range(N):
        board.append(input())

    check_pattern = False
    for i in range(N):
        for j in range(M):
            if board[i][j] == '#':
                hash_index = (i + j) % 2
                dot_index = (hash_index + 1) % 2
                check_pattern = True
                break
            elif board[i][j] == '.':
                dot_index = (i + j) % 2
                hash_index = (dot_index + 1) % 2
                check_pattern = True
                break

        if check_pattern:
            break

    if check_pattern:
        for i in range(N):
            for j in range(M):
                if board[i][j] == '#' and (i + j) % 2 == dot_index:
                    state = 'impossible'
                elif board[i][j] == '.' and (i + j) % 2 == hash_index:
                    state = 'impossible'

    print('#' + str(t + 1), state)