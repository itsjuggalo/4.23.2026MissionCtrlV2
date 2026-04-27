package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class k implements ChronoZonedDateTime, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient C1554g f13157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient ZoneOffset f13158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient ZoneId f13159c;

    static ChronoZonedDateTime C(ZoneId zoneId, ZoneOffset zoneOffset, C1554g c1554g) {
        Objects.requireNonNull(c1554g, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new k(zoneId, (ZoneOffset) zoneId, c1554g);
        }
        j$.time.zone.f fVarR = zoneId.r();
        LocalDateTime localDateTimeC = LocalDateTime.C(c1554g);
        List listG = fVarR.g(localDateTimeC);
        if (listG.size() == 1) {
            zoneOffset = (ZoneOffset) listG.get(0);
        } else if (listG.size() == 0) {
            j$.time.zone.b bVarF = fVarR.f(localDateTimeC);
            c1554g = c1554g.S(bVarF.C().J());
            zoneOffset = bVarF.J();
        } else if (zoneOffset == null || !listG.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) listG.get(0);
        }
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        return new k(zoneId, zoneOffset, c1554g);
    }

    static k J(l lVar, Instant instant, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.r().d(instant);
        Objects.requireNonNull(zoneOffsetD, com.amazon.device.iap.internal.c.b.as);
        return new k(zoneId, zoneOffsetD, (C1554g) lVar.x(LocalDateTime.i0(instant.getEpochSecond(), instant.getNano(), zoneOffsetD)));
    }

    static k r(l lVar, j$.time.temporal.m mVar) {
        k kVar = (k) mVar;
        if (lVar.equals(kVar.h())) {
            return kVar;
        }
        throw new ClassCastException("Chronology mismatch, required: " + lVar.s() + ", actual: " + kVar.h().s());
    }

    private k(ZoneId zoneId, ZoneOffset zoneOffset, C1554g c1554g) {
        Objects.requireNonNull(c1554g, "dateTime");
        this.f13157a = c1554g;
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        this.f13158b = zoneOffset;
        Objects.requireNonNull(zoneId, "zone");
        this.f13159c = zoneId;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset E() {
        return this.f13158b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final InterfaceC1552e B() {
        return this.f13157a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId Q() {
        return this.f13159c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime I(ZoneId zoneId) {
        return C(zoneId, this.f13158b, this.f13157a);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return true;
        }
        return rVar != null && rVar.W(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
            int i4 = AbstractC1557j.f13156a[aVar.ordinal()];
            if (i4 == 1) {
                return d(j4 - O(), (j$.time.temporal.u) j$.time.temporal.b.SECONDS);
            }
            ZoneId zoneId = this.f13159c;
            C1554g c1554g = this.f13157a;
            if (i4 != 2) {
                return C(zoneId, this.f13158b, c1554g.b(j4, rVar));
            }
            return J(h(), Instant.ofEpochSecond(c1554g.Y(ZoneOffset.c0(aVar.Z(j4))), c1554g.n().Z()), zoneId);
        }
        return r(h(), rVar.p(this, j4));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.m
    public final ChronoZonedDateTime d(long j4, j$.time.temporal.u uVar) {
        if (uVar instanceof j$.time.temporal.b) {
            return m(this.f13157a.d(j4, uVar));
        }
        return r(h(), uVar.p(this, j4));
    }

    private Object writeReplace() {
        return new E((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.f13157a);
        objectOutput.writeObject(this.f13158b);
        objectOutput.writeObject(this.f13159c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo((ChronoZonedDateTime) obj) == 0;
    }

    public final int hashCode() {
        return (this.f13157a.hashCode() ^ this.f13158b.hashCode()) ^ Integer.rotateLeft(this.f13159c.hashCode(), 3);
    }

    public final String toString() {
        String string = this.f13157a.toString();
        ZoneOffset zoneOffset = this.f13158b;
        String str = string + zoneOffset.toString();
        ZoneId zoneId = this.f13159c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }
}
