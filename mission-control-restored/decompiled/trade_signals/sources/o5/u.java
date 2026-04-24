package o5;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements InterfaceC2483k, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0 f21989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f21990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f21991c;

    public u(Function0 initializer, Object obj) {
        AbstractC2304t.f(initializer, "initializer");
        this.f21989a = initializer;
        this.f21990b = C2466D.f21950a;
        this.f21991c = obj == null ? this : obj;
    }

    @Override // o5.InterfaceC2483k
    public boolean e() {
        return this.f21990b != C2466D.f21950a;
    }

    @Override // o5.InterfaceC2483k
    public Object getValue() {
        Object objInvoke;
        Object obj = this.f21990b;
        C2466D c2466d = C2466D.f21950a;
        if (obj != c2466d) {
            return obj;
        }
        synchronized (this.f21991c) {
            objInvoke = this.f21990b;
            if (objInvoke == c2466d) {
                Function0 function0 = this.f21989a;
                AbstractC2304t.c(function0);
                objInvoke = function0.invoke();
                this.f21990b = objInvoke;
                this.f21989a = null;
            }
        }
        return objInvoke;
    }

    public String toString() {
        return e() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ u(Function0 function0, Object obj, int i8, AbstractC2296k abstractC2296k) {
        this(function0, (i8 & 2) != 0 ? null : obj);
    }
}
