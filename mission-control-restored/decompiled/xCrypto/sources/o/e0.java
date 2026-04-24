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
import g.AbstractC1250c;
import g.AbstractC1252e;
import g.AbstractC1253f;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f13840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f13841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f13842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f13843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f13844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f13845g;

    public e0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f13842d = layoutParams;
        this.f13843e = new Rect();
        this.f13844f = new int[2];
        this.f13845g = new int[2];
        this.f13839a = context;
        View viewInflate = LayoutInflater.from(context).inflate(AbstractC1253f.f11664m, (ViewGroup) null);
        this.f13840b = viewInflate;
        this.f13841c = (TextView) viewInflate.findViewById(AbstractC1252e.f11638m);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.h.f11677a;
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

    public final void a(View view, int i4, int i5, boolean z4, WindowManager.LayoutParams layoutParams) {
        int height;
        int i6;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f13839a.getResources().getDimensionPixelOffset(AbstractC1250c.f11575h);
        if (view.getWidth() < dimensionPixelOffset) {
            i4 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f13839a.getResources().getDimensionPixelOffset(AbstractC1250c.f11574g);
            height = i5 + dimensionPixelOffset2;
            i6 = i5 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i6 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f13839a.getResources().getDimensionPixelOffset(z4 ? AbstractC1250c.f11577j : AbstractC1250c.f11576i);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f13843e);
        Rect rect = this.f13843e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f13839a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f13843e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f13845g);
        view.getLocationOnScreen(this.f13844f);
        int[] iArr = this.f13844f;
        int i7 = iArr[0];
        int[] iArr2 = this.f13845g;
        int i8 = i7 - iArr2[0];
        iArr[0] = i8;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i8 + i4) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f13840b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f13840b.getMeasuredHeight();
        int i9 = this.f13844f[1];
        int i10 = ((i6 + i9) - dimensionPixelOffset3) - measuredHeight;
        int i11 = i9 + height + dimensionPixelOffset3;
        if (z4) {
            if (i10 >= 0) {
                layoutParams.y = i10;
                return;
            } else {
                layoutParams.y = i11;
                return;
            }
        }
        if (measuredHeight + i11 <= this.f13843e.height()) {
            layoutParams.y = i11;
        } else {
            layoutParams.y = i10;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f13839a.getSystemService("window")).removeView(this.f13840b);
        }
    }

    public boolean d() {
        return this.f13840b.getParent() != null;
    }

    public void e(View view, int i4, int i5, boolean z4, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f13841c.setText(charSequence);
        a(view, i4, i5, z4, this.f13842d);
        ((WindowManager) this.f13839a.getSystemService("window")).addView(this.f13840b, this.f13842d);
    }
}
