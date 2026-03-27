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

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long[] f17320i = new long[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final e[] f17321j = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final LocalDateTime[] f17322k = new LocalDateTime[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b[] f17323l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f17324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset[] f17325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f17326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocalDateTime[] f17327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ZoneOffset[] f17328e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e[] f17329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeZone f17330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient ConcurrentHashMap f17331h = new ConcurrentHashMap();

    public static f h(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        return new f(zoneOffset);
    }

    private f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f17324a = jArr;
        this.f17325b = zoneOffsetArr;
        this.f17326c = jArr2;
        this.f17328e = zoneOffsetArr2;
        this.f17329f = eVarArr;
        if (jArr2.length == 0) {
            this.f17327d = f17322k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            while (i7 < jArr2.length) {
                int i8 = i7 + 1;
                b bVar = new b(jArr2[i7], zoneOffsetArr2[i7], zoneOffsetArr2[i8]);
                if (bVar.W()) {
                    arrayList.add(bVar.r());
                    arrayList.add(bVar.p());
                } else {
                    arrayList.add(bVar.p());
                    arrayList.add(bVar.r());
                }
                i7 = i8;
            }
            this.f17327d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f17330g = null;
    }

    private f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f17325b = zoneOffsetArr;
        long[] jArr = f17320i;
        this.f17324a = jArr;
        this.f17326c = jArr;
        this.f17327d = f17322k;
        this.f17328e = zoneOffsetArr;
        this.f17329f = f17321j;
        this.f17330g = null;
    }

    f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {i(timeZone.getRawOffset())};
        this.f17325b = zoneOffsetArr;
        long[] jArr = f17320i;
        this.f17324a = jArr;
        this.f17326c = jArr;
        this.f17327d = f17322k;
        this.f17328e = zoneOffsetArr;
        this.f17329f = f17321j;
        this.f17330g = timeZone;
    }

    private static ZoneOffset i(int i7) {
        return ZoneOffset.c0(i7 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f17330g != null ? (byte) 100 : (byte) 1, this);
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        long[] jArr = this.f17324a;
        objectOutput.writeInt(jArr.length);
        for (long j7 : jArr) {
            a.c(j7, objectOutput);
        }
        for (ZoneOffset zoneOffset : this.f17325b) {
            a.d(zoneOffset, objectOutput);
        }
        long[] jArr2 = this.f17326c;
        objectOutput.writeInt(jArr2.length);
        for (long j8 : jArr2) {
            a.c(j8, objectOutput);
        }
        for (ZoneOffset zoneOffset2 : this.f17328e) {
            a.d(zoneOffset2, objectOutput);
        }
        e[] eVarArr = this.f17329f;
        objectOutput.writeByte(eVarArr.length);
        for (e eVar : eVarArr) {
            eVar.writeExternal(objectOutput);
        }
    }

    final void k(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.f17330g.getID());
    }

    static f j(ObjectInput objectInput) throws IOException {
        int i7 = objectInput.readInt();
        long[] jArr = f17320i;
        long[] jArr2 = i7 == 0 ? jArr : new long[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            jArr2[i8] = a.a(objectInput);
        }
        int i9 = i7 + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            zoneOffsetArr[i10] = a.b(objectInput);
        }
        int i11 = objectInput.readInt();
        if (i11 != 0) {
            jArr = new long[i11];
        }
        long[] jArr3 = jArr;
        for (int i12 = 0; i12 < i11; i12++) {
            jArr3[i12] = a.a(objectInput);
        }
        int i13 = i11 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            zoneOffsetArr2[i14] = a.b(objectInput);
        }
        int i15 = objectInput.readByte();
        e[] eVarArr = i15 == 0 ? f17321j : new e[i15];
        for (int i16 = 0; i16 < i15; i16++) {
            eVarArr[i16] = e.b(objectInput);
        }
        return new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f17330g;
        if (timeZone != null) {
            return i(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f17326c;
        if (jArr.length == 0) {
            return this.f17325b[0];
        }
        long jC = instant.C();
        int length = this.f17329f.length;
        ZoneOffset[] zoneOffsetArr = this.f17328e;
        if (length > 0 && jC > jArr[jArr.length - 1]) {
            b[] bVarArrB = b(c(jC, zoneOffsetArr[zoneOffsetArr.length - 1]));
            b bVar = null;
            for (int i7 = 0; i7 < bVarArrB.length; i7++) {
                bVar = bVarArrB[i7];
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
        ZoneOffset[] zoneOffsetArr = this.f17325b;
        int i7 = 0;
        TimeZone timeZone = this.f17330g;
        if (timeZone != null) {
            b[] bVarArrB = b(localDateTime.c0());
            if (bVarArrB.length == 0) {
                return i(timeZone.getOffset(localDateTime.Y(zoneOffsetArr[0]) * 1000));
            }
            int length = bVarArrB.length;
            while (i7 < length) {
                b bVar = bVarArrB[i7];
                Object objA = a(localDateTime, bVar);
                if ((objA instanceof b) || objA.equals(bVar.S())) {
                    return objA;
                }
                i7++;
                obj = objA;
            }
            return obj;
        }
        if (this.f17326c.length == 0) {
            return zoneOffsetArr[0];
        }
        int length2 = this.f17329f.length;
        LocalDateTime[] localDateTimeArr = this.f17327d;
        if (length2 > 0 && localDateTime.d0(localDateTimeArr[localDateTimeArr.length - 1])) {
            b[] bVarArrB2 = b(localDateTime.c0());
            int length3 = bVarArrB2.length;
            while (i7 < length3) {
                b bVar2 = bVarArrB2[i7];
                Object objA2 = a(localDateTime, bVar2);
                if ((objA2 instanceof b) || objA2.equals(bVar2.S())) {
                    return objA2;
                }
                i7++;
                obj = objA2;
            }
            return obj;
        }
        int iBinarySearch = Arrays.binarySearch(localDateTimeArr, localDateTime);
        ZoneOffset[] zoneOffsetArr2 = this.f17328e;
        if (iBinarySearch == -1) {
            return zoneOffsetArr2[0];
        }
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        } else if (iBinarySearch < localDateTimeArr.length - 1) {
            int i8 = iBinarySearch + 1;
            if (localDateTimeArr[iBinarySearch].equals(localDateTimeArr[i8])) {
                iBinarySearch = i8;
            }
        }
        if ((iBinarySearch & 1) == 0) {
            LocalDateTime localDateTime2 = localDateTimeArr[iBinarySearch];
            LocalDateTime localDateTime3 = localDateTimeArr[iBinarySearch + 1];
            int i9 = iBinarySearch / 2;
            ZoneOffset zoneOffset = zoneOffsetArr2[i9];
            ZoneOffset zoneOffset2 = zoneOffsetArr2[i9 + 1];
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
            return localDateTime.e0(bVar.p()) ? bVar : bVar.J();
        }
        if (localDateTime.e0(localDateTimeR)) {
            return localDateTime.e0(bVar.p()) ? bVar.S() : bVar;
        }
        return bVar.J();
    }

    private b[] b(int i7) {
        long j7;
        Integer numValueOf = Integer.valueOf(i7);
        ConcurrentHashMap concurrentHashMap = this.f17331h;
        b[] bVarArr = (b[]) concurrentHashMap.get(numValueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        TimeZone timeZone = this.f17330g;
        if (timeZone != null) {
            b[] bVarArr2 = f17323l;
            if (i7 < 1800) {
                return bVarArr2;
            }
            long jY = LocalDateTime.f0(i7 - 1).Y(this.f17325b[0]);
            int offset = timeZone.getOffset(jY * 1000);
            long j8 = 31968000 + jY;
            while (jY < j8) {
                long j9 = 7776000 + jY;
                long j10 = jY;
                if (offset != timeZone.getOffset(j9 * 1000)) {
                    jY = j10;
                    while (j9 - jY > 1) {
                        int i8 = offset;
                        long j11 = j8;
                        long jFloorDiv = Math.floorDiv(j9 + jY, 2L);
                        if (timeZone.getOffset(jFloorDiv * 1000) == i8) {
                            jY = jFloorDiv;
                        } else {
                            j9 = jFloorDiv;
                        }
                        offset = i8;
                        j8 = j11;
                    }
                    j7 = j8;
                    int i9 = offset;
                    if (timeZone.getOffset(jY * 1000) == i9) {
                        jY = j9;
                    }
                    ZoneOffset zoneOffsetI = i(i9);
                    offset = timeZone.getOffset(jY * 1000);
                    ZoneOffset zoneOffsetI2 = i(offset);
                    if (c(jY, zoneOffsetI2) == i7) {
                        bVarArr2 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length + 1);
                        bVarArr2[bVarArr2.length - 1] = new b(jY, zoneOffsetI, zoneOffsetI2);
                    }
                } else {
                    j7 = j8;
                    jY = j9;
                }
                j8 = j7;
            }
            if (1916 <= i7 && i7 < 2100) {
                concurrentHashMap.putIfAbsent(numValueOf, bVarArr2);
            }
            return bVarArr2;
        }
        e[] eVarArr = this.f17329f;
        b[] bVarArr3 = new b[eVarArr.length];
        for (int i10 = 0; i10 < eVarArr.length; i10++) {
            bVarArr3[i10] = eVarArr[i10].a(i7);
        }
        if (i7 < 2100) {
            concurrentHashMap.putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    private static int c(long j7, ZoneOffset zoneOffset) {
        return j$.time.h.i0(Math.floorDiv(j7 + ((long) zoneOffset.Z()), 86400)).b0();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Objects.equals(this.f17330g, fVar.f17330g) && Arrays.equals(this.f17324a, fVar.f17324a) && Arrays.equals(this.f17325b, fVar.f17325b) && Arrays.equals(this.f17326c, fVar.f17326c) && Arrays.equals(this.f17328e, fVar.f17328e) && Arrays.equals(this.f17329f, fVar.f17329f);
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f17330g) ^ Arrays.hashCode(this.f17324a)) ^ Arrays.hashCode(this.f17325b)) ^ Arrays.hashCode(this.f17326c)) ^ Arrays.hashCode(this.f17328e)) ^ Arrays.hashCode(this.f17329f);
    }

    public final String toString() {
        TimeZone timeZone = this.f17330g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f17325b[r1.length - 1] + "]";
    }
}
