(ns mtg-reporter-replacement.core-test
  (:use clojure.test
        mtg-reporter-replacement.core))

;(deftest a-test
;  (testing "FIXME, I fail."
;    (is (= 0 1))))
(def sample-player {:first "Sample", :last "Player", :number 123, :results [], :points 0})
(def second-player {:first "Second", :last "Person", :number 456, :results [], :points 0})
(def match-result-one {:round 1, :playerA 123, :playerB 456, :a-wins 2, :b-wins 1, :draws 0})
(def match-result-two {:round 1, :playerA 123, :playerB 456, :a-wins 1, :b-wins 2, :draws 0})
(def match-result-three {:round 1, :playerA 123, :playerB 456, :a-wins 1, :b-wins 1, :draws 1})

(deftest create-player-test
  (testing "creating players works"
           (is (= (create-player "Sample" "Player" 123) sample-player))))

(deftest create-match-result-test
  (testing "creating match results works"
           (is (= (create-match-result 1 sample-player second-player 2 1 0) match-result-one))))

(deftest calculate-match-points-test
  (testing "creating match points works"
           (is (= (calculate-match-points sample-player match-result-one) 3))
           (is (= (calculate-match-points sample-player match-result-two) 0))
           (is (= (calculate-match-points sample-player match-result-three) 1))
           (is (= (calculate-match-points second-player match-result-one) 0))
           (is (= (calculate-match-points second-player match-result-two) 3))
           (is (= (calculate-match-points second-player match-result-three) 1))))

