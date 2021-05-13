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
        #_[:div
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
           #_[:div
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
                 {:label "Companies"}]
                [navbar-btn
                 {:label "Team"}]
                [navbar-btn
                 {:label "Mission"}]
                #_[navbar-btn
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

(defn impetus-section []
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
         "Peace cannot be kept by force; it can only be achieved by understanding."]
        [:p "Albert Einstien, Ralph Waldo Emerson"]]]]]]
   [:div.container
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div
       {:style {:text-align 'center
                :margin-top 100}}
       [:img {:src "/img/vw-bus-icon.svg"
              :style {:display 'block
                      :margin "0 auto 30px auto"}}]
       [:h3
        {:style {:font-size 70
                 :margin-bottom 60}}
        "Economic Miracles"]]]]
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div.row
       [:div.col-lg-6
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "It was a combination of suicidal defiance of the Nazis and Hitler by Ludwig Erhard and the lesson the Allies learned to not saddle the loser with the debt of war, fostered the environment in which the Volkswagen Auto Company released the Type 2 VW Bus."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "This industrial product would go on from hippies to civil rights activists to surfers to be a renewing and enduring symbol of peace, cultural revolution and freedom."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "It was a literal, economic and metaphorical vehicle for post-war world we live in, a sign of hope that we can emerge from strife but also a symbol of how precariously easy it is to forget those lessons."]]
       [:div.col-lg-6
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "The world has improved in many ways since that time, but new consequences of being in violent competition with our natural environment, seemingly intractable social inequity problems, and the very sources of our physical and mental well being are in a precarious position once again."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Our cities are threatened with ecological disasters, our food sources have declined in nutrion by up to 50%, and we are even struggling to maintain well informed societies."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "It’s here that we believe there will be new personal economic vehicles of change that will carry and alter the zero sum games that we are facing. Like the VW Bus, the personal computer and many other transformational technologies that bring power and freedom back to everyone."]]]]]]])

(defn venn-diagram-section []
  [:div {:style {:padding "150px 30px"}}
   [:img {:src "/img/venn-diagram.png"
          :style {:display 'block
                  :margin "0 auto"}}]])

(defn thesis-section []
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
         "Never let the future disturb you. You will meet it, if you have to, with the same weapons of reason which today arm you against the present."]
        [:p "Marcus Aurelius"]]]]]]
   [:div.container
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div
       {:style {:text-align 'center
                :margin-top 100}}
       [:img {:src "/img/surfboards.svg"
              :style {:display 'block
                      :margin "0 auto 30px auto"}}]
       [:h3
        {:style {:font-size 70
                 :margin-bottom 60}}
        "The third wave of computation"]
       [:div.row
        [:div.col-lg-8.offset-lg-2
         [:h4
          {:style {:font-size 30
                   :margin-bottom 60}}
          "From simulations, to our persons, to now the physical world."]]]]]]
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div.row
       [:div.col-lg-6
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "We believe now is the start of the third wave of computing, in which computation is a part of the physical environment even more so than we can perceive today."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "The dynamics of technology are not to dissimiliar from the physics of waves, the accumulation of forces of the personal computing revolution are still rewriting how we think and express ourselves today, on top of which the internet is continuing to fundamentally re-write organizations, services and information systems, the mobile revolution gave computation eyes and senses in the world, and for better or for worse this is only the beginning."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Each accumulative function has reduced costs and rapidly advanced the underlying materials that lead to the next wave, staying ahead of commodization is a constant concern for all operators, and one can only truly stay ahead by deeply investing in the technological future."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "These forces that accumulate into a wave of computational revolution are not easy to read. However there are things that are required for such a revolution to emerge."]]
       [:div.col-lg-6
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Historically we are beset by examples where incumbent mindset and power mistake new transformational technology as a toy; infamously the Xerox executives handed over the most valuable technological baby of our century over to Apple and Microsoft. "]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "We are particularly vulnerable to this because of the survivorship/success bias, leadership at Xerox culture was molded to deliver more copy machines, a device that ostensibly made that irelevant would be difficult to bring to conscious consideration."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "That being said that is why we feel uniquely capable of finding that founder that can bring an Apple 2 to market. Each partner has deep technical expertise in the areas we think are most likely to accumulate into a new wave of computation."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "With traditional processes are being supplanted by self constructing machines, vehicles are beginning to drive themsleves, common grocery stores are able to operate without human labor. "]]]]]]])

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
   [:div.container
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div
       {:style {:text-align 'center
                :margin-top 100}}
       [:img {:src "/img/surfboards.svg"
              :style {:display 'block
                      :margin "0 auto 30px auto"}}]
       
       [:div.row
        [:div.col-lg-8.offset-lg-2
         [:h3
          {:style {:font-size 70
                   :margin-bottom 60}}
          "Balance with the natural world"]
         [:h4
          {:style {:font-size 30
                   :margin-bottom 60}}
          "Don’t fight the wave, ride it"]]]]]]
    [:div.row
     [:div.col-lg-10.offset-lg-1
      [:div.row
       [:div.col-lg-6
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "In the simple case of solar power, unceasing technological progress of silicon has fast made it economical suicide to build anything but."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Today through a series of tragedy of the commons we strip the very land and pollute the very oceans that we derive our sustenance from. "]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Wheat the original impetus for organized society has declined in protein value by 50% over the past 100 years, not to mention the other necessary nutrients across all industrially farmed products."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Those same agricultural lands and our cities are polluting and laying waste to the oceans from which we supplement our increasingly poor diets with and utilize for our physical well being."]]
       [:div.col-lg-6
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Even our cities our failing us as just buildings contribute to 39% of global emissions, and they’re not even that nice with slums increasing by 24%, homelessness continues to be a growing epidemic. Our current form of civic engineering has failed to provide the basics of shelter to all citizens, a basic technology invented right after fire."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "In this context we seek to invest in transformational endeavors that harness natural forces to create enduring alluvial(“regenerative”) relationships with communities and nature."]
        [:p {:style {:font-size 22
                     :margin-bottom 20}}
         "Abstract eco-systems are built on real eco-systems of the environment and our communities, the next trillion dollar companies will be built with a better understanding of how to harness and co-exist with natural systems."]]]]]]])

(defn dawn-patrol-fund []
  {:render
   (fn []
     [:div {:style {:width "100%"
                    :height "100%"
                    :style {:font-family "'Noto Serif', serif"}}}
      [surf-club-hero-section]
      [fund-intro-section]
      [fund-highlights-section]
      [impetus-section]
      [venn-diagram-section]
      [thesis-section]
      [thesis-2-section]])})
