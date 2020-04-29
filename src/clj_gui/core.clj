(ns clj-gui.core
  (:use [seesaw core table]
        [clj-gui.db.core])
  (:require [clj-gui.gui :as gui]
            [clj-gui.db.migration :as migration]
            [clojure.java.io :as io]))

(defn -main []
  (when (not (.exists (io/file (:name db))))
    (migration/init-db!))
  (migration/update-db!)
  (comment (let [f (show! (gui/main-frame "Viewer"))
                 tbl (select f [:#table])]
             ; Listen for selection changes and show them in the label
             (listen tbl :selection
                     (fn [e]
                       (do
                         (println e)
                         (config! (select f [:#sel])
                                  :text (str "Selection: "
                                             ; (selection tbl) returns the selected row index
                                             ; (value-at tbl row) returns the record at row
                                             (value-at tbl (selection tbl)))))))
             f)))
