package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import h0.AbstractC1273c;
import h0.AbstractC1274d;
import h0.AbstractC1277g;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f7819I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence f7820O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence f7821P;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            if (SwitchPreferenceCompat.this.a(Boolean.valueOf(z4))) {
                SwitchPreferenceCompat.this.L(z4);
            } else {
                compoundButton.setChecked(!z4);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f7819I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12025U0, i4, i5);
        O(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12044c1, AbstractC1277g.f12027V0));
        N(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12041b1, AbstractC1277g.f12029W0));
        R(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12050e1, AbstractC1277g.f12033Y0));
        Q(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12047d1, AbstractC1277g.f12035Z0));
        M(AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12038a1, AbstractC1277g.f12031X0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void S(View view) {
        boolean z4 = view instanceof SwitchCompat;
        if (z4) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f7823D);
        }
        if (z4) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f7820O);
            switchCompat.setTextOff(this.f7821P);
            switchCompat.setOnCheckedChangeListener(this.f7819I);
        }
    }

    private void T(View view) {
        if (((AccessibilityManager) g().getSystemService("accessibility")).isEnabled()) {
            S(view.findViewById(AbstractC1274d.f11981a));
            P(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void D(View view) {
        super.D(view);
        T(view);
    }

    public void Q(CharSequence charSequence) {
        this.f7821P = charSequence;
        w();
    }

    public void R(CharSequence charSequence) {
        this.f7820O = charSequence;
        w();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1273c.f11979i);
    }
}
