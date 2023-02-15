(ns hello-world.basics)

;;; for bind values to names, the scope is local

; Single bind
(let [g "Hello!"]
  (println g))
; => Hello!

; multiple bind
(let [h "Hello, "
      t "Clojure!"]
  (println (str h t)))
; => Hello, Clojure!

; simitar to let* 
(let [l "Light"
      d (str l " and " "Darkness.")]
  (println "God dont exists only " d))
; => God dont exists only Light and Darkness

; scope
(let [x 1]
  (let [x 2]
    (println x))
  (println x))
; => 2
; => 1

; binding to symbols
(def small-pi 3.1416)

; function binding
(defn hi 
  "Print a generic or personal Hello."
  ([] (println "Hello!"))
  ([name] (str "Hello, " name)))

(hi)
(hi "myself")

; lambda
(fn [x] (+ x 1) 1)

; if
(if true
  (println "Hello")
  (println "nope"))

;; Multiple output
(if true
  (do
    (println "Hello")
    (println "nope")))

;; if with let binding
(if-let [true? (> 3 1)]
  (println "ok")
  (println "nope"))

;; another form of if-do
(when (> 1 3)
  (println "ok")
  (println "nope"))

(when (> 3 1)
  (println "ok")
  (println "nope"))

; case
(defn hello [name]
  (case name
    "clojure" "ok, Welcome back"
    "simple hello return? :)"))

(hello "clojure")
(hello "me")

; conditional and "otherwise" output
(defn cond-output 
  [name]
  (cond
    (= name "clojure") "Hello!"
    :else "nope") )

(cond-output "clojure")
(cond-output "me")

; format
(format "Hello %s %s" "me" ":)")
(format "my-pi: %.3f" 3.1415)

;conj 
(conj [1 2 3] [4 5 6]) ;conj for vectors
(conj (list 1 2 3) (list 4 5 6)) ;conj for lists

; vector access using the index
(nth [1 2 3] 1)

; java interop index of the element "2"
(.indexOf [1 2 3] 2)

; Sets collections of uniques values
(def s1 #{1 3 2})
(def s2 #{1 2 3 4 5 6})
(conj s1 4)
(conj (conj s1 4) s2)
(conj (conj #{1 2 3} 4) 4)
(sort s1)
(contains? s1 3)
(contains? s1 44)
(clojure.set/subset? s1 s2)
(clojure.set/subset? s2 s1)
(clojure.set/superset? s2 s1)

; maps
(def os {:unix ["GNU/Linux" "BSD*"] :another "nope"})
(get os :unix)
(get os :another)
(:unix os)

(assoc os :real-time "amoeba")
os
(def fruits {:orange "drupe"})
(merge os fruits)
(vals os)
(keys os)

; sequences (generic representation of any sequence)
(def sq0 #{1 2 3})
(def sq1 '(4 5 6))
(def sq2 [7 8 9])

(first sq0)
(first sq1)
(rest sq1)
(cons 0 sq0)
(concat sq0 sq1)
(concat sq1 sq2)
(concat sq2 sq1)
(map inc sq0)
(reduce + sq0)
(reduce (fn [x y] (+ y (* x 2))) sq0)
(range 3 20 2)
(repeatedly 5 (fn [] (println "Hello, Clojure!")))

; some for-each
(doseq [words ["World" "Darkness" "feeling" "behaviour" "true"]] 
       (println words))

(take 4 (range 0 100 2))
(take-while odd? (range 1 10 2))
(drop 3 (range 0 10))
(drop-while odd? (range 1 10))
(filter odd? (range 0 10))
(remove odd? (range 0 10))
(partition-by (fn [x] (< x 4)) (range 0 10))
(group-by (fn [x] (> x 4)) (range 0 10))

; recursion
(defn fac [x]
  (cond 
    (= x 0) 1
    :else (* x (fac (- x 1)))))
(fac 4)

; java interop
(let [now (new java.util.Date)]
  (println now))

(let [now (new java.util.Date)]
  (.toString now)) 