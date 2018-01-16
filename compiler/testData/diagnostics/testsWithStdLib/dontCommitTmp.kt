//fun <T> materialize(): T = TODO()
//
//val a: Unit = run {
//    "hello"
//}
//
//val b: Unit = materialize<Int>()

val a: () -> Unit = {
    if (true) 42
}