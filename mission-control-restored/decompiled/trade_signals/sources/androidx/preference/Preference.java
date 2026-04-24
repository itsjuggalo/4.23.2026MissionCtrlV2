package androidx.preference;

import K.i;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import s0.AbstractC2681a;
import s0.AbstractC2682b;
import s0.AbstractC2683c;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public List f12057A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public b f12058B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final View.OnClickListener f12059C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f12063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f12064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f12066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Intent f12067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f12068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f12072m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f12073n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12074o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12075p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12076q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f12077r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12078s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12079t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12080u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12081v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12082w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12083x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12084y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f12085z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.S(view);
        }
    }

    public interface b {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, AbstractC2683c.f22949g, R.attr.preferenceStyle));
    }

    public final b B() {
        return this.f12058B;
    }

    public CharSequence H() {
        return this.f12063d;
    }

    public boolean I() {
        return !TextUtils.isEmpty(this.f12066g);
    }

    public boolean J() {
        return this.f12069j && this.f12074o && this.f12075p;
    }

    public boolean K() {
        return this.f12070k;
    }

    public void L() {
    }

    public void M(boolean z7) {
        List list = this.f12057A;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((Preference) list.get(i8)).O(this, z7);
        }
    }

    public void N() {
    }

    public void O(Preference preference, boolean z7) {
        if (this.f12074o == z7) {
            this.f12074o = !z7;
            M(X());
            L();
        }
    }

    public Object P(TypedArray typedArray, int i8) {
        return null;
    }

    public void Q(Preference preference, boolean z7) {
        if (this.f12075p == z7) {
            this.f12075p = !z7;
            M(X());
            L();
        }
    }

    public void R() {
        if (J() && K()) {
            N();
            t();
            if (this.f12067h != null) {
                g().startActivity(this.f12067h);
            }
        }
    }

    public void S(View view) {
        R();
    }

    public boolean T(boolean z7) {
        if (!Y()) {
            return false;
        }
        if (z7 == m(!z7)) {
            return true;
        }
        r();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean U(int i8) {
        if (!Y()) {
            return false;
        }
        if (i8 == n(~i8)) {
            return true;
        }
        r();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public boolean V(String str) {
        if (!Y()) {
            return false;
        }
        Object obj = null;
        if (TextUtils.equals(str, q(null))) {
            return true;
        }
        r();
        obj.getClass();
        throw null;
    }

    public final void W(b bVar) {
        this.f12058B = bVar;
        L();
    }

    public boolean X() {
        return !J();
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
        int i8 = this.f12061b;
        int i9 = preference.f12061b;
        if (i8 != i9) {
            return i8 - i9;
        }
        CharSequence charSequence = this.f12063d;
        CharSequence charSequence2 = preference.f12063d;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f12063d.toString());
    }

    public Context g() {
        return this.f12060a;
    }

    public StringBuilder i() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceH = H();
        if (!TextUtils.isEmpty(charSequenceH)) {
            sb.append(charSequenceH);
            sb.append(' ');
        }
        CharSequence charSequenceW = w();
        if (!TextUtils.isEmpty(charSequenceW)) {
            sb.append(charSequenceW);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public String k() {
        return this.f12068i;
    }

    public Intent l() {
        return this.f12067h;
    }

    public boolean m(boolean z7) {
        if (!Y()) {
            return z7;
        }
        r();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public int n(int i8) {
        if (!Y()) {
            return i8;
        }
        r();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public String q(String str) {
        if (!Y()) {
            return str;
        }
        r();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public AbstractC2681a r() {
        return null;
    }

    public AbstractC2682b t() {
        return null;
    }

    public String toString() {
        return i().toString();
    }

    public CharSequence w() {
        return B() != null ? B().a(this) : this.f12064e;
    }

    public Preference(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Preference(android.content.Context r5, android.util.AttributeSet r6, int r7, int r8) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }
}
