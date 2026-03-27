package P5;

import P5.f;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f6459b = new c("Function", 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f6460c = new c("SuspendFunction", 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f6461d = new c("KFunction", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f6462e = new c("KSuspendFunction", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f6463f = new c("UNKNOWN", 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ c[] f6464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f6465h;

    public static final class a {
        public a() {
        }

        public final c a(f functionTypeKind) {
            AbstractC2304t.f(functionTypeKind, "functionTypeKind");
            return AbstractC2304t.b(functionTypeKind, f.a.f6471e) ? c.f6459b : AbstractC2304t.b(functionTypeKind, f.d.f6474e) ? c.f6460c : AbstractC2304t.b(functionTypeKind, f.b.f6472e) ? c.f6461d : AbstractC2304t.b(functionTypeKind, f.c.f6473e) ? c.f6462e : c.f6463f;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    static {
        c[] cVarArrA = a();
        f6464g = cVarArrA;
        f6465h = AbstractC2875b.a(cVarArrA);
        f6458a = new a(null);
    }

    public c(String str, int i8) {
    }

    public static final /* synthetic */ c[] a() {
        return new c[]{f6459b, f6460c, f6461d, f6462e, f6463f};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f6464g.clone();
    }
}
