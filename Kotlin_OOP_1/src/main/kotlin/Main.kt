
fun main(args: Array<String>) {

    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")

    // değişken oluşturma
    val name = "Ali" // val -> final
    var surname:String = "Bilmem" // var değişken
    surname = "Bilki"
    println(surname::class)

    // kullanıcıdan data alma
    println("Lütfen adınızı giriniz!")
    val namex = readLine()!!
    println(namex::class)

    println("Lütfen yaşınızı giriniz")
    val age = readLine()
    if ( age != null ) {
        var cAge:Int = age.toInt()
        println(cAge::class)
    }

    var i = 0;
    var j = 0;

    ++i
    j++

    println("i ${++i}")
    println("j ${j++}")

    // tek satırlı if
    val status = if ( i == 2 ) "Merhaba" else "Hello"
    println(status)



    // tür kıyaslama
    val obj:Any = 100;
    val typeStatus = obj is Int
    println( typeStatus )

    // object tür değiştirme
    var stNum:Any = 100
    println(stNum::class)
    val cstNum = stNum as Int
    println(cstNum::class)

    var dizi = arrayOf(1,2,3,4,5,7,8)
    stNum = 3
    // when - swich
    when ( stNum ) {

        // aralık belirtilerek kıyaslama
        in 5..9 -> {
            println("Sonuç 1 ile 9 aralığında")
        }

        // dizi içindeki elemanlar arasından var mı?
        in dizi -> {
            println("Sonuç Dizi içinde var")
        }

        1,2,10,40 -> {
            println("Sonuç 1,2,10,40 ")
        }
        50 -> {
            println("Sonuç 50")
        }

        100 -> {
            println("Sonuç 100")
        }

        else -> {
            println("Şartlar uyuşmuyor")
        }

    }


    // if içinde dizi üyesi arama
    stNum = 9
    if ( stNum in dizi ) {
        println("if içinde dizi elemanı( $stNum ) var")
    }else {
        println("if içinde dizi elemanı( $stNum ) yok")
    }

    for ( item in dizi ) {
        println("For item : $item")
    }

    for ( item in 4..10  ) {
        println("Item 4..10 : $item")
    }

}