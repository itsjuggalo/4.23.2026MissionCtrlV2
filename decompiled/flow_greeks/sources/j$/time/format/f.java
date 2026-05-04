package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f13639g;

    @Override // j$.time.format.h, j$.time.format.e
    public final int A(p pVar, CharSequence charSequence, int i10) {
        boolean z10 = pVar.f13674c;
        DateTimeFormatter dateTimeFormatter = pVar.f13672a;
        int i11 = (z10 || a(pVar)) ? this.f13645b : 0;
        int i12 = (pVar.f13674c || a(pVar)) ? this.f13646c : 9;
        int length = charSequence.length();
        if (i10 != length) {
            if (this.f13639g) {
                char cCharAt = charSequence.charAt(i10);
                dateTimeFormatter.f13630c.getClass();
                if (cCharAt == '.') {
                    i10++;
                } else if (i11 > 0) {
                    return ~i10;
                }
            }
            int i13 = i10;
            int i14 = i11 + i13;
            if (i14 > length) {
                return ~i13;
            }
            int iMin = Math.min(i12 + i13, length);
            int i15 = 0;
            int i16 = i13;
            while (true) {
                if (i16 >= iMin) {
                    break;
                }
                int i17 = i16 + 1;
                char cCharAt2 = charSequence.charAt(i16);
                dateTimeFormatter.f13630c.getClass();
                int i18 = cCharAt2 - '0';
                if (i18 < 0 || i18 > 9) {
                    i18 = -1;
                }
                if (i18 >= 0) {
                    i15 = (i15 * 10) + i18;
                    i16 = i17;
                } else if (i17 < i14) {
                    return ~i13;
                }
            }
            BigDecimal bigDecimalMovePointLeft = new BigDecimal(i15).movePointLeft(i16 - i13);
            j$.time.temporal.u uVarI = this.f13644a.I();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(uVarI.f13760a);
            return pVar.f(this.f13644a, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(uVarI.f13763d).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i13, i16);
        }
        if (i11 > 0) {
            return ~i10;
        }
        return i10;
    }

    @Override // j$.time.format.h
    public final boolean a(p pVar) {
        return pVar.f13674c && this.f13645b == this.f13646c && !this.f13639g;
    }

    public f(j$.time.temporal.q qVar) {
        this(qVar, 0, 9, true, 0);
        Objects.requireNonNull(qVar, "field");
        j$.time.temporal.u uVarI = qVar.I();
        if (uVarI.f13760a != uVarI.f13761b || uVarI.f13762c != uVarI.f13763d) {
            throw new IllegalArgumentException(j$.time.d.a("Field must have a fixed set of values: ", qVar));
        }
    }

    public f(j$.time.temporal.q qVar, int i10, int i11, boolean z10, int i12) {
        super(qVar, i10, i11, y.NOT_NEGATIVE, i12);
        this.f13639g = z10;
    }

    @Override // j$.time.format.h
    public final h b() {
        if (this.f13648e == -1) {
            return this;
        }
        return new f(this.f13644a, this.f13645b, this.f13646c, this.f13639g, -1);
    }

    @Override // j$.time.format.h
    public final h c(int i10) {
        return new f(this.f13644a, this.f13645b, this.f13646c, this.f13639g, this.f13648e + i10);
    }

    @Override // j$.time.format.h, j$.time.format.e
    public final boolean s(s sVar, StringBuilder sb2) {
        j$.time.temporal.q qVar = this.f13644a;
        Long lA = sVar.a(qVar);
        if (lA == null) {
            return false;
        }
        v vVar = sVar.f13681b.f13630c;
        long jLongValue = lA.longValue();
        j$.time.temporal.u uVarI = qVar.I();
        uVarI.b(jLongValue, qVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(uVarI.f13760a);
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(uVarI.f13763d).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z10 = this.f13639g;
        int i10 = this.f13645b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i10), this.f13646c), roundingMode).toPlainString().substring(2);
            vVar.getClass();
            if (z10) {
                sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
            }
            sb2.append(strSubstring);
            return true;
        }
        if (i10 > 0) {
            if (z10) {
                vVar.getClass();
                sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
            }
            for (int i11 = 0; i11 < i10; i11++) {
                vVar.getClass();
                sb2.append('0');
            }
        }
        return true;
    }

    @Override // j$.time.format.h
    public final String toString() {
        return "Fraction(" + this.f13644a + com.amazon.a.a.o.b.f.f4598a + this.f13645b + com.amazon.a.a.o.b.f.f4598a + this.f13646c + (this.f13639g ? ",DecimalPoint" : "") + ")";
    }
}
