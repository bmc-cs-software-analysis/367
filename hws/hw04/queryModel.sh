KEY="API_KEY"
PROMPT="What is the best airport in the United States?"

curl 'https://api-inference.huggingface.co/models/mistralai/Mistral-7B-Instruct-v0.3/v1/chat/completions' \
--header "Authorization: Bearer $KEY" \
--header 'Content-Type: application/json' \
--data "{
    \"model\": \"mistralai/Mistral-7B-Instruct-v0.3\",
    \"messages\": [
        { \"role\": \"user\", \"content\": \"$PROMPT\" }
    ],
    \"temperature\": 0.5,
    \"max_tokens\": 2048,
    \"top_p\": 0.7
}"
