package j$.time;

import com.revenuecat.purchases.common.Constants;
import j$.time.temporal.TemporalAccessor;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f13708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f13709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f13710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l[] f13711h = new l[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f13712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f13713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte f13714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13715d;

    static {
        int i10 = 0;
        while (true) {
            l[] lVarArr = f13711h;
            if (i10 < lVarArr.length) {
                lVarArr[i10] = new l(i10, 0, 0, 0);
                i10++;
            } else {
                l lVar = lVarArr[0];
                f13710g = lVar;
                l lVar2 = lVarArr[12];
                f13708e = lVar;
                f13709f = new l(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static l P(int i10, int i11, int i12, int i13) {
        j$.time.temporal.a.HOUR_OF_DAY.X(i10);
        j$.time.temporal.a.MINUTE_OF_HOUR.X(i11);
        j$.time.temporal.a.SECOND_OF_MINUTE.X(i12);
        j$.time.temporal.a.NANO_OF_SECOND.X(i13);
        return A(i10, i11, i12, i13);
    }

    public static l V(long j10) {
        j$.time.temporal.a.NANO_OF_DAY.X(j10);
        int i10 = (int) (j10 / 3600000000000L);
        long j11 = j10 - (((long) i10) * 3600000000000L);
        int i11 = (int) (j11 / 60000000000L);
        long j12 = j11 - (((long) i11) * 60000000000L);
        int i12 = (int) (j12 / 1000000000);
        return A(i10, i11, i12, (int) (j12 - (((long) i12) * 1000000000)));
    }

    public static l F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.r.f13759g);
        if (lVar != null) {
            return lVar;
        }
        throw new c("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static l A(int i10, int i11, int i12, int i13) {
        if ((i11 | i12 | i13) == 0) {
            return f13711h[i10];
        }
        return new l(i10, i11, i12, i13);
    }

    public l(int i10, int i11, int i12, int i13) {
        this.f13712a = (byte) i10;
        this.f13713b = (byte) i11;
        this.f13714c = (byte) i12;
        this.f13715d = i13;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean h(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).Y();
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return I(qVar);
        }
        return super.g(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long i(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.NANO_OF_DAY) {
                return d0();
            }
            if (qVar == j$.time.temporal.a.MICRO_OF_DAY) {
                return d0() / 1000;
            }
            return I(qVar);
        }
        return qVar.P(this);
    }

    public final int I(j$.time.temporal.q qVar) {
        switch (k.f13706a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f13715d;
            case 2:
                throw new j$.time.temporal.t("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f13715d / 1000;
            case 4:
                throw new j$.time.temporal.t("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f13715d / 1000000;
            case 6:
                return (int) (d0() / 1000000);
            case 7:
                return this.f13714c;
            case 8:
                return e0();
            case 9:
                return this.f13713b;
            case 10:
                return (this.f13712a * 60) + this.f13713b;
            case 11:
                return this.f13712a % 12;
            case 12:
                int i10 = this.f13712a % 12;
                if (i10 % 12 == 0) {
                    return 12;
                }
                return i10;
            case 13:
                return this.f13712a;
            case 14:
                byte b10 = this.f13712a;
                if (b10 == 0) {
                    return 24;
                }
                return b10;
            case 15:
                return this.f13712a / 12;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: k */
    public final j$.time.temporal.m m(h hVar) {
        return (l) hVar.e(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final l c(long j10, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (l) qVar.V(this, j10);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.X(j10);
        switch (k.f13706a[aVar.ordinal()]) {
            case 1:
                return g0((int) j10);
            case 2:
                return V(j10);
            case 3:
                return g0(((int) j10) * 1000);
            case 4:
                return V(j10 * 1000);
            case 5:
                return g0(((int) j10) * 1000000);
            case 6:
                return V(j10 * 1000000);
            case 7:
                int i10 = (int) j10;
                if (this.f13714c != i10) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.X(i10);
                    return A(this.f13712a, this.f13713b, i10, this.f13715d);
                }
                return this;
            case 8:
                return b0(j10 - ((long) e0()));
            case 9:
                int i11 = (int) j10;
                if (this.f13713b != i11) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.X(i11);
                    return A(this.f13712a, i11, this.f13714c, this.f13715d);
                }
                return this;
            case 10:
                return Z(j10 - ((long) ((this.f13712a * 60) + this.f13713b)));
            case 11:
                return Y(j10 - ((long) (this.f13712a % 12)));
            case 12:
                if (j10 == 12) {
                    j10 = 0;
                }
                return Y(j10 - ((long) (this.f13712a % 12)));
            case 13:
                int i12 = (int) j10;
                if (this.f13712a != i12) {
                    j$.time.temporal.a.HOUR_OF_DAY.X(i12);
                    return A(i12, this.f13713b, this.f13714c, this.f13715d);
                }
                return this;
            case 14:
                if (j10 == 24) {
                    j10 = 0;
                }
                int i13 = (int) j10;
                if (this.f13712a != i13) {
                    j$.time.temporal.a.HOUR_OF_DAY.X(i13);
                    return A(i13, this.f13713b, this.f13714c, this.f13715d);
                }
                return this;
            case 15:
                return Y((j10 - ((long) (this.f13712a / 12))) * 12);
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    public final l g0(int i10) {
        if (this.f13715d == i10) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.X(i10);
        return A(this.f13712a, this.f13713b, this.f13714c, i10);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final l d(long j10, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (k.f13707b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return a0(j10);
                case 2:
                    return a0((j10 % 86400000000L) * 1000);
                case 3:
                    return a0((j10 % 86400000) * 1000000);
                case 4:
                    return b0(j10);
                case 5:
                    return Z(j10);
                case 6:
                    return Y(j10);
                case 7:
                    return Y((j10 % 2) * 12);
                default:
                    throw new j$.time.temporal.t("Unsupported unit: " + sVar);
            }
        }
        return (l) sVar.s(this, j10);
    }

    public final l Y(long j10) {
        return j10 == 0 ? this : A(((((int) (j10 % 24)) + this.f13712a) + 24) % 24, this.f13713b, this.f13714c, this.f13715d);
    }

    public final l Z(long j10) {
        if (j10 != 0) {
            int i10 = (this.f13712a * 60) + this.f13713b;
            int i11 = ((((int) (j10 % 1440)) + i10) + 1440) % 1440;
            if (i10 != i11) {
                return A(i11 / 60, i11 % 60, this.f13714c, this.f13715d);
            }
        }
        return this;
    }

    public final l b0(long j10) {
        if (j10 != 0) {
            int i10 = (this.f13713b * 60) + (this.f13712a * 3600) + this.f13714c;
            int i11 = ((((int) (j10 % 86400)) + i10) + 86400) % 86400;
            if (i10 != i11) {
                return A(i11 / 3600, (i11 / 60) % 60, i11 % 60, this.f13715d);
            }
        }
        return this;
    }

    public final l a0(long j10) {
        if (j10 != 0) {
            long jD0 = d0();
            long j11 = (((j10 % 86400000000000L) + jD0) + 86400000000000L) % 86400000000000L;
            if (jD0 != j11) {
                return A((int) (j11 / 3600000000000L), (int) ((j11 / 60000000000L) % 60), (int) ((j11 / 1000000000) % 60), (int) (j11 % 1000000000));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j10, j$.time.temporal.s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(i iVar) {
        if (iVar == j$.time.temporal.r.f13754b || iVar == j$.time.temporal.r.f13753a || iVar == j$.time.temporal.r.f13757e || iVar == j$.time.temporal.r.f13756d) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f13759g) {
            return this;
        }
        if (iVar == j$.time.temporal.r.f13758f) {
            return null;
        }
        if (iVar == j$.time.temporal.r.f13755c) {
            return j$.time.temporal.b.NANOS;
        }
        return iVar.k(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m e(j$.time.temporal.m mVar) {
        return mVar.c(d0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final int e0() {
        return (this.f13713b * 60) + (this.f13712a * 3600) + this.f13714c;
    }

    public final long d0() {
        return (((long) this.f13714c) * 1000000000) + (((long) this.f13713b) * 60000000000L) + (((long) this.f13712a) * 3600000000000L) + ((long) this.f13715d);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final int compareTo(l lVar) {
        int iCompare = Integer.compare(this.f13712a, lVar.f13712a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.f13713b, lVar.f13713b)) == 0 && (iCompare = Integer.compare(this.f13714c, lVar.f13714c)) == 0) ? Integer.compare(this.f13715d, lVar.f13715d) : iCompare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f13712a == lVar.f13712a && this.f13713b == lVar.f13713b && this.f13714c == lVar.f13714c && this.f13715d == lVar.f13715d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jD0 = d0();
        return (int) (jD0 ^ (jD0 >>> 32));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(18);
        byte b10 = this.f13712a;
        byte b11 = this.f13713b;
        byte b12 = this.f13714c;
        int i10 = this.f13715d;
        sb2.append(b10 < 10 ? "0" : "");
        sb2.append((int) b10);
        String str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        sb2.append(b11 < 10 ? ":0" : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb2.append((int) b11);
        if (b12 > 0 || i10 > 0) {
            if (b12 < 10) {
                str = ":0";
            }
            sb2.append(str);
            sb2.append((int) b12);
            if (i10 > 0) {
                sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
                if (i10 % 1000000 == 0) {
                    sb2.append(Integer.toString((i10 / 1000000) + 1000).substring(1));
                } else if (i10 % 1000 == 0) {
                    sb2.append(Integer.toString((i10 / 1000) + 1000000).substring(1));
                } else {
                    sb2.append(Integer.toString(i10 + 1000000000).substring(1));
                }
            }
        }
        return sb2.toString();
    }

    private Object writeReplace() {
        return new t((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void h0(DataOutput dataOutput) {
        if (this.f13715d == 0) {
            if (this.f13714c == 0) {
                if (this.f13713b == 0) {
                    dataOutput.writeByte(~this.f13712a);
                    return;
                } else {
                    dataOutput.writeByte(this.f13712a);
                    dataOutput.writeByte(~this.f13713b);
                    return;
                }
            }
            dataOutput.writeByte(this.f13712a);
            dataOutput.writeByte(this.f13713b);
            dataOutput.writeByte(~this.f13714c);
            return;
        }
        dataOutput.writeByte(this.f13712a);
        dataOutput.writeByte(this.f13713b);
        dataOutput.writeByte(this.f13714c);
        dataOutput.writeInt(this.f13715d);
    }

    public static l c0(DataInput dataInput) throws IOException {
        int i10;
        int i11;
        int i12 = dataInput.readByte();
        int i13 = 0;
        if (i12 < 0) {
            i12 = ~i12;
            i11 = 0;
            i10 = 0;
        } else {
            byte b10 = dataInput.readByte();
            if (b10 < 0) {
                int i14 = ~b10;
                i10 = 0;
                i13 = i14;
                i11 = 0;
            } else {
                byte b11 = dataInput.readByte();
                if (b11 < 0) {
                    i11 = ~b11;
                    i10 = 0;
                    i13 = b10;
                } else {
                    i10 = dataInput.readInt();
                    i13 = b10;
                    i11 = b11;
                }
            }
        }
        return P(i12, i13, i11, i10);
    }
}
