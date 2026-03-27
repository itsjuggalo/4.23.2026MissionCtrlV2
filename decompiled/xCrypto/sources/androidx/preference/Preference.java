package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import h0.AbstractC1271a;
import h0.AbstractC1272b;
import h0.AbstractC1273c;
import h0.AbstractC1275e;
import h0.AbstractC1277g;
import java.util.List;
import y.AbstractC1934i;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public List f7761A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public b f7762B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final View.OnClickListener f7763C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f7767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f7768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7770g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Intent f7771h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7772i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7773j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7774k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7775l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7776m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f7777n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7778o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7779p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7780q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7781r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7782s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7783t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7784u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7785v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7786w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7787x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7788y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7789z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.D(view);
        }
    }

    public interface b {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.f7765b = Integer.MAX_VALUE;
        this.f7766c = 0;
        this.f7773j = true;
        this.f7774k = true;
        this.f7775l = true;
        this.f7778o = true;
        this.f7779p = true;
        this.f7780q = true;
        this.f7781r = true;
        this.f7782s = true;
        this.f7784u = true;
        this.f7787x = true;
        this.f7788y = AbstractC1275e.f11982a;
        this.f7763C = new a();
        this.f7764a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1277g.f12000I, i4, i5);
        this.f7769f = AbstractC1934i.e(typedArrayObtainStyledAttributes, AbstractC1277g.f12054g0, AbstractC1277g.f12002J, 0);
        this.f7770g = AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12060j0, AbstractC1277g.f12014P);
        this.f7767d = AbstractC1934i.g(typedArrayObtainStyledAttributes, AbstractC1277g.f12076r0, AbstractC1277g.f12010N);
        this.f7768e = AbstractC1934i.g(typedArrayObtainStyledAttributes, AbstractC1277g.f12074q0, AbstractC1277g.f12016Q);
        this.f7765b = AbstractC1934i.d(typedArrayObtainStyledAttributes, AbstractC1277g.f12064l0, AbstractC1277g.f12018R, Integer.MAX_VALUE);
        this.f7772i = AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12052f0, AbstractC1277g.f12028W);
        this.f7788y = AbstractC1934i.e(typedArrayObtainStyledAttributes, AbstractC1277g.f12062k0, AbstractC1277g.f12008M, AbstractC1275e.f11982a);
        this.f7789z = AbstractC1934i.e(typedArrayObtainStyledAttributes, AbstractC1277g.f12078s0, AbstractC1277g.f12020S, 0);
        this.f7773j = AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12049e0, AbstractC1277g.f12006L, true);
        this.f7774k = AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12068n0, AbstractC1277g.f12012O, true);
        this.f7775l = AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12066m0, AbstractC1277g.f12004K, true);
        this.f7776m = AbstractC1934i.f(typedArrayObtainStyledAttributes, AbstractC1277g.f12043c0, AbstractC1277g.f12022T);
        int i6 = AbstractC1277g.f12034Z;
        this.f7781r = AbstractC1934i.b(typedArrayObtainStyledAttributes, i6, i6, this.f7774k);
        int i7 = AbstractC1277g.f12037a0;
        this.f7782s = AbstractC1934i.b(typedArrayObtainStyledAttributes, i7, i7, this.f7774k);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC1277g.f12040b0)) {
            this.f7777n = A(typedArrayObtainStyledAttributes, AbstractC1277g.f12040b0);
        } else if (typedArrayObtainStyledAttributes.hasValue(AbstractC1277g.f12024U)) {
            this.f7777n = A(typedArrayObtainStyledAttributes, AbstractC1277g.f12024U);
        }
        this.f7787x = AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12070o0, AbstractC1277g.f12026V, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(AbstractC1277g.f12072p0);
        this.f7783t = zHasValue;
        if (zHasValue) {
            this.f7784u = AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12072p0, AbstractC1277g.f12030X, true);
        }
        this.f7785v = AbstractC1934i.b(typedArrayObtainStyledAttributes, AbstractC1277g.f12056h0, AbstractC1277g.f12032Y, false);
        int i8 = AbstractC1277g.f12058i0;
        this.f7780q = AbstractC1934i.b(typedArrayObtainStyledAttributes, i8, i8, true);
        int i9 = AbstractC1277g.f12046d0;
        this.f7786w = AbstractC1934i.b(typedArrayObtainStyledAttributes, i9, i9, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Object A(TypedArray typedArray, int i4) {
        return null;
    }

    public void B(Preference preference, boolean z4) {
        if (this.f7779p == z4) {
            this.f7779p = !z4;
            x(I());
            w();
        }
    }

    public void C() {
        if (u() && v()) {
            y();
            p();
            if (this.f7771h != null) {
                g().startActivity(this.f7771h);
            }
        }
    }

    public void D(View view) {
        C();
    }

    public boolean E(boolean z4) {
        if (!J()) {
            return false;
        }
        if (z4 == l(!z4)) {
            return true;
        }
        o();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean F(int i4) {
        if (!J()) {
            return false;
        }
        if (i4 == m(~i4)) {
            return true;
        }
        o();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean G(String str) {
        if (!J()) {
            return false;
        }
        Object obj = null;
        if (TextUtils.equals(str, n(null))) {
            return true;
        }
        o();
        obj.getClass();
        throw null;
    }

    public final void H(b bVar) {
        this.f7762B = bVar;
        w();
    }

    public boolean I() {
        return !u();
    }

    public boolean J() {
        return false;
    }

    public boolean a(Object obj) {
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i4 = this.f7765b;
        int i5 = preference.f7765b;
        if (i4 != i5) {
            return i4 - i5;
        }
        CharSequence charSequence = this.f7767d;
        CharSequence charSequence2 = preference.f7767d;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f7767d.toString());
    }

    public Context g() {
        return this.f7764a;
    }

    public StringBuilder h() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceS = s();
        if (!TextUtils.isEmpty(charSequenceS)) {
            sb.append(charSequenceS);
            sb.append(' ');
        }
        CharSequence charSequenceQ = q();
        if (!TextUtils.isEmpty(charSequenceQ)) {
            sb.append(charSequenceQ);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String i() {
        return this.f7772i;
    }

    public Intent k() {
        return this.f7771h;
    }

    public boolean l(boolean z4) {
        if (!J()) {
            return z4;
        }
        o();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public int m(int i4) {
        if (!J()) {
            return i4;
        }
        o();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public String n(String str) {
        if (!J()) {
            return str;
        }
        o();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public AbstractC1271a o() {
        return null;
    }

    public AbstractC1272b p() {
        return null;
    }

    public CharSequence q() {
        return r() != null ? r().a(this) : this.f7768e;
    }

    public final b r() {
        return this.f7762B;
    }

    public CharSequence s() {
        return this.f7767d;
    }

    public boolean t() {
        return !TextUtils.isEmpty(this.f7770g);
    }

    public String toString() {
        return h().toString();
    }

    public boolean u() {
        return this.f7773j && this.f7778o && this.f7779p;
    }

    public boolean v() {
        return this.f7774k;
    }

    public void w() {
    }

    public void x(boolean z4) {
        List list = this.f7761A;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((Preference) list.get(i4)).z(this, z4);
        }
    }

    public void y() {
    }

    public void z(Preference preference, boolean z4) {
        if (this.f7778o == z4) {
            this.f7778o = !z4;
            x(I());
            w();
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1934i.a(context, AbstractC1273c.f11977g, R.attr.preferenceStyle));
    }
}
