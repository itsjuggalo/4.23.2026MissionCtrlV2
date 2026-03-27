package s2;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class y extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14652a;

    public y(String str) {
        this.f14652a = str;
    }

    public final BigDecimal a() {
        return AbstractC1768A.b(this.f14652a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f14652a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.f14652a.equals(((y) obj).f14652a);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f14652a);
    }

    public int hashCode() {
        return this.f14652a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f14652a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f14652a);
            }
        } catch (NumberFormatException unused2) {
            return a().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f14652a);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f14652a;
    }
}
