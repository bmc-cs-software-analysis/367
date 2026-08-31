import random

def generate_clause(variables):
    """Generate a 3-literal clause with random negations."""
    chosen = random.sample(variables, 3)
    return tuple(random.choice([v, f'~{v}']) for v in chosen)

def generate_formula(num_vars=20, num_clauses=85):
    variables = [f'a{i}' for i in range(1, num_vars + 1)]
    clauses = [generate_clause(variables) for _ in range(num_clauses)]
    return [f"({c[0]} {c[1]} {c[2]})" for c in clauses]

if __name__ == "__main__":
    formula = generate_formula()
    for clause in formula:
        print(clause)
