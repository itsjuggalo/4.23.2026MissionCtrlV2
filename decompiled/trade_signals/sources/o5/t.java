package o5;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import y.AbstractC2965b;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements InterfaceC2483k, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f21984d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21985e = AtomicReferenceFieldUpdater.newUpdater(t.class, Object.class, "b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Function0 f21986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f21987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f21988c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public t(Function0 initializer) {
        AbstractC2304t.f(initializer, "initializer");
        this.f21986a = initializer;
        C2466D c2466d = C2466D.f21950a;
        this.f21987b = c2466d;
        this.f21988c = c2466d;
    }

    @Override // o5.InterfaceC2483k
    public boolean e() {
        return this.f21987b != C2466D.f21950a;
    }

    @Override // o5.InterfaceC2483k
    public Object getValue() {
        Object obj = this.f21987b;
        C2466D c2466d = C2466D.f21950a;
        if (obj != c2466d) {
            return obj;
        }
        Function0 function0 = this.f21986a;
        if (function0 != null) {
            Object objInvoke = function0.invoke();
            if (AbstractC2965b.a(f21985e, this, c2466d, objInvoke)) {
                this.f21986a = null;
                return objInvoke;
            }
        }
        return this.f21987b;
    }

    public String toString() {
        return e() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
