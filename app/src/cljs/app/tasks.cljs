(ns app.tasks
  (:require [reagent.core :as reagent :refer [atom]]))

(def tasks
  [{:summary "task1"}
   {:summary "task2"}])

(defn list-tasks
  []
  [:div.tasklist
   [:ul
    (for [i tasks]
      ^{:key i}
      [:div.tasksummary
       [:h5 (:summary i)]])]])
