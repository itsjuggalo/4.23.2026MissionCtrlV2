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
import g.AbstractC1766c;
import g.AbstractC1768e;
import g.AbstractC1769f;

/* JADX INFO: loaded from: classes.dex */
public class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f21795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f21796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f21797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f21798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f21799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f21800g;

    public U(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f21797d = layoutParams;
        this.f21798e = new Rect();
        this.f21799f = new int[2];
        this.f21800g = new int[2];
        this.f21794a = context;
        View viewInflate = LayoutInflater.from(context).inflate(AbstractC1769f.f17756k, (ViewGroup) null);
        this.f21795b = viewInflate;
        this.f21796c = (TextView) viewInflate.findViewById(AbstractC1768e.f17739l);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.h.f17770a;
        layoutParams.flags = 24;
    }

    public static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public final void a(View view, int i8, int i9, boolean z7, WindowManager.LayoutParams layoutParams) {
        int height;
        int i10;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f21794a.getResources().getDimensionPixelOffset(AbstractC1766c.f17680g);
        if (view.getWidth() < dimensionPixelOffset) {
            i8 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f21794a.getResources().getDimensionPixelOffset(AbstractC1766c.f17679f);
            height = i9 + dimensionPixelOffset2;
            i10 = i9 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i10 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f21794a.getResources().getDimensionPixelOffset(z7 ? AbstractC1766c.f17682i : AbstractC1766c.f17681h);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f21798e);
        Rect rect = this.f21798e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f21794a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f21798e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f21800g);
        view.getLocationOnScreen(this.f21799f);
        int[] iArr = this.f21799f;
        int i11 = iArr[0];
        int[] iArr2 = this.f21800g;
        int i12 = i11 - iArr2[0];
        iArr[0] = i12;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i12 + i8) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f21795b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f21795b.getMeasuredHeight();
        int i13 = this.f21799f[1];
        int i14 = ((i10 + i13) - dimensionPixelOffset3) - measuredHeight;
        int i15 = i13 + height + dimensionPixelOffset3;
        if (!z7 ? measuredHeight + i15 <= this.f21798e.height() : i14 < 0) {
            layoutParams.y = i14;
        } else {
            layoutParams.y = i15;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f21794a.getSystemService("window")).removeView(this.f21795b);
        }
    }

    public boolean d() {
        return this.f21795b.getParent() != null;
    }

    public void e(View view, int i8, int i9, boolean z7, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f21796c.setText(charSequence);
        a(view, i8, i9, z7, this.f21797d);
        ((WindowManager) this.f21794a.getSystemService("window")).addView(this.f21795b, this.f21797d);
    }
}
