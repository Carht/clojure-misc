(defn fac [num]
  (loop [internal-num num
         result (bigint 1)]
    (if (zero? internal-num)
      result
      (recur (dec internal-num) (* internal-num result)))))

(fac 4)
(fac 24)
(fac 26723)

(defn my-length [lst]
  (loop [i-list lst acc 0]
    (if (empty? i-list)
      acc
      (recur (rest i-list) (inc acc)))))

(my-length '(1 2 3 4))


(defn my-range [start stop step]
  (loop [a start
         b stop
         c step
         acc []]
    (if (>= a b)
      acc
      (recur (+ a c) b c (conj acc (+ a c))))))

(my-range 0 5 1)
(my-range 0 10 2)

(defn reverse-range [start stop step]
  (loop [a start
         b stop
         c step
         acc []]
    (cond (<= b a) acc
          (< step 0) acc
          :else (recur a (- b c) c (conj acc (- b c))))))

(reverse-range 0 10 1)
(reverse-range 0 10 -1)
(reverse-range 10 20 3)

(defn my-repeat [elem times]
  (loop [e elem
         t times
         acc []]
    (if (zero? t)
      acc
      (recur e (dec t) (conj acc e)))))

(my-repeat 3 20)
(my-repeat "x" 5)

(defn my-reverse [coll]
  (loop
      [icoll coll
       acc []]
    (if (empty? icoll)
      acc
      (recur (rest icoll) (cons (first icoll) acc)))))

(my-reverse (my-range 0 10 1))
(my-reverse "abc")
