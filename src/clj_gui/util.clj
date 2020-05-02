(ns clj-gui.util)

(defn rand-upperstr [len]
  (apply str (take len (repeatedly #(char (+ (rand 26) 65))))))

(defn rand-numstr [len]
  (apply str (take len (repeatedly #(char (+ (rand 9) 48))))))
