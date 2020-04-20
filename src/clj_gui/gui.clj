(ns clj-gui.gui
  (:use [seesaw core table])
  (:require [clj-gui.util :as util]))

(defn gen-row [id]
  {:id id
   :name (str "name-" id)
   :town (util/rand-str 6)
   :interest "programming"})

(defn gen-data [n]
  (map gen-row (range n)))

(defn- make-table []
  (table :id :table
         :model [
                 :columns [{:key :name :text "Name"}
                           {:key :town :text "Town"}
                           {:key :interest :text "Interest"}]
                 :rows (gen-data 1000)]))

(defn main-frame
  "Create the main frame on application with title"
  [title]
  (frame :title title :width 500 :height 400
         :content (border-panel
                    :center (scrollable (make-table))
                    :south (label :id :sel :text "Selection: "))))
