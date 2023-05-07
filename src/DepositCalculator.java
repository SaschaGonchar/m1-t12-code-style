import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args)
    {
        new DepositCalculator().Menu();
    }
double calculateComplexPercent(double depositAmount, double y,int depositTermInYear ) {
       double pay = depositAmount * Math.pow((1 + y/ 12), 12 *depositTermInYear);
       return roundToInteger(pay, 2);
  }
  double calculateSimplePercent(double depositAmount, double doubleYearRate, int depositTermInYear) {
         return roundToInteger(depositAmount+depositAmount * doubleYearRate * depositTermInYear, 2);
  }
  double roundToInteger(double value,int places) {
    double ScaLe= Math.pow(10, places);
    return Math.round(value*ScaLe)/ScaLe;
    }
    void Menu( ) {
      int depositTermInYear;
      int depositType;
      Scanner objScanner = new Scanner(System.in);
      System.out.println("Введите сумму вклада в рублях:") ;
      int depositAmount = objScanner.nextInt();
      System.out.println("Введите срок вклада в годах:") ;
      depositTermInYear = objScanner.nextInt( );
      System.out.println ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
      depositType = objScanner.nextInt();
      double outDoubleVar = 0;
      if (depositType ==1){
          outDoubleVar = calculateSimplePercent(depositAmount, 0.06, depositTermInYear);
      } else if (depositType == 2) {
          outDoubleVar = calculateComplexPercent(depositAmount, 0.06, depositTermInYear);
      }
      System.out.println("Результат вклада: " + depositAmount + " за " + depositTermInYear + " лет превратятся в " + outDoubleVar);
    }
}
