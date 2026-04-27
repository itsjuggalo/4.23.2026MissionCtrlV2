package Y6;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: Y6.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1038z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1013k f9699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B5.p f9700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f9701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f9702e;

    public C1038z(Object obj, InterfaceC1013k interfaceC1013k, B5.p pVar, Object obj2, Throwable th) {
        this.f9698a = obj;
        this.f9699b = interfaceC1013k;
        this.f9700c = pVar;
        this.f9701d = obj2;
        this.f9702e = th;
    }

    public static /* synthetic */ C1038z b(C1038z c1038z, Object obj, InterfaceC1013k interfaceC1013k, B5.p pVar, Object obj2, Throwable th, int i8, Object obj3) {
        if ((i8 & 1) != 0) {
            obj = c1038z.f9698a;
        }
        if ((i8 & 2) != 0) {
            interfaceC1013k = c1038z.f9699b;
        }
        InterfaceC1013k interfaceC1013k2 = interfaceC1013k;
        if ((i8 & 4) != 0) {
            pVar = c1038z.f9700c;
        }
        B5.p pVar2 = pVar;
        if ((i8 & 8) != 0) {
            obj2 = c1038z.f9701d;
        }
        Object obj4 = obj2;
        if ((i8 & 16) != 0) {
            th = c1038z.f9702e;
        }
        return c1038z.a(obj, interfaceC1013k2, pVar2, obj4, th);
    }

    public final C1038z a(Object obj, InterfaceC1013k interfaceC1013k, B5.p pVar, Object obj2, Throwable th) {
        return new C1038z(obj, interfaceC1013k, pVar, obj2, th);
    }

    public final boolean c() {
        return this.f9702e != null;
    }

    public final void d(C1019n c1019n, Throwable th) {
        InterfaceC1013k interfaceC1013k = this.f9699b;
        if (interfaceC1013k != null) {
            c1019n.m(interfaceC1013k, th);
        }
        B5.p pVar = this.f9700c;
        if (pVar != null) {
            c1019n.n(pVar, th, this.f9698a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1038z)) {
            return false;
        }
        C1038z c1038z = (C1038z) obj;
        return AbstractC2304t.b(this.f9698a, c1038z.f9698a) && AbstractC2304t.b(this.f9699b, c1038z.f9699b) && AbstractC2304t.b(this.f9700c, c1038z.f9700c) && AbstractC2304t.b(this.f9701d, c1038z.f9701d) && AbstractC2304t.b(this.f9702e, c1038z.f9702e);
    }

    public int hashCode() {
        Object obj = this.f9698a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        InterfaceC1013k interfaceC1013k = this.f9699b;
        int iHashCode2 = (iHashCode + (interfaceC1013k == null ? 0 : interfaceC1013k.hashCode())) * 31;
        B5.p pVar = this.f9700c;
        int iHashCode3 = (iHashCode2 + (pVar == null ? 0 : pVar.hashCode())) * 31;
        Object obj2 = this.f9701d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f9702e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f9698a + ", cancelHandler=" + this.f9699b + ", onCancellation=" + this.f9700c + ", idempotentResume=" + this.f9701d + ", cancelCause=" + this.f9702e + ')';
    }

    public /* synthetic */ C1038z(Object obj, InterfaceC1013k interfaceC1013k, B5.p pVar, Object obj2, Throwable th, int i8, AbstractC2296k abstractC2296k) {
        this(obj, (i8 & 2) != 0 ? null : interfaceC1013k, (i8 & 4) != 0 ? null : pVar, (i8 & 8) != 0 ? null : obj2, (i8 & 16) != 0 ? null : th);
    }
}
