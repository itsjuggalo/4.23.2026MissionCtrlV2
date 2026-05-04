package o;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f17266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.f f17267b;

    public g(TextView textView) {
        this.f17266a = textView;
        this.f17267b = new s1.f(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f17267b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f17267b.b();
    }

    public void c(AttributeSet attributeSet, int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f17266a.getContext().obtainStyledAttributes(attributeSet, g.i.S, i10, 0);
        try {
            boolean z10 = typedArrayObtainStyledAttributes.hasValue(g.i.f9787g0) ? typedArrayObtainStyledAttributes.getBoolean(g.i.f9787g0, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(boolean z10) {
        this.f17267b.c(z10);
    }

    public void e(boolean z10) {
        this.f17267b.d(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f17267b.e(transformationMethod);
    }
}
