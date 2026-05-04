package u9;

import android.graphics.drawable.Drawable;
import com.revenuecat.purchases.common.Constants;
import i3.q;
import q9.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j implements y3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ea.i f22454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f22455b;

    public j(ea.i iVar, r rVar) {
        this.f22454a = iVar;
        this.f22455b = rVar;
    }

    @Override // y3.e
    public boolean b(q qVar, Object obj, z3.d dVar, boolean z10) {
        l.a("Image Downloading  Error : " + qVar.getMessage() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + qVar.getCause());
        if (this.f22454a == null || this.f22455b == null) {
            return false;
        }
        if (qVar.getLocalizedMessage().contains("Failed to decode")) {
            this.f22455b.c(r.b.IMAGE_UNSUPPORTED_FORMAT);
            return false;
        }
        this.f22455b.c(r.b.UNSPECIFIED_RENDER_ERROR);
        return false;
    }

    @Override // y3.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, Object obj, z3.d dVar, g3.a aVar, boolean z10) {
        l.a("Image Downloading  Success : " + drawable);
        return false;
    }
}
