package H3;

import H3.o;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public I3.c f3680a;

    public class a implements o.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I3.c f3681a;

        public a(I3.c cVar) {
            this.f3681a = cVar;
        }

        @Override // H3.o.e
        public boolean a(Object obj) {
            return true;
        }

        @Override // H3.o.e
        public void b(View view, Object obj) {
            if (this.f3681a.d() != null) {
                this.f3681a.d().onClick(view);
            }
        }
    }

    public class b extends o {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ WindowManager.LayoutParams f3683o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ WindowManager f3684p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ I3.c f3685q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, Object obj, o.e eVar, WindowManager.LayoutParams layoutParams, WindowManager windowManager, I3.c cVar) {
            super(view, obj, eVar);
            this.f3683o = layoutParams;
            this.f3684p = windowManager;
            this.f3685q = cVar;
        }

        @Override // H3.o
        public float f() {
            return this.f3683o.x;
        }

        @Override // H3.o
        public void i(float f8) {
            this.f3683o.x = (int) f8;
            this.f3684p.updateViewLayout(this.f3685q.f(), this.f3683o);
        }
    }

    public void a(Activity activity) {
        if (h()) {
            g(activity).removeViewImmediate(this.f3680a.f());
            this.f3680a = null;
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

    public final o e(k kVar, I3.c cVar, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
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
        I3.c cVar = this.f3680a;
        if (cVar == null) {
            return false;
        }
        return cVar.f().isShown();
    }

    public void i(I3.c cVar, Activity activity) {
        String str;
        if (h()) {
            str = "Fiam already active. Cannot show new Fiam.";
        } else {
            if (!activity.isFinishing() && !activity.isDestroyed()) {
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
                this.f3680a = cVar;
                return;
            }
            str = "Activity is finishing or does not have valid window token. Cannot show FIAM.";
        }
        l.e(str);
    }
}
