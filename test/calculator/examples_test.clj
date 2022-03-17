(ns calculator.examples-test
  (:require [clojure.test :refer :all]))

(defn sum [a b] (+ a b))

(defn sum-plus-two [a b]
  (+ 2 (sum a b)))

(deftest other-test
  (testing "Outras possíveis verificações"
    (let [value  (mod 10 6)
          person {:name "Pessoa"
                  :age 48
                  :children [1001 1087 1134]}]

      (is (not= 10 (* 5 5)))

      (is (true? (> (+ 5 1) 5)))

      (is (false? (= 1 10)))

      (is (odd? (/ 9 3)))

      (is (not (integer? (/ 3 2))))

      (is (true? (and (pos-int? value)
                      (<= value 10))))

      (is (or (and (contains? person :age)
                   (> (:age person) 40))
              (< (-> person :children count) 5)))

      (is (= 10 (sum-plus-two 5 3)))

      (is (= 33 (with-redefs [sum (constantly 31)]
                  (sum-plus-two 5 3))))))

  (testing "Testes múltiplos"
    (are [?expected ?operation]
         (= ?expected ?operation)

      ; soma
      2   (+ 1 1)

      ; multiplicação
      4   (* 2 2)

      ; divisão
      1/5 (/ 1 5)

      ; exponenciação
      8.0 (Math/pow 2 3))))
