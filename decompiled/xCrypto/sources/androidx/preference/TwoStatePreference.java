package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f7823D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public CharSequence f7824E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public CharSequence f7825F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f7826G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public boolean f7827H;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }

    @Override // androidx.preference.Preference
    public Object A(TypedArray typedArray, int i4) {
        return Boolean.valueOf(typedArray.getBoolean(i4, false));
    }

    @Override // androidx.preference.Preference
    public boolean I() {
        return (this.f7827H ? this.f7823D : !this.f7823D) || super.I();
    }

    public boolean K() {
        return this.f7823D;
    }

    public void L(boolean z4) {
        boolean z5 = this.f7823D != z4;
        if (z5 || !this.f7826G) {
            this.f7823D = z4;
            this.f7826G = true;
            E(z4);
            if (z5) {
                x(I());
                w();
            }
        }
    }

    public void M(boolean z4) {
        this.f7827H = z4;
    }

    public void N(CharSequence charSequence) {
        this.f7825F = charSequence;
        if (K()) {
            return;
        }
        w();
    }

    public void O(CharSequence charSequence) {
        this.f7824E = charSequence;
        if (K()) {
            w();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void P(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.f7823D
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r4.f7824E
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r4.f7824E
            r5.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r4.f7823D
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.f7825F
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.f7825F
            r5.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r2 = r4.q()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3e
            r5.setText(r2)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.P(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    public void y() {
        super.y();
        boolean z4 = !K();
        if (a(Boolean.valueOf(z4))) {
            L(z4);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
