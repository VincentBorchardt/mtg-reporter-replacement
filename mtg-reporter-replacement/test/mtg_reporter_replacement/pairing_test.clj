(ns mtg-reporter-replacement.pairing-test
    (:use clojure.test
        mtg-reporter-replacement.core
        mtg-reporter-replacement.pairings))

(deftest getting-num-at-match-points-test
  (testing "getting the num of people at each point total works"
           (is (= (get-num-at-each-match-points [{:player "thing" :points 3} {:player "stuff" :points 0} {:player "more" :points 3}]) 
                  ([3 2] [0 1])))))

