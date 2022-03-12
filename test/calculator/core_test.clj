(ns calculator.core-test
  (:require [clojure.test :refer :all]
            [calculator.core :refer :all]))

(def empty-coll [])
(def one-element-coll [])
(def repetead-element-coll [])
(def asc-coll [])
(def desc-coll [])
(def unsorted-coll [])

(deftest c-sort-test
  (testing "FIXME, I fail."
    (is (= 0 (c-sort empty-coll)))))

(deftest c-mean-test
  (testing "FIXME, I fail."
    (is (= 2.5 (c-mean empty-coll)))))

(deftest c-mode-test
  (testing "FIXME, I fail."
    (is (= 0 (c-mode empty-coll)))))

(deftest c-range-test
  (testing "FIXME, I fail."
    (is (= 0 (c-range empty-coll)))))

(deftest c-median-test
  (testing "FIXME, I fail."
    (is (= 0 (c-median empty-coll)))))
