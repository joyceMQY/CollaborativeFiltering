CollaborativeFiltering
======================
RecommenderExperiement.java:
1. KEY_VALUE_N contains all the userid - # of recommendations pairs. They are all generated randomly using RandomGenerator.java.
2. FILE_NAME contains all the dataset file paths, I stored them under the project root/data(dir)/dataset(dir) - you can change it to any paths you like, but please follow the order of the files so that they can match the key value pairs.

3. Method recommendAll(int N) is the main entrance of all the recommendations. Please find out the value of N before running the method in main.
For each dataset:
	For each userid - # of recommendations pair we selected:
		Generate all the output filenames: generateOutputFileNames(filename, j, num); num = N (which is the parameter of this method, also the N in runRecommenderN())
		Do all the recommendations (different combinations of implementation/arguments) from runRecommender1() to runRecommenderN(). Please implement your own 
                runRecommenderX(filename, id, num, output)
                The arguments are: String filename - dataset file path
                                   int id - userid
                                   int num - # of recommendations
                                   String output - the file path to store the result of this recommendation.


Recommender.java:
runRecommender1() to runRecommenderN()
Implment the recommendation!

Pair.java
The class to store the itemid-value result pair.
