package com.bumptech.glide;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a4.c f5260a = a4.a.a();

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final a4.c b() {
        return this.f5260a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return c4.l.d(this.f5260a, ((l) obj).f5260a);
        }
        return false;
    }

    public int hashCode() {
        a4.c cVar = this.f5260a;
        if (cVar != null) {
            return cVar.hashCode();
        }
        return 0;
    }
}
