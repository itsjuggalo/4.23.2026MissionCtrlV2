package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements m {
    public static final t BCE;
    public static final t CE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ t[] f13608a;

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f13608a.clone();
    }

    static {
        t tVar = new t("BCE", 0);
        BCE = tVar;
        t tVar2 = new t("CE", 1);
        CE = tVar2;
        f13608a = new t[]{tVar, tVar2};
    }

    @Override // j$.time.chrono.m
    public final int getValue() {
        return ordinal();
    }
}
