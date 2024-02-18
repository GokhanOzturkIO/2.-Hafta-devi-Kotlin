<div align=left>

## BASE TYPES AND NULL SAFETY

| val ile var arasındaki fark nedir? |
|------------------------------------|
|Val ile var arasındaki fark var değeri herhangi bir anda değiştirile bilirken, val 'ın değeri atama anında yapılır.val read-only değişkendir.|

|Bir var değişkeni val gibi davranmasını nasıl sağlayabiliriz val kelimesini kullanmadan? Bunu neden yapmak isteriz? Örnek bir senaryo verin.|
|------------------------------------|
|Değişkenin setter fonksiyonunu private yaparak val gibi davranmasını sağlaya biliriz. Örnegin: |
```kotlin
  var number :Int
    private set
```
|"Değişmez" (Immutable) ve "Salt Okunur" (ReadOnly) kavramlarını açıklayın. val değişkenler neden aslında "değişmez" değil de "salt okunur" olarak açıklanmalıdır?|
|------------------------------------|
|Immutable hiçbir şekilde değiştirelemezken, ReadOnly class içinde farklı parametrelerden üretilen bir değişken ise aslında val değeri dışardan gözlemlerken değiştirğini görürüz.|

|"Tip Çıkarımı" (Type inference) kavramını açıklayın. Hangi durumlarda tip belirtmek kesin olarak gereklidir?|
|------------------------------------|
|Tip çıkarımı, değişkenin valuesuna bakarak tip belirlemesi yapar,Null gelebilecek durumlarda Idenin gelecek değer tipini de bilmesi için tip belirlemesi yaparız.|

|Kotlin'de tüm değişkenlerin sınıf olarak bulunması, "ilkel tip" (primitive type) olmadıkları anlamına gelir mi? Arka planda neler oluyor?|
|------------------------------------|
|Kotlinde primitive tipler class olarak gözüksede compile time da primitive tiplere dönüştürülürler.|

|"Tip Güvenliği" (Type Safety) kavramını açıklayın.|
|------------------------------------|
|    /**     Pas Geçtim      *//|

|Bir değişkeni nullable yapmak için ne yapmalıyız?|
|------------------------------------|
|Değişkenin tipini belirlerken sonuna bir "?" koymalıyız. Örneğin String?,Int?|


|"Null Güvenliği" (Null Safety) kavramını açıklayın.|
|------------------------------------|
|Null olabilecek parametreleri kullanırken null olması durumunda kodun crash olmaması için bir null önlemidir, nesne sonuna ? koyularak kullanılır.|

|Bir değişkene null değer atanır ve tip belirtilmezse Kotlin bu değişkeni nasıl yorumlar?|
|------------------------------------|
|Kotlin bunu Nothing classından türemiş bir nesne gibi yorumlar.|

|İlkel bir değişkenin nullable olması ile null değer alamaması arasında bellek yönetimi açısından nasıl farklar vardır?|
|------------------------------------|
|Null değişkenler, null olamayacak değişkenlere göre daha çok yer kaplar, Null kontrolü yapılacağı için daha yavaş çalışır, güvenirlikleri daha düşüktür.|

|Nullable bir değişkenin bir değere sahip olması ile null olması arasında bellek yönetimi açısından nasıl bir fark vardır? Null değer almış bir değişken bellekte yer kaplamaz diyebilir miyiz?|
|------------------------------------|
|Null değişken bellekte null değilken değişken tipinin bayt karşılığı kadar, null iken null referansı gösterecek kadar yer kaplar, yani null olan değerlerde bellekte bir yer kaplar.|

|Nullable bir değişkenle çalışırken hangi operatörleri kullanırız? Bu operatörlerin kullanım farkları nelerdir? Hangisini ne zaman kullanmak daha anlamlıdır?|
|------------------------------------|
|Null olabilecek bir değişken ile çalışırken "?", "!", "?:" operatörlerini kullanırız; bu operatörler sırasıyle değişkenin null olup olmadığını null olmadığı durumlarda çalışmaya devam etmeyi, değişkenin o anda null olmayacağını null gelirse kodu crashlemeyi sağlar,    "?" operatörünü null gelebilecek ama çok önemli olmayan tölere edibileceğimiz kısımlarda kullanırız.    "!" operatörünü null gelebilecek ama çok önemli olan devam edilmesi durumda daha büyük sorunlara yol acabilecek durumlarda kullanırız.    3. operatör ise Elvis isimli operatördür. Değişkenin null olması durumunda değişken yerine bir değer koymaya yarar.    Örneğin:|

```kotlin
            val nullableString: String? = null
            val nonNullString = nullableString ?: "Varsayılan Değer"
            println("Değişkenin Değeri: $nonNullString")
```
Burada elvis ile string null ise yerine "Varsayılan Değer" yazdırıyoruz, null değilse değerini ne ise onu kullanıyoruz.

## NUMBERS

|Kaç farklı tipte "number" sınıfı miras alan "alt sınıf" (child class) vardır? Bunların değer aralıkları neden önemlidir?|
|------------------------------------|
|Number sınıfının alt sınıfları: Int, Double, Long ,Float, Byte, Short şeklinde sıralanabilir.Değer aralıklarının farklı olması gereksiz yere bellekte alan kaplanmamaısını sağlar böylelikle işlem hızının iyi yönde bir olanak tanır.|

|Eğer bir değişkene tip belirtimi yapılmaz ve bir değer atanırsa, Kotlin tip çıkarımını nasıl yapar?|
|------------------------------------|
|Kotlin, değişkenin değerini belirtmesek de değişkenin değerine ve atanan değerin türüne göre tip çıkarımı yapabilir.|

|Float değişken oluştururken F ve f harfleri varken, Long değişken oluştururken neden küçük l harfi yoktur?|
|------------------------------------|
|Bazı fontlarda 1(bir)'in yazımı ile küçük L harfinin yazımı birbirine çok benzediği için küçük l harfi karışıklık çıkartmaması için kullanılmaz.|

|Tek duyarlıklı (Single precision) ve Çift duyarlıklı (Double precision) kavramlarını açıklayın.|     
|------------------------------------|
|Bilgisayar sistemlerinde ondalıklı sayıların temsil edilme şekillerini ifade eder.Tek duyarlıklı sayılar, 32 bitlik bir kayan nokta formatını kullanırken, çift duyarlıklı sayılar 64 bitlik bir format kullanır.Tek duyarlıklı sayılar daha az bellek kullanır ve daha düşük hassasiyetlidir, çift duyarlıklı sayılar ise daha fazla bellek kullanır ve daha yüksek hassasiyete sahiptir.|

|Double ve Float değişkenlerle çalışırken ondalık ayıracı olarak hangi işaretler kullanılır? Bu ayıraçların kullanımında nelere dikkat etmek gerekir?|
|------------------------------------|
|Double ve Float değişkenlerle valuenun ondalık aracı olarak .(noktadan_sonraki_küsürat_miktarif) şeklinde kullanılır. örneğin .3f -> noktadan sonra 3 rakam.Fakat bunu bir string olarak formatlayıp göstereceksek, Locale 'e göre nokta yada virgüle göre formatlama yapmalıyız.|

|Double ve Float değişkenler ondalık kısımda kaç basamağa kadar işlem yaparlar? Bu sınırın üzerinde gelen ondalık bilgileri için nasıl davranırlar? Hangi durumlar için Float ve hangi durumlar için Double kullanılmalıdır?|
|------------------------------------|
|Float, 6-7 basamağa kadar, Double 15-16 basamağa kadar işlem yapar.Daha fazla basamak sınırın üzerine gelen ondalık sayılarda overflow olur ve program crash verebilir.|

|Ondalık(Decimal), Onaltılık (Hexadecimal) ve İkilik (Binary) değişkenleri Kotlin'de nasıl tanımlayabilirsiniz?|
|------------------------------------|
```kotlin 
    val decimalNumber = 1905
    val hexadecimalNumber = 0x759
    val binaryNumber = 0b010000011
```

|Sekizlik (Octal) değişkenler Java'da nasıl tanımlanır? Kotlin'de Sekizlik değişken tanımlanabilir mi?|
|------------------------------------|
|Java'da sekizlik değişlenleri tanımlarken sayının başına 0 (sıfır) eklenir bunun aksine Kotlin'de sekizlik değişken tanımlanırken herhangi bir özellik yoktur. Kotlin'de sekizlik değişken tanımlanırken Integer'a ait parseInt yardımcı fonksiyonu kullanılır.|

|"Geleneksel Notasyon" (Conventional Notation) gösterimi nasıl yapılır?|
|------------------------------------|
|Kotlin'de ondalıklı değişkenler için geleneksel gösterim desteklenir.Double için -> 123.4, 123.4e10, Float içn -> 123.4f ya da 123.4F|

|Sayısal değişkenlerde alt çizgi (underscore) nasıl kullanılır? Kotlin bunu nasıl yorumlar?|
|------------------------------------|
|Sayı sabitlerini daha kolay okunur hale getirmek için alt çizgi kullanabilir ve ide bu alt çizgileri dikkate almaz. Örneğin: val number = 1_000_000 ve val number=1000000 eşittir.|

| == ile neyi karşılaştırırız? === ile neyi karşılaştırırız?|
|------------------------------------|
|    == ile değişkenlerin value larını karşılaştırırken kullanılır.      === ile değişkenlerin bellek referansını karşılaştırırken kullanılır. |

| === operatörü ile karşılaştırma yaparken Byte değer aralığı neden önemlidir? Kotlin bu aralığa göre neden özel bir davranış sergiler?|
|------------------------------------|
|Referans kontrollerine yapılan özel bir optimizasyon nedeni ile bu değer bayt aralığında ise value ları aynı olan farklı iki değişken olsalar bile memory de aynı alanı işaret ederler.|

| Sayısal değişkenlerde hangi matematiksel operatörler kullanılabilir?|
```
    toplama: Plus  = +
    çıkarma: Minus = -
    çarpma:  Times = x
    bölme:  Div   = /
```

| Sayısal değişkenlerde hangi karşılaştırma operatörleri kullanılabilir?|
|------------------------------------|
```
    == -> İki değer birbirine eşitse true döndürür.
    != -> İki değer birbirine eşit değilse true döndürür.
    Küçük '<' -> Sol taraftaki değer sağ taraftakinden küçükse true döndürür.
    Büyük '>' -> Sol taraftaki değer sağ taraftakinden büyükse true döndürür.
    Büyük veya Eşit '>=' -> Sol taraftaki değer sağ taraftakinden büyük veya eşitse true döndürür.
    Küçük veya Eşit '<=' -> Sol taraftaki değer sağ taraftakinden küçük veya eşitse true döndürür.
    Ve Operatörü '&&' -> Her iki ifade de doğruysa True döndürür.
    Veya Operatörü '||' -> İfadelerden biri doğruysa True döndürür.
```

|Bit düzeyinde operatörler (Bitwise operators) nelerdir? Ne amaçla kullanılır? Kotlin'de bunları nasıl kullanabilirsiniz?|
|------------------------------------|
 ```
    Kotlin, tam sayılar üzerinde bir dizi bitsel işlem sağlar. Yalnızca Int ve Long'a uygulanabilirler:
    shl(bits) –> İşaretsiz sola kaydırma işlemidir. Bir değeri belirtilen miktarda bit sola kaydırır.
    shr(bits) –> İşaretle sağa kaydırma işlemidir. Bir değeri belirtilen miktarda bit sağa kaydırır. Kaydırılan bitler, işaret bitinin değeriyle doldurulur.
    ushr(bits) –> İşaretsiz sağa kaydırma işlemidir. Bir değeri belirtilen miktarda bit sağa kaydırır. Kaydırılan bitler, her zaman sıfır ile doldurulur.
    and(bits) –> Bit bitiyle AND işlemi yapar. İki değerin her bir bitini karşılaştırır ve her iki bit de 1 ise sonuç 1 olur, aksi halde sonuç 0 olur.
    or(bits) –> Bit bitiyle OR işlemi yapar. İki değerin her bir bitini karşılaştırır ve herhangi biri 1 ise sonuç 1 olur.
    xor(bits) –> Bit bitiyle XOR işlemi yapar. İki değerin her bir bitini karşılaştırır ve yalnızca biri 1 ise sonuç 1 olur.
    inv() –> Tüm bitleri tersine çevirir. Yani, 0'lar 1'e, 1'ler ise 0'a dönüşür.
```

| Kotlin'de büyük sayılarla çalışırken hangi ek türlerden yararlanılır ve bu türlerin sınırları nelerdir?|
|------------------------------------|
|BigInteger, BigDecimal gibi ek türler kullanılır.|

| Double ve Float değişkenler kullanılırken "yuvarlama" davranışı nasıldır? Bu nasıl değiştirilebilir?|
|------------------------------------|
|Varsayılan olarak, Kotlin'de Double ve Float sayıları IEEE 754 standardına göre yuvarlanır.Bu standart, genellikle en yakın ondalık sayıya yuvarlama yapar, yani en yakın tam sayıya veya belirli bir ondalık basamağa yuvarlama yapabilir.     Ancak, bazı durumlarda bu yuvarlama hatası gözlenebilir. Kotlin'de bu yuvarlama davranışını değiştirmek pek mümkün değildir, çünkü bu standartla ilgilidir ve dilin kendisiyle ilgili değildir.Ancak, özel yuvarlama stratejileri uygulanabilir. Örneğin, belirli bir hassasiyetle yuvarlama yapmak için özel bir yuvarlama fonksiyonu oluşturabilirsiniz.Bu fonksiyonlar, belirli bir hassasiyetteki yuvarlama için kullanılabilir ve kullanıcı ihtiyaçlarına uyacak şekilde özelleştirilebilir.|

##UnSigned Numbers

|İşaretsiz" (Unsigned) değişkenler ne demektir? İşaretli olanlarla aralarındaki fark nedir?|
|------------------------------------|
|İşaretsiz sayılar sadece pozitif sayıları kapsayan veri tipleridir.Işaretli sayılar pozitif ve negatif sayıları value alabilirken unsigned sayılar sadece pozitif sayıları alabilir.|

|İşaretsiz" değişkenler nasıl bir sınıf yapısında tutulurlar? Bu neden önemlidir?|
|------------------------------------|
|İşaretli ile aynı sınıf tipinde tutulur. Performansa olumlu yönde etki yapar. Beklenmedik sonuçları engeler, Örneğin yaşın bir şekilde negatif çıkması.|

|İşaretsiz" değişkenlerin harf gösterimi nasıldır?|
|------------------------------------|
|U harfi ile birlikte gösterilir; Örnegin:|
```kotlin
        val unsignedInt: UInt = 42u
        val unsignedByte: UByte = 10u
        val unsignedShort: UShort = 500u
        val unsignedLong: ULong = 12345678901234567890u
```

|val a1 = 42u ve val a2 = 0xFFFF_FFFF_FFFFu" değişkenlerin tipleri ne olur? Neden?|
|------------------------------------|
|a1 bir unsigned integer iken a2 bir unsigned long tipindedir. A1 in türü belirtilmediğinden ide Int kabul eder ve u harfi ile bunun bir unsigned tipli olduğu çıkarımını yapar. a2 için de aynı şartlar geçerli iken verilen value ya göre Long tipi çıkarımını yapar.|

|İşaretsiz" "Long" harf gösterimi nasıl yapılır?|
|------------------------------------|
```kotlin
  val unsignedLong: ULong = 12345678901234567890u
```

|İşaretsiz" değişkenlerin kullanım amaçları nelerdir?|
|------------------------------------|
|Negatif olamayacak durumlar için veri güvenliği sağlamak, örneğin yaş, boy uzunluğu, kilo daha büyük bir Int aralığı sağlamak , negatif olamayacak değerler pozitif alanda aralığı genişletmek için kullanılır.|

|İşaretsiz" değişkenlerle yapılan matematiksel işlemlerde, özellikle büyük sayılarla çalışırken karşılaşılabilecek taşma (overflow) ve taşma olmaması (underflow) durumları için Kotlin nasıl bir yönetim sağlar?|
|------------------------------------|
|Kotlin işaretsiz tamsayılarla yapılan işlemlerde taşma durumlarını kontrol eder ve bu durumlarda güvenlik önlemleri alır.Ancak, uygulama tasarımında büyük sayılarla çalışılıyorsa, taşma riskini azaltmak için uygun dönüşümler ve veri türleri dikkate alınmalıdır.|

|"İşaretsiz" değişkenlerin sınırlamaları nelerdir?|
|------------------------------------|
```
    UByte -> 0-255
    UShort ->  0-65_535
    UInt -> 0-4_294_967_295
    ULong- > 0- 18_446_744_073_709_551_615
```

|İşaretsiz" değişken türleri (UInt, ULong vs.) kullanırken, Java API'leri ile uyumluluk konusunda ne gibi sorunlar olabilir? Bunları çözmek için neler yapabilirsiniz?|
|------------------------------------|
|işaretli tam sayıya dönüştürme işlemi kullanılabilir.|


## Type Conversation

|is ve !is operatörlerinin kullanımını açıklayın.|
|------------------------------------|
|tip kontrolü için kullanılır, genelde şartlı olabiliecek kodlarda kullanılır.|

|Akıllı Dönüşüm" (Smart Cast) ne demektir? Farklı kod örnekleri ile açıklayın. Bu özelliğin sınırlamaları nelerdir?|
|------------------------------------|
|Örneğin, bir değişkenin null olup olmadığını kontrol edip null olmadığı durumda onu null olmadığı garantisiyle kullanmak istiyorsanız, Kotlin'in akıllı dönüşüm özelliğinden faydalanabilirsiniz.Örneğin:|
```kotlin
 fun printLength(text: String?) {
     if (text != null) {
         println("Length of text: ${text.length}") // text artık String türüne dönüşmüştür.
     } else {
         println("Text is null")
     }
 }
```

|Sayısal değişkenlerde örtük tip genişletme (implicit widening conversions) ne demektir? Kotlin'de bu neden yapılamaz?|
|------------------------------------|
|Sayısal değişkenlerde örtük tip genişletme (implicit widening conversions), bir türün daha küçük boyutlu bir türden daha büyük bir boyuta dönüştürülmesini ifade eder.Bu dönüşüm, derleyici tarafından otomatik olarak gerçekleştirilir ve genellikle bilgi kaybı olmadan yapılır.Kotlin, implicit (otomatik) tür dönüşümünü desteklemez çünkü bu tür dönüşümler genellikle beklenmeyen sonuçlara veya hatalara neden olabilir. Bunun yerine, Kotlin güvenli ve açık (explicit type conversion) tür dönüşümleri sağlar.|

|val b: Byte = 1 ile val i: Int = b ve son olarak print(b == i) gibi bir kod yazıldığında çıktı ne olur? Neden böyle bir çıktı aldığınızı açıklayın.|
|------------------------------------|
|Bu kod malasef ide ' tarafından derlenmedi == operatörü aynı anda byte ve Int e uygulanmaz hatası verdi. Çünkü kotlin byte'ı Int'e çevirerek bu karşılaştırmayı yapamaz.|

|val b: Byte = 1 ile val i: Int = b.toInt() ve son olarak print(b == i) gibi bir kod yazıldığında çıktı ne olur? Neden böyle bir çıktı aldığınızı açıklayın.|
|------------------------------------|
Bu kod da çalışmaz ancak
```
        print(b.toInt() == i)
```
şeklinde yazsaydık çalışabilirdi.

|Sayısal değişkenlerde açık dönüşüm (Explicit Type Conversion) yaparken hangi fonksiyonları kullanabilirsiniz?|
|------------------------------------|
|toByte(),toInt(),toDouble(),toLong(),toFloat() özetle hangi tipe dönüştürmek istiyorsak toTİPİSMİ() , kendimiz de oluşturduğumuz data classlara fonksiyon ekleyerek tip dönüşümü yaptırabiliriz.|

|val result = 1L + 3" // "Long + Int" gibi bir işlemin sonucunda "result" değişkeninin tipi ve değeri ne olur? Neden böyle olduğunu açıklayın.|
|------------------------------------|
|Long tipinde olur, Ide 2 veri tipinden daha büyük olanın tipini sonucun veri tipi olarak kabul eder.|

|val result = Int.MAX_VALUE + Int.MAX_VALUE" gibi bir işlemin sonucunda "result" değişkeninin tipi ve değeri ne olur? Neden böyle olduğunu açıklayın.|
|------------------------------------|
|Result değişkenin tipide Int olur fakat burada hata alırız çünkü sonuç Int veri tipinin aralığından büyüktür fakat sonucun veri tipi Int olacaktır dolayısıyla burada bir overflow hatası vardır.|

|val x = 5 / 2 println(x == 2)" gibi bir işlemin sonucu ve tipi nedir? Neden böyle olduğunu açıklayın.|
|------------------------------------|
|Sonuç tipi boolean dır print fonksiyonu içinde bir şart sorgusu yapılmıştır ve return tipi booleandır. Sonuç true döner|

|val x = 5L / 2 println(x == 2L)" gibi bir işlemin sonucu ve tipi nedir? Neden böyle olduğunu açıklayın.|
|------------------------------------|
|Sonuç tipi boolean dır print fonksiyonu içinde bir şart sorgusu yapılmıştır ve return tipi booleandır. Sonuç true döner|

|val x = 5 / 2.toDouble() println(x == 2.5)" gibi bir işlemin sonucu ve tipi nedir? Neden böyle olduğunu açıklayın.|
|------------------------------------|
|5/2 . toDouble sonucu 2.5 gelir ve println içerisindeki sorgudan sonuç true döner tipi booleandır|

|Kotlin'de tür dönüşümü yapılırken, dönüşümün başarısız olması durumunda TypeCastException nasıl ele alınır ve bu tür hataların önüne geçmek için hangi önlemler alınabilir?|
|------------------------------------|
|Try catch blokları kullanımı, işlem sonrası is sorgusu ile işlem yapılması yada işlem anında as? ile null durumlardan kaçınma ile yapılabilir.|

</div>