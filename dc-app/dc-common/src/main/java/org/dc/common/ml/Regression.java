package org.dc.common.ml;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Regression {

	public static void main(String[] args) throws Exception {

		// load dataset
		DataSource source = new DataSource("/home/likewise-open/ACADEMIC/csstnns/Desktop/qdb1.arff");
		Instances dataset = source.getDataSet();
		// set class index to the last attribute
		dataset.setClassIndex(dataset.numAttributes() - 1);

		// build model
		LinearRegression lr = new LinearRegression();
		lr.buildClassifier(dataset);
		// output model
		System.out.println(lr);
	}
}
