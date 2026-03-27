package G4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class j implements c, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public R4.a f536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f538c;

    public j(R4.a initializer) {
        kotlin.jvm.internal.j.e(initializer, "initializer");
        this.f536a = initializer;
        this.f537b = k.f539a;
        this.f538c = this;
    }

    @Override // G4.c
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f537b;
        k kVar = k.f539a;
        if (obj != kVar) {
            return obj;
        }
        synchronized (this.f538c) {
            objInvoke = this.f537b;
            if (objInvoke == kVar) {
                R4.a aVar = this.f536a;
                kotlin.jvm.internal.j.b(aVar);
                objInvoke = aVar.invoke();
                this.f537b = objInvoke;
                this.f536a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.f537b != k.f539a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
