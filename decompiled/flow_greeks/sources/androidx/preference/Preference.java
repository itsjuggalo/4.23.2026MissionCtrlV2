package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.common.api.a;
import d2.c;
import d2.e;
import d2.g;
import java.util.List;
import k0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public List A;
    public b B;
    public final View.OnClickListener C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f2512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f2513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Intent f2516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f2521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f2522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2524p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2525q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2526r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2527s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2528t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2529u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2530v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2532x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2533y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2534z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.S(view);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f2510b = a.e.API_PRIORITY_OTHER;
        this.f2511c = 0;
        this.f2518j = true;
        this.f2519k = true;
        this.f2520l = true;
        this.f2523o = true;
        this.f2524p = true;
        this.f2525q = true;
        this.f2526r = true;
        this.f2527s = true;
        this.f2529u = true;
        this.f2532x = true;
        this.f2533y = e.f7517a;
        this.C = new a();
        this.f2509a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.I, i10, i11);
        this.f2514f = i.e(typedArrayObtainStyledAttributes, g.f7537g0, g.J, 0);
        this.f2515g = i.f(typedArrayObtainStyledAttributes, g.f7543j0, g.P);
        this.f2512d = i.g(typedArrayObtainStyledAttributes, g.f7559r0, g.N);
        this.f2513e = i.g(typedArrayObtainStyledAttributes, g.f7557q0, g.Q);
        this.f2510b = i.d(typedArrayObtainStyledAttributes, g.f7547l0, g.R, a.e.API_PRIORITY_OTHER);
        this.f2517i = i.f(typedArrayObtainStyledAttributes, g.f7535f0, g.W);
        this.f2533y = i.e(typedArrayObtainStyledAttributes, g.f7545k0, g.M, e.f7517a);
        this.f2534z = i.e(typedArrayObtainStyledAttributes, g.f7561s0, g.S, 0);
        this.f2518j = i.b(typedArrayObtainStyledAttributes, g.f7532e0, g.L, true);
        this.f2519k = i.b(typedArrayObtainStyledAttributes, g.f7551n0, g.O, true);
        this.f2520l = i.b(typedArrayObtainStyledAttributes, g.f7549m0, g.K, true);
        this.f2521m = i.f(typedArrayObtainStyledAttributes, g.f7526c0, g.T);
        int i12 = g.Z;
        this.f2526r = i.b(typedArrayObtainStyledAttributes, i12, i12, this.f2519k);
        int i13 = g.f7520a0;
        this.f2527s = i.b(typedArrayObtainStyledAttributes, i13, i13, this.f2519k);
        if (typedArrayObtainStyledAttributes.hasValue(g.f7523b0)) {
            this.f2522n = L(typedArrayObtainStyledAttributes, g.f7523b0);
        } else if (typedArrayObtainStyledAttributes.hasValue(g.U)) {
            this.f2522n = L(typedArrayObtainStyledAttributes, g.U);
        }
        this.f2532x = i.b(typedArrayObtainStyledAttributes, g.f7553o0, g.V, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(g.f7555p0);
        this.f2528t = zHasValue;
        if (zHasValue) {
            this.f2529u = i.b(typedArrayObtainStyledAttributes, g.f7555p0, g.X, true);
        }
        this.f2530v = i.b(typedArrayObtainStyledAttributes, g.f7539h0, g.Y, false);
        int i14 = g.f7541i0;
        this.f2525q = i.b(typedArrayObtainStyledAttributes, i14, i14, true);
        int i15 = g.f7529d0;
        this.f2531w = i.b(typedArrayObtainStyledAttributes, i15, i15, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean A() {
        return this.f2518j && this.f2523o && this.f2524p;
    }

    public boolean B() {
        return this.f2519k;
    }

    public void G(boolean z10) {
        List list = this.A;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((Preference) list.get(i10)).K(this, z10);
        }
    }

    public void K(Preference preference, boolean z10) {
        if (this.f2523o == z10) {
            this.f2523o = !z10;
            G(X());
            E();
        }
    }

    public Object L(TypedArray typedArray, int i10) {
        return null;
    }

    public void M(Preference preference, boolean z10) {
        if (this.f2524p == z10) {
            this.f2524p = !z10;
            G(X());
            E();
        }
    }

    public void R() {
        if (A() && B()) {
            H();
            s();
            if (this.f2516h != null) {
                c().startActivity(this.f2516h);
            }
        }
    }

    public void S(View view) {
        R();
    }

    public boolean T(boolean z10) {
        if (!Y()) {
            return false;
        }
        if (z10 == l(!z10)) {
            return true;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean U(int i10) {
        if (!Y()) {
            return false;
        }
        if (i10 == m(~i10)) {
            return true;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean V(String str) {
        if (!Y()) {
            return false;
        }
        Object obj = null;
        if (TextUtils.equals(str, o(null))) {
            return true;
        }
        q();
        obj.getClass();
        throw null;
    }

    public final void W(b bVar) {
        this.B = bVar;
        E();
    }

    public boolean X() {
        return !A();
    }

    public boolean Y() {
        return false;
    }

    public boolean a(Object obj) {
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i10 = this.f2510b;
        int i11 = preference.f2510b;
        if (i10 != i11) {
            return i10 - i11;
        }
        CharSequence charSequence = this.f2512d;
        CharSequence charSequence2 = preference.f2512d;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f2512d.toString());
    }

    public Context c() {
        return this.f2509a;
    }

    public StringBuilder h() {
        StringBuilder sb2 = new StringBuilder();
        CharSequence charSequenceW = w();
        if (!TextUtils.isEmpty(charSequenceW)) {
            sb2.append(charSequenceW);
            sb2.append(' ');
        }
        CharSequence charSequenceU = u();
        if (!TextUtils.isEmpty(charSequenceU)) {
            sb2.append(charSequenceU);
            sb2.append(' ');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2;
    }

    public String i() {
        return this.f2517i;
    }

    public Intent k() {
        return this.f2516h;
    }

    public boolean l(boolean z10) {
        if (!Y()) {
            return z10;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public int m(int i10) {
        if (!Y()) {
            return i10;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public String o(String str) {
        if (!Y()) {
            return str;
        }
        q();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public d2.a q() {
        return null;
    }

    public d2.b s() {
        return null;
    }

    public String toString() {
        return h().toString();
    }

    public CharSequence u() {
        return v() != null ? v().a(this) : this.f2513e;
    }

    public final b v() {
        return this.B;
    }

    public CharSequence w() {
        return this.f2512d;
    }

    public boolean y() {
        return !TextUtils.isEmpty(this.f2515g);
    }

    public void E() {
    }

    public void H() {
    }

    public Preference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f7512g, R.attr.preferenceStyle));
    }
}
