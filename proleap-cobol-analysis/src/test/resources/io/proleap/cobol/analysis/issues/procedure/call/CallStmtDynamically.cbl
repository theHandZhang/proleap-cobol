 IDENTIFICATION DIVISION.
 PROGRAM-ID. CALLSTMT.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 01 SOMEPROG1 PIC X(10) VALUE "SUB1".
 01 SOMEPROG2 PIC X(10) VALUE "SUB2".
 PROCEDURE DIVISION.
    CALL "SUB1"
       USING
          BY REFERENCE INTEGER SOMEINT SOMEFILE
          BY VALUE 1 2 SOMEID1
          BY CONTENT ADDRESS OF SOMEID2 LENGTH OF SOMEID3 4
       GIVING SOMEID4.  
       
    CALL 1
       USING
          BY REFERENCE INTEGER SOMEINT SOMEFILE
          BY VALUE 1 2 SOMEID1
          BY CONTENT ADDRESS OF SOMEID2 LENGTH OF SOMEID3 4
       GIVING SOMEID4.
       
	CALL SOMEPROG2
       USING
          BY REFERENCE INTEGER SOMEINT SOMEFILE
          BY VALUE 1 2 SOMEID1
          BY CONTENT ADDRESS OF SOMEID2 LENGTH OF SOMEID3 4
       GIVING SOMEID4.
       