package ru.zotov.utils.calculator;

@FunctionalInterface
public interface ICalculatorSimulation  {

   /**
    * У каждого может быть своя реализация ICalculator.
    * Например, в моем варианте при делениее числа на нуль результат Infinity, что считаю приемлемым;
    * @param calculator instanceof ICalculator
    */
   void startSimulation(ICalculator calculator);

}
