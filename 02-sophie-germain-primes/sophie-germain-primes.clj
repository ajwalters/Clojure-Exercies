(def sophie-germain-primes
  (concat [2 3]
    (for [i (iterate inc 4)
          :let [pair (+ 1 (* 2 i))
                correct-form? #(= (mod (- % 5) 6) 0)
                is-prime? (fn [n]
                            (not-any?
                              #(= (mod n %) 0)
                              (range 2 n)))]
          :when (and
                  (correct-form? i)
                  (correct-form? pair)
                  (is-prime? i)
                  (is-prime? pair))]
      i)))
