package org.dc.common.ml.naviebayes;

import java.util.List;

public interface Classifier {
	void trainClassifier(List<Human> humans);
	String classify(Human human);
}
