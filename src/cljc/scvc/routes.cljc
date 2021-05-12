(ns scvc.routes
  (:require [scvc.templates :as tpl]))

(defn routes [& [opts]]
  [["/" :index]
   ["/dawn-patrol-fund" :dawn-patrol-fund]])
