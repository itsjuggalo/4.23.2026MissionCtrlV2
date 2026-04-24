package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
final class g extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f19746g;

    g(j$.time.temporal.r rVar, int i8, int i9, boolean z7, int i10) {
        super(rVar, i8, i9, z.NOT_NEGATIVE, i10);
        this.f19746g = z7;
    }

    @Override // j$.time.format.i
    final boolean b(q qVar) {
        return qVar.k() && this.f19749b == this.f19750c && !this.f19746g;
    }

    @Override // j$.time.format.i
    final i c() {
        if (this.f19752e == -1) {
            return this;
        }
        return new g(this.f19748a, this.f19749b, this.f19750c, this.f19746g, -1);
    }

    @Override // j$.time.format.i
    final i d(int i8) {
        return new g(this.f19748a, this.f19749b, this.f19750c, this.f19746g, this.f19752e + i8);
    }

    @Override // j$.time.format.i, j$.time.format.f
    public final boolean o(t tVar, StringBuilder sb) {
        j$.time.temporal.r rVar = this.f19748a;
        Long lE = tVar.e(rVar);
        if (lE == null) {
            return false;
        }
        w wVarB = tVar.b();
        long jLongValue = lE.longValue();
        j$.time.temporal.w wVarA = rVar.A();
        wVarA.b(jLongValue, rVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(wVarA.e());
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(wVarA.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z7 = this.f19746g;
        int i8 = this.f19749b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i8), this.f19750c), roundingMode).toPlainString().substring(2);
            wVarB.getClass();
            if (z7) {
                sb.append(com.amazon.a.a.o.c.a.b.f14112a);
            }
            sb.append(strSubstring);
            return true;
        }
        if (i8 <= 0) {
            return true;
        }
        if (z7) {
            wVarB.getClass();
            sb.append(com.amazon.a.a.o.c.a.b.f14112a);
        }
        for (int i9 = 0; i9 < i8; i9++) {
            wVarB.getClass();
            sb.append('0');
        }
        return true;
    }

    @Override // j$.time.format.i, j$.time.format.f
    public final int q(q qVar, CharSequence charSequence, int i8) {
        int i9 = (qVar.k() || b(qVar)) ? this.f19749b : 0;
        int i10 = (qVar.k() || b(qVar)) ? this.f19750c : 9;
        int length = charSequence.length();
        if (i8 == length) {
            return i9 > 0 ? ~i8 : i8;
        }
        if (this.f19746g) {
            char cCharAt = charSequence.charAt(i8);
            qVar.f().getClass();
            if (cCharAt != '.') {
                return i9 > 0 ? ~i8 : i8;
            }
            i8++;
        }
        int i11 = i8;
        int i12 = i9 + i11;
        if (i12 > length) {
            return ~i11;
        }
        int iMin = Math.min(i10 + i11, length);
        int i13 = 0;
        int i14 = i11;
        while (true) {
            if (i14 >= iMin) {
                break;
            }
            int i15 = i14 + 1;
            int iA = qVar.f().a(charSequence.charAt(i14));
            if (iA >= 0) {
                i13 = (i13 * 10) + iA;
                i14 = i15;
            } else if (i15 < i12) {
                return ~i11;
            }
        }
        BigDecimal bigDecimalMovePointLeft = new BigDecimal(i13).movePointLeft(i14 - i11);
        j$.time.temporal.w wVarA = this.f19748a.A();
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(wVarA.e());
        return qVar.n(this.f19748a, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(wVarA.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i11, i14);
    }

    @Override // j$.time.format.i
    public final String toString() {
        return "Fraction(" + this.f19748a + com.amazon.a.a.o.b.f.f14100a + this.f19749b + com.amazon.a.a.o.b.f.f14100a + this.f19750c + (this.f19746g ? ",DecimalPoint" : "") + ")";
    }
}
