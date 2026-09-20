## Date: 20-09-2026

**Today's Work:**
- Organized branches into clean isolated workspaces where each feature branch contains only its corresponding session folder with `class_problem/` and `assignment_problem/` subfolders.
- Completed Session 1 (Java Basics) problems under `feature/session_1`:
  - **Class Problems**: `RockPaperScissors.java` (random move generator, 5-round game loop, summary table, win percentage), `PalindromeChecker.java` (iterative, recursive, and array-reversal approaches), `BmiCalculator.java` (BMI calculation and health category classification report), `FirstNonRepeatingChar.java` (character frequency analysis), `ReverseCustomerName.java` (in-place two-pointer string reversal).
  - **Assignment Problems**: `SeatDuplicationChecker.java` (nested loops duplicate scanner without Collections), `TypingAccuracyChecker.java` (character-by-character matching, accuracy percentage, first mismatch locator), `TrafficSignalStreak.java` (longest consecutive identical character streak tracker), `WarehouseInventory.java` (section sum comparison and overall highest quantity finder), `MovieReviewProfiler.java` (word length categorization into Short, Medium, Long).
- Completed Session 2 (Strings & Methods) problems under `feature/session_2`:
  - **Class Problems**: `VowelConsonantCounter.java` (case-insensitive letter counting), `StudentRecordParser.java` (CSV splitting and field validation), `FileExtensionValidator.java` (extension extraction and format verification), `PhoneNumberFormatter.java` (10-digit validation and masked output with `StringBuilder`), `BankReferenceValidator.java` (14-character reference code validation and formatted display).
  - **Assignment Problems**: `PinValidator.java` (4-digit ATM PIN length check), `WordReversalEncoder.java` (individual word reversal while keeping order), `InventoryRecordParser.java` (CSV product record validation and formatting), `IsbnValidator.java` (13-character ISBN normalizer and validator), `WordFrequencyReport.java` (stop-word filtering and descending frequency distribution).
- Completed Session 4 (Constructors & Keywords) assignment problems under `feature/session_4`:
  - `Participant.java` (constructor chaining via `this()`), `Item.java` (`this` parameter-field collision resolution for batch restock), `ParkingTicket.java` (`final` method overstay fine calculator), `MembershipCard.java` (`static` initialization block for one-time library metadata loading), `CanteenPayment.java` (`instanceof` type checking and safe downcasting in loop).
- Completed Session 6 (Inheritance & Polymorphism) assignment problems under `feature/session_6`:
  - `GymMember.java` (base class with member validation, auto-generated IDs, fee calculation), `PremiumMember.java` (subclass with half late-fee override via `super`), `EliteMember.java` (multilevel 3-generation inheritance), `GroupClassMember.java` (hierarchical sibling inheritance), `GymReport.java` (polymorphic session aggregation, batch printing with `StringBuilder` and `instanceof` downcasting).
- Compiled all solutions using `-source 8 -target 8`, verified sample outputs, and deleted temporary compilation artifacts.

**Next Session Plan:**
- Complete Session 7 assignment problems under `feature/session_7`.
- Continue practicing advanced OOP design patterns and abstractions.

**Issues Faced:**
- None

---

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
