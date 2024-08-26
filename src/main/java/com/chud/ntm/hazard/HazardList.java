package com.chud.ntm.hazard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HazardList {

    private final List<Hazard> hazards;

    public HazardList(Hazard... hazards) {
        this.hazards = Arrays.asList(hazards);
    }

    public HazardList(List<Hazard> hazards) {
        this.hazards = hazards;
    }

    public Stream<Hazard> stream() {
        return hazards.stream();
    }

    @Override
    public String toString() {
        return hazards.toString();
    }
}
