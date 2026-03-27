package com.google.android.material.textfield;

import D2.f;
import D2.g;
import D2.q;
import D2.s;
import D2.t;
import D2.v;
import D2.x;
import Q.AbstractC0680v;
import Q.N;
import R.AbstractC0687c;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import j.AbstractC2040a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import n2.e;
import n2.h;
import p.C2358t;
import p.S;
import y2.j;
import y2.l;
import z2.AbstractC2881c;

/* JADX INFO: loaded from: classes.dex */
public class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f11750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f11751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f11752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f11753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f11754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f11755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f11756g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f11757h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11758i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f11759j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f11760k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f11761l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View.OnLongClickListener f11762m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f11763n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f11764o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11765p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public EditText f11766q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AccessibilityManager f11767r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AbstractC0687c.a f11768s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final TextWatcher f11769t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextInputLayout.g f11770u;

    /* JADX INFO: renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    public class C0190a extends j {
        public C0190a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            a.this.m().a(editable);
        }

        @Override // y2.j, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            a.this.m().b(charSequence, i7, i8, i9);
        }
    }

    public class b implements TextInputLayout.g {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout) {
            if (a.this.f11766q == textInputLayout.getEditText()) {
                return;
            }
            if (a.this.f11766q != null) {
                a.this.f11766q.removeTextChangedListener(a.this.f11769t);
                if (a.this.f11766q.getOnFocusChangeListener() == a.this.m().e()) {
                    a.this.f11766q.setOnFocusChangeListener(null);
                }
            }
            a.this.f11766q = textInputLayout.getEditText();
            if (a.this.f11766q != null) {
                a.this.f11766q.addTextChangedListener(a.this.f11769t);
            }
            a.this.m().n(a.this.f11766q);
            a aVar = a.this;
            aVar.c0(aVar.m());
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a.this.J();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray f11774a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f11775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f11777d;

        public d(a aVar, S s7) {
            this.f11775b = aVar;
            this.f11776c = s7.m(n2.j.f19417W4, 0);
            this.f11777d = s7.m(n2.j.f19561r5, 0);
        }

        public final s b(int i7) {
            if (i7 == -1) {
                return new g(this.f11775b);
            }
            if (i7 == 0) {
                return new v(this.f11775b);
            }
            if (i7 == 1) {
                return new x(this.f11775b, this.f11777d);
            }
            if (i7 == 2) {
                return new f(this.f11775b);
            }
            if (i7 == 3) {
                return new q(this.f11775b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i7);
        }

        public s c(int i7) {
            s sVar = (s) this.f11774a.get(i7);
            if (sVar != null) {
                return sVar;
            }
            s sVarB = b(i7);
            this.f11774a.append(i7, sVarB);
            return sVarB;
        }
    }

    public a(TextInputLayout textInputLayout, S s7) {
        super(textInputLayout.getContext());
        this.f11758i = 0;
        this.f11759j = new LinkedHashSet();
        this.f11769t = new C0190a();
        b bVar = new b();
        this.f11770u = bVar;
        this.f11767r = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f11750a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f11751b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonI = i(this, layoutInflaterFrom, e.f19181G);
        this.f11752c = checkableImageButtonI;
        CheckableImageButton checkableImageButtonI2 = i(frameLayout, layoutInflaterFrom, e.f19180F);
        this.f11756g = checkableImageButtonI2;
        this.f11757h = new d(this, s7);
        C2358t c2358t = new C2358t(getContext());
        this.f11764o = c2358t;
        z(s7);
        y(s7);
        A(s7);
        frameLayout.addView(checkableImageButtonI2);
        addView(c2358t);
        addView(frameLayout);
        addView(checkableImageButtonI);
        textInputLayout.h(bVar);
        addOnAttachStateChangeListener(new c());
    }

    public final void A(S s7) {
        this.f11764o.setVisibility(8);
        this.f11764o.setId(e.f19187M);
        this.f11764o.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        N.n0(this.f11764o, 1);
        l0(s7.m(n2.j.f19313H5, 0));
        if (s7.q(n2.j.f19320I5)) {
            m0(s7.c(n2.j.f19320I5));
        }
        k0(s7.o(n2.j.f19306G5));
    }

    public boolean B() {
        return x() && this.f11756g.isChecked();
    }

    public boolean C() {
        return this.f11751b.getVisibility() == 0 && this.f11756g.getVisibility() == 0;
    }

    public boolean D() {
        return this.f11752c.getVisibility() == 0;
    }

    public void E(boolean z7) {
        this.f11765p = z7;
        t0();
    }

    public void F() {
        r0();
        H();
        G();
        if (m().t()) {
            p0(this.f11750a.b0());
        }
    }

    public void G() {
        t.c(this.f11750a, this.f11756g, this.f11760k);
    }

    public void H() {
        t.c(this.f11750a, this.f11752c, this.f11753d);
    }

    public void I(boolean z7) {
        boolean z8;
        boolean zIsActivated;
        boolean zIsChecked;
        s sVarM = m();
        boolean z9 = true;
        if (!sVarM.l() || (zIsChecked = this.f11756g.isChecked()) == sVarM.m()) {
            z8 = false;
        } else {
            this.f11756g.setChecked(!zIsChecked);
            z8 = true;
        }
        if (!sVarM.j() || (zIsActivated = this.f11756g.isActivated()) == sVarM.k()) {
            z9 = z8;
        } else {
            K(!zIsActivated);
        }
        if (z7 || z9) {
            G();
        }
    }

    public final void J() {
        AccessibilityManager accessibilityManager;
        AbstractC0687c.a aVar = this.f11768s;
        if (aVar == null || (accessibilityManager = this.f11767r) == null) {
            return;
        }
        AbstractC0687c.b(accessibilityManager, aVar);
    }

    public void K(boolean z7) {
        this.f11756g.setActivated(z7);
    }

    public void L(boolean z7) {
        this.f11756g.setCheckable(z7);
    }

    public void M(int i7) {
        N(i7 != 0 ? getResources().getText(i7) : null);
    }

    public void N(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f11756g.setContentDescription(charSequence);
        }
    }

    public void O(int i7) {
        P(i7 != 0 ? AbstractC2040a.b(getContext(), i7) : null);
    }

    public void P(Drawable drawable) {
        this.f11756g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f11750a, this.f11756g, this.f11760k, this.f11761l);
            G();
        }
    }

    public void Q(int i7) {
        if (this.f11758i == i7) {
            return;
        }
        o0(m());
        int i8 = this.f11758i;
        this.f11758i = i7;
        j(i8);
        V(i7 != 0);
        s sVarM = m();
        O(r(sVarM));
        M(sVarM.c());
        L(sVarM.l());
        if (!sVarM.i(this.f11750a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f11750a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i7);
        }
        n0(sVarM);
        R(sVarM.f());
        EditText editText = this.f11766q;
        if (editText != null) {
            sVarM.n(editText);
            c0(sVarM);
        }
        t.a(this.f11750a, this.f11756g, this.f11760k, this.f11761l);
        I(true);
    }

    public void R(View.OnClickListener onClickListener) {
        t.f(this.f11756g, onClickListener, this.f11762m);
    }

    public void S(View.OnLongClickListener onLongClickListener) {
        this.f11762m = onLongClickListener;
        t.g(this.f11756g, onLongClickListener);
    }

    public void T(ColorStateList colorStateList) {
        if (this.f11760k != colorStateList) {
            this.f11760k = colorStateList;
            t.a(this.f11750a, this.f11756g, colorStateList, this.f11761l);
        }
    }

    public void U(PorterDuff.Mode mode) {
        if (this.f11761l != mode) {
            this.f11761l = mode;
            t.a(this.f11750a, this.f11756g, this.f11760k, mode);
        }
    }

    public void V(boolean z7) {
        if (C() != z7) {
            this.f11756g.setVisibility(z7 ? 0 : 8);
            q0();
            s0();
            this.f11750a.l0();
        }
    }

    public void W(int i7) {
        X(i7 != 0 ? AbstractC2040a.b(getContext(), i7) : null);
        H();
    }

    public void X(Drawable drawable) {
        this.f11752c.setImageDrawable(drawable);
        r0();
        t.a(this.f11750a, this.f11752c, this.f11753d, this.f11754e);
    }

    public void Y(View.OnClickListener onClickListener) {
        t.f(this.f11752c, onClickListener, this.f11755f);
    }

    public void Z(View.OnLongClickListener onLongClickListener) {
        this.f11755f = onLongClickListener;
        t.g(this.f11752c, onLongClickListener);
    }

    public void a0(ColorStateList colorStateList) {
        if (this.f11753d != colorStateList) {
            this.f11753d = colorStateList;
            t.a(this.f11750a, this.f11752c, colorStateList, this.f11754e);
        }
    }

    public void b0(PorterDuff.Mode mode) {
        if (this.f11754e != mode) {
            this.f11754e = mode;
            t.a(this.f11750a, this.f11752c, this.f11753d, mode);
        }
    }

    public final void c0(s sVar) {
        if (this.f11766q == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f11766q.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f11756g.setOnFocusChangeListener(sVar.g());
        }
    }

    public void d0(int i7) {
        e0(i7 != 0 ? getResources().getText(i7) : null);
    }

    public void e0(CharSequence charSequence) {
        this.f11756g.setContentDescription(charSequence);
    }

    public void f0(int i7) {
        g0(i7 != 0 ? AbstractC2040a.b(getContext(), i7) : null);
    }

    public final void g() {
        if (this.f11768s == null || this.f11767r == null || !N.O(this)) {
            return;
        }
        AbstractC0687c.a(this.f11767r, this.f11768s);
    }

    public void g0(Drawable drawable) {
        this.f11756g.setImageDrawable(drawable);
    }

    public void h() {
        this.f11756g.performClick();
        this.f11756g.jumpDrawablesToCurrentState();
    }

    public void h0(boolean z7) {
        if (z7 && this.f11758i != 1) {
            Q(1);
        } else {
            if (z7) {
                return;
            }
            Q(0);
        }
    }

    public final CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i7) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(n2.g.f19216b, viewGroup, false);
        checkableImageButton.setId(i7);
        t.d(checkableImageButton);
        if (AbstractC2881c.f(getContext())) {
            AbstractC0680v.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public void i0(ColorStateList colorStateList) {
        this.f11760k = colorStateList;
        t.a(this.f11750a, this.f11756g, colorStateList, this.f11761l);
    }

    public final void j(int i7) {
        Iterator it = this.f11759j.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public void j0(PorterDuff.Mode mode) {
        this.f11761l = mode;
        t.a(this.f11750a, this.f11756g, this.f11760k, mode);
    }

    public CheckableImageButton k() {
        if (D()) {
            return this.f11752c;
        }
        if (x() && C()) {
            return this.f11756g;
        }
        return null;
    }

    public void k0(CharSequence charSequence) {
        this.f11763n = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f11764o.setText(charSequence);
        t0();
    }

    public CharSequence l() {
        return this.f11756g.getContentDescription();
    }

    public void l0(int i7) {
        V.g.n(this.f11764o, i7);
    }

    public s m() {
        return this.f11757h.c(this.f11758i);
    }

    public void m0(ColorStateList colorStateList) {
        this.f11764o.setTextColor(colorStateList);
    }

    public Drawable n() {
        return this.f11756g.getDrawable();
    }

    public final void n0(s sVar) {
        sVar.s();
        this.f11768s = sVar.h();
        g();
    }

    public int o() {
        return this.f11758i;
    }

    public final void o0(s sVar) {
        J();
        this.f11768s = null;
        sVar.u();
    }

    public CheckableImageButton p() {
        return this.f11756g;
    }

    public final void p0(boolean z7) {
        if (!z7 || n() == null) {
            t.a(this.f11750a, this.f11756g, this.f11760k, this.f11761l);
            return;
        }
        Drawable drawableMutate = J.a.l(n()).mutate();
        J.a.h(drawableMutate, this.f11750a.getErrorCurrentTextColors());
        this.f11756g.setImageDrawable(drawableMutate);
    }

    public Drawable q() {
        return this.f11752c.getDrawable();
    }

    public final void q0() {
        this.f11751b.setVisibility((this.f11756g.getVisibility() != 0 || D()) ? 8 : 0);
        setVisibility((C() || D() || ((this.f11763n == null || this.f11765p) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final int r(s sVar) {
        int i7 = this.f11757h.f11776c;
        return i7 == 0 ? sVar.d() : i7;
    }

    public final void r0() {
        this.f11752c.setVisibility(q() != null && this.f11750a.M() && this.f11750a.b0() ? 0 : 8);
        q0();
        s0();
        if (x()) {
            return;
        }
        this.f11750a.l0();
    }

    public CharSequence s() {
        return this.f11756g.getContentDescription();
    }

    public void s0() {
        if (this.f11750a.f11699d == null) {
            return;
        }
        N.A0(this.f11764o, getContext().getResources().getDimensionPixelSize(n2.c.f19160s), this.f11750a.f11699d.getPaddingTop(), (C() || D()) ? 0 : N.D(this.f11750a.f11699d), this.f11750a.f11699d.getPaddingBottom());
    }

    public Drawable t() {
        return this.f11756g.getDrawable();
    }

    public final void t0() {
        int visibility = this.f11764o.getVisibility();
        int i7 = (this.f11763n == null || this.f11765p) ? 8 : 0;
        if (visibility != i7) {
            m().q(i7 == 0);
        }
        q0();
        this.f11764o.setVisibility(i7);
        this.f11750a.l0();
    }

    public CharSequence u() {
        return this.f11763n;
    }

    public ColorStateList v() {
        return this.f11764o.getTextColors();
    }

    public TextView w() {
        return this.f11764o;
    }

    public boolean x() {
        return this.f11758i != 0;
    }

    public final void y(S s7) {
        if (!s7.q(n2.j.f19568s5)) {
            if (s7.q(n2.j.f19429Y4)) {
                this.f11760k = AbstractC2881c.b(getContext(), s7, n2.j.f19429Y4);
            }
            if (s7.q(n2.j.f19435Z4)) {
                this.f11761l = l.f(s7.j(n2.j.f19435Z4, -1), null);
            }
        }
        if (s7.q(n2.j.f19423X4)) {
            Q(s7.j(n2.j.f19423X4, 0));
            if (s7.q(n2.j.f19410V4)) {
                N(s7.o(n2.j.f19410V4));
            }
            L(s7.a(n2.j.f19403U4, true));
            return;
        }
        if (s7.q(n2.j.f19568s5)) {
            if (s7.q(n2.j.f19575t5)) {
                this.f11760k = AbstractC2881c.b(getContext(), s7, n2.j.f19575t5);
            }
            if (s7.q(n2.j.f19582u5)) {
                this.f11761l = l.f(s7.j(n2.j.f19582u5, -1), null);
            }
            Q(s7.a(n2.j.f19568s5, false) ? 1 : 0);
            N(s7.o(n2.j.f19554q5));
        }
    }

    public final void z(S s7) {
        if (s7.q(n2.j.f19463d5)) {
            this.f11753d = AbstractC2881c.b(getContext(), s7, n2.j.f19463d5);
        }
        if (s7.q(n2.j.f19470e5)) {
            this.f11754e = l.f(s7.j(n2.j.f19470e5, -1), null);
        }
        if (s7.q(n2.j.f19456c5)) {
            X(s7.g(n2.j.f19456c5));
        }
        this.f11752c.setContentDescription(getResources().getText(h.f19237f));
        N.v0(this.f11752c, 2);
        this.f11752c.setClickable(false);
        this.f11752c.setPressable(false);
        this.f11752c.setFocusable(false);
    }
}
