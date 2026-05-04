package com.google.gson;

import com.google.gson.internal.x;
import com.google.gson.internal.z;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6878a;

    public n(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f6878a = bool;
    }

    public static boolean K(n nVar) {
        Object obj = nVar.f6878a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public Number A() {
        Object obj = this.f6878a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new x((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean G() {
        return this.f6878a instanceof Boolean;
    }

    public boolean L() {
        return this.f6878a instanceof Number;
    }

    public boolean R() {
        return this.f6878a instanceof String;
    }

    @Override // com.google.gson.i
    public boolean a() {
        return G() ? ((Boolean) this.f6878a).booleanValue() : Boolean.parseBoolean(f());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f6878a == null) {
            return nVar.f6878a == null;
        }
        if (K(this) && K(nVar)) {
            return ((this.f6878a instanceof BigInteger) || (nVar.f6878a instanceof BigInteger)) ? u().equals(nVar.u()) : A().longValue() == nVar.A().longValue();
        }
        Object obj2 = this.f6878a;
        if (obj2 instanceof Number) {
            Object obj3 = nVar.f6878a;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return s().compareTo(nVar.s()) == 0;
                }
                double dV = v();
                double dV2 = nVar.v();
                return dV == dV2 || (Double.isNaN(dV) && Double.isNaN(dV2));
            }
        }
        return obj2.equals(nVar.f6878a);
    }

    @Override // com.google.gson.i
    public String f() {
        Object obj = this.f6878a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (L()) {
            return A().toString();
        }
        if (G()) {
            return ((Boolean) this.f6878a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f6878a.getClass());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f6878a == null) {
            return 31;
        }
        if (K(this)) {
            jDoubleToLongBits = A().longValue();
        } else {
            Object obj = this.f6878a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(A().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public BigDecimal s() {
        Object obj = this.f6878a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : z.b(f());
    }

    public BigInteger u() {
        Object obj = this.f6878a;
        return obj instanceof BigInteger ? (BigInteger) obj : K(this) ? BigInteger.valueOf(A().longValue()) : z.c(f());
    }

    public double v() {
        return L() ? A().doubleValue() : Double.parseDouble(f());
    }

    public int w() {
        return L() ? A().intValue() : Integer.parseInt(f());
    }

    public long y() {
        return L() ? A().longValue() : Long.parseLong(f());
    }

    public n(Number number) {
        Objects.requireNonNull(number);
        this.f6878a = number;
    }

    public n(String str) {
        Objects.requireNonNull(str);
        this.f6878a = str;
    }
}
