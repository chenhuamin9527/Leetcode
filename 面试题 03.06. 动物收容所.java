class AnimalShelf {

    LinkedList<int[]> queueCat;
    LinkedList<int[]> queueDog;

    public AnimalShelf() {
        queueCat = new LinkedList<>();
        queueDog = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        // 判断种类后入队
        if (animal[1] == 0) {
            queueCat.addLast(animal);
        } else if (animal[1] == 1) {
            queueDog.addLast(animal);
        }
    }

    // 挑选所有动物中最老的
    public int[] dequeueAny() {
        // 取出cat的队首，判空则直接返回
        int[] headCat;
        if (!queueCat.isEmpty()) {
            headCat = queueCat.getFirst();
        } else if (!queueDog.isEmpty()) {
            // 当猫队列无猫时，直接将狗队列的第一个出队
            return queueDog.removeFirst();
        } else {
            // 代表猫狗队列中无任何猫狗
            return new int[] { -1, -1 };
        }
        // 取出dog的队首，判空则直接返回
        int[] headDog;
        if (!queueDog.isEmpty()) {
            headDog = queueDog.getFirst();
        } else {
            // 当狗队列无狗时，直接将猫队列的第一个出队
            return queueCat.removeFirst();
        }
        // 当同时都有猫狗时 比较后返回 判断猫狗中谁比较老
        if (headCat[0] <= headDog[0]) {
            return queueCat.removeFirst();
        } else {
            return queueDog.removeFirst();
        }
    }

    // 挑选狗
    public int[] dequeueDog() {
        if (!queueDog.isEmpty()) {
            return queueDog.removeFirst();
        } else {
            return new int[] { -1, -1 };
        }
    }

    // 挑选猫
    public int[] dequeueCat() {
        if (!queueCat.isEmpty()) {
            return queueCat.removeFirst();
        } else {
            return new int[] { -1, -1 };
        }
    }
}
