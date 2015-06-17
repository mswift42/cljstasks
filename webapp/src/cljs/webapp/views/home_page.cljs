(ns webapp.views.home-page
  (:require
   [webapp.views.nav-bar :refer [nav-bar]]))

(defn home-page []
  [:div.container
   (nav-bar "")
   [:div.header
    [:h2 "Days"]]])

(defn newtask-input
  "inputelement for newtask and edittask elements."
  [summary id]
  [:input.form-control {:id id :field :text :value (str summary)}])



