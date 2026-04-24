package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
final class m implements f {
    public static final m INSENSITIVE;
    public static final m LENIENT;
    public static final m SENSITIVE;
    public static final m STRICT;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ m[] f13228a;

    @Override // j$.time.format.f
    public final boolean p(t tVar, StringBuilder sb) {
        return true;
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) f13228a.clone();
    }

    static {
        m mVar = new m("SENSITIVE", 0);
        SENSITIVE = mVar;
        m mVar2 = new m("INSENSITIVE", 1);
        INSENSITIVE = mVar2;
        m mVar3 = new m("STRICT", 2);
        STRICT = mVar3;
        m mVar4 = new m("LENIENT", 3);
        LENIENT = mVar4;
        f13228a = new m[]{mVar, mVar2, mVar3, mVar4};
    }

    @Override // j$.time.format.f
    public final int r(q qVar, CharSequence charSequence, int i4) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            qVar.l(true);
            return i4;
        }
        if (iOrdinal == 1) {
            qVar.l(false);
            return i4;
        }
        if (iOrdinal == 2) {
            qVar.p(true);
            return i4;
        }
        if (iOrdinal != 3) {
            return i4;
        }
        qVar.p(false);
        return i4;
    }

    @Override // java.lang.Enum
    public final String toString() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return "ParseCaseSensitive(true)";
        }
        if (iOrdinal == 1) {
            return "ParseCaseSensitive(false)";
        }
        if (iOrdinal == 2) {
            return "ParseStrict(true)";
        }
        if (iOrdinal == 3) {
            return "ParseStrict(false)";
        }
        throw new IllegalStateException("Unreachable");
    }
}
