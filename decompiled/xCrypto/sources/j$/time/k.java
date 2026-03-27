package j$.time;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.revenuecat.purchases.common.Constants;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f13275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f13276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f13277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final k[] f13278h = new k[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f13279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f13280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte f13281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13282d;

    static {
        int i4 = 0;
        while (true) {
            k[] kVarArr = f13278h;
            if (i4 < kVarArr.length) {
                kVarArr[i4] = new k(i4, 0, 0, 0);
                i4++;
            } else {
                k kVar = kVarArr[0];
                f13277g = kVar;
                k kVar2 = kVarArr[12];
                f13275e = kVar;
                f13276f = new k(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static k b0(int i4) {
        j$.time.temporal.a.HOUR_OF_DAY.a0(i4);
        return f13278h[i4];
    }

    public static k c0(int i4, int i5, int i6, int i7) {
        j$.time.temporal.a.HOUR_OF_DAY.a0(i4);
        j$.time.temporal.a.MINUTE_OF_HOUR.a0(i5);
        j$.time.temporal.a.SECOND_OF_MINUTE.a0(i6);
        j$.time.temporal.a.NANO_OF_SECOND.a0(i7);
        return C(i4, i5, i6, i7);
    }

    public static k e0(long j4) {
        j$.time.temporal.a.SECOND_OF_DAY.a0(j4);
        int i4 = (int) (j4 / 3600);
        long j5 = j4 - ((long) (i4 * 3600));
        int i5 = (int) (j5 / 60);
        return C(i4, i5, (int) (j5 - ((long) (i5 * 60))), 0);
    }

    public static k d0(long j4) {
        j$.time.temporal.a.NANO_OF_DAY.a0(j4);
        int i4 = (int) (j4 / 3600000000000L);
        long j5 = j4 - (((long) i4) * 3600000000000L);
        int i5 = (int) (j5 / 60000000000L);
        long j6 = j5 - (((long) i5) * 60000000000L);
        int i6 = (int) (j6 / 1000000000);
        return C(i4, i5, i6, (int) (j6 - (((long) i6) * 1000000000)));
    }

    public static k J(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        k kVar = (k) temporalAccessor.a(j$.time.temporal.s.c());
        if (kVar != null) {
            return kVar;
        }
        throw new c("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private static k C(int i4, int i5, int i6, int i7) {
        if ((i5 | i6 | i7) == 0) {
            return f13278h[i4];
        }
        return new k(i4, i5, i6, i7);
    }

    private k(int i4, int i5, int i6, int i7) {
        this.f13279a = (byte) i4;
        this.f13280b = (byte) i5;
        this.f13281c = (byte) i6;
        this.f13282d = i7;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0();
        }
        return rVar != null && rVar.W(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return S(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            if (rVar == j$.time.temporal.a.NANO_OF_DAY) {
                return l0();
            }
            if (rVar == j$.time.temporal.a.MICRO_OF_DAY) {
                return l0() / 1000;
            }
            return S(rVar);
        }
        return rVar.r(this);
    }

    private int S(j$.time.temporal.r rVar) {
        int i4 = j.f13273a[((j$.time.temporal.a) rVar).ordinal()];
        byte b4 = this.f13280b;
        int i5 = this.f13282d;
        byte b5 = this.f13279a;
        switch (i4) {
            case 1:
                return i5;
            case 2:
                throw new j$.time.temporal.v("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return i5 / 1000;
            case 4:
                throw new j$.time.temporal.v("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return i5 / 1000000;
            case 6:
                return (int) (l0() / 1000000);
            case 7:
                return this.f13281c;
            case 8:
                return m0();
            case 9:
                return b4;
            case 10:
                return (b5 * 60) + b4;
            case 11:
                return b5 % 12;
            case 12:
                int i6 = b5 % 12;
                if (i6 % 12 == 0) {
                    return 12;
                }
                return i6;
            case 14:
                if (b5 == 0) {
                    return 24;
                }
            case 13:
                return b5;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return b5 / 12;
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    public final int T() {
        return this.f13279a;
    }

    public final int W() {
        return this.f13280b;
    }

    public final int a0() {
        return this.f13281c;
    }

    public final int Z() {
        return this.f13282d;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return (k) gVar.c(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final k b(long j4, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (k) rVar.p(this, j4);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.a0(j4);
        int i4 = j.f13273a[aVar.ordinal()];
        byte b4 = this.f13280b;
        byte b5 = this.f13281c;
        int i5 = this.f13282d;
        byte b6 = this.f13279a;
        switch (i4) {
            case 1:
                return o0((int) j4);
            case 2:
                return d0(j4);
            case 3:
                return o0(((int) j4) * 1000);
            case 4:
                return d0(j4 * 1000);
            case 5:
                return o0(((int) j4) * 1000000);
            case 6:
                return d0(j4 * 1000000);
            case 7:
                int i6 = (int) j4;
                if (b5 != i6) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.a0(i6);
                    return C(b6, b4, i6, i5);
                }
                return this;
            case 8:
                return j0(j4 - ((long) m0()));
            case 9:
                int i7 = (int) j4;
                if (b4 != i7) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.a0(i7);
                    return C(b6, i7, b5, i5);
                }
                return this;
            case 10:
                return h0(j4 - ((long) ((b6 * 60) + b4)));
            case 11:
                return g0(j4 - ((long) (b6 % 12)));
            case 12:
                if (j4 == 12) {
                    j4 = 0;
                }
                return g0(j4 - ((long) (b6 % 12)));
            case 13:
                int i8 = (int) j4;
                if (b6 != i8) {
                    j$.time.temporal.a.HOUR_OF_DAY.a0(i8);
                    return C(i8, b4, b5, i5);
                }
                return this;
            case 14:
                if (j4 == 24) {
                    j4 = 0;
                }
                int i9 = (int) j4;
                if (b6 != i9) {
                    j$.time.temporal.a.HOUR_OF_DAY.a0(i9);
                    return C(i9, b4, b5, i5);
                }
                return this;
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return g0((j4 - ((long) (b6 / 12))) * 12);
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    public final k o0(int i4) {
        if (this.f13282d == i4) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.a0(i4);
        return C(this.f13279a, this.f13280b, this.f13281c, i4);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final k d(long j4, j$.time.temporal.u uVar) {
        if (uVar instanceof j$.time.temporal.b) {
            switch (j.f13274b[((j$.time.temporal.b) uVar).ordinal()]) {
                case 1:
                    return i0(j4);
                case 2:
                    return i0((j4 % 86400000000L) * 1000);
                case 3:
                    return i0((j4 % 86400000) * 1000000);
                case 4:
                    return j0(j4);
                case 5:
                    return h0(j4);
                case 6:
                    return g0(j4);
                case 7:
                    return g0((j4 % 2) * 12);
                default:
                    throw new j$.time.temporal.v("Unsupported unit: " + uVar);
            }
        }
        return (k) uVar.p(this, j4);
    }

    public final k g0(long j4) {
        if (j4 == 0) {
            return this;
        }
        return C(((((int) (j4 % 24)) + this.f13279a) + 24) % 24, this.f13280b, this.f13281c, this.f13282d);
    }

    public final k h0(long j4) {
        if (j4 != 0) {
            int i4 = (this.f13279a * 60) + this.f13280b;
            int i5 = ((((int) (j4 % 1440)) + i4) + 1440) % 1440;
            if (i4 != i5) {
                return C(i5 / 60, i5 % 60, this.f13281c, this.f13282d);
            }
        }
        return this;
    }

    public final k j0(long j4) {
        if (j4 != 0) {
            int i4 = (this.f13280b * 60) + (this.f13279a * 3600) + this.f13281c;
            int i5 = ((((int) (j4 % 86400)) + i4) + 86400) % 86400;
            if (i4 != i5) {
                return C(i5 / 3600, (i5 / 60) % 60, i5 % 60, this.f13282d);
            }
        }
        return this;
    }

    public final k i0(long j4) {
        if (j4 != 0) {
            long jL0 = l0();
            long j5 = (((j4 % 86400000000000L) + jL0) + 86400000000000L) % 86400000000000L;
            if (jL0 != j5) {
                return C((int) (j5 / 3600000000000L), (int) ((j5 / 60000000000L) % 60), (int) ((j5 / 1000000000) % 60), (int) (j5 % 1000000000));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j4, uVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.a() || tVar == j$.time.temporal.s.g() || tVar == j$.time.temporal.s.f() || tVar == j$.time.temporal.s.d()) {
            return null;
        }
        if (tVar == j$.time.temporal.s.c()) {
            return this;
        }
        if (tVar == j$.time.temporal.s.b()) {
            return null;
        }
        if (tVar == j$.time.temporal.s.e()) {
            return j$.time.temporal.b.NANOS;
        }
        return tVar.j(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.b(l0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final int m0() {
        return (this.f13280b * 60) + (this.f13279a * 3600) + this.f13281c;
    }

    public final long l0() {
        return (((long) this.f13281c) * 1000000000) + (((long) this.f13280b) * 60000000000L) + (((long) this.f13279a) * 3600000000000L) + ((long) this.f13282d);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        int iCompare = Integer.compare(this.f13279a, kVar.f13279a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.f13280b, kVar.f13280b)) == 0 && (iCompare = Integer.compare(this.f13281c, kVar.f13281c)) == 0) ? Integer.compare(this.f13282d, kVar.f13282d) : iCompare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f13279a == kVar.f13279a && this.f13280b == kVar.f13280b && this.f13281c == kVar.f13281c && this.f13282d == kVar.f13282d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jL0 = l0();
        return (int) (jL0 ^ (jL0 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b4 = this.f13279a;
        sb.append(b4 < 10 ? "0" : "");
        sb.append((int) b4);
        String str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        byte b5 = this.f13280b;
        sb.append(b5 < 10 ? ":0" : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append((int) b5);
        byte b6 = this.f13281c;
        int i4 = this.f13282d;
        if (b6 > 0 || i4 > 0) {
            if (b6 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append((int) b6);
            if (i4 > 0) {
                sb.append(com.amazon.a.a.o.c.a.b.f8816a);
                if (i4 % 1000000 == 0) {
                    sb.append(Integer.toString((i4 / 1000000) + 1000).substring(1));
                } else if (i4 % 1000 == 0) {
                    sb.append(Integer.toString((i4 / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i4 + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void p0(DataOutput dataOutput) {
        byte b4 = this.f13281c;
        byte b5 = this.f13279a;
        byte b6 = this.f13280b;
        int i4 = this.f13282d;
        if (i4 != 0) {
            dataOutput.writeByte(b5);
            dataOutput.writeByte(b6);
            dataOutput.writeByte(b4);
            dataOutput.writeInt(i4);
            return;
        }
        if (b4 != 0) {
            dataOutput.writeByte(b5);
            dataOutput.writeByte(b6);
            dataOutput.writeByte(~b4);
        } else if (b6 == 0) {
            dataOutput.writeByte(~b5);
        } else {
            dataOutput.writeByte(b5);
            dataOutput.writeByte(~b6);
        }
    }

    static k k0(ObjectInput objectInput) throws IOException {
        int i4;
        int i5;
        int i6 = objectInput.readByte();
        int i7 = 0;
        if (i6 < 0) {
            i6 = ~i6;
            i5 = 0;
            i4 = 0;
        } else {
            byte b4 = objectInput.readByte();
            if (b4 < 0) {
                int i8 = ~b4;
                i4 = 0;
                i7 = i8;
                i5 = 0;
            } else {
                byte b5 = objectInput.readByte();
                if (b5 < 0) {
                    i5 = ~b5;
                    i4 = 0;
                    i7 = b4;
                } else {
                    i4 = objectInput.readInt();
                    i7 = b4;
                    i5 = b5;
                }
            }
        }
        return c0(i6, i7, i5, i4);
    }
}
