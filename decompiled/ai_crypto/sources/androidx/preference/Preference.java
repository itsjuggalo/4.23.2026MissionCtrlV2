package androidx.preference;

import H.i;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.common.api.a;
import java.util.List;
import x0.AbstractC2814a;
import x0.AbstractC2815b;
import x0.c;
import x0.e;
import x0.g;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public List f7870A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public b f7871B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final View.OnClickListener f7872C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f7876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f7877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Intent f7880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f7886n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7887o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7888p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7889q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7890r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7891s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7896x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7897y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7898z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.C(view);
        }
    }

    public interface b {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i7, int i8) {
        this.f7874b = a.e.API_PRIORITY_OTHER;
        this.f7875c = 0;
        this.f7882j = true;
        this.f7883k = true;
        this.f7884l = true;
        this.f7887o = true;
        this.f7888p = true;
        this.f7889q = true;
        this.f7890r = true;
        this.f7891s = true;
        this.f7893u = true;
        this.f7896x = true;
        this.f7897y = e.f25159a;
        this.f7872C = new a();
        this.f7873a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f25177I, i7, i8);
        this.f7878f = i.e(typedArrayObtainStyledAttributes, g.f25231g0, g.f25179J, 0);
        this.f7879g = i.f(typedArrayObtainStyledAttributes, g.f25237j0, g.f25191P);
        this.f7876d = i.g(typedArrayObtainStyledAttributes, g.f25253r0, g.f25187N);
        this.f7877e = i.g(typedArrayObtainStyledAttributes, g.f25251q0, g.f25193Q);
        this.f7874b = i.d(typedArrayObtainStyledAttributes, g.f25241l0, g.f25195R, a.e.API_PRIORITY_OTHER);
        this.f7881i = i.f(typedArrayObtainStyledAttributes, g.f25229f0, g.f25205W);
        this.f7897y = i.e(typedArrayObtainStyledAttributes, g.f25239k0, g.f25185M, e.f25159a);
        this.f7898z = i.e(typedArrayObtainStyledAttributes, g.f25255s0, g.f25197S, 0);
        this.f7882j = i.b(typedArrayObtainStyledAttributes, g.f25226e0, g.f25183L, true);
        this.f7883k = i.b(typedArrayObtainStyledAttributes, g.f25245n0, g.f25189O, true);
        this.f7884l = i.b(typedArrayObtainStyledAttributes, g.f25243m0, g.f25181K, true);
        this.f7885m = i.f(typedArrayObtainStyledAttributes, g.f25220c0, g.f25199T);
        int i9 = g.f25211Z;
        this.f7890r = i.b(typedArrayObtainStyledAttributes, i9, i9, this.f7883k);
        int i10 = g.f25214a0;
        this.f7891s = i.b(typedArrayObtainStyledAttributes, i10, i10, this.f7883k);
        if (typedArrayObtainStyledAttributes.hasValue(g.f25217b0)) {
            this.f7886n = z(typedArrayObtainStyledAttributes, g.f25217b0);
        } else if (typedArrayObtainStyledAttributes.hasValue(g.f25201U)) {
            this.f7886n = z(typedArrayObtainStyledAttributes, g.f25201U);
        }
        this.f7896x = i.b(typedArrayObtainStyledAttributes, g.f25247o0, g.f25203V, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(g.f25249p0);
        this.f7892t = zHasValue;
        if (zHasValue) {
            this.f7893u = i.b(typedArrayObtainStyledAttributes, g.f25249p0, g.f25207X, true);
        }
        this.f7894v = i.b(typedArrayObtainStyledAttributes, g.f25233h0, g.f25209Y, false);
        int i11 = g.f25235i0;
        this.f7889q = i.b(typedArrayObtainStyledAttributes, i11, i11, true);
        int i12 = g.f25223d0;
        this.f7895w = i.b(typedArrayObtainStyledAttributes, i12, i12, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void A(Preference preference, boolean z7) {
        if (this.f7888p == z7) {
            this.f7888p = !z7;
            w(H());
            v();
        }
    }

    public void B() {
        if (t() && u()) {
            x();
            o();
            if (this.f7880h != null) {
                c().startActivity(this.f7880h);
            }
        }
    }

    public void C(View view) {
        B();
    }

    public boolean D(boolean z7) {
        if (!I()) {
            return false;
        }
        if (z7 == k(!z7)) {
            return true;
        }
        n();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean E(int i7) {
        if (!I()) {
            return false;
        }
        if (i7 == l(~i7)) {
            return true;
        }
        n();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean F(String str) {
        if (!I()) {
            return false;
        }
        Object obj = null;
        if (TextUtils.equals(str, m(null))) {
            return true;
        }
        n();
        obj.getClass();
        throw null;
    }

    public final void G(b bVar) {
        this.f7871B = bVar;
        v();
    }

    public boolean H() {
        return !t();
    }

    public boolean I() {
        return false;
    }

    public boolean a(Object obj) {
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i7 = this.f7874b;
        int i8 = preference.f7874b;
        if (i7 != i8) {
            return i7 - i8;
        }
        CharSequence charSequence = this.f7876d;
        CharSequence charSequence2 = preference.f7876d;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f7876d.toString());
    }

    public Context c() {
        return this.f7873a;
    }

    public StringBuilder h() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceR = r();
        if (!TextUtils.isEmpty(charSequenceR)) {
            sb.append(charSequenceR);
            sb.append(' ');
        }
        CharSequence charSequenceP = p();
        if (!TextUtils.isEmpty(charSequenceP)) {
            sb.append(charSequenceP);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String i() {
        return this.f7881i;
    }

    public Intent j() {
        return this.f7880h;
    }

    public boolean k(boolean z7) {
        if (!I()) {
            return z7;
        }
        n();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public int l(int i7) {
        if (!I()) {
            return i7;
        }
        n();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public String m(String str) {
        if (!I()) {
            return str;
        }
        n();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public AbstractC2814a n() {
        return null;
    }

    public AbstractC2815b o() {
        return null;
    }

    public CharSequence p() {
        return q() != null ? q().a(this) : this.f7877e;
    }

    public final b q() {
        return this.f7871B;
    }

    public CharSequence r() {
        return this.f7876d;
    }

    public boolean s() {
        return !TextUtils.isEmpty(this.f7879g);
    }

    public boolean t() {
        return this.f7882j && this.f7887o && this.f7888p;
    }

    public String toString() {
        return h().toString();
    }

    public boolean u() {
        return this.f7883k;
    }

    public void v() {
    }

    public void w(boolean z7) {
        List list = this.f7870A;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((Preference) list.get(i7)).y(this, z7);
        }
    }

    public void x() {
    }

    public void y(Preference preference, boolean z7) {
        if (this.f7887o == z7) {
            this.f7887o = !z7;
            w(H());
            v();
        }
    }

    public Object z(TypedArray typedArray, int i7) {
        return null;
    }

    public Preference(Context context, AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f25154g, R.attr.preferenceStyle));
    }
}
