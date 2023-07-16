(import 'java.io.File)

(defn min-to-mill [minutes] (* minutes 1000 60))

(defn recently-modified? [file]
  (> (.lastModified file)
     (- (System/currentTimeMillis) (min-to-mill 30))))

(filter recently-modified? (file-seq (File. "/home/carht")))
