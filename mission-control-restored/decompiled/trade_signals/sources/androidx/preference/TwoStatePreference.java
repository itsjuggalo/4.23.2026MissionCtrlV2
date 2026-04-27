package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f12119D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public CharSequence f12120E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public CharSequence f12121F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f12122G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f12123H;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.preference.Preference
    public void N() {
        super.N();
        boolean z7 = !Z();
        if (a(Boolean.valueOf(z7))) {
            a0(z7);
        }
    }

    @Override // androidx.preference.Preference
    public Object P(TypedArray typedArray, int i8) {
        return Boolean.valueOf(typedArray.getBoolean(i8, false));
    }

    @Override // androidx.preference.Preference
    public boolean X() {
        return (this.f12123H ? this.f12119D : !this.f12119D) || super.X();
    }

    public boolean Z() {
        return this.f12119D;
    }

    public void a0(boolean z7) {
        boolean z8 = this.f12119D != z7;
        if (z8 || !this.f12122G) {
            this.f12119D = z7;
            this.f12122G = true;
            T(z7);
            if (z8) {
                M(X());
                L();
            }
        }
    }

    public void b0(boolean z7) {
        this.f12123H = z7;
    }

    public void c0(CharSequence charSequence) {
        this.f12121F = charSequence;
        if (Z()) {
            return;
        }
        L();
    }

    public void d0(CharSequence charSequence) {
        this.f12120E = charSequence;
        if (Z()) {
            L();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e0(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.f12119D
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r4.f12120E
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r4.f12120E
        L16:
            r5.setText(r0)
            r0 = r1
            goto L2b
        L1b:
            boolean r0 = r4.f12119D
            if (r0 != 0) goto L2a
            java.lang.CharSequence r0 = r4.f12121F
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2a
            java.lang.CharSequence r0 = r4.f12121F
            goto L16
        L2a:
            r0 = 1
        L2b:
            if (r0 == 0) goto L3b
            java.lang.CharSequence r2 = r4.w()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3b
            r5.setText(r2)
            r0 = r1
        L3b:
            if (r0 != 0) goto L3e
            goto L40
        L3e:
            r1 = 8
        L40:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L49
            r5.setVisibility(r1)
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.e0(android.view.View):void");
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
    }
}
