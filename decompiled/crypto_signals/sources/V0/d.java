package V0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f3187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f3188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ d[] f3189d;

    static {
        d dVar = new d("DEFAULT", 0);
        f3186a = dVar;
        d dVar2 = new d("VERY_LOW", 1);
        f3187b = dVar2;
        d dVar3 = new d("HIGHEST", 2);
        f3188c = dVar3;
        f3189d = new d[]{dVar, dVar2, dVar3};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f3189d.clone();
    }
}
