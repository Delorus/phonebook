(ns clj-gui.db.migration
  (:use [clj-gui.db.core])
  (:require [migratus.core :as migration]))

(def config {:store         :database
             :migration-dir "db/migration/"
             :init-in-transaction? false
             :db            {:subprotocol (:type db)
                             :subname     (:name db)}})

(defn init-db! []
  (migration/init config))

(defn update-db! []
  (migration/migrate config))
