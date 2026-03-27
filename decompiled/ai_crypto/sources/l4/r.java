package l4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f18382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f18383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ r[] f18384c;

    public enum a extends r {
        public a(String str, int i7) {
            super(str, i7, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f18382a = aVar;
        r rVar = new r("STRING", 1) { // from class: l4.r.b
            {
                a aVar2 = null;
            }
        };
        f18383b = rVar;
        f18384c = new r[]{aVar, rVar};
    }

    public r(String str, int i7) {
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f18384c.clone();
    }

    public /* synthetic */ r(String str, int i7, a aVar) {
        this(str, i7);
    }
}
