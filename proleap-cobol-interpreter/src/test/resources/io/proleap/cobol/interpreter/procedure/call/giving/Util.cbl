 IDENTIFICATION DIVISION.
 PROGRAM-ID. UTIL.

 DATA DIVISION.
   LINKAGE SECTION.
   01 LS-STUDENT-ID PIC 9(4).

 PROCEDURE DIVISION GIVING LS-STUDENT-ID.
   DISPLAY 'In Called Program'.
   MOVE 1111 TO LS-STUDENT-ID.
   DISPLAY 'Student Id : ' LS-STUDENT-ID.
 EXIT PROGRAM.