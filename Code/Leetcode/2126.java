class AsteroidsDestroyed {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long summingMass = mass;
        
        for (int item: asteroids) {
            if (summingMass >= item) {
                summingMass += item;
            }
            
            else {
                return false;
            }
        }
        
        return true;
    }
