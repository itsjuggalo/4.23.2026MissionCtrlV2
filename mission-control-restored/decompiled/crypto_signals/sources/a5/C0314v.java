package a5;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: a5.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0314v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0304k f4156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final R4.q f4157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4158d;
    public final Throwable e;

    public C0314v(Object obj, InterfaceC0304k interfaceC0304k, R4.q qVar, Object obj2, Throwable th) {
        this.f4155a = obj;
        this.f4156b = interfaceC0304k;
        this.f4157c = qVar;
        this.f4158d = obj2;
        this.e = th;
    }

    public static C0314v a(C0314v c0314v, InterfaceC0304k interfaceC0304k, CancellationException cancellationException, int i) {
        Object obj = c0314v.f4155a;
        if ((i & 2) != 0) {
            interfaceC0304k = c0314v.f4156b;
        }
        InterfaceC0304k interfaceC0304k2 = interfaceC0304k;
        R4.q qVar = c0314v.f4157c;
        Object obj2 = c0314v.f4158d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = c0314v.e;
        }
        c0314v.getClass();
        return new C0314v(obj, interfaceC0304k2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0314v)) {
            return false;
        }
        C0314v c0314v = (C0314v) obj;
        return kotlin.jvm.internal.j.a(this.f4155a, c0314v.f4155a) && kotlin.jvm.internal.j.a(this.f4156b, c0314v.f4156b) && kotlin.jvm.internal.j.a(this.f4157c, c0314v.f4157c) && kotlin.jvm.internal.j.a(this.f4158d, c0314v.f4158d) && kotlin.jvm.internal.j.a(this.e, c0314v.e);
    }

    public final int hashCode() {
        Object obj = this.f4155a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        InterfaceC0304k interfaceC0304k = this.f4156b;
        int iHashCode2 = (iHashCode + (interfaceC0304k == null ? 0 : interfaceC0304k.hashCode())) * 31;
        R4.q qVar = this.f4157c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f4158d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f4155a + ", cancelHandler=" + this.f4156b + ", onCancellation=" + this.f4157c + ", idempotentResume=" + this.f4158d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ C0314v(Object obj, InterfaceC0304k interfaceC0304k, R4.q qVar, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : interfaceC0304k, (i & 4) != 0 ? null : qVar, (Object) null, (i & 16) != 0 ? null : cancellationException);
    }
}
