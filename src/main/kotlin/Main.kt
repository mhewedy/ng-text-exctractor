import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.io.FileReader

const val baseDir = "/Users/mhewedy/Downloads/SNE SC/sitneat-customer-app-141ed5747021/src"

fun main() {

    File(baseDir).walk()
        .asSequence()
        .filter { it.extension == "html" }
        .onEach { println("""file: "$it" contains following text:""") }
        .map { FileReader(it).use { f -> f.readText() } }
        .map { Jsoup.parse(it) }
        .forEach { extract(it) }
}

fun extract(doc: Document) {
    doc.allElements
        .filter { e -> e.hasText() }
        .forEach { println(it.text()) }
}

fun textToTranslation(text: String): String {
    // I am writing test cases first
    TODO()
}
