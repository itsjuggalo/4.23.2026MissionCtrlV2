package j$.time.temporal;

import j$.time.format.y;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface r {
    w A();

    w H(TemporalAccessor temporalAccessor);

    default TemporalAccessor M(Map map, TemporalAccessor temporalAccessor, y yVar) {
        return null;
    }

    boolean R();

    boolean U(TemporalAccessor temporalAccessor);

    m o(m mVar, long j8);

    long q(TemporalAccessor temporalAccessor);
}
