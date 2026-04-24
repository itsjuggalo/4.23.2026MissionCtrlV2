package v3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f10627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f10628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f10629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f10630d;
    public l e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f10631f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f10632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f10633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10634m;

    public l(boolean z6) {
        this.f10631f = null;
        this.f10632k = z6;
        this.e = this;
        this.f10630d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f10631f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f10633l;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f10631f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f10633l;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f10631f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f10633l;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f10632k) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f10633l;
        this.f10633l = obj;
        return obj2;
    }

    public final String toString() {
        return this.f10631f + "=" + this.f10633l;
    }

    public l(boolean z6, l lVar, Object obj, l lVar2, l lVar3) {
        this.f10627a = lVar;
        this.f10631f = obj;
        this.f10632k = z6;
        this.f10634m = 1;
        this.f10630d = lVar2;
        this.e = lVar3;
        lVar3.f10630d = this;
        lVar2.e = this;
    }
}
