package t3;

import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1826m f14902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i3.k f14903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f14904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f14905e;

    public B(Object obj, AbstractC1826m abstractC1826m, i3.k kVar, Object obj2, Throwable th) {
        this.f14901a = obj;
        this.f14902b = abstractC1826m;
        this.f14903c = kVar;
        this.f14904d = obj2;
        this.f14905e = th;
    }

    public static /* synthetic */ B b(B b4, Object obj, AbstractC1826m abstractC1826m, i3.k kVar, Object obj2, Throwable th, int i4, Object obj3) {
        if ((i4 & 1) != 0) {
            obj = b4.f14901a;
        }
        if ((i4 & 2) != 0) {
            abstractC1826m = b4.f14902b;
        }
        if ((i4 & 4) != 0) {
            kVar = b4.f14903c;
        }
        if ((i4 & 8) != 0) {
            obj2 = b4.f14904d;
        }
        if ((i4 & 16) != 0) {
            th = b4.f14905e;
        }
        Throwable th2 = th;
        i3.k kVar2 = kVar;
        return b4.a(obj, abstractC1826m, kVar2, obj2, th2);
    }

    public final B a(Object obj, AbstractC1826m abstractC1826m, i3.k kVar, Object obj2, Throwable th) {
        return new B(obj, abstractC1826m, kVar, obj2, th);
    }

    public final boolean c() {
        return this.f14905e != null;
    }

    public final void d(C1832p c1832p, Throwable th) {
        AbstractC1826m abstractC1826m = this.f14902b;
        if (abstractC1826m != null) {
            c1832p.m(abstractC1826m, th);
        }
        i3.k kVar = this.f14903c;
        if (kVar != null) {
            c1832p.n(kVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b4 = (B) obj;
        return kotlin.jvm.internal.r.b(this.f14901a, b4.f14901a) && kotlin.jvm.internal.r.b(this.f14902b, b4.f14902b) && kotlin.jvm.internal.r.b(this.f14903c, b4.f14903c) && kotlin.jvm.internal.r.b(this.f14904d, b4.f14904d) && kotlin.jvm.internal.r.b(this.f14905e, b4.f14905e);
    }

    public int hashCode() {
        Object obj = this.f14901a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC1826m abstractC1826m = this.f14902b;
        int iHashCode2 = (iHashCode + (abstractC1826m == null ? 0 : abstractC1826m.hashCode())) * 31;
        i3.k kVar = this.f14903c;
        int iHashCode3 = (iHashCode2 + (kVar == null ? 0 : kVar.hashCode())) * 31;
        Object obj2 = this.f14904d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f14905e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f14901a + ", cancelHandler=" + this.f14902b + ", onCancellation=" + this.f14903c + ", idempotentResume=" + this.f14904d + ", cancelCause=" + this.f14905e + ')';
    }

    public /* synthetic */ B(Object obj, AbstractC1826m abstractC1826m, i3.k kVar, Object obj2, Throwable th, int i4, AbstractC1585j abstractC1585j) {
        this(obj, (i4 & 2) != 0 ? null : abstractC1826m, (i4 & 4) != 0 ? null : kVar, (i4 & 8) != 0 ? null : obj2, (i4 & 16) != 0 ? null : th);
    }
}
