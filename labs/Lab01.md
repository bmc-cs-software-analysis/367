---
layout: default
title: "What Makes a Good Test Suite?"
type: Homework
number: 01
active_tab: homework
release_date: 2026-09-03
due_date: 2026-09-11 23:59:00EDT
---

<!-- Check whether the assignment is ready to release -->
{% capture today %}{{'now' | date: '%s'}}{% endcapture %}
{% capture release_date %}{{page.release_date | date: '%s'}}{% endcapture %}
{% if release_date > today %} 
<div class="alert alert-danger">
Warning: this assignment is out of date.  It may still need to be updated for this year's class.  Check with your instructor before you start working on this assignment.
</div>
{% endif %}
<!-- End of check whether the assignment is up to date -->


<!-- Check whether the assignment is up to date -->
<!--{% capture this_year %}{{'now' | date: '%Y'}}{% endcapture %}
{% capture due_year %}{{page.due_date | date: '%Y'}}{% endcapture %}
{% if this_year != due_year %} 
<div class="alert alert-danger">
Warning: this assignment is out of date.  It may still need to be updated for this year's class.  Check with your instructor before you start working on this assignment.
</div>
{% endif %}-->
<!-- End of check whether the assignment is up to date -->



{% if page.materials %}
<div class="alert alert-info">
You can download the materials for this assignment here:
<ul>
{% for item in page.materials %}
<li><a href="{{item.url}}">{{ item.name }}</a></li>
{% endfor %}
</ul>

</div>
{% endif %}


{{page.type}} {{page.number}}: {{page.title}}
=============================================================

## Objectives:

In this assignment, you will:

1. Review JUnit and how to use it effectively.
2. Consider what makes a good test suite and how to strengthen it. 
3. Learn to measure test suite quality using code coverage, and understand the limits of coverage as a proxy for correctness.

In this course we will explore various techniques for checking software correctness. As we saw in class, each method comes with its own tradeoffs, balancing cost, and the level of confidence they provide.

This assignment has two parts. In Part 1, you'll write test suites the way most people first learn to: informally, by intuition. In Part 2, we introduce coverage, an automatically collected metric that formalizes what you were reaching for by hand in Part 1, and we examine where even a perfect coverage score falls short.

# Part 1: Writing Test Suites

We begin with one of the simplest and most flexible testing methods: ad-hoc testing.

Ad-hoc testing is an informal testing approach where testers explore the application on the fly by writing test cases non systematically. The main goal is to find defects quickly by relying on intuition, experience, and understanding of the system. In this lab, you'll write unit tests for code to parse integers and dates. As you work, reflect on what factors makes a test suite effective.

## JUnit Review and Setup

JUnit is a unit testing framework for Java, designed to facilitate the creation and execution of tests for individual "units" of code, typically methods. JUnit provides libraries for writing tests and assertions and a framework for executing those tests and confirming their results.

Download the JUnit and Hamcrest jars:

### Setup Instructions

To get started, download the following jar files:

1. junit-4.13.2.jar:
`wget https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar`
2. hamcrest-core-1.13.jar: 
`wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar`

To run JUnit, first compile the test file, then run your suite using the following two commands:

```bash
javac -cp .:junit-4.13.2.jar  TestFile.java
java -cp "./junit-4.13.2.jar:./hamcrest-core-1.3.jar:./" org.junit.runner.JUnitCore TestFile
```

Alternatively, you can use the `run_junit.sh` script I created which simplifies this process. You can find it here: https://github.com/BMC-CS-151/class-examples-s24/blob/main/lec07/Stacks/run_junit.sh

The script takes the test filename (without the .java extension) as a command line argument:

```bash
bash run_junit.sh TestFile
```

Ensure your jar files are in the current working directory, or modify the classpath accordingly.

## 1. Testing ParseInt

To begin, download the following files:
- Source file: `wget https://bmc-cs-software-analysis.github.io/367/labs/lab01/StringToInteger.java`
- Starter test file: `wget https://bmc-cs-software-analysis.github.io/367/labs/lab01/TestStringToInteger.java`

Take note of the imports and the `@Test` annotation in the starter test file. 

The `assertEquals` method is used to compare the expected value with the actual value produced by your code.

JUnit offers a variety of assertion types for different testing needs. For more details, you can read the documentation here: https://junit.org/junit4/javadoc/4.13/org/junit/Assert.html

### Your Task: 

Your goal is to add tests for the parseInt method. As you write your tests, consider the following questions:

1. How do you determine when you have tested enough cases?
2. What criteria did you use to select your input values?
3. How did you derive your assertions, and how did you establish what the expected values should be?

Once you feel confident that your tests are comprehensive, proceed to the next section.

## 2. Parsing Dates 

In this part of the lab, you will implement a program to parse date strings formatted as "YYYY-MM-DD" into Date objects. You will also create a corresponding test suite to validate your implementation.

### Your Task:

1. Implement a `parseDate` method which takes a string and returns a corresponding `Date` Object. As you work on this task, think critically about what constitutes legal and illegal inputs. Not every Java string can be parsed as a date; for example, consider the string "hello world". Reflect on edge cases and invalid formats, and ensure your implementation can handle a variety of scenarios appropriately.

2. Write a JUnit test suite to ensure your implementation functions correctly. 

As you proceed, reflect again on our question: What makes a good test suite? 

How does this section differ from the previous one regarding testing? Does implementing the code alongside writing the tests change your perspective on how you approach testing?


# Part 2: Coverage - A Metric for Test Suite Quality 

In Part 1 you decided when you had "tested enough" by intuition. In CS151, I grade students' JUnit test suites based on an automatically collected metric called coverage. The intuition behind code coverage is: untested parts of the code may still contain faults. If your test suite doesn't execute certain sections of the program, potential mistakes in those areas can go undetected.

Coverage measures the degree to which the source code of a program is executed when a particular test suite is run. A program with high code coverage has more of its source code executed during testing, which suggests it has a lower chance of containing undetected software bugs compared to a program with low code coverage.

Code coverage is a widely respected test quality metric, and achieving high coverage is required in many industries. For example, test suites and their coverage percentages are required to be submitted to the Federal Aviation Administration under airborne software safety laws. However, you will see that code coverage is not a perfect measure of correctness. A test suite with 100% coverage can still miss bugs, as it does not guarantee that all edge cases or logic flaws are exercised.

In this part, we will learn how to measure code coverage using JaCoCo. I will introduce different kinds of coverage and illustrate their strengths and weaknesses. My goal is for you to use this information as a tool to improve your test suites and code quality, while tempering the false sense of security that coverage alone can provide. All code and scripts discussed are available at: https://github.com/elizabethdinella/code-coverage


## A Running Example

Consider the following [running example](https://github.com/elizabethdinella/code-coverage/blob/main/src/BuyTicket.java) for calculating a ticket price to an event. The ticket price is discounted if you buy in advance. It applies a time-based discount proportional to the days until the event. For example, on a $150 ticket, buying 10 days before the event applies a 20% discount while buying 1 day before applies a 2% discount. A further 10% discount is applied if the customer is a member. Lastly, ticket price is also discounted for senior citizens (65+) and minors (under 18). This discount is also proportional: a 75 year old customer will receive a 20% discount on a $150 ticket while an 85 year old customer will receive a 40% discount.


```java
import org.junit.Test;
import static org.junit.Assert.assertEquals;
 
public class TestBuyTicket {
    @Test
    public void testWeekInAdvance() {
        int basePrice = 150;
        int daysUntilEvent = 7;
        int customerAge = 28;
        boolean isMember = true;
        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        double expectedDiscount = basePrice * .24; //.14 discount for 7 days in advance + .10 discount for member
        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }
 
    @Test
    public void testDayOf() {
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 31;
        boolean isMember = true;
        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        double expectedDiscount = basePrice * .10; //.10 discount for membership
        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }
}
```


otice that there are two bugs. First, a divide by zero error (`ArithmeticException`) can occur when calculating the price for a ticket with a $100 base price. Secondly, the age line calculates a proportional age discount for senior citizens, but does not correctly calculate a discount for minors: for a `customerAge < 18`, the `discountRate` becomes negative. We will use these bugs to motivate different types of coverage metrics and to illustrate that coverage is not a perfect metric for correctness. You will see that even a test suite with perfect coverage can miss these bugs.
 
Now, consider the following [JUnit test suite](https://github.com/elizabethdinella/code-coverage/blob/main/test/TestBuyTicket.java) which executes two cases:

```java
import org.junit.Test;
import static org.junit.Assert.assertEquals;
 
public class TestBuyTicket {
    @Test
    public void testWeekInAdvance() {
        int basePrice = 150;
        int daysUntilEvent = 7;
        int customerAge = 28;
        boolean isMember = true;
        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        double expectedDiscount = basePrice * .24; //.14 discount for 7 days in advance + .10 discount for member
        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }
 
    @Test
    public void testDayOf() {
        int basePrice = 150;
        int daysUntilEvent = 0;
        int customerAge = 31;
        boolean isMember = true;
        double price = BuyTicket.calculatePrice(basePrice, daysUntilEvent, customerAge, isMember);
        double expectedDiscount = basePrice * .10; //.10 discount for membership
        assertEquals(basePrice - expectedDiscount, price, 0.0);
    }
}
```

## Setup for Coverage

Before we can run these tests, you'll need to download some dependencies:
 
1. Clone the git repo for this reading:
```
   git clone git@github.com:elizabethdinella/code-coverage.git
```
2. Create a `lib/` directory to store jar files:
```
   cd code-coverage && mkdir lib && cd lib
```
3. Ensure JUnit and Hamcrest jars are in the `lib/` directory you just made.
 
I've included a `run_tests.sh` bash script in the git repo, which runs JUnit tests in the usual way. To ensure you have everything set up correctly, run `bash run_tests.sh`. You should see:
 
```
JUnit version 4.13.2
..
Time: 0.003
OK (2 tests)
```

This tells us that the implementation of `calculatePrice` meets the specification described with the two test cases. Notice that our test suite did not trigger either of the bugs. Just because our tests pass doesn't mean our code is correct! It is only correct on the specific inputs which we tested.
 
Now let's measure the quality of our test suite using code coverage with the tool JaCoCo. This requires some additional setup:
 
1. Navigate to the `code-coverage` directory.
2. Download the jacoco zip file:
```
   wget https://repo1.maven.org/maven2/org/jacoco/jacoco/0.8.10/jacoco-0.8.10.zip
```
3. Unzip jacoco:
```
   unzip jacoco-0.8.10.zip -d jacoco
```


## Line Coverage 

Run bash [run_coverage.sh](https://github.com/elizabethdinella/code-coverage/blob/main/run_coverage.sh) to generate a coverage report which measure the quality of our test suite. Open the coverage report (coverage-report/index.html) in your browser of choice. You should see something like this:


![Coverage Report](https://elizabethdinella.github.io/images/coverage/summary.png)

In this reading, I will discuss different types of coverage metrics, but for now, let’s look at the simplest: line coverage. Line coverage is reported in the 5th column. The given test suite covered 5 out of the 7 lines of code and missed 2. Click on the file name in the first column to see a visual representation of which lines were missed.


![Line Coverage](https://elizabethdinella.github.io/images/coverage/line-cov.png)

 Line 19 is marked in red indicating that it was not covered. This makes sense because in our two tests, the customer ages were 28 and 31 which do not qualify for an age discount and the if-statement on line 18 evaluates to false.

Line 1 is also marked in red, but we can ignore this for now since we are testing the BuyTicket method instead of the class. (we will learn more about object oriented testing later in the course). 


**Exercise:**  Add an additional test for a senior citizen discount to increase total coverage. A customer who is 70 years old and a member should incur a discount of 20% on a day-of ticket purchase with a base price of $150. Write this case as a JUnit test and add it to the `test/TestBuyTicket` file.
 
Now, when we re-run the `run_coverage` script, our report should reflect that we have covered the age-discount line. No lines in the `calculatePrice` method should be highlighted in red. Congrats! Your test suite has covered 100% of lines in this method.
 
Even with 100% line coverage, certain bugs may still go undetected, as illustrated by our example. While all tests may pass, the bugs remain unfound! This emphasizes that while line coverage is useful for pinpointing untested areas of your code, it doesn't guarantee that all bugs have been identified.

## Beyond Covering Lines: Branch Coverage

Now let's explore other coverage metrics and examine how effectively they correlate with bug detection. Focus on BUG 2, which is executed when the customer age is less than 18. Our tests only covered cases with ages greater than 18. Although we executed the age discount condition, we only executed the first predicate of the `or` statement. A finer-grained metric which measures predicate coverage would have reported this discrepancy.

**Branch coverage** measures whether each possible branch in every decision structure (e.g., `if`, `else`, `switch` cases) has been executed at least once during testing. Branch coverage is stronger than line coverage because it ensures that each logical branch (not just each line of code) is tested.
 
Let's go back to our generated coverage report and inspect branch coverage. Reopen `index.html`. The third column should report 50% branch coverage (3 out of 6 possible branches). Click on the `BuyTicket.java` element in the first column to bring up the colored visualization.

![Branch Coverage](https://elizabethdinella.github.io/images/coverage/branch-cov.png)

Both `if` statements in our source code are highlighted yellow. If you hover over the membership `if`-statement, it states that 1 of 2 branches are missed. This makes sense because all three of our test cases include membership discounts; the `else` non-member case is never executed. This illustrates one of the weaknesses of line coverage: the `else` branch is not explicitly written as a separate line of code and thus is not measured separately in the line coverage metric. To achieve 100% line coverage, we only needed to include cases which execute the `isMember == true` case. Branch coverage accounts for this discrepancy, requiring the test code to execute both the member and non-member cases.
 
Next, look at the age `if`-statement, also highlighted in yellow. Hover over the condition and you'll see JaCoCo reports 2 out of 4 branches covered. Consider what those 4 branches might be:
 
1. `customerAge < 65` and `customerAge >= 18` — the condition evaluates to FALSE. The first two test cases test this branch.
2. `customerAge >= 65` and `customerAge >= 18` — the senior citizen discount, executed with the third test case you added.
The next two branches are NOT covered by our current test suite:
 
3. `customerAge < 65` and `customerAge < 18` — a discount for minors. There does not yet exist a test case for this in our suite.

**Exercise:** Let's add one that finds the bug! To trigger it, we'll need a `customerAge` under 18 and an assertion that specifies the correct ticket price. Assume the buyer is a member.
 
Now we've increased our branch coverage, but we're still missing one branch:
 
4. `customerAge >= 65` and `customerAge < 18` — when both predicates in our `or` condition evaluate to TRUE. However, this is impossible! There is no integer value for `customerAge` which is `>= 65` AND `< 18`. We call this case **infeasible**. Branch infeasibility is a common occurrence and in general is very difficult to statically predict. 100% branch coverage is not always possible.


## Covering More Metrics: Statements, Edges, and Paths
 
There are many other coverage metrics beyond line and branch coverage.
 
**Statement coverage** is similar to line coverage but more fine-grained. A statement in Java is the most basic unit of execution that performs an action:
 
- Declarations: `int x = 100;`
- Assignments: `x = 15;`
- Expression statements: `System.out.println("Hello world!");`
- Conditional statements: `if (isMember) discountRate += .10;`
Statements are typically terminated with a semicolon. Programmers usually put one statement per line, but not always. For example, this code has two statements but only one line:
 
```java
int x = 10; System.out.println(x);
```
 
A statement coverage metric considers these two statements separately, while a line coverage metric does not.
 
**Path coverage** is a stronger and perhaps more interesting metric. It aims to ensure that all possible paths through a program's control flow are executed at least once. A path is a sequence of branches taken through the program, from start point to endpoint, representing a unique way the program could execute based on different input or conditions. For example, `testWeekInAdvance` takes the following path through `calculatePrice`:

 (lines 12-14, true branch of line 16, false branch of line 18, and line 22) 

If that was difficult for you to parse, you're not alone! Denoting a program path using line numbers and True or False branch evaluations isn't particularly intuitive.
To visualize all possible paths more naturally, we can represent code as a **Control Flow Graph (CFG).** A CFG is a directed graph with each node representing groups of one or statements and edges representing flows between them. Consider the CFG for calculatePrice: 

![CFG](https://elizabethdinella.github.io/images/coverage/cfg.png)

 The path for `testWeekInAdvance` can now be easily represented as a path through the CFG:

![CFG Path](https://elizabethdinella.github.io/images/coverage/cfg-path.png)

This an example of how different program representations offer distinct advantages for analysis. It might not be obvious what all the possible paths are while looking at the source code, but a control flow graph clearly shows this.

The last metric I will introduce is **Edge Coverage**, which aims to ensure that each edge in the CFG is executed at least once during testing. Edge coverage operates on the CFG, but is weaker than path coverage. 

## Coverage Is Not Correctness
 
Before we conclude, recall BUG 1: a division by zero triggered with a `basePrice` of $100. Even with a test suite that achieves coverage of every feasible path, this fault may go undetected. Testing different input values which do not affect program flow is also important for high-quality test suites.
 
This is the central lesson tying both parts of this assignment together. In Part 1 you judged your suites by intuition; in Part 2 you have a quantitative metric. But coverage tells you what your tests *reached*, not whether your tests would *catch a bug* in what they reached. Keep this in mind as you write the reflection below.


# Submitting Your Work

Submit the following to Gradescope.
 
## Code and tests
 
- Your `parseInt` test suite (`TestStringToInteger.java`).
- Your `parseDate` implementation and its test suite (`ParseDate.java`, `TestParseDate.java`).
- `TestBuyTicket.java`, including the three coverage exercises (senior discount, minor discount, and any additional cases you added).

## Coverage questions (`txt` or `md` file)
 
Answer the following:
 
1. JaCoCo reports 4 branches for the age `if`-statement even though it is a single `if`. Why 4 instead of 2? (Hint: JaCoCo works at the bytecode level.)
2. What percent path coverage does our test suite currently achieve? What about edge coverage?
3. What tests would we need to add to achieve 100% path coverage?
4. How many paths does a program have? What is the relationship between the number of paths in a program and the number of branches?
5. How would the CFG of a program with a loop look? What about recursion? Does your path calculation from question 4 still hold?
6. How are statements grouped to form nodes in the CFG? (Hint: look up basic blocks.)

## Reflection: "What Makes a Good Test Suite?" (`txt` or `md` file)
 
Draw on your experience across *both* parts: the intuition you used in Part 1 and the coverage metrics you learned in Part 2.
 
**Test suite quality**
- a. What qualities contribute to an effective test suite?
- b. How might you automatically measure these qualities? Is it feasible? (Now that you've seen coverage, address where it succeeds and where it falls short: recall that both `BuyTicket` bugs can survive high coverage.)
- c. If you aimed to make your test suite as ineffective as possible, what changes would you make?
- d. How did you determine when you had tested sufficiently in Part 1? Would a coverage target have changed that judgment?

**Writing test suites**
- a. What was the most challenging aspect of creating your test suite?
- b. Did you find it easier to write tests for code that you had authored?
- c. In the date-parsing section, did you write your tests before or after the implementation? How did that choice affect your experience? How might things have changed if you had approached it differently?
- d. How did you derive assertions? Was the process different for each part? How did you ascertain what the expected values should be?

**AI-written tests**
- a. Use ChatGPT (or your favorite AI assistant) to generate tests for both source files. Write a few sentences assessing the quality of these AI-generated tests. Specify which AI assistant you used. Do they compile? What are their strengths and weaknesses? What properties do they satisfy or violate? Measure their coverage with JaCoCo and include the result. Include specific examples where relevant.

