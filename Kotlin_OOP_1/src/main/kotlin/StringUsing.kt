

fun main() {

    val data = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur"
    val metin = "Metin"
    val cumle = "Cümle : $data $metin"

    val val1:Any = 1
    val val2:Any = "1"

    if ( val1 == val2) {
        println("== Veriler eşit")
    }

    if ( val1 === val2 ) {
        println("=== Veriler eşit")
    }


    println(cumle)

    // get
    println( data.get(0) )

    // subString
    val subStr = data.substring(6, 11)
    println(subStr)

    // upperCase
    println( data.uppercase() )
    println( data.lowercase() )

    if ( metin == "Metin" ) {
        println("Doğrulama Başarılı")
    }

    // hatalı kullanım sadece object(any) türünü kıyaslamak için kullanılır.
    if ( metin.equals("Metin") ) {
        println("Doğrulama Başarılı")
    }


    // isEpmty
    println( data.isEmpty() )
    println( data.length )

    // plus - Değer ekleme
    val stB = StringBuilder()
    stB.append(data)
    stB.append(" Kotlin")
    println( stB )
    println( data.plus(" Farklı Kotlin") )


    // replace
    val newStr = data.replace("Lorem", "Ali")
    println( newStr )


}