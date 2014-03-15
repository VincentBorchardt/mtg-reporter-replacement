(ns mtg-reporter-replacement.gui
  (:use seesaw.core
        mtg-reporter-replacement.core
        mtg-reporter-replacement.results-gui))

(defn -main [& args]
  (invoke-later
    (-> results-frame
     pack!
     show!)))

(defn basic [& args]
  (invoke-later
    (-> (frame :title "Hello",
           :content "Hello, Seesaw",
           :on-close :exit)
     pack!
     show!)))


