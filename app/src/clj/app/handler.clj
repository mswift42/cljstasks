(ns app.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :refer [not-found resources]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [include-js include-css]]
            [prone.middleware :refer [wrap-exceptions]]
            [ring.middleware.reload :refer [wrap-reload]]
            [environ.core :refer [env]]))

(def home-page
  (html
   [:html
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:name "viewport"
             :content "width=device-width, initial-scale=1"}]
     (include-css (if (env :dev) "css/site.css" "css/site.min.css"))
     (include-css "https://storage.googleapis.com/code.getmdl.io/1.0.0/material.blue_grey-deep_purple.min.css")
     (include-css "https://fonts.googleapis.com/icon?family=Material+Icons")
     (include-js "https://storage.googleapis.com/code.getmdl.io/1.0.0/material.min.js")]
    [:body
     [:div.navlayout
      [:div.mdl-layout.mdl-js-layout.mdl-layout--fixed-drawer.mdl-layout--fixed-header
       [:header.mdl-layout__header
        [:div.mdl-layout__header-row
         [:div.mdl-layout-spacer]
         [:div.mdl-textfield.mdl-js-textfield.mdl-textfield--expandable.mdl-textfield--floating-label.mdl-textfield--align-right
          [:label.mdl-button.mdl-js-button.mdl-button--icon
           {:for "fixed-header-drawer-exp"}
           [:i.material-icons "search"]]
          [:div.mdl-textfield__expendable-holder
           [:input.mdl-textfield__input {:type "text" :name "searchinput"
                                         :id "fixed-header-drawer-exp"}]]]]]
       
       [:div.mdl-layout__drawer
        [:span.mdl-layout-title "Days"]
        [:nav.mdl-navigation
         [:a.mdl-navigation__link {:href "/#"} "Home"]
         [:a.mdl-navigation__link {:href "/#about"} "About"]]]
       [:main.mdl-layout__content
        [:div#app.page-content
         [:h3 "ClojureScript has not been compiled!"]
         [:p "please run "
          [:b "lein figwheel"]
          " in order to start the compiler"]]]]]
     (include-js "js/app.js")]]))

(defroutes routes
  (GET "/" [] home-page)
  (resources "/")
  (not-found "Not Found"))

(def app
  (let [handler (wrap-defaults #'routes site-defaults)]
    (if (env :dev) (-> handler wrap-exceptions wrap-reload) handler)))
