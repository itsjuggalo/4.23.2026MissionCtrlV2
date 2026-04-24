package com.amazon.device.iap.model;

/* JADX INFO: loaded from: classes.dex */
public final class CoinsReward {
    private final int amount;

    public CoinsReward(int i7) {
        this.amount = i7;
    }

    public static final CoinsReward from(int i7) {
        if (i7 > 0) {
            return new CoinsReward(i7);
        }
        return null;
    }

    public int getAmount() {
        return this.amount;
    }
}
