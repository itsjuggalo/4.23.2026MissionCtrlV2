package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
final class g extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f7453g;

    g(j$.time.temporal.r rVar, int i, int i6, boolean z6, int i7) {
        super(rVar, i, i6, z.NOT_NEGATIVE, i7);
        this.f7453g = z6;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i
    final i c() {
        if (this.e == -1) {
            return this;
        }
        return new g(this.f7455a, this.f7456b, this.f7457c, this.f7453g, -1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i
    final i d(int i) {
        return new g(this.f7455a, this.f7456b, this.f7457c, this.f7453g, this.e + i);
    }

    @Override // j$.time.format.i
    final boolean b(q qVar) {
        return qVar.k() && this.f7456b == this.f7457c && !this.f7453g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i, j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        ?? r02 = this.f7455a;
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
        boolean z6 = this.f7453g;
        int i = this.f7456b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i), this.f7457c), roundingMode).toPlainString().substring(2);
            wVarB.getClass();
            if (z6) {
                sb.append('.');
            }
            sb.append(strSubstring);
            return true;
        }
        if (i <= 0) {
            return true;
        }
        if (z6) {
            wVarB.getClass();
            sb.append('.');
        }
        for (int i6 = 0; i6 < i; i6++) {
            wVarB.getClass();
            sb.append('0');
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.i, j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i) {
        int i6 = (qVar.k() || b(qVar)) ? this.f7456b : 0;
        int i7 = (qVar.k() || b(qVar)) ? this.f7457c : 9;
        int length = charSequence.length();
        if (i != length) {
            if (this.f7453g) {
                char cCharAt = charSequence.charAt(i);
                qVar.f().getClass();
                if (cCharAt == '.') {
                    i++;
                } else if (i6 > 0) {
                    return ~i;
                }
            }
            int i8 = i;
            int i9 = i6 + i8;
            if (i9 > length) {
                return ~i8;
            }
            int iMin = Math.min(i7 + i8, length);
            int i10 = 0;
            int i11 = i8;
            while (true) {
                if (i11 >= iMin) {
                    break;
                }
                int i12 = i11 + 1;
                int iA = qVar.f().a(charSequence.charAt(i11));
                if (iA >= 0) {
                    i10 = (i10 * 10) + iA;
                    i11 = i12;
                } else if (i12 < i9) {
                    return ~i8;
                }
            }
            BigDecimal bigDecimalMovePointLeft = new BigDecimal(i10).movePointLeft(i11 - i8);
            ?? r52 = this.f7455a;
            j$.time.temporal.w wVarC = r52.C();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(wVarC.e());
            return qVar.n(r52, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(wVarC.d()).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i8, i11);
        }
        if (i6 > 0) {
            return ~i;
        }
        return i;
    }

    @Override // j$.time.format.i
    public final String toString() {
        return "Fraction(" + this.f7455a + "," + this.f7456b + "," + this.f7457c + (this.f7453g ? ",DecimalPoint" : "") + ")";
    }
}
