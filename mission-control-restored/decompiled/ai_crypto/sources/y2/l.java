package y2;

import Q.F;
import Q.N;
import Q.W;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f25634a;

        public a(View view) {
            this.f25634a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f25634a.getContext().getSystemService("input_method")).showSoftInput(this.f25634a, 1);
        }
    }

    public class b implements F {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f25635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f25636b;

        public b(d dVar, e eVar) {
            this.f25635a = dVar;
            this.f25636b = eVar;
        }

        @Override // Q.F
        public W a(View view, W w7) {
            return this.f25635a.a(view, w7, new e(this.f25636b));
        }
    }

    public interface d {
        W a(View view, W w7, e eVar);
    }

    public static void a(View view, d dVar) {
        N.z0(view, new b(dVar, new e(N.E(view), view.getPaddingTop(), N.D(view), view.getPaddingBottom())));
        g(view);
    }

    public static float b(Context context, int i7) {
        return TypedValue.applyDimension(1, i7, context.getResources().getDisplayMetrics());
    }

    public static Integer c(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    public static float d(View view) {
        float fU = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fU += N.u((View) parent);
        }
        return fU;
    }

    public static boolean e(View view) {
        return N.z(view) == 1;
    }

    public static PorterDuff.Mode f(int i7, PorterDuff.Mode mode) {
        if (i7 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i7 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i7 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i7) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void g(View view) {
        if (N.O(view)) {
            N.i0(view);
        } else {
            view.addOnAttachStateChangeListener(new c());
        }
    }

    public static void h(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f25638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f25640d;

        public e(int i7, int i8, int i9, int i10) {
            this.f25637a = i7;
            this.f25638b = i8;
            this.f25639c = i9;
            this.f25640d = i10;
        }

        public e(e eVar) {
            this.f25637a = eVar.f25637a;
            this.f25638b = eVar.f25638b;
            this.f25639c = eVar.f25639c;
            this.f25640d = eVar.f25640d;
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            N.i0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
