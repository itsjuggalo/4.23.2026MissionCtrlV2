package I0;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f4047a = new j("STRICT", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f4048b = new j("LOG", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f4049c = new j("QUIET", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ j[] f4050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f4051e;

    static {
        j[] jVarArrA = a();
        f4050d = jVarArrA;
        f4051e = AbstractC2875b.a(jVarArrA);
    }

    public j(String str, int i8) {
    }

    public static final /* synthetic */ j[] a() {
        return new j[]{f4047a, f4048b, f4049c};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f4050d.clone();
    }
}
