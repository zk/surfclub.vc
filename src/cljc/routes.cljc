(ns routes)

(defn routes [& [opts]]
  [["/" :browser.index/view]
   ["/foo/:bar" :foo-bar]
   ["/foo/:bar/baz" :foo-bar-baz]])

