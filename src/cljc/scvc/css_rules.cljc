(ns scvc.css-rules
  (:require [garden.stylesheet :refer [at-media]]
            [garden.core :as garden]))

(def bp-xs {:min-width "0px" :max-width "575px"})
(def bp-sm {:min-width "576px" :max-width "767px"})
(def bp-md {:min-width "768px" :max-width "991px"})
(def bp-<md {:max-width "991px"})
(def bp-lg {:min-width "992px" :max-width "1199px"})
(def bp-<lg {:max-width "1199px"})
(def bp-xl {:min-width "1200px"})

(defn rules [opts]
  [[:body {:font-family "'Noto Serif', 'Helvetica Neue', sans-serif"}]
   [:.landing-page {:font-family "'Noto Serif', serif"}]
   [:.hero-section
    [:h1 {:font-size "80px"}
     (at-media bp-xs
       [:& {:font-size "50px"}])]]
   [:img {:max-width "100%"
          :display 'block}]
   [:h1 :h2 {:font-family "'Bungee', sans-serif"}]
   [:.callouts-section
    [:p
     {:font-size "19px"}]]
   [:.our-team-section
    [:h3
     {:font-size "30px"}
     #_(at-media bp-xs
         [:& {:font-size "13px"}])]
    [:h4
     {:margin-bottom "4px"}
     #_(at-media bp-xs
         [:& {:font-size "9px"}])]
    [:p
     #_(at-media bp-xs
         [:& {:font-size "12px"}])]]])
