package com.app.logic

import com.app.exception.InvalidCellPopulationException
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by amits on 19/07/15.
 */
class UniverseSpec extends Specification {

    def "test cell generation"() {

        expect:
        def universe = new Universe(input)
        universe.regenerate()
        universe.getCellPopulationArray() == output as String[]
        where:

        input                    | output
        ["-XXX", "XXX-"]         | ["---X--", "-X--X-", "-X--X-", "--X---"]
        ["XX", "XX"]             | ["----", "-XX-", "-XX-", "----"]
        ["XXX"]                  | ["--X--", "--X--", "--X--"]
        ["-X-X", "XXX-", "-X-X"] | ["------", "-XX---", "-X--X-", "-XX---", "------"]
    }

    @Unroll
    def "verify exception in cell generation when #input cell population in given as input"() {

        when:
        new Universe(input)
        then:
        thrown InvalidCellPopulationException
        where:
        input << getData()
    }

    def getData() {
        [null, []]
    }
}