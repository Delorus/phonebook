(ns clj-gui.core
  (:use [seesaw core table])
  (:require [clj-gui.gui :as gui]))

(defn -main []
  (let [f (show! (gui/main-frame "Viewer"))
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
    f))
