package kotlin.jvm.internal;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class a implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f7920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7921b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7922c = 2;

    public a(AtomicReference atomicReference) {
        this.f7920a = atomicReference;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7921b == aVar.f7921b && this.f7922c == aVar.f7922c && j.a(this.f7920a, aVar.f7920a) && AtomicReference.class.equals(AtomicReference.class);
    }

    @Override // kotlin.jvm.internal.g
    public final int getArity() {
        return 2;
    }

    public final int hashCode() {
        return ((((((((((AtomicReference.class.hashCode() + ((this.f7920a != null ? r0.hashCode() : 0) * 31)) * 31) + 113762) * 31) - 869290769) * 31) + (this.f7921b ? 1231 : 1237)) * 31) + 2) * 31) + this.f7922c;
    }

    public final String toString() {
        t.f7935a.getClass();
        return u.a(this);
    }
}
