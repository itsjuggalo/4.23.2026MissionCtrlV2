package com.bumptech.glide;

import o1.C2455a;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o1.c f14812a = C2455a.a();

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final l clone() {
        try {
            return (l) super.clone();
        } catch (CloneNotSupportedException e8) {
            throw new RuntimeException(e8);
        }
    }

    public final o1.c c() {
        return this.f14812a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return AbstractC2629l.d(this.f14812a, ((l) obj).f14812a);
        }
        return false;
    }

    public int hashCode() {
        o1.c cVar = this.f14812a;
        if (cVar != null) {
            return cVar.hashCode();
        }
        return 0;
    }
}
