package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import x0.c;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public CharSequence f7848D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public CharSequence f7849E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public Drawable f7850F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public CharSequence f7851G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public CharSequence f7852H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f7853I;

    public DialogPreference(Context context, AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25234i, i7, i8);
        String strF = i.f(typedArrayObtainStyledAttributes, g.f25254s, g.f25236j);
        this.f7848D = strF;
        if (strF == null) {
            this.f7848D = r();
        }
        this.f7849E = i.f(typedArrayObtainStyledAttributes, g.f25252r, g.f25238k);
        this.f7850F = i.c(typedArrayObtainStyledAttributes, g.f25248p, g.f25240l);
        this.f7851G = i.f(typedArrayObtainStyledAttributes, g.f25258u, g.f25242m);
        this.f7852H = i.f(typedArrayObtainStyledAttributes, g.f25256t, g.f25244n);
        this.f7853I = i.e(typedArrayObtainStyledAttributes, g.f25250q, g.f25246o, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void x() {
        o();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f25149b, R.attr.dialogPreferenceStyle));
    }
}
