package p;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import h.AbstractC1664i;

/* JADX INFO: renamed from: p.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2350k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f21384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0.f f21385b;

    public C2350k(TextView textView) {
        this.f21384a = textView;
        this.f21385b = new j0.f(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f21385b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f21385b.b();
    }

    public void c(AttributeSet attributeSet, int i7) {
        TypedArray typedArrayObtainStyledAttributes = this.f21384a.getContext().obtainStyledAttributes(attributeSet, AbstractC1664i.f14548S, i7, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(AbstractC1664i.f14611g0) ? typedArrayObtainStyledAttributes.getBoolean(AbstractC1664i.f14611g0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(boolean z7) {
        this.f21385b.c(z7);
    }

    public void e(boolean z7) {
        this.f21385b.d(z7);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f21385b.e(transformationMethod);
    }
}
