package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements m {
    public static final r AH;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ r[] f19712a;

    static {
        r rVar = new r("AH", 0);
        AH = rVar;
        f19712a = new r[]{rVar};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f19712a.clone();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.w k(j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.ERA ? j$.time.temporal.w.j(1L, 1L) : super.k(rVar);
    }

    @Override // j$.time.chrono.m
    public final int o() {
        return 1;
    }
}
