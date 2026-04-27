package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC1549b;
import j$.time.chrono.InterfaceC1552e;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC1552e, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f13114c = h0(g.f13267d, k.f13275e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f13115d = h0(g.f13268e, k.f13276f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f13116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f13117b;

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        j$.time.temporal.b bVar = (j$.time.temporal.b) uVar;
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j4, bVar);
    }

    public static LocalDateTime f0(int i4) {
        return new LocalDateTime(g.g0(i4, 12, 31), k.b0(0));
    }

    public static LocalDateTime g0(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        return new LocalDateTime(g.g0(i4, i5, i6), k.c0(i7, i8, i9, i10));
    }

    public static LocalDateTime h0(g gVar, k kVar) {
        Objects.requireNonNull(gVar, "date");
        Objects.requireNonNull(kVar, com.amazon.a.a.h.a.f8463b);
        return new LocalDateTime(gVar, kVar);
    }

    public static LocalDateTime i0(long j4, int i4, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        long j5 = i4;
        j$.time.temporal.a.NANO_OF_SECOND.a0(j5);
        long jZ = j4 + ((long) zoneOffset.Z());
        long j6 = 86400;
        return new LocalDateTime(g.i0(Math.floorDiv(jZ, j6)), k.d0((((long) ((int) Math.floorMod(jZ, j6))) * 1000000000) + j5));
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
            return new LocalDateTime(g.J(temporalAccessor), k.J(temporalAccessor));
        } catch (c e4) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e4);
        }
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.d(charSequence, new h());
    }

    private LocalDateTime(g gVar, k kVar) {
        this.f13116a = gVar;
        this.f13117b = kVar;
    }

    private LocalDateTime p0(g gVar, k kVar) {
        return (this.f13116a == gVar && this.f13117b == kVar) ? this : new LocalDateTime(gVar, kVar);
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
            return ((j$.time.temporal.a) rVar).b0() ? this.f13117b.l(rVar) : this.f13116a.l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f13117b.i(rVar) : this.f13116a.i(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f13117b.g(rVar) : this.f13116a.g(rVar);
        }
        return rVar.r(this);
    }

    private int r(LocalDateTime localDateTime) {
        int iR = this.f13116a.r(localDateTime.f13116a);
        return iR == 0 ? this.f13117b.compareTo(localDateTime.f13117b) : iR;
    }

    public final g m0() {
        return this.f13116a;
    }

    @Override // j$.time.chrono.InterfaceC1552e
    public final InterfaceC1549b o() {
        return this.f13116a;
    }

    public final int c0() {
        return this.f13116a.b0();
    }

    public final int Z() {
        return this.f13116a.a0();
    }

    public final int J() {
        return this.f13116a.T();
    }

    public final DayOfWeek S() {
        return this.f13116a.W();
    }

    @Override // j$.time.chrono.InterfaceC1552e
    public final k n() {
        return this.f13117b;
    }

    public final int T() {
        return this.f13117b.T();
    }

    public final int W() {
        return this.f13117b.W();
    }

    public final int b0() {
        return this.f13117b.a0();
    }

    public final int a0() {
        return this.f13117b.Z();
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return p0(gVar, this.f13117b);
    }

    public final LocalDateTime o0(g gVar) {
        return p0(gVar, this.f13117b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            boolean zB0 = ((j$.time.temporal.a) rVar).b0();
            k kVar = this.f13117b;
            g gVar = this.f13116a;
            if (zB0) {
                return p0(gVar, kVar.b(j4, rVar));
            }
            return p0(gVar.b(j4, rVar), kVar);
        }
        return (LocalDateTime) rVar.p(this, j4);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j4, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) uVar.p(this, j4);
        }
        switch (i.f13272a[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return l0(this.f13116a, 0L, 0L, 0L, j4);
            case 2:
                LocalDateTime localDateTimePlusDays = plusDays(j4 / 86400000000L);
                return localDateTimePlusDays.l0(localDateTimePlusDays.f13116a, 0L, 0L, 0L, (j4 % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimePlusDays2 = plusDays(j4 / 86400000);
                return localDateTimePlusDays2.l0(localDateTimePlusDays2.f13116a, 0L, 0L, 0L, (j4 % 86400000) * 1000000);
            case 4:
                return k0(j4);
            case 5:
                return l0(this.f13116a, 0L, j4, 0L, 0L);
            case 6:
                return l0(this.f13116a, j4, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimePlusDays3 = plusDays(j4 / 256);
                return localDateTimePlusDays3.l0(localDateTimePlusDays3.f13116a, (j4 % 256) * 12, 0L, 0L, 0L);
            default:
                return p0(this.f13116a.d(j4, uVar), this.f13117b);
        }
    }

    public LocalDateTime plusWeeks(long j4) {
        return p0(this.f13116a.n0(j4), this.f13117b);
    }

    public LocalDateTime plusDays(long j4) {
        return p0(this.f13116a.l0(j4), this.f13117b);
    }

    public final LocalDateTime k0(long j4) {
        return l0(this.f13116a, 0L, 0L, j4, 0L);
    }

    @Override // j$.time.chrono.InterfaceC1552e
    /* JADX INFO: renamed from: k */
    public final InterfaceC1552e e(long j4, j$.time.temporal.b bVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j4, bVar);
    }

    private LocalDateTime l0(g gVar, long j4, long j5, long j6, long j7) {
        long j8 = j4 | j5 | j6 | j7;
        k kVarD0 = this.f13117b;
        if (j8 == 0) {
            return p0(gVar, kVarD0);
        }
        long j9 = j4 / 24;
        long j10 = j9 + (j5 / 1440) + (j6 / 86400) + (j7 / 86400000000000L);
        long j11 = 1;
        long j12 = ((j4 % 24) * 3600000000000L) + ((j5 % 1440) * 60000000000L) + ((j6 % 86400) * 1000000000) + (j7 % 86400000000000L);
        long jL0 = kVarD0.l0();
        long j13 = (j12 * j11) + jL0;
        long jFloorDiv = Math.floorDiv(j13, 86400000000000L) + (j10 * j11);
        long jFloorMod = Math.floorMod(j13, 86400000000000L);
        if (jFloorMod != jL0) {
            kVarD0 = k.d0(jFloorMod);
        }
        return p0(gVar.l0(jFloorDiv), kVarD0);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.b()) {
            return this.f13116a;
        }
        return super.a(tVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.chrono.InterfaceC1552e
    public final ChronoZonedDateTime H(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // j$.time.chrono.InterfaceC1552e, java.lang.Comparable
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC1552e interfaceC1552e) {
        if (interfaceC1552e instanceof LocalDateTime) {
            return r((LocalDateTime) interfaceC1552e);
        }
        return super.compareTo(interfaceC1552e);
    }

    public final boolean d0(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return r(localDateTime) > 0;
        }
        long jV = this.f13116a.v();
        long jV2 = localDateTime.f13116a.v();
        if (jV <= jV2) {
            return jV == jV2 && this.f13117b.l0() > localDateTime.f13117b.l0();
        }
        return true;
    }

    public final boolean e0(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return r(localDateTime) < 0;
        }
        long jV = this.f13116a.v();
        long jV2 = localDateTime.f13116a.v();
        if (jV >= jV2) {
            return jV == jV2 && this.f13117b.l0() < localDateTime.f13117b.l0();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f13116a.equals(localDateTime.f13116a) && this.f13117b.equals(localDateTime.f13117b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f13116a.hashCode() ^ this.f13117b.hashCode();
    }

    public final String toString() {
        return this.f13116a.toString() + "T" + this.f13117b.toString();
    }

    private Object writeReplace() {
        return new s((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void q0(DataOutput dataOutput) {
        this.f13116a.u0(dataOutput);
        this.f13117b.p0(dataOutput);
    }
}
