package com.elouissi.sitronix.utils;

import com.elouissi.sitronix.domain.Arbre;

public class ProductiviteUtil {
    public static Float calculerProductivite(Arbre arbre) {
        Integer age = arbre.getAge();

        if (age < 3) {
            return 2.5f;
        } else if (age <= 10) {
            return 12.0f;
        } else {
            return 20.0f;
        }
    }
}
