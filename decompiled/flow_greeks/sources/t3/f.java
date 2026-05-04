package t3;

import android.content.Context;
import android.graphics.Bitmap;
import c4.k;
import g3.l;
import i3.v;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f20699b;

    public f(l lVar) {
        this.f20699b = (l) k.e(lVar);
    }

    @Override // g3.l
    public v a(Context context, v vVar, int i10, int i11) {
        c cVar = (c) vVar.get();
        v fVar = new p3.f(cVar.e(), com.bumptech.glide.b.c(context).f());
        v vVarA = this.f20699b.a(context, fVar, i10, i11);
        if (!fVar.equals(vVarA)) {
            fVar.b();
        }
        cVar.m(this.f20699b, (Bitmap) vVarA.get());
        return vVar;
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        this.f20699b.b(messageDigest);
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f20699b.equals(((f) obj).f20699b);
        }
        return false;
    }

    @Override // g3.f
    public int hashCode() {
        return this.f20699b.hashCode();
    }
}
