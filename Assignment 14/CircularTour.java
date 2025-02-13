class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalPetrol = 0, totalDistance = 0, start = 0, currSurplus = 0;

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currSurplus += petrol[i] - distance[i];

            if (currSurplus < 0) {
                start = i + 1;
                currSurplus = 0;
            }
        }
        return (totalPetrol >= totalDistance) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPoint(petrol, distance);
        System.out.println(startIndex);
    }
}
