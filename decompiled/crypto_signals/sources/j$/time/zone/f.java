package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Serializable {
    private static final long[] i = new long[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final e[] f7592j = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final LocalDateTime[] f7593k = new LocalDateTime[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b[] f7594l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f7595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset[] f7596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f7597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocalDateTime[] f7598d;
    private final ZoneOffset[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e[] f7599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeZone f7600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient ConcurrentHashMap f7601h = new ConcurrentHashMap();

    public static f h(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return new f(zoneOffset);
    }

    private f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f7595a = jArr;
        this.f7596b = zoneOffsetArr;
        this.f7597c = jArr2;
        this.e = zoneOffsetArr2;
        this.f7599f = eVarArr;
        if (jArr2.length == 0) {
            this.f7598d = f7593k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 < jArr2.length) {
                int i7 = i6 + 1;
                b bVar = new b(jArr2[i6], zoneOffsetArr2[i6], zoneOffsetArr2[i7]);
                if (bVar.W()) {
                    arrayList.add(bVar.r());
                    arrayList.add(bVar.p());
                } else {
                    arrayList.add(bVar.p());
                    arrayList.add(bVar.r());
                }
                i6 = i7;
            }
            this.f7598d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f7600g = null;
    }

    private f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f7596b = zoneOffsetArr;
        long[] jArr = i;
        this.f7595a = jArr;
        this.f7597c = jArr;
        this.f7598d = f7593k;
        this.e = zoneOffsetArr;
        this.f7599f = f7592j;
        this.f7600g = null;
    }

    f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {i(timeZone.getRawOffset())};
        this.f7596b = zoneOffsetArr;
        long[] jArr = i;
        this.f7595a = jArr;
        this.f7597c = jArr;
        this.f7598d = f7593k;
        this.e = zoneOffsetArr;
        this.f7599f = f7592j;
        this.f7600g = timeZone;
    }

    private static ZoneOffset i(int i6) {
        return ZoneOffset.c0(i6 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f7600g != null ? (byte) 100 : (byte) 1, this);
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        long[] jArr = this.f7595a;
        objectOutput.writeInt(jArr.length);
        for (long j4 : jArr) {
            a.c(j4, objectOutput);
        }
        for (ZoneOffset zoneOffset : this.f7596b) {
            a.d(zoneOffset, objectOutput);
        }
        long[] jArr2 = this.f7597c;
        objectOutput.writeInt(jArr2.length);
        for (long j6 : jArr2) {
            a.c(j6, objectOutput);
        }
        for (ZoneOffset zoneOffset2 : this.e) {
            a.d(zoneOffset2, objectOutput);
        }
        e[] eVarArr = this.f7599f;
        objectOutput.writeByte(eVarArr.length);
        for (e eVar : eVarArr) {
            eVar.writeExternal(objectOutput);
        }
    }

    final void k(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.f7600g.getID());
    }

    static f j(ObjectInput objectInput) throws IOException {
        int i6 = objectInput.readInt();
        long[] jArr = i;
        long[] jArr2 = i6 == 0 ? jArr : new long[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            jArr2[i7] = a.a(objectInput);
        }
        int i8 = i6 + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            zoneOffsetArr[i9] = a.b(objectInput);
        }
        int i10 = objectInput.readInt();
        if (i10 != 0) {
            jArr = new long[i10];
        }
        long[] jArr3 = jArr;
        for (int i11 = 0; i11 < i10; i11++) {
            jArr3[i11] = a.a(objectInput);
        }
        int i12 = i10 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            zoneOffsetArr2[i13] = a.b(objectInput);
        }
        int i14 = objectInput.readByte();
        e[] eVarArr = i14 == 0 ? f7592j : new e[i14];
        for (int i15 = 0; i15 < i14; i15++) {
            eVarArr[i15] = e.b(objectInput);
        }
        return new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f7600g;
        if (timeZone != null) {
            return i(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f7597c;
        if (jArr.length == 0) {
            return this.f7596b[0];
        }
        long jC = instant.C();
        int length = this.f7599f.length;
        ZoneOffset[] zoneOffsetArr = this.e;
        if (length > 0 && jC > jArr[jArr.length - 1]) {
            b[] bVarArrB = b(c(jC, zoneOffsetArr[zoneOffsetArr.length - 1]));
            b bVar = null;
            for (int i6 = 0; i6 < bVarArrB.length; i6++) {
                bVar = bVarArrB[i6];
                if (jC < bVar.O()) {
                    return bVar.S();
                }
            }
            return bVar.J();
        }
        int iBinarySearch = Arrays.binarySearch(jArr, jC);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        return zoneOffsetArr[iBinarySearch + 1];
    }

    public final List g(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (objE instanceof b) {
            return ((b) objE).T();
        }
        return Collections.singletonList((ZoneOffset) objE);
    }

    public final b f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (objE instanceof b) {
            return (b) objE;
        }
        return null;
    }

    private Object e(LocalDateTime localDateTime) {
        Object obj = null;
        ZoneOffset[] zoneOffsetArr = this.f7596b;
        int i6 = 0;
        TimeZone timeZone = this.f7600g;
        if (timeZone != null) {
            b[] bVarArrB = b(localDateTime.c0());
            if (bVarArrB.length == 0) {
                return i(timeZone.getOffset(localDateTime.Y(zoneOffsetArr[0]) * 1000));
            }
            int length = bVarArrB.length;
            while (i6 < length) {
                b bVar = bVarArrB[i6];
                Object objA = a(localDateTime, bVar);
                if ((objA instanceof b) || objA.equals(bVar.S())) {
                    return objA;
                }
                i6++;
                obj = objA;
            }
            return obj;
        }
        if (this.f7597c.length == 0) {
            return zoneOffsetArr[0];
        }
        int length2 = this.f7599f.length;
        LocalDateTime[] localDateTimeArr = this.f7598d;
        if (length2 > 0 && localDateTime.d0(localDateTimeArr[localDateTimeArr.length - 1])) {
            b[] bVarArrB2 = b(localDateTime.c0());
            int length3 = bVarArrB2.length;
            while (i6 < length3) {
                b bVar2 = bVarArrB2[i6];
                Object objA2 = a(localDateTime, bVar2);
                if ((objA2 instanceof b) || objA2.equals(bVar2.S())) {
                    return objA2;
                }
                i6++;
                obj = objA2;
            }
            return obj;
        }
        int iBinarySearch = Arrays.binarySearch(localDateTimeArr, localDateTime);
        ZoneOffset[] zoneOffsetArr2 = this.e;
        if (iBinarySearch == -1) {
            return zoneOffsetArr2[0];
        }
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        } else if (iBinarySearch < localDateTimeArr.length - 1) {
            int i7 = iBinarySearch + 1;
            if (localDateTimeArr[iBinarySearch].equals(localDateTimeArr[i7])) {
                iBinarySearch = i7;
            }
        }
        if ((iBinarySearch & 1) == 0) {
            LocalDateTime localDateTime2 = localDateTimeArr[iBinarySearch];
            LocalDateTime localDateTime3 = localDateTimeArr[iBinarySearch + 1];
            int i8 = iBinarySearch / 2;
            ZoneOffset zoneOffset = zoneOffsetArr2[i8];
            ZoneOffset zoneOffset2 = zoneOffsetArr2[i8 + 1];
            if (zoneOffset2.Z() > zoneOffset.Z()) {
                return new b(localDateTime2, zoneOffset, zoneOffset2);
            }
            return new b(localDateTime3, zoneOffset, zoneOffset2);
        }
        return zoneOffsetArr2[(iBinarySearch / 2) + 1];
    }

    private static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTimeR = bVar.r();
        if (bVar.W()) {
            if (localDateTime.e0(localDateTimeR)) {
                return bVar.S();
            }
            if (!localDateTime.e0(bVar.p())) {
                return bVar.J();
            }
        } else {
            if (!localDateTime.e0(localDateTimeR)) {
                return bVar.J();
            }
            if (localDateTime.e0(bVar.p())) {
                return bVar.S();
            }
        }
        return bVar;
    }

    private b[] b(int i6) {
        Integer numValueOf = Integer.valueOf(i6);
        ConcurrentHashMap concurrentHashMap = this.f7601h;
        b[] bVarArr = (b[]) concurrentHashMap.get(numValueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        TimeZone timeZone = this.f7600g;
        if (timeZone != null) {
            b[] bVarArr2 = f7594l;
            if (i6 < 1800) {
                return bVarArr2;
            }
            long jY = LocalDateTime.f0(i6 - 1).Y(this.f7596b[0]);
            long j4 = 1000;
            int offset = timeZone.getOffset(jY * 1000);
            long j6 = 31968000 + jY;
            while (jY < j6) {
                long j7 = 7776000 + jY;
                long j8 = j4;
                if (offset != timeZone.getOffset(j7 * j8)) {
                    while (j7 - jY > 1) {
                        int i7 = offset;
                        long jFloorDiv = Math.floorDiv(j7 + jY, 2L);
                        if (timeZone.getOffset(jFloorDiv * j8) == i7) {
                            jY = jFloorDiv;
                        } else {
                            j7 = jFloorDiv;
                        }
                        offset = i7;
                    }
                    int i8 = offset;
                    if (timeZone.getOffset(jY * j8) == i8) {
                        jY = j7;
                    }
                    ZoneOffset zoneOffsetI = i(i8);
                    offset = timeZone.getOffset(jY * j8);
                    ZoneOffset zoneOffsetI2 = i(offset);
                    if (c(jY, zoneOffsetI2) == i6) {
                        bVarArr2 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length + 1);
                        bVarArr2[bVarArr2.length - 1] = new b(jY, zoneOffsetI, zoneOffsetI2);
                    }
                } else {
                    jY = j7;
                }
                j4 = j8;
            }
            if (1916 <= i6 && i6 < 2100) {
                concurrentHashMap.putIfAbsent(numValueOf, bVarArr2);
            }
            return bVarArr2;
        }
        e[] eVarArr = this.f7599f;
        b[] bVarArr3 = new b[eVarArr.length];
        for (int i9 = 0; i9 < eVarArr.length; i9++) {
            bVarArr3[i9] = eVarArr[i9].a(i6);
        }
        if (i6 < 2100) {
            concurrentHashMap.putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    private static int c(long j4, ZoneOffset zoneOffset) {
        return j$.time.g.i0(Math.floorDiv(j4 + ((long) zoneOffset.Z()), 86400)).b0();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.f7600g, fVar.f7600g) && Arrays.equals(this.f7595a, fVar.f7595a) && Arrays.equals(this.f7596b, fVar.f7596b) && Arrays.equals(this.f7597c, fVar.f7597c) && Arrays.equals(this.e, fVar.e) && Arrays.equals(this.f7599f, fVar.f7599f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f7600g) ^ Arrays.hashCode(this.f7595a)) ^ Arrays.hashCode(this.f7596b)) ^ Arrays.hashCode(this.f7597c)) ^ Arrays.hashCode(this.e)) ^ Arrays.hashCode(this.f7599f);
    }

    public final String toString() {
        TimeZone timeZone = this.f7600g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f7596b[r1.length - 1] + "]";
    }
}
