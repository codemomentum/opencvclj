(ns opencvclj.core
  (:import
    org.opencv.core.Core
    org.opencv.core.Mat
    org.opencv.core.MatOfRect
    org.opencv.core.Point
    org.opencv.core.Rect
    org.opencv.core.Scalar
    org.opencv.highgui.Highgui
    org.opencv.objdetect.CascadeClassifier))

(clojure.lang.RT/loadLibrary org.opencv.core.Core/NATIVE_LIBRARY_NAME)

(defn draw-rect [detection img]
  (Core/rectangle img
                  (Point. (.x detection) (.y detection))
                  (Point. (+ (.x detection) (.width detection))
                          (+ (.y detection) (.height detection)))
                  (Scalar. 0 255 0)))

(defn classify [classifier-fname img-fname out-fname]
  (let [classifier (CascadeClassifier. classifier-fname)
        img (Highgui/imread img-fname)
        detections (MatOfRect.)]
    (.detectMultiScale classifier img detections)
    (doall (map #(draw-rect % img) (.toList detections)))
    (Highgui/imwrite out-fname img)))

#_(classify (.getPath (clojure.java.io/resource "haarcascade_frontalface_alt.xml"))
          (.getPath (clojure.java.io/resource "res.png"))
          "res-detected.png")
