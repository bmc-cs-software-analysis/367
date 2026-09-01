#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
  char input[65536];
  fgets(input, sizeof(input), stdin);
  int x = 13;
  int z = 21;
  int y = 0;

  if (strlen(input) > 10 && input[5] == 'a') {
    z = x / y;
    abort();
  }

  return 0;
}
