# Java Functional Programming — Revision Notes

---

## 1. Core Concepts of Functional Programming in Java

Java is not a pure FP language, but since Java 8 it has FP-capable features:

**First-class functions** — functions as values, passed around and returned.
**Pure functions** — no side effects; same input → same output always.
**Immutability** — prefer final fields, immutable collections, no mutation.
**Referential transparency** — expression can be replaced by its result without changing behaviour.
**Higher-order functions** — functions that take or return other functions (e.g. `map`, `filter`, `reduce`).

Java enables all of this via **lambda expressions**, **method references**, and **functional interfaces**.

---

## 2. Functional Interface — The Foundation

A **functional interface** has exactly **one abstract method** (SAM — Single Abstract Method). It can have multiple `default` and `static` methods.

```java
@FunctionalInterface  // optional but recommended — compiler enforces SAM rule
public interface MyAction {
    void execute(String input);  // SAM
    default void log() { System.out.println("running"); }  // allowed
}
```

Any functional interface can be implemented with:

- A **lambda**: `(x) -> x.toUpperCase()`
- A **method reference**: `String::toUpperCase`
- An **anonymous class**: `new MyAction() { ... }`

All three are equivalent — lambdas are syntactic sugar over an anonymous class implementing the SAM.

---

## 3. Functional Interface Hierarchy

All 43 built-in interfaces live in `java.util.function`.

```
java.util.function
├── Function<T,R>             apply(T) → R
│   ├── BiFunction<T,U,R>     apply(T,U) → R
│   ├── UnaryOperator<T>      apply(T) → T      ← extends Function<T,T>
│   ├── BinaryOperator<T>     apply(T,T) → T    ← extends BiFunction<T,T,T>
│   ├── IntFunction<R>        apply(int) → R
│   ├── LongFunction<R>       apply(long) → R
│   ├── DoubleFunction<R>     apply(double) → R
│   ├── ToIntFunction<T>      applyAsInt(T) → int
│   ├── ToLongFunction<T>     applyAsLong(T) → long
│   ├── ToDoubleFunction<T>   applyAsDouble(T) → double
│   ├── IntUnaryOperator      applyAsInt(int) → int
│   ├── LongUnaryOperator     applyAsLong(long) → long
│   ├── DoubleUnaryOperator   applyAsDouble(double) → double
│   ├── IntBinaryOperator     applyAsInt(int,int) → int
│   ├── ToIntBiFunction<T,U>  applyAsInt(T,U) → int
│   └── ... (Long/Double variants)
│
├── Predicate<T>              test(T) → boolean
│   ├── BiPredicate<T,U>      test(T,U) → boolean
│   ├── IntPredicate          test(int) → boolean
│   ├── LongPredicate         test(long) → boolean
│   └── DoublePredicate       test(double) → boolean
│
├── Consumer<T>               accept(T) → void
│   ├── BiConsumer<T,U>       accept(T,U) → void
│   ├── IntConsumer           accept(int) → void
│   ├── LongConsumer          accept(long) → void
│   ├── DoubleConsumer        accept(double) → void
│   ├── ObjIntConsumer<T>     accept(T, int) → void
│   ├── ObjLongConsumer<T>    accept(T, long) → void
│   └── ObjDoubleConsumer<T>  accept(T, double) → void
│
├── Supplier<T>               get() → T
│   ├── IntSupplier           getAsInt() → int
│   ├── LongSupplier          getAsLong() → long
│   ├── DoubleSupplier        getAsDouble() → double
│   └── BooleanSupplier       getAsBoolean() → boolean
│
└── Other @FunctionalInterfaces (outside java.util.function)
    ├── Runnable              run() → void
    ├── Callable<V>           call() → V  (throws Exception)
    └── Comparator<T>         compare(T,T) → int
```

---

## 4. Function\<T,R\> — Transformer

Takes T, returns R. The most general-purpose interface.

```java
// SAM: R apply(T t)
// Default methods: andThen(Function after), compose(Function before)
// Static:          identity()

Function<String, Integer> length = String::length;
length.apply("hello");   // 5

// compose: before → this
// andThen: this → after
Function<String, String> shout = s -> s.toUpperCase() + "!";
Function<String, Integer> len   = String::length;

Function<String, Integer> shoutLen = shout.andThen(len);
shoutLen.apply("hi");   // 3  ("HI!" has length 3)

Function<String, Integer> composed = len.compose(shout);
composed.apply("hi");   // 3  (same thing, different reading direction)

Function.identity(); // returns its input unchanged — t -> t
```

**BiFunction\<T,U,R\>** — two inputs, one output:

```java
// SAM: R apply(T t, U u)
// Default: andThen (only — compose not available on BiFunction)
BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
repeat.apply("ab", 3);  // "ababab"
```

---

## 5. Predicate\<T\> — Tester

Takes T, returns boolean. Used heavily in `filter`.

```java
// SAM: boolean test(T t)
// Default: and(Predicate), or(Predicate), negate()
// Static:  not(Predicate), isEqual(Object)

Predicate<String> notEmpty = s -> !s.isEmpty();
Predicate<String> longWord = s -> s.length() > 5;

Predicate<String> valid = notEmpty.and(longWord);
Predicate<String> either = notEmpty.or(longWord);
Predicate<String> empty  = notEmpty.negate();

Predicate<String> notNull = Predicate.not(Objects::isNull);   // Java 11+

list.stream().filter(valid).toList();

// BiPredicate<T,U>
// SAM: boolean test(T t, U u)
BiPredicate<String, String> startsWith = String::startsWith;
startsWith.test("hello", "he");  // true
```

---

## 6. Consumer\<T\> — Side-effect Action

Takes T, returns nothing. Used in `forEach`.

```java
// SAM: void accept(T t)
// Default: andThen(Consumer after)

Consumer<String> print  = System.out::println;
Consumer<String> log    = s -> logger.info(s);
Consumer<String> both   = print.andThen(log);  // chain side effects

list.forEach(both);

// BiConsumer<T,U>
// SAM: void accept(T t, U u)
BiConsumer<String, Integer> showEntry = (k, v) -> System.out.println(k + "=" + v);
map.forEach(showEntry);  // Map.forEach takes BiConsumer

// ObjIntConsumer<T> — avoids boxing
ObjIntConsumer<String> indexed = (s, i) -> System.out.println(i + ": " + s);
```

---

## 7. Supplier\<T\> — Factory / Lazy Provider

No input, returns T. Used for lazy evaluation and factory methods.

```java
// SAM: T get()

Supplier<List<String>> listFactory = ArrayList::new;
List<String> newList = listFactory.get();

// Lazy evaluation — value not computed until .get() is called
Supplier<String> expensive = () -> computeHeavyThing();
Optional.empty().orElseGet(expensive);  // only runs if Optional is empty
                                        // vs orElse(expensive.get()) — always runs!

// Useful pattern: lazy singleton
Supplier<Config> config = () -> Config.load();  // load only when needed
```

---

## 8. Operator Interfaces — Same Type In and Out

Operators are specialised Function/BiFunction where input and output types are identical.

```java
// UnaryOperator<T> extends Function<T,T>
// SAM: T apply(T t)
UnaryOperator<String> trim   = String::trim;
UnaryOperator<String> upper  = String::toUpperCase;
UnaryOperator<String> both   = trim.andThen(upper); // Function methods work too

list.replaceAll(trim);  // List.replaceAll takes UnaryOperator

// BinaryOperator<T> extends BiFunction<T,T,T>
// SAM: T apply(T t1, T t2)
// Static: maxBy(Comparator), minBy(Comparator)
BinaryOperator<Integer> add = Integer::sum;
BinaryOperator<String> concat = String::concat;

stream.reduce(0, add);  // Stream.reduce takes BinaryOperator

BinaryOperator<String> longer = BinaryOperator.maxBy(
    Comparator.comparingInt(String::length)
);

// Primitive operators — avoid boxing overhead
IntUnaryOperator doubler = n -> n * 2;
IntBinaryOperator multiply = (a, b) -> a * b;
```

---

## 9. Primitive Specialisations — Why They Exist

Using `Function<Integer, Integer>` boxes `int` → `Integer` on every call. For performance-critical code use primitive variants:

| Generic                      | Primitive equivalent | SAM               |
| ---------------------------- | -------------------- | ----------------- |
| `Function<Integer, R>`       | `IntFunction<R>`     | `apply(int)`      |
| `Function<T, Integer>`       | `ToIntFunction<T>`   | `applyAsInt(T)`   |
| `Function<Integer, Integer>` | `IntUnaryOperator`   | `applyAsInt(int)` |
| `Predicate<Integer>`         | `IntPredicate`       | `test(int)`       |
| `Consumer<Integer>`          | `IntConsumer`        | `accept(int)`     |
| `Supplier<Integer>`          | `IntSupplier`        | `getAsInt()`      |

All exist in `int`, `long`, and `double` variants. No `byte`, `short`, `float`, `char` variants exist — widen to `int`/`double` for those.

```java
IntStream.range(0, 1_000_000)
    .filter((IntPredicate) n -> n % 2 == 0)   // no boxing
    .map((IntUnaryOperator) n -> n * n)
    .sum();
```

---

## 10. Method References — Shorthand for Lambdas

Four kinds:

```java
// 1. Static method
Function<String, Integer> parse = Integer::parseInt;
// equivalent: s -> Integer.parseInt(s)

// 2. Instance method of a particular object
String prefix = "Hello ";
Function<String, String> greet = prefix::concat;
// equivalent: s -> prefix.concat(s)

// 3. Instance method of an arbitrary object of the type
Function<String, String> upper = String::toUpperCase;
// equivalent: s -> s.toUpperCase()

// 4. Constructor
Supplier<ArrayList<String>> make = ArrayList::new;
Function<Integer, int[]> arr     = int[]::new;
// equivalent: () -> new ArrayList<>()
```

---

## 11. Lambda Expressions — Syntax and Rules

```java
// Full form
(String s, int n) -> { return s.repeat(n); }

// Inferred types
(s, n) -> s.repeat(n)

// Single expression — no braces, no return
s -> s.toUpperCase()

// No args
() -> System.out.println("hi")

// Explicit return type — not possible directly; return type is always inferred

// Multi-statement — needs braces and return
(a, b) -> {
    int sum = a + b;
    return sum * 2;
}
```

---

## 12. Lexical Scoping in Lambdas

A lambda **closes over** its enclosing scope. Variables captured from the enclosing scope must be **effectively final** (not reassigned after initial assignment — the `final` keyword is optional).

```java
String prefix = "Hello";      // effectively final — never reassigned
Function<String, String> greet = name -> prefix + " " + name;

// This would NOT compile:
String mutable = "A";
mutable = "B";               // now NOT effectively final
Function<String, String> f = s -> mutable + s;  // compile error
```

**Why effectively final?** Lambdas in Java are closures over values, not variables. The JVM needs the captured value to be stable — it's copied into a hidden field of the lambda object. If the variable could change, the lambda would see a stale copy.

```java
// Common mistake — using loop variable
for (int i = 0; i < 5; i++) {
    final int captured = i;               // must capture a final copy
    executors.submit(() -> process(captured));
    // executors.submit(() -> process(i));  // compile error — i not effectively final
}
```

---

## 13. `this` and `super` Inside Lambdas

**Lambdas do NOT have their own `this`.** Unlike anonymous classes, a lambda does not introduce a new scope — `this` inside a lambda refers to the **enclosing class instance**.

```java
class Printer {
    String prefix = ">> ";

    Runnable makePrinter() {
        return () -> System.out.println(this.prefix + "done");
        //                              ^^^^ refers to Printer instance
    }
}
```

**Anonymous class `this`** refers to the anonymous class itself:

```java
class Printer {
    String prefix = ">> ";

    Runnable makePrinter() {
        return new Runnable() {
            String prefix = "anon";
            public void run() {
                System.out.println(this.prefix);  // "anon" — refers to Runnable instance
                System.out.println(Printer.this.prefix); // ">>" — outer class
            }
        };
    }
}
```

**`super` in lambdas** also refers to the enclosing class's superclass:

```java
class Child extends Parent {
    Runnable r = () -> super.doSomething(); // calls Parent.doSomething()
}
```

---

## 14. Default and Static Methods on Functional Interfaces

These do not count toward the SAM rule — you can have as many as you want.

```java
// default methods — instance methods on the interface (can be overridden)
Function<T,R>
    .andThen(Function<R,V> after)   // this → after
    .compose(Function<V,T> before)  // before → this

Predicate<T>
    .and(Predicate<T> other)
    .or(Predicate<T> other)
    .negate()

Consumer<T>
    .andThen(Consumer<T> after)

// static methods — utility factory methods
Predicate.not(Predicate<T> p)        // Java 11
Predicate.isEqual(Object target)
Function.identity()
BinaryOperator.maxBy(Comparator<T>)
BinaryOperator.minBy(Comparator<T>)
Comparator.comparing(Function<T,U> key)
Comparator.comparingInt(ToIntFunction<T>)
```

---

## 15. Function Composition — The Big Picture

```java
// andThen: do this THEN that
Function<Integer, Integer> times2 = x -> x * 2;
Function<Integer, Integer> plus3  = x -> x + 3;

times2.andThen(plus3).apply(5);   // (5*2)+3 = 13  → times2 first, then plus3
times2.compose(plus3).apply(5);   // (5+3)*2 = 16  → plus3 first, then times2

// Predicate chaining
Predicate<String> nonempty = s -> !s.isEmpty();
Predicate<String> shortStr  = s -> s.length() < 10;
Predicate<String> valid     = nonempty.and(shortStr);  // both must be true

// Consumer chaining — all execute, exceptions in first still run second? No.
// andThen: first executes, then second. If first throws, second doesn't run.
Consumer<String> a = s -> System.out.println("A: " + s);
Consumer<String> b = s -> System.out.println("B: " + s);
a.andThen(b).accept("hello");  // prints A: hello, then B: hello
```

---

## 16. Streams Integration — Where FP Shines

```java
List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");

// filter takes Predicate
// map takes Function
// forEach takes Consumer
// reduce takes BinaryOperator

words.stream()
    .filter(s -> s.length() > 4)          // Predicate
    .map(String::toUpperCase)              // Function / method ref
    .sorted(Comparator.naturalOrder())     // Comparator
    .forEach(System.out::println);         // Consumer / method ref

// reduce with BinaryOperator
int total = IntStream.rangeClosed(1, 10)
    .reduce(0, Integer::sum);             // IntBinaryOperator

// collect with Supplier + BiConsumer + BiConsumer (container factory, accumulator, combiner)
// Collector.of(Supplier, BiConsumer, BinaryOperator)

// flatMap takes Function<T, Stream<R>>
List<List<Integer>> nested = List.of(List.of(1,2), List.of(3,4));
List<Integer> flat = nested.stream()
    .flatMap(Collection::stream)
    .toList();   // Java 16+
```

---

## 17. Custom Functional Interfaces — When and How

Use a custom one when the built-in 43 don't fit (e.g. checked exceptions, 3 args, domain-specific naming):

```java
@FunctionalInterface
interface TriFunction<A, B, C, R> {
    R apply(A a, B b, C c);
}

// Functional interface that throws
@FunctionalInterface
interface CheckedSupplier<T> {
    T get() throws Exception;
}

// Wrap checked into unchecked for use in streams
static <T> Supplier<T> unchecked(CheckedSupplier<T> cs) {
    return () -> {
        try { return cs.get(); }
        catch (Exception e) { throw new RuntimeException(e); }
    };
}
```

---

## 18. Runnable vs Callable vs Supplier

| Interface     | Package                | SAM      | Returns | Throws checked? | Use case                   |
| ------------- | ---------------------- | -------- | ------- | --------------- | -------------------------- |
| `Runnable`    | `java.lang`            | `run()`  | void    | No              | Threads, tasks             |
| `Callable<V>` | `java.util.concurrent` | `call()` | V       | Yes             | `ExecutorService.submit()` |
| `Supplier<T>` | `java.util.function`   | `get()`  | T       | No              | Lazy values, factories     |

```java
// Runnable — no result
Runnable r = () -> System.out.println("running");
new Thread(r).start();

// Callable — result + checked exception
Callable<String> c = () -> Files.readString(Path.of("data.txt")); // throws IOException
Future<String> f = executor.submit(c);

// Supplier — result, no exception
Supplier<String> s = () -> "hello";
Optional.empty().orElseGet(s);
```

---

## 19. Quick Reference Card

| Interface           | In  | Out     | SAM            | Extras                                   |
| ------------------- | --- | ------- | -------------- | ---------------------------------------- |
| `Function<T,R>`     | T   | R       | `apply(T)`     | `andThen`, `compose`, `identity()`       |
| `BiFunction<T,U,R>` | T,U | R       | `apply(T,U)`   | `andThen`                                |
| `UnaryOperator<T>`  | T   | T       | `apply(T)`     | extends `Function<T,T>`                  |
| `BinaryOperator<T>` | T,T | T       | `apply(T,T)`   | `maxBy`, `minBy`                         |
| `Predicate<T>`      | T   | boolean | `test(T)`      | `and`, `or`, `negate`, `not()`           |
| `BiPredicate<T,U>`  | T,U | boolean | `test(T,U)`    | `and`, `or`, `negate`                    |
| `Consumer<T>`       | T   | void    | `accept(T)`    | `andThen`                                |
| `BiConsumer<T,U>`   | T,U | void    | `accept(T,U)`  | `andThen`                                |
| `Supplier<T>`       | —   | T       | `get()`        | —                                        |
| `Runnable`          | —   | void    | `run()`        | —                                        |
| `Callable<V>`       | —   | V       | `call()`       | throws checked                           |
| `Comparator<T>`     | T,T | int     | `compare(T,T)` | `comparing`, `thenComparing`, `reversed` |

---

## 20. Key Gotchas

```java
// 1. SAM must be abstract — default/static don't count
@FunctionalInterface
interface OK {
    void go();
    default void log() {}   // fine — not abstract
    static void help() {}   // fine — static
}

// 2. Checked exceptions can't be thrown from standard FI lambdas
Function<String, Integer> f = s -> Integer.parseInt(s);  // fine
Function<String, Path> g   = s -> Files.createFile(Path.of(s));  // COMPILE ERROR
// Solution: wrap or use custom @FunctionalInterface that throws

// 3. Lambda variables are NOT serializable by default unless the FI extends Serializable
Comparator<String> c = (Serializable & Comparator<String>) (a, b) -> a.compareTo(b);

// 4. Predicate.not() vs .negate() — both negate; not() is a static factory for method refs
list.stream().filter(Predicate.not(String::isEmpty));  // cleaner with method refs
list.stream().filter(((Predicate<String>) String::isEmpty).negate()); // equivalent, ugly

// 5. Identity function
Function.identity() == t -> t  // use when API needs a Function but you want passthrough
map.stream().collect(Collectors.toMap(Function.identity(), String::length));

// 6. this in lambda = enclosing class, NOT the lambda itself
// Use anonymous class if you need self-reference (e.g. recursive lambda via wrapper)

// 7. Effectively final — the VARIABLE must not be reassigned, not the object's contents
List<String> list = new ArrayList<>();  // effectively final (not reassigned)
list.add("item");                       // mutating contents is FINE
Runnable r = () -> list.add("more");    // legal
```

---

_java.util.function — 43 interfaces total | Java 8+ | All are @FunctionalInterface_
