 IDENTIFICATION DIVISION.
 PROGRAM-ID. COND.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 SOMECOND1 PICTURE IS 9(1).
 01 SOMECOND2 PICTURE IS 9(1).
 PROCEDURE DIVISION.
    IF SOMECOND1 = SOMECOND1 THEN
       DISPLAY 'thentext'
    ELSE
       DISPLAY 'elsetext'
    END-IF.
    IF SOMECOND2 < SOMECOND2 THEN
       DISPLAY 'thentext'
    ELSE
       DISPLAY 'elsetext'
    END-IF.
    IF SOMECOND1 > SOMECOND1 THEN
       DISPLAY 'thentext'
    ELSE
       DISPLAY 'elsetext'
    END-IF.
    IF SOMECOND1 > SOMECOND2 THEN
       DISPLAY 'thentext'
    ELSE
       DISPLAY 'elsetext'
    END-IF.
    IF SOMECOND1=SOMECOND1 OR SOMECOND2=SOMECOND1 THEN
       DISPLAY 'thentext'
    ELSE
       DISPLAY 'elsetext'
    END-IF.
