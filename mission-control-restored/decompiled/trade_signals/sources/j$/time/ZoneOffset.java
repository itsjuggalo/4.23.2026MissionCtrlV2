package j$.time;

import com.revenuecat.purchases.common.Constants;
import j$.time.temporal.TemporalAccessor;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, j$.time.temporal.n, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient String f19660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap f19655d = new ConcurrentHashMap(16, 0.75f, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap f19656e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = a0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ZoneOffset f19657f = a0(-64800);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ZoneOffset f19658g = a0(64800);

    private ZoneOffset(int i8) {
        String string;
        this.f19659b = i8;
        if (i8 == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i8);
            StringBuilder sb = new StringBuilder();
            int i9 = iAbs / 3600;
            int i10 = (iAbs / 60) % 60;
            sb.append(i8 < 0 ? "-" : "+");
            sb.append(i9 < 10 ? "0" : "");
            sb.append(i9);
            String str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            sb.append(i10 < 10 ? ":0" : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(i10);
            int i11 = iAbs % 60;
            if (i11 != 0) {
                sb.append(i11 < 10 ? ":0" : str);
                sb.append(i11);
            }
            string = sb.toString();
        }
        this.f19660c = string;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset Y(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentHashMap r0 = j$.time.ZoneOffset.f19656e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L63
            r1 = 3
            if (r0 == r1) goto L7f
            r4 = 5
            if (r0 == r4) goto L5a
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L50
            r5 = 7
            if (r0 == r5) goto L43
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = b0(r7, r2, r3)
            int r1 = b0(r7, r6, r2)
            int r2 = b0(r7, r5, r2)
            goto L85
        L37:
            j$.time.c r0 = new j$.time.c
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L43:
            int r0 = b0(r7, r2, r3)
            int r1 = b0(r7, r1, r3)
            int r2 = b0(r7, r4, r3)
            goto L85
        L50:
            int r0 = b0(r7, r2, r3)
            int r1 = b0(r7, r6, r2)
        L58:
            r2 = r3
            goto L85
        L5a:
            int r0 = b0(r7, r2, r3)
            int r1 = b0(r7, r1, r3)
            goto L58
        L63:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L7f:
            int r0 = b0(r7, r2, r3)
            r1 = r3
            r2 = r1
        L85:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L9e
            if (r3 != r5) goto L92
            goto L9e
        L92:
            j$.time.c r0 = new j$.time.c
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L9e:
            if (r3 != r5) goto La8
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = Z(r7, r0, r1)
            return r7
        La8:
            j$.time.ZoneOffset r7 = Z(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.Y(java.lang.String):j$.time.ZoneOffset");
    }

    public static ZoneOffset Z(int i8, int i9, int i10) {
        if (i8 < -18 || i8 > 18) {
            throw new c("Zone offset hours not in valid range: value " + i8 + " is not in the range -18 to 18");
        }
        if (i8 > 0) {
            if (i9 < 0 || i10 < 0) {
                throw new c("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i8 < 0) {
            if (i9 > 0 || i10 > 0) {
                throw new c("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i9 > 0 && i10 < 0) || (i9 < 0 && i10 > 0)) {
            throw new c("Zone offset minutes and seconds must have the same sign");
        }
        if (i9 < -59 || i9 > 59) {
            throw new c("Zone offset minutes not in valid range: value " + i9 + " is not in the range -59 to 59");
        }
        if (i10 < -59 || i10 > 59) {
            throw new c("Zone offset seconds not in valid range: value " + i10 + " is not in the range -59 to 59");
        }
        if (Math.abs(i8) == 18 && (i9 | i10) != 0) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        return a0((i9 * 60) + (i8 * 3600) + i10);
    }

    public static ZoneOffset a0(int i8) {
        if (i8 < -64800 || i8 > 64800) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i8 % 900 != 0) {
            return new ZoneOffset(i8);
        }
        Integer numValueOf = Integer.valueOf(i8);
        ConcurrentHashMap concurrentHashMap = f19655d;
        ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(numValueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentHashMap.putIfAbsent(numValueOf, new ZoneOffset(i8));
        ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(numValueOf);
        f19656e.putIfAbsent(zoneOffset2.f19660c, zoneOffset2);
        return zoneOffset2;
    }

    private static int b0(CharSequence charSequence, int i8, boolean z7) {
        if (z7 && charSequence.charAt(i8 - 1) != ':') {
            throw new c("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char cCharAt = charSequence.charAt(i8);
        char cCharAt2 = charSequence.charAt(i8 + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
        }
        throw new c("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    static ZoneOffset c0(DataInput dataInput) throws IOException {
        byte b8 = dataInput.readByte();
        return b8 == 127 ? a0(dataInput.readInt()) : a0(b8 * 900);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 8, this);
    }

    @Override // j$.time.ZoneId
    final void R(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        d0(dataOutput);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f19659b - this.f19659b;
    }

    public final int X() {
        return this.f19659b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.temporal.t tVar) {
        return (tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.f()) ? this : super.b(tVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m d(j$.time.temporal.m mVar) {
        return mVar.c(this.f19659b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    final void d0(DataOutput dataOutput) {
        int i8 = this.f19659b;
        int i9 = i8 % 900 == 0 ? i8 / 900 : 127;
        dataOutput.writeByte(i9);
        if (i9 == 127) {
            dataOutput.writeInt(i8);
        }
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneOffset) {
            return this.f19659b == ((ZoneOffset) obj).f19659b;
        }
        return false;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.OFFSET_SECONDS : rVar != null && rVar.U(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f19659b;
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return rVar.q(this);
    }

    @Override // j$.time.ZoneId
    public final String getId() {
        return this.f19660c;
    }

    @Override // j$.time.ZoneId
    public final int hashCode() {
        return this.f19659b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f19659b;
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return super.k(rVar).a(g(rVar), rVar);
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f q() {
        return j$.time.zone.f.i(this);
    }

    @Override // j$.time.ZoneId
    public final String toString() {
        return this.f19660c;
    }
}
