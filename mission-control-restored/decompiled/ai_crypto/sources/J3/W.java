package J3;

import com.google.protobuf.AbstractC1240i;

/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1240i f3151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r3.e f3153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r3.e f3154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r3.e f3155e;

    public W(AbstractC1240i abstractC1240i, boolean z7, r3.e eVar, r3.e eVar2, r3.e eVar3) {
        this.f3151a = abstractC1240i;
        this.f3152b = z7;
        this.f3153c = eVar;
        this.f3154d = eVar2;
        this.f3155e = eVar3;
    }

    public static W a(boolean z7, AbstractC1240i abstractC1240i) {
        return new W(abstractC1240i, z7, G3.k.h(), G3.k.h(), G3.k.h());
    }

    public r3.e b() {
        return this.f3153c;
    }

    public r3.e c() {
        return this.f3154d;
    }

    public r3.e d() {
        return this.f3155e;
    }

    public AbstractC1240i e() {
        return this.f3151a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || W.class != obj.getClass()) {
            return false;
        }
        W w7 = (W) obj;
        if (this.f3152b == w7.f3152b && this.f3151a.equals(w7.f3151a) && this.f3153c.equals(w7.f3153c) && this.f3154d.equals(w7.f3154d)) {
            return this.f3155e.equals(w7.f3155e);
        }
        return false;
    }

    public boolean f() {
        return this.f3152b;
    }

    public int hashCode() {
        return (((((((this.f3151a.hashCode() * 31) + (this.f3152b ? 1 : 0)) * 31) + this.f3153c.hashCode()) * 31) + this.f3154d.hashCode()) * 31) + this.f3155e.hashCode();
    }
}
