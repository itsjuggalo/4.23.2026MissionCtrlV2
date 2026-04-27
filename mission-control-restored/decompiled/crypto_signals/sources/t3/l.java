package t3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class l extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Serializable f10249a;

    public l(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f10249a = bool;
    }

    public static boolean l(l lVar) {
        Serializable serializable = lVar.f10249a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // t3.h
    public final boolean a() {
        Serializable serializable = this.f10249a;
        return serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(c());
    }

    @Override // t3.h
    public final String c() {
        Serializable serializable = this.f10249a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return k().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        Serializable serializable = this.f10249a;
        Serializable serializable2 = lVar.f10249a;
        if (serializable == null) {
            return serializable2 == null;
        }
        if (l(this) && l(lVar)) {
            return ((serializable instanceof BigInteger) || (serializable2 instanceof BigInteger)) ? f().equals(lVar.f()) : k().longValue() == lVar.k().longValue();
        }
        if (!(serializable instanceof Number) || !(serializable2 instanceof Number)) {
            return serializable.equals(serializable2);
        }
        if ((serializable instanceof BigDecimal) && (serializable2 instanceof BigDecimal)) {
            return (serializable instanceof BigDecimal ? (BigDecimal) serializable : v3.d.j(c())).compareTo(serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : v3.d.j(lVar.c())) == 0;
        }
        double dH = h();
        double dH2 = lVar.h();
        if (dH != dH2) {
            return Double.isNaN(dH) && Double.isNaN(dH2);
        }
        return true;
    }

    public final BigInteger f() {
        Serializable serializable = this.f10249a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (l(this)) {
            return BigInteger.valueOf(k().longValue());
        }
        String strC = c();
        v3.d.d(strC);
        return new BigInteger(strC);
    }

    public final double h() {
        return this.f10249a instanceof Number ? k().doubleValue() : Double.parseDouble(c());
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        Serializable serializable = this.f10249a;
        if (serializable == null) {
            return 31;
        }
        if (l(this)) {
            jDoubleToLongBits = k().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(k().doubleValue());
        }
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public final Number k() {
        Serializable serializable = this.f10249a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new v3.i((String) serializable);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public l(Number number) {
        Objects.requireNonNull(number);
        this.f10249a = number;
    }

    public l(String str) {
        Objects.requireNonNull(str);
        this.f10249a = str;
    }
}
