package j$.time.zone;

import j$.time.DayOfWeek;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.l;
import j$.time.n;
import j$.time.temporal.o;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long[] f13795i = new long[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e[] f13796j = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final LocalDateTime[] f13797k = new LocalDateTime[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b[] f13798l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f13799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ZoneOffset[] f13800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f13801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LocalDateTime[] f13802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ZoneOffset[] f13803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e[] f13804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeZone f13805g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient ConcurrentMap f13806h = new ConcurrentHashMap();

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.f13781b;
        if (bVar.s()) {
            if (localDateTime.F(localDateTime2)) {
                return bVar.f13782c;
            }
            if (!localDateTime.F(bVar.f13781b.X(bVar.f13783d.f13556b - bVar.f13782c.f13556b))) {
                return bVar.f13783d;
            }
        } else {
            if (!localDateTime.F(localDateTime2)) {
                return bVar.f13783d;
            }
            if (localDateTime.F(bVar.f13781b.X(bVar.f13783d.f13556b - bVar.f13782c.f13556b))) {
                return bVar.f13782c;
            }
        }
        return bVar;
    }

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f13799a = jArr;
        this.f13800b = zoneOffsetArr;
        this.f13801c = jArr2;
        this.f13803e = zoneOffsetArr2;
        this.f13804f = eVarArr;
        if (jArr2.length == 0) {
            this.f13802d = f13797k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 < jArr2.length) {
                int i11 = i10 + 1;
                b bVar = new b(jArr2[i10], zoneOffsetArr2[i10], zoneOffsetArr2[i11]);
                if (bVar.s()) {
                    arrayList.add(bVar.f13781b);
                    arrayList.add(bVar.f13781b.X(bVar.f13783d.f13556b - bVar.f13782c.f13556b));
                } else {
                    arrayList.add(bVar.f13781b.X(bVar.f13783d.f13556b - bVar.f13782c.f13556b));
                    arrayList.add(bVar.f13781b);
                }
                i10 = i11;
            }
            this.f13802d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f13805g = null;
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f13800b = zoneOffsetArr;
        long[] jArr = f13795i;
        this.f13799a = jArr;
        this.f13801c = jArr;
        this.f13802d = f13797k;
        this.f13803e = zoneOffsetArr;
        this.f13804f = f13796j;
        this.f13805g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {g(timeZone.getRawOffset())};
        this.f13800b = zoneOffsetArr;
        long[] jArr = f13795i;
        this.f13799a = jArr;
        this.f13801c = jArr;
        this.f13802d = f13797k;
        this.f13803e = zoneOffsetArr;
        this.f13804f = f13796j;
        this.f13805g = timeZone;
    }

    public static ZoneOffset g(int i10) {
        return ZoneOffset.Y(i10 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f13805g != null ? (byte) 100 : (byte) 1, this);
    }

    public static int c(long j10, ZoneOffset zoneOffset) {
        return j$.time.h.c0(Math.floorDiv(j10 + ((long) zoneOffset.f13556b), 86400)).f13701a;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f13805g;
        if (timeZone != null) {
            return g(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f13801c;
        if (jArr.length == 0) {
            return this.f13800b[0];
        }
        long j10 = instant.f13542a;
        if (this.f13804f.length > 0 && j10 > jArr[jArr.length - 1]) {
            b[] bVarArrB = b(c(j10, this.f13803e[r8.length - 1]));
            b bVar = null;
            for (int i10 = 0; i10 < bVarArrB.length; i10++) {
                bVar = bVarArrB[i10];
                if (j10 < bVar.f13780a) {
                    return bVar.f13782c;
                }
            }
            return bVar.f13783d;
        }
        int iBinarySearch = Arrays.binarySearch(jArr, j10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return this.f13803e[iBinarySearch + 1];
    }

    public final List f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (!(objE instanceof b)) {
            return Collections.singletonList((ZoneOffset) objE);
        }
        b bVar = (b) objE;
        return bVar.s() ? Collections.EMPTY_LIST : j$.time.b.a(new Object[]{bVar.f13782c, bVar.f13783d});
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (r8.s(r0) > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
    
        if (r8.f13547b.d0() <= r0.f13547b.d0()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(j$.time.LocalDateTime r8) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.e(j$.time.LocalDateTime):java.lang.Object");
    }

    public final b[] b(int i10) {
        j$.time.h hVarA;
        b[] bVarArr = f13798l;
        Integer numValueOf = Integer.valueOf(i10);
        b[] bVarArr2 = (b[]) ((ConcurrentHashMap) this.f13806h).get(numValueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j10 = 1;
        int i11 = 0;
        int i12 = 1;
        if (this.f13805g != null) {
            if (i10 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.f13544c;
            j$.time.h hVarB0 = j$.time.h.b0(i10 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.X(0);
            long jW = new LocalDateTime(hVarB0, l.f13711h[0]).w(this.f13800b[0]);
            long j11 = 1000;
            int offset = this.f13805g.getOffset(jW * 1000);
            long j12 = 31968000 + jW;
            while (jW < j12) {
                long j13 = jW + 7776000;
                long j14 = j11;
                if (offset != this.f13805g.getOffset(j13 * j14)) {
                    while (j13 - jW > j10) {
                        long jFloorDiv = Math.floorDiv(j13 + jW, 2L);
                        if (this.f13805g.getOffset(jFloorDiv * j14) == offset) {
                            jW = jFloorDiv;
                        } else {
                            j13 = jFloorDiv;
                        }
                        j10 = 1;
                    }
                    if (this.f13805g.getOffset(jW * j14) == offset) {
                        jW = j13;
                    }
                    ZoneOffset zoneOffsetG = g(offset);
                    int offset2 = this.f13805g.getOffset(jW * j14);
                    ZoneOffset zoneOffsetG2 = g(offset2);
                    if (c(jW, zoneOffsetG2) == i10) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(jW, zoneOffsetG, zoneOffsetG2);
                    }
                    offset = offset2;
                } else {
                    jW = j13;
                }
                j11 = j14;
                j10 = 1;
            }
            if (1916 <= i10 && i10 < 2100) {
                ((ConcurrentHashMap) this.f13806h).putIfAbsent(numValueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f13804f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i13 = 0;
        while (i13 < eVarArr.length) {
            e eVar = eVarArr[i13];
            byte b10 = eVar.f13787b;
            if (b10 < 0) {
                n nVar = eVar.f13786a;
                long j15 = i10;
                s.f13607c.getClass();
                int iA = nVar.A(s.X(j15)) + 1 + eVar.f13787b;
                j$.time.h hVar = j$.time.h.f13699d;
                j$.time.temporal.a.YEAR.X(j15);
                j$.time.temporal.a.DAY_OF_MONTH.X(iA);
                hVarA = j$.time.h.A(i10, nVar.getValue(), iA);
                DayOfWeek dayOfWeek = eVar.f13788c;
                if (dayOfWeek != null) {
                    hVarA = hVarA.k(new o(dayOfWeek.getValue(), i12));
                }
            } else {
                n nVar2 = eVar.f13786a;
                j$.time.h hVar2 = j$.time.h.f13699d;
                j$.time.temporal.a.YEAR.X(i10);
                j$.time.temporal.a.DAY_OF_MONTH.X(b10);
                hVarA = j$.time.h.A(i10, nVar2.getValue(), b10);
                DayOfWeek dayOfWeek2 = eVar.f13788c;
                if (dayOfWeek2 != null) {
                    hVarA = hVarA.k(new o(dayOfWeek2.getValue(), i11));
                }
            }
            if (eVar.f13790e) {
                hVarA = hVarA.f0(1L);
            }
            LocalDateTime localDateTimeI = LocalDateTime.I(hVarA, eVar.f13789d);
            d dVar = eVar.f13791f;
            ZoneOffset zoneOffset = eVar.f13792g;
            ZoneOffset zoneOffset2 = eVar.f13793h;
            int i14 = c.f13784a[dVar.ordinal()];
            if (i14 == 1) {
                localDateTimeI = localDateTimeI.X(zoneOffset2.f13556b - ZoneOffset.UTC.f13556b);
            } else if (i14 == 2) {
                localDateTimeI = localDateTimeI.X(zoneOffset2.f13556b - zoneOffset.f13556b);
            }
            bVarArr3[i13] = new b(localDateTimeI, eVar.f13793h, eVar.f13794i);
            i13++;
            i11 = 0;
        }
        if (i10 < 2100) {
            ((ConcurrentHashMap) this.f13806h).putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.f13805g, fVar.f13805g) && Arrays.equals(this.f13799a, fVar.f13799a) && Arrays.equals(this.f13800b, fVar.f13800b) && Arrays.equals(this.f13801c, fVar.f13801c) && Arrays.equals(this.f13803e, fVar.f13803e) && Arrays.equals(this.f13804f, fVar.f13804f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f13805g) ^ Arrays.hashCode(this.f13799a)) ^ Arrays.hashCode(this.f13800b)) ^ Arrays.hashCode(this.f13801c)) ^ Arrays.hashCode(this.f13803e)) ^ Arrays.hashCode(this.f13804f);
    }

    public final String toString() {
        TimeZone timeZone = this.f13805g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f13800b[r0.length - 1] + "]";
    }
}
