package ru.avalon.devj_110;

public class Main {

    private static final double ACCURACY = 1e-5;

    public static void main(String[] args) {
        final Dichotomy dichotomy = new Dichotomy();
        final FunctionImpl function = new FunctionImpl();

        //реализация функционального интерфейса с помощью вложенного класса
        System.out.println(dichotomy.dichotomyMethod(function, 0.01, 2, ACCURACY));

        //реализация функционального интерфейса с помощью анонимного класса
        System.out.println(dichotomy.dichotomyMethod(new IFunction() {
            @Override
            public double func(double value) {
                return Math.sin(value) - 0.75;
            }
        }, 2, 3, ACCURACY));

        //реализация функционального интерфейса с помощью ссылки на статический метод
        System.out.println(dichotomy.dichotomyMethod(FunctionImpl::logFunc, 1, 3, ACCURACY));

        //реализация функционального интерфейса с помощью ссылки на метод экземпляра
        System.out.println(dichotomy.dichotomyMethod(function::tangFunc, 2, 4, ACCURACY));

        //реализация функционального интерфейса с помощью лямбда-выражения
        System.out.println(dichotomy.dichotomyMethod(e -> Math.pow(e, 3) - 8 * e + 2, 1, 5, ACCURACY));
    }

    private static class FunctionImpl implements IFunction {

        private static double logFunc(double value) {
            return Math.log(Math.pow(value, 3)) - 2;
        }

        private  double tangFunc(double value) {
            return Math.tan(value);
        }

        @Override
        public double func(double value) {
            return Math.exp(- value) - 0.5;
        }

    }

}
