(ns webapp.views.home-page
  (:require
   [webapp.views.nav-bar :refer [nav-bar]]))

(defn home-page []
  [:div.container
   (nav-bar "")
   [:div.header
    [:h2 "Days"]]])
