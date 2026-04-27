package c4;

import b4.InterfaceC0994a;

/* JADX INFO: renamed from: c4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1142a implements D5.a, InterfaceC0994a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f9410c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile D5.a f9411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f9412b = f9410c;

    public C1142a(D5.a aVar) {
        this.f9411a = aVar;
    }

    public static InterfaceC0994a a(D5.a aVar) {
        return aVar instanceof InterfaceC0994a ? (InterfaceC0994a) aVar : new C1142a((D5.a) d.b(aVar));
    }

    public static D5.a b(D5.a aVar) {
        d.b(aVar);
        return aVar instanceof C1142a ? aVar : new C1142a(aVar);
    }

    private static Object c(Object obj, Object obj2) {
        if (obj == f9410c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // D5.a
    public Object get() {
        Object obj = this.f9412b;
        Object obj2 = f9410c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f9412b;
                    if (obj == obj2) {
                        obj = this.f9411a.get();
                        this.f9412b = c(this.f9412b, obj);
                        this.f9411a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
