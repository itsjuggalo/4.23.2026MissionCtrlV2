package o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.google.android.gms.common.api.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f17330l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ConcurrentHashMap f17331m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17332a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17333b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f17334c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f17335d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f17336e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f17337f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17338g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f17339h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f17340i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f17341j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f17342k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = a.e.API_PRIORITY_OTHER;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends d {
        @Override // o.p.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) p.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends b {
        @Override // o.p.b, o.p.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // o.p.d
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
        public abstract void a(StaticLayout.Builder builder, TextView textView);

        public boolean b(TextView textView) {
            return ((Boolean) p.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public p(TextView textView) {
        this.f17340i = textView;
        this.f17341j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f17342k = new c();
        } else {
            this.f17342k = new b();
        }
    }

    public static Method k(String str) {
        try {
            Method declaredMethod = (Method) f17331m.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, null)) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            f17331m.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    public static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e10);
            return obj2;
        }
    }

    public void a() {
        if (n()) {
            if (this.f17333b) {
                if (this.f17340i.getMeasuredHeight() <= 0 || this.f17340i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f17342k.b(this.f17340i) ? 1048576 : (this.f17340i.getMeasuredWidth() - this.f17340i.getTotalPaddingLeft()) - this.f17340i.getTotalPaddingRight();
                int height = (this.f17340i.getHeight() - this.f17340i.getCompoundPaddingBottom()) - this.f17340i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f17330l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f17340i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f17333b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i10 : iArr) {
                if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i11 = 0; i11 < size; i11++) {
                    iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public final void c() {
        this.f17332a = 0;
        this.f17335d = -1.0f;
        this.f17336e = -1.0f;
        this.f17334c = -1.0f;
        this.f17337f = new int[0];
        this.f17333b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        return a.a(charSequence, alignment, i10, i11, this.f17340i, this.f17339h, this.f17342k);
    }

    public final int e(RectF rectF) {
        int length = this.f17337f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = 1;
        int i11 = length - 1;
        int i12 = 0;
        while (i10 <= i11) {
            int i13 = (i10 + i11) / 2;
            if (x(this.f17337f[i13], rectF)) {
                int i14 = i13 + 1;
                i12 = i10;
                i10 = i14;
            } else {
                i12 = i13 - 1;
                i11 = i12;
            }
        }
        return this.f17337f[i12];
    }

    public int f() {
        return Math.round(this.f17336e);
    }

    public int g() {
        return Math.round(this.f17335d);
    }

    public int h() {
        return Math.round(this.f17334c);
    }

    public int[] i() {
        return this.f17337f;
    }

    public int j() {
        return this.f17332a;
    }

    public void l(int i10) {
        TextPaint textPaint = this.f17339h;
        if (textPaint == null) {
            this.f17339h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f17339h.set(this.f17340i.getPaint());
        this.f17339h.setTextSize(i10);
    }

    public boolean n() {
        return y() && this.f17332a != 0;
    }

    public void o(AttributeSet attributeSet, int i10) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f17341j.obtainStyledAttributes(attributeSet, g.i.S, i10, 0);
        TextView textView = this.f17340i;
        t0.c0.I(textView, textView.getContext(), g.i.S, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        if (typedArrayObtainStyledAttributes.hasValue(g.i.X)) {
            this.f17332a = typedArrayObtainStyledAttributes.getInt(g.i.X, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(g.i.W) ? typedArrayObtainStyledAttributes.getDimension(g.i.W, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(g.i.U) ? typedArrayObtainStyledAttributes.getDimension(g.i.U, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(g.i.T) ? typedArrayObtainStyledAttributes.getDimension(g.i.T, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(g.i.V) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(g.i.V, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f17332a = 0;
            return;
        }
        if (this.f17332a == 1) {
            if (!this.f17338g) {
                DisplayMetrics displayMetrics = this.f17341j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                z(dimension2, dimension3, dimension);
            }
            u();
        }
    }

    public void p(int i10, int i11, int i12, int i13) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f17341j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    public void q(int[] iArr, int i10) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i10 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f17341j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArrCopyOf[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f17337f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f17338g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    public void r(int i10) {
        if (y()) {
            if (i10 == 0) {
                c();
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            DisplayMetrics displayMetrics = this.f17341j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    public final void s(float f10) {
        if (f10 != this.f17340i.getPaint().getTextSize()) {
            this.f17340i.getPaint().setTextSize(f10);
            boolean zIsInLayout = this.f17340i.isInLayout();
            if (this.f17340i.getLayout() != null) {
                this.f17333b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f17340i, null);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (zIsInLayout) {
                    this.f17340i.forceLayout();
                } else {
                    this.f17340i.requestLayout();
                }
                this.f17340i.invalidate();
            }
        }
    }

    public void t(int i10, float f10) {
        Context context = this.f17341j;
        s(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean u() {
        if (y() && this.f17332a == 1) {
            if (!this.f17338g || this.f17337f.length == 0) {
                int iFloor = ((int) Math.floor((this.f17336e - this.f17335d) / this.f17334c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i10 = 0; i10 < iFloor; i10++) {
                    iArr[i10] = Math.round(this.f17335d + (i10 * this.f17334c));
                }
                this.f17337f = b(iArr);
            }
            this.f17333b = true;
        } else {
            this.f17333b = false;
        }
        return this.f17333b;
    }

    public final void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f17337f = b(iArr);
            w();
        }
    }

    public final boolean w() {
        boolean z10 = this.f17337f.length > 0;
        this.f17338g = z10;
        if (z10) {
            this.f17332a = 1;
            this.f17335d = r0[0];
            this.f17336e = r0[r1 - 1];
            this.f17334c = -1.0f;
        }
        return z10;
    }

    public final boolean x(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f17340i.getText();
        TransformationMethod transformationMethod = this.f17340i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f17340i)) != null) {
            text = transformation;
        }
        int maxLines = this.f17340i.getMaxLines();
        l(i10);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f17340i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    public final boolean y() {
        return true;
    }

    public final void z(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f17332a = 1;
        this.f17335d = f10;
        this.f17336e = f11;
        this.f17334c = f12;
        this.f17338g = false;
    }
}
