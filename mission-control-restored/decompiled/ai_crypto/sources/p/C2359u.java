package p;

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
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.api.a;
import h.AbstractC1664i;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: p.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2359u {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f21431l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ConcurrentHashMap f21432m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static ConcurrentHashMap f21433n = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21434a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21435b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21436c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21437d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f21438e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f21439f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21440g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f21441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f21442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f21443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f21444k;

    /* JADX INFO: renamed from: p.u$a */
    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i7, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i7, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        public static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    /* JADX INFO: renamed from: p.u$b */
    public static final class b {
        public static boolean a(View view) {
            return view.isInLayout();
        }
    }

    /* JADX INFO: renamed from: p.u$c */
    public static final class c {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i7, int i8, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i7);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i8 == -1) {
                i8 = a.e.API_PRIORITY_OTHER;
            }
            hyphenationFrequency.setMaxLines(i8);
            try {
                fVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* JADX INFO: renamed from: p.u$d */
    public static class d extends f {
        @Override // p.C2359u.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) C2359u.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: renamed from: p.u$e */
    public static class e extends d {
        @Override // p.C2359u.d, p.C2359u.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // p.C2359u.f
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: renamed from: p.u$f */
    public static class f {
        public abstract void a(StaticLayout.Builder builder, TextView textView);

        public boolean b(TextView textView) {
            return ((Boolean) C2359u.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public C2359u(TextView textView) {
        this.f21442i = textView;
        this.f21443j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f21444k = new e();
        } else {
            this.f21444k = new d();
        }
    }

    public static Method k(String str) {
        try {
            Method declaredMethod = (Method) f21432m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                f21432m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e7) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e7);
            return null;
        }
    }

    public static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e7) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e7);
            return obj2;
        }
    }

    public void a() {
        if (n()) {
            if (this.f21435b) {
                if (this.f21442i.getMeasuredHeight() <= 0 || this.f21442i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f21444k.b(this.f21442i) ? 1048576 : (this.f21442i.getMeasuredWidth() - this.f21442i.getTotalPaddingLeft()) - this.f21442i.getTotalPaddingRight();
                int height = (this.f21442i.getHeight() - this.f21442i.getCompoundPaddingBottom()) - this.f21442i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f21431l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f21442i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f21435b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            if (i7 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i7)) < 0) {
                arrayList.add(Integer.valueOf(i7));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i8 = 0; i8 < size; i8++) {
            iArr2[i8] = ((Integer) arrayList.get(i8)).intValue();
        }
        return iArr2;
    }

    public final void c() {
        this.f21434a = 0;
        this.f21437d = -1.0f;
        this.f21438e = -1.0f;
        this.f21436c = -1.0f;
        this.f21439f = new int[0];
        this.f21435b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i7, int i8) {
        return c.a(charSequence, alignment, i7, i8, this.f21442i, this.f21441h, this.f21444k);
    }

    public final int e(RectF rectF) {
        int length = this.f21439f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i7 = 1;
        int i8 = length - 1;
        int i9 = 0;
        while (i7 <= i8) {
            int i10 = (i7 + i8) / 2;
            if (x(this.f21439f[i10], rectF)) {
                int i11 = i10 + 1;
                i9 = i7;
                i7 = i11;
            } else {
                i9 = i10 - 1;
                i8 = i9;
            }
        }
        return this.f21439f[i9];
    }

    public int f() {
        return Math.round(this.f21438e);
    }

    public int g() {
        return Math.round(this.f21437d);
    }

    public int h() {
        return Math.round(this.f21436c);
    }

    public int[] i() {
        return this.f21439f;
    }

    public int j() {
        return this.f21434a;
    }

    public void l(int i7) {
        TextPaint textPaint = this.f21441h;
        if (textPaint == null) {
            this.f21441h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f21441h.set(this.f21442i.getPaint());
        this.f21441h.setTextSize(i7);
    }

    public boolean n() {
        return y() && this.f21434a != 0;
    }

    public void o(AttributeSet attributeSet, int i7) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f21443j.obtainStyledAttributes(attributeSet, AbstractC1664i.f14548S, i7, 0);
        TextView textView = this.f21442i;
        Q.N.j0(textView, textView.getContext(), AbstractC1664i.f14548S, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14568X)) {
            this.f21434a = typedArrayObtainStyledAttributes.getInt(AbstractC1664i.f14568X, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14564W) ? typedArrayObtainStyledAttributes.getDimension(AbstractC1664i.f14564W, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14556U) ? typedArrayObtainStyledAttributes.getDimension(AbstractC1664i.f14556U, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14552T) ? typedArrayObtainStyledAttributes.getDimension(AbstractC1664i.f14552T, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14560V) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC1664i.f14560V, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f21434a = 0;
            return;
        }
        if (this.f21434a == 1) {
            if (!this.f21440g) {
                DisplayMetrics displayMetrics = this.f21443j.getResources().getDisplayMetrics();
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

    public void p(int i7, int i8, int i9, int i10) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f21443j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i10, i7, displayMetrics), TypedValue.applyDimension(i10, i8, displayMetrics), TypedValue.applyDimension(i10, i9, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    public void q(int[] iArr, int i7) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i7 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f21443j.getResources().getDisplayMetrics();
                    for (int i8 = 0; i8 < length; i8++) {
                        iArrCopyOf[i8] = Math.round(TypedValue.applyDimension(i7, iArr[i8], displayMetrics));
                    }
                }
                this.f21439f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f21440g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    public void r(int i7) {
        if (y()) {
            if (i7 == 0) {
                c();
                return;
            }
            if (i7 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i7);
            }
            DisplayMetrics displayMetrics = this.f21443j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    public final void s(float f7) {
        if (f7 != this.f21442i.getPaint().getTextSize()) {
            this.f21442i.getPaint().setTextSize(f7);
            boolean zA = b.a(this.f21442i);
            if (this.f21442i.getLayout() != null) {
                this.f21435b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f21442i, null);
                    }
                } catch (Exception e7) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e7);
                }
                if (zA) {
                    this.f21442i.forceLayout();
                } else {
                    this.f21442i.requestLayout();
                }
                this.f21442i.invalidate();
            }
        }
    }

    public void t(int i7, float f7) {
        Context context = this.f21443j;
        s(TypedValue.applyDimension(i7, f7, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean u() {
        if (y() && this.f21434a == 1) {
            if (!this.f21440g || this.f21439f.length == 0) {
                int iFloor = ((int) Math.floor((this.f21438e - this.f21437d) / this.f21436c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i7 = 0; i7 < iFloor; i7++) {
                    iArr[i7] = Math.round(this.f21437d + (i7 * this.f21436c));
                }
                this.f21439f = b(iArr);
            }
            this.f21435b = true;
        } else {
            this.f21435b = false;
        }
        return this.f21435b;
    }

    public final void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = typedArray.getDimensionPixelSize(i7, -1);
            }
            this.f21439f = b(iArr);
            w();
        }
    }

    public final boolean w() {
        boolean z7 = this.f21439f.length > 0;
        this.f21440g = z7;
        if (z7) {
            this.f21434a = 1;
            this.f21437d = r0[0];
            this.f21438e = r0[r1 - 1];
            this.f21436c = -1.0f;
        }
        return z7;
    }

    public final boolean x(int i7, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f21442i.getText();
        TransformationMethod transformationMethod = this.f21442i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f21442i)) != null) {
            text = transformation;
        }
        int iB = a.b(this.f21442i);
        l(i7);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f21442i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB);
        return (iB == -1 || (staticLayoutD.getLineCount() <= iB && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    public final boolean y() {
        return !(this.f21442i instanceof AbstractC2348i);
    }

    public final void z(float f7, float f8, float f9) {
        if (f7 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f7 + "px) is less or equal to (0px)");
        }
        if (f8 <= f7) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f8 + "px) is less or equal to minimum auto-size text size (" + f7 + "px)");
        }
        if (f9 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f9 + "px) is less or equal to (0px)");
        }
        this.f21434a = 1;
        this.f21437d = f7;
        this.f21438e = f8;
        this.f21436c = f9;
        this.f21440g = false;
    }
}
