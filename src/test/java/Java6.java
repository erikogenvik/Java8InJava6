import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by erik on 2016-03-09.
 */
public class Java6 {

    @Test
    public void java6() {
        List<Date> dates = new ArrayList<Date>();

        dates.add(new Date(114, 1, 5));
        dates.add(new Date(114, 2, 7));
        dates.add(new Date(114, 3, 4));
        dates.add(new Date(114, 4, 3));
        dates.add(new Date(115, 6, 8));
        dates.add(new Date(115, 7, 6));
        dates.add(new Date(116, 8, 5));
        dates.add(new Date(117, 9, 1));

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        for (Date date : dates) {
            String formatted = dateFormatter.format(date);
            int count = 0;
            for (byte aByte : formatted.getBytes()) {
                if (aByte == '5' || aByte == '6') {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println(count);
            }
        }
    }

}
