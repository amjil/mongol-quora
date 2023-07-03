(ns amjil.jirgee.test-utils
  (:require
    [amjil.jirgee.core :as core]
    [integrant.repl.state :as state]))

(defn system-state 
  []
  (or @core/system state/system))

(defn system-fixture
  []
  (fn [f]
    (when (nil? (system-state))
      (core/start-app {:opts {:profile :test}}))
    (f)))
