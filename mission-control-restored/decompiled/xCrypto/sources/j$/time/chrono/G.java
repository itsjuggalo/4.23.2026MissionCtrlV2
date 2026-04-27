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
public final class G extends AbstractC1548a implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final G f13139d = new G();
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
    public final m N(int i4) {
        if (i4 == 0) {
            return J.BEFORE_BE;
        }
        if (i4 == 1) {
            return J.BE;
        }
        throw new j$.time.c("Invalid era: " + i4);
    }

    @Override // j$.time.chrono.l
    public final String s() {
        return "ThaiBuddhist";
    }

    @Override // j$.time.chrono.l
    public final String R() {
        return "buddhist";
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b G(int i4, int i5, int i6) {
        return new I(j$.time.g.g0(i4 - 543, i5, i6));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b A(int i4, int i5) {
        return new I(j$.time.g.j0(i4 - 543, i5));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b q(long j4) {
        return new I(j$.time.g.i0(j4));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b L() {
        return new I(j$.time.g.J(j$.time.g.f0(j$.time.b.c())));
    }

    @Override // j$.time.chrono.l
    public final InterfaceC1549b t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof I) {
            return (I) temporalAccessor;
        }
        return new I(j$.time.g.J(temporalAccessor));
    }

    @Override // j$.time.chrono.l
    public final int w(m mVar, int i4) {
        if (mVar instanceof J) {
            return mVar == J.BE ? i4 : 1 - i4;
        }
        throw new ClassCastException("Era must be BuddhistEra");
    }

    private G() {
    }

    @Override // j$.time.chrono.l
    public final List D() {
        return j$.time.b.b(J.values());
    }

    @Override // j$.time.chrono.l
    public final j$.time.temporal.w U(j$.time.temporal.a aVar) {
        int i4 = F.f13138a[aVar.ordinal()];
        if (i4 == 1) {
            j$.time.temporal.w wVarC = j$.time.temporal.a.PROLEPTIC_MONTH.C();
            return j$.time.temporal.w.j(wVarC.e() + 6516, wVarC.d() + 6516);
        }
        if (i4 == 2) {
            j$.time.temporal.w wVarC2 = j$.time.temporal.a.YEAR.C();
            return j$.time.temporal.w.k((-(wVarC2.e() + 543)) + 1, wVarC2.d() + 543);
        }
        if (i4 == 3) {
            j$.time.temporal.w wVarC3 = j$.time.temporal.a.YEAR.C();
            return j$.time.temporal.w.j(wVarC3.e() + 543, wVarC3.d() + 543);
        }
        return aVar.C();
    }

    @Override // j$.time.chrono.AbstractC1548a, j$.time.chrono.l
    public final InterfaceC1549b P(Map map, j$.time.format.y yVar) {
        return (I) super.P(map, yVar);
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
