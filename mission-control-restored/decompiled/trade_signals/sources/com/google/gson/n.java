package com.google.gson;

import com.google.gson.internal.x;
import com.google.gson.internal.z;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class n extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16254a;

    public n(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f16254a = bool;
    }

    public static boolean P(n nVar) {
        Object obj = nVar.f16254a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public BigDecimal I() {
        Object obj = this.f16254a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : z.b(h());
    }

    public BigInteger J() {
        Object obj = this.f16254a;
        return obj instanceof BigInteger ? (BigInteger) obj : P(this) ? BigInteger.valueOf(N().longValue()) : z.c(h());
    }

    public double K() {
        return Q() ? N().doubleValue() : Double.parseDouble(h());
    }

    public int L() {
        return Q() ? N().intValue() : Integer.parseInt(h());
    }

    public long M() {
        return Q() ? N().longValue() : Long.parseLong(h());
    }

    public Number N() {
        Object obj = this.f16254a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new x((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean O() {
        return this.f16254a instanceof Boolean;
    }

    public boolean Q() {
        return this.f16254a instanceof Number;
    }

    public boolean R() {
        return this.f16254a instanceof String;
    }

    @Override // com.google.gson.i
    public boolean a() {
        return O() ? ((Boolean) this.f16254a).booleanValue() : Boolean.parseBoolean(h());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f16254a == null) {
            return nVar.f16254a == null;
        }
        if (P(this) && P(nVar)) {
            return ((this.f16254a instanceof BigInteger) || (nVar.f16254a instanceof BigInteger)) ? J().equals(nVar.J()) : N().longValue() == nVar.N().longValue();
        }
        Object obj2 = this.f16254a;
        if (obj2 instanceof Number) {
            Object obj3 = nVar.f16254a;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return I().compareTo(nVar.I()) == 0;
                }
                double dK = K();
                double dK2 = nVar.K();
                if (dK != dK2) {
                    return Double.isNaN(dK) && Double.isNaN(dK2);
                }
                return true;
            }
        }
        return obj2.equals(nVar.f16254a);
    }

    @Override // com.google.gson.i
    public String h() {
        Object obj = this.f16254a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (Q()) {
            return N().toString();
        }
        if (O()) {
            return ((Boolean) this.f16254a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f16254a.getClass());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f16254a == null) {
            return 31;
        }
        if (P(this)) {
            jDoubleToLongBits = N().longValue();
        } else {
            Object obj = this.f16254a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(N().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public n(Number number) {
        Objects.requireNonNull(number);
        this.f16254a = number;
    }

    public n(String str) {
        Objects.requireNonNull(str);
        this.f16254a = str;
    }
}
