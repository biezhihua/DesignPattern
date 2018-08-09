package 代理模式


/**
 * 代理的使用场景
 *
 * 1.
 */

interface ISubject {
    fun request()
}

class RealSubject : ISubject {

    override fun request() {
        println("Real Subject")
    }

}

class ProxySubject constructor(val target: ISubject) : ISubject {

    override fun request() {
        println("Proxy Subject")
        target.request()
    }
}