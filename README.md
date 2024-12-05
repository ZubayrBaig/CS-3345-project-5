# CS-3345-project-5
Name: Mirza Zubayr Baig
netID: mzb230000
Project: 5
Files:
- QuickSorter.java
- Main.java

I used eclipse IDE to write this code
I am on Java 8 Update 431
I compiled and ran the program on my IDE (eclipse)
From my tests the program worked without any problems. 

Report 1:
  Array Size = 70
  FIRST_ELEMENT : PT0.000996792S
  RANDOM_ELEMENT : PT0.000118542S
  MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.000043916S
  MEDIAN_OF_THREE_ELEMENTS : PT0.00003675S

Report 2:
  Array Size = 60000
  FIRST_ELEMENT : PT0.03188425S
  RANDOM_ELEMENT : PT0.012456584S
  MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.01236025S
  MEDIAN_OF_THREE_ELEMENTS : PT0.01203125S

Report 3:
  Array Size = 800000
  FIRST_ELEMENT : PT0.153556916S
  RANDOM_ELEMENT : PT0.125705916S
  MEDIAN_OF_THREE_RANDOM_ELEMENTS : PT0.119414083S
  MEDIAN_OF_THREE_ELEMENTS : PT0.115892042S

Observations:
  - Even with larger array sizes like 800,000, the sorting time is very quick
  - The FIRST_ELEMNT pivot strategy always took the longest. If I was to apply a quicksort in real life, I would not choose the first element as the pivot.
  - The other 3 pivot strategies had times that were very close to each other with the RANDOM_ELEMENT being a little slower and the other 2 being incredibly close. However, in the end, the MEDIAN_OF_THREE_ELEMENTS startegy came out on top being the fastest overall.

Sorted and Almost Sorted Arrays:
  - When I tried sorting with sorted arrays, the MEDIAN_OF_THREE_ELEMENTS startegy was obviously the fastest because the array was already sorted. And the FIRST_ELEMENT strategy was the slowest because the whole algorithm became O(n^2)
  - With almost sorted arrays, the results were very similar. The MEDIAN_OF_THREE_ELEMENTS strategy was the fasstest and the FIRST_ELEMENT startegy was the slowest

