package j$.time.temporal;

import j$.time.format.y;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface r {
    w C();

    w J(TemporalAccessor temporalAccessor);

    boolean T();

    boolean W(TemporalAccessor temporalAccessor);

    m p(m mVar, long j4);

    long r(TemporalAccessor temporalAccessor);

    default TemporalAccessor S(HashMap map, TemporalAccessor temporalAccessor, y yVar) {
        return null;
    }
}
