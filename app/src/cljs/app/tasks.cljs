(ns app.tasks
  (:require [reagent.core :as reagent :refer [atom]]))

(defonce tasks
  (atom
            '({:summary "task1"}
             {:summary "task2"})))

(defn add-task
  "add a task to var tasks"
  [task]
  (swap! tasks conj task))

(defn toggle-class
  "swap classes for a referenced atom."
  [a k class1 class2]
  (if (= (@a k) class1)
    (swap! a assoc k class2)
    (swap! a assoc k class1)))

(defn card-element
  "card-element returns a material-design card component."
  [content]
  [:div.mdl-card.mdl-shadow--2dp.taskcard
   [:div.mdl-card__title.mdl-card--expand
    content]])

(defn edit-task-summary
  "edit-task represents a single-task element with an 
   text input field for correcting the task summary."
  [task]
  [:div {:style "display:none"}
   [:input {:type "text" :value (:summary task)}]])

(defn single-task
  "single-task returns a html element for a given task"
  [task]
  [:div
   [card-element
    [:h5 (:summary task)]
    [edit-task-summary task]]])


(defn list-tasks
  "list-tasks is a component container for a list
   of single-tasks."
  []
  [:div.tasklist
   [:div.addtask
   [:button.mdl-button.mdl-js-button.mdl-button--fab.mdl-js-ripple-effect.mdl-button--colored {:on-click #(add-task {:summary "New Task"})}
    [:i.material-icons "add"]]]
   [:ul
    (for [i @tasks]
      ^{:key i}
      (single-task i))]])


