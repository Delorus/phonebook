(ns clj-gui.gui.components
  (:use [seesaw core table]))

(defn state-row [bind-atom]
  (let [row (label :id :sel :text @bind-atom :preferred-size [0 :by 14])]
    (add-watch bind-atom :state-bind #(config! row :text %4))
    row))


(defn data-table [init-rows]
  (scrollable (table :id :data-table
                     :model [:columns [{:key :name :text "Абонент"}
                                       {:key :phone :text "Телефон"}]
                             :rows init-rows])))


(defn main-frame
  "Create the main frame on application with title"
  [title content]
  (frame :title title :width 500 :height 400
         :content content
         :on-close :exit))
