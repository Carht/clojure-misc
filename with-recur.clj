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

(defn my-repeat [elem times]
  (loop [e elem
         t times
         acc []]
    (if (zero? t)
      acc
      (recur e (dec t) (conj acc e)))))

(repeat 3 20)
(repeat "x" 5)
