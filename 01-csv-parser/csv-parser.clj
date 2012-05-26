(require '[clojure.string :as str])

(def input-string
  (str "first-name,last-name,age,profession\n"
       "Bob,Jones,35,Programmer\n"
       "Alice,Johnson,25,Designer\n"
       "Faye,Peterson,40,Manager\n"
       "Don,Donaldson,33,Designer\n"
       "Claire,Classon,38,Programmer"))

(defn try-my-parser [parser-fn]
  (parser-fn (java.io.StringReader. input-string)))

(defn parse-row [row]
  (str/split  row #","))

(defn extract-headers [header-row]
  (map keyword (parse-row header-row)))

(defn parse-csv [reader]
  (let [lines (str/split-lines (slurp reader))
        headers (extract-headers (first lines))]
    (map #(zipmap headers (parse-row %)) (rest lines))))
