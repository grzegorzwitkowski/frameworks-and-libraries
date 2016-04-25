package rxjava;

import rx.Observable;

public class Main {

    public static void main(String[] args) {

        // hello world
        
        RandomIntSupplier supplier = new RandomIntSupplier();
        Observable<Integer> randomInts = supplier.get();
        randomInts
                .limit(5)
                .forEach(System.out::println);
    }
}
