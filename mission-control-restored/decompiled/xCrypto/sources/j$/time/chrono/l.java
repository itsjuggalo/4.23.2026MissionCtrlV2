package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends Comparable {
    InterfaceC1549b A(int i4, int i5);

    List D();

    InterfaceC1549b G(int i4, int i5, int i6);

    InterfaceC1549b L();

    m N(int i4);

    InterfaceC1549b P(Map map, j$.time.format.y yVar);

    String R();

    j$.time.temporal.w U(j$.time.temporal.a aVar);

    boolean equals(Object obj);

    int hashCode();

    InterfaceC1549b q(long j4);

    String s();

    InterfaceC1549b t(TemporalAccessor temporalAccessor);

    String toString();

    int w(m mVar, int i4);

    ChronoZonedDateTime y(Instant instant, ZoneId zoneId);

    static l F(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.a(j$.time.temporal.s.a());
        s sVar = s.f13177d;
        if (lVar != null) {
            return lVar;
        }
        Objects.requireNonNull(sVar, "defaultObj");
        return sVar;
    }

    default InterfaceC1552e x(LocalDateTime localDateTime) {
        try {
            return t(localDateTime).K(j$.time.k.J(localDateTime));
        } catch (j$.time.c e4) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e4);
        }
    }
}
