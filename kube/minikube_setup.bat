minikube config set insecure-registry "10.0.0.0/8"
minikube start

rem # registry
minikube addons enable registry
Start-Job { minikube kubectl -- port-forward --namespace=kube-system service/registry 5000:80 }

rem #pods list
minikube kubectl -- get pods -A

rem #services list
minikube kubectl -- get service -A

rem #load image
minikube kubectl -- create deployment  flux --image=registry.kube-system.svc.cluster.local/flux:1.0

rem #remove deployment
rem minikube kubectl -- delete deployment  flux

rem # remove minikube vm
rem minikube delete
