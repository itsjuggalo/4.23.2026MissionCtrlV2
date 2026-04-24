package T2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f3025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f3026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f3027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z f3028d;
    public static final z e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final z f3029f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ z[] f3030k;

    static {
        z zVar = new z("Initial", 0);
        f3025a = zVar;
        z zVar2 = new z("Starting", 1);
        f3026b = zVar2;
        z zVar3 = new z("Open", 2);
        f3027c = zVar3;
        z zVar4 = new z("Healthy", 3);
        f3028d = zVar4;
        z zVar5 = new z("Error", 4);
        e = zVar5;
        z zVar6 = new z("Backoff", 5);
        f3029f = zVar6;
        f3030k = new z[]{zVar, zVar2, zVar3, zVar4, zVar5, zVar6};
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) f3030k.clone();
    }
}
