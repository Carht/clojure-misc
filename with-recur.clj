(defn fac [num]
  (loop [internal-num num
         result (bigint 1)]
    (if (zero? internal-num)
      result
      (recur (dec internal-num) (* internal-num result)))))

(fac 4)
(fac 24)
(fac 26723)
