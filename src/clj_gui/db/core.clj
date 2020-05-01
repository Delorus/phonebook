(ns clj-gui.db.core
  (:require [clojure.string :as str]))

(def ^:const db {:name "phones.db"
                 :type "sqlite"})

(defn id? [id] (integer? id))

(defn only-one? [count] (= 1 count))

(defn not-blank? [str-field] (not (str/blank? str-field)))
