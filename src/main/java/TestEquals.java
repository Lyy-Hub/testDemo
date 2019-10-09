public class testEquals {
        public static void main(String[] args) {
            Cat c1 = new Cat (1,2,3);
            Cat c2 = new Cat (1,2,3);
            System.out.println(c1==c2);
            System.out.println(c1.equals(c2));

        }
    }
    class Cat{
        int color ;
        int height ;
        int weight ;

        public Cat(int color, int height, int weight){
            this.color = color ;
            this.height = height ;
            this.weight = weight ;
        }

        public boolean equals(Object obj){
            if (obj == null) return false ;
            else{
                if (obj instanceof Cat){
                    Cat c = (Cat) obj;
                    if(c.color== this.color && c.height == this.height && c.weight == this.weight){
                        return true ;
                    }
                }
            }
            return false ;
        }
}
