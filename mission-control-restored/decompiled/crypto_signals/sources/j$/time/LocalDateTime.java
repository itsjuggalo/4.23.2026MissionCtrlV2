package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC0706b;
import j$.time.chrono.InterfaceC0709e;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC0709e, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f7363c = h0(g.f7505d, k.e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f7364d = h0(g.e, k.f7512f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f7365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f7366b;

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m e(long j4, j$.time.temporal.u uVar) {
        j$.time.temporal.b bVar = (j$.time.temporal.b) uVar;
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j4, bVar);
    }

    public static LocalDateTime f0(int i) {
        return new LocalDateTime(g.g0(i, 12, 31), k.b0(0));
    }

    public static LocalDateTime g0(int i, int i6, int i7, int i8, int i9, int i10, int i11) {
        return new LocalDateTime(g.g0(i, i6, i7), k.c0(i8, i9, i10, i11));
    }

    public static LocalDateTime h0(g gVar, k kVar) {
        Objects.requireNonNull(gVar, "date");
        Objects.requireNonNull(kVar, "time");
        return new LocalDateTime(gVar, kVar);
    }

    public static LocalDateTime i0(long j4, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j6 = i;
        j$.time.temporal.a.NANO_OF_SECOND.a0(j6);
        long jZ = j4 + ((long) zoneOffset.Z());
        long j7 = 86400;
        return new LocalDateTime(g.i0(Math.floorDiv(jZ, j7)), k.d0((((long) ((int) Math.floorMod(jZ, j7))) * 1000000000) + j6));
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
        } catch (c e) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.d(charSequence, new h());
    }

    private LocalDateTime(g gVar, k kVar) {
        this.f7365a = gVar;
        this.f7366b = kVar;
    }

    private LocalDateTime p0(g gVar, k kVar) {
        return (this.f7365a == gVar && this.f7366b == kVar) ? this : new LocalDateTime(gVar, kVar);
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
            return ((j$.time.temporal.a) rVar).b0() ? this.f7366b.l(rVar) : this.f7365a.l(rVar);
        }
        return rVar.J(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f7366b.i(rVar) : this.f7365a.i(rVar);
        }
        return super.i(rVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) rVar).b0() ? this.f7366b.g(rVar) : this.f7365a.g(rVar);
        }
        return rVar.r(this);
    }

    private int r(LocalDateTime localDateTime) {
        int iR = this.f7365a.r(localDateTime.f7365a);
        return iR == 0 ? this.f7366b.compareTo(localDateTime.f7366b) : iR;
    }

    public final g m0() {
        return this.f7365a;
    }

    @Override // j$.time.chrono.InterfaceC0709e
    public final InterfaceC0706b o() {
        return this.f7365a;
    }

    public final int c0() {
        return this.f7365a.b0();
    }

    public final int Z() {
        return this.f7365a.a0();
    }

    public final int J() {
        return this.f7365a.T();
    }

    public final DayOfWeek S() {
        return this.f7365a.W();
    }

    @Override // j$.time.chrono.InterfaceC0709e
    public final k n() {
        return this.f7366b;
    }

    public final int T() {
        return this.f7366b.T();
    }

    public final int W() {
        return this.f7366b.W();
    }

    public final int b0() {
        return this.f7366b.a0();
    }

    public final int a0() {
        return this.f7366b.Z();
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(g gVar) {
        return p0(gVar, this.f7366b);
    }

    public final LocalDateTime o0(g gVar) {
        return p0(gVar, this.f7366b);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime b(long j4, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            boolean zB0 = ((j$.time.temporal.a) rVar).b0();
            k kVar = this.f7366b;
            g gVar = this.f7365a;
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
        switch (i.f7509a[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return l0(this.f7365a, 0L, 0L, 0L, j4);
            case 2:
                LocalDateTime localDateTimePlusDays = plusDays(j4 / 86400000000L);
                return localDateTimePlusDays.l0(localDateTimePlusDays.f7365a, 0L, 0L, 0L, (j4 % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimePlusDays2 = plusDays(j4 / 86400000);
                return localDateTimePlusDays2.l0(localDateTimePlusDays2.f7365a, 0L, 0L, 0L, (j4 % 86400000) * 1000000);
            case 4:
                return k0(j4);
            case 5:
                return l0(this.f7365a, 0L, j4, 0L, 0L);
            case 6:
                return l0(this.f7365a, j4, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimePlusDays3 = plusDays(j4 / 256);
                return localDateTimePlusDays3.l0(localDateTimePlusDays3.f7365a, (j4 % 256) * 12, 0L, 0L, 0L);
            default:
                return p0(this.f7365a.d(j4, uVar), this.f7366b);
        }
    }

    public LocalDateTime plusWeeks(long j4) {
        return p0(this.f7365a.n0(j4), this.f7366b);
    }

    public LocalDateTime plusDays(long j4) {
        return p0(this.f7365a.l0(j4), this.f7366b);
    }

    public final LocalDateTime k0(long j4) {
        return l0(this.f7365a, 0L, 0L, j4, 0L);
    }

    @Override // j$.time.chrono.InterfaceC0709e
    /* JADX INFO: renamed from: k */
    public final InterfaceC0709e e(long j4, j$.time.temporal.b bVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, bVar).d(1L, bVar) : d(-j4, bVar);
    }

    private LocalDateTime l0(g gVar, long j4, long j6, long j7, long j8) {
        long j9 = j4 | j6 | j7 | j8;
        k kVarD0 = this.f7366b;
        if (j9 == 0) {
            return p0(gVar, kVarD0);
        }
        long j10 = j4 / 24;
        long j11 = j10 + (j6 / 1440) + (j7 / 86400) + (j8 / 86400000000000L);
        long j12 = 1;
        long j13 = ((j4 % 24) * 3600000000000L) + ((j6 % 1440) * 60000000000L) + ((j7 % 86400) * 1000000000) + (j8 % 86400000000000L);
        long jL0 = kVarD0.l0();
        long j14 = (j13 * j12) + jL0;
        long jFloorDiv = Math.floorDiv(j14, 86400000000000L) + (j11 * j12);
        long jFloorMod = Math.floorMod(j14, 86400000000000L);
        if (jFloorMod != jL0) {
            kVarD0 = k.d0(jFloorMod);
        }
        return p0(gVar.l0(jFloorDiv), kVarD0);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object a(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.s.b()) {
            return this.f7365a;
        }
        return super.a(tVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.chrono.InterfaceC0709e
    public final ChronoZonedDateTime H(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // j$.time.chrono.InterfaceC0709e, java.lang.Comparable
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC0709e interfaceC0709e) {
        if (interfaceC0709e instanceof LocalDateTime) {
            return r((LocalDateTime) interfaceC0709e);
        }
        return super.compareTo(interfaceC0709e);
    }

    public final boolean d0(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return r(localDateTime) > 0;
        }
        long jV = this.f7365a.v();
        long jV2 = localDateTime.f7365a.v();
        if (jV <= jV2) {
            return jV == jV2 && this.f7366b.l0() > localDateTime.f7366b.l0();
        }
        return true;
    }

    public final boolean e0(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return r(localDateTime) < 0;
        }
        long jV = this.f7365a.v();
        long jV2 = localDateTime.f7365a.v();
        if (jV >= jV2) {
            return jV == jV2 && this.f7366b.l0() < localDateTime.f7366b.l0();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f7365a.equals(localDateTime.f7365a) && this.f7366b.equals(localDateTime.f7366b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f7365a.hashCode() ^ this.f7366b.hashCode();
    }

    public final String toString() {
        return this.f7365a.toString() + "T" + this.f7366b.toString();
    }

    private Object writeReplace() {
        return new s((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    final void q0(DataOutput dataOutput) {
        this.f7365a.u0(dataOutput);
        this.f7366b.p0(dataOutput);
    }
}
