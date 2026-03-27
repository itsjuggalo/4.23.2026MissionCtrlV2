package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public interface l extends Comparable {
    InterfaceC2030b A(int i7, int i8);

    List D();

    InterfaceC2030b G(int i7, int i8, int i9);

    InterfaceC2030b L();

    m N(int i7);

    InterfaceC2030b P(Map map, j$.time.format.y yVar);

    String R();

    j$.time.temporal.w U(j$.time.temporal.a aVar);

    InterfaceC2030b q(long j7);

    String s();

    InterfaceC2030b t(TemporalAccessor temporalAccessor);

    int w(m mVar, int i7);

    ChronoZonedDateTime y(Instant instant, ZoneId zoneId);

    static l F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.a(j$.time.temporal.s.a());
        s sVar = s.f17138d;
        if (lVar != null) {
            return lVar;
        }
        Objects.requireNonNull(sVar, "defaultObj");
        return sVar;
    }

    default InterfaceC2033e x(LocalDateTime localDateTime) {
        try {
            return t(localDateTime).K(j$.time.l.J(localDateTime));
        } catch (j$.time.c e7) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e7);
        }
    }
}
