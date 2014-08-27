(ns cursive.core-test
  (:require [clj-webdriver.taxi :refer :all]
            [clj-webdriver.driver :refer :all]
            [clojure.test :refer :all])

(fact "tits"
        (set-driver!  {:browser :chrome})
        (to "https://github.com")
        (click "a[href*='login']")
        (input-text "#password" "your-password")
        (submit "#password")
        (text ".flash") => "Incorrect username and password")
