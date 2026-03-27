package U1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class m implements l, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f3114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile transient boolean f3115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Object f3116c;

    public m(l lVar) {
        this.f3114a = lVar;
    }

    @Override // U1.l
    public final Object get() {
        if (!this.f3115b) {
            synchronized (this) {
                try {
                    if (!this.f3115b) {
                        Object obj = this.f3114a.get();
                        this.f3116c = obj;
                        this.f3115b = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f3116c;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Suppliers.memoize(");
        if (this.f3115b) {
            obj = "<supplier that returned " + this.f3116c + ">";
        } else {
            obj = this.f3114a;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }
}
