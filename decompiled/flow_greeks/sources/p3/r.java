package p3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r implements g3.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g3.l f18277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18278c;

    public r(g3.l lVar, boolean z10) {
        this.f18277b = lVar;
        this.f18278c = z10;
    }

    @Override // g3.l
    public i3.v a(Context context, i3.v vVar, int i10, int i11) {
        j3.d dVarF = com.bumptech.glide.b.c(context).f();
        Drawable drawable = (Drawable) vVar.get();
        i3.v vVarA = q.a(dVarF, drawable, i10, i11);
        if (vVarA != null) {
            i3.v vVarA2 = this.f18277b.a(context, vVarA, i10, i11);
            if (!vVarA2.equals(vVarA)) {
                return d(context, vVarA2);
            }
            vVarA2.b();
            return vVar;
        }
        if (!this.f18278c) {
            return vVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        this.f18277b.b(messageDigest);
    }

    public final i3.v d(Context context, i3.v vVar) {
        return z.f(context.getResources(), vVar);
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f18277b.equals(((r) obj).f18277b);
        }
        return false;
    }

    @Override // g3.f
    public int hashCode() {
        return this.f18277b.hashCode();
    }

    public g3.l c() {
        return this;
    }
}
