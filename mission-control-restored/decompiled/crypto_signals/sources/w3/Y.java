package w3;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements t3.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t3.s f10743c;

    public /* synthetic */ Y(Object obj, t3.s sVar, int i) {
        this.f10741a = i;
        this.f10742b = obj;
        this.f10743c = sVar;
    }

    @Override // t3.t
    public final t3.s create(t3.e eVar, A3.a aVar) {
        switch (this.f10741a) {
            case 0:
                if (aVar.f61a == ((Class) this.f10742b)) {
                    return this.f10743c;
                }
                return null;
            case 1:
                Class<?> cls = aVar.f61a;
                if (((Class) this.f10742b).isAssignableFrom(cls)) {
                    return new C1283c(this, cls);
                }
                return null;
            default:
                if (aVar.equals((A3.a) this.f10742b)) {
                    return this.f10743c;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f10741a) {
            case 0:
                return "Factory[type=" + ((Class) this.f10742b).getName() + ",adapter=" + this.f10743c + "]";
            case 1:
                return "Factory[typeHierarchy=" + ((Class) this.f10742b).getName() + ",adapter=" + this.f10743c + "]";
            default:
                return super.toString();
        }
    }
}
