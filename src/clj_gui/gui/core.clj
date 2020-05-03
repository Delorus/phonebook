(ns clj-gui.gui.core
  (:require [clj-gui.util :as util]
            [clojure.string :as str]))

;todo define display protocol, that convert to string and back

(defn format-phone [phone]
  (:phone phone))

(defn format-phones
  ([coll]
   (->> coll (map format-phone) (str/join ", ")))
  ([delim coll]
   (->> coll (map format-phone) (str/join delim))))

(defn format-contact [contact]
  (update contact :phone format-phones))

(defn format-contacts [coll]
  (map format-contact coll))
