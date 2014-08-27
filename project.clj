(defproject cursive "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/core.async "0.1.338.0-5c5012-alpha"]
                 [expectations "2.0.9"]
                 [clj-webdriver "0.6.1"]
                 [om "0.7.1"]
                 [om-sync "0.1.1"]
                 [prismatic/om-tools "0.3.3"]
                 [com.datomic/datomic-free "0.9.4894"]
                 [figwheel "0.1.3-SNAPSHOT"]]
  :jvm-opts  ["-Xmx1G"]
  :plugins [[lein-gorilla "0.3.2" :exclusions [org.clojure/clojure]]
            [lein-cljsbuild "1.0.3"]
            [lein-expectations "0.0.7"]
            [com.cemerick/austin "0.1.4"]
            [lein-figwheel "0.1.3-SNAPSHOT"]
            [lein-bower "0.5.1"]
            [lein-ring "0.8.8"]
            [lein-autoexpect "1.0"]]
  :ring  {:init cursive.server/init-conn
          :handler cursive.server/app}
  :bower-dependencies [[foundation "5.4.0"]]
  :bower  {:scripts  {:postinstall "./node_modules/.bin/wiredep -s resources/public/index.html"}}
  :figwheel {
             :http-server-port "public"
             :port 3449
             :css-dirs ["resources/public/css"]}
  :cljsbuild  {
               :builds  [{:id "dev"
                          :source-paths  ["src/cursive" "src/figwheel" "src/brepl"]
                          :compiler  {
                                      :output-to "resources/public/cursive.js"
                                      :output-dir "resources/public/out"
                                      :optimizations :none
                                      :source-map true}}
                         :db  [:dev  {:main cursive.db}]]})
