package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import d2.c;
import d2.g;
import k0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    public CharSequence D;
    public CharSequence E;
    public Drawable F;
    public CharSequence G;
    public CharSequence H;
    public int I;

    public DialogPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f7540i, i10, i11);
        String strF = i.f(typedArrayObtainStyledAttributes, g.f7560s, g.f7542j);
        this.D = strF;
        if (strF == null) {
            this.D = w();
        }
        this.E = i.f(typedArrayObtainStyledAttributes, g.f7558r, g.f7544k);
        this.F = i.c(typedArrayObtainStyledAttributes, g.f7554p, g.f7546l);
        this.G = i.f(typedArrayObtainStyledAttributes, g.f7564u, g.f7548m);
        this.H = i.f(typedArrayObtainStyledAttributes, g.f7562t, g.f7550n);
        this.I = i.e(typedArrayObtainStyledAttributes, g.f7556q, g.f7552o, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void H() {
        s();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f7507b, R.attr.dialogPreferenceStyle));
    }
}
