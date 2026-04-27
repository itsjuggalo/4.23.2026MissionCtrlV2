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
    static l D(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.s.a());
        s sVar = s.f19713d;
        if (lVar != null) {
            return lVar;
        }
        Objects.requireNonNull(sVar, "defaultObj");
        return sVar;
    }

    List B();

    InterfaceC2186b E(int i8, int i9, int i10);

    InterfaceC2186b J();

    m L(int i8);

    InterfaceC2186b O(Map map, j$.time.format.y yVar);

    String Q();

    j$.time.temporal.w S(j$.time.temporal.a aVar);

    String getId();

    InterfaceC2186b p(long j8);

    InterfaceC2186b r(TemporalAccessor temporalAccessor);

    int u(m mVar, int i8);

    default InterfaceC2189e v(LocalDateTime localDateTime) {
        try {
            return r(localDateTime).I(j$.time.l.H(localDateTime));
        } catch (j$.time.c e8) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e8);
        }
    }

    ChronoZonedDateTime w(Instant instant, ZoneId zoneId);

    InterfaceC2186b y(int i8, int i9);
}
