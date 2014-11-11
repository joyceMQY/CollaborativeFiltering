import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.ItemAverageRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.GenericItemSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;



public class Recommender {
	//GenericBooleanPrefItemBasedRecommender
	//GenericItemBasedRecommender
	//ItemAverageRecommender
	//ItemUserAverageRecommender
	
	//CityBlockSimilarity
	//EuclideanDistanceSimilarity
	//GenericItemSimilarity
	//LogLikelihoodSimilarity
	//PearsonCorrelationSimilarity
	//TanimotoCoefficientSimilarity
	//UncenteredCosineSimilarity
	
	//GenericBooleanPrefItemBasedRecommender + CityBlockSimilarity
	public static List<Pair> runRecommender1(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new CityBlockSimilarity(model);
			ItemBasedRecommender recommender = new GenericBooleanPrefItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericBooleanPrefItemBasedRecommender + EuclideanDistanceSimilarity
	public static List<Pair> runRecommender2(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new EuclideanDistanceSimilarity(model);
			ItemBasedRecommender recommender = new GenericBooleanPrefItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericBooleanPrefItemBasedRecommender + LogLikelihoodSimilarity
	public static List<Pair> runRecommender3(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new LogLikelihoodSimilarity(model);
			ItemBasedRecommender recommender = new GenericBooleanPrefItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericBooleanPrefItemBasedRecommender + PearsonCorrelationSimilarity
	public static List<Pair> runRecommender4(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
			ItemBasedRecommender recommender = new GenericBooleanPrefItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericBooleanPrefItemBasedRecommender + TanimotoCoefficientSimilarity
	public static List<Pair> runRecommender5(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new TanimotoCoefficientSimilarity(model);
			ItemBasedRecommender recommender = new GenericBooleanPrefItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericBooleanPrefItemBasedRecommender + UncenteredCosineSimilarity
	public static List<Pair> runRecommender6(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new UncenteredCosineSimilarity(model);
			ItemBasedRecommender recommender = new GenericBooleanPrefItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

	//GenericItemBasedRecommender + CityBlockSimilarity
	public static List<Pair> runRecommender7(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new CityBlockSimilarity(model);
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericItemBasedRecommender + EuclideanDistanceSimilarity
	public static List<Pair> runRecommender8(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new EuclideanDistanceSimilarity(model);
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericItemBasedRecommender + LogLikelihoodSimilarity
	public static List<Pair> runRecommender9(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new LogLikelihoodSimilarity(model);
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericItemBasedRecommender + PearsonCorrelationSimilarity
	public static List<Pair> runRecommender10(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericItemBasedRecommender + TanimotoCoefficientSimilarity
	public static List<Pair> runRecommender11(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new TanimotoCoefficientSimilarity(model);
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//GenericItemBasedRecommender + UncenteredCosineSimilarity
	public static List<Pair> runRecommender12(String filename, int id, int num, String output) {
		List<Pair> result = new ArrayList<Pair>();

		try {
			
			long readStart = System.currentTimeMillis();
			DataModel model = new FileDataModel(new File(filename));
			long readEnd = System.currentTimeMillis();
			
			long modelStart = System.currentTimeMillis();
			ItemSimilarity similarity = new UncenteredCosineSimilarity(model);
			ItemBasedRecommender recommender = new GenericItemBasedRecommender(
					model, similarity);
			long modelEnd = System.currentTimeMillis();
			
			long recStart = System.currentTimeMillis();
			List<RecommendedItem> recommendations = recommender.recommend(id,
					num);
			long recEnd = System.currentTimeMillis();
			
			for (RecommendedItem recommendation : recommendations) {
				Pair pair = new Pair(recommendation.getItemID(),
						recommendation.getValue());
				result.add(pair);
			}

			RecommenderExperiment.writeResult(result, output);
			System.out.println("==================================================");
			System.out.println("Similarity Class: " + similarity.getClass().getSimpleName());
			System.out.println("Recommender Class: " + recommender.getClass().getSimpleName());
			System.out.println("Output Filename: " + output);
			System.out.println("Time to read file: " + (readEnd - readStart));
			System.out.println("Time to build model: " + (modelEnd - modelStart));
			System.out.println("Time to recommend: " + (recEnd - recStart));
			System.out.println("==================================================");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

	//Not Item-based:
	//ItemAverageRecommender	
	//ItemUserAverageRecommender
}
