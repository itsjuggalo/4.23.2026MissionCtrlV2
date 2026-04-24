package j$.time.temporal;

/* JADX INFO: loaded from: classes3.dex */
public interface m extends TemporalAccessor {
    m b(long j7, r rVar);

    m d(long j7, u uVar);

    /* JADX INFO: renamed from: j */
    m m(j$.time.h hVar);

    default m e(long j7, u uVar) {
        return j7 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j7, uVar);
    }
}
