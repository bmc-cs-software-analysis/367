KEY="API_KEY"
PROMPT="What is the best airport in the United States?"

curl 'https://router.huggingface.co/v1/chat/completions' \
-X POST \
--header "Authorization: Bearer $KEY" \
--header 'Content-Type: application/json' \
--data "{
    \"model\": \"meta-llama/Llama-3.1-8B-Instruct\",
    \"messages\": [
        { \"role\": \"user\", \"content\": \"$PROMPT\" }
    ],
    \"temperature\": 0.5,
    \"max_tokens\": 2048,
    \"top_p\": 0.7
}"
