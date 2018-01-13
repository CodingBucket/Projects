
import io

# File create
with io.FileIO("foobar.txt", "w") as file:
    handle1 = open('foobar.txt', 'r+')
    handle1.write("I AM NEW FILE")
    handle1.close()