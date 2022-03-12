(ns calculator.core
  (:gen-class))

(defn c-sort [coll]
  "Recursive quick sort implementation"
  [coll]
  (vec
   (if (<= (count coll) 1)
     coll
     (let [pivot  (first coll)
           others (rest coll)]
       (concat
        (c-sort (filter #(>= pivot %) others))
        [pivot]
        (c-sort (filter #(< pivot %) others)))))))

(defn c-mean [coll]
  (float (/ (reduce + coll) (count coll))))

(defn c-mode [coll]
  (key (apply max-key val (frequencies coll))))

(defn c-range [coll]
  (let [sorted-coll (c-sort coll)]
    (- (last sorted-coll) (first sorted-coll))))

(defn c-median [coll]
  (let [sorted-coll (c-sort coll)
        coll-size   (count coll)
        middle      (quot coll-size 2)]
    (if (odd? coll-size)
      (nth sorted-coll middle)
      (c-mean [(nth sorted-coll (dec middle)) (nth sorted-coll middle)]))))
