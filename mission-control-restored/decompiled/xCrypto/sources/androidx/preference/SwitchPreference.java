package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import h0.AbstractC1273c;
import h0.AbstractC1277g;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final a f7815I;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public CharSequence f7816O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public CharSequence f7817P;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            if (SwitchPreference.this.a(Boolean.valueOf(z4))) {
                SwitchPreference.this.L(z4);
            } else {
                compoundButton.setChecked(!z4);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f7815I = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12003J0, i4, i5);
        O(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12019R0, AbstractC1277g.f12005K0));
        N(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12017Q0, AbstractC1277g.f12007L0));
        R(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12023T0, AbstractC1277g.f12011N0));
        Q(AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12021S0, AbstractC1277g.f12013O0));
        M(AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12015P0, AbstractC1277g.f12009M0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void T(View view) {
        if (((AccessibilityManager) g().getSystemService("accessibility")).isEnabled()) {
            S(view.findViewById(R.id.switch_widget));
            P(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void D(View view) {
        super.D(view);
        T(view);
    }

    public void Q(CharSequence charSequence) {
        this.f7817P = charSequence;
        w();
    }

    public void R(CharSequence charSequence) {
        this.f7816O = charSequence;
        w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S(View view) {
        boolean z4 = view instanceof Switch;
        if (z4) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f7823D);
        }
        if (z4) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.f7816O);
            r4.setTextOff(this.f7817P);
            r4.setOnCheckedChangeListener(this.f7815I);
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11980j, R.attr.switchPreferenceStyle));
    }
}
