minikube delete

minikube config set insecure-registry "10.0.0.0/8,192.168.0.0/16"
minikube start

rem # registry
minikube addons enable registry
Start-Job { minikube kubectl -- port-forward --namespace=kube-system service/registry 5000:80 }

mvn compile jib:build -P standard

rem #pods list
minikube kubectl -- get pods -A

rem #services list
minikube kubectl -- get service -A

rem #load image
minikube kubectl -- create deployment  flux --image=/flux:1.0

minikube kubectl -- expose deployment  flux --type=LoadBalancer --port 8080