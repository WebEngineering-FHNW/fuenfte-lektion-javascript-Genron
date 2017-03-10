package mvc

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(InPlaceCalculatorController)
class InPlaceCalculatorControllerSpec extends Specification {

    InPlaceCalculatorController controller

    def setup() {
        controller = new InPlaceCalculatorController()
    }

    def cleanup() {
    }

    @Unroll
    void "average of #en and #exam should be #result"(en, exam, result) {
        when:
            def model = new CalculatorModel(en:en, exam:exam)
            controller.calc(model)
        then: "average calculation"
            model.result == result
        where:
            en  | exam | result
            0.0 | 0.0  | "Cannot calculate. Exam value was invalid."
            1.0 | 2.0  | "2"
            2.0 | 1.0  | "2"
            1.0 | 1.9  | "1"

    }
}
