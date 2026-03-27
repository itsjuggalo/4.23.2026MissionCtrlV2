package Y3;

import s3.AbstractC1024h;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ b[] f3622b;

    static {
        b bVar = new b("PLAIN_TEXT", 0);
        f3621a = bVar;
        f3622b = new b[]{bVar};
    }

    public static b a(String str) throws NoSuchFieldException {
        for (b bVar : values()) {
            bVar.getClass();
            if ("text/plain".equals(str)) {
                return bVar;
            }
        }
        throw new NoSuchFieldException(AbstractC1024h.b("No such ClipboardContentFormat: ", str));
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f3622b.clone();
    }
}
