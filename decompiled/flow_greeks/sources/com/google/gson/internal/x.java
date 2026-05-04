package com.google.gson.internal;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6849a;

    public x(String str) {
        this.f6849a = str;
    }

    public final BigDecimal a() {
        return z.b(this.f6849a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f6849a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f6849a.equals(((x) obj).f6849a);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f6849a);
    }

    public int hashCode() {
        return this.f6849a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f6849a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f6849a);
            }
        } catch (NumberFormatException unused2) {
            return a().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f6849a);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f6849a;
    }
}
