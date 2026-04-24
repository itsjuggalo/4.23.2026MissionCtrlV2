package h1;

import U0.l;
import W0.v;
import android.content.Context;
import android.graphics.Bitmap;
import d1.C1618g;
import java.security.MessageDigest;
import q1.AbstractC2628k;

/* JADX INFO: renamed from: h1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1851f implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f18356b;

    public C1851f(l lVar) {
        this.f18356b = (l) AbstractC2628k.d(lVar);
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        this.f18356b.a(messageDigest);
    }

    @Override // U0.l
    public v b(Context context, v vVar, int i8, int i9) {
        C1848c c1848c = (C1848c) vVar.get();
        v c1618g = new C1618g(c1848c.e(), com.bumptech.glide.b.c(context).f());
        v vVarB = this.f18356b.b(context, c1618g, i8, i9);
        if (!c1618g.equals(vVarB)) {
            c1618g.b();
        }
        c1848c.m(this.f18356b, (Bitmap) vVarB.get());
        return vVar;
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (obj instanceof C1851f) {
            return this.f18356b.equals(((C1851f) obj).f18356b);
        }
        return false;
    }

    @Override // U0.f
    public int hashCode() {
        return this.f18356b.hashCode();
    }
}
