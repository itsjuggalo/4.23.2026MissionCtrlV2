package Z2;

import W2.p;
import a3.AbstractC0787c;
import a3.EnumC0785a;
import b3.InterfaceC0867e;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements e, InterfaceC0867e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6013b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f6014c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "result");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6015a;
    private volatile Object result;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public k(e delegate, Object obj) {
        r.f(delegate, "delegate");
        this.f6015a = delegate;
        this.result = obj;
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        EnumC0785a enumC0785a = EnumC0785a.f6187b;
        if (obj == enumC0785a) {
            if (androidx.concurrent.futures.b.a(f6014c, this, enumC0785a, AbstractC0787c.e())) {
                return AbstractC0787c.e();
            }
            obj = this.result;
        }
        if (obj == EnumC0785a.f6188c) {
            return AbstractC0787c.e();
        }
        if (obj instanceof p.b) {
            throw ((p.b) obj).f5489a;
        }
        return obj;
    }

    @Override // b3.InterfaceC0867e
    public InterfaceC0867e getCallerFrame() {
        e eVar = this.f6015a;
        if (eVar instanceof InterfaceC0867e) {
            return (InterfaceC0867e) eVar;
        }
        return null;
    }

    @Override // Z2.e
    public i getContext() {
        return this.f6015a.getContext();
    }

    @Override // Z2.e
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            EnumC0785a enumC0785a = EnumC0785a.f6187b;
            if (obj2 == enumC0785a) {
                if (androidx.concurrent.futures.b.a(f6014c, this, enumC0785a, obj)) {
                    return;
                }
            } else {
                if (obj2 != AbstractC0787c.e()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.b.a(f6014c, this, AbstractC0787c.e(), EnumC0785a.f6188c)) {
                    this.f6015a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.f6015a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(e delegate) {
        this(delegate, EnumC0785a.f6187b);
        r.f(delegate, "delegate");
    }
}
