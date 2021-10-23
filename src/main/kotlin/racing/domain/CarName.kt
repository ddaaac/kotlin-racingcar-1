package racing.domain

import racing.CarNameException
import racing.require

private const val MAX_CAR_NAME_LENGTH = 5

@JvmInline
value class CarName(val value: String) {

    init {
        require(value.isNotBlank()) { CarNameException("자동차 이름은 공백이 될 수 없습니다") }
        require(value.length <= MAX_CAR_NAME_LENGTH) { CarNameException("자동차 이름은 5자를 초과할 수 없습니다") }
    }

    companion object {

        private const val CAR_NAME_DELIMETER = ","

        fun from(names: String): List<CarName> {
            return names.split(CAR_NAME_DELIMETER).map(::CarName)
        }
    }
}
