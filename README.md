## Date: 05-09-2026

**Today's Work:**
- Completed Session 5 Access Modifiers and Encapsulation class problems under `src/session_5_access_modifiers_and_encapsulation/class_problem/`:
  - M1: `MovieTicket.java` - Configured four fields with distinct access modifiers (`private`, `default`, `protected`, `public`).
  - M2: `AccessChecker.java` - Implemented access classifier across 5 contexts (`SAME_CLASS`, `SAME_PACKAGE`, `DIFFERENT_PACKAGE`, `SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE`, `SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE`) and batch summary count.
  - M3: `CineScreen.java` - Redesigned seat booking encapsulation with constructor-time validation (`seatsTotal <= 0`) and boundary-safe state transition methods.
  - M4: `MovieBookingProfile.java` - Created JavaBean compliant class with `this()` constructor chaining and write-only OTP property.
  - M5: `BookingReceipt.java` & `GroupBookingReceipt.java` - Implemented immutable receipts with defensive array copying, wither pattern, and `processNightlySettlement()` with `instanceof` dispatch and null safety.

**Next Session Plan:**
- Complete Session 5 assignment problems.
- Explore advanced OOP concepts, inheritance hierarchies, and interfaces.

**Issues Faced:**
- None

---

## Date: 28-08-2026

**Today's Work:**
- Completed Session 4 OOP programming problems under `src/session_4_constructors_and_keywords/`:
  - M1: `LibraryBook.java` - Implemented `LibraryBook` with constructor chaining via `this()` to assign default `"PENDING"` status to unconfirmed ISBNs in a single pass.
  - M2: `Employee.java` - Resolved field/parameter naming collisions using the `this` keyword in both the constructor and `raiseSalary()` method to process uniform festival bonuses.
  - M3: `LateFee.java` - Created late fee calculator with locked `final` methods (`calculateLateFee()` and `printSummary()`), skipping on-time accounts (`daysLate <= 0`).
  - M4: `SrmStudent.java` - Implemented one-time static setup for college details using a `static` initialization block while batch creating student records.
  - M5: `AccountPayment.java` - Implemented batch payment processing using `instanceof` to dynamically dispatch payments between `HostelFeeAccount` and `FeeAccount` with account type counters.
- Added interactive `Scanner` input statements across all Session 4 programs.

**Next Session Plan:**
- Explore advanced polymorphism, abstract classes, and interface hierarchies in Java.
- Complete upcoming OOP assignment modules.

**Issues Faced:**
- None

---

## Date: 27-08-2026

**Today's Work:**
- Completed Session 3 assignment practice questions covering class design, encapsulation, constructor overloading, reference copying, and static fields (`BookInventory.java`, `PayrollAccount.java`, `Employee.java`, `HallTicket.java`, `EmployeeStatic.java`).

**Next Session Plan:**
- Proceed to Session 4 exercises and advanced constructor chaining.

**Issues Faced:**
- None

---

## Date: 22-08-2026

**Today's Work:**
- Completed Session 3 core OOP problems under `src/session_3_oop_basics/`:
  - M1: `PlacementRecord.java` - Implemented `PlacementRecord` class with array of objects.
  - M2: `MessWallet.java` - Implemented `MessWallet` with encapsulated balance and transactional validations.
  - M3: `Course.java` - Implemented `Course` with constructor overloading for theory and lab courses.
  - M4: `IdCard.java` - Implemented `IdCard` demonstrating reference copying and `==` comparisons.
  - M5: `Student.java` - Implemented `Student` tracking static college name and student count.

**Next Session Plan:**
- Complete Session 3 assignment practice problems.

**Issues Faced:**
- None

---
