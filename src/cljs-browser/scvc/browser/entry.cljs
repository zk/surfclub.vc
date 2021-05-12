(ns scvc.browser.entry
  (:require [scvc.routes]
            [rx.browser :as browser]
            [reitit.core :as rei]
            [scvc.browser.pages]))

(defn dispatch-route [routes handlers & [opts]]
  (let [uri (or (:uri opts)
                (browser/location-pathname))
        match (rei/match-by-path
                (rei/router routes)
                uri)]
    (if match
      (let [{:keys [data path-params]} match
            {:keys [name]} data
            handler (get handlers name)]
        (when handler
          (browser/<set-root!
            [handler (merge
                       path-params
                       (:default-opts opts))])))
      (when-let [f (:not-found opts)]
        (f)))))

(defn handlers []
  {:index scvc.browser.pages/index
   :dawn-patrol-fund scvc.browser.pages/dawn-patrol-fund})

(defn init []
  (dispatch-route
    (scvc.routes/routes)
    (handlers)
    {:not-found (fn []
                  (browser/<show-component!
                    [:div "404"]))}))

(init)


