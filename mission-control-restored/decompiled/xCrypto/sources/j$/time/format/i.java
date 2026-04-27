package j$.time.format;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
class i implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long[] f13211f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Enum f13212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f13213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f13214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z f13215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f13216e;

    /* JADX WARN: Multi-variable type inference failed */
    i(j$.time.temporal.r rVar, int i4, int i5, z zVar) {
        this.f13212a = (Enum) rVar;
        this.f13213b = i4;
        this.f13214c = i5;
        this.f13215d = zVar;
        this.f13216e = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected i(j$.time.temporal.r rVar, int i4, int i5, z zVar, int i6) {
        this.f13212a = (Enum) rVar;
        this.f13213b = i4;
        this.f13214c = i5;
        this.f13215d = zVar;
        this.f13216e = i6;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [j$.time.temporal.r, java.lang.Enum] */
    i c() {
        return this.f13216e == -1 ? this : new i(this.f13212a, this.f13213b, this.f13214c, this.f13215d, -1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.temporal.r, java.lang.Enum] */
    i d(int i4) {
        int i5 = this.f13216e + i4;
        return new i(this.f13212a, this.f13213b, this.f13214c, this.f13215d, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.temporal.r, java.lang.Enum, java.lang.Object] */
    @Override // j$.time.format.f
    public boolean p(t tVar, StringBuilder sb) {
        ?? r02 = this.f13212a;
        Long lE = tVar.e(r02);
        if (lE == null) {
            return false;
        }
        long jLongValue = lE.longValue();
        w wVarB = tVar.b();
        String string = jLongValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jLongValue));
        int length = string.length();
        int i4 = this.f13214c;
        if (length > i4) {
            throw new j$.time.c("Field " + ((Object) r02) + " cannot be printed as the value " + jLongValue + " exceeds the maximum print width of " + i4);
        }
        wVarB.getClass();
        int i5 = this.f13213b;
        z zVar = this.f13215d;
        if (jLongValue >= 0) {
            int i6 = c.f13206a[zVar.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    sb.append('+');
                }
            } else if (i5 < 19 && jLongValue >= f13211f[i5]) {
                sb.append('+');
            }
        } else {
            int i7 = c.f13206a[zVar.ordinal()];
            if (i7 == 1 || i7 == 2 || i7 == 3) {
                sb.append('-');
            } else if (i7 == 4) {
                throw new j$.time.c("Field " + ((Object) r02) + " cannot be printed as the value " + jLongValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i8 = 0; i8 < i5 - string.length(); i8++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    boolean b(q qVar) {
        int i4 = this.f13216e;
        if (i4 != -1) {
            return i4 > 0 && this.f13213b == this.f13214c && this.f13215d == z.NOT_NEGATIVE;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.f
    public int r(q qVar, CharSequence charSequence, int i4) {
        int i5;
        boolean z4;
        boolean z5;
        BigInteger bigIntegerAdd;
        long j4;
        int i6;
        long j5;
        int i7;
        long j6;
        boolean z6;
        int length = charSequence.length();
        if (i4 == length) {
            return ~i4;
        }
        char cCharAt = charSequence.charAt(i4);
        qVar.f().getClass();
        boolean z7 = true;
        int i8 = this.f13214c;
        z zVar = this.f13215d;
        int i9 = this.f13213b;
        int i10 = 0;
        if (cCharAt == '+') {
            boolean zK = qVar.k();
            boolean z8 = i9 == i8;
            int iOrdinal = zVar.ordinal();
            if (iOrdinal == 0 ? zK : !(iOrdinal == 1 || iOrdinal == 4 || (!zK && !z8))) {
                return ~i4;
            }
            i5 = i4 + 1;
            z5 = true;
            z4 = false;
        } else {
            qVar.f().getClass();
            if (cCharAt == '-') {
                boolean zK2 = qVar.k();
                boolean z9 = i9 == i8;
                int iOrdinal2 = zVar.ordinal();
                if (iOrdinal2 != 0 && iOrdinal2 != 1 && iOrdinal2 != 4 && (zK2 || z9)) {
                    return ~i4;
                }
                i5 = i4 + 1;
                z4 = true;
                z5 = false;
            } else {
                if (zVar == z.ALWAYS && qVar.k()) {
                    return ~i4;
                }
                i5 = i4;
                z4 = false;
                z5 = false;
            }
        }
        int i11 = (qVar.k() || b(qVar)) ? i9 : 1;
        int i12 = i5 + i11;
        if (i12 > length) {
            return ~i5;
        }
        if (!qVar.k() && !b(qVar)) {
            i8 = 9;
        }
        int i13 = this.f13216e;
        int iMax = Math.max(i13, 0) + i8;
        while (true) {
            bigIntegerAdd = null;
            if (i10 >= 2) {
                j4 = 0;
                i6 = i5;
                j5 = 0;
                break;
            }
            int iMin = Math.min(iMax + i5, length);
            i7 = i5;
            j6 = 0;
            while (true) {
                if (i7 >= iMin) {
                    z6 = z7;
                    j4 = 0;
                    break;
                }
                int i14 = i7 + 1;
                z6 = z7;
                j4 = 0;
                int iA = qVar.f().a(charSequence.charAt(i7));
                if (iA >= 0) {
                    if (i14 - i5 > 18) {
                        if (bigIntegerAdd == null) {
                            bigIntegerAdd = BigInteger.valueOf(j6);
                        }
                        bigIntegerAdd = bigIntegerAdd.multiply(BigInteger.TEN).add(BigInteger.valueOf(iA));
                    } else {
                        j6 = (j6 * 10) + ((long) iA);
                    }
                    i7 = i14;
                    z7 = z6;
                } else if (i7 < i12) {
                    return ~i5;
                }
            }
            if (i13 <= 0 || i10 != 0) {
                break;
            }
            iMax = Math.max(i11, (i7 - i5) - i13);
            i10++;
            z7 = z6;
        }
        i6 = i7;
        j5 = j6;
        BigInteger bigIntegerDivide = bigIntegerAdd;
        if (z4) {
            if (bigIntegerDivide != null) {
                if (bigIntegerDivide.equals(BigInteger.ZERO) && qVar.k()) {
                    return ~(i5 - 1);
                }
                bigIntegerDivide = bigIntegerDivide.negate();
            } else {
                if (j5 == j4 && qVar.k()) {
                    return ~(i5 - 1);
                }
                j5 = -j5;
            }
        } else if (zVar == z.EXCEEDS_PAD && qVar.k()) {
            int i15 = i6 - i5;
            if (z5) {
                if (i15 <= i9) {
                    return ~(i5 - 1);
                }
            } else if (i15 > i9) {
                return ~i5;
            }
        }
        ?? r32 = this.f13212a;
        if (bigIntegerDivide != null) {
            if (bigIntegerDivide.bitLength() > 63) {
                bigIntegerDivide = bigIntegerDivide.divide(BigInteger.TEN);
                i6--;
            }
            return qVar.n(r32, bigIntegerDivide.longValue(), i5, i6);
        }
        return qVar.n(r32, j5, i5, i6);
    }

    public String toString() {
        Enum r02 = this.f13212a;
        int i4 = this.f13214c;
        z zVar = this.f13215d;
        int i5 = this.f13213b;
        if (i5 == 1 && i4 == 19 && zVar == z.NORMAL) {
            return "Value(" + r02 + ")";
        }
        if (i5 == i4 && zVar == z.NOT_NEGATIVE) {
            return "Value(" + r02 + com.amazon.a.a.o.b.f.f8804a + i5 + ")";
        }
        return "Value(" + r02 + com.amazon.a.a.o.b.f.f8804a + i5 + com.amazon.a.a.o.b.f.f8804a + i4 + com.amazon.a.a.o.b.f.f8804a + zVar + ")";
    }
}
