(ns clj-gui.db.model
  (:use [korma db core])
  (:use [clj-gui.db.core]))

(defdb sqlite (sqlite3 {:db (:name db)}))

(declare phone)
(defentity contact
           (pk :id)
           (entity-fields :name)
           (has-many phone))

(defentity phone
           (pk :id)
           (entity-fields :phone)
           (belongs-to contact))


;todo how about unique check?
;todo check contact with contact-id exist
(defn create-phone! [number contact-id]
  {:pre [(not-blank? number) (id? contact-id)]}
  (insert phone (values {:phone number :contact_id contact-id})))


;todo how about not-found check? (return 0)
(defn remove-phone! [phone-id]
  {:pre [(id? phone-id)]
   :post [(only-one? %)]}
  (delete phone (where {:id phone-id})))


(defn exist-phone? [number]
  {:pre [(not-blank? number)]}
  (select phone (where {:phone number})))


(defn create-contact!
  ([name]
   {:pre [(not-blank? name)]}
   (insert contact (values {:name name}))))


(defn edit-contact-name! [contact-id new-name]
  {:pre [(id? contact-id) (not-blank? new-name)]}
  (update contact (set-fields {:name new-name}) (where {:id contact-id})))


(defn remove-contact! [contact-id]
  {:pre [(id? contact-id)]}
  (delete contact (where {:id contact-id})))


(defn load-contacts [offset limit]
  {:pre [(integer? offset) (integer? limit)]}
  (select contact
          (with phone)
          (fields :id)
          (korma.core/limit limit)
          (korma.core/offset offset)
          (order :name)))

;(defn find-contact-by-phone [phone-pattern])
