package j$.time.format;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class h implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long[] f13643f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f13644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f13647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13648e;

    public h(j$.time.temporal.q qVar, int i10, int i11, y yVar) {
        this.f13644a = qVar;
        this.f13645b = i10;
        this.f13646c = i11;
        this.f13647d = yVar;
        this.f13648e = 0;
    }

    public h(j$.time.temporal.q qVar, int i10, int i11, y yVar, int i12) {
        this.f13644a = qVar;
        this.f13645b = i10;
        this.f13646c = i11;
        this.f13647d = yVar;
        this.f13648e = i12;
    }

    public h b() {
        if (this.f13648e == -1) {
            return this;
        }
        return new h(this.f13644a, this.f13645b, this.f13646c, this.f13647d, -1);
    }

    public h c(int i10) {
        return new h(this.f13644a, this.f13645b, this.f13646c, this.f13647d, this.f13648e + i10);
    }

    @Override // j$.time.format.e
    public boolean s(s sVar, StringBuilder sb2) {
        j$.time.temporal.q qVar = this.f13644a;
        Long lA = sVar.a(qVar);
        if (lA == null) {
            return false;
        }
        long jLongValue = lA.longValue();
        v vVar = sVar.f13681b.f13630c;
        String string = jLongValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jLongValue));
        int length = string.length();
        int i10 = this.f13646c;
        if (length > i10) {
            throw new j$.time.c("Field " + qVar + " cannot be printed as the value " + jLongValue + " exceeds the maximum print width of " + i10);
        }
        vVar.getClass();
        int i11 = this.f13645b;
        y yVar = this.f13647d;
        if (jLongValue >= 0) {
            int i12 = b.f13635a[yVar.ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    sb2.append('+');
                }
            } else if (i11 < 19 && jLongValue >= f13643f[i11]) {
                sb2.append('+');
            }
        } else {
            int i13 = b.f13635a[yVar.ordinal()];
            if (i13 == 1 || i13 == 2 || i13 == 3) {
                sb2.append('-');
            } else if (i13 == 4) {
                throw new j$.time.c("Field " + qVar + " cannot be printed as the value " + jLongValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i14 = 0; i14 < i11 - string.length(); i14++) {
            sb2.append('0');
        }
        sb2.append(string);
        return true;
    }

    public boolean a(p pVar) {
        int i10 = this.f13648e;
        if (i10 != -1) {
            return i10 > 0 && this.f13645b == this.f13646c && this.f13647d == y.NOT_NEGATIVE;
        }
        return true;
    }

    @Override // j$.time.format.e
    public int A(p pVar, CharSequence charSequence, int i10) {
        boolean z10;
        boolean z11;
        BigInteger bigIntegerAdd;
        boolean z12;
        boolean z13;
        int i11;
        long j10;
        long j11;
        int i12;
        int i13;
        DateTimeFormatter dateTimeFormatter;
        boolean z14;
        int i14 = i10;
        int length = charSequence.length();
        if (i14 == length) {
            return ~i14;
        }
        char cCharAt = charSequence.charAt(i10);
        DateTimeFormatter dateTimeFormatter2 = pVar.f13672a;
        dateTimeFormatter2.f13630c.getClass();
        int i15 = this.f13646c;
        y yVar = this.f13647d;
        int i16 = this.f13645b;
        int i17 = 0;
        boolean z15 = true;
        if (cCharAt == '+') {
            boolean z16 = pVar.f13674c;
            boolean z17 = i16 == i15;
            int iOrdinal = yVar.ordinal();
            if (iOrdinal == 0 ? z16 : !(iOrdinal == 1 || iOrdinal == 4 || (!z16 && !z17))) {
                return ~i14;
            }
            i14++;
            z10 = false;
            z11 = true;
        } else {
            dateTimeFormatter2.f13630c.getClass();
            if (cCharAt == '-') {
                boolean z18 = pVar.f13674c;
                boolean z19 = i16 == i15;
                int iOrdinal2 = yVar.ordinal();
                if (iOrdinal2 != 0 && iOrdinal2 != 1 && iOrdinal2 != 4 && (z18 || z19)) {
                    return ~i14;
                }
                i14++;
                z11 = false;
                z10 = true;
            } else {
                if (yVar == y.ALWAYS && pVar.f13674c) {
                    return ~i14;
                }
                z10 = false;
                z11 = false;
            }
        }
        int i18 = (pVar.f13674c || a(pVar)) ? i16 : 1;
        int i19 = i14 + i18;
        if (i19 > length) {
            return ~i14;
        }
        if (!pVar.f13674c && !a(pVar)) {
            i15 = 9;
        }
        int i20 = this.f13648e;
        int iMax = Math.max(i20, 0) + i15;
        while (true) {
            bigIntegerAdd = null;
            if (i17 >= 2) {
                z12 = z10;
                z13 = z11;
                i11 = i14;
                j10 = 0;
                break;
            }
            int iMin = Math.min(i14 + iMax, length);
            boolean z20 = z15;
            j11 = 0;
            i12 = i14;
            while (true) {
                if (i12 >= iMin) {
                    i13 = length;
                    z12 = z10;
                    break;
                }
                int i21 = i12 + 1;
                char cCharAt2 = charSequence.charAt(i12);
                i13 = length;
                dateTimeFormatter2.f13630c.getClass();
                int i22 = cCharAt2 - '0';
                z12 = z10;
                if (i22 < 0 || i22 > 9) {
                    i22 = -1;
                }
                if (i22 >= 0) {
                    if (i21 - i14 > 18) {
                        if (bigIntegerAdd == null) {
                            bigIntegerAdd = BigInteger.valueOf(j11);
                        }
                        dateTimeFormatter = dateTimeFormatter2;
                        z14 = z11;
                        bigIntegerAdd = bigIntegerAdd.multiply(BigInteger.TEN).add(BigInteger.valueOf(i22));
                    } else {
                        dateTimeFormatter = dateTimeFormatter2;
                        z14 = z11;
                        j11 = (j11 * 10) + ((long) i22);
                    }
                    i12 = i21;
                    z10 = z12;
                    length = i13;
                    dateTimeFormatter2 = dateTimeFormatter;
                    z11 = z14;
                } else if (i12 < i19) {
                    return ~i14;
                }
            }
            DateTimeFormatter dateTimeFormatter3 = dateTimeFormatter2;
            z13 = z11;
            if (i20 <= 0 || i17 != 0) {
                break;
            }
            int iMax2 = Math.max(i18, (i12 - i14) - i20);
            i17++;
            z15 = z20;
            z10 = z12;
            dateTimeFormatter2 = dateTimeFormatter3;
            z11 = z13;
            iMax = iMax2;
            length = i13;
        }
        i11 = i12;
        j10 = j11;
        BigInteger bigIntegerDivide = bigIntegerAdd;
        if (z12) {
            if (bigIntegerDivide != null) {
                if (bigIntegerDivide.equals(BigInteger.ZERO) && pVar.f13674c) {
                    return ~(i14 - 1);
                }
                bigIntegerDivide = bigIntegerDivide.negate();
            } else {
                if (j10 == 0 && pVar.f13674c) {
                    return ~(i14 - 1);
                }
                j10 = -j10;
            }
        } else if (yVar == y.EXCEEDS_PAD && pVar.f13674c) {
            int i23 = i11 - i14;
            if (z13) {
                if (i23 <= i16) {
                    return ~(i14 - 1);
                }
            } else if (i23 > i16) {
                return ~i14;
            }
        }
        if (bigIntegerDivide == null) {
            return pVar.f(this.f13644a, j10, i14, i11);
        }
        if (bigIntegerDivide.bitLength() > 63) {
            bigIntegerDivide = bigIntegerDivide.divide(BigInteger.TEN);
            i11--;
        }
        return pVar.f(this.f13644a, bigIntegerDivide.longValue(), i14, i11);
    }

    public String toString() {
        int i10 = this.f13646c;
        j$.time.temporal.q qVar = this.f13644a;
        y yVar = this.f13647d;
        int i11 = this.f13645b;
        if (i11 == 1 && i10 == 19 && yVar == y.NORMAL) {
            return "Value(" + qVar + ")";
        }
        if (i11 == i10 && yVar == y.NOT_NEGATIVE) {
            return "Value(" + qVar + com.amazon.a.a.o.b.f.f4598a + i11 + ")";
        }
        return "Value(" + qVar + com.amazon.a.a.o.b.f.f4598a + i11 + com.amazon.a.a.o.b.f.f4598a + i10 + com.amazon.a.a.o.b.f.f4598a + yVar + ")";
    }
}
