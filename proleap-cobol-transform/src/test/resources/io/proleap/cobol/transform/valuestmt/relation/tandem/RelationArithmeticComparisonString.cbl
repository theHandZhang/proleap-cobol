 IDENTIFICATION DIVISION.
 PROGRAM-ID. RELSTRING.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 02 P-OR-F PIC X(5) VALUE SPACE.
 PROCEDURE DIVISION.
    IF P-OR-F EQUAL TO "FAIL*" 
       DISPLAY "test".