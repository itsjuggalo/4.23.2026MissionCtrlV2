package S2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f2881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f2882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ f[] f2883d;

    static {
        f fVar = new f("QUERY", 0);
        f2880a = fVar;
        f fVar2 = new f("DOCUMENTS", 1);
        f2881b = fVar2;
        f fVar3 = new f("TARGETTYPE_NOT_SET", 2);
        f2882c = fVar3;
        f2883d = new f[]{fVar, fVar2, fVar3};
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f2883d.clone();
    }
}
