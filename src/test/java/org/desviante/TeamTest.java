package org.desviante;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Testes para o contrato de equals/hashCode da classe Team.
 */
class TeamTest {

    /**
     * Verifica que dois times com o mesmo nome são considerados iguais.
     */
    @Test
    void teamsWithSameNameAreEqual() {
        Team teamA = new Team("Lakers", "Conference 2");
        Team teamB = new Team("Lakers", "Conference 2");

        assertEquals(teamA, teamB);
    }

    /**
     * Verifica que times com nomes diferentes não são considerados iguais.
     */
    @Test
    void teamsWithDifferentNamesAreNotEqual() {
        Team lakers = new Team("Lakers", "Conference 2");
        Team sixers = new Team("76ers", "Conference 1");

        assertNotEquals(lakers, sixers);
    }

    /**
     * Verifica que a conferência não influencia a igualdade entre times,
     * apenas o nome é usado como identidade do time.
     */
    @Test
    void teamsWithSameNameButDifferentConferenceAreStillEqual() {
        Team teamA = new Team("Lakers", "Conference 2");
        Team teamB = new Team("Lakers", "Conference 1"); // conferência diferente, nome igual

        assertEquals(teamA, teamB);
    }

    /**
     * Verifica que times considerados iguais produzem o mesmo hashCode,
     * respeitando o contrato de equals/hashCode exigido pelo HashMap.
     */
    @Test
    void equalTeamsHaveSameHashCode() {
        Team teamA = new Team("Lakers", "Conference 2");
        Team teamB = new Team("Lakers", "Conference 2");

        assertEquals(teamA.hashCode(), teamB.hashCode());
    }
}