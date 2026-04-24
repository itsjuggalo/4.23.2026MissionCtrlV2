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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: o.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2447p {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f21883l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ConcurrentHashMap f21884m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21885a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21886b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21887c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21888d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f21889e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f21890f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21891g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f21892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f21893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f21894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f21895k;

    /* JADX INFO: renamed from: o.p$a */
    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i8, int i9, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i8);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i9 == -1) {
                i9 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i9);
            try {
                dVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* JADX INFO: renamed from: o.p$b */
    public static class b extends d {
        @Override // o.C2447p.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) C2447p.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* JADX INFO: renamed from: o.p$c */
    public static class c extends b {
        @Override // o.C2447p.b, o.C2447p.d
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // o.C2447p.d
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* JADX INFO: renamed from: o.p$d */
    public static class d {
        public abstract void a(StaticLayout.Builder builder, TextView textView);

        public boolean b(TextView textView) {
            return ((Boolean) C2447p.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public C2447p(TextView textView) {
        this.f21893i = textView;
        this.f21894j = textView.getContext();
        this.f21895k = Build.VERSION.SDK_INT >= 29 ? new c() : new b();
    }

    public static Method k(String str) {
        try {
            Method declaredMethod = (Method) f21884m.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, null)) != null) {
                declaredMethod.setAccessible(true);
                f21884m.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e8) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e8);
            return null;
        }
    }

    public static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e8) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e8);
            return obj2;
        }
    }

    public void a() {
        if (n()) {
            if (this.f21886b) {
                if (this.f21893i.getMeasuredHeight() <= 0 || this.f21893i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f21895k.b(this.f21893i) ? 1048576 : (this.f21893i.getMeasuredWidth() - this.f21893i.getTotalPaddingLeft()) - this.f21893i.getTotalPaddingRight();
                int height = (this.f21893i.getHeight() - this.f21893i.getCompoundPaddingBottom()) - this.f21893i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f21883l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fE = e(rectF);
                        if (fE != this.f21893i.getTextSize()) {
                            t(0, fE);
                        }
                    } finally {
                    }
                }
            }
            this.f21886b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i8 : iArr) {
            if (i8 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i8)) < 0) {
                arrayList.add(Integer.valueOf(i8));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i9 = 0; i9 < size; i9++) {
            iArr2[i9] = ((Integer) arrayList.get(i9)).intValue();
        }
        return iArr2;
    }

    public final void c() {
        this.f21885a = 0;
        this.f21888d = -1.0f;
        this.f21889e = -1.0f;
        this.f21887c = -1.0f;
        this.f21890f = new int[0];
        this.f21886b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i8, int i9) {
        return a.a(charSequence, alignment, i8, i9, this.f21893i, this.f21892h, this.f21895k);
    }

    public final int e(RectF rectF) {
        int length = this.f21890f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i8 = 1;
        int i9 = length - 1;
        int i10 = 0;
        while (i8 <= i9) {
            int i11 = (i8 + i9) / 2;
            if (x(this.f21890f[i11], rectF)) {
                int i12 = i11 + 1;
                i10 = i8;
                i8 = i12;
            } else {
                i10 = i11 - 1;
                i9 = i10;
            }
        }
        return this.f21890f[i10];
    }

    public int f() {
        return Math.round(this.f21889e);
    }

    public int g() {
        return Math.round(this.f21888d);
    }

    public int h() {
        return Math.round(this.f21887c);
    }

    public int[] i() {
        return this.f21890f;
    }

    public int j() {
        return this.f21885a;
    }

    public void l(int i8) {
        TextPaint textPaint = this.f21892h;
        if (textPaint == null) {
            this.f21892h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f21892h.set(this.f21893i.getPaint());
        this.f21892h.setTextSize(i8);
    }

    public boolean n() {
        return y() && this.f21885a != 0;
    }

    public void o(AttributeSet attributeSet, int i8) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f21894j.obtainStyledAttributes(attributeSet, g.i.f17837S, i8, 0);
        TextView textView = this.f21893i;
        T.D.I(textView, textView.getContext(), g.i.f17837S, attributeSet, typedArrayObtainStyledAttributes, i8, 0);
        if (typedArrayObtainStyledAttributes.hasValue(g.i.f17852X)) {
            this.f21885a = typedArrayObtainStyledAttributes.getInt(g.i.f17852X, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(g.i.f17849W) ? typedArrayObtainStyledAttributes.getDimension(g.i.f17849W, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(g.i.f17843U) ? typedArrayObtainStyledAttributes.getDimension(g.i.f17843U, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(g.i.f17840T) ? typedArrayObtainStyledAttributes.getDimension(g.i.f17840T, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(g.i.f17846V) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(g.i.f17846V, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!y()) {
            this.f21885a = 0;
            return;
        }
        if (this.f21885a == 1) {
            if (!this.f21891g) {
                DisplayMetrics displayMetrics = this.f21894j.getResources().getDisplayMetrics();
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

    public void p(int i8, int i9, int i10, int i11) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f21894j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i11, i8, displayMetrics), TypedValue.applyDimension(i11, i9, displayMetrics), TypedValue.applyDimension(i11, i10, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    public void q(int[] iArr, int i8) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i8 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f21894j.getResources().getDisplayMetrics();
                    for (int i9 = 0; i9 < length; i9++) {
                        iArrCopyOf[i9] = Math.round(TypedValue.applyDimension(i8, iArr[i9], displayMetrics));
                    }
                }
                this.f21890f = b(iArrCopyOf);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f21891g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    public void r(int i8) {
        if (y()) {
            if (i8 == 0) {
                c();
                return;
            }
            if (i8 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i8);
            }
            DisplayMetrics displayMetrics = this.f21894j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (u()) {
                a();
            }
        }
    }

    public final void s(float f8) {
        if (f8 != this.f21893i.getPaint().getTextSize()) {
            this.f21893i.getPaint().setTextSize(f8);
            boolean zIsInLayout = this.f21893i.isInLayout();
            if (this.f21893i.getLayout() != null) {
                this.f21886b = false;
                try {
                    Method methodK = k("nullLayouts");
                    if (methodK != null) {
                        methodK.invoke(this.f21893i, null);
                    }
                } catch (Exception e8) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e8);
                }
                if (zIsInLayout) {
                    this.f21893i.forceLayout();
                } else {
                    this.f21893i.requestLayout();
                }
                this.f21893i.invalidate();
            }
        }
    }

    public void t(int i8, float f8) {
        Context context = this.f21894j;
        s(TypedValue.applyDimension(i8, f8, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean u() {
        if (y() && this.f21885a == 1) {
            if (!this.f21891g || this.f21890f.length == 0) {
                int iFloor = ((int) Math.floor((this.f21889e - this.f21888d) / this.f21887c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i8 = 0; i8 < iFloor; i8++) {
                    iArr[i8] = Math.round(this.f21888d + (i8 * this.f21887c));
                }
                this.f21890f = b(iArr);
            }
            this.f21886b = true;
        } else {
            this.f21886b = false;
        }
        return this.f21886b;
    }

    public final void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i8 = 0; i8 < length; i8++) {
                iArr[i8] = typedArray.getDimensionPixelSize(i8, -1);
            }
            this.f21890f = b(iArr);
            w();
        }
    }

    public final boolean w() {
        boolean z7 = this.f21890f.length > 0;
        this.f21891g = z7;
        if (z7) {
            this.f21885a = 1;
            this.f21888d = r0[0];
            this.f21889e = r0[r1 - 1];
            this.f21887c = -1.0f;
        }
        return z7;
    }

    public final boolean x(int i8, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f21893i.getText();
        TransformationMethod transformationMethod = this.f21893i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f21893i)) != null) {
            text = transformation;
        }
        int maxLines = this.f21893i.getMaxLines();
        l(i8);
        StaticLayout staticLayoutD = d(text, (Layout.Alignment) m(this.f21893i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutD.getLineCount() <= maxLines && staticLayoutD.getLineEnd(staticLayoutD.getLineCount() - 1) == text.length())) && ((float) staticLayoutD.getHeight()) <= rectF.bottom;
    }

    public final boolean y() {
        return true;
    }

    public final void z(float f8, float f9, float f10) {
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f8 + "px) is less or equal to (0px)");
        }
        if (f9 <= f8) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f9 + "px) is less or equal to minimum auto-size text size (" + f8 + "px)");
        }
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f10 + "px) is less or equal to (0px)");
        }
        this.f21885a = 1;
        this.f21888d = f8;
        this.f21889e = f9;
        this.f21887c = f10;
        this.f21891g = false;
    }
}
