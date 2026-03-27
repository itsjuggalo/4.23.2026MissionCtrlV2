package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC2030b;
import j$.time.chrono.InterfaceC2033e;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC2033e, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f17073c = h0(h.f17228d, l.f17236e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f17074d = h0(h.f17229e, l.f17237f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f17075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f17076b;

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j7, j$.time.temporal.u uVar) {
        j$.time.temporal.b bVar = (j$.time.temporal.b) uVar;
        return j7 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j7, bVar);
    }

    @Override // j$.time.chrono.InterfaceC2033e
    public final InterfaceC2030b o() {
        return this.f17075a;
    }

    public static LocalDateTime f0(int i7) {
        return new LocalDateTime(h.g0(i7, 12, 31), l.b0(0));
    }

    public static LocalDateTime g0(int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        return new LocalDateTime(h.g0(i7, i8, i9), l.c0(i10, i11, i12, i13));
    }

    public static LocalDateTime h0(h hVar, l lVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(lVar, com.amazon.a.a.h.a.f9648b);
        return new LocalDateTime(hVar, lVar);
    }

    public static LocalDateTime i0(long j7, int i7, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        long j8 = i7;
        j$.time.temporal.a.NANO_OF_SECOND.a0(j8);
        long jZ = j7 + ((long) zoneOffset.Z());
        long j9 = 86400;
        return new LocalDateTime(h.i0(Math.floorDiv(jZ, j9)), l.d0((((long) ((int) Math.floorMod(jZ, j9))) * 1000000000) + j8));
    }

    public static LocalDateTime C(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).W();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(h.J(temporalAccessor), l.J(temporalAccessor));
        } catch (c e7) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e7);
        }
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.d(charSequence, new i());
    }

    private LocalDateTime(h hVar, l lVar) {
        this.f17075a = hVar;
        this.f17076b = lVar;
    }

    private LocalDateTime p0(h hVar, l lVar) {
        return (this.f17075a == hVar && this.f17076b == lVar) ? this : new LocalDateTime(hVar, lVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar != null && rVar.W(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        return aVar.T() || aVar.b0();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f17076b.l(rVar) : this.f17075a.l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f17076b.i(rVar) : this.f17075a.i(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f17076b.g(rVar) : this.f17075a.g(rVar);
        }
        return rVar.r(this);
    }

    private int r(LocalDateTime localDateTime) {
        int iR = this.f17075a.r(localDateTime.f17075a);
        return iR == 0 ? this.f17076b.compareTo(localDateTime.f17076b) : iR;
    }

    public final h m0() {
        return this.f17075a;
    }

    public final int c0() {
        return this.f17075a.b0();
    }

    public final int Z() {
        return this.f17075a.a0();
    }

    public final int J() {
        return this.f17075a.T();
    }

    public final DayOfWeek S() {
        return this.f17075a.W();
    }

    @Override // j$.time.chrono.InterfaceC2033e
    public final l n() {
        return this.f17076b;
    }

    public final int T() {
        return this.f17076b.T();
    }

    public final int W() {
        return this.f17076b.W();
    }

    public final int b0() {
        return this.f17076b.a0();
    }

    public final int a0() {
        return this.f17076b.Z();
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(h hVar) {
        return p0(hVar, this.f17076b);
    }

    public final LocalDateTime o0(h hVar) {
        return p0(hVar, this.f17076b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime b(long j7, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            boolean zB0 = ((j$.time.temporal.a) rVar).b0();
            l lVar = this.f17076b;
            h hVar = this.f17075a;
            if (zB0) {
                return p0(hVar, lVar.b(j7, rVar));
            }
            return p0(hVar.b(j7, rVar), lVar);
        }
        return (LocalDateTime) rVar.p(this, j7);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j7, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) uVar.p(this, j7);
        }
        switch (j.f17233a[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return l0(this.f17075a, 0L, 0L, 0L, j7);
            case 2:
                LocalDateTime localDateTimePlusDays = plusDays(j7 / 86400000000L);
                return localDateTimePlusDays.l0(localDateTimePlusDays.f17075a, 0L, 0L, 0L, (j7 % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimePlusDays2 = plusDays(j7 / 86400000);
                return localDateTimePlusDays2.l0(localDateTimePlusDays2.f17075a, 0L, 0L, 0L, (j7 % 86400000) * 1000000);
            case 4:
                return k0(j7);
            case 5:
                return l0(this.f17075a, 0L, j7, 0L, 0L);
            case 6:
                return l0(this.f17075a, j7, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimePlusDays3 = plusDays(j7 / 256);
                return localDateTimePlusDays3.l0(localDateTimePlusDays3.f17075a, (j7 % 256) * 12, 0L, 0L, 0L);
            default:
                return p0(this.f17075a.d(j7, uVar), this.f17076b);
        }
    }

    public LocalDateTime plusWeeks(long j7) {
        return p0(this.f17075a.n0(j7), this.f17076b);
    }

    public LocalDateTime plusDays(long j7) {
        return p0(this.f17075a.l0(j7), this.f17076b);
    }

    public final LocalDateTime k0(long j7) {
        return l0(this.f17075a, 0L, 0L, j7, 0L);
    }

    @Override // j$.time.chrono.InterfaceC2033e
    /* JADX INFO: renamed from: k */
    public final InterfaceC2033e e(long j7, j$.time.temporal.b bVar) {
        return j7 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j7, bVar);
    }

    private LocalDateTime l0(h hVar, long j7, long j8, long j9, long j10) {
        long j11 = j7 | j8 | j9 | j10;
        l lVarD0 = this.f17076b;
        if (j11 == 0) {
            return p0(hVar, lVarD0);
        }
        long j12 = j7 / 24;
        long j13 = j12 + (j8 / 1440) + (j9 / 86400) + (j10 / 86400000000000L);
        long j14 = 1;
        long j15 = ((j7 % 24) * 3600000000000L) + ((j8 % 1440) * 60000000000L) + ((j9 % 86400) * 1000000000) + (j10 % 86400000000000L);
        long jL0 = lVarD0.l0();
        long j16 = (j15 * j14) + jL0;
        long jFloorDiv = Math.floorDiv(j16, 86400000000000L) + (j13 * j14);
        long jFloorMod = Math.floorMod(j16, 86400000000000L);
        if (jFloorMod != jL0) {
            lVarD0 = l.d0(jFloorMod);
        }
        return p0(hVar.l0(jFloorDiv), lVarD0);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.b()) {
            return this.f17075a;
        }
        return super.a(tVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.chrono.InterfaceC2033e
    public final ChronoZonedDateTime H(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // j$.time.chrono.InterfaceC2033e, java.lang.Comparable
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC2033e interfaceC2033e) {
        if (interfaceC2033e instanceof LocalDateTime) {
            return r((LocalDateTime) interfaceC2033e);
        }
        return super.compareTo(interfaceC2033e);
    }

    public final boolean d0(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return r(localDateTime) > 0;
        }
        long jV = this.f17075a.v();
        long jV2 = localDateTime.f17075a.v();
        return jV > jV2 || (jV == jV2 && this.f17076b.l0() > localDateTime.f17076b.l0());
    }

    public final boolean e0(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return r(localDateTime) < 0;
        }
        long jV = this.f17075a.v();
        long jV2 = localDateTime.f17075a.v();
        return jV < jV2 || (jV == jV2 && this.f17076b.l0() < localDateTime.f17076b.l0());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.f17075a.equals(localDateTime.f17075a) && this.f17076b.equals(localDateTime.f17076b);
    }

    public final int hashCode() {
        return this.f17075a.hashCode() ^ this.f17076b.hashCode();
    }

    public final String toString() {
        return this.f17075a.toString() + "T" + this.f17076b.toString();
    }

    private Object writeReplace() {
        return new t((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void q0(DataOutput dataOutput) {
        this.f17075a.u0(dataOutput);
        this.f17076b.p0(dataOutput);
    }
}
