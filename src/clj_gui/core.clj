(ns clj-gui.core
  (:use [seesaw core table]
        [clj-gui.db.core])
  (:require [clj-gui.gui.components :as comp]
            [clj-gui.gui.core :as gui]
            [clj-gui.db.migration :as migration]
            [clj-gui.util :as util]
            [clj-gui.db.model :as model]
            [seesaw.border :as border]))

(def log (atom ""))

(defn- prepare-db! []
  (when (not (exist-db?))
    (migration/init-db!))
  (migration/update-db!))

(defn- enable-antialiasing []
  (System/setProperty "awt.useSystemAAFontSettings" "on")
  (System/setProperty "swing.aatext" "true"))

(defn- show-view! []
  (show!
    (comp/main-frame
      "Viewer"
      (border-panel
        :center (border-panel
                  :center (comp/data-table
                            (gui/format-contacts (model/load-contacts 0 100)))
                  :south (comp/tool-panel))
        :south (comp/state-row log)))))

(defn -main []
  (prepare-db!)
  (enable-antialiasing)
  (show-view!))
