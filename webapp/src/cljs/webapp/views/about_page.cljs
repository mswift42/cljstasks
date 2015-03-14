(ns webapp.views.about-page)

(defn about-page []
  [:div.container
   [:div.header
    [:h2 "About Days"]]
   [:div.aboutdesc
    [:p "A simple dayplanner implemented in clojurescirpt / reagent."]
    [:div [:a {:href "#/"} "go to home page"]]]])
