(defproject clj-gui "0.1.0-SNAPSHOT"
  :description "Example of Clojure GUI application"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [seesaw "1.5.0"]
                 [korma "0.4.3"]
                 [org.xerial/sqlite-jdbc "3.30.1"]
                 [migratus "1.2.8"]]
  :main ^:skip-aot clj-gui.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
