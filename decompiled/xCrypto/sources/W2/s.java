package W2;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements j, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f5495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f5496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5497c;

    public s(Function0 initializer, Object obj) {
        kotlin.jvm.internal.r.f(initializer, "initializer");
        this.f5495a = initializer;
        this.f5496b = A.f5457a;
        this.f5497c = obj == null ? this : obj;
    }

    @Override // W2.j
    public Object getValue() {
        Object objInvoke;
        Object obj = this.f5496b;
        A a4 = A.f5457a;
        if (obj != a4) {
            return obj;
        }
        synchronized (this.f5497c) {
            objInvoke = this.f5496b;
            if (objInvoke == a4) {
                Function0 function0 = this.f5495a;
                kotlin.jvm.internal.r.c(function0);
                objInvoke = function0.invoke();
                this.f5496b = objInvoke;
                this.f5495a = null;
            }
        }
        return objInvoke;
    }

    @Override // W2.j
    public boolean isInitialized() {
        return this.f5496b != A.f5457a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ s(Function0 function0, Object obj, int i4, AbstractC1585j abstractC1585j) {
        this(function0, (i4 & 2) != 0 ? null : obj);
    }
}
