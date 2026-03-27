package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class A extends AbstractC1548a implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final A f13132d = new A();
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // j$.time.chrono.l
    public final String s() {
        return "Minguo";
    }

    @Override // j$.time.chrono.l
    public final m N(int i4) {
        if (i4 == 0) {
            return D.BEFORE_ROC;
        }
        if (i4 == 1) {
            return D.ROC;
        }
        throw new j$.time.c("Invalid era: " + i4);
    }

    @Override // j$.time.chrono.l
    public final String R() {
        return "roc";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b G(int i4, int i5, int i6) {
        return new C(j$.time.g.g0(i4 + 1911, i5, i6));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b A(int i4, int i5) {
        return new C(j$.time.g.j0(i4 + 1911, i5));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b q(long j4) {
        return new C(j$.time.g.i0(j4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b L() {
        return new C(j$.time.g.J(j$.time.g.f0(j$.time.b.c())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof C) {
            return (C) temporalAccessor;
        }
        return new C(j$.time.g.J(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final int w(m mVar, int i4) {
        if (mVar instanceof D) {
            return mVar == D.ROC ? i4 : 1 - i4;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.l
    public final List D() {
        return j$.time.b.b(D.values());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.w U(j$.time.temporal.a aVar) {
        int i4 = z.f13191a[aVar.ordinal()];
        if (i4 == 1) {
            j$.time.temporal.w wVarC = j$.time.temporal.a.PROLEPTIC_MONTH.C();
            return j$.time.temporal.w.j(wVarC.e() - 22932, wVarC.d() - 22932);
        }
        if (i4 == 2) {
            j$.time.temporal.w wVarC2 = j$.time.temporal.a.YEAR.C();
            return j$.time.temporal.w.k(wVarC2.d() - 1911, (-wVarC2.e()) + 1912);
        }
        if (i4 == 3) {
            j$.time.temporal.w wVarC3 = j$.time.temporal.a.YEAR.C();
            return j$.time.temporal.w.j(wVarC3.e() - 1911, wVarC3.d() - 1911);
        }
        return aVar.C();
    }

    @Override // j$.time.chrono.AbstractC1548a, j$.time.chrono.l
    public final InterfaceC1549b P(Map map, j$.time.format.y yVar) {
        return (C) super.P(map, yVar);
    }

    private A() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime y(Instant instant, ZoneId zoneId) {
        return k.J(this, instant, zoneId);
    }

    Object writeReplace() {
        return new E((byte) 1, this);
    }
}
