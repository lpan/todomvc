(ns todomvc.semantic
  (:require [goog.object :as obj]
            [om.next :as om]
            [cljsjs.semantic-ui-react]))

(defn component
  "Get a component from sematic-ui-react"
  [k & ks]
  (let [ui js/semanticUIReact
        com (if (seq ks)
              (apply obj/getValueByKeys ui k ks)
              (obj/get ui k))]
    (fn
      [props children]
      (js/React.createElement com props children))))

(def button (component "Button"))

(def list (component "List"))

(def list-item (component "List" "Item"))

(def header (component "Header"))

(def input (component "Input"))
