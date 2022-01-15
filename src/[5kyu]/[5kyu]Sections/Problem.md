# [5kyu] Sections


<p align="center">
https://www.codewars.com/kata/5da1df6d8b0f6c0026e6d58d/
</p>

Consider the following equation of a surface S: z*z*z = x*x * y*y.
Take a cross section of S by a plane P: z = k where k is a positive integer (k > 0).
Call this cross section C(k).

<h3>Task</h3>
Find the number of points of C(k) whose coordinates are positive integers.

<h3>Examples</h3>
If we call c(k) the function which returns this number we have
````
c(1) -> 1
c(4) -> 4
c(4096576) -> 160
c(2019) -> 0 which means that no point of C(2019) has integer coordinates.
````
<h3>Notes</h3>
- k can go up to about 10,000,000,000
- Prolog: the function cis called section.
- COBOL: the function cis called sections.
- Please could you ask before translating : some translations are already written.