import com.microsoft.z3.*;

public class HW7Part1 {

    public static void f1() {
        //Boolean Proposition 1:  ~~A

        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare boolean variables 

        //query the solver
    }

    public static void f2() {
        //Boolean Proposition 2:  A ^ ~A

        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare boolean variables 

        //query the solver
    }


    public static void f3() {
        //Boolean Proposition 3:  (A v B) ^ (~A v C) ^ (~B v ~C)

        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare boolean variables 

        //query the solver

    }


    public static void f4() {
        //Boolean Proposition 4: (A∨B∨C)∧(¬A∨D)∧(¬B∨¬D)∧(C∨¬D)∧(A∨¬C) 

        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare boolean variables 

        //query the solver

    }

    public static void f5() {
        //Boolean Proposition 5: (A∨B∨C)∧(¬A∨D)∧(¬B∨D)∧(¬C∨D)∧(¬D∨E)∧(A∨¬E)∧(B∨¬E)∧(C∨¬E)∧(¬A∨¬B)∧(¬B∨¬C)∧(¬A∨¬C)

        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare boolean variables 

        //query the solver
    }

    public static void prog1() {
        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare integer variables 
        ArithExpr x = (ArithExpr) ctx.mkIntConst("X");
        ArithExpr y = (ArithExpr) ctx.mkIntConst("Y");

    }

    public static void prog2() {
        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare integer variables 
        ArithExpr x = (ArithExpr) ctx.mkIntConst("X");
        ArithExpr y = (ArithExpr) ctx.mkIntConst("Y");
        ArithExpr z = (ArithExpr) ctx.mkIntConst("Z");

    }

    public static void example() {
        //setup solver
        Context ctx = new Context(); 
        Solver solver = ctx.mkSolver();

        //declare boolean variables p, q, and r
        BoolExpr p = ctx.mkBoolConst("p");
        BoolExpr q = ctx.mkBoolConst("q");
        BoolExpr r = ctx.mkBoolConst("r");

        //(p V q)
        BoolExpr clause1 = ctx.mkOr(p,q);
        //(p V ~r)
        BoolExpr clause2 = ctx.mkOr(p,ctx.mkNot(r));


        //(p V q) ^ (p V ~r) 
        solver.add(ctx.mkAnd(clause1, clause2));

        //query the solver
        System.out.println(solver.check());
        //get the last model - throws NPE if it is UNSAT
        System.out.println(solver.getModel());
    }

    public static void main(String[] args) {
        
        System.out.println();
        System.out.println("================ EXAMPLE ================");
        example();

        System.out.println();
        System.out.println("================ PROPOSITION 1 ================");
        f1();

        System.out.println();
        System.out.println("================ PROPOSITION 2 ================");
        f2();

        System.out.println();
        System.out.println("================ PROPOSITION 3 ================");
        f3();

        System.out.println();
        System.out.println("================ PROPOSITION 4 ================");
        f4();

        System.out.println();
        System.out.println("================ PROPOSITION 5 ================");
        f5();

        System.out.println();
        System.out.println("================ PROGRAM 1 ================");
        prog1();

        System.out.println();
        System.out.println("================ PROGRAM 2 ================");
        prog2();

    }
}
