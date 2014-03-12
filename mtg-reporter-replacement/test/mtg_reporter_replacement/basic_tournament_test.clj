(ns mtg-reporter-replacement.basic-tournament-test
  (:use clojure.test
      mtg-reporter-replacement.core))

(def player1 (create-player "Joe" "First" 1))
(def player2 (create-player "Mary" "Second" 2))
(def player3 (create-player "Harry" "Third" 3))
(def player4 (create-player "Sue" "Fourth" 4))
(def tourney-round-0 [player1 player2 player3 player4])

(def match-1-1 (create-match-result 1 player1 player2 2 1 0))
(def match-1-2 (create-match-result 1 player3 player4 1 2 0))
(def round-1-results [match-1-1 match-1-2])

(def tourney-with-r1-results (process-match-results tourney-round-0 round-1-results))
(def tourney-round-1 (process-match-points tourney-with-r1-results))