package n4;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class y extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19681a;

    public y(String str) {
        this.f19681a = str;
    }

    public final BigDecimal a() {
        return AbstractC2256A.b(this.f19681a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f19681a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.f19681a.equals(((y) obj).f19681a);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f19681a);
    }

    public int hashCode() {
        return this.f19681a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f19681a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f19681a);
            }
        } catch (NumberFormatException unused2) {
            return a().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f19681a);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f19681a;
    }
}
