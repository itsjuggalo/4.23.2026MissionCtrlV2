package I0;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: renamed from: I0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0569j implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f2793a;

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f7, Rect rect, Rect rect2) {
        int i7 = rect.left + ((int) ((rect2.left - r0) * f7));
        int i8 = rect.top + ((int) ((rect2.top - r1) * f7));
        int i9 = rect.right + ((int) ((rect2.right - r2) * f7));
        int i10 = rect.bottom + ((int) ((rect2.bottom - r6) * f7));
        Rect rect3 = this.f2793a;
        if (rect3 == null) {
            return new Rect(i7, i8, i9, i10);
        }
        rect3.set(i7, i8, i9, i10);
        return this.f2793a;
    }
}
