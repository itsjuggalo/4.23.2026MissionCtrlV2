package B1;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class a implements InterfaceC2426a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f125c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile InterfaceC2426a f126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f127b = f125c;

    public a(InterfaceC2426a interfaceC2426a) {
        this.f126a = interfaceC2426a;
    }

    public static InterfaceC2426a a(InterfaceC2426a interfaceC2426a) {
        d.b(interfaceC2426a);
        return interfaceC2426a instanceof a ? interfaceC2426a : new a(interfaceC2426a);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f125c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // n5.InterfaceC2426a
    public Object get() {
        Object obj = this.f127b;
        Object obj2 = f125c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f127b;
                    if (obj == obj2) {
                        obj = this.f126a.get();
                        this.f127b = b(this.f127b, obj);
                        this.f126a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
