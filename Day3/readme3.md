# Week 3 – Object-Oriented Programming

This week focused on practicing core **Object-Oriented Programming (OOP)** concepts in Java through five practical problems.

## 📚 Topics Studied

### 1. Classes, Objects & Arrays of Objects

* Learned how to replace **parallel arrays** with a proper class-based design.
* Created a `PlacementRecord` class with fields such as:

  * `studentName`
  * `company`
  * `packageLpa`
* Used a **constructor** to initialize object data.
* Created multiple objects and stored them in an **array of objects**.
* Used an **instance method** to display object information.

**Key concepts:** Classes, Objects, Constructors, Instance Methods, Arrays of Objects.

---

### 2. Encapsulation

* Learned how to protect data inside a class using the `private` access modifier.
* Implemented a `MessWallet` class with a private `balance`.
* Used methods such as:

  * `topUp()`
  * `deduct()`
  * `getBalance()`
* Applied **validation inside methods** to prevent invalid operations.
* Learned how to provide controlled, read-only access using a getter.
* Prevented the balance from being directly modified from outside the class.

**Key concepts:** Encapsulation, Private Fields, Data Validation, Getter Methods, Controlled Access.

---

### 3. Constructor Overloading & `this()`

* Learned how a class can have multiple constructors with different parameters.
* Implemented a `Course` class with:

  * `code`
  * `title`
  * `credits`
  * `labCredits`
* Created a four-parameter constructor for courses with labs.
* Created a three-parameter constructor for theory-only courses.
* Used **`this()` constructor chaining** to avoid duplicating initialization logic.
* Calculated total credits using an instance method.

**Key concepts:** Constructor Overloading, `this()`, Constructor Chaining, Code Reusability.

---

### 4. Reference Copying & Object Identity

* Learned that assigning one object variable to another does **not create a new object**.
* Both variables can refer to the **same object in memory**.
* Modified an object through one reference and observed the change through another reference.
* Used the `==` operator to compare object references.
* Compared:

  * Two variables referring to the same object.
  * Two separate objects containing identical data.

**Key concepts:** Reference Copying, Object References, `==`, Object Identity vs Content Equality.

---

### 5. Instance vs Static Members

* Learned the difference between **instance members** and **static members**.
* Used instance fields for data that belongs to individual students:

  * `name`
  * `attendance`
* Used a static field `collegeName` for data shared by all students.
* Used a static `studentCount` to track the number of created objects.
* Learned that a static method cannot directly access instance fields.
* Learned to access static members through the **class name**.

**Key concepts:** Instance Variables, Static Variables, Static Methods, Shared Data, Object Count.

---

## 🧠 Overall Learning

By completing these problems, I practiced how to:

* Design programs using **classes and objects**
* Initialize objects using **constructors**
* Store and work with **arrays of objects**
* Protect data using **encapsulation**
* Validate data inside class methods
* Use **constructor overloading**
* Chain constructors using `this()`
* Understand how **object references** work
* Differentiate **object identity** from data/content
* Understand **instance vs static** members
* Use static variables and methods for **class-level/shared information**

## 🛠️ Technologies Used

* **Language:** Java
* **Topic:** Object-Oriented Programming
* **Week:** 3
* **Practice:** Category B Problems
* **Focus:** Classes and Objects
