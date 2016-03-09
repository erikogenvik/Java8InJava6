import com.annimon.stream.Stream;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Predicate;
import org.junit.Test;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 2016-03-09.
 */
public class Java6ThreetenAndStream {

    @Test
    public void threetenAndStream() {
        List<LocalDateTime> dates = new ArrayList<LocalDateTime>();

        dates.add(LocalDateTime.of(2014, 2, 5, 0, 0));
        dates.add(LocalDateTime.of(2014, 3, 7, 0, 0));
        dates.add(LocalDateTime.of(2014, 4, 4, 0, 0));
        dates.add(LocalDateTime.of(2014, 5, 3, 0, 0));
        dates.add(LocalDateTime.of(2015, 7, 8, 0, 0));
        dates.add(LocalDateTime.of(2015, 8, 6, 0, 0));
        dates.add(LocalDateTime.of(2016, 9, 5, 0, 0));
        dates.add(LocalDateTime.of(2017, 10, 1, 0, 0));


        Stream.of(dates).map(new Function<LocalDateTime, String>() {
            @Override
            public String apply(LocalDateTime value) {
                return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(value);
            }
        }).map(new Function<String, byte[]>() {
            @Override
            public byte[] apply(String value) {
                return value.getBytes();
            }
        }).map(new Function<byte[], Integer>() {
            @Override
            public Integer apply(byte[] value) {
                int count = 0;
                for (byte aByte : value) {
                    if (aByte == '5' || aByte == '6') {
                        count++;
                    }
                }
                return count;
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value != 0;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        });

    }

}
