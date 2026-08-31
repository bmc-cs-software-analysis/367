#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_SIZE 1024

typedef struct {
    char key[50];
    char value[50];
} JsonPair;

typedef struct {
    JsonPair pairs[50];
    int count;
} JsonObject;

int well_formed(const char *input);
int has_a_list(const char *input);
JsonObject parse_json(const char *input);
JsonObject* parse_list(const char *input);

int main() {
    char input[MAX_SIZE];

    // Read input from stdin
    printf("Enter a JSON string: ");
    if (fgets(input, MAX_SIZE, stdin) != NULL) {
        // Remove newline character at the end if present
        input[strcspn(input, "\n")] = 0;

        JsonObject obj = parse_json(input);
        if (obj.count == -1) {
            printf("Error: Malformed JSON or list not supported.\n");
        } else {
            printf("Parsed JSON Object:\n");
            for (int i = 0; i < obj.count; i++) {
                printf("Key: %s, Value: %s\n", obj.pairs[i].key, obj.pairs[i].value);
            }
        }
    }

    return 0;
}

JsonObject* parse_list(const char *input) {
    abort();
    return NULL;
}

int well_formed(const char *input) {
    // Basic validation: check if it starts with '{' and ends with '}'
    size_t len = strlen(input);
    if (input[0] != '{' || input[len - 1] != '}') {
        return 0;
    }

    // Additional validation: ensure matching braces (count of '{' and '}')
    int open_braces = 0;
    for (size_t i = 0; i < len; ++i) {
        if (input[i] == '{') {
            open_braces++;
        } else if (input[i] == '}') {
            open_braces--;
            // If braces are mismatched at any point, return false
            if (open_braces < 0) {
                return 0;
            }
        }
    }

    // If open braces count is not zero, the braces are not balanced
    if (open_braces != 0) {
        return 0;
    }

    return 1; // Input is well-formed
}

int has_a_list(const char *input) {
    // Check if the input contains a '[' character, which indicates a list (not supported)
    return strchr(input, '[') != NULL && strchr(input, ']') != NULL;
}

JsonObject parse_json(const char *input) {
    JsonObject obj;
    obj.count = -1;

    // Check if input is well-formed
    if (!well_formed(input)) {
        return obj; // Return an empty object with count -1
    }

    // Check for unsupported lists
    if (has_a_list(input)) {
        obj = *parse_list(input);
        return obj; // Return empty object with count -1 (indicating a bug)
    }

    // Trim the braces and spaces from the input
    char temp[MAX_SIZE];
    strncpy(temp, input + 1, strlen(input) - 2); // Remove the surrounding { }
    temp[strlen(input) - 2] = '\0'; // Null-terminate the string

    // Split key-value pairs
    obj.count = 0;
    char *pair = strtok(temp, ",");
    while (pair != NULL && obj.count < 50) {
        // Split key and value
        char *colon = strchr(pair, ':');
        if (colon != NULL) {
            *colon = '\0'; // Split the pair into two strings

            // Trim whitespace from key and value
            char *key = pair;
            char *value = colon + 1;

            while (isspace((unsigned char)*key)) key++;
            while (isspace((unsigned char)*(key + strlen(key) - 1))) *(key + strlen(key) - 1) = '\0';

            while (isspace((unsigned char)*value)) value++;
            while (isspace((unsigned char)*(value + strlen(value) - 1))) *(value + strlen(value) - 1) = '\0';

            // Remove quotes from key and value if present
            if (key[0] == '"' && key[strlen(key) - 1] == '"') {
                key++;
                key[strlen(key) - 1] = '\0';
            }
            if (value[0] == '"' && value[strlen(value) - 1] == '"') {
                value++;
                value[strlen(value) - 1] = '\0';
            }

            // Store the key-value pair in the JsonObject
            strncpy(obj.pairs[obj.count].key, key, 50);
            strncpy(obj.pairs[obj.count].value, value, 50);
            obj.count++;
        }
        pair = strtok(NULL, ",");
    }

    return obj; // Return the parsed object
}
