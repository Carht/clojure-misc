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
