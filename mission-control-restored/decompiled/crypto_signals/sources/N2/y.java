package N2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f2059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f2060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ y[] f2061c;

    static {
        y yVar = new y("ADDED", 0);
        f2059a = yVar;
        y yVar2 = new y("REMOVED", 1);
        f2060b = yVar2;
        f2061c = new y[]{yVar, yVar2};
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f2061c.clone();
    }
}
