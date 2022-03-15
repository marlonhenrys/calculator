(ns calculator.core-test
  (:require [clojure.test :refer :all]
            [calculator.core :refer :all]))

(def empty-coll [])
(def one-element-coll [10])
(def repeated-coll [20 20 20 20 20 20])
(def asc-coll [1 1.5 3 4 5.5 6])
(def desc-coll [5 4 3 2 -1])
(def unsorted-coll [6 3 4 2 5 1 7])
(def repeated-elements-coll [1 3 4 5 3 2 4 4 3])
(def coll-with-string [-1 4 -2.5 -0.5 3.5 1.5 "5"])

(deftest c-sort-test
  (testing "Coleção vazia"
    (is (= [] (c-sort empty-coll))))

  (testing "Coleção com um único elemento"
    (is (= one-element-coll (c-sort one-element-coll))))

  (testing "Coleção com um único elemento repetidas vezes"
    (is (= repeated-coll (c-sort repeated-coll))))

  (testing "Coleção já ordenada de forma crescente"
    (is (= asc-coll (c-sort asc-coll))))

  (testing "Coleção já ordenada de forma decrescente"
    (is (= [-1 2 3 4 5] (c-sort desc-coll))))

  (testing "Coleção não ordenada"
    (is (= [1 2 3 4 5 6 7] (c-sort unsorted-coll))))

  (testing "Coleção não ordenada com elementos repetidos"
    (is (= [1 2 3 3 3 4 4 4 5] (c-sort repeated-elements-coll))))

  (testing "Coleção com tipos variados"
    (is (thrown-with-msg? ClassCastException
                          #"class java.lang.String cannot be cast to class java.lang.Number"
                          (c-sort coll-with-string)))))

(deftest c-mean-test
  (testing "Coleção vazia"
    (is (thrown? Exception (c-mean empty-coll))))

  (testing "Coleção com um único elemento"
    (is (= 10 (c-mean one-element-coll))))

  (testing "Coleção com um único elemento repetidas vezes"
    (is (= 20 (c-mean repeated-coll))))

  (testing "Coleção não ordenada"
    (is (= 4 (c-mean unsorted-coll))))

  (testing "Coleção com tipos variados"
    (is (thrown-with-msg? ClassCastException
                          #"class java.lang.String cannot be cast to class java.lang.Number"
                          (c-mean coll-with-string)))))

(deftest c-mode-test
  (testing "Coleção vazia"
    (is (thrown? Exception (c-mode empty-coll))))

  (testing "Coleção com um único elemento"
    (is (= [10] (c-mode one-element-coll))))

  (testing "Coleção com um único elemento repetidas vezes"
    (is (= [20] (c-mode repeated-coll))))

  (testing "Coleção não ordenada sem elementos repetidos"
    (is (= [1 2 3 4 5 6 7] (c-mode unsorted-coll))))

  (testing "Coleção não ordenada com elementos repetidos"
    (is (= [3 4] (c-mode repeated-elements-coll))))

  (testing "Coleção com tipos variados"
    (is (thrown-with-msg? ClassCastException
                          #"class java.lang.String cannot be cast to class java.lang.Number"
                          (c-mode coll-with-string)))))

(deftest c-range-test
  (testing "Coleção vazia"
    (is (thrown? Exception (c-range empty-coll))))

  (testing "Coleção com um único elemento"
    (is (= 0 (c-range one-element-coll))))

  (testing "Coleção com um único elemento repetidas vezes"
    (is (= 0 (c-range repeated-coll))))

  (testing "Coleção já ordenada de forma crescente"
    (is (= 5 (c-range asc-coll))))

  (testing "Coleção já ordenada de forma decrescente"
    (is (= 6 (c-range desc-coll))))

  (testing "Coleção não ordenada"
    (is (= 6 (c-range unsorted-coll))))

  (testing "Coleção com tipos variados"
    (is (thrown-with-msg? ClassCastException
                          #"class java.lang.String cannot be cast to class java.lang.Number"
                          (c-range coll-with-string)))))

(deftest c-median-test
  (testing "Coleção vazia"
    (is (thrown? Exception (c-median empty-coll))))

  (testing "Coleção com um único elemento"
    (is (= 10 (c-median one-element-coll))))

  (testing "Coleção com um único elemento repetidas vezes"
    (is (= 20 (c-median repeated-coll))))

  (testing "Coleção já ordenada de forma crescente"
    (is (= 3.5 (c-median asc-coll))))

  (testing "Coleção já ordenada de forma decrescente"
    (is (= 3 (c-median desc-coll))))

  (testing "Coleção não ordenada"
    (is (= 4 (c-median unsorted-coll))))

  (testing "Coleção com tipos variados"
    (is (thrown-with-msg? ClassCastException
                          #"class java.lang.String cannot be cast to class java.lang.Number"
                          (c-median coll-with-string)))))
