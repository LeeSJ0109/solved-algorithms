def Decoding(string):
    base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
    origin = ""
    origin_text = ""
    for s in string:
        origin += bin(base64.find(s))[2:].rjust(6, '0')
    
    for i in range(0, len(origin), 8):
        origin_text += (chr(int(origin[i:i + 8], 2)))
        
    return origin_text

T = int(input())

for t in range(T):
    print('#' + str(t + 1), Decoding(input()))