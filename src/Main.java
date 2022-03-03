/**
 * @author Stanislav Rakitov in 2022
 */
public class Main {
  public static void main(String[] args) {
    Calculator calc = Calculator.instance.get();
    int a = calc.plus.apply(1, 2);
    int b = calc.minus.apply(1, 1);

    // При выполнении этого блока кода будет вызвано прерывание
    // Деление на ноль. Так как переменная b на текущий момент имеет значение 0
    // int c = calc.devide.apply(a, b);

    // Способы решения:
    // 1 вызывать через try/catch
    try {
      int c = calc.devide.apply(a, b);
      calc.println.accept(c);
    } catch (ArithmeticException e) {
      System.out.println("Арифметическая ошибка. Возможно деление на ноль.");
    }

    // Второй способ
    int c = calc.devide.apply(a, b != 0 ? b : -1);
    calc.println.accept(c);

    // Но надо понимать изначальную бизнес задачу.
    // И возможно выбрасывание исключения будет правильным вариантом.

  }
}
