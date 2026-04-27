package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class I {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final RectF f8237l = new RectF();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap f8238m = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8239a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8240b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8241c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f8242d = -1.0f;
    public float e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f8243f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f8244g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f8245h;
    public final TextView i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f8246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final F f8247k;

    static {
        new ConcurrentHashMap();
    }

    public I(TextView textView) {
        this.i = textView;
        this.f8246j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f8247k = new G();
        } else {
            this.f8247k = new F();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length != 0) {
            Arrays.sort(iArr);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            if (length != arrayList.size()) {
                int size = arrayList.size();
                int[] iArr2 = new int[size];
                for (int i6 = 0; i6 < size; i6++) {
                    iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
                }
                return iArr2;
            }
        }
        return iArr;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f8238m;
            Method declaredMethod = (Method) concurrentHashMap.get(str);
            if (declaredMethod != null || (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) == null) {
                return declaredMethod;
            }
            declaredMethod.setAccessible(true);
            concurrentHashMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    public static Object e(String str, Object obj, Object obj2) {
        try {
            return d(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj2;
        }
    }

    public final void a() {
        if (this.f8239a != 0) {
            if (this.f8240b) {
                if (this.i.getMeasuredHeight() <= 0 || this.i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f8247k.b(this.i) ? 1048576 : (this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft()) - this.i.getTotalPaddingRight();
                int height = (this.i.getHeight() - this.i.getCompoundPaddingBottom()) - this.i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f8237l;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float fC = c(rectF);
                        if (fC != this.i.getTextSize()) {
                            f(0, fC);
                        }
                    } finally {
                    }
                }
            }
            this.f8240b = true;
        }
    }

    public final int c(RectF rectF) {
        CharSequence transformation;
        int length = this.f8243f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = length - 1;
        int i6 = 0;
        int i7 = 1;
        while (i7 <= i) {
            int i8 = (i7 + i) / 2;
            int i9 = this.f8243f[i8];
            TextView textView = this.i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                text = transformation;
            }
            int iB = AbstractC0804C.b(textView);
            TextPaint textPaint = this.f8245h;
            if (textPaint == null) {
                this.f8245h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f8245h.set(textView.getPaint());
            this.f8245h.setTextSize(i9);
            StaticLayout staticLayoutA = E.a(text, (Layout.Alignment) e("getLayoutAlignment", textView, Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB, textView, this.f8245h, this.f8247k);
            if ((iB == -1 || (staticLayoutA.getLineCount() <= iB && staticLayoutA.getLineEnd(staticLayoutA.getLineCount() - 1) == text.length())) && staticLayoutA.getHeight() <= rectF.bottom) {
                int i10 = i8 + 1;
                i6 = i7;
                i7 = i10;
            } else {
                i6 = i8 - 1;
                i = i6;
            }
        }
        return this.f8243f[i6];
    }

    public final void f(int i, float f6) {
        Context context = this.f8246j;
        float fApplyDimension = TypedValue.applyDimension(i, f6, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.i;
        if (fApplyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(fApplyDimension);
            boolean zA = D.a(textView);
            if (textView.getLayout() != null) {
                this.f8240b = false;
                try {
                    Method methodD = d("nullLayouts");
                    if (methodD != null) {
                        methodD.invoke(textView, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (zA) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean g() {
        if (this.f8239a == 1) {
            if (!this.f8244g || this.f8243f.length == 0) {
                int iFloor = ((int) Math.floor((this.e - this.f8242d) / this.f8241c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i = 0; i < iFloor; i++) {
                    iArr[i] = Math.round((i * this.f8241c) + this.f8242d);
                }
                this.f8243f = b(iArr);
            }
            this.f8240b = true;
        } else {
            this.f8240b = false;
        }
        return this.f8240b;
    }

    public final boolean h() {
        boolean z6 = this.f8243f.length > 0;
        this.f8244g = z6;
        if (z6) {
            this.f8239a = 1;
            this.f8242d = r0[0];
            this.e = r0[r1 - 1];
            this.f8241c = -1.0f;
        }
        return z6;
    }

    public final void i(float f6, float f7, float f8) {
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f6 + "px) is less or equal to (0px)");
        }
        if (f7 <= f6) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f7 + "px) is less or equal to minimum auto-size text size (" + f6 + "px)");
        }
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f8 + "px) is less or equal to (0px)");
        }
        this.f8239a = 1;
        this.f8242d = f6;
        this.e = f7;
        this.f8241c = f8;
        this.f8244g = false;
    }
}
