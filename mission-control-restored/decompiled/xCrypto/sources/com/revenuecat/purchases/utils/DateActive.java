package com.revenuecat.purchases.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class DateActive {
    private final boolean inGracePeriod;
    private final boolean isActive;

    public DateActive(boolean z4, boolean z5) {
        this.isActive = z4;
        this.inGracePeriod = z5;
    }

    public static /* synthetic */ DateActive copy$default(DateActive dateActive, boolean z4, boolean z5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = dateActive.isActive;
        }
        if ((i4 & 2) != 0) {
            z5 = dateActive.inGracePeriod;
        }
        return dateActive.copy(z4, z5);
    }

    public final boolean component1() {
        return this.isActive;
    }

    public final boolean component2() {
        return this.inGracePeriod;
    }

    public final DateActive copy(boolean z4, boolean z5) {
        return new DateActive(z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateActive)) {
            return false;
        }
        DateActive dateActive = (DateActive) obj;
        return this.isActive == dateActive.isActive && this.inGracePeriod == dateActive.inGracePeriod;
    }

    public final boolean getInGracePeriod() {
        return this.inGracePeriod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z4 = this.isActive;
        ?? r02 = z4;
        if (z4) {
            r02 = 1;
        }
        int i4 = r02 * 31;
        boolean z5 = this.inGracePeriod;
        return i4 + (z5 ? 1 : z5);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        return "DateActive(isActive=" + this.isActive + ", inGracePeriod=" + this.inGracePeriod + ')';
    }
}
