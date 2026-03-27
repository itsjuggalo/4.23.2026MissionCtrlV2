package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import h0.AbstractC1273c;
import h0.AbstractC1277g;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public CharSequence f7739D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public CharSequence f7740E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public Drawable f7741F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public CharSequence f7742G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public CharSequence f7743H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f7744I;

    public DialogPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12057i, i4, i5);
        String strF = AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12077s, AbstractC1277g.f12059j);
        this.f7739D = strF;
        if (strF == null) {
            this.f7739D = s();
        }
        this.f7740E = AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12075r, AbstractC1277g.f12061k);
        this.f7741F = AbstractC1934i.c(typedArrayObtainStyledAttributes, AbstractC1277g.f12071p, AbstractC1277g.f12063l);
        this.f7742G = AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12081u, AbstractC1277g.f12065m);
        this.f7743H = AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12079t, AbstractC1277g.f12067n);
        this.f7744I = AbstractC1934i.e(typedArrayObtainStyledAttributes, AbstractC1277g.f12073q, AbstractC1277g.f12069o, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void y() {
        p();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11972b, R.attr.dialogPreferenceStyle));
    }
}
