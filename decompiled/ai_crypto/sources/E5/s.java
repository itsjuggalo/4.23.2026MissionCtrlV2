package E5;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements j, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f1689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f1690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1691c;

    public s(Function0 initializer, Object obj) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        this.f1689a = initializer;
        this.f1690b = A.f1651a;
        this.f1691c = obj == null ? this : obj;
    }

    @Override // E5.j
    public boolean d() {
        return this.f1690b != A.f1651a;
    }

    @Override // E5.j
    public Object getValue() {
        Object objInvoke;
        Object obj = this.f1690b;
        A a7 = A.f1651a;
        if (obj != a7) {
            return obj;
        }
        synchronized (this.f1691c) {
            objInvoke = this.f1690b;
            if (objInvoke == a7) {
                Function0 function0 = this.f1689a;
                kotlin.jvm.internal.r.c(function0);
                objInvoke = function0.invoke();
                this.f1690b = objInvoke;
                this.f1689a = null;
            }
        }
        return objInvoke;
    }

    public String toString() {
        return d() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ s(Function0 function0, Object obj, int i7, AbstractC2148j abstractC2148j) {
        this(function0, (i7 & 2) != 0 ? null : obj);
    }
}
