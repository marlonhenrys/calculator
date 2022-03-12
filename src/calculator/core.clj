(ns calculator.core
  (:gen-class))

(defn c-sort
  "Ordenação por QuickSort recursivo"
  [coll]
  (if (<= (count coll) 1)
    coll
    (let [pivot  (first coll)
          others (rest coll)]
      (concat
       (c-sort (filter #(>= pivot %) others))
       [pivot]
       (c-sort (filter #(< pivot %) others))))))

(defn c-mean
  "Cálculo de média simples"
  [coll]
  (let [result (/ (reduce + coll) (count coll))]
    (if (ratio? result)
      (float result)
      result)))

(defn c-mode
  "Cálculo de moda"
  [coll]
  (let [occurrences (frequencies coll)
        max-occurrences (apply max (vals occurrences))]
    (->> occurrences
         (filter #(= max-occurrences (val %)))
         (map key)
         c-sort)))

(defn c-range
  "Cálculo de amplitude"
  [coll]
  (let [sorted-coll (c-sort coll)]
    (- (last sorted-coll) (first sorted-coll))))

(defn c-median
  "Cálculo de mediana"
  [coll]
  (let [sorted-coll (c-sort coll)
        coll-size   (count coll)
        middle      (quot coll-size 2)]
    (if (odd? coll-size)
      (nth sorted-coll middle)
      (c-mean [(nth sorted-coll (dec middle)) (nth sorted-coll middle)]))))
