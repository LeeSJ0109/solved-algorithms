T = int(input())

for t in range(T):
    board = []
    for _ in range(8):
        board.append(input())

    rook_index = [b.find('O') for b in board]
    rook_count = [b.count('O') for b in board]
    rook_index.sort()

    state = "no"
    if rook_index == [i for i in range(8)] and rook_count == [1 for _ in range(8)]:
        state = "yes"

    print('#' + str(t + 1), state)