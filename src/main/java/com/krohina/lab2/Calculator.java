package com.krohina.lab2;

import java.util.Objects;
import java.util.Stack;

/**
 * Класс обработчика выражения.<br>
 * Реализует функциональность для вычисления значения выражения.
 */
public class Calculator{

    /**
     * Строка, содержащая выражение (скобки, числа, операторы).
     */
    public String expression;

    /**
     * Конструктор класса-обработчика по строке-выражению.
     * @param str строка, содержащая выражение для вычисления
     */
    public Calculator(String str){
        this.expression = str;
    }

    /**
     * Метод для удаления лишних пробелов из выражения.
     */
    private void delSpace()
    {
        StringBuilder newString = new StringBuilder();
        for(int pos = 0; pos < expression.length(); ++pos)
            if (expression.charAt(pos) != ' ')
                newString.append(expression.charAt(pos));
        expression = newString.toString();
    }

    /**
     * Метод проверки корректности заданного выражения.
     * @return Возвращает:<br>
     * <i>True</i> - если выражение составлено корректно<br>
     * <i>False</i> - если выражение составлено с ошибками
     */
    private boolean isCorrect()
    {
        if (expression.isEmpty())
            return false;
        delSpace();
        int cnt_bracket = 0;
        for(int pos = 0; pos < expression.length(); ++pos){
            if(cnt_bracket >= 0){
                switch(expression.charAt(pos)){
                    case '+': case '-': case '*': case '/':{
                        //По краям выражения не может быть знаков операций
                        if(pos == 0 || pos == expression.length() - 1)
                            return false;
                        //Не может быть двух знаков операций идущих подряд
                        else if(expression.charAt(pos + 1) == '+' ||
                                expression.charAt(pos + 1) == '-' ||
                                expression.charAt(pos + 1) == '*' ||
                                expression.charAt(pos + 1) == '/' ||
                                expression.charAt(pos + 1) == ')')
                            return false;
                        break;
                    }
                    case '(':{
                        ++cnt_bracket;
                        //Не может быть пустых скобок, или сочетаний скобки со знаком операции
                        if(expression.charAt(pos + 1) == '+' ||
                                expression.charAt(pos + 1) == '-' ||
                                expression.charAt(pos + 1) == '*' ||
                                expression.charAt(pos + 1) == '/' ||
                                expression.charAt(pos + 1) == ')')
                            return false;
                        else if(pos == expression.length() - 1)
                            return false;
                        break;
                    }
                    case ')':{
                        --cnt_bracket;
                        if(pos == 0)
                            return false;
                        //Аналогично и после закрытой скобки
                        else if(expression.charAt(pos - 1) == '+' ||
                                expression.charAt(pos - 1) == '-' ||
                                expression.charAt(pos-1) == '*' ||
                                expression.charAt(pos-1) == '/' ||
                                expression.charAt(pos-1) == '(' )
                            return false;
                        break;
                    }
                    default:
                        if(expression.charAt(pos) >= '0' && expression.charAt(pos) <= '9'){
                            if(pos != 0)
                                if(expression.charAt(pos - 1) == ')' )
                                    //перед цифрой не может быть закрывающей скобки
                                    return false;
                            if(pos != expression.length() - 1)
                                if(expression.charAt(pos + 1) == '(' )
                                    //после цифры не может быть открывающей скобки
                                    return false;
                        }
                        else
                            //когда это неизвестный знак
                            return false;
                }
            }
            else
                //если cnt_bracket < 0 то дисбаланс по скобкам
                return false;
        }
        // остается проверить баланс по скобкам
        return cnt_bracket == 0;
    }

    /**
     * Метод определяющий вычислительный приоритет оператора.
     * @param ch проверяемый символ (оператор или скобка).
     * @return Возвращает приоритет проверяемого символа.
     */
    private int priorityOf(char ch){
        if(ch == '*' || ch == '/')
            return 3;
        else if(ch == '+' || ch == '-')
            return 2;
        else if(ch == '(')
            return 1;
        else if(ch == ')')
            return -1;
        return 0;
    }

    /**
     * Метод преобразования выражения в постфиксную форму.<br>
     * Необходим для последующего удобного вычисления значения выражения.
     * @return Возвращает:<br>
     * <i>True</i> - если выражение может быть преобразовано<br>
     * <i>False</i> - в иных случаях
     */
    private boolean toPostfixNotation(){

        if (!isCorrect() || expression.isEmpty())
            return false;
        Stack<Character> charStack = new Stack<>();
        StringBuilder newString = new StringBuilder();

        for(int pos = 0; pos < expression.length(); ++pos){
            int typeOper = priorityOf(expression.charAt(pos));

            //обычный символ
            if (typeOper == 0)
                newString.append(expression.charAt(pos));

            //открывающая скобка
            else if (typeOper == 1)
                charStack.push(expression.charAt(pos));

            //знак операции
            else if (typeOper > 1){
                newString.append(' ');
                while (!charStack.empty()) {
                    if (priorityOf(charStack.peek()) >= typeOper)
                        newString.append(charStack.pop());
                    else
                        break;
                }
                charStack.push(expression.charAt(pos));
            }

            //закрывающая скобка
            else if (typeOper == -1) {
                newString.append(' ');
                while (priorityOf(charStack.peek()) != 1)
                    newString.append(charStack.pop());
                charStack.pop();
            }
        }
        //сбрасывание остатка стека
        while (!charStack.empty())
            newString.append(charStack.pop());
        expression = newString.toString();
        return true;
    }

    /**
     * Метод вычисления значения выражения.<br>
     * Результат вычисления записывает в строковое поле <b>expression</b>, в котором хранилась строка-выражение.
     * @return Возвращает:<br>
     * <i>True</i> - если выражение было вычислено<br>
     * <i>False</i> - если оно было заданно некорректно
     */
    public boolean calculate(){

        boolean goodPostNot = toPostfixNotation();
        if (!goodPostNot)
            return false;

        StringBuilder res = new StringBuilder();
        Stack<Double> st = new Stack<>();

        for(int pos = 0; pos < expression.length(); ++pos){
            if (expression.charAt(pos) == ' ')
                continue;
            if (priorityOf(expression.charAt(pos)) == 0){
                while(expression.charAt(pos) != ' ' && priorityOf(expression.charAt(pos)) == 0){
                    res.append(expression.charAt(pos++));
                    if (pos == expression.length())
                        break;
                }
                st.push(Double.parseDouble(res.toString()));
                res = new StringBuilder();
            }
            if (priorityOf(expression.charAt(pos)) > 1){
                double num1 = st.pop();
                double num2 = st.pop();

                if (expression.charAt(pos) == '+')
                    st.push(num2 + num1);

                if (expression.charAt(pos) == '-')
                    st.push(num2 - num1);

                if (expression.charAt(pos) == '*')
                    st.push(num2 * num1);

                if (expression.charAt(pos) == '/')
                    st.push(num2 / num1);
            }
        }
        expression = Double.toString(st.pop());
        return true;
    }

    /**
     * Метод преобразования выражения к строке.
     * @return Возвращает строку-выражение, содержащееся в поле класса.
     */
    @Override
    public String toString(){
        return expression;
    }

    /**
     * Метод глубокого сравнения классов-обработчиков.
     * @param obj объект для сравнения.
     * @return Возвращает:<br>
     * <i>True</i> - если объекты соответствуют друг другу по полям и содержимому<br>
     * <i>False</i> - в ином случае
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Calculator that = (Calculator) obj;
        return Objects.equals(expression, that.expression);
    }

    /**
     * Метод подсчета хеш-кода.
     * @return Возвращает целочисленное значение соответсвующее хеш-коду строки-выражения.
     */
    @Override
    public int hashCode(){
        return Objects.hash(expression);
    }

}
