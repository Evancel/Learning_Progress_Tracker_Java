class Sum {
    public static int sumOfAreas(Shape[] array) {
        // write your code here
        int sum = 0;
        for(Shape shape : array){
            int area = 0;
            if(shape instanceof Square sqr){
                area = (int) Math.pow(sqr.getSide(),2);
            }else if(shape instanceof Rectangle rct){
                area = rct.getHeight() * rct.getWidth();
            }
            sum += area;
        }
        return sum;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}