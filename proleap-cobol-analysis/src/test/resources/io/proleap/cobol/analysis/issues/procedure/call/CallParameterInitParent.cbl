 IDENTIFICATION DIVISION.
 PROGRAM-ID. CALLSTMT.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 SOMEPARAM1 PIC X(10) VALUE "PARAM3".
 	02 SOMEPARAM2 PIC X(10).
 01 SOMEPARAM3 PIC X(10).
 	02 SOMEPARAM4 PIC X(10).
 PROCEDURE DIVISION.
	CALL SOMEPROG2
       USING SOMEPARAM2.
    CALL SOMEPROG2
       USING SOMEPARAM4.
    CALL SOMEPROG1
       USING
          BY REFERENCE SOMEPARAM1 SOMEPARAM3.