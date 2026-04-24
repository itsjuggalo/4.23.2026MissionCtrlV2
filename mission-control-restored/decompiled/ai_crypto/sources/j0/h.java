package j0;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class h implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransformationMethod f17365a;

    public h(TransformationMethod transformationMethod) {
        this.f17365a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f17365a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f17365a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || androidx.emoji2.text.c.b().d() != 1) ? charSequence : androidx.emoji2.text.c.b().o(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z7, int i7, Rect rect) {
        TransformationMethod transformationMethod = this.f17365a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z7, i7, rect);
        }
    }
}
