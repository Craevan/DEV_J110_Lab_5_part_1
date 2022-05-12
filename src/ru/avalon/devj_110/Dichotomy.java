package ru.avalon.devj_110;


public class Dichotomy {

    double dichotomyMethod(IFunction function, double leftBorder, double rightBorder, double accuracy) {
        while ((rightBorder - leftBorder) > accuracy) {
            double point = (leftBorder + rightBorder) / 2;
            if(function.func(point) == 0)
                return point;
            if(function.func(leftBorder) < 0 && function.func(point) < 0
                    || function.func(leftBorder) > 0 && function.func(point) > 0)
                leftBorder = point;
            else if(function.func(point) < 0 && function.func(rightBorder) < 0
                    || function.func(point) > 0 && function.func(rightBorder) > 0)
                rightBorder = point;
        }
        return leftBorder;
    }

}
