package com.elouissi.sitronix.utils;

import com.elouissi.sitronix.domain.enums.Saison;

import java.time.LocalDate;

public class SaisonUtil {
    public static Saison getSaisonFromDate(LocalDate date) {
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        if ((month == 3 && day >= 20) || month == 4 || month == 5 || (month == 6 && day <= 20)) {
            return Saison.PRINTEMP;
        }
        else if ((month == 6 && day >= 21) || month == 7 || month == 8 || (month == 9 && day <= 22)) {
            return Saison.ETE;
        }
        else if ((month == 9 && day >= 23) || month == 10 || month == 11 || (month == 12 && day <= 20)) {
            return Saison.AUTOMNE;
        }
        else {
            return Saison.HIVER;
        }
    }


}
