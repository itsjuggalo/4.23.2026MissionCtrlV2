package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
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

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long[] f19897i = new long[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final e[] f19898j = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final LocalDateTime[] f19899k = new LocalDateTime[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b[] f19900l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f19901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ZoneOffset[] f19902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f19903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocalDateTime[] f19904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ZoneOffset[] f19905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e[] f19906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeZone f19907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient ConcurrentHashMap f19908h = new ConcurrentHashMap();

    private f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f19902b = zoneOffsetArr;
        long[] jArr = f19897i;
        this.f19901a = jArr;
        this.f19903c = jArr;
        this.f19904d = f19899k;
        this.f19905e = zoneOffsetArr;
        this.f19906f = f19898j;
        this.f19907g = null;
    }

    f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {j(timeZone.getRawOffset())};
        this.f19902b = zoneOffsetArr;
        long[] jArr = f19897i;
        this.f19901a = jArr;
        this.f19903c = jArr;
        this.f19904d = f19899k;
        this.f19905e = zoneOffsetArr;
        this.f19906f = f19898j;
        this.f19907g = timeZone;
    }

    private f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        LocalDateTime localDateTimeQ;
        this.f19901a = jArr;
        this.f19902b = zoneOffsetArr;
        this.f19903c = jArr2;
        this.f19905e = zoneOffsetArr2;
        this.f19906f = eVarArr;
        if (jArr2.length == 0) {
            this.f19904d = f19899k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i8 = 0;
            while (i8 < jArr2.length) {
                int i9 = i8 + 1;
                b bVar = new b(jArr2[i8], zoneOffsetArr2[i8], zoneOffsetArr2[i9]);
                if (bVar.U()) {
                    arrayList.add(bVar.q());
                    localDateTimeQ = bVar.o();
                } else {
                    arrayList.add(bVar.o());
                    localDateTimeQ = bVar.q();
                }
                arrayList.add(localDateTimeQ);
                i8 = i9;
            }
            this.f19904d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.f19907g = null;
    }

    private static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTimeQ = bVar.q();
        boolean zU = bVar.U();
        boolean zC0 = localDateTime.c0(localDateTimeQ);
        return zU ? zC0 ? bVar.M() : localDateTime.c0(bVar.o()) ? bVar : bVar.H() : !zC0 ? bVar.H() : localDateTime.c0(bVar.o()) ? bVar.M() : bVar;
    }

    private b[] b(int i8) {
        long j8;
        Integer numValueOf = Integer.valueOf(i8);
        ConcurrentHashMap concurrentHashMap = this.f19908h;
        b[] bVarArr = (b[]) concurrentHashMap.get(numValueOf);
        if (bVarArr != null) {
            return bVarArr;
        }
        TimeZone timeZone = this.f19907g;
        if (timeZone == null) {
            e[] eVarArr = this.f19906f;
            b[] bVarArr2 = new b[eVarArr.length];
            for (int i9 = 0; i9 < eVarArr.length; i9++) {
                bVarArr2[i9] = eVarArr[i9].a(i8);
            }
            if (i8 < 2100) {
                concurrentHashMap.putIfAbsent(numValueOf, bVarArr2);
            }
            return bVarArr2;
        }
        b[] bVarArr3 = f19900l;
        if (i8 < 1800) {
            return bVarArr3;
        }
        long jW = LocalDateTime.d0(i8 - 1).W(this.f19902b[0]);
        int offset = timeZone.getOffset(jW * 1000);
        long j9 = 31968000 + jW;
        while (jW < j9) {
            long j10 = 7776000 + jW;
            long j11 = jW;
            if (offset != timeZone.getOffset(j10 * 1000)) {
                jW = j11;
                while (j10 - jW > 1) {
                    int i10 = offset;
                    long j12 = j9;
                    long jFloorDiv = Math.floorDiv(j10 + jW, 2L);
                    if (timeZone.getOffset(jFloorDiv * 1000) == i10) {
                        jW = jFloorDiv;
                    } else {
                        j10 = jFloorDiv;
                    }
                    offset = i10;
                    j9 = j12;
                }
                j8 = j9;
                int i11 = offset;
                if (timeZone.getOffset(jW * 1000) == i11) {
                    jW = j10;
                }
                ZoneOffset zoneOffsetJ = j(i11);
                offset = timeZone.getOffset(jW * 1000);
                ZoneOffset zoneOffsetJ2 = j(offset);
                if (c(jW, zoneOffsetJ2) == i8) {
                    bVarArr3 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length + 1);
                    bVarArr3[bVarArr3.length - 1] = new b(jW, zoneOffsetJ, zoneOffsetJ2);
                }
            } else {
                j8 = j9;
                jW = j10;
            }
            j9 = j8;
        }
        if (1916 <= i8 && i8 < 2100) {
            concurrentHashMap.putIfAbsent(numValueOf, bVarArr3);
        }
        return bVarArr3;
    }

    private static int c(long j8, ZoneOffset zoneOffset) {
        return j$.time.h.g0(Math.floorDiv(j8 + ((long) zoneOffset.X()), 86400)).Z();
    }

    private Object e(LocalDateTime localDateTime) {
        Object obj = null;
        ZoneOffset[] zoneOffsetArr = this.f19902b;
        int i8 = 0;
        TimeZone timeZone = this.f19907g;
        if (timeZone != null) {
            b[] bVarArrB = b(localDateTime.a0());
            if (bVarArrB.length == 0) {
                return j(timeZone.getOffset(localDateTime.W(zoneOffsetArr[0]) * 1000));
            }
            int length = bVarArrB.length;
            while (i8 < length) {
                b bVar = bVarArrB[i8];
                Object objA = a(localDateTime, bVar);
                if ((objA instanceof b) || objA.equals(bVar.M())) {
                    return objA;
                }
                i8++;
                obj = objA;
            }
            return obj;
        }
        if (this.f19903c.length == 0) {
            return zoneOffsetArr[0];
        }
        int length2 = this.f19906f.length;
        LocalDateTime[] localDateTimeArr = this.f19904d;
        if (length2 > 0 && localDateTime.b0(localDateTimeArr[localDateTimeArr.length - 1])) {
            b[] bVarArrB2 = b(localDateTime.a0());
            int length3 = bVarArrB2.length;
            while (i8 < length3) {
                b bVar2 = bVarArrB2[i8];
                Object objA2 = a(localDateTime, bVar2);
                if ((objA2 instanceof b) || objA2.equals(bVar2.M())) {
                    return objA2;
                }
                i8++;
                obj = objA2;
            }
            return obj;
        }
        int iBinarySearch = Arrays.binarySearch(localDateTimeArr, localDateTime);
        ZoneOffset[] zoneOffsetArr2 = this.f19905e;
        if (iBinarySearch == -1) {
            return zoneOffsetArr2[0];
        }
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        } else if (iBinarySearch < localDateTimeArr.length - 1) {
            int i9 = iBinarySearch + 1;
            if (localDateTimeArr[iBinarySearch].equals(localDateTimeArr[i9])) {
                iBinarySearch = i9;
            }
        }
        if ((iBinarySearch & 1) != 0) {
            return zoneOffsetArr2[(iBinarySearch / 2) + 1];
        }
        LocalDateTime localDateTime2 = localDateTimeArr[iBinarySearch];
        LocalDateTime localDateTime3 = localDateTimeArr[iBinarySearch + 1];
        int i10 = iBinarySearch / 2;
        ZoneOffset zoneOffset = zoneOffsetArr2[i10];
        ZoneOffset zoneOffset2 = zoneOffsetArr2[i10 + 1];
        return zoneOffset2.X() > zoneOffset.X() ? new b(localDateTime2, zoneOffset, zoneOffset2) : new b(localDateTime3, zoneOffset, zoneOffset2);
    }

    public static f i(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        return new f(zoneOffset);
    }

    private static ZoneOffset j(int i8) {
        return ZoneOffset.a0(i8 / 1000);
    }

    static f k(DataInput dataInput) throws IOException {
        int i8 = dataInput.readInt();
        long[] jArr = f19897i;
        long[] jArr2 = i8 == 0 ? jArr : new long[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            jArr2[i9] = a.a(dataInput);
        }
        int i10 = i8 + 1;
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            zoneOffsetArr[i11] = a.b(dataInput);
        }
        int i12 = dataInput.readInt();
        if (i12 != 0) {
            jArr = new long[i12];
        }
        long[] jArr3 = jArr;
        for (int i13 = 0; i13 < i12; i13++) {
            jArr3[i13] = a.a(dataInput);
        }
        int i14 = i12 + 1;
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[i14];
        for (int i15 = 0; i15 < i14; i15++) {
            zoneOffsetArr2[i15] = a.b(dataInput);
        }
        int i16 = dataInput.readByte();
        e[] eVarArr = i16 == 0 ? f19898j : new e[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            eVarArr[i17] = e.b(dataInput);
        }
        return new f(jArr2, zoneOffsetArr, jArr3, zoneOffsetArr2, eVarArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.f19907g != null ? (byte) 100 : (byte) 1, this);
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.f19907g;
        if (timeZone != null) {
            return j(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f19903c;
        if (jArr.length == 0) {
            return this.f19902b[0];
        }
        long jA = instant.A();
        int length = this.f19906f.length;
        ZoneOffset[] zoneOffsetArr = this.f19905e;
        if (length <= 0 || jA <= jArr[jArr.length - 1]) {
            int iBinarySearch = Arrays.binarySearch(jArr, jA);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            return zoneOffsetArr[iBinarySearch + 1];
        }
        b[] bVarArrB = b(c(jA, zoneOffsetArr[zoneOffsetArr.length - 1]));
        b bVar = null;
        for (int i8 = 0; i8 < bVarArrB.length; i8++) {
            bVar = bVarArrB[i8];
            if (jA < bVar.N()) {
                return bVar.M();
            }
        }
        return bVar.H();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Objects.equals(this.f19907g, fVar.f19907g) && Arrays.equals(this.f19901a, fVar.f19901a) && Arrays.equals(this.f19902b, fVar.f19902b) && Arrays.equals(this.f19903c, fVar.f19903c) && Arrays.equals(this.f19905e, fVar.f19905e) && Arrays.equals(this.f19906f, fVar.f19906f);
    }

    public final b f(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        if (objE instanceof b) {
            return (b) objE;
        }
        return null;
    }

    public final List g(LocalDateTime localDateTime) {
        Object objE = e(localDateTime);
        return objE instanceof b ? ((b) objE).R() : Collections.singletonList((ZoneOffset) objE);
    }

    public final boolean h() {
        b bVar;
        TimeZone timeZone = this.f19907g;
        if (timeZone == null) {
            return this.f19903c.length == 0;
        }
        if (timeZone.useDaylightTime() || timeZone.getDSTSavings() != 0) {
            return false;
        }
        Instant instantM = Instant.M();
        long jA = instantM.A();
        if (instantM.H() > 0 && jA < Long.MAX_VALUE) {
            jA++;
        }
        int iC = c(jA, d(instantM));
        b[] bVarArrB = b(iC);
        int length = bVarArrB.length - 1;
        while (true) {
            if (length >= 0) {
                if (jA > bVarArrB[length].N()) {
                    bVar = bVarArrB[length];
                    break;
                }
                length--;
            } else if (iC > 1800) {
                b[] bVarArrB2 = b(iC - 1);
                int length2 = bVarArrB2.length - 1;
                while (true) {
                    if (length2 < 0) {
                        int offset = timeZone.getOffset((jA - 1) * 1000);
                        long jT = j$.time.h.e0(1800, 1, 1).t() * 86400;
                        for (long jMin = Math.min(jA - 31104000, (j$.time.b.d().b() / 1000) + 31968000); jT <= jMin; jMin -= 7776000) {
                            int offset2 = timeZone.getOffset(jMin * 1000);
                            if (offset != offset2) {
                                int iC2 = c(jMin, j(offset2));
                                b[] bVarArrB3 = b(iC2 + 1);
                                int length3 = bVarArrB3.length - 1;
                                while (true) {
                                    if (length3 < 0) {
                                        b[] bVarArrB4 = b(iC2);
                                        bVar = bVarArrB4[bVarArrB4.length - 1];
                                        break;
                                    }
                                    if (jA > bVarArrB3[length3].N()) {
                                        bVar = bVarArrB3[length3];
                                        break;
                                    }
                                    length3--;
                                }
                            }
                        }
                    } else {
                        if (jA > bVarArrB2[length2].N()) {
                            bVar = bVarArrB2[length2];
                            break;
                        }
                        length2--;
                    }
                }
            } else {
                bVar = null;
            }
        }
        return bVar == null;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.f19907g) ^ Arrays.hashCode(this.f19901a)) ^ Arrays.hashCode(this.f19902b)) ^ Arrays.hashCode(this.f19903c)) ^ Arrays.hashCode(this.f19905e)) ^ Arrays.hashCode(this.f19906f);
    }

    final void l(DataOutput dataOutput) throws IOException {
        long[] jArr = this.f19901a;
        dataOutput.writeInt(jArr.length);
        for (long j8 : jArr) {
            a.c(j8, dataOutput);
        }
        for (ZoneOffset zoneOffset : this.f19902b) {
            a.d(zoneOffset, dataOutput);
        }
        long[] jArr2 = this.f19903c;
        dataOutput.writeInt(jArr2.length);
        for (long j9 : jArr2) {
            a.c(j9, dataOutput);
        }
        for (ZoneOffset zoneOffset2 : this.f19905e) {
            a.d(zoneOffset2, dataOutput);
        }
        e[] eVarArr = this.f19906f;
        dataOutput.writeByte(eVarArr.length);
        for (e eVar : eVarArr) {
            eVar.c(dataOutput);
        }
    }

    final void m(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.f19907g.getID());
    }

    public final String toString() {
        StringBuilder sb;
        TimeZone timeZone = this.f19907g;
        if (timeZone != null) {
            String id = timeZone.getID();
            sb = new StringBuilder("ZoneRules[timeZone=");
            sb.append(id);
        } else {
            ZoneOffset zoneOffset = this.f19902b[r1.length - 1];
            sb = new StringBuilder("ZoneRules[currentStandardOffset=");
            sb.append(zoneOffset);
        }
        sb.append("]");
        return sb.toString();
    }
}
