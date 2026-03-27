package com.google.gson.internal;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public final class x extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16225a;

    public x(String str) {
        this.f16225a = str;
    }

    public final BigDecimal a() {
        return z.b(this.f16225a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f16225a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f16225a.equals(((x) obj).f16225a);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f16225a);
    }

    public int hashCode() {
        return this.f16225a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f16225a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f16225a);
            }
        } catch (NumberFormatException unused2) {
            return a().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f16225a);
        } catch (NumberFormatException unused) {
            return a().longValue();
        }
    }

    public String toString() {
        return this.f16225a;
    }
}
