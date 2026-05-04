package s9;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.FiamListener;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import q9.q;
import q9.r;
import t.c;
import u9.c;
import u9.e;
import u9.i;
import u9.j;
import u9.k;
import u9.l;
import u9.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f20113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f20114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u9.e f20115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f20116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f20117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u9.g f20118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u9.a f20119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Application f20120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u9.c f20121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FiamListener f20122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ea.i f20123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f20124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f20125m;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v9.c f20127b;

        public a(Activity activity, v9.c cVar) {
            this.f20126a = activity;
            this.f20127b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.w(this.f20126a, this.f20127b);
        }
    }

    /* JADX INFO: renamed from: s9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class ViewOnClickListenerC0353b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f20129a;

        public ViewOnClickListenerC0353b(Activity activity) {
            this.f20129a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f20124l != null) {
                b.this.f20124l.a(r.a.CLICK);
            }
            b.this.s(this.f20129a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ea.a f20131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f20132b;

        public c(ea.a aVar, Activity activity) {
            this.f20131a = aVar;
            this.f20132b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f20124l != null) {
                l.f("Calling callback for click action");
                b.this.f20124l.b(this.f20131a);
            }
            b.this.z(this.f20132b, Uri.parse(this.f20131a.b()));
            b.this.B();
            b.this.E(this.f20132b);
            b.this.r();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends e.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ v9.c f20134e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Activity f20135f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f20136g;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements View.OnTouchListener {
            public a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                if (b.this.f20124l != null) {
                    b.this.f20124l.a(r.a.UNKNOWN_DISMISS_TYPE);
                }
                d dVar = d.this;
                b.this.s(dVar.f20135f);
                return true;
            }
        }

        /* JADX INFO: renamed from: s9.b$d$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0354b implements m.b {
            public C0354b() {
            }

            @Override // u9.m.b
            public void a() {
                if (b.this.f20123k == null || b.this.f20124l == null) {
                    return;
                }
                l.f("Impression timer onFinish for: " + b.this.f20123k.a().a());
                b.this.f20124l.d();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements m.b {
            public c() {
            }

            @Override // u9.m.b
            public void a() {
                if (b.this.f20123k != null && b.this.f20124l != null) {
                    b.this.f20124l.a(r.a.AUTO);
                }
                d dVar = d.this;
                b.this.s(dVar.f20135f);
            }
        }

        /* JADX INFO: renamed from: s9.b$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class RunnableC0355d implements Runnable {
            public RunnableC0355d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                u9.g gVar = b.this.f20118f;
                d dVar = d.this;
                gVar.i(dVar.f20134e, dVar.f20135f);
                if (d.this.f20134e.b().n().booleanValue()) {
                    b.this.f20121i.a(b.this.f20120h, d.this.f20134e.f(), c.EnumC0387c.TOP);
                }
            }
        }

        public d(v9.c cVar, Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.f20134e = cVar;
            this.f20135f = activity;
            this.f20136g = onGlobalLayoutListener;
        }

        @Override // u9.e.a
        public void l(Exception exc) {
            l.e("Image download failure ");
            if (this.f20136g != null) {
                this.f20134e.e().getViewTreeObserver().removeGlobalOnLayoutListener(this.f20136g);
            }
            b.this.q();
            b.this.r();
        }

        @Override // u9.e.a
        public void n() {
            if (!this.f20134e.b().p().booleanValue()) {
                this.f20134e.f().setOnTouchListener(new a());
            }
            b.this.f20116d.b(new C0354b(), 5000L, 1000L);
            if (this.f20134e.b().o().booleanValue()) {
                b.this.f20117e.b(new c(), 20000L, 1000L);
            }
            this.f20135f.runOnUiThread(new RunnableC0355d());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20142a;

        static {
            int[] iArr = new int[MessageType.values().length];
            f20142a = iArr;
            try {
                iArr[MessageType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20142a[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20142a[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20142a[MessageType.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b(q qVar, Map map, u9.e eVar, m mVar, m mVar2, u9.g gVar, Application application, u9.a aVar, u9.c cVar) {
        this.f20113a = qVar;
        this.f20114b = map;
        this.f20115c = eVar;
        this.f20116d = mVar;
        this.f20117e = mVar2;
        this.f20118f = gVar;
        this.f20120h = application;
        this.f20119g = aVar;
        this.f20121i = cVar;
    }

    public static /* synthetic */ void a(b bVar, Activity activity, ea.i iVar, r rVar) {
        if (bVar.f20123k != null || bVar.f20113a.c()) {
            l.a("Active FIAM exists. Skipping trigger");
        } else {
            bVar.F(iVar, rVar);
            bVar.G(activity);
        }
    }

    public static int v(Application application) {
        return application.getResources().getConfiguration().orientation;
    }

    public final void A(Activity activity, v9.c cVar, ea.g gVar, e.a aVar) {
        if (x(gVar)) {
            this.f20115c.c(gVar.b()).a(new j(this.f20123k, this.f20124l)).e(activity.getClass()).d(s9.e.f20153a).c(cVar.e(), aVar);
        } else {
            aVar.n();
        }
    }

    public final void B() {
        FiamListener fiamListener = this.f20122j;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    public final void C() {
        FiamListener fiamListener = this.f20122j;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    public final void D() {
        FiamListener fiamListener = this.f20122j;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    public final void E(Activity activity) {
        if (this.f20118f.h()) {
            this.f20115c.b(activity.getClass());
            this.f20118f.a(activity);
            q();
        }
    }

    public final void F(ea.i iVar, r rVar) {
        this.f20123k = iVar;
        this.f20124l = rVar;
    }

    public final void G(Activity activity) {
        v9.c cVarA;
        if (this.f20123k == null || this.f20113a.c()) {
            l.e("No active message found to render");
            return;
        }
        if (this.f20123k.c().equals(MessageType.UNSUPPORTED)) {
            l.e("The message being triggered is not supported by this version of the sdk.");
            return;
        }
        D();
        k kVar = (k) ((bd.a) this.f20114b.get(x9.g.a(this.f20123k.c(), v(this.f20120h)))).get();
        int i10 = e.f20142a[this.f20123k.c().ordinal()];
        if (i10 == 1) {
            cVarA = this.f20119g.a(kVar, this.f20123k);
        } else if (i10 == 2) {
            cVarA = this.f20119g.d(kVar, this.f20123k);
        } else if (i10 == 3) {
            cVarA = this.f20119g.c(kVar, this.f20123k);
        } else {
            if (i10 != 4) {
                l.e("No bindings found for this message type");
                return;
            }
            cVarA = this.f20119g.b(kVar, this.f20123k);
        }
        activity.findViewById(R.id.content).post(new a(activity, cVarA));
    }

    public final boolean H(Activity activity) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intent.setPackage("com.android.chrome");
        List<ResolveInfo> listQueryIntentServices = activity.getPackageManager().queryIntentServices(intent, 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    public final void I(Activity activity) {
        String str = this.f20125m;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            return;
        }
        l.f("Unbinding from activity: " + activity.getLocalClassName());
        this.f20113a.d();
        E(activity);
        this.f20125m = null;
    }

    @Override // u9.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        I(activity);
        this.f20113a.e();
        super.onActivityPaused(activity);
    }

    @Override // u9.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        p(activity);
    }

    public final void p(final Activity activity) {
        String str = this.f20125m;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            l.f("Binding to activity: " + activity.getLocalClassName());
            this.f20113a.f(new FirebaseInAppMessagingDisplay() { // from class: s9.a
                @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
                public final void displayMessage(ea.i iVar, r rVar) {
                    b.a(this.f20111a, activity, iVar, rVar);
                }
            });
            this.f20125m = activity.getLocalClassName();
        }
        if (this.f20123k != null) {
            G(activity);
        }
    }

    public final void q() {
        this.f20116d.a();
        this.f20117e.a();
    }

    public final void r() {
        F(null, null);
    }

    public final void s(Activity activity) {
        l.a("Dismissing fiam");
        C();
        E(activity);
        r();
    }

    public final List t(ea.i iVar) {
        ArrayList arrayList = new ArrayList();
        int i10 = e.f20142a[iVar.c().ordinal()];
        if (i10 == 1) {
            arrayList.add(((ea.c) iVar).e());
            return arrayList;
        }
        if (i10 == 2) {
            arrayList.add(((ea.j) iVar).e());
            return arrayList;
        }
        if (i10 == 3) {
            arrayList.add(((ea.h) iVar).e());
            return arrayList;
        }
        if (i10 != 4) {
            arrayList.add(ea.a.a().a());
            return arrayList;
        }
        ea.f fVar = (ea.f) iVar;
        arrayList.add(fVar.i());
        arrayList.add(fVar.j());
        return arrayList;
    }

    public final ea.g u(ea.i iVar) {
        if (iVar.c() != MessageType.CARD) {
            return iVar.b();
        }
        ea.f fVar = (ea.f) iVar;
        ea.g gVarH = fVar.h();
        ea.g gVarG = fVar.g();
        return (v(this.f20120h) != 1 ? !x(gVarG) : x(gVarH)) ? gVarH : gVarG;
    }

    public final void w(Activity activity, v9.c cVar) {
        View.OnClickListener cVar2;
        if (this.f20123k == null) {
            return;
        }
        ViewOnClickListenerC0353b viewOnClickListenerC0353b = new ViewOnClickListenerC0353b(activity);
        HashMap map = new HashMap();
        for (ea.a aVar : t(this.f20123k)) {
            if (aVar == null || TextUtils.isEmpty(aVar.b())) {
                l.f("No action url found for action. Treating as dismiss.");
                cVar2 = viewOnClickListenerC0353b;
            } else {
                cVar2 = new c(aVar, activity);
            }
            map.put(aVar, cVar2);
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerG = cVar.g(map, viewOnClickListenerC0353b);
        if (onGlobalLayoutListenerG != null) {
            cVar.e().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListenerG);
        }
        A(activity, cVar, u(this.f20123k), new d(cVar, activity, onGlobalLayoutListenerG));
    }

    public final boolean x(ea.g gVar) {
        return (gVar == null || TextUtils.isEmpty(gVar.b())) ? false : true;
    }

    public final boolean y(Uri uri) {
        String scheme;
        return (uri == null || (scheme = uri.getScheme()) == null || (!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https"))) ? false : true;
    }

    public final void z(Activity activity, Uri uri) {
        if (y(uri) && H(activity)) {
            t.c cVarA = new c.d().a();
            Intent intent = cVarA.f20444a;
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            cVarA.a(activity, uri);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", uri);
        ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intent2, 0);
        intent2.addFlags(1073741824);
        intent2.addFlags(268435456);
        if (resolveInfoResolveActivity != null) {
            activity.startActivity(intent2);
        } else {
            l.e("Device cannot resolve intent for: android.intent.action.VIEW");
        }
    }
}
