package U2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f3131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f3133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f3134d;
    public static final e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f3135f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f3136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f3137l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f3138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f3139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ e[] f3140o;

    /* JADX INFO: Fake field, exist only in values array */
    e EF0;

    static {
        e eVar = new e("ALL", 0);
        e eVar2 = new e("LISTEN_STREAM_IDLE", 1);
        f3131a = eVar2;
        e eVar3 = new e("LISTEN_STREAM_CONNECTION_BACKOFF", 2);
        f3132b = eVar3;
        e eVar4 = new e("WRITE_STREAM_IDLE", 3);
        f3133c = eVar4;
        e eVar5 = new e("WRITE_STREAM_CONNECTION_BACKOFF", 4);
        f3134d = eVar5;
        e eVar6 = new e("HEALTH_CHECK_TIMEOUT", 5);
        e = eVar6;
        e eVar7 = new e("ONLINE_STATE_TIMEOUT", 6);
        f3135f = eVar7;
        e eVar8 = new e("GARBAGE_COLLECTION", 7);
        f3136k = eVar8;
        e eVar9 = new e("RETRY_TRANSACTION", 8);
        f3137l = eVar9;
        e eVar10 = new e("CONNECTIVITY_ATTEMPT_TIMER", 9);
        f3138m = eVar10;
        e eVar11 = new e("INDEX_BACKFILL", 10);
        f3139n = eVar11;
        f3140o = new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, eVar10, eVar11};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f3140o.clone();
    }
}
