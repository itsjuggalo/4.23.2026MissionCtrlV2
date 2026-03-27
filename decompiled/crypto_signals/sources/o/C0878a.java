package o;

import java.util.HashMap;

/* JADX INFO: renamed from: o.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0878a extends C0883f {
    public final HashMap e = new HashMap();

    @Override // o.C0883f
    public final C0880c a(Object obj) {
        return (C0880c) this.e.get(obj);
    }

    @Override // o.C0883f
    public final Object b(Object obj) {
        Object objB = super.b(obj);
        this.e.remove(obj);
        return objB;
    }
}
