(ns clj-gui.core
  (:use [seesaw core table]
        [clj-gui.db.core])
  (:require [clj-gui.gui.components :as comp]
            [clj-gui.gui.core :as gui]
            [clj-gui.db.migration :as migration]
            [clj-gui.util :as util]
            [clj-gui.db.model :as model]))

(defn- prepare-db! []
  (when (not (exist-db?))
    (migration/init-db!))
  (migration/update-db!))

(def log (atom ""))

(defn -main []
  (prepare-db!)
  (show! (comp/main-frame "Viewer"
                          (border-panel
                            :center (comp/data-table
                                      (gui/format-contacts (model/load-contacts 0 100)))
                            :south (comp/state-row log)))))


