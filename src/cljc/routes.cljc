(ns routes
  (:require [scvc.templates :as tpl]))

(defn routes [& [opts]]
  [["/" {:name :browser.index/view
         :template tpl/main}]
   ["/foo/:bar" :foo-bar]
   ["/foo/:bar/baz" :foo-bar-baz]])
