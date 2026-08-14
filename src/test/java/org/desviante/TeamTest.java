package org.desviante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TeamTest {

    @Test
    void teamsWithSameNameAreEqual() {
        Team teamA = new Team("Lakers", "Conference 2");
        Team teamB = new Team("Lakers", "Conference 2");

        assertEquals(teamA, teamB);
    }

    @Test
    void teamsWithDifferentNamesAreNotEqual() {
        Team lakers = new Team("Lakers", "Conference 2");
        Team sixers = new Team("76ers", "Conference 1");

        assertNotEquals(lakers, sixers);
    }

    @Test
    void teamsWithSameNameButDifferentConferenceAreStillEqual() {
        Team teamA = new Team("Lakers", "Conference 2");
        Team teamB = new Team("Lakers", "Conference 1"); // conferência diferente, nome igual

        assertEquals(teamA, teamB);
    }

    @Test
    void equalTeamsHaveSameHashCode() {
        Team teamA = new Team("Lakers", "Conference 2");
        Team teamB = new Team("Lakers", "Conference 2");

        assertEquals(teamA.hashCode(), teamB.hashCode());
    }
}