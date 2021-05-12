(ns scvc.browser.pages
  (:require [rx.kitchen-sink :as ks]
            [rx.browser.page-navbar :as pn]
            [rx.browser.ui :as ui]
            [rx.browser.buttons :as btn]
            [rx.browser.components :as cmp]
            [reagent.core :as r]
            [reagent.dom :as rdom]
            [clojure.core.async :as async
             :refer [go <! timeout]]))

(defn navbar-btn [opts]
  [btn/button
   (ks/deep-merge
     {:style {:padding "4px 16px"
              :border-radius 999
              :background-color 'white
              :font-size 14
              :font-weight 'bold
              :color "#4F4F4F"}
      :hover-style {:background-color "rgba(0,0,0,0.05)"}
      :active-style {:background-color "rgba(0,0,0,0.1)"}}
     opts)])

(defn lp-balance-section []
  [:div
   {:style {:margin "150px 0"}}
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

(defn lp-callouts-section []
  [:div.callouts-section
   [:div.container
    [:div.row
     [:div.col-lg-8.offset-lg-2
      [:div.row
       [:div.col-lg-6
        [ui/g
         {:gap 24}
         [ui/g
          {:gap 12}
          [:img {:src "/img/alluvial_plain.jpg"
                 :style {:width "100%"}}]
          [:p
           {:style {:text-align 'right}}
           "Alluvial Cities that work in tandem with nature."]]

         [ui/g
          {:gap 12}
          [:img {:src "/img/tools_to_support_growth.jpg"
                 :style {:width "100%"}}]
          [:p
           {:style {:text-align 'left}}
           "Physical, Emotional and Professional tools that support individual growth."]]]]
       [:div.col-lg-6
        [ui/g
         {:gap 24}
         [ui/g
          {:gap 12}
          [:img {:src "/img/community_empowerment.jpg"
                 :style {:width "100%"}}]
          [:p
           {:style {:text-align 'right}}
           "Community empowerment that helps lift individuals from social in-equity."]]

         [ui/g
          {:gap 12}
          [:img {:src "/img/consumption_and_production.jpg"
                 :style {:width "100%"}}]
          [:p
           {:style {:text-align 'left}}
           "Consumption and production that reverses disaster to our environmental and personal health."]]]]]]]]])

(defn lp-companies-section []
  [:div
   {:style {:margin "150px 0"}}
   [:div.container
    [:div.row
     [:div.col-lg-8.offset-lg-2
      [:div {:style {:align-items 'center}}
       [:h2 {:style {:font-size 40
                     :font-family "'Noto Serif', serif"
                     :text-align 'center
                     :font-weight 'normal
                     :margin-bottom 28}}
        "Our Companies"]
       [:img {:src "/img/companies_placard.svg"}]]]]]])

(defn lp-board-meetings-section []
  [:div
   {:style {:margin "150px 0"}}
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
         "Board Meetings"]
        [:p "Startups can be grueling tests of emotional, mental and even physical endurance. As former founders we’re building infrastructure so that you can run the marathon, or catch the big wave."]
        [:div
         {:style {:text-align 'center}}
         [:a {:href "#"
              :style {:font-size 19
                      :text-decoration 'underline
                      :color "#072D2B"}}
          "Come to a Board Meeting"]]]]]]]])

(defn lp-our-team-section []
  [:div.our-team-section
   {:style {:margin "150px 0"}}
   [:div.container
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div {:style {:align-items 'center}}
       [ui/g
        {:gap 24}
        [:img {:src "/img/surfboards.svg"
               :style {:margin "0 auto"
                       :width 80
                       :height 80}}]
        [:h2 {:style {:font-size 40
                      :font-family "'Noto Serif', serif"
                      :text-align 'center
                      :font-weight 'normal}}
         "Our Team"]
        
        [:div.row
         [:div.col-4
          [ui/g {:gap  24
                 :style {:text-align 'center}}
           [:img {:src "/img/vu-avatar.png"}]
           [ui/g {:gap 4}
            [:h3 "Vu Tran"]
            [:h4 "Managing Partner"]
            [:p "Snap Product Development Research, Serial Entrepeneur, Y Combinator"]]]]
         [:div.col-4
          [ui/g
           {:gap  24
            :style {:text-align 'center}}
           [:img {:src "/img/josh-avatar.png"}]
           [ui/g {:gap 4}
            [:h3 "Josh Leong"]
            [:h4 "Managing Partner"]
            [:p "Google Assistant Machine Vision researcher, Autonomous Car Design, Airbnb, YC, Microsoft Excel Lead Designer, Shorts Enthusiast"]]]]
         [:div.col-4
          [ui/g
           {:gap 24
            :style {:text-align 'center}}
           [:img {:src "/img/zk-avatar.png"}]
           [ui/g {:gap 4}
            [:h3 "Zachary Kim"]
            [:h4 "Managing Partner"]
            [:p "Zaarly CTO, Neuro-computation researcher, Hawaii Horse Rancher."]]]]]]]]]]])

(defn index []
  {:render
   (fn []
     [:div.landing-page
      {:style {:width "100%"}}
      [:div {:style {:height 125}}]
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
         [:div.col-lg-8.offset-lg-2
          [:div.hero-section
           {:style {:text-align 'center
                    :color 'white}}
           [:h1
            {:style {:color 'white
                     :line-height 1.15
                     :margin-bottom 20}}
            "Surf Club" [:br] "Ventures"]
           [:div.col-lg-10.offset-lg-1
            [:p
             {:style {:font-size 22
                      :margin-bottom 20}}
             "We back companies that create a future of balance with nature, communities and ourselves."]]
           [:div
            [:a {:href "#"
                 :style {:font-size 22
                         :color 'white
                         :text-decoration 'underline}}
             "Say Hello"]]]]]]]

      [lp-balance-section]
      [:video
       {:width "100%"
        :autoPlay "autoPlay"
        :autoplay "autoplay"
        :loop "loop"
        :muted "muted"}
       [:source {:src "/vid/windpower.mp4" :type "video/mp4" }]]
      #_[lp-callouts-section]
      [lp-companies-section]
      [lp-board-meetings-section]
      [lp-our-team-section]
      [:div {:style {:height 700
                     :background "url('/img/surfguy.jpg')"
                     :background-position "50% 50%"
                     :background-size 'cover}}]
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
              [:img {:src "/img/surf_club_logo.svg"
                     :style {:width 75
                             :height 75
                             :transform (str "scale(" (- 1 (* pct 0.25)) ")")}}]
              [ui/g
               {:gap 12
                :horizontal? true}
               [ui/g {:gap 20 :horizontal? true :align-items 'center
                      :class "d-none d-lg-flex"}
                [navbar-btn
                 {:label "Team"}]
                [navbar-btn
                 {:label "Companies"}]
                [navbar-btn
                 {:label "Mission"}]
                [navbar-btn
                 {:label "Investor Login"
                  :before [:img {:src "/img/board_shorts_icon.svg"
                                 :style {:width 14
                                         :height 14}}]}]]
               [:div.d-block.d-lg-none
                [cmp/hamburger-menu]]]]]]])}]])})

(defn surf-club-hero-section []
  [:div {:style {:width "100%"
                 :height "100%"
                 :background-color "#0AA49A"
                 :display 'flex
                 :align-items 'center
                 :justify-content 'center
                 :position 'relative
                 :color 'white}}
   [:div {:style {:width "80%"
                  :height "80%"
                  :background-image "url('/img/wave-graphic.svg')"
                  :background-repeat 'no-repeat
                  :background-position "50% 50%"
                  :background-size 'contain
                  :display 'flex
                  :flex-direction 'column
                  :align-items 'center
                  :justify-content 'center}}
    [:h1
     {:style {:font-size "12vw"
              :line-height 1}}
     "Surf"
     [:br]
     "Club"
     [:br]]
    [:h1
     {:style {:font-size "5.8vw"
              :line-height 1.1}}
     "Ventures"]]
   [:div {:style {:position 'absolute
                  :bottom 0
                  :left 0
                  :right 0
                  :padding 20
                  :text-align 'center
                  :font-size "1vw"}}
    "Proprietary & Confidential"]])

(defn fund-intro-section []
  [:div {:style {:width "100%"
                 :min-height "100%"
                 :background-color "#0AA49A"
                 :display 'flex
                 :flex-direction 'column
                 :color 'white}}
   [:div {:style {:flex 1
                  :display 'flex
                  :flex-direction 'column
                  :justify-content 'flex-end
                  :background-image "url('/img/hawaii_city_fund_bg.jpg')"
                  :background-repeat 'no-repeat
                  :background-position "50% 100%"
                  :background-size 'cover
                  :padding "80px 40px"}}
    [ui/g {:gap 10}
     [:img {:src "/img/surf_club_logo.svg"
            :style {:width "10vw"}}]
     [:h2
      {:style {:font-size "6vw"}}
      "Dawn Patrol 1"]
     [:div {:style {:font-size "4vw"}}
      "US $5,500,000 Limited Partner Interest"]]]
   [:div {:style {:min-height 300
                  :width "100%"
                  :padding 40
                  :background-color "#0AA49A"}}
    [:div.container-fluid
     [:div.row
      [:div.col-lg-4
       [:p
        {:style {:font-size 17
                 :margin-bottom 20}}
        "This presentation is supplied to you in connection with your proposed investment in Dawn Patrol 1 (the “Fund”) and providesn certain confidential information on it’s investment manager. This presentation does not constitute an offering of interests in the Fund and any interests in the Fund are being offered solely on the basis of the Fund’s"]]
      [:div.col-lg-4
       [:p
        {:style {:font-size 17
                 :margin-bottom 20}}
        "Confidential Private Offering Memorandum. Numbers current as of end of March 2021. Do not copy or distribute."]
       [:p
        {:style {:font-size 17
                 :font-weight 'bold}}
        "Proprietary & Confidential"]
       [:p
        {:style {:font-size 17
                 :font-weight 'bold}}
        "© 2021 Surf Club Ventures"]]]]]])

(defn fund-highlights-section []
  [:div
   {:style {:background-image "url('/img/wave-shadow.svg')"
            :background-position "50% 50%"
            :background-size 'cover
            :background-repeat 'no-repeat
            :padding "80px 0"}}
   [:div.container
    [:div.row
     {:style {:margin-bottom 50}}
     [:div.col-lg-10.offset-lg-1
      [ui/g
       {:gap 20
        :horizontal? true
        :align-items 'center}
       [:img {:src "/img/wave-dark.svg"
              :style {:width 100
                      :height 100}}]
       [:h2
        {:style {:color "#0AA49A"
                 :font-size 50}}
        "HIGHLIGHTS"]]]]
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div.row
       [:div.col-lg-6
        [:h3 {:style {:font-size 36
                      :margin-bottom 16}}
         "Early Investments"]
        [:p
         {:style {:font-size 22}}
         "Proven track record of early investments in transformational companies, with standouts returning 80X."]
        [:div {:style {:padding "40px 0"}}
         [:hr]]
        [:img {:src "/img/companies-fund-graphic.svg"
               :style {:display 'block
                       :width "100%"}}]]
       [:div.col-lg-6
        [:h3 {:style {:font-size 36
                      :margin-bottom 16}}
         "Deep Experience LPs"]]]]]]])

(defn dawn-patrol-fund []
  {:render
   (fn []
     [:div {:style {:width "100%"
                    :height "100%"
                    :style {:font-family "'Noto Serif', serif"}}}
      [surf-club-hero-section]
      [fund-intro-section]
      [fund-highlights-section]])})

