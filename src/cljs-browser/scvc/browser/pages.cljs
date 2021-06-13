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

(defn para [& args]
  (let [[opts & children] (ks/ensure-opts args)]
    (into
      [:p (ks/deep-merge
            {:style {:font-size 20
                     :margin-bottom 40}}
            opts)]
      children)))

(defn lp-balance-section []
  [:div
   {:style {:margin "100px 0"
            :position 'relative}}
   [:img {:src "/img/wave-shadow.svg"
          :style {:position 'absolute
                  :top 0
                  :left 0
                  :right 0}}]
   [:div.container
    [:div.row
     [:div.col-lg-8.offset-lg-2
      [:div.row
       [:div.col-lg-12
        [:div {:style {:text-align 'center}}
         [:img {:src "/img/vw-bus-icon.svg"
                :style {:margin "0 auto 30px auto"
                        :width 80
                        :height 80}}]
         [:h2 {:style {:font-size 40
                       :font-family "'Noto Serif', serif"
                       :text-align 'center
                       :font-weight 'normal
                       :margin "0 auto 40px auto"}}
          "Forward Balance"]]]]
      [:div.row
       [:div.col-lg-6
        [para
         "Surf Club is an early stage venture capital fund that focuses on investing in deep technology that has the potential to unlock the third wave of personal computing and the new applications that come during that era."]]
       [:div.col-lg-6
        [para "We’re looking for companies that transform our un-sustainable relationship with nature, and the zero-sum games that imbalance our communities and personal lives."]]]]]]])

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
   {:style {:background-color "#0AA49A"
            :color 'white
            :padding "75px 0"
            :position 'relative}}
   [:img {:src "/img/wave-shadow-left.svg"
          :style {:position 'absolute
                  :top 300
                  :left 0
                  :width 1200}}]
   [:div
    {:id "companies"
     :style {:margin "75px 0"}}
    [:div.container
     [:div.row
      [:div.col-lg-8.offset-lg-2
       [:div {:style {:align-items 'center}}
        [:img {:src "/img/surfboards-white.svg"
               :style {:display 'block
                       :margin "0 auto"
                       :height 100
                       :margin-bottom 40}}]
        [:h2 {:style {:font-size 50
                      :font-family "'Noto Serif', serif"
                      :text-align 'center
                      :font-weight 'normal
                      :margin-bottom 40}}
         "You're in great company"]]]]]
    [:div {:style {:padding "80px 0"}}
     [:div.container
      [:div.row
       [:div.col-lg-8.offset-lg-2
        [:div {:style {:align-items 'center}}
         [:img {:src "/img/companies-placard-white.svg"}]]]]]]]])

(defn lp-board-meetings-section []
  [:div
   {:style {:margin "150px 0"
            :position 'relative}}
   [:img {:src "/img/wave-shadow-right.svg"
          :style {:position 'absolute
                  :top 0
                  :left 0
                  :right 0
                  :z-index -1}}]
   [:div.container
    [:div.row
     [:div.col-lg-6.offset-lg-3
      [:div {:style {:align-items 'center}}
       [:img {:src "/img/vw-bus-icon.svg"
              :style {:margin "0 auto 40px auto"
                      :width 80
                      :height 80}}]
       [:h2 {:style {:font-size 40
                     :font-family "'Noto Serif', serif"
                     :text-align 'center
                     :font-weight 'normal
                     :margin "0 auto 40px auto"}}
        "Board Meetings"]
       [para "Hawaii is the home of surfing, a practice that is deeply ingrained in its culture and history. It’s a practice in connecting with nature, community and oneself. Come out and catch a wave with us sometime."]
       [:div
        {:style {:text-align 'center}}
        [:a {:href "https://calendly.com/surfclubventures/board-meeting"
             :target "_blank"
             :style {:font-size 19
                     :text-decoration 'underline
                     :color "#072D2B"}}
         "Attend a Board Meeting"]]]]]]])

(defn lp-our-team-section []
  [:div.our-team-section
   {:id "team"
    :style {:margin "150px 0"}}
   [:div.container
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div {:style {:align-items 'center}}
       [ui/g
        {:gap 24}
        [:img {:src "/img/surfboards.svg"
               :style {:margin "0 auto"
                       :width 120
                       :height 120}}]
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
            [:p "Snap Product Development Research, Serial Entrepeneur, YC Founder"]]]]
         [:div.col-4
          [ui/g
           {:gap  24
            :style {:text-align 'center}}
           [:img {:src "/img/josh-avatar.png"}]
           [ui/g {:gap 4}
            [:h3 "Josh Leong"]
            [:h4 "Managing Partner"]
            [:p "Google Assistant Machine Vision researcher, Autonomous Car Design, Airbnb, YC Founder, Microsoft Excel Lead Designer, Shorts Enthusiast"]]]]
         [:div.col-4
          [ui/g
           {:gap 24
            :style {:text-align 'center}}
           [:img {:src "/img/zk-avatar.png"}]
           [ui/g {:gap 4}
            [:h3 "Zachary Kim"]
            [:h4 "Managing Partner"]
            [:p "Former Zaarly CTO, Neuro-computation researcher, Hawaii horse rancher"]]]]]]]]]]])

(defn photo-our-team-section []
  [:div.our-team-section
   {:id "team"
    :style {:margin "0 0 150px 0"}}
   [:div
    [:div
     {:style {:width "100%"
              :max-width 1200
              :margin "0 auto 60px auto"
              :position 'relative}}
     [:img {:src "/img/team-photo.jpg"
            :style {:width "100%"
                    :display 'block
                    :margin "0 auto 60px auto"
                    :max-width 1200}}]

     [:img {:src "/img/surf-club-partners-logo.svg"
            :style {:position 'absolute
                    :top 40
                    :right 40
                    :width 120}}]]]
   [:div.container
    [:div.row
     [:div.col-lg-12
      [:div {:style {:align-items 'center}}
       [ui/g
        {:gap 24}
        
        [:div.row
         [:div.col-4
          [ui/g {:gap  24}
           [ui/g {:gap 4}
            [:h3
             {:style {:font-weight 'normal
                      :font-size 38}}
             "Vu Tran"]
            [:h4
             {:style {:margin-bottom 20}}
             "General Partner"]
            [:h4
             {:style {:margin-bottom 20}}
             "2x YC Founder, Snap Crypto engineering research lead, serial entrepreneur, real estate investor, experienced venture capitalist."]
            [:p "Vu has a deep technical and product background. He can write legitimately good code and has lead large scale engineering efforts at both Postmates and Snapchat as an individual contributor and as a senior manager."]]]]
         [:div.col-4
          [ui/g
           {:gap 24}
           [ui/g {:gap 4}
            [:h3
             {:style {:font-weight 'normal
                      :font-size 38}}
             "Zack Kim"]
            [:h4
             {:style {:margin-bottom 20}}
             "General Partner"]
            [:h4
             {:style {:margin-bottom 20}}
             "YC Founder, former Zaarly CTO, angel investor, LISP hacker, horse rancher."]
            [:p "Zack comes from a deeply technical background. As a Neurosurgical methods researcher he aided individuals suffering from Parkinson's disease in reducing essential tremors via an electrical impulse device."]]]]
         [:div.col-4
          [ui/g
           {:gap  24}
           [ui/g {:gap 4}
            [:h3
             {:style {:font-weight 'normal
                      :font-size 38}}
             "Josh Leong"]
            [:h4
             {:style {:margin-bottom 20}}
             "General Partner"]
            [:h4
             {:style {:margin-bottom 20}}
             "YC Founder, Google Assistant machine vision research, autonomous car design. Airbnb principal, Microsoft Excel lead designer, shorts enthusiast."]
            [:p "Inspired by his time collaborating with  CDG the former Xerox Parc Researchers famous for inventing the first two computing revolutions, Josh is investing and inventing in the next personal computation revolution."]]]]
         ]]]]]]])

(defn lp-alluvial-cities-section []
  [:div
   [:div.container
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:video
       {:width "100%"
        :autoPlay "autoPlay"
        :autoplay "autoplay"
        :loop "loop"
        :muted "muted"
        :style {:margin "0 0 8px 0"}
        :poster "/img/building-cities-cover.jpg"}
       [:source {:src "/vid/windpower.mp4" :type "video/mp4" }]]
      [para
       {:style {:text-align 'right}}
       "Surf Lab - Building New Cities"]]]]])

(defn lp-new-balance-section []
  [:div
   {:style {:margin "150px 0"
            :position 'relative}}
   [:img {:src "/img/wave-shadow-left.svg"
          :style {:position 'absolute
                  :top 0
                  :left 0
                  :right 0
                  :z-index -1}}]
   [:div.container
    [:div.row
     [:div.col-lg-8.offset-lg-2
      [:div.row
       [:div.col-lg-12
        [:div {:style {:text-align 'center}}
         [:img {:src "/img/wave-icon.svg"
                :style {:margin "0 auto 30px auto"
                        :width 120
                        :height 120}}]
         [:h2 {:style {:font-size 40
                       :font-family "'Noto Serif', serif"
                       :text-align 'center
                       :font-weight 'normal
                       :margin "0 auto 40px auto"}}
          "New Balance"]]]]
      [:div.row
       [:div.col-lg-6
        [para
         "We think the great technology companies of the next generation will come from the deep existential problem spaces that we are coming to terms with now. "]
        [para
         "From the relationship our cities have with the natural environment, to our threatened sources of sustenance, to the intractable social in-equity in our societies and the very information systems we rely on to form our view of the world."]]
       [:div.col-lg-6
        [para "The big problems left to be solved today are deeply complex; unable to be solved with our existing tools whether they be organizational, mechanical, electrical or even traditional software."]
        [para "However they also represent the biggest opportunity for long term economic return, regenerative eco-systems, and inclusive societies."]]]]]]])


(defn lp-dawn-patrol-network []
  [:div
   {:style {:margin "150px 0 0 0"
            :position 'relative}}
   [:div.container
    [:div.row
     [:div.col-lg-8.offset-lg-2
      [:div.row
       [:div.col-lg-12
        [:div {:style {:text-align 'center}}
         [:img {:src "/img/dawn-patrol-logo.png"
                :style {:margin "0 auto 50px auto"
                        :height 150}}]
         [:h2 {:style {:font-size 45
                       :font-family "'Noto Serif', serif"
                       :text-align 'center
                       :font-weight 'normal
                       :margin "0 auto 60px auto"}}
          "Dawn Patrol Network"]]]]
      [:div.row
       [:div.col-lg-6
        [para
         "Surf Club is run by founders who can build. We invest, lead and drive impact into communities with real world projects and software and it’s no different in how we approach venture."]]
       [:div.col-lg-6
        [para "The Dawn Patrol Network is a community run platform of founders discovering and vetting new companies built on top of a web3 staking incentive system."]]]
      [:div {:style {:height 40}}]
      [:div.row
       [:div.col-lg-12
        [:img {:src "/img/dawn-patrol-supporters.png"
               :style {:display 'block
                       :margin "0 auto"}}]]]
      [:div {:style {:height 80}}]
      [:div.row
       [:div.col-lg-10.offset-lg-1
        [btn/button
         {:label "Sign up for the Beta"
          :href "https://docs.google.com/forms/d/e/1FAIpQLSdtRKBzkVHPbqNwed2i5NqIziqbh9Jrweq4_8vPRMtz4_ju3g/viewform"
          :target "_blank"
          :style {:background-color "#34A1F4"
                  :margin "0 auto 20px auto"
                  :color 'white
                  :padding "16px 90px"
                  :letter-spacing 1
                  :border-radius 999
                  :font-size 28
                  :text-decoration 'none}
          :hover-style {:background-color "#238AD9"}
          :active-style {:background-color "#275E87"}}]
        [para
         {:style {:font-size 15
                  :color "#072D2B"
                  :text-align 'center}}
         "Currently prioritizing YC and Surf Club Founders"]]]]]
    [:div {:style {:height 100}}]
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:img {:src "/img/dawn-patrol-screens.png"
             :style {:display 'block
                     :margin "0 auto"}}]]]]])

(defn tshirt-logo-section []
  [:div
   {:style {:background-image "url('/img/thesis-overview-bg.jpg')"
            :background-repeat 'no-repeat
            :background-size 'cover}}
   [:img {:src "/img/surf-club-tshirt-logo.svg"
          :style {:display 'block
                  :margin "0 auto"
                  :padding "100px 0"
                  :width "90vw"}}]])

(defn index []
  {:render
   (fn []
     [:div.landing-page
      {:style {:width "100%"}}
      [:div {:style {:height 125}}]
      [:div.hero-section
       {:style {:background "url('/img/lp-hero-bg.jpg')"
                :background-position "50% 50%"
                :background-size 'cover
                :min-height 700

                :display 'flex
                :align-items 'center
                :justify-content 'center}}
       [:div.container
        [:div.row
         [:div.col-lg-10.offset-lg-1
          [:div.hero-section
           [:img {:src "/img/lp-hero-fg.svg"
                  :alt "Surf Club Ventures"}]]]]]]
      [:div {:style {:height 40}}]
      [:div.container
       [:div.row
        [:div.col-lg-8.offset-lg-2
         [:h3
          {:style {:font-size 32
                   :margin-bottom 20
                   :text-align 'center}}
          "We back technology companies that create a future of balance with nature, communities and ourselves."]]]]

      [lp-balance-section]
      [lp-alluvial-cities-section]
      #_[lp-callouts-section]
      [lp-new-balance-section]
      [lp-companies-section]
      [lp-board-meetings-section]
      [:div {:style {:height 700
                     :background "url('/img/surf-hangout.jpg')"
                     :background-position "50% 50%"
                     :background-size 'cover
                     :display 'flex
                     :align-items 'flex-end
                     :justify-content 'flex-end}}
       [:img {:src "/img/surf-club-wave-outline.svg"
              :style {:display 'block
                      :width 200
                      :margin 30}}]]

      [lp-dawn-patrol-network]
      [photo-our-team-section]
      [tshirt-logo-section]

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
                 {:label "Companies"
                  :href "#companies"}]
                [navbar-btn
                 {:label "Team"
                  :href "#team"}]
                #_[navbar-btn
                   {:label "Mission"
                    :href "#mission"}]
                #_[navbar-btn
                   {:label "Investor Login"
                    :before [:img {:src "/img/board_shorts_icon.svg"
                                   :style {:width 14
                                           :height 14}}]}]]
               #_[:div.d-block.d-lg-none
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

(defn dp-pitch-embed []
  [:div {:style {:width "100%"
                 :height "100%"
                 :background-color "#0AA49A"
                 :display 'flex
                 :align-items 'center
                 :justify-content 'center
                 :position 'relative
                 :color 'white}}
   [:div {:style {:width "100%"
                  :height "100%"
                  :background-image "url('/img/pitch-bg.jpg')"
                  :background-repeat 'no-repeat
                  :background-position "50% 50%"
                  :background-size 'cover
                  :position 'relative
                  :display 'flex
                  :flex-direction 'column
                  :align-items 'center
                  :justify-content 'center
                  }}
    [:div
     {:style {:height 0
              :overflow 'hidden
              :padding-top "45%"
              :width "80%"
              :position 'relative
              :background-color 'white}}
     [:iframe {:src "https://app.pitch.com/app/embed/294106da-dd27-4665-93ea-c41f88abc027"
               :allow "fullscreen"
               :allowfullscreen ""
               :width "100%"
               :height "100%"
               :style {:position 'absolute
                       :top 0
                       :left 0
                       :right 0
                       :bottom 0
                       :border "none"}}]]]
   
   [:div {:style {:position 'absolute
                  :bottom 0
                  :left 0
                  :right 0
                  :padding 20
                  :text-align 'center
                  :font-size "1vw"}}
    "Limited Partner Deck"]])

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
       #_[:div.col-lg-6
          [:h3 {:style {:font-size 36
                        :margin-bottom 16}}
           "Deep Experience LPs"]]]]]]])

(defn impetus-section []
  [:div
   [:div {:style {:width "100%"
                  :height 400
                  :background-image "url('/img/hawaii-city-page-header-bg.jpg')"
                  :background-position "50% 50%"
                  :background-size 'cover
                  :display 'flex
                  :align-items 'center
                  :justify-content 'center}}
    [:div.container
     [:div.row
      [:div.col-lg-8.offset-lg-2
       
       [:div
        {:style {:color 'white
                 :text-align 'center}}
        [:h3
         {:style {:font-size 30
                  :margin-bottom 20}}
         "Peace cannot be kept by force; it can only be achieved by understanding."]
        [:p "Albert Einstien"]]]]]]
   [:div
    {:style {:margin "100px 0"}}
    [:div.container
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div
        {:style {:text-align 'center}}
        [:img {:src "/img/vw-bus-icon.svg"
               :style {:display 'block
                       :margin "0 auto 30px auto"}}]
        [:h3
         {:style {:font-size 50
                  :margin-bottom 60}}
         "Surf Club is looking for new vehicles of peace & prosperity"]]]]
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div.row
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Surf Club is an early stage venture capital fund that focuses on investing in deep technology that has the potential to unlock the third wave of personal computing and the new applications that come during that era."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Every personal computation wave was bigger than anyone could have imagined at the time, and also so different from each other that the transformational applications of the next were terribly difficult for the established powers to anticipate."]]
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We are seeing a new swell of technology from computational architecture & agriculture, advanced machine visions systems, cost effective robotics to new interface technology and tools for thought."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We believe that these forces will coalesce into a new era of inclusive technology where computation is part of our physical environment, and the traditional intractable problems such as eco-system failure, resource depletion and social in-equity will be transformed for the better."]]]]]]]])

(defn venn-diagram-section []
  [:div {:style {:margin "150px 30px"}}
   [:img {:src "/img/venn-diagram.png"
          :style {:display 'block
                  :margin "0 auto"}}]])

(defn thesis-overview-section []
  [:div
   [:div {:style {:width "100%"
                  :background-image "url('/img/thesis-overview-bg.jpg')"
                  :background-position "50% 50%"
                  :background-size 'cover
                  :display 'flex
                  :align-items 'center
                  :justify-content 'center
                  :margin-bottom 120}}
    [:div.container
     [:div.row
      [:div.col-lg-12
       [:img {:src "/img/thesis-overview.svg"
              :style {:width "100%"
                      :margin "120px 0"}}]]]]]])

(defn thesis-section []
  [:div
   #_[:div {:style {:width "100%"
                    :height 400
                    :background-image "url('/img/hawaii-city-page-header-bg.jpg')"
                    :background-position "50% 50%"
                    :background-size 'cover
                    :display 'flex
                    :align-items 'center
                    :justify-content 'center
                    }}
      [:div.container
       [:div.row
        [:div.col-lg-8.offset-lg-2
       
         [:div
          {:style {:color 'white
                   :text-align 'center}}
          [:h3
           {:style {:font-size 30
                    :margin-bottom 20}}
           "Never let the future disturb you. You will meet it, if you have to, with the same weapons of reason which today arm you against the present."]
          [:p "Marcus Aurelius"]]]]]]
   [:div
    {:style {:margin "100px 0"}}
    [:div.container
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div
        {:style {:text-align 'center}}
        [:img {:src "/img/surfboards.svg"
               :style {:display 'block
                       :margin "0 auto 30px auto"}}]
        [:h3
         {:style {:font-size 60
                  :margin-bottom 60}}
         "The third wave of computation"]
        [:div.row
         [:div.col-lg-8.offset-lg-2
          [:h4
           {:style {:font-size 30
                    :margin-bottom 60}}
           "From our desks, to our persons, to the fabric of the physical world"]]]]]]
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div.row
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We believe now is the time to begin investing in ways to catch the next big wave of computing."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Desktop computers changed the way we thought and expressed ourselves, industries were created, it’s hard to consider that finance didn’t really exist until the introduction of spreadsheets. The internet that connected those personal computers, fundamentally re-wrote organizations, services and communities."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Mobile computing brought computation further into the real world, giving computers eyes and senses. This changed our world in ways that were totally different from the desktop, transforming how we navigated and saw the physical world, how we communicated and our very culture."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "From our ideas to our persons to the very physical world, we believe the third wave of computing will bring computation to be fully integrated into the physical world"]]
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "When a powerful design insight meets a novel and increasingly available technology do the forces of a new wave of computation form."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "When the mouse and cursor was introduced to the computer experiments at Xerox Parc it led to the creation of every metaphor that we use today in computing. A direct tool of expressing one’s agency transformed the command line that only experts at large institutions could utilize into something anyone could."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Now we are seeing new advancements in computational architecture that are allowing individuals to actuate their intent in physical space. Deep learning systems are creating new powerful interfaces in language and vision that no longer require you to even have technology on your person. These systems are transforming industries, and changing the way we understand the natural environment."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We are at the very beginning of something that will be bigger than the two waves of the past."]]]]]]]])

(defn thesis-2-section []
  [:div
   [:div {:style {:width "100%"
                  :height 400
                  :background-image "url('/img/hawaii-city-page-header-bg.jpg')"
                  :background-position "50% 50%"
                  :background-size 'cover
                  :display 'flex
                  :align-items 'center
                  :justify-content 'center
                  }}
    [:div.container
     [:div.row
      [:div.col-lg-8.offset-lg-2
       
       [:div
        {:style {:color 'white
                 :text-align 'center}}
        [:h3
         {:style {:font-size 30
                  :margin-bottom 20}}
         "In nature, nothing is perfect and everything is perfect. Trees can be contorted, bent in weird ways, and they’re still beautiful."]
        [:p "Alice Walker"]]]]]]
   [:div
    {:style {:margin "100px 0"}}
    [:div.container
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div
        {:style {:text-align 'center}}
        [:img {:src "/img/surfboards.svg"
               :style {:display 'block
                       :margin "0 auto 30px auto"}}]
        
        [:div.row
         [:div.col-lg-8.offset-lg-2
          [:h3
           {:style {:font-size 60
                    :margin-bottom 60}}
           "Balance with the natural world"]
          [:h4
           {:style {:font-size 30
                    :margin-bottom 60}}
           "Riding waves, not fighting them"]]]]]]
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div.row
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We think the great technology companies of the next generation will come from the deep existential problem spaces that we are coming to terms with now. From the relationship our cities have with the natural environment, to our threatened sources of sustenance, to the intractable social in-equity in our societies and the very information systems we rely on to form our view of the world."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Ironically the single greatest threat to cities being under-water or destroyed by increasing natural disasters is cities themselves; constructing and operating the buildings we live and work in contribute to 39% of global emissions. However at the same time we are now seeing companies investing in computational architecture that embed computation into the structural make up of a building and change the economic equation under which they operate."]]
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "In food we are suffering from simultaneous epidemics of obesity and starvation not only in distribution but the quality of the food itself, the wheat that we have been industrially farming is returning 50% lower protien 100 years ago. At the same time we are seeing vision systems transform farms from the field and in aquaculture a deepening understanding of complex life-cycles."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "The big problems left to be solved today are deeply complex unable to be solved with our existing mechanical, electrical and traditional software tools alone. At the same time they also represent the biggest opportunity for long term economic return, regenerative eco-systems, and inclusive societies."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We think that the third wave computing is not only possible now, but that it is necessary for our well being and survival. "]]]]]]]])

(defn farmy-project []
  [:div
   [:div.container
    [:div.row
     [:div.col-lg-12
      [:video
       {:width "100%"
        :autoPlay "autoPlay"
        :autoplay "autoplay"
        :loop "loop"
        :muted "muted"}
       [:source {:src "/vid/windpower.mp4" :type "video/mp4" }]]]]
    [:div.row
     [:div.col-lg-4
      [:div
       {:style {:margin "30px 0 100px 0"}}
       [:h3 {:style {:margin-bottom 20
                     :font-size 30}}
        "The Farmy Project"]
       [:p
        {:style {:font-size 18
                 :line-height 1.6}}
        "We’re putting these ideas into practice by building highly desirable communities that also integrate computational agriculture and architecture together."]]]]]])

(defn new-generation-of-founders-section []
  [:div
   [:div {:style {:width "100%"
                  :height 400
                  :background-image "url('/img/hawaii-city-page-header-bg.jpg')"
                  :background-position "50% 50%"
                  :background-size 'cover
                  :display 'flex
                  :align-items 'center
                  :justify-content 'center
                  }}
    [:div.container
     [:div.row
      [:div.col-lg-8.offset-lg-2
       
       [:div
        {:style {:color 'white
                 :text-align 'center}}
        [:h3
         {:style {:font-size 30
                  :margin-bottom 20}}
         "Many of us take better care of our automobiles than we do of our own bodies ... yet the auto has replaceable parts"]
        [:p "B.J. Palmer"]]]]]]
   [:div
    {:style {:margin "100px 0"}}
    [:div.container
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div
        {:style {:text-align 'center}}
        [:img {:src "/img/vw-bus-icon.svg"
               :style {:display 'block
                       :margin "0 auto 30px auto"}}]
        
        [:div.row
         [:div.col-lg-8.offset-lg-2
          [:h3
           {:style {:font-size 50
                    :margin-bottom 30}}
           "A new generation of founders"]
          [:h4
           {:style {:font-size 30
                    :margin-bottom 60}}
           "Sustained disruptive change"]]]]]]
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div.row
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Surf Club is new infrastructure, community and brand for a new generation of founders organized around the love for and culture of surfing."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "Over 300B+ in value has been created by Y-Combinator by making start-ups less hard, and a large part of that has been in building a strong community to support founders through the difficult journey of start-ups."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We are offering founders not only direct deep technical & operational expertise but with a balanced understanding of physio-intellectual well being."]]
        [:div.col-lg-6
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "We think there’s an opportunity here to build a high value brand for a new wave of millenial and gen z founders."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "90% of Gen Z believes that companies must act to affect social and environmental impact."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "67% of millenials invest for societal and environmental impact now and is only growing."]
         [:p {:style {:font-size 22
                      :margin-bottom 20}}
          "From the problems that we are directly addressing, to the community and culture we are building, we are finding that founders are responding well to Surf Club being a long term partner in their endaevor."]]]]]]]])

(defn fund-infra-section []
  [:div
   {:style {:margin-bottom 200}}
   [:div {:style {:width "100%"
                  :height 700
                  :background-image "url('/img/infra-header-bg.jpg')"
                  :background-position "50% 50%"
                  :background-size 'cover
                  :display 'flex
                  :align-items 'center
                  :justify-content 'center
                  }}]
   [:div
    {:style {:margin "-50px 0 100px 0"}}
    [:div.container
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div
        {:style {:text-align 'center}}
        [:img {:src "/img/surf_club_logo.svg"
               :style {:display 'block
                       :margin "0px auto 30px auto"}}]
        [:h2
         {:style {:font-size 60
                  :margin-bottom 60
                  :color "#25504D"}}
         "Fund Infra"]]]]
     [:div.row
      [:div.col-lg-10.offset-lg-1
       [:div.row
        [:div.col-lg-12
         [:h3
          {:style {:font-size 30
                   :margin "0 0 8px 0"}}
          "The Farmy Project"]
         [para {:style {:margin-bottom 20}}
          "Through the farmy project Surf Club is actually building the physical communities of the future with many of the companies we invest in. These are demonstrations of the power of physical computation working in tandem with nature and the communities around them. Learn More."]]]
       [:div {:style {:height 60}}]
       [:div.row
        [:div.col-lg-6
         [:img {:src "/img/surf-hangout.jpg"}]]
        [:div.col-lg-6
         [:h3
          {:style {:font-size 30
                   :margin "0 0 8px 0"}}
          "Board Meetings"]
         [para {:style {:margin-bottom 20}}
          "Regularly take founders and experienced LPs to connect, chat and surf out here in Hawaii."]]]

       [:div {:style {:height 60}}]
       [:div.row
        [:div.col-lg-6
         [:h3
          {:style {:font-size 30
                   :margin "0 0 8px 0"}}
          "Founder Swellness"]
         [para {:style {:margin-bottom 20}}
          "Once a year we host a large founder retreat in Oahu, Hawaii on our ranch to connect with each other and the local community.  "]]
        [:div.col-lg-6
         [:img {:src "/img/ranch.jpg"}]]]
       [:div {:style {:height 60}}]
       [:div.row
        [:div.col-lg-6
         [:img {:src "/img/vw-bus-images.jpg"}]]
        [:div.col-lg-6
         [:h3
          {:style {:font-size 30
                   :margin "0 0 8px 0"}}
          "Surf Club"]
         [para {:style {:margin-bottom 20}}
          "A community of founders and individuals dedicated to changing our relationship with the environment and ourselves."]]]]]]]])

(defn portfolio-strategy-section []
  (let [subhead-style {:color "#187A74"
                       :margin-bottom 12
                       :font-size 30}
        para-style {:font-size 24
                    :line-height 1.6
                    :margin-bottom 60}]
    [:div
     {:style {:margin "100px 0"}}
     [:div.container
      [:div.row
       [:div.col-lg-8.offset-lg-2
        [:div.row
         [:div.col-lg-12
          [:img {:src "/img/surf_club_logo.svg"
                 :style {:display 'block
                         :margin "0 auto 60px auto"}}]]]
        [:div.row
         [:div.col-lg-12
          [:div
           {:style {:text-align 'center}}
           [:h2
            {:style {:color "#25504D"
                     :font-size 50
                     :margin-bottom 60}}
            "Portfolio Strategy"]]]
         [:div.col-lg-6
          [:div
           [:h3
            {:style subhead-style}
            "Early Stage Venture Capital"]
           [:p {:style para-style} "Supporting seed stage companies with 100k+ Checks"]]]
         [:div.col-lg-6
          [:div
           [:h3
            {:style subhead-style}
            "Cross Stage Thesis Capital"]
           [:p {:style para-style} "Follow-on and support of founders within our network"]]]]]]

      [:div {:style {:height 60}}]
      [:div.row
       [:div.col-lg-8.offset-lg-2
        [:div.row
         [:div.col-lg-12
          [:div
           {:style {:text-align 'center}}
           [:h2
            {:style {:color "#25504D"
                     :font-size 50
                     :margin-bottom 60}}
            "Fund Details"]]]
         [:div.col-lg-6
          [:div
           [:h3
            {:style subhead-style}
            "Early Stage Venture Capital Fund"]
           [:p {:style para-style}
            "Based in Hawaii and the West Coast"]]]
         [:div.col-lg-6
          [:div
           [:h3
            {:style subhead-style}
            "Investment Strategy"]
           [:p {:style para-style}
            "$100K Checks into seed and pre-seed stage companies at 10-15 deals per year."]]]
         [:div.col-lg-12
          [:div
           [:h3
            {:style subhead-style}
            "Focusing on solving existential problems with physical computing & machine intelligence"]
           [:p {:style para-style}
            "Robotics, Deep Learning, Machine Vision, Ag-Tech, Architecture, Synthetic Bio, PhysioSocial Health"]]]
         [:div.col-lg-12
          [:div
           [:h3
            {:style subhead-style}
            "Select LPs"]
           [:p {:style para-style}
            "Robotics, Deep Learning, Machine Vision, Ag-Tech, Architecture, Synthetic Bio"]]]]]]
      [:div {:style {:height 60}}]]]))

(defn fund-summary-section []
  (let [subhead-style {:color "#187A74"
                       :margin-bottom 12
                       :font-size 30}
        para-style {:font-size 24
                    :line-height 1.6
                    :margin-bottom 60}]
    [:div
     {:style {:margin "100px 0"}}
     [:div.container
      [:div.row
       [:div.col-lg-8.offset-lg-2
        [:div.row
         [:div.col-lg-12
          [:img {:src "/img/surf_club_logo.svg"
                 :style {:display 'block
                         :margin "0 auto 60px auto"}}]]]
        [:div.row
         [:div.col-lg-12
          [:div
           {:style {:text-align 'center}}
           [:h2
            {:style {:color "#25504D"
                     :font-size 50
                     :margin-bottom 60}}
            "Fund Summary & Closing"]]]
         [:div.col-lg-12
          [:div
           [:h3
            {:style subhead-style}
            "Fund Type"]
           [:p {:style para-style}
            "Standard Delaware US LLC"]]]
         [:div.col-lg-6
          [:div
           [:h3
            {:style subhead-style}
            "Fund Size & Location"]
           [:p {:style para-style} "1M out of 3.5M committed, based in Honolulu, San Francisco, Tokyo"]]]
         [:div.col-lg-6
          [:div
           [:h3
            {:style subhead-style}
            "Initial Investment Period"]
           [:p {:style para-style}
            "3 years"]]]]

        [:div.row[:div.col-lg-12
                  [:div
                   [:h3
                    {:style subhead-style}
                    "Minimum LP Comittment"]
                   [:p {:style para-style}
                    "$100,000 for individuals, $250,000 for institutions"]]]
         [:div.col-lg-6
          [:div
           [:h3
            {:style subhead-style}
            "Capital Call Schedule"]
           [:p {:style para-style}
            "Approx. 30% yearly: Year 1-2, 20% Year 3, as needed year 4-7 for follow-ons."]]]]]]]]))


(defn dawn-patrol-fund []
  {:render
   (fn []
     [:div {:style {:width "100%"
                    :height "100%"
                    :style {:font-family "'Noto Serif', serif"}}}
      [surf-club-hero-section]
      [dp-pitch-embed]
      [fund-intro-section]
      [fund-highlights-section]
      [impetus-section]
      [thesis-overview-section]
      [thesis-section]
      [thesis-2-section]
      #_[farmy-project]
      [new-generation-of-founders-section]
      [lp-our-team-section]
      [fund-infra-section]
      [portfolio-strategy-section]
      [fund-summary-section]
      [:div {:style {:height 400}}]])})

