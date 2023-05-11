
package clases;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Test  {
	
	
	public static void main(String[] args) {
		
		
		Observable<String> miObservable = Observable.just("mensaje 1", "mensaje 2", "mensaje 3", "mensaje 4", "mensaje 5");
		
		TextObserver testObserver = new TextObserver("observer 1");
		TextObserver testObserver2 = new TextObserver("observer 2");
		
		//testObserver recibirá y procesará los mensajes recibidos por el Observable
		miObservable.subscribe(testObserver);
		System.out.println("-----------------");
		miObservable.subscribe(testObserver2);
		
	}


}

class TextObserver implements Observer<String> {
    private final String nombreObserver;
    
    public TextObserver(String observerName) {
        this.nombreObserver = observerName;
    }

	public void onSubscribe(Disposable d) {
		// TODO Auto-generated method stub
		
	}

	public void onNext(String t) {
		System.out.println("[" + nombreObserver + "] Mensaje: " + t);
		
	}

	public void onError(Throwable e) {
		// TODO Auto-generated method stub
		
	}

	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

   
}