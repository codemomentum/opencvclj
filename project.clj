(defproject opencvclj "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [org.bytedeco.javacpp-presets/opencv "2.4.11-0.11"]]
            :resource-paths ["lib/opencv-2411.jar"]
            :jvm-opts [~(str "-Djava.library.path=native/:" (System/getProperty "java.library.path"))]
            )

;;http://docs.opencv.org/doc/tutorials/introduction/clojure_dev_intro/clojure_dev_intro.html
