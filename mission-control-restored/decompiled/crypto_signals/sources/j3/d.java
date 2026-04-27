package j3;

import s3.D;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f7758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ d[] f7759c;

    static {
        d dVar = new d("CRASHLYTICS", 0);
        f7757a = dVar;
        d dVar2 = new d("PERFORMANCE", 1);
        f7758b = dVar2;
        d[] dVarArr = {dVar, dVar2, new d("MATT_SAYS_HI", 2)};
        f7759c = dVarArr;
        D.H(dVarArr);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f7759c.clone();
    }
}
