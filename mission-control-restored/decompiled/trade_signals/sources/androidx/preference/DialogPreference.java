package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import s0.AbstractC2683c;
import s0.g;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public CharSequence f12035D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public CharSequence f12036E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public Drawable f12037F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public CharSequence f12038G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public CharSequence f12039H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f12040I;

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22944b, R.attr.dialogPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public void N() {
        t();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f23029i, i8, i9);
        String strF = i.f(typedArrayObtainStyledAttributes, g.f23049s, g.f23031j);
        this.f12035D = strF;
        if (strF == null) {
            this.f12035D = H();
        }
        this.f12036E = i.f(typedArrayObtainStyledAttributes, g.f23047r, g.f23033k);
        this.f12037F = i.c(typedArrayObtainStyledAttributes, g.f23043p, g.f23035l);
        this.f12038G = i.f(typedArrayObtainStyledAttributes, g.f23053u, g.f23037m);
        this.f12039H = i.f(typedArrayObtainStyledAttributes, g.f23051t, g.f23039n);
        this.f12040I = i.e(typedArrayObtainStyledAttributes, g.f23045q, g.f23041o, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
