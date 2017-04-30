# Dynamic Programming — Longest Common Subsequence

**Objective:** Given two string sequences, write an algorithm to find the length of longest subsequence present in both of them.

These kind of dynamic programming questions are very famous in the interviews like Amazon, Microsoft, Oracle and many more.

**What is Longest Common Subsequence:** A longest subsequence is a sequence that appears in the same relative order, but not necessarily contiguous(not substring) in both the string.

#### Example:
    String A = "acbaed";
    String B = "abcadf";    
<p align="center">
    <img src="http://algorithms.tutorialhorizon.com/files/2015/06/Longest-Common-Subsequence-example.jpg"?raw="true" width="50%">
</p>

    Longest Common Subsequence - example
    Longest Common Subsequence(LCS):     acad, Length: 4

#### Approach:

**Recursion:**

Start com­par­ing strings in reverse order one char­ac­ter at a time.

Now we have 2 cases -
1. Both char­ac­ters are same
   1. add 1 to the result and remove the last char­ac­ter from both the strings and make recur­sive call to the mod­i­fied strings.
2. Both char­ac­ters are different
   1. Remove the last char­ac­ter of String 1 and make a recur­sive call and remove the last char­ac­ter from String 2 and make a        recur­sive and then return the max from returns of both recur­sive calls. see exam­ple below
**Exam­ple:**

    Case 1:
    
    String A: "ABCD", String B: "AEBD"
    
    LCS("ABCD", "AEBD") = 1 + LCS("ABC", "AEB")

    Case 2: 

    String A: "ABCDE", String B: "AEBDF"

    LCS("ABCDE", "AEBDF") = Max(LCS("ABCDE", "AEBD"), LCS("ABCD", "AEBDF"))
    
### Code:
    public static int LCS(String A, String B) {
		if (A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int lenA = A.length();
		int lenB = B.length();
		// check if last characters are same
		if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
			// Add 1 to the result and remove the last character from both
			// the strings and make recursive call to the modified strings.
			return 1 + LCS(A.substring(0, lenA - 1), B.substring(0, lenB - 1));
		} else {
			// Remove the last character of String 1 and make a recursive
			// call and remove the last character from String 2 and make a
			// recursive and then return the max from returns of both recursive
			// calls
			return Math.max(
					LCS(A.substring(0, lenA - 1), B.substring(0, lenB)),
					LCS(A.substring(0, lenA), B.substring(0, lenB - 1)));
		}
	}
    
In a given string of length n, there can be 2n sub­se­quences can be made, so if we do it by recur­sion then Time com­plex­ity will O(2n) since we will solv­ing sub prob­lems repeat­edly.
<p align="center">
<img src="http://algorithms.tutorialhorizon.com/files/2015/06/LCS-Recursion-Tree.png"?raw="true" width="50%" height="50%">
</p>

## Dynamic Pro­gram­ming:
We will solve it in Top-manner and store the solu­tion of the sub prob­lems in a solu­tion array and use it when ever needed, This tech­nique is called Mem­o­iza­tion. See the code for bet­ter explanation.

## Code:
    public static int find(char[] A, char[] B) {
	int[][] LCS = new int[A.length + 1][B.length + 1];
	String[][] solution = new String[A.length + 1][B.length + 1];
	// if A is null then LCS of A, B =0
	for (int i = 0; i <= B.length; i++) {
		LCS[0][i] = 0;
		solution[0][i] = "0";
	}

	// if B is null then LCS of A, B =0
	for (int i = 0; i <= A.length; i++) {
		LCS[i][0] = 0;
		solution[i][0] = "0";
	}
	for (int i = 1; i <= A.length; i++) {
		for (int j = 1; j <= B.length; j++) {
			if (A[i - 1] == B[j - 1]) {
				LCS[i][j] = LCS[i - 1][j - 1] + 1;
			} else {
				LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
			}
		}
	}
	return LCS[A.length][B.length];
    }
    
#### Print the Longest Com­mon Subsequence:

Take a look into the LCS[][] used in the code
<p align="center">
<img src="http://algorithms.tutorialhorizon.com/files/2015/06/LCS-Printing-Result.png"?raw="true" width="50%" height="50%">
</p>
Start from bot­tom right cor­ner and track the path and mark the cell from which cell the value is com­ing and when­ever you go diag­o­nal ( means last char­ac­ter of both string has matched, so we reduce the length of both the strings by 1, so we moved diag­o­nally), mark those cells, this is our answer.
