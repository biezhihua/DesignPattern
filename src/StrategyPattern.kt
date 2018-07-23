import org.junit.Test

class Main {

    @Test
    fun main() {

        val price = 100F
        val num = 10

        val actionFactory = ActionFactory()

        val goodsAction: GoodsAction = actionFactory.createAction(0)

        val result = goodsAction.calculate(price * num)

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

class ActionFactory {

    fun createAction(type: Int): GoodsAction {
        return when (type) {
            0 -> NormalAction()
            1 -> DiscountAction(0.8F)
            else -> FullSentAction(300F, 100F)
        }
    }
}