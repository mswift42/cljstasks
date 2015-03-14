(ns webapp.views.nav-bar)

(defn nav-bar [active]
  [:nav.navbar-default.navbar-fixed-top {:role "navigation"}
   [:div.container
    [:div.navbar-header
     [:a.navbar-brand {:href "/#"} "DAYS"]]
    [:div.navbar-collapse.collapse
     (if (= active "about")
       [:ul.nav.navbar-nav
        [:li
         [:a {:href "#/"} "Home"]]
        [:li.active
         [:a {:href "#/about"} "About"]]]
       [:ul.nav.navbar-nav
        [:li.active
         [:a {:href "#/"} "Home"]]
        [:li
         [:a {:href "#/about"} "About"]]])]]])
