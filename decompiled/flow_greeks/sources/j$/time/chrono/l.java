package j$.time.chrono;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface l extends Comparable {
    m B(int i10);

    int C(m mVar, int i10);

    b G(TemporalAccessor temporalAccessor);

    b M();

    b Q(int i10, int i11, int i12);

    b S(Map map, j$.time.format.x xVar);

    ChronoZonedDateTime T(Instant instant, ZoneId zoneId);

    boolean equals(Object obj);

    int hashCode();

    b p(long j10);

    String q();

    String toString();

    String u();

    b v(int i10, int i11);

    j$.time.temporal.u y(j$.time.temporal.a aVar);

    List z();

    static l r(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        l lVar = (l) temporalAccessor.b(j$.time.temporal.r.f13754b);
        s sVar = s.f13607c;
        if (lVar != null) {
            return lVar;
        }
        Objects.requireNonNull(sVar, "defaultObj");
        return sVar;
    }

    static l of(String str) {
        ConcurrentHashMap concurrentHashMap = a.f13563a;
        Objects.requireNonNull(str, DiagnosticsEntry.ID_KEY);
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = a.f13563a;
            l lVar = (l) concurrentHashMap2.get(str);
            if (lVar == null) {
                lVar = (l) a.f13564b.get(str);
            }
            if (lVar != null) {
                return lVar;
            }
            if (concurrentHashMap2.get("ISO") != null) {
                for (l lVar2 : ServiceLoader.load(l.class)) {
                    if (str.equals(lVar2.q()) || str.equals(lVar2.u())) {
                        return lVar2;
                    }
                }
                throw new j$.time.c("Unknown chronology: ".concat(str));
            }
            o oVar = o.f13591l;
            oVar.getClass();
            a.A(oVar, "Hijrah-umalqura");
            v vVar = v.f13610c;
            vVar.getClass();
            a.A(vVar, "Japanese");
            a0 a0Var = a0.f13565c;
            a0Var.getClass();
            a.A(a0Var, "Minguo");
            g0 g0Var = g0.f13576c;
            g0Var.getClass();
            a.A(g0Var, "ThaiBuddhist");
            try {
                for (a aVar : Arrays.asList(new a[0])) {
                    if (!aVar.q().equals("ISO")) {
                        a.A(aVar, aVar.q());
                    }
                }
                s sVar = s.f13607c;
                sVar.getClass();
                a.A(sVar, "ISO");
            } catch (Throwable th) {
                throw new ServiceConfigurationError(th.getMessage(), th);
            }
        }
    }

    default e H(LocalDateTime localDateTime) {
        try {
            return G(localDateTime).L(j$.time.l.F(localDateTime));
        } catch (j$.time.c e10) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e10);
        }
    }
}
