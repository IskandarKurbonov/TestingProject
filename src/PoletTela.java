/**
 * Класс для вычисления полёта тела
 * @author Iskandar Kurbonov
 * @version 1.0
 */

/** Импорт статической библиотеки*/
import static java.lang.Math.*;

/** Публичный класс */
public class PoletTela {
    public static void main(String[] args) {
        /** Скорость свободного падения */
        final double g = 9.8;
        /** Угол к горизонту в градусах */
        double alpha = 30;
        /** Масса тела (в кг) */
        double m = 0.1;
        /** Коэффициент сопротивления воздуха (Н*с/м) */
        double gamma = 0.1;
        /** Скорость тела (м/с) */
        double V = 100.0;
        /** Время */
        double t = 1.0;
        /** Координаты тела */
        double x,y;
        /** Перевод градусов в радианы */
        alpha/=180/PI;
        /** Вычисление координат: */
        x = V*m*cos(alpha)/gamma*(1-exp(-gamma*t/m));
        y = m*(V*sin(alpha)*gamma+m*g)/gamma/gamma*
                (1-exp(-gamma*t/m))-m*g*t/gamma;
        /** Вывод информации */
        System.out.println(
                "Координаты тела для t="+t+" сек:\n x="+x+
                        "м\ny=" +y+ "м"
        );
        System.out.println("Параметры:");
        System.out.println("Угол alpha=" +alpha/PI*180+" градусов"
        );
        System.out.println("Скорость V=" +V+ " м/с");
        System.out.println("Коэффициент сопротивления gamma=" +gamma+ "Н*с/м");
        System.out.println("Масса тела " +m+ " кг");

    }
}
