(ns clj-gui.db.model
  (:use [korma db core])
  (:use [clj-gui.db.core]))

(defdb db (sqlite3 {:db (:name db)}))

(defentity phone)
(defentity contact
           (has-many phone))

(defn hello [] "hello world")
;todo create startup migration :'(
