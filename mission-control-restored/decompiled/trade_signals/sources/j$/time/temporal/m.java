package j$.time.temporal;

/* JADX INFO: loaded from: classes3.dex */
public interface m extends TemporalAccessor {
    default m a(long j8, u uVar) {
        return j8 == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j8, uVar);
    }

    m c(long j8, r rVar);

    m e(long j8, u uVar);

    /* JADX INFO: renamed from: j */
    m l(j$.time.h hVar);
}
