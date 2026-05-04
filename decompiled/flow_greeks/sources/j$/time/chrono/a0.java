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
public final class a0 extends a implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f13565c = new a0();
    private static final long serialVersionUID = 1039765215346859963L;

    @Override // j$.time.chrono.l
    public final String q() {
        return "Minguo";
    }

    @Override // j$.time.chrono.l
    public final m B(int i10) {
        if (i10 == 0) {
            return d0.BEFORE_ROC;
        }
        if (i10 == 1) {
            return d0.ROC;
        }
        throw new j$.time.c("Invalid era: " + i10);
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "roc";
    }

    @Override // j$.time.chrono.l
    public final b Q(int i10, int i11, int i12) {
        return new c0(j$.time.h.b0(i10 + 1911, i11, i12));
    }

    @Override // j$.time.chrono.l
    public final b v(int i10, int i11) {
        return new c0(j$.time.h.d0(i10 + 1911, i11));
    }

    @Override // j$.time.chrono.l
    public final b p(long j10) {
        return new c0(j$.time.h.c0(j10));
    }

    @Override // j$.time.chrono.l
    public final b M() {
        return new c0(j$.time.h.F(j$.time.h.a0(j$.time.b.b())));
    }

    @Override // j$.time.chrono.l
    public final b G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof c0) {
            return (c0) temporalAccessor;
        }
        return new c0(j$.time.h.F(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i10) {
        if (mVar instanceof d0) {
            return mVar == d0.ROC ? i10 : 1 - i10;
        }
        throw new ClassCastException("Era must be MinguoEra");
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(d0.values());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        int i10 = z.f13621a[aVar.ordinal()];
        if (i10 == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f13735b;
            return j$.time.temporal.u.f(uVar.f13760a - 22932, uVar.f13763d - 22932);
        }
        if (i10 == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f13735b;
            return j$.time.temporal.u.g(uVar2.f13763d - 1911, (-uVar2.f13760a) + 1912);
        }
        if (i10 != 3) {
            return aVar.f13735b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f13735b;
        return j$.time.temporal.u.f(uVar3.f13760a - 1911, uVar3.f13763d - 1911);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final b S(Map map, j$.time.format.x xVar) {
        return (c0) super.S(map, xVar);
    }

    private a0() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.chrono.l
    public final ChronoZonedDateTime T(Instant instant, ZoneId zoneId) {
        return k.F(this, instant, zoneId);
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
