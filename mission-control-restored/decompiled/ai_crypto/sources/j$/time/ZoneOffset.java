package j$.time;

import com.revenuecat.purchases.common.Constants;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class ZoneOffset extends ZoneId implements TemporalAccessor, j$.time.temporal.n, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient String f17085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap f17080d = new ConcurrentHashMap(16, 0.75f, 4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap f17081e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = c0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ZoneOffset f17082f = c0(-64800);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ZoneOffset f17083g = c0(64800);

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset a0(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentHashMap r0 = j$.time.ZoneOffset.f17081e
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
            int r0 = d0(r7, r2, r3)
            int r1 = d0(r7, r6, r2)
            int r2 = d0(r7, r5, r2)
            goto L85
        L37:
            j$.time.c r0 = new j$.time.c
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L43:
            int r0 = d0(r7, r2, r3)
            int r1 = d0(r7, r1, r3)
            int r2 = d0(r7, r4, r3)
            goto L85
        L50:
            int r0 = d0(r7, r2, r3)
            int r1 = d0(r7, r6, r2)
        L58:
            r2 = r3
            goto L85
        L5a:
            int r0 = d0(r7, r2, r3)
            int r1 = d0(r7, r1, r3)
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
            int r0 = d0(r7, r2, r3)
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
            j$.time.ZoneOffset r7 = b0(r7, r0, r1)
            return r7
        La8:
            j$.time.ZoneOffset r7 = b0(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.a0(java.lang.String):j$.time.ZoneOffset");
    }

    private static int d0(String str, int i7, boolean z7) {
        if (z7 && str.charAt(i7 - 1) != ':') {
            throw new c("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) str));
        }
        char cCharAt = str.charAt(i7);
        char cCharAt2 = str.charAt(i7 + 1);
        if (cCharAt >= '0' && cCharAt <= '9' && cCharAt2 >= '0' && cCharAt2 <= '9') {
            return (cCharAt2 - '0') + ((cCharAt - '0') * 10);
        }
        throw new c("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) str));
    }

    public static ZoneOffset b0(int i7, int i8, int i9) {
        if (i7 < -18 || i7 > 18) {
            throw new c("Zone offset hours not in valid range: value " + i7 + " is not in the range -18 to 18");
        }
        if (i7 > 0) {
            if (i8 < 0 || i9 < 0) {
                throw new c("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i7 < 0) {
            if (i8 > 0 || i9 > 0) {
                throw new c("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i8 > 0 && i9 < 0) || (i8 < 0 && i9 > 0)) {
            throw new c("Zone offset minutes and seconds must have the same sign");
        }
        if (i8 < -59 || i8 > 59) {
            throw new c("Zone offset minutes not in valid range: value " + i8 + " is not in the range -59 to 59");
        }
        if (i9 < -59 || i9 > 59) {
            throw new c("Zone offset seconds not in valid range: value " + i9 + " is not in the range -59 to 59");
        }
        if (Math.abs(i7) == 18 && (i8 | i9) != 0) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        return c0((i8 * 60) + (i7 * 3600) + i9);
    }

    public static ZoneOffset c0(int i7) {
        if (i7 < -64800 || i7 > 64800) {
            throw new c("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i7 % 900 == 0) {
            Integer numValueOf = Integer.valueOf(i7);
            ConcurrentHashMap concurrentHashMap = f17080d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(numValueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(numValueOf, new ZoneOffset(i7));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(numValueOf);
            f17081e.putIfAbsent(zoneOffset2.f17085c, zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i7);
    }

    private ZoneOffset(int i7) {
        String string;
        this.f17084b = i7;
        if (i7 == 0) {
            string = "Z";
        } else {
            int iAbs = Math.abs(i7);
            StringBuilder sb = new StringBuilder();
            int i8 = iAbs / 3600;
            int i9 = (iAbs / 60) % 60;
            sb.append(i7 < 0 ? "-" : "+");
            sb.append(i8 < 10 ? "0" : "");
            sb.append(i8);
            String str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
            sb.append(i9 < 10 ? ":0" : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(i9);
            int i10 = iAbs % 60;
            if (i10 != 0) {
                sb.append(i10 < 10 ? ":0" : str);
                sb.append(i10);
            }
            string = sb.toString();
        }
        this.f17085c = string;
    }

    public final int Z() {
        return this.f17084b;
    }

    @Override // j$.time.ZoneId
    public final String s() {
        return this.f17085c;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f r() {
        return j$.time.zone.f.h(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.OFFSET_SECONDS : rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f17084b;
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return super.l(rVar).a(g(rVar), rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f17084b;
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return rVar.r(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        return (tVar == j$.time.temporal.s.d() || tVar == j$.time.temporal.s.f()) ? this : super.a(tVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.b(this.f17084b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f17084b - this.f17084b;
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneOffset) {
            return this.f17084b == ((ZoneOffset) obj).f17084b;
        }
        return false;
    }

    @Override // j$.time.ZoneId
    public final int hashCode() {
        return this.f17084b;
    }

    @Override // j$.time.ZoneId
    public final String toString() {
        return this.f17085c;
    }

    private Object writeReplace() {
        return new t((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    final void T(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(8);
        f0(objectOutput);
    }

    final void f0(DataOutput dataOutput) {
        int i7 = this.f17084b;
        int i8 = i7 % 900 == 0 ? i7 / 900 : 127;
        dataOutput.writeByte(i8);
        if (i8 == 127) {
            dataOutput.writeInt(i7);
        }
    }

    static ZoneOffset e0(ObjectInput objectInput) throws IOException {
        byte b7 = objectInput.readByte();
        return b7 == 127 ? c0(objectInput.readInt()) : c0(b7 * 900);
    }
}
