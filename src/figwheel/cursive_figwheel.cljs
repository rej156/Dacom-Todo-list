(ns cursive-figwheel
    (:require  [figwheel.client :as fw :include-macros true]))

(fw/watch-and-reload)
