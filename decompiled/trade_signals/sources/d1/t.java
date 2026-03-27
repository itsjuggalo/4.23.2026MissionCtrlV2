package d1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class t implements U0.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U0.l f16816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f16817c;

    public t(U0.l lVar, boolean z7) {
        this.f16816b = lVar;
        this.f16817c = z7;
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        this.f16816b.a(messageDigest);
    }

    @Override // U0.l
    public W0.v b(Context context, W0.v vVar, int i8, int i9) {
        X0.d dVarF = com.bumptech.glide.b.c(context).f();
        Drawable drawable = (Drawable) vVar.get();
        W0.v vVarA = s.a(dVarF, drawable, i8, i9);
        if (vVarA != null) {
            W0.v vVarB = this.f16816b.b(context, vVarA, i8, i9);
            if (!vVarB.equals(vVarA)) {
                return d(context, vVarB);
            }
            vVarB.b();
            return vVar;
        }
        if (!this.f16817c) {
            return vVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    public final W0.v d(Context context, W0.v vVar) {
        return y.f(context.getResources(), vVar);
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (obj instanceof t) {
            return this.f16816b.equals(((t) obj).f16816b);
        }
        return false;
    }

    @Override // U0.f
    public int hashCode() {
        return this.f16816b.hashCode();
    }

    public U0.l c() {
        return this;
    }
}
