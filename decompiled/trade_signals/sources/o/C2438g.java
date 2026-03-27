package o;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: renamed from: o.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2438g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f21835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0.f f21836b;

    public C2438g(TextView textView) {
        this.f21835a = textView;
        this.f21836b = new j0.f(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f21836b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f21836b.b();
    }

    public void c(AttributeSet attributeSet, int i8) {
        TypedArray typedArrayObtainStyledAttributes = this.f21835a.getContext().obtainStyledAttributes(attributeSet, g.i.f17837S, i8, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(g.i.f17886g0) ? typedArrayObtainStyledAttributes.getBoolean(g.i.f17886g0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(boolean z7) {
        this.f21836b.c(z7);
    }

    public void e(boolean z7) {
        this.f21836b.d(z7);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f21836b.e(transformationMethod);
    }
}
