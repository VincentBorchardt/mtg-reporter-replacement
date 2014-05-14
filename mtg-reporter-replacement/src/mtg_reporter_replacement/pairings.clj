(ns mtg-reporter-replacement.pairings
  (:use mtg-reporter-replacement.core))

;Players are defaulted to :points 0, so points is always there
;This determines the number of players at each point value, and sorts it from most points to least points
(defn get-num-at-each-match-points [tourney]
  (reverse (sort-by #(first %1) (first (partition 2 (frequencies (map #(% :points) tourney)))))

