(ns app.tasks
  (:require [reagent.core :as reagent :refer [atom]]))

(def tasks
  [{:summary "task1"}
   {:summary "task2"}])

(defn single-task
  "single-task returns a html element for a given task"
  [task]
  [:div.singletask
   [:div.tasksummary
    [:h5 (:summary task)]]])

(defn list-tasks
  "list-tasks is a component container for a list
   of single-tasks."
  []
  [:div.tasklist
   [:ul
    (for [i tasks]
      ^{:key i}
      (single-task i))]])
