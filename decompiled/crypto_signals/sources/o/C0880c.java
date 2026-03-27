package o;

import java.util.Map;

/* JADX INFO: renamed from: o.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0880c implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0880c f8617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0880c f8618d;

    public C0880c(Object obj, Object obj2) {
        this.f8615a = obj;
        this.f8616b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0880c)) {
            return false;
        }
        C0880c c0880c = (C0880c) obj;
        return this.f8615a.equals(c0880c.f8615a) && this.f8616b.equals(c0880c.f8616b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8615a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f8616b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f8615a.hashCode() ^ this.f8616b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f8615a + "=" + this.f8616b;
    }
}
