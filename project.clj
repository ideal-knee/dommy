(defproject org.clojars.ideal-knee/dommy "0.1.3-SNAPSHOT"
  :clojurescript? true
  :description "No nonsense Clojurescript dom templating and (soon) manipulation"
  :url "https://github.com/ideal-knee/dommy"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:url "git@github.com:ideal-knee/dommy.git"}
  :plugins [[lein-cljsbuild "0.3.2"]]
  :hooks [leiningen.cljsbuild]
  :dependencies [[crate "0.2.3" :scope "dev"] ;; for perf test
                 [prismatic/cljs-test "0.0.6"]]
  :cljsbuild
    {:builds
     {:dev  {:source-paths ["src"]
             :compiler {:output-to "target/main.js"
                        :optimizations :whitespace
                        :pretty-print true}}
      :test {:source-paths ["src" "test"]
             :incremental? true
             :compiler {:output-to "target/unit-test.js"
                        :optimizations :whitespace
                        :pretty-print true}}}
     :test-commands {"unit" ["phantomjs" "target/unit-test.js" "resources/test.html"]}})
