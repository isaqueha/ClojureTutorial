; INICIANDO COM CLOJURE
;;;;;;;;;;;;;;;;;;;;;;;
; Este é um exemplo de comentário de linha

; No paradigma funcional o código é escrito como uma "forma funcional" 
; forma funcional é uma função que recebe outras funções como parâmetro ou uma função que resulta em outra função (ou ambos)

; A sintaxe do Clojure é semelhante a do Lisp: o código é composto de expressões (forma funcional) que resultam em algum valor
; As expressões são escritas como listas, usando a notação de prefixo. O primeiro elemento na lista é o nome de uma função, o nome de uma macro, uma expressão lambda ou o nome de um operador especial. 
; O restante da lista são os argumentos.
; No exemplo a seguir, println é a função e "Hello, World" é o argumento
; (println "Hello, World")


; Mais alguns exemplos básicos:
; str vai criar uma string com seus argumentos
; (str "Hello" " " "World") ; => "Hello World"

; Veja como utilizar os operadores aritméticos
; O operador 
; (+ 1 1) ; => 2
; (- 2 1) ; => 1
; (* 3 2) ; => 2
; (/ 2 4) ; => 2

; Veja mais alguns exemplos
;(+ 1 2 3) ; => 6
;(+ 1 (- 3 2)) ; = 1 + (3 - 2) => 2
;(+ 5 (* 5 (- 7 2 1))) ; => 25

; Usando operadores de igualdade
; (= 1 1) ; => true
; (= 2 1) ; => false

; Usando operador de negação
; (not true) ; => false


; Usando a função let
;;;;;;;;;;;;;
; Para criar um escopo você pode utilizar a função let
; Veja o exemplo abaixo, após o let é criado um vetor (symbols) com nomes e valores
; (let [width     10
;       height    20
;       thickness 2]
;   (println "hello from inside the `let`.")
;   (* width height thickness)) ; apresenta aqui a multiplicação entre os simbolos do vetor

;Veja mais um exemplo do uso de possíveis usos do let
; (let [x 2 ; define o valor do x
;       x (* x x) ; define operação de multiplicação sobre o x
;       x (+ x 1)] ; define operação de soma sobre o x
;   x) ; retorna o valor do escopo do let


; Valores escalares
; Na matemática, na informática, e na física uma grandeza escalar é definida quando precisamos
; somente de um valor numérico associado a uma unidade de medida para caracterizar uma grandeza física. ... 
; Grandezas como comprimento, massa e tempo são três exemplos de grandezas escalares.
; Veja abaixo qual é o suporte do Clojure para os valores escalares
; (println "Scalars: \n")
; (println "Type of 1 is: " (type 1) "\n")
; (println "Type of 1.2 is: " (type 1.2) "\n")
; (println "Type of 1N is: " (type 1N) "\n")
; (println "Type of 1.5M is: " (type 1.5M) "\n")
; (println "Type of 1.2e4 is: " (type 1.2e4) "\n")
; (println "Type of 1/3 is: " (type 1/3) "\n")
; (println "Type of \"HEY!\" is: " (type "HEY!") "\n")
; (println "Type of \\a is: " (type \a) "\n")
; (println "Type of :my-keyword is: " (type :my-keyword) "\n")
; (println "Type of 'my-s is: " (type 'my-s) "\n")



; Tipos de dados
;;;;;;;;;;;;;

; Clojure utiliza os tipos objetos do Java para booleans, strings e numbers.
; Podemos usar a função `class` para verificar um tipo de dado
; Execute os exemplos abaixo:
; (class 1) ; Integer literals são java.lang.Long bypor padrão
; (class 1.); Float literals são java.lang.Double
; (class ""); Strings são sempre definidas entre aspas duplas e são do tipo java.lang.String
; (class false) ; Booleans são java.lang.Boolean
; (class nil); O valor "null" é chamado nil


; Estruturas de dados (Collections e Sequences)
;;;;;;;;;;;;;
; Existem funções para criar as várias estruturas de dados sem usar a sintaxe literal usual
; Veja os exemplos abaixo
; (list 1 2 3)            ; ⇒ '(1 2 3)
; (vector 1 2 3)          ; ⇒ [1 2 3]
; (hash-map :a 1 :b 2)    ; ⇒ {:a 1 :b 2}
; (hash-set :a :b :c)     ; ⇒ #{:a :b :c}


; As listas são estruturas do tipo linked-list e os vetores são arrays
; (class [1 2 3]) ; => clojure.lang.PersistentVector
; (class '(1 2 3)) ; => clojure.lang.PersistentList

; Uma lista pode ser escrita da seguinte forma: (1 2 3), porém precisamos usar a aspa simples: ' 
; para indicar para o compilador que o que vem depois do parênteses não é uma função (lembre-se que tudo é considerado como uma função depois dos parênteses)
; Por exemplo, tente executar o exemplo abaixo sem a aspa  depois com a aspa:
; (class (1 2 3))
; (class '(1 2 3))

; Além disso, (list 1 2 3) é o mesmo que '(1 2 3)
; (list 1 2 3)
; '(1 2 3)


; "Collections" são grupos de dados
; Tanto as lists quanto os vectors são collections
; A função "coll?" abaixo verifica se a estrutura de dados é uma collection:
; (coll? '(1 2 3)) ; => true
; (coll? [1 2 3]) ; => true

; "Sequences" (seqs) são descrições abstratas de lists
; Somente lists são sequences
; A função "seq?" abaixo verifica se a estrutura de dados é uma sequence:
; (seq? '(1 2 3)) ; => true
; (seq? [1 2 3]) ; => false

; Utilize a função "cons" para adicionar um item no início de uma list ou vector
; (cons 4 [1 2 3]) ; => (4 1 2 3)
; (cons 4 '(1 2 3)) ; => (4 1 2 3)

; A função "conj" adiciona um item à uma collection de forma mais eficiente
; Para lists, ele insere no início, para vectors, ele insere no final
; (conj [1 2 3] 4) ; => [1 2 3 4]
; (conj '(1 2 3) 4) ; => (4 1 2 3)

; Use a função "concat" para concatenar lists e vectors
; (concat [1 2] '(3 4)) ; => (1 2 3 4)


; Existem várias funções que permitem trabalhar com strings
; Veja algumas delas abaixo:
; (require '[clojure.string :as str])
; (str "hi" "there") ;; ⇒ "hithere"
; (count "hello") ;; ⇒ 5
; (str/split "hello there" #" ") ;; ⇒ ["hello" "there"]
; (str/join ["hello" "there"]) ;; ⇒ "hellothere"
; (str/replace "hello there" "ll" "LL") ;; ⇒ "heLLo there"


; Como strings são sequences qualquer função que pode ser utilizada com sequences
; funciona também com strings
; Veja alguns exemplos abaixo:
; (first "hello") ;; ⇒ \h
; (last "hello") ;; ⇒ \o
; (rest "hello") ;; ⇒ (\e \l \l \o)
; (nth "hello" 1) ;; ⇒ \e
; (doseq [letter "hello"] (println letter))
;   ; h
;   ; e
;   ; l
;   ; l
;   ; o
;   ; ⇒ nil


; Functions
;;;;;;;;;;;;;;;;;;;;;

; Use fn para criar novas functions. Uma função sempre retorna a última sentença
; (fn [] "Hello World") ; => aqui vai mostrar o endereço de memória de fn

; Você precisa de parênteses extras para chamar a função
; ((fn [] "Hello World")) ; => "Hello World"

; Você pode criar uma variável usando a função "def"
; (def x 1)
; x ; => 1

; Atribuindo uma função a uma variável:
; (def hello-world (fn [] "Hello World"))
; (hello-world) ; => "Hello World"

; Você pode também encurtar o processo acima usando "defn"
; ((defn hello-world [] "Hello World"))

; O []  acima representa a lista de argumentos da função
; (defn hello [name]
;   (str "Hello " name))
; (hello "Steve") ; => "Hello Steve"

; Você também pode usar a forma abaixo para criar functions:
; (def hello2 #(str "Hello " %1))
; (hello2 "Fanny") ; => "Hello Fanny"

; Você também pode ter funções com que recebem diferentes tipos de parâmetros e dependendo
; dos parâmetros, assumem um comportamento diferente
; Veja abaixo o exemplo
; (defn hello3
;   ([] "Hello World") ; se não receber parâmetro imprime Hello World
;   ([name] (str "Hello " name))) ; se receber parâmetro imprime Hello e o parâmetro recebido
; (hello3 "Jake") ; => "Hello Jake"
; (hello3) ; => "Hello World"

; Funções podem empacotar argumentos extras em um seq para você
; (defn count-args [& args]
;   (str "You passed " (count args) " args: " args))
; (count-args 1 2 3) ; => "Você passou 3 args: (1 2 3)"

; Você pode misturar argumentos regulares e empacotados
;(defn hello-count [name & args]
;  (str "Hello " name ", you passed " (count args) " extra args"))
;(hello-count "Finn" 1 2 3) ; => "Hello Finn, you passed 3 extra args"


; Maps
;;;;;;;;;;

; Hash maps e array maps compartilhar uma interface. Hash maps têm pesquisas mais rápidas
; mas não retem a ordem das chaves
;(class {:a 1 :b 2 :c 3}) ; => clojure.lang.PersistentArrayMap
;(class (hash-map :a 1 :b 2 :c 3)) ; => clojure.lang.PersistentHashMap
;(class :a) ; => clojure.lang.Keyword

;(def stringmap {"a" 1, "b" 2, "c" 3})
;stringmap  ; => {"a" 1, "b" 2, "c" 3}

;(def keymap {:a 1, :b 2, :c 3})
;keymap ; => {:a 1, :c 3, :b 2}

; Você pode recuperar um valor de um map chamando-o como uma função
;(stringmap "b") ; => 2
;(keymap :b) ; => 2

; Keywords também podem ser usadas para recuperar o valor de um map
;(:c keymap) ; => 3

; Recuperar uma chave não presente retorna nulo
;(stringmap "d") ; => nil

; Use "assoc" para adicionar novas keys em hash-maps
;(def newkeymap (assoc keymap :d 4))
;newkeymap ; => {:a 1, :b 2, :c 3, :d 4}

; Mas lembre-se, os tipos de clojure são imutáveis!
;keymap ; => {:a 1, :b 2, :c 3}

; Use "dissoc" para remover keys
;(dissoc keymap :a :b) ; => {:c 3}



; Sets
;;;;;;

;(class #{1 2 3}) ; => clojure.lang.PersistentHashSet
;(set [1 2 3 1 2 3 3 2 1 3 2 1]) ; => #{1 2 3}

; Adicione um item com "conj"
;(conj #{1 2 3} 4) ; => #{1 2 3 4}

; Remova um item com "disj"
;(disj #{1 2 3} 1) ; => #{2 3}

; Teste a existência de um item usando set como uma function:
;(#{1 2 3} 1) ; => 1
;(#{1 2 3} 4) ; => nil

; Aqui foi apresentado apenas algumas functions de set, há muitas outras no namespace: clojure.sets.



; Outras formas úteis
;;;;;;;;;;;;;;;;;

; If terciário
;(if false "a" "b") ; => "b"
;(if false "a") ; => nil

; Use let para criar associações temporárias
;(let [a 1 b 2]
;  (> a b)) ; =>  a > b == false

; Agrupe sentenças com "do"
;(do
;  (print "Hello")
;  "World") ; => "World" (prints "Hello")

; Functions usam o "do" de forma implícita
;(defn print-and-say-hello [name]
;  (print "Saying hello to " name)
;  (str "Hello " name))
;(print-and-say-hello "Jeff") ;=> "Hello Jeff" (prints "Saying hello to Jeff")

; let também
;(let [name "Urkel"]
;  (print "Saying hello to " name)
;  (str "Hello " name)) ; => "Hello Urkel" (prints "Saying hello to Urkel")



; Modules
;;;;;;;;;;;;;;;

; Também podemos utilizar set operations
;(intersection #{1 2 3} #{2 3 4}) ; => #{2 3}
;(difference #{1 2 3} #{2 3 4}) ; => #{1}


; Java
;;;;;;;;;;;;;;;;;

; Java tem uma biblioteca padrão enorme e útil e você pode utilizá-la
; Use import para carregar uma biblioteca Java
;(import java.util.Date)
;(Date.) ; <date object>
;(. (Date.) getTime) ; <timestamp>
;(.getTime (Date.)) ; msma coisa acima
;(System/currentTimeMillis) ; <timestamp>

;(import java.util.Calendar)
;(doto (Calendar/getInstance)
;  (.set 2000 1 1 0 0 0)
;  .getTime) ; => Date = 2000-01-01 00:00:00

; STM
;;;;;;;;;;;;;;;;;

; Software Transactional Memory é usado para trabalhar com persistência de dados

; O atom é a forma mais simples de se trabalhar com STM
;(def my-atom (atom {}))

; Você pode atualizar um atom com a funcão "swap!"
; swap! pega uma função e a chama com o valor atual do átomo como o primeiro argumento, 
; e quaisquer argumentos à direita como o segundo
;(swap! my-atom assoc :a 1) 
;(swap! my-atom assoc :b 2) 

; Use '@' para chamar o átomo e obter o valor
;@my-atom ; => {:a 1 :b 2}

; Exemplo de contador usando o atom
;(def counter (atom 0))
;(defn inc-counter []
;  (swap! counter inc))
;(inc-counter)
;(inc-counter)
;(inc-counter)
;(inc-counter)
;(inc-counter) ;@counter ; => 5

; Outros elementos de STM são refs e agents:
; Refs: http://clojure.org/refs
; Agents: http://clojure.org/agents