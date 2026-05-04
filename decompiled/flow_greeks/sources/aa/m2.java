package aa;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import q9.a;
import q9.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map f516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map f517i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ga.h f520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final da.a f521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnalyticsConnector f522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f524g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f525a;

        static {
            int[] iArr = new int[MessageType.values().length];
            f525a = iArr;
            try {
                iArr[MessageType.CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f525a[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f525a[MessageType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f525a[MessageType.IMAGE_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void a(byte[] bArr);
    }

    static {
        HashMap map = new HashMap();
        f516h = map;
        HashMap map2 = new HashMap();
        f517i = map2;
        map.put(r.b.UNSPECIFIED_RENDER_ERROR, q9.d0.UNSPECIFIED_RENDER_ERROR);
        map.put(r.b.IMAGE_FETCH_ERROR, q9.d0.IMAGE_FETCH_ERROR);
        map.put(r.b.IMAGE_DISPLAY_ERROR, q9.d0.IMAGE_DISPLAY_ERROR);
        map.put(r.b.IMAGE_UNSUPPORTED_FORMAT, q9.d0.IMAGE_UNSUPPORTED_FORMAT);
        map2.put(r.a.AUTO, q9.i.AUTO);
        map2.put(r.a.CLICK, q9.i.CLICK);
        map2.put(r.a.SWIPE, q9.i.SWIPE);
        map2.put(r.a.UNKNOWN_DISMISS_TYPE, q9.i.UNKNOWN_DISMISS_TYPE);
    }

    public m2(b bVar, AnalyticsConnector analyticsConnector, a7.g gVar, ga.h hVar, da.a aVar, o oVar, Executor executor) {
        this.f518a = bVar;
        this.f522e = analyticsConnector;
        this.f519b = gVar;
        this.f520c = hVar;
        this.f521d = aVar;
        this.f523f = oVar;
        this.f524g = executor;
    }

    public Bundle e(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", str2);
        bundle.putString("_nmn", str);
        try {
            bundle.putInt("_ndt", (int) (this.f521d.a() / 1000));
            return bundle;
        } catch (NumberFormatException e10) {
            h2.d("Error while parsing use_device_time in FIAM event: " + e10.getMessage());
            return bundle;
        }
    }

    public final a.b f(ea.i iVar, String str) {
        return q9.a.i0().C("22.0.2").D(this.f519b.r().f()).x(iVar.a().a()).y(q9.b.c0().y(this.f519b.r().c()).x(str)).z(this.f521d.a());
    }

    public final q9.a g(ea.i iVar, String str, q9.i iVar2) {
        return (q9.a) f(iVar, str).A(iVar2).n();
    }

    public final q9.a h(ea.i iVar, String str, q9.j jVar) {
        return (q9.a) f(iVar, str).B(jVar).n();
    }

    public final q9.a i(ea.i iVar, String str, q9.d0 d0Var) {
        return (q9.a) f(iVar, str).E(d0Var).n();
    }

    public final boolean j(ea.i iVar) {
        boolean zL;
        int i10 = a.f525a[iVar.c().ordinal()];
        if (i10 == 1) {
            ea.f fVar = (ea.f) iVar;
            return (l(fVar.i()) || l(fVar.j())) ? false : true;
        }
        if (i10 == 2) {
            zL = l(((ea.j) iVar).e());
        } else if (i10 == 3) {
            zL = l(((ea.c) iVar).e());
        } else {
            if (i10 != 4) {
                h2.b("Unable to determine if impression should be counted as conversion.");
                return false;
            }
            zL = l(((ea.h) iVar).e());
        }
        return !zL;
    }

    public final boolean k(ea.i iVar) {
        return iVar.a().c();
    }

    public final boolean l(ea.a aVar) {
        return (aVar == null || aVar.b() == null || aVar.b().isEmpty()) ? false : true;
    }

    public void m(final ea.i iVar, final r.a aVar) {
        if (!k(iVar)) {
            this.f520c.getId().addOnSuccessListener(this.f524g, new OnSuccessListener() { // from class: aa.l2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    m2 m2Var = this.f507a;
                    m2Var.f518a.a(m2Var.g(iVar, (String) obj, (q9.i) m2.f517i.get(aVar)).i());
                }
            });
            n(iVar, "fiam_dismiss", false);
        }
        this.f523f.d(iVar);
    }

    public final void n(ea.i iVar, String str, boolean z10) {
        String strA = iVar.a().a();
        Bundle bundleE = e(iVar.a().b(), strA);
        h2.a("Sending event=" + str + " params=" + bundleE);
        AnalyticsConnector analyticsConnector = this.f522e;
        if (analyticsConnector == null) {
            h2.d("Unable to log event: analytics library is missing");
            return;
        }
        analyticsConnector.logEvent(AppMeasurement.FIAM_ORIGIN, str, bundleE);
        if (z10) {
            this.f522e.setUserProperty(AppMeasurement.FIAM_ORIGIN, "_ln", "fiam:" + strA);
        }
    }

    public void o(final ea.i iVar) {
        if (!k(iVar)) {
            this.f520c.getId().addOnSuccessListener(this.f524g, new OnSuccessListener() { // from class: aa.i2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    m2 m2Var = this.f478a;
                    m2Var.f518a.a(m2Var.h(iVar, (String) obj, q9.j.IMPRESSION_EVENT_TYPE).i());
                }
            });
            n(iVar, "fiam_impression", j(iVar));
        }
        this.f523f.b(iVar);
    }

    public void p(final ea.i iVar, ea.a aVar) {
        if (!k(iVar)) {
            this.f520c.getId().addOnSuccessListener(this.f524g, new OnSuccessListener() { // from class: aa.k2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    m2 m2Var = this.f498a;
                    m2Var.f518a.a(m2Var.h(iVar, (String) obj, q9.j.CLICK_EVENT_TYPE).i());
                }
            });
            n(iVar, "fiam_action", true);
        }
        this.f523f.c(iVar, aVar);
    }

    public void q(final ea.i iVar, final r.b bVar) {
        if (!k(iVar)) {
            this.f520c.getId().addOnSuccessListener(this.f524g, new OnSuccessListener() { // from class: aa.j2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    m2 m2Var = this.f488a;
                    m2Var.f518a.a(m2Var.i(iVar, (String) obj, (q9.d0) m2.f516h.get(bVar)).i());
                }
            });
        }
        this.f523f.a(iVar, bVar);
    }
}
