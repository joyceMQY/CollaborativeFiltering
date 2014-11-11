CollaborativeFiltering
======================
RecommenderExperiement.java:
<br>1. KEY_VALUE_I contains all the userid - # of recommendations pairs. They are all generated randomly using RandomGenerator.java.
<br>2. FILE_NAME contains all the dataset file paths, I stored them under the project root/data(dir)/dataset(dir) - you can change it to any paths you like, but please follow the order of the files so that they can match the key value pairs.
<br>3. Method recommendAll(int N) is the main entrance of all the recommendations. Please find out the value of N before running the method in main.
<br>For each dataset:
<br>&nbsp;&nbsp;&nbsp;&nbsp;For each userid - # of recommendations pair we selected:
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Generate all the output filenames: generateOutputFileNames(filename, j, num); num = N (which is the parameter of this method, also the N in runRecommenderN())
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Do all the recommendations (different combinations of implementation/arguments) from runRecommender1() to runRecommenderN(). Please implement your own runRecommenderX(filename, id, num, output)
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The arguments are: String filename - dataset file path
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int id - userid
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int num - # of recommendations
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String output - the file path to store the result of this recommendation.
<br>
<br>Recommender.java:
<br>runRecommender1() to runRecommenderN()
<br>Implment the recommendation!
<br>
<br>Pair.java:
<br>The class to store the itemid-value result pair.
