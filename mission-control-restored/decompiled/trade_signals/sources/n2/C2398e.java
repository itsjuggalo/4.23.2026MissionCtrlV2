package n2;

/* JADX INFO: renamed from: n2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2398e implements InterfaceC2400g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f21579c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile InterfaceC2400g f21580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f21581b = f21579c;

    public C2398e(InterfaceC2400g interfaceC2400g) {
        this.f21580a = interfaceC2400g;
    }

    public static InterfaceC2400g a(InterfaceC2400g interfaceC2400g) {
        interfaceC2400g.getClass();
        return interfaceC2400g instanceof C2398e ? interfaceC2400g : new C2398e(interfaceC2400g);
    }

    @Override // n2.InterfaceC2400g
    public final Object zza() {
        Object objZza = this.f21581b;
        Object obj = f21579c;
        if (objZza == obj) {
            synchronized (this) {
                try {
                    objZza = this.f21581b;
                    if (objZza == obj) {
                        objZza = this.f21580a.zza();
                        Object obj2 = this.f21581b;
                        if (obj2 != obj && obj2 != objZza) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objZza + ". This is likely due to a circular dependency.");
                        }
                        this.f21581b = objZza;
                        this.f21580a = null;
                    }
                } finally {
                }
            }
        }
        return objZza;
    }
}
