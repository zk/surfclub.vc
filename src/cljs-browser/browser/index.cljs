(ns browser.index
  (:require [rx.kitchen-sink :as ks]
            [rx.browser.page-navbar :as pn]
            [rx.browser.ui :as ui]
            [rx.browser.buttons :as btn]))

(defn navbar-btn [opts]
  [btn/button
   (ks/deep-merge
     {:style {:padding "4px 16px"
              :border-radius 999
              :background-color 'white
              :font-size 16
              :font-weight 'bold
              :color "#4F4F4F"}}
     opts)])

(defn lp-balance-section []
  [:div
   {:style {:padding "100px 0"}}
   [:div.container
    [:div.row
     [:div.col-lg-6.offset-lg-3
      [:div {:style {:align-items 'center}}
       [ui/g
        {:gap 24}
        [:img {:src "/img/vw-bus-icon.svg"
               :style {:margin "0 auto"
                       :width 80
                       :height 80}}]
        [:h2 {:style {:font-size 40
                      :font-family "'Noto Serif', serif"
                      :text-align 'center
                      :font-weight 'normal}}
         "Bring Balance Forward"]
        [:p "Surf Club Ventures is a founder led early stage venture capital firm that supports companies that transform our un-sustainable relationship with nature, and the zero-sum games that imbalance our communities and personal lives."]
        [:p "We support balanced companies and help founders that create enduring value through technology that changes the quotient of trade-offs we encounter everyday."]]]]]]])

(defn view []
  {:render
   (fn []
     [:div.landing-page
      {:style {:width "100%"}}
      [:div {:style {:height 150}}]
      [:div.hero-section
       {:style {:background "url('/img/lp_hero_background.jpg')"
                :background-position "50% 50%"
                :background-size 'cover
                :min-height 700

                :display 'flex
                :align-items 'center
                :justify-content 'center}}
       [:div.container
        [:div.row
         [:div.col-lg-6.offset-lg-3
          [:div.hero-section
           {:style {:text-align 'center
                    :color 'white}}
           [:h1
            {:style {:color 'white
                     :line-height 1.15
                     :margin-bottom 20}}
            "Surf Club" [:br] "Ventures"]
           [:p
            {:style {:font-size 22
                     :margin-bottom 20}}
            "We back companies that create a future of balance with nature, communities and ourselves."]
           [:div
            [:a {:href "#"
                 :style {:font-size 22
                         :color 'white
                         :text-decoration 'underline}}
             "Say Hello"]]]]]]]

      [lp-balance-section]
      [pn/navbar
       {:render
        (fn [{:keys [pct]}]
          [:div
           {:style {:height (+ 75 (* 75 (- 1 pct)))
                    :display 'flex
                    :background-color
                    "white"
                    #_(str "rgba(255,255,255," (* 1 (* pct pct)) ")")
                    
                    :align-items 'center
                    :font-family "'Lato', Helvetica, sans-serif"}}
           [:div.container
            [:div.col-lg-10.offset-lg-1
             [ui/g
              {:horizontal? true
               :justify-content 'space-between
               :align-items 'center
               :style {:flex 1}}
              (let [size (+ 50 (* 25 (- 1 pct)))]
                [:img {:src "/img/surf_club_logo.svg"
                       :style {:width 75
                               :height 75
                               :transform (str "scale(" (- 1 (* pct 0.25)) ")")}}])
              [ui/g
               {:gap 12
                :horizontal? true}
               #_[navbar-btn
                {:label "Team"}]
               #_[navbar-btn
                {:label "Companies"}]
               #_[navbar-btn
                {:label "Mission"}]
               #_[navbar-btn
                  {:label "Investor Login"
                   :before [:img {:src "/img/board_shorts_icon.svg"}]}]]
              #_[:div "HI"]]]]])}]])})





