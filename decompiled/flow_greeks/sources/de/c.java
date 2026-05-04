package de;

import de.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f8058b = new c("Function", 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f8059c = new c("SuspendFunction", 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f8060d = new c("KFunction", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f8061e = new c("KSuspendFunction", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f8062f = new c("UNKNOWN", 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ c[] f8063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ jd.a f8064h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final c a(f functionTypeKind) {
            t.f(functionTypeKind, "functionTypeKind");
            return t.b(functionTypeKind, f.a.f8069e) ? c.f8058b : t.b(functionTypeKind, f.d.f8072e) ? c.f8059c : t.b(functionTypeKind, f.b.f8070e) ? c.f8060d : t.b(functionTypeKind, f.c.f8071e) ? c.f8061e : c.f8062f;
        }

        public a() {
        }
    }

    static {
        c[] cVarArrA = a();
        f8063g = cVarArrA;
        f8064h = jd.b.a(cVarArrA);
        f8057a = new a(null);
    }

    public c(String str, int i10) {
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{f8058b, f8059c, f8060d, f8061e, f8062f};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f8063g.clone();
    }
}
