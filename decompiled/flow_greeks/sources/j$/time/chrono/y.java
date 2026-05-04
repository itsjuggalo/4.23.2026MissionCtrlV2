package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements m, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f13616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final y[] f13617e;
    private static final long serialVersionUID = 1466499369062886794L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f13618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient j$.time.h f13619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient String f13620c;

    static {
        y yVar = new y(-1, j$.time.h.b0(1868, 1, 1), "Meiji");
        f13616d = yVar;
        f13617e = new y[]{yVar, new y(0, j$.time.h.b0(1912, 7, 30), "Taisho"), new y(1, j$.time.h.b0(1926, 12, 25), "Showa"), new y(2, j$.time.h.b0(1989, 1, 8), "Heisei"), new y(3, j$.time.h.b0(2019, 5, 1), "Reiwa")};
    }

    public final y q() {
        if (this == f13617e[r0.length - 1]) {
            return null;
        }
        return r(this.f13618a + 1);
    }

    public y(int i10, j$.time.h hVar, String str) {
        this.f13618a = i10;
        this.f13619b = hVar;
        this.f13620c = str;
    }

    public static y r(int i10) {
        int i11 = i10 + 1;
        if (i11 >= 0) {
            y[] yVarArr = f13617e;
            if (i11 < yVarArr.length) {
                return yVarArr[i11];
            }
        }
        throw new j$.time.c("Invalid era: " + i10);
    }

    public static y p(j$.time.h hVar) {
        if (hVar.X(x.f13612d)) {
            throw new j$.time.c("JapaneseDate before Meiji 6 are not supported");
        }
        for (int length = f13617e.length - 1; length >= 0; length--) {
            y yVar = f13617e[length];
            if (hVar.compareTo(yVar.f13619b) >= 0) {
                return yVar;
            }
        }
        return null;
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return this.f13618a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u l(j$.time.temporal.q qVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        if (qVar == aVar) {
            return v.f13610c.y(aVar);
        }
        return super.l(qVar);
    }

    public final String toString() {
        return this.f13620c;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 5, this);
    }
}
