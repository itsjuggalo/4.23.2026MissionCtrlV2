package o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f17357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f17358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f17359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f17360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f17361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f17362g;

    public r0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f17359d = layoutParams;
        this.f17360e = new Rect();
        this.f17361f = new int[2];
        this.f17362g = new int[2];
        this.f17356a = context;
        View viewInflate = LayoutInflater.from(context).inflate(g.f.f9746k, (ViewGroup) null);
        this.f17357b = viewInflate;
        this.f17358c = (TextView) viewInflate.findViewById(g.e.f9729l);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.h.f9760a;
        layoutParams.flags = 24;
    }

    public static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if (!(layoutParams instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams).type != 2) {
            for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    return ((Activity) context).getWindow().getDecorView();
                }
            }
        }
        return rootView;
    }

    public final void a(View view, int i10, int i11, boolean z10, WindowManager.LayoutParams layoutParams) {
        int height;
        int i12;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f17356a.getResources().getDimensionPixelOffset(g.c.f9689g);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f17356a.getResources().getDimensionPixelOffset(g.c.f9688f);
            height = i11 + dimensionPixelOffset2;
            i12 = i11 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i12 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f17356a.getResources().getDimensionPixelOffset(z10 ? g.c.f9691i : g.c.f9690h);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f17360e);
        Rect rect = this.f17360e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f17356a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f17360e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f17362g);
        view.getLocationOnScreen(this.f17361f);
        int[] iArr = this.f17361f;
        int i13 = iArr[0];
        int[] iArr2 = this.f17362g;
        int i14 = i13 - iArr2[0];
        iArr[0] = i14;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i14 + i10) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f17357b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f17357b.getMeasuredHeight();
        int i15 = this.f17361f[1];
        int i16 = ((i12 + i15) - dimensionPixelOffset3) - measuredHeight;
        int i17 = i15 + height + dimensionPixelOffset3;
        if (z10) {
            if (i16 >= 0) {
                layoutParams.y = i16;
                return;
            } else {
                layoutParams.y = i17;
                return;
            }
        }
        if (measuredHeight + i17 <= this.f17360e.height()) {
            layoutParams.y = i17;
        } else {
            layoutParams.y = i16;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f17356a.getSystemService("window")).removeView(this.f17357b);
        }
    }

    public boolean d() {
        return this.f17357b.getParent() != null;
    }

    public void e(View view, int i10, int i11, boolean z10, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f17358c.setText(charSequence);
        a(view, i10, i11, z10, this.f17359d);
        ((WindowManager) this.f17356a.getSystemService("window")).addView(this.f17357b, this.f17359d);
    }
}
