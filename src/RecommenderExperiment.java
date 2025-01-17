import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.Factorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDPlusPlusFactorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecommenderExperiment {
	//Generated by random
	private static int[][] KEY_VALUE_1 = {{24688,2},{31580,23},{27278,96},{43976,11},{36758,21},{14326,75},{23430,9},{23145,62},{647,76},{8924,47}};
	private static int[][] KEY_VALUE_2 = {{2996,64},{44380,21},{8770,14},{14516,29},{33019,80},{49543,13},{2609,28},{1925,69},{13215,68},{27978,47}};
	private static int[][] KEY_VALUE_3 = {{2420,62},{6023,100},{5108,29},{5295,14},{4032,61},{5324,19},{1600,29},{5728,4},{4805,36},{3693,35}};
	private static int[][] KEY_VALUE_4 = {{917,96},{390,7},{508,34},{112,41},{389,96},{383,99},{709,78},{484,55},{757,68},{27,41}};
	private static int[][] KEY_VALUE_5 = {{1066873,30},{924232,90},{1810296,20},{742021,7},{1102772,13},{987769,73},{1405290,4},{315528,91},{795037,98},{1743932,58}};
	private static String[] FILE_NAME = { "./data/dataset/dating_less.csv",
			"./data/dataset/jester.csv",
			"./data/dataset/ml-1m-ratings.csv",
			"./data/dataset/ml-100k-ratings.csv",
			"./data/dataset/yahoo.csv"};
	private static int[][][] PARAM_SET = {KEY_VALUE_1, KEY_VALUE_2, KEY_VALUE_3, KEY_VALUE_4, KEY_VALUE_5};
	
	public static void writeResult(List<Pair> result, String filename) {
		try
		{
		    FileWriter writer = new FileWriter(filename);
	 
		    writer.append("ItemID");
		    writer.append(',');
		    writer.append("Value");
		    writer.append('\n');
		    for(Pair p: result) {
		    	writer.append("" + p.itemID);
		    	writer.append(',');
		    	writer.append("" + p.value);
		    	writer.append('\n');
		    }
	 
		    //generate whatever data you want
	 
		    writer.flush();
		    writer.close();
		}
		catch(IOException e)
		{
		     e.printStackTrace();
		} 
	}
	
	public void recommendAll(int n) {
		for(int i = 0; i < 1; i ++) {
			String filename = FILE_NAME[i];
			int[][] params = PARAM_SET[i];
			for(int j = 0; j < 10; j ++) {
				int id = params[j][0];
				int num = params[j][1];
				String[] output = generateOutputFileNames(filename, j + 1, n);
				Recommender.runRecommender1(filename, id, num, output[0]);
				Recommender.runRecommender2(filename, id, num, output[1]);
				Recommender.runRecommender3(filename, id, num, output[2]);
				Recommender.runRecommender4(filename, id, num, output[3]);
				Recommender.runRecommender5(filename, id, num, output[4]);
				Recommender.runRecommender6(filename, id, num, output[5]);
				Recommender.runRecommender7(filename, id, num, output[6]);
				Recommender.runRecommender8(filename, id, num, output[7]);
				Recommender.runRecommender9(filename, id, num, output[8]);
				Recommender.runRecommender10(filename, id, num, output[9]);
				Recommender.runRecommender11(filename, id, num, output[10]);
				Recommender.runRecommender12(filename, id, num, output[11]);
			}
		}
	}
	
	private String[] generateOutputFileNames(String filename, int paramNum, int recomNum) {
		String[] temp = filename.split("/");
		String file = temp[temp.length - 1];
		String param = "_Param" + paramNum;
		String[] result = new String[recomNum];
		for(int i = 1; i <= recomNum; i ++) {
			String recom = "_Recommender" + i;
			result[i - 1] = "./result/" + file + param + recom + ".csv";
		}
		
		return result;
	}	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("./result/dating_less_performance.txt")), true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RecommenderExperiment r = new RecommenderExperiment();
		r.recommendAll(12); // the argument is the number of runRecommender() in Recommender.java
		
		
//		List<Pair> result = new ArrayList<Pair>();
//
//		try {
//			DataModel model = new FileDataModel(new File(
//					"./data/dataset/ml-100k-ratings.csv"));
//			 // UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
//			 ItemSimilarity similarity = new
//			 EuclideanDistanceSimilarity(model);
//			 // ItemSimilarity similarity = new UncenteredCosineSimilarity(model);
//			 // UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.01, similarity, model);
//			 // UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
//			 ItemBasedRecommender recommender = new
//			 GenericBooleanPrefItemBasedRecommender(model, similarity);
//			 List<RecommendedItem> recommendations = recommender.recommend(4,
//			 10);
//			 for (RecommendedItem recommendation : recommendations) {
//			 System.out.println(recommendation);
////			 Pair pair = new SampleRecommender.Pair(recommendation.getItemID(), recommendation.getValue());
////			 result.add(pair);
//			 }
//			 
//			 SampleRecommender r = new SampleRecommender();
//			 r.writeResult(result, "./result/sampleResult.csv");
//
////			int numFeatures = 4;
////			double lambda = 1;
////			int numIterations = 100;
////			Factorizer fac =  new ALSWRFactorizer(model, numFeatures, lambda, numIterations);
//////			new SVDPlusPlusFactorizer(model, numFeatures, numIterations);
////			SVDRecommender recommender = new SVDRecommender(model, fac);
////
////			List<RecommendedItem> recommendations = recommender
////					.recommend(2, 10);
////			for (RecommendedItem recommendation : recommendations) {
////				System.out.println(recommendation);
////			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TasteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
