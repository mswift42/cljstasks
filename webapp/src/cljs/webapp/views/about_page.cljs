(ns webapp.views.about-page
  (:require
   [webapp.views.nav-bar :refer [nav-bar]]))

(defn about-page []
  [:div.container
   (nav-bar "about")
   [:div.header
    [:h2 "About Days"]]
   [:div.aboutdesc
    [:p "A simple dayplanner implemented in clojurescirpt / reagent."]
    [:div [:a {:href "#/"} "go to home page"]]]])
