import com.annimon.stream.Stream;
import org.junit.Test;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 2016-03-09.
 */
public class Java6ThreetenAndStreamAndRetroLambda {


    @Test
    public void threetenAndStreamAndLambda() {
        List<LocalDateTime> dates = new ArrayList<LocalDateTime>();

        dates.add(LocalDateTime.of(2014, 2, 5, 0, 0));
        dates.add(LocalDateTime.of(2014, 3, 7, 0, 0));
        dates.add(LocalDateTime.of(2014, 4, 4, 0, 0));
        dates.add(LocalDateTime.of(2014, 5, 3, 0, 0));
        dates.add(LocalDateTime.of(2015, 7, 8, 0, 0));
        dates.add(LocalDateTime.of(2015, 8, 6, 0, 0));
        dates.add(LocalDateTime.of(2016, 9, 5, 0, 0));
        dates.add(LocalDateTime.of(2017, 10, 1, 0, 0));


        Stream.of(dates)
                .map(DateTimeFormatter.ISO_LOCAL_DATE_TIME::format)
                .map(String::getBytes)
                .map(value -> {
                    int count = 0;
                    for (byte aByte : value) {
                        if (aByte == '5' || aByte == '6') {
                            count++;
                        }
                    }
                    return count;
                })
                .filter(value -> value != 0)
                .forEach(System.out::println);

    }
}
