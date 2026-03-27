package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Y implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable f4527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ X f4529c;

    public Y(X x6, Comparable comparable, Object obj) {
        this.f4529c = x6;
        this.f4527a = comparable;
        this.f4528b = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f4527a.compareTo(((Y) obj).f4527a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f4527a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f4528b;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f4527a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f4528b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f4527a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f4528b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f4529c.c();
        Object obj2 = this.f4528b;
        this.f4528b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f4527a + "=" + this.f4528b;
    }
}
