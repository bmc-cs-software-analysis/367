method Square(x: int) returns (y: int)
  ensures y == x * x
{
  y := x * x;
}

method Divide(a: int, b: int) returns (q: int)
  requires b != 0
  ensures q * b == a || q * b + a % b == a
{
  q := a / b;
}
