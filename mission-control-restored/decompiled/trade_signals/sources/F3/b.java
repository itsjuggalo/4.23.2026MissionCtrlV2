package F3;

import D3.q;
import D3.r;
import H3.c;
import H3.e;
import H3.i;
import H3.j;
import H3.k;
import H3.l;
import H3.m;
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
import n5.InterfaceC2426a;
import t.C2729c;

/* JADX INFO: loaded from: classes.dex */
public class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f1526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f1527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H3.e f1528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f1529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f1530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final H3.g f1531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final H3.a f1532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Application f1533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final H3.c f1534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FiamListener f1535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public R3.i f1536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f1537l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f1538m;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f1539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ I3.c f1540b;

        public a(Activity activity, I3.c cVar) {
            this.f1539a = activity;
            this.f1540b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.w(this.f1539a, this.f1540b);
        }
    }

    /* JADX INFO: renamed from: F3.b$b, reason: collision with other inner class name */
    public class ViewOnClickListenerC0022b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f1542a;

        public ViewOnClickListenerC0022b(Activity activity) {
            this.f1542a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f1537l != null) {
                b.this.f1537l.c(r.a.CLICK);
            }
            b.this.s(this.f1542a);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ R3.a f1544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f1545b;

        public c(R3.a aVar, Activity activity) {
            this.f1544a = aVar;
            this.f1545b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f1537l != null) {
                l.f("Calling callback for click action");
                b.this.f1537l.b(this.f1544a);
            }
            b.this.A(this.f1545b, Uri.parse(this.f1544a.b()));
            b.this.C();
            b.this.F(this.f1545b);
            b.this.r();
        }
    }

    public class d extends e.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ I3.c f1547e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Activity f1548f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1549g;

        public class a implements View.OnTouchListener {
            public a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                if (b.this.f1537l != null) {
                    b.this.f1537l.c(r.a.UNKNOWN_DISMISS_TYPE);
                }
                d dVar = d.this;
                b.this.s(dVar.f1548f);
                return true;
            }
        }

        /* JADX INFO: renamed from: F3.b$d$b, reason: collision with other inner class name */
        public class C0023b implements m.b {
            public C0023b() {
            }

            @Override // H3.m.b
            public void a() {
                if (b.this.f1536k == null || b.this.f1537l == null) {
                    return;
                }
                l.f("Impression timer onFinish for: " + b.this.f1536k.a().a());
                b.this.f1537l.d();
            }
        }

        public class c implements m.b {
            public c() {
            }

            @Override // H3.m.b
            public void a() {
                if (b.this.f1536k != null && b.this.f1537l != null) {
                    b.this.f1537l.c(r.a.AUTO);
                }
                d dVar = d.this;
                b.this.s(dVar.f1548f);
            }
        }

        /* JADX INFO: renamed from: F3.b$d$d, reason: collision with other inner class name */
        public class RunnableC0024d implements Runnable {
            public RunnableC0024d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                H3.g gVar = b.this.f1531f;
                d dVar = d.this;
                gVar.i(dVar.f1547e, dVar.f1548f);
                if (d.this.f1547e.b().n().booleanValue()) {
                    b.this.f1534i.a(b.this.f1533h, d.this.f1547e.f(), c.EnumC0046c.TOP);
                }
            }
        }

        public d(I3.c cVar, Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            this.f1547e = cVar;
            this.f1548f = activity;
            this.f1549g = onGlobalLayoutListener;
        }

        @Override // H3.e.a
        public void l(Exception exc) {
            l.e("Image download failure ");
            if (this.f1549g != null) {
                this.f1547e.e().getViewTreeObserver().removeGlobalOnLayoutListener(this.f1549g);
            }
            b.this.q();
            b.this.r();
        }

        @Override // H3.e.a
        public void n() {
            if (!this.f1547e.b().p().booleanValue()) {
                this.f1547e.f().setOnTouchListener(new a());
            }
            b.this.f1529d.b(new C0023b(), 5000L, 1000L);
            if (this.f1547e.b().o().booleanValue()) {
                b.this.f1530e.b(new c(), 20000L, 1000L);
            }
            this.f1548f.runOnUiThread(new RunnableC0024d());
        }
    }

    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1555a;

        static {
            int[] iArr = new int[MessageType.values().length];
            f1555a = iArr;
            try {
                iArr[MessageType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1555a[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1555a[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1555a[MessageType.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b(q qVar, Map map, H3.e eVar, m mVar, m mVar2, H3.g gVar, Application application, H3.a aVar, H3.c cVar) {
        this.f1526a = qVar;
        this.f1527b = map;
        this.f1528c = eVar;
        this.f1529d = mVar;
        this.f1530e = mVar2;
        this.f1531f = gVar;
        this.f1533h = application;
        this.f1532g = aVar;
        this.f1534i = cVar;
    }

    public static int v(Application application) {
        return application.getResources().getConfiguration().orientation;
    }

    public final void A(Activity activity, Uri uri) {
        if (y(uri) && I(activity)) {
            C2729c c2729cA = new C2729c.d().a();
            Intent intent = c2729cA.f23275a;
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            c2729cA.a(activity, uri);
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

    public final void B(Activity activity, I3.c cVar, R3.g gVar, e.a aVar) {
        if (x(gVar)) {
            this.f1528c.c(gVar.b()).a(new j(this.f1536k, this.f1537l)).e(activity.getClass()).d(F3.e.f1566a).c(cVar.e(), aVar);
        } else {
            aVar.n();
        }
    }

    public final void C() {
        FiamListener fiamListener = this.f1535j;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    public final void D() {
        FiamListener fiamListener = this.f1535j;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    public final void E() {
        FiamListener fiamListener = this.f1535j;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    public final void F(Activity activity) {
        if (this.f1531f.h()) {
            this.f1528c.b(activity.getClass());
            this.f1531f.a(activity);
            q();
        }
    }

    public final void G(R3.i iVar, r rVar) {
        this.f1536k = iVar;
        this.f1537l = rVar;
    }

    public final void H(Activity activity) {
        I3.c cVarA;
        if (this.f1536k == null || this.f1526a.c()) {
            l.e("No active message found to render");
            return;
        }
        if (this.f1536k.c().equals(MessageType.UNSUPPORTED)) {
            l.e("The message being triggered is not supported by this version of the sdk.");
            return;
        }
        E();
        k kVar = (k) ((InterfaceC2426a) this.f1527b.get(K3.g.a(this.f1536k.c(), v(this.f1533h)))).get();
        int i8 = e.f1555a[this.f1536k.c().ordinal()];
        if (i8 == 1) {
            cVarA = this.f1532g.a(kVar, this.f1536k);
        } else if (i8 == 2) {
            cVarA = this.f1532g.d(kVar, this.f1536k);
        } else if (i8 == 3) {
            cVarA = this.f1532g.c(kVar, this.f1536k);
        } else {
            if (i8 != 4) {
                l.e("No bindings found for this message type");
                return;
            }
            cVarA = this.f1532g.b(kVar, this.f1536k);
        }
        activity.findViewById(R.id.content).post(new a(activity, cVarA));
    }

    public final boolean I(Activity activity) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intent.setPackage("com.android.chrome");
        List<ResolveInfo> listQueryIntentServices = activity.getPackageManager().queryIntentServices(intent, 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    public final void J(Activity activity) {
        String str = this.f1538m;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            return;
        }
        l.f("Unbinding from activity: " + activity.getLocalClassName());
        this.f1526a.d();
        F(activity);
        this.f1538m = null;
    }

    @Override // H3.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        J(activity);
        this.f1526a.f();
        super.onActivityPaused(activity);
    }

    @Override // H3.i, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        p(activity);
    }

    public final void p(final Activity activity) {
        String str = this.f1538m;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            l.f("Binding to activity: " + activity.getLocalClassName());
            this.f1526a.g(new FirebaseInAppMessagingDisplay() { // from class: F3.a
                @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
                public final void displayMessage(R3.i iVar, r rVar) {
                    this.f1524a.z(activity, iVar, rVar);
                }
            });
            this.f1538m = activity.getLocalClassName();
        }
        if (this.f1536k != null) {
            H(activity);
        }
    }

    public final void q() {
        this.f1529d.a();
        this.f1530e.a();
    }

    public final void r() {
        G(null, null);
    }

    public final void s(Activity activity) {
        l.a("Dismissing fiam");
        D();
        F(activity);
        r();
    }

    public final List t(R3.i iVar) {
        R3.a aVarE;
        ArrayList arrayList = new ArrayList();
        int i8 = e.f1555a[iVar.c().ordinal()];
        if (i8 == 1) {
            aVarE = ((R3.c) iVar).e();
        } else if (i8 == 2) {
            aVarE = ((R3.j) iVar).e();
        } else if (i8 == 3) {
            aVarE = ((R3.h) iVar).e();
        } else if (i8 != 4) {
            aVarE = R3.a.a().a();
        } else {
            R3.f fVar = (R3.f) iVar;
            arrayList.add(fVar.i());
            aVarE = fVar.j();
        }
        arrayList.add(aVarE);
        return arrayList;
    }

    public final R3.g u(R3.i iVar) {
        if (iVar.c() != MessageType.CARD) {
            return iVar.b();
        }
        R3.f fVar = (R3.f) iVar;
        R3.g gVarH = fVar.h();
        R3.g gVarG = fVar.g();
        return v(this.f1533h) == 1 ? x(gVarH) ? gVarH : gVarG : x(gVarG) ? gVarG : gVarH;
    }

    public final void w(Activity activity, I3.c cVar) {
        View.OnClickListener cVar2;
        if (this.f1536k == null) {
            return;
        }
        ViewOnClickListenerC0022b viewOnClickListenerC0022b = new ViewOnClickListenerC0022b(activity);
        HashMap map = new HashMap();
        for (R3.a aVar : t(this.f1536k)) {
            if (aVar == null || TextUtils.isEmpty(aVar.b())) {
                l.f("No action url found for action. Treating as dismiss.");
                cVar2 = viewOnClickListenerC0022b;
            } else {
                cVar2 = new c(aVar, activity);
            }
            map.put(aVar, cVar2);
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerG = cVar.g(map, viewOnClickListenerC0022b);
        if (onGlobalLayoutListenerG != null) {
            cVar.e().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListenerG);
        }
        B(activity, cVar, u(this.f1536k), new d(cVar, activity, onGlobalLayoutListenerG));
    }

    public final boolean x(R3.g gVar) {
        return (gVar == null || TextUtils.isEmpty(gVar.b())) ? false : true;
    }

    public final boolean y(Uri uri) {
        String scheme;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https");
    }

    public final /* synthetic */ void z(Activity activity, R3.i iVar, r rVar) {
        if (this.f1536k != null || this.f1526a.c()) {
            l.a("Active FIAM exists. Skipping trigger");
        } else {
            G(iVar, rVar);
            H(activity);
        }
    }
}
