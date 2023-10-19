import com.example.secondproject.dao.HistoryDao;
import com.example.secondproject.dao.ReservationDao;
import com.example.secondproject.dao.TripsDao;
import com.example.secondproject.model.History;
import com.example.secondproject.model.Reservation;
import com.example.secondproject.model.Trips;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TripService {


    @Test
    public void confirmThem(){
        Trips trips = new Trips("ttree","jjjg");
        Reservation reservation = new Reservation("mtn","Miracle", trips);
//        TripsDao.saveTrips(trips);
        ReservationDao.saveReservation(reservation);
        History history = new History();
        history.setHistories("sdjdujhbg");
        history.setNow(LocalDate.now());
        HistoryDao.saveHistory(history);
    }

    @Test
    public void adddTrips(){
        Reservation er = new Reservation("fc","cddf");
        Trips tri = new Trips("ttree","jjjg", er );

        TripsDao.saveTrips(tri);
    }

}
