(ns clj-gui.core
  (:use [seesaw core table]
        [clj-gui.db.core])
  (:require [clj-gui.gui :as gui]
            [clj-gui.db.migration :as migration]))

(defn- prepare-db! []
  (when (not (exist-db?))
    (migration/init-db!))
  (migration/update-db!))

(def log (atom ""))

(defn -main []
  (prepare-db!)
  (show! (gui/main-frame "Viewer"
                         (border-panel
                           :center (gui/data-table (gui/gen-data 100))
                           :south (gui/state-row log)))))


