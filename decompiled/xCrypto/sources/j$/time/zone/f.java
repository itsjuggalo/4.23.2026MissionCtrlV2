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

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long[] f13359i = new long[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final e[] f13360j = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final LocalDateTime[] f13361k = new LocalDateTime[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b[] f13362l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f13363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset[] f13364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f13365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocalDateTime[] f13366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ZoneOffset[] f13367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e[] f13368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeZone f13369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient ConcurrentHashMap f13370h = new ConcurrentHashMap();

    public static f h(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        return new f(zoneOffset);
    }

    private f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f13363a = jArr;
        this.f13364b = zoneOffsetArr;
        this.f13365c = jArr2;
        this.f13367e = zoneOffsetArr2;
        this.f13368f = eVarArr;
        if (jArr2.length == 0) {
            this.f13366d = f13361k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (i4 < jArr2.length) {
                int i5 = i4 + 1;
                b bVar = new b(jArr2[i4], zoneOffsetArr2[i4], zoneOffsetArr2[i5]);
                if (bVar.W()) {
                    arrayList.add(bVar.r());
                    arrayList.add(bVar.p());
                } else {
                    arrayList.add(bVar.p());
                    arrayList.add(bVar.r());
                }
                i4 = i5;
            }
            this.f13366d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f13369g = null;
    }

    private f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f13364b = zoneOffsetArr;
        long[] jArr = f13359i;
        this.f13363a = jArr;
        this.f13365c = jArr;
        this.f13366d = f13361k;
        this.f13367e = zoneOffsetArr;
        this.f13368f = f13360j;
        this.f13369g = null;
    }

    f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {i(timeZone.getRawOffset())};
        this.f13364b = zoneOffsetArr;
        long[] jArr = f13359i;
        this.f13363a = jArr;
        this.f13365c = jArr;
        this.f13366d = f13361k;
        this.f13367e = zoneOffsetArr;
        this.f13368f = f13360j;
        this.f13369g = timeZone;
    }

    private static ZoneOffset i(int i4) {
        return ZoneOffset.c0(i4 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f13369g != null ? (byte) 100 : (byte) 1, this);
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        long[] jArr = this.f13363a;
        objectOutput.writeInt(jArr.length);
        for (long j4 : jArr) {
            a.c(j4, objectOutput);
        }
        for (ZoneOffset zoneOffset : this.f13364b) {
            a.d(zoneOffset, objectOutput);
        }
        long[] jArr2 = this.f13365c;
        objectOutput.writeInt(jArr2.length);
        for (long j5 : jArr2) {
            a.c(j5, objectOutput);
        }
        for (ZoneOffset zoneOffset2 : this.f13367e) {
            a.d(zoneOffset2, objectOutput);
        }
        e[] eVarArr = this.f13368f;
        objectOutput.writeByte(eVarArr.length);
        for (e eVar : eVarArr) {
            eVar.writeExternal(objectOutput);
        }
    }

    final void k(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.f13369g.getID());
    }

    static f j(ObjectInput objectInput) throws IOException {
        int i4 = objectInput.readInt();
        long[] jArr = f13359i;
        long[] jArr2 = i4 == 0 ? jArr : new long[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            jArr2[i5] = a.a(objectInput);
        }
        int i6 = i4 + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            zoneOffsetArr[i7] = a.b(objectInput);
        }
        int i8 = objectInput.readInt();
        if (i8 != 0) {
            jArr = new long[i8];
        }
        long[] jArr3 = jArr;
        for (int i9 = 0; i9 < i8; i9++) {
            jArr3[i9] = a.a(objectInput);
        }
        int i10 = i8 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            zoneOffsetArr2[i11] = a.b(objectInput);
        }
        int i12 = objectInput.readByte();
        e[] eVarArr = i12 == 0 ? f13360j : new e[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            eVarArr[i13] = e.b(objectInput);
        }
        return new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f13369g;
        if (timeZone != null) {
            return i(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f13365c;
        if (jArr.length == 0) {
            return this.f13364b[0];
        }
        long epochSecond = instant.getEpochSecond();
        int length = this.f13368f.length;
        ZoneOffset[] zoneOffsetArr = this.f13367e;
        if (length > 0 && epochSecond > jArr[jArr.length - 1]) {
            b[] bVarArrB = b(c(epochSecond, zoneOffsetArr[zoneOffsetArr.length - 1]));
            b bVar = null;
            for (int i4 = 0; i4 < bVarArrB.length; i4++) {
                bVar = bVarArrB[i4];
                if (epochSecond < bVar.O()) {
                    return bVar.S();
                }
            }
            return bVar.J();
        }
        int iBinarySearch = Arrays.binarySearch(jArr, epochSecond);
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
        ZoneOffset[] zoneOffsetArr = this.f13364b;
        int i4 = 0;
        TimeZone timeZone = this.f13369g;
        if (timeZone != null) {
            b[] bVarArrB = b(localDateTime.c0());
            if (bVarArrB.length == 0) {
                return i(timeZone.getOffset(localDateTime.Y(zoneOffsetArr[0]) * 1000));
            }
            int length = bVarArrB.length;
            while (i4 < length) {
                b bVar = bVarArrB[i4];
                Object objA = a(localDateTime, bVar);
                if ((objA instanceof b) || objA.equals(bVar.S())) {
                    return objA;
                }
                i4++;
                obj = objA;
            }
            return obj;
        }
        if (this.f13365c.length == 0) {
            return zoneOffsetArr[0];
        }
        int length2 = this.f13368f.length;
        LocalDateTime[] localDateTimeArr = this.f13366d;
        if (length2 > 0 && localDateTime.d0(localDateTimeArr[localDateTimeArr.length - 1])) {
            b[] bVarArrB2 = b(localDateTime.c0());
            int length3 = bVarArrB2.length;
            while (i4 < length3) {
                b bVar2 = bVarArrB2[i4];
                Object objA2 = a(localDateTime, bVar2);
                if ((objA2 instanceof b) || objA2.equals(bVar2.S())) {
                    return objA2;
                }
                i4++;
                obj = objA2;
            }
            return obj;
        }
        int iBinarySearch = Arrays.binarySearch(localDateTimeArr, localDateTime);
        ZoneOffset[] zoneOffsetArr2 = this.f13367e;
        if (iBinarySearch == -1) {
            return zoneOffsetArr2[0];
        }
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        } else if (iBinarySearch < localDateTimeArr.length - 1) {
            int i5 = iBinarySearch + 1;
            if (localDateTimeArr[iBinarySearch].equals(localDateTimeArr[i5])) {
                iBinarySearch = i5;
            }
        }
        if ((iBinarySearch & 1) == 0) {
            LocalDateTime localDateTime2 = localDateTimeArr[iBinarySearch];
            LocalDateTime localDateTime3 = localDateTimeArr[iBinarySearch + 1];
            int i6 = iBinarySearch / 2;
            ZoneOffset zoneOffset = zoneOffsetArr2[i6];
            ZoneOffset zoneOffset2 = zoneOffsetArr2[i6 + 1];
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

    private b[] b(int i4) {
        Integer numValueOf = Integer.valueOf(i4);
        ConcurrentHashMap concurrentHashMap = this.f13370h;
        b[] bVarArr = (b[]) concurrentHashMap.get(numValueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        TimeZone timeZone = this.f13369g;
        if (timeZone != null) {
            b[] bVarArr2 = f13362l;
            if (i4 < 1800) {
                return bVarArr2;
            }
            long jY = LocalDateTime.f0(i4 - 1).Y(this.f13364b[0]);
            long j4 = 1000;
            int offset = timeZone.getOffset(jY * 1000);
            long j5 = 31968000 + jY;
            while (jY < j5) {
                long j6 = 7776000 + jY;
                long j7 = j4;
                if (offset != timeZone.getOffset(j6 * j7)) {
                    while (j6 - jY > 1) {
                        int i5 = offset;
                        long jFloorDiv = Math.floorDiv(j6 + jY, 2L);
                        if (timeZone.getOffset(jFloorDiv * j7) == i5) {
                            jY = jFloorDiv;
                        } else {
                            j6 = jFloorDiv;
                        }
                        offset = i5;
                    }
                    int i6 = offset;
                    if (timeZone.getOffset(jY * j7) == i6) {
                        jY = j6;
                    }
                    ZoneOffset zoneOffsetI = i(i6);
                    offset = timeZone.getOffset(jY * j7);
                    ZoneOffset zoneOffsetI2 = i(offset);
                    if (c(jY, zoneOffsetI2) == i4) {
                        bVarArr2 = (b[]) Arrays.copyOf(bVarArr2, bVarArr2.length + 1);
                        bVarArr2[bVarArr2.length - 1] = new b(jY, zoneOffsetI, zoneOffsetI2);
                    }
                } else {
                    jY = j6;
                }
                j4 = j7;
            }
            if (1916 <= i4 && i4 < 2100) {
                concurrentHashMap.putIfAbsent(numValueOf, bVarArr2);
            }
            return bVarArr2;
        }
        e[] eVarArr = this.f13368f;
        b[] bVarArr3 = new b[eVarArr.length];
        for (int i7 = 0; i7 < eVarArr.length; i7++) {
            bVarArr3[i7] = eVarArr[i7].a(i4);
        }
        if (i4 < 2100) {
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
            if (Objects.equals(this.f13369g, fVar.f13369g) && Arrays.equals(this.f13363a, fVar.f13363a) && Arrays.equals(this.f13364b, fVar.f13364b) && Arrays.equals(this.f13365c, fVar.f13365c) && Arrays.equals(this.f13367e, fVar.f13367e) && Arrays.equals(this.f13368f, fVar.f13368f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f13369g) ^ Arrays.hashCode(this.f13363a)) ^ Arrays.hashCode(this.f13364b)) ^ Arrays.hashCode(this.f13365c)) ^ Arrays.hashCode(this.f13367e)) ^ Arrays.hashCode(this.f13368f);
    }

    public final String toString() {
        TimeZone timeZone = this.f13369g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f13364b[r1.length - 1] + "]";
    }
}
