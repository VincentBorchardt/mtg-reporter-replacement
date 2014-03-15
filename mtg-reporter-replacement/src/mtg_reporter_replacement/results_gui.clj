(ns mtg-reporter-replacement.results-gui)

(def b (button :text "Some Text"))
(def c (button :text "More Text"))

(listen b :action #(alert % "response"))

(def buttons-panel (flow-panel
    :align :left
    :hgap 20
    :items [b c]))

(def results-content
  (border-panel :hgap 10 :vgap 10
                :south buttons-panel
                :center "Center!"))

(def results-frame 
  (frame :title "Results Frame"
         :content results-content))