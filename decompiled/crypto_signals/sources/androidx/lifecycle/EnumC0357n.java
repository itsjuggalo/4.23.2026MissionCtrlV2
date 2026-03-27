package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0357n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0357n f4681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0357n f4682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0357n f4683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0357n f4684d;
    public static final EnumC0357n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumC0357n[] f4685f;

    static {
        EnumC0357n enumC0357n = new EnumC0357n("DESTROYED", 0);
        f4681a = enumC0357n;
        EnumC0357n enumC0357n2 = new EnumC0357n("INITIALIZED", 1);
        f4682b = enumC0357n2;
        EnumC0357n enumC0357n3 = new EnumC0357n("CREATED", 2);
        f4683c = enumC0357n3;
        EnumC0357n enumC0357n4 = new EnumC0357n("STARTED", 3);
        f4684d = enumC0357n4;
        EnumC0357n enumC0357n5 = new EnumC0357n("RESUMED", 4);
        e = enumC0357n5;
        f4685f = new EnumC0357n[]{enumC0357n, enumC0357n2, enumC0357n3, enumC0357n4, enumC0357n5};
    }

    public static EnumC0357n valueOf(String str) {
        return (EnumC0357n) Enum.valueOf(EnumC0357n.class, str);
    }

    public static EnumC0357n[] values() {
        return (EnumC0357n[]) f4685f.clone();
    }
}
