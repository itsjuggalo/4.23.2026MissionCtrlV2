package H3;

import D3.r;
import W0.q;
import android.graphics.drawable.Drawable;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class j implements m1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final R3.i f3688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f3689b;

    public j(R3.i iVar, r rVar) {
        this.f3688a = iVar;
        this.f3689b = rVar;
    }

    @Override // m1.e
    public boolean a(q qVar, Object obj, n1.d dVar, boolean z7) {
        r rVar;
        r.b bVar;
        l.a("Image Downloading  Error : " + qVar.getMessage() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + qVar.getCause());
        if (this.f3688a == null || this.f3689b == null) {
            return false;
        }
        if (qVar.getLocalizedMessage().contains("Failed to decode")) {
            rVar = this.f3689b;
            bVar = r.b.IMAGE_UNSUPPORTED_FORMAT;
        } else {
            rVar = this.f3689b;
            bVar = r.b.UNSPECIFIED_RENDER_ERROR;
        }
        rVar.a(bVar);
        return false;
    }

    @Override // m1.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(Drawable drawable, Object obj, n1.d dVar, U0.a aVar, boolean z7) {
        l.a("Image Downloading  Success : " + drawable);
        return false;
    }
}
