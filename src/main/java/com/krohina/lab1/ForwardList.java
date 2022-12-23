package com.krohina.lab1;

/**
 * Класс односвязного списка.<br>
 * Реализует структуру данных "односвязный (однонаправленный) список".
 * @param <T> тип данных, определяющих элементы в списке.
 */
public class ForwardList<T>{
    /**
     * Класс узла односвязного списка.<br>
     * Представляет собой промежуточное звено списка, с хранимым внутри соответствующим этому звену элементом.
     * @param <T> тип данных, определяющий элементы в списке.
     */
    private class Node<T>{
        /**
         * Атрибут, хранящий значение текущего элемента списка.
         */
        private T data;
        /**
         * Атрибут, хранящий указатель на следующий узел списка.
         */
        private Node<T> next;

        /**
         * Конструктор узла списка без параметров.<br>
         * По умолчанию заполняет содержимое звена как <i>null</i>>
         */
        public Node(){
            this.data = null;
            this.next = null;
        }
        /**
         * Конструктор узла списка по хранимым данным.<br>
         * Записывает в соответсвующее звено переданные данные.<br>
         * Указатель на следующее звено определяет как <i>null</i>.
         * @param NewData данные для записи в узел.
         */
        public Node(T NewData){
            this.data = NewData;
            this.next = null;
        }
        /**
         * Конструктор узла списка по хранимым данным и указателю на следующий элемент.<br>
         * Заполняет соответствующие атрибуты звена переданными значениями.
         * @param NewData данные для записи в узел.
         * @param NewNext указатель на следующий узел, после заданного.
         */
        public Node(T NewData, Node<T> NewNext){
            this.data = NewData;
            this.next = NewNext;
        }

        /**
         * Переопределение глубокого сравнения от Object по полям узла.
         * @param obj объект для сравнения.
         * @return Возвращает:<br>
         * <i>True</i> если составляющие узлов были равны<br>
         * <i>False</i> в случаях если объекты сравнения были разного типа, или содержимое полей не совпало.
         */
        @Override
        public boolean equals(Object obj){
            if(obj == this)
                return true;
            if(obj.getClass() != this.getClass())
                return false;
            Node<T> tmp = (Node<T>)obj;
            return this.data.equals(tmp.data) &&
                    ((this.next == null && tmp.next == null) || this.next.equals(tmp.next));
        }
    }

    /**
     * Атрибут, содержащий указатель на первый (head) элемент списка.
     */
    private Node<T> head;
    /**
     * Атрибут, содержащий количество элементов, хранимых в списке.
     */
    private int size;

    /**
     * Конструктор списка без параметров.<br>
     * Устанавливает стартовые настройки:<br>
     * -первый элемент списка = <i>null</i><br>
     * -количество элементов = <i>0</i>
     */
    public ForwardList(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Метод вставки элемента в голову списка (перед первым до этого момента элементом)
     * @param value значение, которое будет храниться в новом головном узле.
     */
    public void push(T value){
        this.head = new Node<T>(value, this.head);
        this.size += 1;
    }
    /**
     * Метод удаления первого элемента списка.
     * @return Возвращает:<br>
     * <i>True</i> если операция выполнена успешно.<br>
     * <i>False</i> в случае если список был пуст.
     */
    public boolean pop(){
        if(this.size == 0) {
            return false;
        }
        this.head = this.head.next;
        this.size -= 1;
        return true;
    }

    /**
     * Метод для получения значения первого узла в списке.
     * @return Возвращает значение элемента, если он существует.
     * @throws IndexOutOfBoundsException в случае если список был пуст.
     */
    public final T front() throws IndexOutOfBoundsException{
        if(this.size == 0) {
            throw new IndexOutOfBoundsException("Cont was empty");
        }
        return this.head.data;
    }

    /**
     * Метод получения размера списка (количества хранимых элементов).
     * @return Возвращает количество элементов, хранимое в атрибуте size.
     */
    public int size(){
        return this.size;
    }

    /**
     * Метод удаления содержимого списка.
     */
    public void clear(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Метод приведения списка к строковому представлению.<br>
     * @return Возвращает строку вида: [val_1, val_2, val_2]<br>
     * где <i>val_1, val_2, val_3, ...</i> - элементы, хранящиеся в списке.
     */
    @Override
    public String toString(){
        String str = "[";
        Node<T> cur = this.head;
        boolean first = true;
        while(cur != null) {
            if(!first){
                str += ", ";
            }
            str += cur.data.toString();
            first = false;
            cur = cur.next;
        }
        str += ']';
        return str;
    }

    /**
     * Метод глубокого сравнения двух списков.<br>
     * @param obj объект, с которым сравнивается текущий список.
     * @return Возвращает:<br>
     * <i>True</i> если списки равны как по элементам, так и по их количеству<br>
     * <i>False</i> в случаях если объекты сравнения были разного типа, условие для <i>True</i> не выполнено.
     */
    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(!obj.getClass().equals(this.getClass()))
            return false;
        if(((ForwardList<T>)obj).size != this.size)
            return false;
        Node<T> obj_cur = ((ForwardList<T>)obj).head;
        Node<T> this_cur = this.head;
        boolean good = true;
        while(good && obj_cur != null && this_cur != null){
            good = obj_cur.equals(this_cur);
            obj_cur = obj_cur.next;
            this_cur = this_cur.next;
        }
        good = obj_cur == null && this_cur == null;
        return good;
    }
}
