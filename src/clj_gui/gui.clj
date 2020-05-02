(ns clj-gui.gui
  (:use [seesaw core table])
  (:require [clj-gui.util :as util]))

;todo define display protocol, that convert to string and back

(defn- gen-row [id]
  {:id    id
   :name  (str "name-" id)
   :phone (util/rand-numstr 6)})

(defn gen-data [n]
  (map gen-row (range n)))

(defn data-table [init-rows]
  (scrollable (table :id :data-table
                     :model [:columns [{:key :name :text "Абонент"}
                                       {:key :phone :text "Телефон"}]
                             :rows init-rows])))

(defn state-row [bind-atom]
  (let [row (label :id :sel :text @bind-atom :preferred-size [0 :by 14])]
    (add-watch bind-atom :state-bind #(config! row :text %4))
    row))


(defn main-frame
  "Create the main frame on application with title"
  [title content]
  (frame :title title :width 500 :height 400
         :content content
         :on-close :exit))
