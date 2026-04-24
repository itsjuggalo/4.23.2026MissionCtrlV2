package l4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import n4.AbstractC2256A;
import n4.y;

/* JADX INFO: loaded from: classes.dex */
public final class o extends AbstractC2177j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18381a;

    public o(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f18381a = bool;
    }

    public static boolean w(o oVar) {
        Object obj = oVar.f18381a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // l4.AbstractC2177j
    public boolean a() {
        return u() ? ((Boolean) this.f18381a).booleanValue() : Boolean.parseBoolean(h());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f18381a == null) {
            return oVar.f18381a == null;
        }
        if (w(this) && w(oVar)) {
            return ((this.f18381a instanceof BigInteger) || (oVar.f18381a instanceof BigInteger)) ? p().equals(oVar.p()) : t().longValue() == oVar.t().longValue();
        }
        Object obj2 = this.f18381a;
        if (obj2 instanceof Number) {
            Object obj3 = oVar.f18381a;
            if (obj3 instanceof Number) {
                if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                    return n().compareTo(oVar.n()) == 0;
                }
                double dQ = q();
                double dQ2 = oVar.q();
                if (dQ != dQ2) {
                    return Double.isNaN(dQ) && Double.isNaN(dQ2);
                }
                return true;
            }
        }
        return obj2.equals(oVar.f18381a);
    }

    @Override // l4.AbstractC2177j
    public String h() {
        Object obj = this.f18381a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (x()) {
            return t().toString();
        }
        if (u()) {
            return ((Boolean) this.f18381a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f18381a.getClass());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f18381a == null) {
            return 31;
        }
        if (w(this)) {
            jDoubleToLongBits = t().longValue();
        } else {
            Object obj = this.f18381a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(t().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public BigDecimal n() {
        Object obj = this.f18381a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : AbstractC2256A.b(h());
    }

    public BigInteger p() {
        Object obj = this.f18381a;
        return obj instanceof BigInteger ? (BigInteger) obj : w(this) ? BigInteger.valueOf(t().longValue()) : AbstractC2256A.c(h());
    }

    public double q() {
        return x() ? t().doubleValue() : Double.parseDouble(h());
    }

    public int r() {
        return x() ? t().intValue() : Integer.parseInt(h());
    }

    public long s() {
        return x() ? t().longValue() : Long.parseLong(h());
    }

    public Number t() {
        Object obj = this.f18381a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new y((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean u() {
        return this.f18381a instanceof Boolean;
    }

    public boolean x() {
        return this.f18381a instanceof Number;
    }

    public boolean y() {
        return this.f18381a instanceof String;
    }

    public o(Number number) {
        Objects.requireNonNull(number);
        this.f18381a = number;
    }

    public o(String str) {
        Objects.requireNonNull(str);
        this.f18381a = str;
    }
}
