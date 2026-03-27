package p;

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
import h.AbstractC1658c;
import h.AbstractC1660e;
import h.AbstractC1661f;
import h.AbstractC1663h;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f21332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f21333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowManager.LayoutParams f21334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f21335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f21336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f21337g;

    public a0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f21334d = layoutParams;
        this.f21335e = new Rect();
        this.f21336f = new int[2];
        this.f21337g = new int[2];
        this.f21331a = context;
        View viewInflate = LayoutInflater.from(context).inflate(AbstractC1661f.f14459m, (ViewGroup) null);
        this.f21332b = viewInflate;
        this.f21333c = (TextView) viewInflate.findViewById(AbstractC1660e.f14433m);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = AbstractC1663h.f14474a;
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

    public final void a(View view, int i7, int i8, boolean z7, WindowManager.LayoutParams layoutParams) {
        int height;
        int i9;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f21331a.getResources().getDimensionPixelOffset(AbstractC1658c.f14371k);
        if (view.getWidth() < dimensionPixelOffset) {
            i7 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f21331a.getResources().getDimensionPixelOffset(AbstractC1658c.f14370j);
            height = i8 + dimensionPixelOffset2;
            i9 = i8 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i9 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f21331a.getResources().getDimensionPixelOffset(z7 ? AbstractC1658c.f14373m : AbstractC1658c.f14372l);
        View viewB = b(view);
        if (viewB == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f21335e);
        Rect rect = this.f21335e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f21331a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f21335e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f21337g);
        view.getLocationOnScreen(this.f21336f);
        int[] iArr = this.f21336f;
        int i10 = iArr[0];
        int[] iArr2 = this.f21337g;
        int i11 = i10 - iArr2[0];
        iArr[0] = i11;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i11 + i7) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f21332b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f21332b.getMeasuredHeight();
        int i12 = this.f21336f[1];
        int i13 = ((i9 + i12) - dimensionPixelOffset3) - measuredHeight;
        int i14 = i12 + height + dimensionPixelOffset3;
        if (z7) {
            if (i13 >= 0) {
                layoutParams.y = i13;
                return;
            } else {
                layoutParams.y = i14;
                return;
            }
        }
        if (measuredHeight + i14 <= this.f21335e.height()) {
            layoutParams.y = i14;
        } else {
            layoutParams.y = i13;
        }
    }

    public void c() {
        if (d()) {
            ((WindowManager) this.f21331a.getSystemService("window")).removeView(this.f21332b);
        }
    }

    public boolean d() {
        return this.f21332b.getParent() != null;
    }

    public void e(View view, int i7, int i8, boolean z7, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f21333c.setText(charSequence);
        a(view, i7, i8, z7, this.f21334d);
        ((WindowManager) this.f21331a.getSystemService("window")).addView(this.f21332b, this.f21334d);
    }
}
