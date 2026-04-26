# Java 21+ Collections Framework — Revision Notes

---

## 1. What's New in Java 21: The Sequenced Interfaces

Java 21 introduced **three new interfaces** to unify access to first/last elements across ordered collections:

| Interface                | Extends                            | Key Methods                                                                                                   |
| ------------------------ | ---------------------------------- | ------------------------------------------------------------------------------------------------------------- |
| `SequencedCollection<E>` | `Collection<E>`                    | `addFirst()`, `addLast()`, `getFirst()`, `getLast()`, `removeFirst()`, `removeLast()`, `reversed()`           |
| `SequencedSet<E>`        | `SequencedCollection<E>`, `Set<E>` | Inherits + no-add methods for sets                                                                            |
| `SequencedMap<K,V>`      | `Map<K,V>`                         | `firstEntry()`, `lastEntry()`, `putFirst()`, `putLast()`, `pollFirstEntry()`, `pollLastEntry()`, `reversed()` |

**Why they matter:** Before Java 21, getting the first/last element of a `LinkedHashSet` was awkward. Now it's `set.getFirst()`.

```java
// Java 21+
List<String> list = new ArrayList<>(List.of("a", "b", "c"));
list.getFirst();   // "a"
list.getLast();    // "c"
list.reversed();   // ["c", "b", "a"] — a reversed view

LinkedHashSet<Integer> lhs = new LinkedHashSet<>(Set.of(1, 2, 3));
lhs.getFirst();    // first inserted element
lhs.reversed();    // reversed view (SequencedSet)

LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
map.put("a", 1); map.put("b", 2);
map.firstEntry();  // a=1
map.lastEntry();   // b=2
```

---

## 2. The Iterable → Collection Hierarchy

```
Iterable<E>
  └── Collection<E>
        └── SequencedCollection<E>  ← NEW Java 21
              ├── List<E>
              ├── Queue<E>
              │     └── Deque<E>
              └── SequencedSet<E>   ← NEW Java 21
                    └── Set<E>
                          ├── SortedSet<E>
                          │     └── NavigableSet<E>
                          └── (HashSet, LinkedHashSet...)
```

---

## 3. LIST — Ordered, Duplicates Allowed

### Interfaces

- `List<E>` extends `SequencedCollection<E>`
- Index-based access: `get(int)`, `set(int, E)`, `add(int, E)`, `remove(int)`
- `ListIterator` for bidirectional traversal

### Implementations

| Class                  | Internal Structure   | `get(i)` | `add/remove (middle)` | Thread-safe?       | Notes                            |
| ---------------------- | -------------------- | -------- | --------------------- | ------------------ | -------------------------------- |
| `ArrayList`            | dynamic array        | O(1)     | O(n)                  | No                 | Default choice for lists         |
| `LinkedList`           | doubly-linked list   | O(n)     | O(1) at iterator      | No                 | Also implements `Deque`          |
| `Vector`               | dynamic array        | O(1)     | O(n)                  | Yes (synchronized) | **Legacy — avoid**               |
| `Stack`                | extends `Vector`     | O(1)     | —                     | Yes (synchronized) | **Legacy — use `Deque` instead** |
| `CopyOnWriteArrayList` | array, copy-on-write | O(1)     | O(n)                  | Yes                | Best for read-heavy concurrent   |

**Memory tip:**

- `ArrayList` wastes ~50% capacity on growth; call `trimToSize()` if memory matters
- `LinkedList` uses ~3× memory of `ArrayList` per element (node overhead)

```java
List<String> list = new ArrayList<>();       // default
List<String> immutable = List.of("a","b");   // Java 9+ immutable
List<String> copy = List.copyOf(existing);   // Java 10+ immutable copy
```

---

## 4. SET — No Duplicates

### Interfaces

- `Set<E>` — unordered (no guaranteed order)
- `SequencedSet<E>` — ordered set with first/last access (NEW Java 21)
- `SortedSet<E>` — sorted by natural order or `Comparator`
  - `first()`, `last()`, `headSet()`, `tailSet()`, `subSet()`
- `NavigableSet<E>` extends `SortedSet`
  - `lower()`, `floor()`, `ceiling()`, `higher()`, `pollFirst()`, `pollLast()`
  - `descendingSet()`, `descendingIterator()`

### Implementations

| Class                 | Order                       | `add/remove/contains` | Nulls?  | Notes                                    |
| --------------------- | --------------------------- | --------------------- | ------- | ---------------------------------------- |
| `HashSet`             | none                        | O(1) avg              | 1 null  | Backed by `HashMap`; default choice      |
| `LinkedHashSet`       | insertion order             | O(1) avg              | 1 null  | Now implements `SequencedSet` in Java 21 |
| `TreeSet`             | sorted (natural/Comparator) | O(log n)              | No null | Implements `NavigableSet`                |
| `EnumSet`             | enum declaration order      | O(1)                  | No null | Bitset-backed; fastest for enums         |
| `CopyOnWriteArraySet` | insertion order             | O(n)                  | 1 null  | Thread-safe, small sets                  |

```java
Set<String> s1 = Set.of("a","b","c");          // immutable, unordered
Set<String> s2 = new HashSet<>();               // mutable, unordered
Set<String> s3 = new LinkedHashSet<>();         // mutable, insertion-ordered
NavigableSet<Integer> ns = new TreeSet<>();     // sorted
ns.floor(5);    // greatest element ≤ 5
ns.ceiling(5);  // smallest element ≥ 5
```

---

## 5. QUEUE and DEQUE

### Interfaces

**`Queue<E>`** — FIFO by default

- `offer(e)` — add to tail (returns false if full)
- `poll()` — remove from head (returns null if empty)
- `peek()` — inspect head (returns null if empty)
- vs `add/remove/element` — throw exceptions on failure

**`Deque<E>`** (Double-Ended Queue) extends `Queue<E>` AND `SequencedCollection<E>`

- Both ends: `offerFirst/offerLast`, `pollFirst/pollLast`, `peekFirst/peekLast`
- Use as **stack**: `push(e)` = `addFirst(e)`, `pop()` = `removeFirst()`
- Use as **queue**: `offer(e)` = `offerLast(e)`, `poll()` = `pollFirst()`

### Implementations

| Class                   | Structure        | Notes                                                             |
| ----------------------- | ---------------- | ----------------------------------------------------------------- |
| `ArrayDeque`            | resizable array  | **Preferred** for both stack and queue — faster than `LinkedList` |
| `LinkedList`            | doubly-linked    | Also implements `List`; more memory overhead                      |
| `PriorityQueue`         | binary heap      | Natural or custom order; `poll()` returns smallest element        |
| `ArrayBlockingQueue`    | bounded array    | Thread-safe, blocks when full/empty                               |
| `LinkedBlockingQueue`   | linked nodes     | Thread-safe, optionally bounded                                   |
| `PriorityBlockingQueue` | heap             | Thread-safe priority queue                                        |
| `ConcurrentLinkedQueue` | lock-free linked | High-throughput non-blocking                                      |

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1); stack.push(2);
stack.pop();    // 2

Queue<String> queue = new ArrayDeque<>();
queue.offer("a"); queue.offer("b");
queue.poll();   // "a"

PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(5); pq.offer(1); pq.offer(3);
pq.poll();  // 1 (min-heap by default)
// For max-heap: new PriorityQueue<>(Comparator.reverseOrder())
```

---

## 6. MAP — Key-Value Pairs

> Note: `Map` does NOT extend `Collection` or `Iterable`.

### Interfaces

- `Map<K,V>` — core key-value contract
- `SequencedMap<K,V>` extends `Map<K,V>` — NEW Java 21
- `SortedMap<K,V>` — keys sorted; `firstKey()`, `lastKey()`, `headMap()`, `tailMap()`, `subMap()`
- `NavigableMap<K,V>` extends `SortedMap` — `lowerKey()`, `floorKey()`, `ceilingKey()`, `higherKey()`, `descendingMap()`

### Implementations

| Class               | Order                       | `get/put` | Nulls (K/V)                  | Thread-safe?       | Notes                                    |
| ------------------- | --------------------------- | --------- | ---------------------------- | ------------------ | ---------------------------------------- |
| `HashMap`           | none                        | O(1) avg  | 1 null key, many null values | No                 | Default choice                           |
| `LinkedHashMap`     | insertion (or access) order | O(1) avg  | 1 null key, values ok        | No                 | Now implements `SequencedMap` in Java 21 |
| `TreeMap`           | sorted                      | O(log n)  | No null key                  | No                 | Implements `NavigableMap`                |
| `EnumMap`           | enum declaration order      | O(1)      | No null key                  | No                 | Fastest for enum keys                    |
| `WeakHashMap`       | none                        | O(1) avg  | 1 null key                   | No                 | Keys GC'd when unreferenced              |
| `IdentityHashMap`   | none                        | O(1) avg  | null ok                      | No                 | Uses `==` instead of `equals()`          |
| `ConcurrentHashMap` | none                        | O(1) avg  | No null key/value            | Yes                | Best concurrent map                      |
| `Hashtable`         | none                        | O(1) avg  | No nulls                     | Yes (synchronized) | **Legacy — avoid**                       |
| `Properties`        | string keys/values          | O(1) avg  | No nulls                     | Yes                | **Legacy — avoid for new code**          |

```java
Map<String, Integer> m = new HashMap<>();
m.put("a", 1);
m.getOrDefault("z", 0);       // 0
m.putIfAbsent("a", 99);       // ignored, already exists
m.computeIfAbsent("b", k -> k.length()); // 1
m.merge("a", 10, Integer::sum); // a = 11

// Iteration
for (var entry : m.entrySet()) {
    System.out.println(entry.getKey() + "=" + entry.getValue());
}
m.forEach((k, v) -> System.out.println(k + "=" + v));

// Immutable maps (Java 9+)
Map<String, Integer> immutable = Map.of("a", 1, "b", 2);
Map<String, Integer> big = Map.ofEntries(
    Map.entry("a", 1),
    Map.entry("b", 2)
);
Map<String, Integer> copy = Map.copyOf(m); // Java 10+
```

---

## 7. TREES — TreeSet and TreeMap

Both are **Red-Black Trees** (self-balancing BST).

| Operation | TreeSet      | TreeMap      |
| --------- | ------------ | ------------ |
| Insert    | O(log n)     | O(log n)     |
| Delete    | O(log n)     | O(log n)     |
| Search    | O(log n)     | O(log n)     |
| Iteration | O(n), sorted | O(n), sorted |

```java
TreeSet<Integer> ts = new TreeSet<>();
ts.add(5); ts.add(2); ts.add(8);
ts.first();              // 2
ts.last();               // 8
ts.headSet(5);           // [2] — exclusive of 5
ts.tailSet(5);           // [5, 8] — inclusive
ts.subSet(2, 8);         // [2, 5] — [2,8)
ts.floor(6);             // 5 — greatest ≤ 6
ts.ceiling(6);           // 8 — smallest ≥ 6
ts.pollFirst();          // removes and returns 2

TreeMap<String, Integer> tm = new TreeMap<>();
tm.put("banana", 2); tm.put("apple", 1); tm.put("cherry", 3);
tm.firstKey();           // "apple"
tm.lastKey();            // "cherry"
tm.headMap("cherry");    // {apple=1, banana=2}
tm.floorKey("blueberry"); // "banana"
tm.descendingMap();       // reversed view
```

**Custom ordering:**

```java
TreeSet<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
TreeMap<String, Integer> caseInsensitive = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
```

---

## 8. Factory Methods — Immutable Collections (Java 9+)

```java
// List
List<String> l = List.of("a", "b", "c");           // immutable, no nulls
List<String> l2 = List.copyOf(mutableList);         // immutable copy

// Set
Set<String> s = Set.of("x", "y", "z");             // immutable, no nulls, no duplicates

// Map
Map<String,Integer> m = Map.of("k1",1, "k2",2);    // up to 10 pairs
Map<String,Integer> m2 = Map.ofEntries(             // unlimited
    Map.entry("k1", 1),
    Map.entry("k2", 2)
);

// Important: these throw UnsupportedOperationException on mutation
// and NullPointerException on null elements/keys/values
```

---

## 9. Algorithms — Collections Utility Class

```java
Collections.sort(list);                          // natural order
Collections.sort(list, comparator);             // custom order
Collections.reverse(list);
Collections.shuffle(list);
Collections.min(collection);
Collections.max(collection);
Collections.frequency(collection, element);
Collections.disjoint(c1, c2);                   // true if no common elements
Collections.nCopies(n, element);                // immutable list of n copies
Collections.unmodifiableList(list);             // unmodifiable view
Collections.synchronizedList(list);             // thread-safe wrapper (prefer CopyOnWriteArrayList)
Collections.singleton(element);                 // immutable single-element Set
Collections.singletonList(element);             // immutable single-element List
Collections.emptyList();                        // immutable empty List
Collections.binarySearch(sortedList, key);      // O(log n) — list must be sorted
Collections.fill(list, value);
Collections.copy(dest, src);
Collections.swap(list, i, j);
Collections.rotate(list, distance);
Collections.replaceAll(list, UnaryOperator);    // Java 8+
```

---

## 10. Sorting and Comparators

```java
// Comparable — natural order (implement in your class)
class Person implements Comparable<Person> {
    public int compareTo(Person other) { return this.age - other.age; }
}

// Comparator — external ordering (Java 8+ functional style)
Comparator<Person> byName = Comparator.comparing(Person::getName);
Comparator<Person> byAgeThenName = Comparator
    .comparingInt(Person::getAge)
    .thenComparing(Person::getName)
    .reversed();

list.sort(byAgeThenName);
list.sort(Comparator.naturalOrder());
list.sort(Comparator.reverseOrder());
list.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
```

---

## 11. Concurrent Collections (java.util.concurrent)

| Class                       | Replaces                       | Notes                                                     |
| --------------------------- | ------------------------------ | --------------------------------------------------------- |
| `ConcurrentHashMap`         | `Hashtable`, `synchronizedMap` | Segment locking; allows concurrent reads + partial writes |
| `CopyOnWriteArrayList`      | `synchronizedList`             | Write = full array copy; best for rare writes             |
| `CopyOnWriteArraySet`       | `synchronizedSet`              | Backed by `CopyOnWriteArrayList`                          |
| `ConcurrentLinkedQueue`     | `synchronizedQueue`            | Lock-free, non-blocking                                   |
| `ConcurrentLinkedDeque`     | —                              | Lock-free deque                                           |
| `BlockingQueue` (interface) | —                              | `put()` blocks when full; `take()` blocks when empty      |
| `ArrayBlockingQueue`        | —                              | Bounded; fair or unfair ordering                          |
| `LinkedBlockingQueue`       | —                              | Optionally bounded                                        |
| `PriorityBlockingQueue`     | —                              | Unbounded priority-based                                  |
| `LinkedTransferQueue`       | —                              | Transfers elements directly to waiting consumers          |
| `DelayQueue`                | —                              | Elements available after a delay                          |

```java
// ConcurrentHashMap — preferred concurrent map
ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();
chm.putIfAbsent("key", 1);
chm.compute("key", (k, v) -> v == null ? 1 : v + 1);  // atomic!
chm.merge("key", 1, Integer::sum);                      // atomic!

// BlockingQueue producer-consumer
BlockingQueue<Task> queue = new LinkedBlockingQueue<>(100);
// Producer:
queue.put(task);        // blocks if full
// Consumer:
Task t = queue.take();  // blocks if empty
```

---

## 12. Streams and Collections (Java 8+)

```java
List<String> names = List.of("Alice", "Bob", "Charlie", "Dave");

// Collect to collections
Set<String> set = names.stream().collect(Collectors.toSet());
List<String> filtered = names.stream().filter(n -> n.length() > 3).toList(); // Java 16+

// Group by
Map<Integer, List<String>> byLength = names.stream()
    .collect(Collectors.groupingBy(String::length));

// Frequency map
Map<String, Long> freq = names.stream()
    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

// Joining
String joined = names.stream().collect(Collectors.joining(", ", "[", "]"));

// toUnmodifiableList / toUnmodifiableMap (Java 10+)
List<String> immutable = names.stream()
    .filter(n -> n.startsWith("A"))
    .collect(Collectors.toUnmodifiableList());

// Collectors.teeing (Java 12+)
var result = names.stream().collect(
    Collectors.teeing(
        Collectors.minBy(Comparator.naturalOrder()),
        Collectors.maxBy(Comparator.naturalOrder()),
        (min, max) -> min.orElse("") + " to " + max.orElse("")
    )
);
```

---

## 13. Quick Decision Guide

### Which List?

- **Default → `ArrayList`** (fast random access, compact memory)
- **Frequent insertions in middle → `LinkedList`** (rarely worth it in practice; benchmark first)
- **Concurrent, read-heavy → `CopyOnWriteArrayList`**
- **Immutable → `List.of(...)`**

### Which Set?

- **Default → `HashSet`** (O(1), no order)
- **Need insertion order → `LinkedHashSet`** (also gets `SequencedSet` API in Java 21)
- **Need sorted order → `TreeSet`** (O(log n))
- **Enum values → `EnumSet`** (fastest possible)
- **Immutable → `Set.of(...)`**

### Which Map?

- **Default → `HashMap`** (O(1), no order)
- **Need insertion order → `LinkedHashMap`** (also gets `SequencedMap` API in Java 21)
- **Need sorted keys → `TreeMap`** (O(log n))
- **Enum keys → `EnumMap`** (fastest possible)
- **Concurrent → `ConcurrentHashMap`** (never use `Hashtable`)
- **Immutable → `Map.of(...)` / `Map.ofEntries(...)`**

### Which Queue?

- **Stack (LIFO) → `ArrayDeque.push/pop`**
- **Queue (FIFO) → `ArrayDeque.offer/poll`**
- **Priority → `PriorityQueue`**
- **Concurrent FIFO → `LinkedBlockingQueue`**

---

## 14. Complexity Cheat Sheet

| Structure         | Access    | Search   | Insert                       | Delete             |
| ----------------- | --------- | -------- | ---------------------------- | ------------------ |
| ArrayList         | O(1)      | O(n)     | O(n)\* amortized O(1) at end | O(n)               |
| LinkedList        | O(n)      | O(n)     | O(1) with iterator           | O(1) with iterator |
| HashSet/HashMap   | —         | O(1) avg | O(1) avg                     | O(1) avg           |
| LinkedHashSet/Map | —         | O(1) avg | O(1) avg                     | O(1) avg           |
| TreeSet/TreeMap   | —         | O(log n) | O(log n)                     | O(log n)           |
| ArrayDeque        | O(1) ends | O(n)     | O(1) ends                    | O(1) ends          |
| PriorityQueue     | O(1) peek | O(n)     | O(log n)                     | O(log n)           |

---

## 15. Key Gotchas

```java
// 1. List.of() throws on null — use Arrays.asList() for null-tolerant fixed list
List<String> nullOk = Arrays.asList("a", null, "b"); // mutable size? No. Null? Yes.

// 2. HashMap allows one null key; TreeMap/ConcurrentHashMap do NOT
new HashMap<>().put(null, "ok");      // fine
new TreeMap<>().put(null, "boom");    // NullPointerException

// 3. Avoid modifying a collection while iterating — use Iterator.remove()
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    if (it.next().isEmpty()) it.remove(); // safe
}
// OR use removeIf (Java 8+):
list.removeIf(String::isEmpty);

// 4. equals()/hashCode() contract — must override both for HashMap keys / HashSet elements
// If a.equals(b), then a.hashCode() == b.hashCode() MUST be true

// 5. EnumSet.allOf / noneOf / of
EnumSet<Day> weekdays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
EnumSet<Day> weekend  = EnumSet.complementOf(weekdays);

// 6. Checked vs unchecked exceptions
queue.add(e);     // throws IllegalStateException if bounded and full
queue.offer(e);   // returns false — prefer this

// 7. SequencedCollection.reversed() is a VIEW — mutations reflect back
List<String> original = new ArrayList<>(List.of("a","b","c"));
List<String> rev = original.reversed();   // view
original.add("d");
rev.getFirst(); // "d" — because it's a live view
```

---

## 16. Java 21 Sequenced Interface Quick Reference

```java
// SequencedCollection methods (available on List, LinkedHashSet, ArrayDeque, etc.)
collection.getFirst();          // NoSuchElementException if empty
collection.getLast();
collection.addFirst(e);         // not on all — e.g., TreeSet throws UnsupportedOperationException
collection.addLast(e);
collection.removeFirst();
collection.removeLast();
collection.reversed();          // returns a reversed VIEW of the collection

// SequencedMap methods (available on LinkedHashMap, TreeMap, etc.)
map.firstEntry();               // Map.Entry or null
map.lastEntry();
map.pollFirstEntry();           // removes and returns
map.pollLastEntry();
map.putFirst(k, v);
map.putLast(k, v);
map.reversed();                 // reversed view
map.sequencedKeySet();          // SequencedSet<K>
map.sequencedValues();          // SequencedCollection<V>
map.sequencedEntrySet();        // SequencedSet<Map.Entry<K,V>>
```

---

_Java 21 LTS — Released September 2023_
