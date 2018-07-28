package 策略模式

import org.junit.Test


/**
 *
 * http://www.runoob.com/design-pattern/strategy-pattern.html
 *
 * 策略模式就是用来封装算法的，但是在实践中，我们可以用它封装几乎任何类型的变化，
 * 只要在分析过程中听到需要在不同的时间应用不同的业务规则，就可以考虑使用策略模式处理这种变化的可能性。
 */

class Main {

    @Test
    fun main() {

        val price = 100F
        val num = 10

        val actionFactory = ActionFactory(0)

        val result = actionFactory.getResult(price * num)

        println("结果: $result")

    }
}

// 活动折扣类型
// 1. 打折
// 2. 满送
// 3. 普通

abstract class GoodsAction {
    abstract fun calculate(money: Float): Float
}

class NormalAction : GoodsAction() {
    override fun calculate(money: Float) = money
}

class DiscountAction(private val discount: Float) : GoodsAction() {
    override fun calculate(money: Float) = discount * money
}

class FullSentAction(private val full: Float, private val sent: Float) : GoodsAction() {
    override fun calculate(money: Float) = if (money >= full) money - sent else money
}

class ActionFactory constructor(type: Int) {

    private val action: GoodsAction = when (type) {
        0 -> NormalAction()
        1 -> DiscountAction(0.8F)
        else -> FullSentAction(300F, 100F)
    }

    fun getResult(money: Float): Float {
        return action.calculate(money)
    }

}