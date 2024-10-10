public class Park {
    public static class Attraction {
        private String name;
        private String time;
        private double cost;

        public Attraction(String name, String time, double cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

        public void infoPark() {
            System.out.println("Название аттракциона: " + name + "; Время работы: " + time +
                    "; Стоимость: " + cost);        }

    }



}
