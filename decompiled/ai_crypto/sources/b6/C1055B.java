package b6;

import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: b6.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1055B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1081m f8960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q5.k f8961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f8962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f8963e;

    public C1055B(Object obj, AbstractC1081m abstractC1081m, Q5.k kVar, Object obj2, Throwable th) {
        this.f8959a = obj;
        this.f8960b = abstractC1081m;
        this.f8961c = kVar;
        this.f8962d = obj2;
        this.f8963e = th;
    }

    public static /* synthetic */ C1055B b(C1055B c1055b, Object obj, AbstractC1081m abstractC1081m, Q5.k kVar, Object obj2, Throwable th, int i7, Object obj3) {
        if ((i7 & 1) != 0) {
            obj = c1055b.f8959a;
        }
        if ((i7 & 2) != 0) {
            abstractC1081m = c1055b.f8960b;
        }
        AbstractC1081m abstractC1081m2 = abstractC1081m;
        if ((i7 & 4) != 0) {
            kVar = c1055b.f8961c;
        }
        Q5.k kVar2 = kVar;
        if ((i7 & 8) != 0) {
            obj2 = c1055b.f8962d;
        }
        Object obj4 = obj2;
        if ((i7 & 16) != 0) {
            th = c1055b.f8963e;
        }
        return c1055b.a(obj, abstractC1081m2, kVar2, obj4, th);
    }

    public final C1055B a(Object obj, AbstractC1081m abstractC1081m, Q5.k kVar, Object obj2, Throwable th) {
        return new C1055B(obj, abstractC1081m, kVar, obj2, th);
    }

    public final boolean c() {
        return this.f8963e != null;
    }

    public final void d(C1087p c1087p, Throwable th) {
        AbstractC1081m abstractC1081m = this.f8960b;
        if (abstractC1081m != null) {
            c1087p.o(abstractC1081m, th);
        }
        Q5.k kVar = this.f8961c;
        if (kVar != null) {
            c1087p.p(kVar, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1055B)) {
            return false;
        }
        C1055B c1055b = (C1055B) obj;
        return kotlin.jvm.internal.r.b(this.f8959a, c1055b.f8959a) && kotlin.jvm.internal.r.b(this.f8960b, c1055b.f8960b) && kotlin.jvm.internal.r.b(this.f8961c, c1055b.f8961c) && kotlin.jvm.internal.r.b(this.f8962d, c1055b.f8962d) && kotlin.jvm.internal.r.b(this.f8963e, c1055b.f8963e);
    }

    public int hashCode() {
        Object obj = this.f8959a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC1081m abstractC1081m = this.f8960b;
        int iHashCode2 = (iHashCode + (abstractC1081m == null ? 0 : abstractC1081m.hashCode())) * 31;
        Q5.k kVar = this.f8961c;
        int iHashCode3 = (iHashCode2 + (kVar == null ? 0 : kVar.hashCode())) * 31;
        Object obj2 = this.f8962d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f8963e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f8959a + ", cancelHandler=" + this.f8960b + ", onCancellation=" + this.f8961c + ", idempotentResume=" + this.f8962d + ", cancelCause=" + this.f8963e + ')';
    }

    public /* synthetic */ C1055B(Object obj, AbstractC1081m abstractC1081m, Q5.k kVar, Object obj2, Throwable th, int i7, AbstractC2148j abstractC2148j) {
        this(obj, (i7 & 2) != 0 ? null : abstractC1081m, (i7 & 4) != 0 ? null : kVar, (i7 & 8) != 0 ? null : obj2, (i7 & 16) != 0 ? null : th);
    }
}
