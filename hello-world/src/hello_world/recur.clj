(ns hello-world.recur)

(defn hello-for []
  (loop [i 0]
    (when (< i 7)
      (println "Hello Recurrr")
      (recur (inc i)))))

(defn fact [n]
  "Calculate the factorial of a number. Loop is similar to `let'.
`i' take the value of `n' and `acc' is an accumulator and take the
base value. `recur' replace the recursive call of `fact'. (See Scheme example)"
  (loop [(bigint i) n acc 1]
    (if (= i 0)
      acc
      (recur (dec i) (* acc i)))))

; (define factorial
; "A example of tail recursive factorial function in Scheme, in this function dont exists recur, but
; recall the same function name. See the similarities" 
;  (lambda (n)
;     (let fact ([i n] [acc 1])
;        (if (zero? i)
;             acc
;             (fact (- i 1) (* acc i))))))

(defn my-sum [lst-num]
  "A base form for sum the numbers of a list."
  (loop [l lst-num acc 0]
    (if (empty? l)
      acc
      (recur (rest l) (+ (first l) acc)))))

(defn my-length [lst]
  "Calculate the length of a list using recur."
  (loop [l lst acc 0]
    (if (empty? l)
      acc
      (recur (rest l) (inc acc)))))

(defn my-reverse [lst]
  "Reverse the lst. If you input a vector, the function return
a list. Recur over the cdr of the list and for each loop, add or
concatenate the active element with the accumulator, the accumulator
begin as a empty list."
  (loop [l lst acc '()]
    (if (empty? l)
      acc
      (recur (rest l) (cons (first l) acc)))))

(defn my-reverse-destructuring [lst]
  "Using destructuring for match the head (h) of the list and
the tail (t) of the list. In this function ask about the-list as
test for the loop."
  (loop [[h & t :as the-list]
         (seq lst)
         acc '()]
    (if the-list
      (recur t (cons h acc))
      acc)))

(defn my-reverse-destructuring-1 [lst]
  "Using destructuring for match the head (h) and the tail (t)
of the list. In this function ask when the-list is empty as test
for the loop."
  (loop [[h & t :as the-list]
         (seq lst)
         acc '()]
    (if (empty? the-list)
      acc
      (recur t (cons h acc)))))
