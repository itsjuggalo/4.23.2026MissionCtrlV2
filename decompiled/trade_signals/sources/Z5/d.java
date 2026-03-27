package Z5;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9770a = new d("FROM_IDE", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f9771b = new d("FROM_BACKEND", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f9772c = new d("FROM_TEST", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f9773d = new d("FROM_BUILTINS", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f9774e = new d("WHEN_CHECK_DECLARATION_CONFLICTS", 4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f9775f = new d("WHEN_CHECK_OVERRIDES", 5);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f9776g = new d("FOR_SCRIPT", 6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f9777h = new d("FROM_REFLECTION", 7);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f9778i = new d("WHEN_RESOLVE_DECLARATION", 8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f9779j = new d("WHEN_GET_DECLARATION_SCOPE", 9);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f9780k = new d("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f9781l = new d("FOR_ALREADY_TRACKED", 11);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f9782m = new d("WHEN_GET_ALL_DESCRIPTORS", 12);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d f9783n = new d("WHEN_TYPING", 13);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f9784o = new d("WHEN_GET_SUPER_MEMBERS", 14);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f9785p = new d("FOR_NON_TRACKED_SCOPE", 15);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d f9786q = new d("FROM_SYNTHETIC_SCOPE", 16);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f9787r = new d("FROM_DESERIALIZATION", 17);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d f9788s = new d("FROM_JAVA_LOADER", 18);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final d f9789t = new d("WHEN_GET_LOCAL_VARIABLE", 19);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final d f9790u = new d("WHEN_FIND_BY_FQNAME", 20);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f9791v = new d("WHEN_GET_COMPANION_OBJECT", 21);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final d f9792w = new d("FOR_DEFAULT_IMPORTS", 22);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ d[] f9793x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f9794y;

    static {
        d[] dVarArrB = b();
        f9793x = dVarArrB;
        f9794y = AbstractC2875b.a(dVarArrB);
    }

    public d(String str, int i8) {
    }

    public static final /* synthetic */ d[] b() {
        return new d[]{f9770a, f9771b, f9772c, f9773d, f9774e, f9775f, f9776g, f9777h, f9778i, f9779j, f9780k, f9781l, f9782m, f9783n, f9784o, f9785p, f9786q, f9787r, f9788s, f9789t, f9790u, f9791v, f9792w};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f9793x.clone();
    }

    @Override // Z5.b
    public a a() {
        return null;
    }
}
