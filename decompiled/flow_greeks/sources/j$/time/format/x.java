package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public static final x LENIENT;
    public static final x SMART;
    public static final x STRICT;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ x[] f13694a;

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) f13694a.clone();
    }

    static {
        x xVar = new x("STRICT", 0);
        STRICT = xVar;
        x xVar2 = new x("SMART", 1);
        SMART = xVar2;
        x xVar3 = new x("LENIENT", 2);
        LENIENT = xVar3;
        f13694a = new x[]{xVar, xVar2, xVar3};
    }
}
