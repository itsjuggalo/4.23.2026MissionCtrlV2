package j$.time.format;

/* JADX INFO: loaded from: classes3.dex */
class i implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long[] f19747f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final j$.time.temporal.r f19748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f19749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f19750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z f19751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f19752e;

    i(j$.time.temporal.r rVar, int i8, int i9, z zVar) {
        this.f19748a = rVar;
        this.f19749b = i8;
        this.f19750c = i9;
        this.f19751d = zVar;
        this.f19752e = 0;
    }

    protected i(j$.time.temporal.r rVar, int i8, int i9, z zVar, int i10) {
        this.f19748a = rVar;
        this.f19749b = i8;
        this.f19750c = i9;
        this.f19751d = zVar;
        this.f19752e = i10;
    }

    boolean b(q qVar) {
        int i8 = this.f19752e;
        return i8 == -1 || (i8 > 0 && this.f19749b == this.f19750c && this.f19751d == z.NOT_NEGATIVE);
    }

    i c() {
        if (this.f19752e == -1) {
            return this;
        }
        return new i(this.f19748a, this.f19749b, this.f19750c, this.f19751d, -1);
    }

    i d(int i8) {
        int i9 = this.f19752e + i8;
        return new i(this.f19748a, this.f19749b, this.f19750c, this.f19751d, i9);
    }

    @Override // j$.time.format.f
    public boolean o(t tVar, StringBuilder sb) {
        j$.time.temporal.r rVar = this.f19748a;
        Long lE = tVar.e(rVar);
        if (lE == null) {
            return false;
        }
        long jLongValue = lE.longValue();
        w wVarB = tVar.b();
        String string = jLongValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jLongValue));
        int length = string.length();
        int i8 = this.f19750c;
        if (length > i8) {
            throw new j$.time.c("Field " + rVar + " cannot be printed as the value " + jLongValue + " exceeds the maximum print width of " + i8);
        }
        wVarB.getClass();
        int i9 = this.f19749b;
        z zVar = this.f19751d;
        if (jLongValue >= 0) {
            int i10 = c.f19742a[zVar.ordinal()];
            if (i10 == 1 ? !(i9 >= 19 || jLongValue < f19747f[i9]) : i10 == 2) {
                sb.append('+');
            }
        } else {
            int i11 = c.f19742a[zVar.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                sb.append('-');
            } else if (i11 == 4) {
                throw new j$.time.c("Field " + rVar + " cannot be printed as the value " + jLongValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i12 = 0; i12 < i9 - string.length(); i12++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x013d, code lost:
    
        return ~r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x013e, code lost:
    
        if (r2 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0146, code lost:
    
        if (r2.bitLength() <= 63) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0148, code lost:
    
        r2 = r2.divide(java.math.BigInteger.TEN);
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x015e, code lost:
    
        return r21.n(r20.f19748a, r2.longValue(), r1, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0169, code lost:
    
        return r21.n(r20.f19748a, r4, r1, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f2, code lost:
    
        r2 = r16;
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fc, code lost:
    
        if (r3 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fe, code lost:
    
        if (r2 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0106, code lost:
    
        if (r2.equals(java.math.BigInteger.ZERO) == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010c, code lost:
    
        if (r21.k() == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x010e, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0111, code lost:
    
        return ~(r1 - r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0112, code lost:
    
        r2 = r2.negate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0116, code lost:
    
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0118, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x011d, code lost:
    
        if (r9 != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0123, code lost:
    
        if (r21.k() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0126, code lost:
    
        r4 = -r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x012b, code lost:
    
        if (r7 != j$.time.format.z.EXCEEDS_PAD) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0131, code lost:
    
        if (r21.k() == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0133, code lost:
    
        r3 = r13 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0135, code lost:
    
        if (r5 == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0137, code lost:
    
        if (r3 > r8) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x013a, code lost:
    
        if (r3 <= r8) goto L84;
     */
    @Override // j$.time.format.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int q(j$.time.format.q r21, java.lang.CharSequence r22, int r23) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.i.q(j$.time.format.q, java.lang.CharSequence, int):int");
    }

    public String toString() {
        int i8 = this.f19750c;
        j$.time.temporal.r rVar = this.f19748a;
        z zVar = this.f19751d;
        int i9 = this.f19749b;
        if (i9 == 1 && i8 == 19 && zVar == z.NORMAL) {
            return "Value(" + rVar + ")";
        }
        if (i9 == i8 && zVar == z.NOT_NEGATIVE) {
            return "Value(" + rVar + com.amazon.a.a.o.b.f.f14100a + i9 + ")";
        }
        return "Value(" + rVar + com.amazon.a.a.o.b.f.f14100a + i9 + com.amazon.a.a.o.b.f.f14100a + i8 + com.amazon.a.a.o.b.f.f14100a + zVar + ")";
    }
}
