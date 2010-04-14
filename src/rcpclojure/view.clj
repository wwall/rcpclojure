(ns rcpclojure.view
  (:gen-class
    :name "rcpclojure.View"
    :extends org.eclipse.ui.part.ViewPart
    :exposes-methods {getSite superGetSite} )
  (:use
    rcpclojure.widgets
    rcpclojure.interop)
  (:import
    (org.eclipse.jface.dialogs MessageDialog)
    (org.eclipse.swt SWT)
    (org.eclipse.swt.layout GridData)))

(defn -createPartControl 
  "Creates the control, a fake email message"
  [this parent]
  (let [shell (.getShell (.superGetSite this))] 
    (composite parent {:layout {:margin [0]}}
      (composite {:layout {:margin [5 10] :span [2 1] :align [:fill :top]}}
        (label {:value "Subject:" :style {:font :bold}})
        (label {:value "This is a message."})
        (label {:value "From:" :style {:font :bold}})
        (link  {:value "<a>someone@example.com</a>" :style {:wrap false}}
          (on-select 
            #(show-info shell "Not Implemented" "Imagine the address book or a new message being created now.")))
        (label {:value "Date:" :style {:font :bold}})
        (label {:value "10:34 am"}))
      (text {:value "This is the body of a message generated by Clojure!" 
             :style {:multi-line true} :layout {:align [:fill]}}))))

(defn -setFocus [this] nil)