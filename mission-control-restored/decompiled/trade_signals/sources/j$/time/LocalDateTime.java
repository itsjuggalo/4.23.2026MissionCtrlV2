package j$.time;

import j$.time.chrono.ChronoZonedDateTime;
import j$.time.chrono.InterfaceC2186b;
import j$.time.chrono.InterfaceC2189e;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC2189e, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f19648c = f0(h.f19805d, l.f19813e);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f19649d = f0(h.f19806e, l.f19814f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f19650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f19651b;

    private LocalDateTime(h hVar, l lVar) {
        this.f19650a = hVar;
        this.f19651b = lVar;
    }

    public static LocalDateTime A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).U();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(h.H(temporalAccessor), l.H(temporalAccessor));
        } catch (c e8) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e8);
        }
    }

    public static LocalDateTime d0(int i8) {
        return new LocalDateTime(h.e0(i8, 12, 31), l.Z(0));
    }

    public static LocalDateTime e0(int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        return new LocalDateTime(h.e0(i8, i9, i10), l.a0(i11, i12, i13, i14));
    }

    public static LocalDateTime f0(h hVar, l lVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(lVar, com.amazon.a.a.h.a.f13759b);
        return new LocalDateTime(hVar, lVar);
    }

    public static LocalDateTime g0(long j8, int i8, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, com.amazon.device.iap.internal.c.b.as);
        long j9 = i8;
        j$.time.temporal.a.NANO_OF_SECOND.Y(j9);
        long jX = j8 + ((long) zoneOffset.X());
        long j10 = 86400;
        return new LocalDateTime(h.g0(Math.floorDiv(jX, j10)), l.b0((((long) ((int) Math.floorMod(jX, j10))) * 1000000000) + j9));
    }

    private LocalDateTime j0(h hVar, long j8, long j9, long j10, long j11) {
        long j12 = j8 | j9 | j10 | j11;
        l lVarB0 = this.f19651b;
        if (j12 == 0) {
            return n0(hVar, lVarB0);
        }
        long j13 = j8 / 24;
        long j14 = j13 + (j9 / 1440) + (j10 / 86400) + (j11 / 86400000000000L);
        long j15 = 1;
        long j16 = ((j8 % 24) * 3600000000000L) + ((j9 % 1440) * 60000000000L) + ((j10 % 86400) * 1000000000) + (j11 % 86400000000000L);
        long jJ0 = lVarB0.j0();
        long j17 = (j16 * j15) + jJ0;
        long jFloorDiv = Math.floorDiv(j17, 86400000000000L) + (j14 * j15);
        long jFloorMod = Math.floorMod(j17, 86400000000000L);
        if (jFloorMod != jJ0) {
            lVarB0 = l.b0(jFloorMod);
        }
        return n0(hVar.j0(jFloorDiv), lVarB0);
    }

    private LocalDateTime n0(h hVar, l lVar) {
        return (this.f19650a == hVar && this.f19651b == lVar) ? this : new LocalDateTime(hVar, lVar);
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.e(charSequence, new i());
    }

    private int q(LocalDateTime localDateTime) {
        int iQ = this.f19650a.q(localDateTime.f19650a);
        return iQ == 0 ? this.f19651b.compareTo(localDateTime.f19651b) : iQ;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new t((byte) 5, this);
    }

    @Override // j$.time.chrono.InterfaceC2189e
    public final ChronoZonedDateTime F(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    public final int H() {
        return this.f19650a.R();
    }

    public final DayOfWeek M() {
        return this.f19650a.U();
    }

    public final int R() {
        return this.f19651b.R();
    }

    public final int U() {
        return this.f19651b.U();
    }

    @Override // j$.time.chrono.InterfaceC2189e, java.lang.Comparable
    /* JADX INFO: renamed from: V */
    public final int compareTo(InterfaceC2189e interfaceC2189e) {
        return interfaceC2189e instanceof LocalDateTime ? q((LocalDateTime) interfaceC2189e) : super.compareTo(interfaceC2189e);
    }

    public final int X() {
        return this.f19650a.Y();
    }

    public final int Y() {
        return this.f19651b.X();
    }

    public final int Z() {
        return this.f19651b.Y();
    }

    @Override // j$.time.temporal.m
    public final InterfaceC2189e a(long j8, j$.time.temporal.u uVar) {
        return j8 == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j8, uVar);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j8, j$.time.temporal.u uVar) {
        return j8 == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j8, uVar);
    }

    public final int a0() {
        return this.f19650a.Z();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.s.b() ? this.f19650a : super.b(tVar);
    }

    public final boolean b0(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return q(localDateTime) > 0;
        }
        long jT = this.f19650a.t();
        long jT2 = localDateTime.f19650a.t();
        return jT > jT2 || (jT == jT2 && this.f19651b.j0() > localDateTime.f19651b.j0());
    }

    public final boolean c0(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return q(localDateTime) < 0;
        }
        long jT = this.f19650a.t();
        long jT2 = localDateTime.f19650a.t();
        return jT < jT2 || (jT == jT2 && this.f19651b.j0() < localDateTime.f19651b.j0());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.f19650a.equals(localDateTime.f19650a) && this.f19651b.equals(localDateTime.f19651b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar != null && rVar.U(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        return aVar.R() || aVar.Z();
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).Z() ? this.f19651b.g(rVar) : this.f19650a.g(rVar) : rVar.q(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime e(long j8, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) uVar.o(this, j8);
        }
        switch (j.f19810a[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return j0(this.f19650a, 0L, 0L, 0L, j8);
            case 2:
                LocalDateTime localDateTimePlusDays = plusDays(j8 / 86400000000L);
                return localDateTimePlusDays.j0(localDateTimePlusDays.f19650a, 0L, 0L, 0L, (j8 % 86400000000L) * 1000);
            case 3:
                LocalDateTime localDateTimePlusDays2 = plusDays(j8 / 86400000);
                return localDateTimePlusDays2.j0(localDateTimePlusDays2.f19650a, 0L, 0L, 0L, (j8 % 86400000) * 1000000);
            case 4:
                return i0(j8);
            case 5:
                return j0(this.f19650a, 0L, j8, 0L, 0L);
            case 6:
                return j0(this.f19650a, j8, 0L, 0L, 0L);
            case 7:
                LocalDateTime localDateTimePlusDays3 = plusDays(j8 / 256);
                return localDateTimePlusDays3.j0(localDateTimePlusDays3.f19650a, (j8 % 256) * 12, 0L, 0L, 0L);
            default:
                return n0(this.f19650a.e(j8, uVar), this.f19651b);
        }
    }

    public final int hashCode() {
        return this.f19650a.hashCode() ^ this.f19651b.hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int i(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).Z() ? this.f19651b.i(rVar) : this.f19650a.i(rVar) : super.i(rVar);
    }

    public final LocalDateTime i0(long j8) {
        return j0(this.f19650a, 0L, 0L, j8, 0L);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m l(h hVar) {
        return n0(hVar, this.f19651b);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w k(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).Z() ? this.f19651b.k(rVar) : this.f19650a.k(rVar) : rVar.H(this);
    }

    public final h k0() {
        return this.f19650a;
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j8, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (LocalDateTime) rVar.o(this, j8);
        }
        boolean Z7 = ((j$.time.temporal.a) rVar).Z();
        l lVar = this.f19651b;
        h hVar = this.f19650a;
        return Z7 ? n0(hVar, lVar.c(j8, rVar)) : n0(hVar.c(j8, rVar), lVar);
    }

    @Override // j$.time.chrono.InterfaceC2189e
    public final l m() {
        return this.f19651b;
    }

    public final LocalDateTime m0(h hVar) {
        return n0(hVar, this.f19651b);
    }

    @Override // j$.time.chrono.InterfaceC2189e
    public final InterfaceC2186b n() {
        return this.f19650a;
    }

    final void o0(DataOutput dataOutput) {
        this.f19650a.s0(dataOutput);
        this.f19651b.n0(dataOutput);
    }

    public LocalDateTime plusDays(long j8) {
        return n0(this.f19650a.j0(j8), this.f19651b);
    }

    public LocalDateTime plusWeeks(long j8) {
        return n0(this.f19650a.l0(j8), this.f19651b);
    }

    public final String toString() {
        return this.f19650a.toString() + "T" + this.f19651b.toString();
    }
}
