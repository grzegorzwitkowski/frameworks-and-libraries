package rxjava;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import rx.Observable;

public class RandomIntSupplier {

    private final Random random = new Random();

    public Observable<Integer> get() {
        List<Integer> ints = IntStream.generate(() -> random.nextInt())
                .limit(1000)
                .boxed()
                .collect(Collectors.toList());
        return Observable.from(ints);
    }
}
