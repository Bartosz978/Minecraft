package org.example.Texture;

public enum BLOCK {
    GRASS (0),STONE (1),WOOD(2),LEAVES(3);
    private int index;

    BLOCK(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }
}
