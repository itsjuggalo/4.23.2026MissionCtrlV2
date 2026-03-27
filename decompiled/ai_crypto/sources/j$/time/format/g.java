package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes3.dex */
final class g extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f17169g;

    g(j$.time.temporal.r rVar, int i7, int i8, boolean z7, int i9) {
        super(rVar, i7, i8, z.NOT_NEGATIVE, i9);
        this.f17169g = z7;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i
    final i c() {
        if (this.f17175e == -1) {
            return this;
        }
        return new g(this.f17171a, this.f17172b, this.f17173c, this.f17169g, -1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i
    final i d(int i7) {
        return new g(this.f17171a, this.f17172b, this.f17173c, this.f17169g, this.f17175e + i7);
    }

    @Override // j$.time.format.i
    final boolean b(q qVar) {
        return qVar.k() && this.f17172b == this.f17173c && !this.f17169g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i, j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        ?? r02 = this.f17171a;
        Long lE = tVar.e(r02);
        if (lE == null) {
            return false;
        }
        w wVarB = tVar.b();
        long jLongValue = lE.longValue();
        j$.time.temporal.w wVarC = r02.C();
        wVarC.b(jLongValue, r02);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(wVarC.e());
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(wVarC.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z7 = this.f17169g;
        int i7 = this.f17172b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i7), this.f17173c), roundingMode).toPlainString().substring(2);
            wVarB.getClass();
            if (z7) {
                sb.append(com.amazon.a.a.o.c.a.b.f10001a);
            }
            sb.append(strSubstring);
            return true;
        }
        if (i7 <= 0) {
            return true;
        }
        if (z7) {
            wVarB.getClass();
            sb.append(com.amazon.a.a.o.c.a.b.f10001a);
        }
        for (int i8 = 0; i8 < i7; i8++) {
            wVarB.getClass();
            sb.append('0');
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i, j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i7) {
        int i8 = (qVar.k() || b(qVar)) ? this.f17172b : 0;
        int i9 = (qVar.k() || b(qVar)) ? this.f17173c : 9;
        int length = charSequence.length();
        if (i7 == length) {
            return i8 > 0 ? ~i7 : i7;
        }
        if (this.f17169g) {
            char cCharAt = charSequence.charAt(i7);
            qVar.f().getClass();
            if (cCharAt != '.') {
                return i8 > 0 ? ~i7 : i7;
            }
            i7++;
        }
        int i10 = i7;
        int i11 = i8 + i10;
        if (i11 > length) {
            return ~i10;
        }
        int iMin = Math.min(i9 + i10, length);
        int i12 = 0;
        int i13 = i10;
        while (true) {
            if (i13 >= iMin) {
                break;
            }
            int i14 = i13 + 1;
            int iA = qVar.f().a(charSequence.charAt(i13));
            if (iA >= 0) {
                i12 = (i12 * 10) + iA;
                i13 = i14;
            } else if (i14 < i11) {
                return ~i10;
            }
        }
        BigDecimal bigDecimalMovePointLeft = new BigDecimal(i12).movePointLeft(i13 - i10);
        ?? r52 = this.f17171a;
        j$.time.temporal.w wVarC = r52.C();
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(wVarC.e());
        return qVar.n(r52, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(wVarC.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i10, i13);
    }

    @Override // j$.time.format.i
    public final String toString() {
        return "Fraction(" + this.f17171a + com.amazon.a.a.o.b.f.f9989a + this.f17172b + com.amazon.a.a.o.b.f.f9989a + this.f17173c + (this.f17169g ? ",DecimalPoint" : "") + ")";
    }
}
