package j$.time.chrono;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 extends a implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g0 f13576c = new g0();
    private static final long serialVersionUID = 2775954514031616474L;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        map.put("en", new String[]{"BB", "BE"});
        map.put("th", new String[]{"BB", "BE"});
        map2.put("en", new String[]{"B.B.", "B.E."});
        map2.put("th", new String[]{"พ.ศ.", "ปีก่อนคริสต์กาลที่"});
        map3.put("en", new String[]{"Before Buddhist", "Budhhist Era"});
        map3.put("th", new String[]{"พุทธศักราช", "ปีก่อนคริสต์กาลที่"});
    }

    @Override // j$.time.chrono.l
    public final m B(int i10) {
        if (i10 == 0) {
            return j0.BEFORE_BE;
        }
        if (i10 == 1) {
            return j0.BE;
        }
        throw new j$.time.c("Invalid era: " + i10);
    }

    @Override // j$.time.chrono.l
    public final String q() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.l
    public final String u() {
        return "buddhist";
    }

    @Override // j$.time.chrono.l
    public final b Q(int i10, int i11, int i12) {
        return new i0(j$.time.h.b0(i10 - 543, i11, i12));
    }

    @Override // j$.time.chrono.l
    public final b v(int i10, int i11) {
        return new i0(j$.time.h.d0(i10 - 543, i11));
    }

    @Override // j$.time.chrono.l
    public final b p(long j10) {
        return new i0(j$.time.h.c0(j10));
    }

    @Override // j$.time.chrono.l
    public final b M() {
        return new i0(j$.time.h.F(j$.time.h.a0(j$.time.b.b())));
    }

    @Override // j$.time.chrono.l
    public final b G(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof i0) {
            return (i0) temporalAccessor;
        }
        return new i0(j$.time.h.F(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final int C(m mVar, int i10) {
        if (mVar instanceof j0) {
            return mVar == j0.BE ? i10 : 1 - i10;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    private g0() {
    }

    @Override // j$.time.chrono.l
    public final List z() {
        return j$.time.b.a(j0.values());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.u y(j$.time.temporal.a aVar) {
        int i10 = f0.f13573a[aVar.ordinal()];
        if (i10 == 1) {
            j$.time.temporal.u uVar = j$.time.temporal.a.PROLEPTIC_MONTH.f13735b;
            return j$.time.temporal.u.f(uVar.f13760a + 6516, uVar.f13763d + 6516);
        }
        if (i10 == 2) {
            j$.time.temporal.u uVar2 = j$.time.temporal.a.YEAR.f13735b;
            return j$.time.temporal.u.g((-(uVar2.f13760a + 543)) + 1, uVar2.f13763d + 543);
        }
        if (i10 != 3) {
            return aVar.f13735b;
        }
        j$.time.temporal.u uVar3 = j$.time.temporal.a.YEAR.f13735b;
        return j$.time.temporal.u.f(uVar3.f13760a + 543, uVar3.f13763d + 543);
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final b S(Map map, j$.time.format.x xVar) {
        return (i0) super.S(map, xVar);
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
