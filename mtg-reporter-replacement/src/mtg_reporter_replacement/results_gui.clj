(ns mtg-reporter-replacement.results-gui
  (:use seesaw.core
        seesaw.table))

(def two-zero-button (button :text "2-0"))
(def two-one-button (button :text "2-1"))
(def one-two-button (button :text "1-2"))
(def zero-two-button (button :text "0-2"))

;(listen b :action #(alert % "response"))

(def pairings-listbox (listbox :model ["item 1" "item 2" "item 3"]))

;this doesn't show headings even though I think it should?
(def pairings-table 
  (table :model
         [:columns [{:key :player1, :name "Player 1"} :player2]
          :rows '[["test 1" "test 2"]
                  ["test 3" "test 4"]
                  {:player1 "test 5" :player2 "test 6"}]]))

(def buttons-panel (flow-panel
    :align :left
    :hgap 20
    :items [two-zero-button two-one-button one-two-button zero-two-button]))

(def results-content
  (border-panel :hgap 10 :vgap 10
                :south buttons-panel
                :center pairings-table))

(def results-frame 
  (frame :title "Results Frame"
         :content results-content))