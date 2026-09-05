# STEP Semester 3 - Java Object-Oriented Programming (OOP)

This repository contains the Java source code solutions and exercises for the **STEP Semester 3** curriculum, organized by sessions and topic areas.

---

## 📁 Repository Structure

```
step_sem_3/
└── src/
    ├── session_3_oop_basics/
    │   ├── class_problem/
    │   │   ├── Course.java
    │   │   ├── IdCard.java
    │   │   ├── MessWallet.java
    │   │   ├── PlacementRecord.java
    │   │   └── Student.java
    │   └── assignment_problem/
    │       ├── BookInventory.java
    │       ├── Employee.java
    │       ├── EmployeeStatic.java
    │       ├── HallTicket.java
    │       └── PayrollAccount.java
    └── session_4_constructors_and_keywords/
        ├── class_problem/
        │   ├── AccountPayment.java
        │   ├── Employee.java
        │   ├── LateFee.java
        │   ├── LibraryBook.java
        │   └── SrmStudent.java
        └── assignment_problem/
```

---

## 📚 Curriculum & Topics Covered

### 🔹 Session 3: OOP Basics (`src/session_3_oop_basics/`)

Focuses on foundational object-oriented programming concepts in Java.

#### Class Problems
* **`Student.java`**: Static variables (`collegeName`, `studentCount`) vs instance fields.
* **`Course.java`**: Constructor overloading and constructor chaining using `this(...)`.
* **`IdCard.java`**: Java reference semantics, object reference sharing, and reference comparison (`==`).
* **`MessWallet.java`**: Data encapsulation (`private` fields), getter methods, and input validation.
* **`PlacementRecord.java`**: Creating and iterating through arrays of objects (`PlacementRecord[]`).

#### Assignment Problems
* **`BookInventory.java`**: Inventory tracking using object arrays.
* **`Employee.java`**: Constructor overloading for different employee types (Permanent vs Intern).
* **`EmployeeStatic.java`**: Nested static class and static counters to track created objects.
* **`HallTicket.java`**: Reference copy behavior, mutation through alias variables, and string parsing.
* **`PayrollAccount.java`**: Encapsulation, bonus additions, tax deductions, and net salary calculations.

---

### 🔹 Session 4: Constructors & Keywords (`src/session_4_constructors_and_keywords/`)

Dives deeper into constructor mechanics, keywords (`this`, `super`, `final`, `static`), and access modifiers.

#### Class Problems
* **`AccountPayment.java`**: Payment processing models and method signatures.
* **`Employee.java`**: Employee modeling with specialized initialization.
* **`LateFee.java`**: Late fee calculation rules and penalty handling.
* **`LibraryBook.java`**: Library management systems demonstrating object properties.
* **`SrmStudent.java`**: SRM student record handling and static attributes.

---

## 🚀 How to Run

### Prerequisites
* **Java Development Kit (JDK 8 or higher)** installed and configured in your environment path.

### Compilation & Execution Examples

Navigate to the project root directory (`step_sem_3`) in your terminal:

#### 1. Compile a Java file
```bash
javac -d bin src/session_3_oop_basics/class_problem/Student.java
```

#### 2. Execute the compiled class
```bash
java -cp bin session_3_oop_basics.class_problem.Student
```

#### 3. Compile all Session 3 files at once
```bash
javac -d bin src/session_3_oop_basics/*/*.java
```
