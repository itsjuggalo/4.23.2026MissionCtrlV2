package com.amazon.device.iap.model;

/* JADX INFO: loaded from: classes.dex */
public final class CoinsReward {
    private final int amount;

    public CoinsReward(int i4) {
        this.amount = i4;
    }

    public static final CoinsReward from(int i4) {
        if (i4 > 0) {
            return new CoinsReward(i4);
        }
        return null;
    }

    public int getAmount() {
        return this.amount;
    }
}
