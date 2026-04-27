package j$.time.chrono;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements m, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f13186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final y[] f13187e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient int f13188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient j$.time.g f13189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient String f13190c;

    static {
        y yVar = new y(-1, j$.time.g.g0(1868, 1, 1), "Meiji");
        f13186d = yVar;
        f13187e = new y[]{yVar, new y(0, j$.time.g.g0(1912, 7, 30), "Taisho"), new y(1, j$.time.g.g0(1926, 12, 25), "Showa"), new y(2, j$.time.g.g0(1989, 1, 8), "Heisei"), new y(3, j$.time.g.g0(2019, 5, 1), "Reiwa")};
    }

    static y r() {
        return f13187e[r0.length - 1];
    }

    static long y() {
        int iB0 = 1000000000 - r().f13189b.b0();
        y[] yVarArr = f13187e;
        int iB02 = yVarArr[0].f13189b.b0();
        for (int i4 = 1; i4 < yVarArr.length; i4++) {
            y yVar = yVarArr[i4];
            iB0 = Math.min(iB0, (yVar.f13189b.b0() - iB02) + 1);
            iB02 = yVar.f13189b.b0();
        }
        return iB0;
    }

    static long x() {
        long jF = j$.time.temporal.a.DAY_OF_YEAR.C().f();
        for (y yVar : f13187e) {
            jF = Math.min(jF, ((yVar.f13189b.d0() ? 366 : 365) - yVar.f13189b.Z()) + 1);
            if (yVar.t() != null) {
                jF = Math.min(jF, yVar.t().f13189b.Z() - 1);
            }
        }
        return jF;
    }

    private y(int i4, j$.time.g gVar, String str) {
        this.f13188a = i4;
        this.f13189b = gVar;
        this.f13190c = str;
    }

    final j$.time.g s() {
        return this.f13189b;
    }

    public static y w(int i4) {
        int i5 = i4 + 1;
        if (i5 >= 0) {
            y[] yVarArr = f13187e;
            if (i5 < yVarArr.length) {
                return yVarArr[i5];
            }
        }
        throw new j$.time.c("Invalid era: " + i4);
    }

    public static y[] A() {
        y[] yVarArr = f13187e;
        return (y[]) Arrays.copyOf(yVarArr, yVarArr.length);
    }

    static y q(j$.time.g gVar) {
        if (gVar.c0(x.f13182d)) {
            throw new j$.time.c("JapaneseDate before Meiji 6 are not supported");
        }
        y[] yVarArr = f13187e;
        for (int length = yVarArr.length - 1; length >= 0; length--) {
            y yVar = yVarArr[length];
            if (gVar.compareTo(yVar.f13189b) >= 0) {
                return yVar;
            }
        }
        return null;
    }

    @Override // j$.time.chrono.m
    public final int p() {
        return this.f13188a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        if (rVar == aVar) {
            return v.f13180d.U(aVar);
        }
        return super.l(rVar);
    }

    public final String toString() {
        return this.f13190c;
    }

    final y t() {
        if (this == r()) {
            return null;
        }
        return w(this.f13188a + 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new E((byte) 5, this);
    }

    final void C(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.f13188a);
    }
}
