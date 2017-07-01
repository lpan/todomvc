(ns todomvc.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [todomvc.parsers :as p]
            [todomvc.semantic :as s]))

(defn add-todo
  []
  (dom/div
    #js {:className "add-todo"}
    (s/input #js {:placeholder "your todo"})
    (s/button nil "Add Todo")))

(defn todo-list
  []
  (dom/div
    nil
    (s/header nil "Todos")
    (s/list #js {:items #js ["lmao" "hehe"]})))

(defui Root
  Object
  (render
    [this]
    (dom/div #js {:className "todos"}
             (add-todo)
             (todo-list))))

(def reconciler
  (om/reconciler
    {:state (atom {})
     :parser (om/parser {:read p/read :mutate p/mutate})}))

(om/add-root! reconciler Root (gdom/getElement "app"))
