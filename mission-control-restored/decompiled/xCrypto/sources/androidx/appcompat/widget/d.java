package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import g.AbstractC1248a;
import g.AbstractC1251d;
import g.g;
import g.i;
import i.AbstractC1284a;
import n.C1610a;
import o.InterfaceC1634A;
import o.a0;

/* JADX INFO: loaded from: classes.dex */
public class d implements InterfaceC1634A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f6797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f6800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f6801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f6804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f6805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f6806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f6807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6808l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6809m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f6811o;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1610a f6812a;

        public a() {
            this.f6812a = new C1610a(d.this.f6797a.getContext(), 0, R.id.home, 0, 0, d.this.f6804h);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = d.this;
            Window.Callback callback = dVar.f6807k;
            if (callback == null || !dVar.f6808l) {
                return;
            }
            callback.onMenuItemSelected(0, this.f6812a);
        }
    }

    public d(Toolbar toolbar, boolean z4) {
        this(toolbar, z4, g.f11665a, AbstractC1251d.f11611n);
    }

    @Override // o.InterfaceC1634A
    public void a(CharSequence charSequence) {
        if (this.f6803g) {
            return;
        }
        o(charSequence);
    }

    @Override // o.InterfaceC1634A
    public void b(int i4) {
        i(i4 != 0 ? AbstractC1284a.b(e(), i4) : null);
    }

    @Override // o.InterfaceC1634A
    public void c(Window.Callback callback) {
        this.f6807k = callback;
    }

    public final int d() {
        if (this.f6797a.getNavigationIcon() == null) {
            return 11;
        }
        this.f6811o = this.f6797a.getNavigationIcon();
        return 15;
    }

    public Context e() {
        return this.f6797a.getContext();
    }

    public void f(View view) {
        View view2 = this.f6799c;
        if (view2 != null && (this.f6798b & 16) != 0) {
            this.f6797a.removeView(view2);
        }
        this.f6799c = view;
        if (view == null || (this.f6798b & 16) == 0) {
            return;
        }
        this.f6797a.addView(view);
    }

    public void g(int i4) {
        if (i4 == this.f6810n) {
            return;
        }
        this.f6810n = i4;
        if (TextUtils.isEmpty(this.f6797a.getNavigationContentDescription())) {
            j(this.f6810n);
        }
    }

    @Override // o.InterfaceC1634A
    public CharSequence getTitle() {
        return this.f6797a.getTitle();
    }

    public void h(int i4) {
        View view;
        int i5 = this.f6798b ^ i4;
        this.f6798b = i4;
        if (i5 != 0) {
            if ((i5 & 4) != 0) {
                if ((i4 & 4) != 0) {
                    p();
                }
                q();
            }
            if ((i5 & 3) != 0) {
                r();
            }
            if ((i5 & 8) != 0) {
                if ((i4 & 8) != 0) {
                    this.f6797a.setTitle(this.f6804h);
                    this.f6797a.setSubtitle(this.f6805i);
                } else {
                    this.f6797a.setTitle((CharSequence) null);
                    this.f6797a.setSubtitle((CharSequence) null);
                }
            }
            if ((i5 & 16) == 0 || (view = this.f6799c) == null) {
                return;
            }
            if ((i4 & 16) != 0) {
                this.f6797a.addView(view);
            } else {
                this.f6797a.removeView(view);
            }
        }
    }

    public void i(Drawable drawable) {
        this.f6801e = drawable;
        r();
    }

    public void j(int i4) {
        k(i4 == 0 ? null : e().getString(i4));
    }

    public void k(CharSequence charSequence) {
        this.f6806j = charSequence;
        p();
    }

    public void l(Drawable drawable) {
        this.f6802f = drawable;
        q();
    }

    public void m(CharSequence charSequence) {
        this.f6805i = charSequence;
        if ((this.f6798b & 8) != 0) {
            this.f6797a.setSubtitle(charSequence);
        }
    }

    public void n(CharSequence charSequence) {
        this.f6803g = true;
        o(charSequence);
    }

    public final void o(CharSequence charSequence) {
        this.f6804h = charSequence;
        if ((this.f6798b & 8) != 0) {
            this.f6797a.setTitle(charSequence);
        }
    }

    public final void p() {
        if ((this.f6798b & 4) != 0) {
            if (TextUtils.isEmpty(this.f6806j)) {
                this.f6797a.setNavigationContentDescription(this.f6810n);
            } else {
                this.f6797a.setNavigationContentDescription(this.f6806j);
            }
        }
    }

    public final void q() {
        if ((this.f6798b & 4) == 0) {
            this.f6797a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f6797a;
        Drawable drawable = this.f6802f;
        if (drawable == null) {
            drawable = this.f6811o;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void r() {
        Drawable drawable;
        int i4 = this.f6798b;
        if ((i4 & 2) == 0) {
            drawable = null;
        } else if ((i4 & 1) == 0 || (drawable = this.f6801e) == null) {
            drawable = this.f6800d;
        }
        this.f6797a.setLogo(drawable);
    }

    @Override // o.InterfaceC1634A
    public void setIcon(int i4) {
        setIcon(i4 != 0 ? AbstractC1284a.b(e(), i4) : null);
    }

    public d(Toolbar toolbar, boolean z4, int i4, int i5) {
        Drawable drawable;
        this.f6809m = 0;
        this.f6810n = 0;
        this.f6797a = toolbar;
        this.f6804h = toolbar.getTitle();
        this.f6805i = toolbar.getSubtitle();
        this.f6803g = this.f6804h != null;
        this.f6802f = toolbar.getNavigationIcon();
        a0 a0VarR = a0.r(toolbar.getContext(), null, i.f11782a, AbstractC1248a.f11544c, 0);
        this.f6811o = a0VarR.f(i.f11827j);
        if (z4) {
            CharSequence charSequenceN = a0VarR.n(i.f11852p);
            if (!TextUtils.isEmpty(charSequenceN)) {
                n(charSequenceN);
            }
            CharSequence charSequenceN2 = a0VarR.n(i.f11844n);
            if (!TextUtils.isEmpty(charSequenceN2)) {
                m(charSequenceN2);
            }
            Drawable drawableF = a0VarR.f(i.f11836l);
            if (drawableF != null) {
                i(drawableF);
            }
            Drawable drawableF2 = a0VarR.f(i.f11832k);
            if (drawableF2 != null) {
                setIcon(drawableF2);
            }
            if (this.f6802f == null && (drawable = this.f6811o) != null) {
                l(drawable);
            }
            h(a0VarR.i(i.f11817h, 0));
            int iL = a0VarR.l(i.f11812g, 0);
            if (iL != 0) {
                f(LayoutInflater.from(this.f6797a.getContext()).inflate(iL, (ViewGroup) this.f6797a, false));
                h(this.f6798b | 16);
            }
            int iK = a0VarR.k(i.f11822i, 0);
            if (iK > 0) {
                ViewGroup.LayoutParams layoutParams = this.f6797a.getLayoutParams();
                layoutParams.height = iK;
                this.f6797a.setLayoutParams(layoutParams);
            }
            int iD = a0VarR.d(i.f11807f, -1);
            int iD2 = a0VarR.d(i.f11802e, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f6797a.C(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iL2 = a0VarR.l(i.f11856q, 0);
            if (iL2 != 0) {
                Toolbar toolbar2 = this.f6797a;
                toolbar2.E(toolbar2.getContext(), iL2);
            }
            int iL3 = a0VarR.l(i.f11848o, 0);
            if (iL3 != 0) {
                Toolbar toolbar3 = this.f6797a;
                toolbar3.D(toolbar3.getContext(), iL3);
            }
            int iL4 = a0VarR.l(i.f11840m, 0);
            if (iL4 != 0) {
                this.f6797a.setPopupTheme(iL4);
            }
        } else {
            this.f6798b = d();
        }
        a0VarR.s();
        g(i4);
        this.f6806j = this.f6797a.getNavigationContentDescription();
        this.f6797a.setNavigationOnClickListener(new a());
    }

    @Override // o.InterfaceC1634A
    public void setIcon(Drawable drawable) {
        this.f6800d = drawable;
        r();
    }
}
