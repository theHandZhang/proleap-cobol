 IDENTIFICATION DIVISION.
 PROGRAM-ID. EVALSTMT.
 PROCEDURE DIVISION.
    EVALUATE SOMEAGE ALSO SOMEAGE2 ALSO SOMEAGE3
       WHEN 0 PERFORM SOMEPROC1
       WHEN 25 PERFORM SOMEPROC2
       WHEN 0 PERFORM SOMEPROC3
       WHEN OTHER PERFORM SOMEPROC4
    END-EVALUATE.
    EVALUATE SOMEAGE
       WHEN 0 PERFORM SOMEPROC1
       WHEN 25 PERFORM SOMEPROC2
       WHEN 50 PERFORM SOMEPROC3
       WHEN OTHER PERFORM SOMEPROC4
    END-EVALUATE.
   