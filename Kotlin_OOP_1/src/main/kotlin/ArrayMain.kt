import com.sun.xml.internal.fastinfoset.util.StringArray

fun main() {

    var arr = Array<String>(3){"Ali"}
    var arr1 = arrayOf("Ali","Veli", "Hasan")

    // değer atama
    arr[0] = "Veli";

    // veriyi belirli indexlere göre yakalama
    val indexs:Iterable<Int> = listOf(0, 1)
    val ls:List<String> = arr.slice(indexs)
    println( "Ls: $ls" )

    println(arr[0])

    var newArr = arr.plus("Erkan")
    newArr.forEach {
        println( it )
    }

    arr1.forEach {
        println(it)
    }




}