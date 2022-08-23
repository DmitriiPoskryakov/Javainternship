public class Expression<T> implements Calculator<T> {

    public T addition(T vol1, T vol2) {
        String sumStr;
        Integer sumInt;
        Double sumDouble;
        if (vol1 instanceof String && vol2 instanceof String) {
            sumStr = (String) vol1 + (String) vol2;
            return (T) sumStr;
        }
        if (vol1 instanceof Integer && vol2 instanceof Integer) {
            sumInt = (Integer) vol1 + (Integer) vol2;
            return (T) sumInt;
        }
        if (vol1 instanceof Double && vol2 instanceof Double) {
            sumDouble = (Double) vol1 + (Double) vol2;
            return (T) sumDouble;
        }
        return vol1;
    }


}
