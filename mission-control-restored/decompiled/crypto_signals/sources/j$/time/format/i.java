package j$.time.format;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
class i implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long[] f7454f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Enum f7455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f7456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f7457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z f7458d;
    final int e;

    /* JADX WARN: Multi-variable type inference failed */
    i(j$.time.temporal.r rVar, int i, int i6, z zVar) {
        this.f7455a = (Enum) rVar;
        this.f7456b = i;
        this.f7457c = i6;
        this.f7458d = zVar;
        this.e = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected i(j$.time.temporal.r rVar, int i, int i6, z zVar, int i7) {
        this.f7455a = (Enum) rVar;
        this.f7456b = i;
        this.f7457c = i6;
        this.f7458d = zVar;
        this.e = i7;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [j$.time.temporal.r, java.lang.Enum] */
    i c() {
        return this.e == -1 ? this : new i(this.f7455a, this.f7456b, this.f7457c, this.f7458d, -1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.temporal.r, java.lang.Enum] */
    i d(int i) {
        int i6 = this.e + i;
        return new i(this.f7455a, this.f7456b, this.f7457c, this.f7458d, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.temporal.r, java.lang.Enum, java.lang.Object] */
    @Override // j$.time.format.f
    public boolean p(t tVar, StringBuilder sb) {
        ?? r02 = this.f7455a;
        Long lE = tVar.e(r02);
        if (lE == null) {
            return false;
        }
        long jLongValue = lE.longValue();
        w wVarB = tVar.b();
        String string = jLongValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jLongValue));
        int length = string.length();
        int i = this.f7457c;
        if (length > i) {
            throw new j$.time.c("Field " + ((Object) r02) + " cannot be printed as the value " + jLongValue + " exceeds the maximum print width of " + i);
        }
        wVarB.getClass();
        int i6 = this.f7456b;
        z zVar = this.f7458d;
        if (jLongValue >= 0) {
            int i7 = c.f7449a[zVar.ordinal()];
            if (i7 != 1) {
                if (i7 == 2) {
                    sb.append('+');
                }
            } else if (i6 < 19 && jLongValue >= f7454f[i6]) {
                sb.append('+');
            }
        } else {
            int i8 = c.f7449a[zVar.ordinal()];
            if (i8 == 1 || i8 == 2 || i8 == 3) {
                sb.append('-');
            } else if (i8 == 4) {
                throw new j$.time.c("Field " + ((Object) r02) + " cannot be printed as the value " + jLongValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i9 = 0; i9 < i6 - string.length(); i9++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    boolean b(q qVar) {
        int i = this.e;
        if (i != -1) {
            return i > 0 && this.f7456b == this.f7457c && this.f7458d == z.NOT_NEGATIVE;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [j$.time.temporal.r, java.lang.Enum] */
    @Override // j$.time.format.f
    public int r(q qVar, CharSequence charSequence, int i) {
        int i6;
        boolean z6;
        boolean z7;
        BigInteger bigIntegerAdd;
        long j4;
        int i7;
        long j6;
        int i8;
        long j7;
        boolean z8;
        int length = charSequence.length();
        if (i == length) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        qVar.f().getClass();
        boolean z9 = true;
        int i9 = this.f7457c;
        z zVar = this.f7458d;
        int i10 = this.f7456b;
        int i11 = 0;
        if (cCharAt == '+') {
            boolean zK = qVar.k();
            boolean z10 = i10 == i9;
            int iOrdinal = zVar.ordinal();
            if (iOrdinal == 0 ? zK : !(iOrdinal == 1 || iOrdinal == 4 || (!zK && !z10))) {
                return ~i;
            }
            i6 = i + 1;
            z7 = true;
            z6 = false;
        } else {
            qVar.f().getClass();
            if (cCharAt == '-') {
                boolean zK2 = qVar.k();
                boolean z11 = i10 == i9;
                int iOrdinal2 = zVar.ordinal();
                if (iOrdinal2 != 0 && iOrdinal2 != 1 && iOrdinal2 != 4 && (zK2 || z11)) {
                    return ~i;
                }
                i6 = i + 1;
                z6 = true;
                z7 = false;
            } else {
                if (zVar == z.ALWAYS && qVar.k()) {
                    return ~i;
                }
                i6 = i;
                z6 = false;
                z7 = false;
            }
        }
        int i12 = (qVar.k() || b(qVar)) ? i10 : 1;
        int i13 = i6 + i12;
        if (i13 > length) {
            return ~i6;
        }
        if (!qVar.k() && !b(qVar)) {
            i9 = 9;
        }
        int i14 = this.e;
        int iMax = Math.max(i14, 0) + i9;
        while (true) {
            bigIntegerAdd = null;
            if (i11 >= 2) {
                j4 = 0;
                i7 = i6;
                j6 = 0;
                break;
            }
            int iMin = Math.min(iMax + i6, length);
            i8 = i6;
            j7 = 0;
            while (true) {
                if (i8 >= iMin) {
                    z8 = z9;
                    j4 = 0;
                    break;
                }
                int i15 = i8 + 1;
                z8 = z9;
                j4 = 0;
                int iA = qVar.f().a(charSequence.charAt(i8));
                if (iA >= 0) {
                    if (i15 - i6 > 18) {
                        if (bigIntegerAdd == null) {
                            bigIntegerAdd = BigInteger.valueOf(j7);
                        }
                        bigIntegerAdd = bigIntegerAdd.multiply(BigInteger.TEN).add(BigInteger.valueOf(iA));
                    } else {
                        j7 = (j7 * 10) + ((long) iA);
                    }
                    i8 = i15;
                    z9 = z8;
                } else if (i8 < i13) {
                    return ~i6;
                }
            }
            if (i14 <= 0 || i11 != 0) {
                break;
            }
            iMax = Math.max(i12, (i8 - i6) - i14);
            i11++;
            z9 = z8;
        }
        i7 = i8;
        j6 = j7;
        BigInteger bigIntegerDivide = bigIntegerAdd;
        if (z6) {
            if (bigIntegerDivide != null) {
                if (bigIntegerDivide.equals(BigInteger.ZERO) && qVar.k()) {
                    return ~(i6 - 1);
                }
                bigIntegerDivide = bigIntegerDivide.negate();
            } else {
                if (j6 == j4 && qVar.k()) {
                    return ~(i6 - 1);
                }
                j6 = -j6;
            }
        } else if (zVar == z.EXCEEDS_PAD && qVar.k()) {
            int i16 = i7 - i6;
            if (z7) {
                if (i16 <= i10) {
                    return ~(i6 - 1);
                }
            } else if (i16 > i10) {
                return ~i6;
            }
        }
        ?? r32 = this.f7455a;
        if (bigIntegerDivide != null) {
            if (bigIntegerDivide.bitLength() > 63) {
                bigIntegerDivide = bigIntegerDivide.divide(BigInteger.TEN);
                i7--;
            }
            return qVar.n(r32, bigIntegerDivide.longValue(), i6, i7);
        }
        return qVar.n(r32, j6, i6, i7);
    }

    public String toString() {
        Enum r02 = this.f7455a;
        int i = this.f7457c;
        z zVar = this.f7458d;
        int i6 = this.f7456b;
        if (i6 == 1 && i == 19 && zVar == z.NORMAL) {
            return "Value(" + r02 + ")";
        }
        if (i6 == i && zVar == z.NOT_NEGATIVE) {
            return "Value(" + r02 + "," + i6 + ")";
        }
        return "Value(" + r02 + "," + i6 + "," + i + "," + zVar + ")";
    }
}
