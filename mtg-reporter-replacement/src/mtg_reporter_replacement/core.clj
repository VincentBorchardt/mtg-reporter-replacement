(ns mtg-reporter-replacement.core)

;Players need first and last names, along with DCI number
;I think they want country eventually, but that can come later
(defn create-player [first last num]
  {:first first, :last last, :number num, :results [], :points 0})

;Match results have a round number, the two players involved
;(identified by number since each player's round results are different under Clojure),
;each players wins and draws--the points calculation can be done outside match results,
;which extends to 3/5 and similiar stuff
(defn create-match-result [round-num playerA playerB first-wins second-wins draws]
  {:round round-num, :playerA (playerA :number), :playerB (playerB :number),
   :a-wins first-wins, :b-wins second-wins, :draws draws})

;This gives the match points for any specific result:
;3 points for a win (I have more wins than you)
;1 point for a draw (same amount of wins as you)
;0 points for a loss (fewer wins than you)
;I need to customize the default results (that's used in both result lists) to do so easily
(defn personal-match-result [player match-result]
  (if (= (player :number) (match-result :playerA))
    {:wins (match-result :a-wins) :losses (match-result :b-wins) :draws (match-result :draws)}
    {:wins (match-result :b-wins) :losses (match-result :a-wins) :draws (match-result :draws)}))

(defn calculate-match-points [player match-result]
  (let [res (personal-match-result player match-result)]
    (cond
      (> (res :wins) (res :losses)) 3
      (< (res :wins) (res :losses)) 0
      :else 1)))
(defn match-result-of-player? [player match-result]
  (or (= (player :number) (match-result :playerA)) (= (player :number) (match-result :playerB))))

(defn get-player-match-result [player match-results]
  (first (filter #(match-result-of-player? player %) match-results)))

(defn append-match-result-to-player [player match-result]
  {:first (player :first), :last (player :last), :number (player :number),
   :results (conj (player :results) match-result), :points (player :points)})

(defn process-match-results [players match-results]
  (map #(append-match-result-to-player % (get-player-match-result % match-results)) players))

(defn calculate-match-points-for-player [player]
  {:first (player :first), :last (player :last), :number (player :number),
   :results (player :results), :points (reduce + (map #(calculate-match-points player %) (player :results)))})

(defn process-match-points [players]
  (map calculate-match-points-for-player players))

(defn sort-standings [players]
  (reverse (sort-by #(% :points))))
;That is the standings for the round, or at least all the players in the round
;it probably needs a full-tournament wrapper with all the info that requires--notably the round number that keeps getting updated
  
