package org.dc.ml.problem.weka.classifier;

import java.io.File;

import org.dc.engine.weka.data.LoadData;

import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class HouseDefaulter {

	public static void main(String[] args) throws Exception {
		
		String path = "D:/MACHINE_LEARNING/DATA/WEKA/HOUSE_DEFAULTER_CLASSIFIER/house_defaulter.arff";

		Instances dataset = LoadData.loadDataset(path);
		dataset.setClassIndex(dataset.numAttributes() - 1);

		// decision trees
		String[] options = new String[1];
		options[0] = "-U";
		J48 tree = new J48();
		tree.setOptions(options);
		tree.buildClassifier(dataset);
		System.out.println(tree);

		// support vector machines
		SMO svm = new SMO();
		svm.buildClassifier(dataset);
		System.out.println(svm);

		// incremental Naive Bayes classifier
		ArffLoader loader = new ArffLoader();

		loader.setFile(new File(path));
		Instances dataStructure = loader.getStructure();
		dataStructure.setClassIndex(dataStructure.numAttributes() - 1);
		NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
		nb.buildClassifier(dataStructure);
		Instance current;
		while ((current = loader.getNextInstance(dataStructure)) != null)
			nb.updateClassifier(current);
		System.out.println(nb);

		// classify the last instance
		Instance weather = dataset.lastInstance();
		double predictedWeather = nb.classifyInstance(weather);
		
		
		System.out.println("Weather Naive Bayes(" + weather + "): " + predictedWeather);
		System.out.println("Weather Tree(" + weather + "): " + tree.classifyInstance(weather));
		System.out.println("Weather SVM(" + weather + "): " + svm.classifyInstance(weather));

	}
}
