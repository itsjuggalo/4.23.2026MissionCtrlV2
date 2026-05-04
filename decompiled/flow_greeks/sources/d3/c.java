package d3;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.play_billing.zzc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile o f7590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f7591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile s f7592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f7593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f7594e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f7595f;

        public /* synthetic */ a(Context context, j2 j2Var) {
            this.f7591b = context;
        }

        public c a() {
            Context context = this.f7591b;
            if (context == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f7592c == null) {
                if (this.f7593d || this.f7594e) {
                    return d() ? new m1(null, context, null, null, this) : new d(null, context, null, null, this);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (this.f7590a == null || !this.f7590a.a()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if (this.f7592c == null) {
                o oVar = this.f7590a;
                return d() ? new m1(null, oVar, context, null, null, null, this) : new d(null, oVar, context, null, null, null, this);
            }
            o oVar2 = this.f7590a;
            s sVar = this.f7592c;
            return d() ? new m1(null, oVar2, context, sVar, null, null, null, this) : new d(null, oVar2, context, sVar, null, null, null, this);
        }

        public a b(o oVar) {
            this.f7590a = oVar;
            return this;
        }

        public a c(s sVar) {
            this.f7592c = sVar;
            return this;
        }

        public final boolean d() {
            try {
                Context context = this.f7591b;
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e10) {
                zzc.zzo("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e10);
                return false;
            }
        }
    }

    public static a h(Context context) {
        return new a(context, null);
    }

    public abstract void a(d3.a aVar, b bVar);

    public abstract void b(i iVar, j jVar);

    public abstract void c();

    public abstract void d(k kVar, g gVar);

    public abstract com.android.billingclient.api.a e(String str);

    public abstract boolean f();

    public abstract com.android.billingclient.api.a g(Activity activity, h hVar);

    public abstract void i(t tVar, q qVar);

    public abstract void j(w wVar, r rVar);

    public abstract com.android.billingclient.api.a k(Activity activity, l lVar, m mVar);

    public abstract void l(e eVar);
}
