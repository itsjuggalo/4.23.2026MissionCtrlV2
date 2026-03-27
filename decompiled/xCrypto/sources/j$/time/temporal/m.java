package j$.time.temporal;

/* JADX INFO: loaded from: classes2.dex */
public interface m extends TemporalAccessor {
    m b(long j4, r rVar);

    m d(long j4, u uVar);

    /* JADX INFO: renamed from: j */
    m m(j$.time.g gVar);

    default m e(long j4, u uVar) {
        return j4 == Long.MIN_VALUE ? d(Long.MAX_VALUE, uVar).d(1L, uVar) : d(-j4, uVar);
    }
}
