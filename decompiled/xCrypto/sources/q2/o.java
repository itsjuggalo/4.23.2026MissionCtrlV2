package q2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import s2.AbstractC1768A;
import s2.y;

/* JADX INFO: loaded from: classes.dex */
public final class o extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14273a;

    public o(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f14273a = bool;
    }

    public static boolean x(o oVar) {
        Object obj = oVar.f14273a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // q2.j
    public boolean c() {
        return w() ? ((Boolean) this.f14273a).booleanValue() : Boolean.parseBoolean(l());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f14273a == null) {
            return oVar.f14273a == null;
        }
        if (x(this) && x(oVar)) {
            return ((this.f14273a instanceof BigInteger) || (oVar.f14273a instanceof BigInteger)) ? r().equals(oVar.r()) : v().longValue() == oVar.v().longValue();
        }
        Object obj2 = this.f14273a;
        if (obj2 instanceof Number) {
            Object obj3 = oVar.f14273a;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return q().compareTo(oVar.q()) == 0;
                }
                double dS = s();
                double dS2 = oVar.s();
                return dS == dS2 || (Double.isNaN(dS) && Double.isNaN(dS2));
            }
        }
        return obj2.equals(oVar.f14273a);
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f14273a == null) {
            return 31;
        }
        if (x(this)) {
            jDoubleToLongBits = v().longValue();
        } else {
            Object obj = this.f14273a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(v().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    @Override // q2.j
    public String l() {
        Object obj = this.f14273a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (y()) {
            return v().toString();
        }
        if (w()) {
            return ((Boolean) this.f14273a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f14273a.getClass());
    }

    public BigDecimal q() {
        Object obj = this.f14273a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : AbstractC1768A.b(l());
    }

    public BigInteger r() {
        Object obj = this.f14273a;
        return obj instanceof BigInteger ? (BigInteger) obj : x(this) ? BigInteger.valueOf(v().longValue()) : AbstractC1768A.c(l());
    }

    public double s() {
        return y() ? v().doubleValue() : Double.parseDouble(l());
    }

    public int t() {
        return y() ? v().intValue() : Integer.parseInt(l());
    }

    public long u() {
        return y() ? v().longValue() : Long.parseLong(l());
    }

    public Number v() {
        Object obj = this.f14273a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new y((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean w() {
        return this.f14273a instanceof Boolean;
    }

    public boolean y() {
        return this.f14273a instanceof Number;
    }

    public boolean z() {
        return this.f14273a instanceof String;
    }

    public o(Number number) {
        Objects.requireNonNull(number);
        this.f14273a = number;
    }

    public o(String str) {
        Objects.requireNonNull(str);
        this.f14273a = str;
    }
}
