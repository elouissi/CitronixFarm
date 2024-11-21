package com.elouissi.sitronix.web.rest.VM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArbreVM {
    private LocalDate date_plantation;

    public LocalDate getDate_plantation() {
        return date_plantation;
    }

    public void setDate_plantation(LocalDate date_plantation) {
        this.date_plantation = date_plantation;
    }
}
