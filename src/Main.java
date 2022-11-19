import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CRC32;

/**
 * Пример использования классов Adler32 и CRC32
 * */
public class Main {
    private static File file;

    /**
     * Функция для проверки аргументов командной строки
     * @param args аргументы командной строки
     * @return true, если мы корректно передали неообходимые аргументы, и false в противном случае
     * */
    private static boolean checkArgs(String[] args) {
        /*Проверяем что программе передан путь к файлу*/
        if (args.length == 0) {
            System.out.println("Введите путь до файла: ");
            return false;
        }

        String fileName = args[0];
        file = new File(fileName);

        /*Проверяем наличие файла на диске*/
        if (!file.exists()) {
            System.out.println("Данного файла не существует");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        /*Проверяем аргументы командной строки*/
        if (checkArgs(args)) {
            /*Создаем объект класса CRC32*/
            CRC32 crc32 = new CRC32();
            /*Создаем объект класса Adler32*/
            Adler32 adler32 = new Adler32();

            byte[] buffer = new byte[1024];
            int countBytes = 0;

            try (FileInputStream in = new FileInputStream(file)) {
                /*читаем байты из файла*/
                while ((countBytes = in.read(buffer)) != -1) {
                    /*обнавляем контрольную сумму у объектов*/
                    crc32.update(buffer, 0, countBytes);
                    adler32.update(buffer, 0, countBytes);
                }
            } catch (IOException ignore) {}

            /*Выводим контрольные суммы на экран*/
            System.out.println("CheckSum: " + crc32.getValue() + "(CRC32)");
            System.out.println("CheckSum: " + adler32.getValue() + "(Adler32)");
        }
    }
}
