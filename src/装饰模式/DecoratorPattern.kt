package 装饰模式

import org.junit.Test


/**
 *
 * http://www.runoob.com/design-pattern/decorator-pattern.html
 *
 * 把类中的装饰功能从类中搬移出去，这样可以简化原有的类。
 *
 * 有效的把类的核心职责和装饰功能区分开，而且可以去除相关类的重复逻辑。
 *
 *
 */


interface IComponent {
    fun operation()
}


class ConcreteComponent : IComponent {

    override fun operation() {
        println("ConcreteComponent")
    }

}

open class Decorator constructor(val component: IComponent) : IComponent {

    override fun operation() {
        component.operation()
    }

}

class DecoratorA constructor(val component1: IComponent) : Decorator(component1) {

    override fun operation() {
        super.operation()

        println("DecoratorA")
    }
}

class DecoratorB constructor(val component1: IComponent) : Decorator(component1) {

    override fun operation() {
        super.operation()

        println("DecoratorB")
    }
}

class Main {

    @Test
    fun main() {

        val concreateComponent = ConcreteComponent();
        val decoratorA = DecoratorA(concreateComponent)
        val decoratorB = DecoratorB(decoratorA)

        decoratorB.operation()

    }
}