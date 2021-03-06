
public class JvmComprehension {
    // если jvm встречает новый класс она отдает его загрузчику в систему загрузки классов
    // потом jvm проверяет что код валиден и идет подготовка к выполнению класса, происходит инициализация класса.
    // ClassLoader подтверждает что класс загружен и его можно использовать, класс JvmComprehension загружается в Metaspace, в нем хранится описание классов которые используются в программе.
    // после загрузки класса jvm ищет точку входа main и начинается выполнение программы.
    // В StackMemory создается фрейм main в котором будут добавляться данные используемые в этом методе.

    public static void main(String[] args) { // в стеке формируется фрейм main
        int i = 1;                      // 1. Создается переменная i значение которой =1 и отправляется в стек блока main
        Object o = new Object();        // 2. Создается объект object в куче, создается переменная o, в которой сохранена ссылка на объект, и отправляется в стек фрейма main.
        Integer ii = 2;                 // 3. Создается объект Integer в куче, создается переменная ii, в которой сохранена ссылка на объект, отравляется в стек main.
        printAll(o, i, ii);             // 4. В стеке создается фрейм под метод printAll с переменной i и 2 ссылками на объекты o и ii в куче.
        System.out.println("finished"); // 7. В стек создается фрейм println, в котором создается ссылка на объект String со значением "finished", объект типа String со значением хранятся в куче.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5. Создается объект Integer в куче, после создается переменная uselessVar, в которую будет сохранена ссылка на объект,
                                                    // переменная uselessVar хранится во фрейм printAll, в стеке
        System.out.println(o.toString() + i + ii);  // 6. В стеке создается фрейм под метод println, и передается ссылка на объект Object (вызов метода
                                                    // .toString создаст отдельный фрейм, который удалится из стека после выполнения), переменная i и еще ссылка на объект integer.
    }                                               // после выхода из метода, из стека будет удален метод printAll.

} // после отработки программы запускается garbage collector, по итогу объекты на которые нет ссылок очистятся из кучи.
