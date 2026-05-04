package u9;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import u9.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v9.c f22446a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements o.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.c f22447a;

        public a(v9.c cVar) {
            this.f22447a = cVar;
        }

        @Override // u9.o.e
        public boolean a(Object obj) {
            return true;
        }

        @Override // u9.o.e
        public void b(View view, Object obj) {
            if (this.f22447a.d() != null) {
                this.f22447a.d().onClick(view);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends o {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ WindowManager.LayoutParams f22449o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ WindowManager f22450p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ v9.c f22451q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, Object obj, o.e eVar, WindowManager.LayoutParams layoutParams, WindowManager windowManager, v9.c cVar) {
            super(view, obj, eVar);
            this.f22449o = layoutParams;
            this.f22450p = windowManager;
            this.f22451q = cVar;
        }

        @Override // u9.o
        public float f() {
            return this.f22449o.x;
        }

        @Override // u9.o
        public void i(float f10) {
            this.f22449o.x = (int) f10;
            this.f22450p.updateViewLayout(this.f22451q.f(), this.f22449o);
        }
    }

    public void a(Activity activity) {
        if (h()) {
            g(activity).removeViewImmediate(this.f22446a.f());
            this.f22446a = null;
        }
    }

    public final Point b(Activity activity) {
        Point point = new Point();
        g(activity).getDefaultDisplay().getRealSize(point);
        return point;
    }

    public final Rect c(Activity activity) {
        Rect rect = new Rect();
        Rect rectF = f(activity);
        Point pointB = b(activity);
        rect.top = rectF.top;
        rect.left = rectF.left;
        rect.right = pointB.x - rectF.right;
        rect.bottom = pointB.y - rectF.bottom;
        return rect;
    }

    public final WindowManager.LayoutParams d(k kVar, Activity activity) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(kVar.A().intValue(), kVar.z().intValue(), 1003, kVar.y().intValue(), -3);
        Rect rectC = c(activity);
        if ((kVar.x().intValue() & 48) == 48) {
            layoutParams.y = rectC.top;
        }
        layoutParams.dimAmount = 0.3f;
        layoutParams.gravity = kVar.x().intValue();
        layoutParams.windowAnimations = 0;
        return layoutParams;
    }

    public final o e(k kVar, v9.c cVar, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        a aVar = new a(cVar);
        return kVar.A().intValue() == -1 ? new o(cVar.c(), null, aVar) : new b(cVar.c(), null, aVar, layoutParams, windowManager, cVar);
    }

    public final Rect f(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    public final WindowManager g(Activity activity) {
        return (WindowManager) activity.getSystemService("window");
    }

    public boolean h() {
        v9.c cVar = this.f22446a;
        if (cVar == null) {
            return false;
        }
        return cVar.f().isShown();
    }

    public void i(v9.c cVar, Activity activity) {
        if (h()) {
            l.e("Fiam already active. Cannot show new Fiam.");
            return;
        }
        if (activity.isFinishing() || activity.isDestroyed()) {
            l.e("Activity is finishing or does not have valid window token. Cannot show FIAM.");
            return;
        }
        k kVarB = cVar.b();
        WindowManager.LayoutParams layoutParamsD = d(kVarB, activity);
        WindowManager windowManagerG = g(activity);
        windowManagerG.addView(cVar.f(), layoutParamsD);
        Rect rectC = c(activity);
        l.d("Inset (top, bottom)", rectC.top, rectC.bottom);
        l.d("Inset (left, right)", rectC.left, rectC.right);
        if (cVar.a()) {
            cVar.c().setOnTouchListener(e(kVarB, cVar, windowManagerG, layoutParamsD));
        }
        this.f22446a = cVar;
    }
}
