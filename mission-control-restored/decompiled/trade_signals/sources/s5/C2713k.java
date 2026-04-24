package s5;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2490r;
import t5.AbstractC2751c;
import t5.EnumC2749a;
import u5.InterfaceC2778e;
import y.AbstractC2965b;

/* JADX INFO: renamed from: s5.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2713k implements InterfaceC2707e, InterfaceC2778e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f23117b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f23118c = AtomicReferenceFieldUpdater.newUpdater(C2713k.class, Object.class, "result");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2707e f23119a;
    private volatile Object result;

    /* JADX INFO: renamed from: s5.k$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2713k(InterfaceC2707e delegate) {
        this(delegate, EnumC2749a.f23326b);
        AbstractC2304t.f(delegate, "delegate");
    }

    public final Object a() throws Throwable {
        Object obj = this.result;
        EnumC2749a enumC2749a = EnumC2749a.f23326b;
        if (obj == enumC2749a) {
            if (AbstractC2965b.a(f23118c, this, enumC2749a, AbstractC2751c.f())) {
                return AbstractC2751c.f();
            }
            obj = this.result;
        }
        if (obj == EnumC2749a.f23327c) {
            return AbstractC2751c.f();
        }
        if (obj instanceof C2490r.b) {
            throw ((C2490r.b) obj).f21983a;
        }
        return obj;
    }

    @Override // u5.InterfaceC2778e
    public InterfaceC2778e getCallerFrame() {
        InterfaceC2707e interfaceC2707e = this.f23119a;
        if (interfaceC2707e instanceof InterfaceC2778e) {
            return (InterfaceC2778e) interfaceC2707e;
        }
        return null;
    }

    @Override // s5.InterfaceC2707e
    public InterfaceC2711i getContext() {
        return this.f23119a.getContext();
    }

    @Override // s5.InterfaceC2707e
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            EnumC2749a enumC2749a = EnumC2749a.f23326b;
            if (obj2 == enumC2749a) {
                if (AbstractC2965b.a(f23118c, this, enumC2749a, obj)) {
                    return;
                }
            } else {
                if (obj2 != AbstractC2751c.f()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (AbstractC2965b.a(f23118c, this, AbstractC2751c.f(), EnumC2749a.f23327c)) {
                    this.f23119a.resumeWith(obj);
                    return;
                }
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.f23119a;
    }

    public C2713k(InterfaceC2707e delegate, Object obj) {
        AbstractC2304t.f(delegate, "delegate");
        this.f23119a = delegate;
        this.result = obj;
    }
}
