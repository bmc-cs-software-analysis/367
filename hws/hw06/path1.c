#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char input[65536];
    fgets(input, sizeof(input), stdin);
    int x = 0;
    int y = 2;
    int z;
    if (strchr(input, 'A')) {  // Check for character 'A'
        if (strchr(input, 'B')) {
            if (strchr(input, 'C')) {
                if (strchr(input, 'D')) {
                    if (strchr(input, 'E')) {
                        if (strchr(input, 'F')) {
                            if (strchr(input, 'G')) {
                                if (strchr(input, 'H')) {
                                    if (strchr(input, 'I')) {
                                        if (strchr(input, 'J')) {
                                            z = y / x;  
                                            abort();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    return 0;
}
