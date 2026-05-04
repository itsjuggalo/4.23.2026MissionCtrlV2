package j$.time.temporal;

/* JADX INFO: loaded from: classes2.dex */
public interface m extends TemporalAccessor {
    m c(long j10, q qVar);

    m d(long j10, s sVar);

    /* JADX INFO: renamed from: k */
    m m(j$.time.h hVar);

    default m a(long j10, s sVar) {
        return j10 == Long.MIN_VALUE ? d(Long.MAX_VALUE, sVar).d(1L, sVar) : d(-j10, sVar);
    }
}
