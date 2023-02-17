(ns hello-world.functions)

(defn round-0
  "Using the type input, util for more significantly more efficient bytecode"
  [^double d ^long precision]
  (let [factor (Math/pow 10 precision)]
    (/ (Math/floor (* d factor)) factor)))

(def not-nil? (complement nil?))

(defn round-1
  "Adding precondition"
  [^double d ^long precision]
  {:pre [(not-nil? d) (not-nil? precision)]}
  (let [factor (Math/pow 10 precision)]
    (/ (Math/floor (* d factor)) factor)))

(defn hello-arity
  "Hello Clojure function with two possible arities."
  ([] (println "Hello! Clojure"))
  ([name] (println (str "Hello, " name " Welcome to Clojure \\o/!"))))

(defn multi-print
  "Variadic function."
  [x & args]
  (println x args))
