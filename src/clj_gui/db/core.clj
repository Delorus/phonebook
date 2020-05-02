(ns clj-gui.db.core
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def ^:const db {:name "phones.db"
                 :type "sqlite"})

(defn exist-db? [] (.exists (io/file (:name db))))

(defn id? [id] (integer? id))

(defn only-one? [count] (= 1 count))

(defn not-blank? [str-field] (not (str/blank? str-field)))
