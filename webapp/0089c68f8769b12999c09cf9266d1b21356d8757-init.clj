nil (do (set! *warn-on-reflection* nil) (require (quote cljsbuild.crossover) (quote cljsbuild.util) (quote figwheel-sidecar.auto-builder)) (try (do (clojure.core/letfn [(copy-crossovers__3099__auto__ [] (cljsbuild.crossover/copy-crossovers "/home/severin/cljstasks/webapp/target/cljsbuild-crossover" (quote [])))] (clojure.core/when (clojure.core/not-empty (quote [])) (copy-crossovers__3099__auto__) (cljsbuild.util/once-every-bg 1000 "copying crossovers" copy-crossovers__3099__auto__)) (figwheel-sidecar.auto-builder/run-autobuilder {:figwheel-options {:resource-paths ["/home/severin/cljstasks/webapp/dev-resources" "/home/severin/cljstasks/webapp/resources"], :css-dirs ["resources/public/css"], :server-port 3449, :ring-handler "webapp.handler/app", :http-server-root "public"}, :all-builds [{:parsed-notify-command {:shell []}, :id "app", :source-paths ["src/cljs" "env/dev/cljs"], :jar false, :notify-command nil, :incremental true, :assert true, :compiler {:output-dir "resources/public/js/out", :externs ["closure-js/externs"], :optimizations :none, :warnings true, :output-to "resources/public/js/app.js", :asset-path "js/out", :source-map true, :libs ["closure-js/libs"], :main "webapp.dev", :pretty-print true}}], :build-ids []})) (java.lang.System/exit 0)) (catch cljsbuild.test.TestsFailedException e__3097__auto__ (java.lang.System/exit 1)) (catch java.lang.Exception e__3097__auto__ (do (.printStackTrace e__3097__auto__) (java.lang.System/exit 1)))))