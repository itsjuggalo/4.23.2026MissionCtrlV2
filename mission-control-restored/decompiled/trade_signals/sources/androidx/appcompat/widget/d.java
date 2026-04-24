package androidx.appcompat.widget;

import T.D;
import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import g.AbstractC1764a;
import g.AbstractC1767d;
import g.AbstractC1770g;
import g.i;
import i.AbstractC1906a;
import n.C2384a;
import o.InterfaceC2449s;
import o.L;

/* JADX INFO: loaded from: classes.dex */
public class d implements InterfaceC2449s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f10786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f10788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f10789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f10790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f10791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f10793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f10794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f10795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f10796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10799n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f10800o;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2384a f10801a;

        public a() {
            this.f10801a = new C2384a(d.this.f10786a.getContext(), 0, R.id.home, 0, 0, d.this.f10793h);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = d.this;
            Window.Callback callback = dVar.f10796k;
            if (callback == null || !dVar.f10797l) {
                return;
            }
            callback.onMenuItemSelected(0, this.f10801a);
        }
    }

    public d(Toolbar toolbar, boolean z7) {
        this(toolbar, z7, AbstractC1770g.f17757a, AbstractC1767d.f17715n);
    }

    @Override // o.InterfaceC2449s
    public void a(CharSequence charSequence) {
        if (this.f10792g) {
            return;
        }
        o(charSequence);
    }

    @Override // o.InterfaceC2449s
    public void b(int i8) {
        i(i8 != 0 ? AbstractC1906a.b(e(), i8) : null);
    }

    @Override // o.InterfaceC2449s
    public void c(Window.Callback callback) {
        this.f10796k = callback;
    }

    public final int d() {
        if (this.f10786a.getNavigationIcon() == null) {
            return 11;
        }
        this.f10800o = this.f10786a.getNavigationIcon();
        return 15;
    }

    public Context e() {
        return this.f10786a.getContext();
    }

    public void f(View view) {
        View view2 = this.f10788c;
        if (view2 != null && (this.f10787b & 16) != 0) {
            this.f10786a.removeView(view2);
        }
        this.f10788c = view;
        if (view == null || (this.f10787b & 16) == 0) {
            return;
        }
        this.f10786a.addView(view);
    }

    public void g(int i8) {
        if (i8 == this.f10799n) {
            return;
        }
        this.f10799n = i8;
        if (TextUtils.isEmpty(this.f10786a.getNavigationContentDescription())) {
            j(this.f10799n);
        }
    }

    @Override // o.InterfaceC2449s
    public CharSequence getTitle() {
        return this.f10786a.getTitle();
    }

    public void h(int i8) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i9 = this.f10787b ^ i8;
        this.f10787b = i8;
        if (i9 != 0) {
            if ((i9 & 4) != 0) {
                if ((i8 & 4) != 0) {
                    p();
                }
                q();
            }
            if ((i9 & 3) != 0) {
                r();
            }
            if ((i9 & 8) != 0) {
                if ((i8 & 8) != 0) {
                    this.f10786a.setTitle(this.f10793h);
                    toolbar = this.f10786a;
                    charSequence = this.f10794i;
                } else {
                    charSequence = null;
                    this.f10786a.setTitle((CharSequence) null);
                    toolbar = this.f10786a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i9 & 16) == 0 || (view = this.f10788c) == null) {
                return;
            }
            if ((i8 & 16) != 0) {
                this.f10786a.addView(view);
            } else {
                this.f10786a.removeView(view);
            }
        }
    }

    public void i(Drawable drawable) {
        this.f10790e = drawable;
        r();
    }

    public void j(int i8) {
        k(i8 == 0 ? null : e().getString(i8));
    }

    public void k(CharSequence charSequence) {
        this.f10795j = charSequence;
        p();
    }

    public void l(Drawable drawable) {
        this.f10791f = drawable;
        q();
    }

    public void m(CharSequence charSequence) {
        this.f10794i = charSequence;
        if ((this.f10787b & 8) != 0) {
            this.f10786a.setSubtitle(charSequence);
        }
    }

    public void n(CharSequence charSequence) {
        this.f10792g = true;
        o(charSequence);
    }

    public final void o(CharSequence charSequence) {
        this.f10793h = charSequence;
        if ((this.f10787b & 8) != 0) {
            this.f10786a.setTitle(charSequence);
            if (this.f10792g) {
                D.L(this.f10786a.getRootView(), charSequence);
            }
        }
    }

    public final void p() {
        if ((this.f10787b & 4) != 0) {
            if (TextUtils.isEmpty(this.f10795j)) {
                this.f10786a.setNavigationContentDescription(this.f10799n);
            } else {
                this.f10786a.setNavigationContentDescription(this.f10795j);
            }
        }
    }

    public final void q() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f10787b & 4) != 0) {
            toolbar = this.f10786a;
            drawable = this.f10791f;
            if (drawable == null) {
                drawable = this.f10800o;
            }
        } else {
            toolbar = this.f10786a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void r() {
        Drawable drawable;
        int i8 = this.f10787b;
        if ((i8 & 2) == 0) {
            drawable = null;
        } else if ((i8 & 1) == 0 || (drawable = this.f10790e) == null) {
            drawable = this.f10789d;
        }
        this.f10786a.setLogo(drawable);
    }

    @Override // o.InterfaceC2449s
    public void setIcon(int i8) {
        setIcon(i8 != 0 ? AbstractC1906a.b(e(), i8) : null);
    }

    public d(Toolbar toolbar, boolean z7, int i8, int i9) {
        Drawable drawable;
        this.f10798m = 0;
        this.f10799n = 0;
        this.f10786a = toolbar;
        this.f10793h = toolbar.getTitle();
        this.f10794i = toolbar.getSubtitle();
        this.f10792g = this.f10793h != null;
        this.f10791f = toolbar.getNavigationIcon();
        L lS = L.s(toolbar.getContext(), null, i.f17861a, AbstractC1764a.f17652c, 0);
        this.f10800o = lS.f(i.f17897j);
        if (z7) {
            CharSequence charSequenceN = lS.n(i.f17921p);
            if (!TextUtils.isEmpty(charSequenceN)) {
                n(charSequenceN);
            }
            CharSequence charSequenceN2 = lS.n(i.f17913n);
            if (!TextUtils.isEmpty(charSequenceN2)) {
                m(charSequenceN2);
            }
            Drawable drawableF = lS.f(i.f17905l);
            if (drawableF != null) {
                i(drawableF);
            }
            Drawable drawableF2 = lS.f(i.f17901k);
            if (drawableF2 != null) {
                setIcon(drawableF2);
            }
            if (this.f10791f == null && (drawable = this.f10800o) != null) {
                l(drawable);
            }
            h(lS.i(i.f17889h, 0));
            int iL = lS.l(i.f17885g, 0);
            if (iL != 0) {
                f(LayoutInflater.from(this.f10786a.getContext()).inflate(iL, (ViewGroup) this.f10786a, false));
                h(this.f10787b | 16);
            }
            int iK = lS.k(i.f17893i, 0);
            if (iK > 0) {
                ViewGroup.LayoutParams layoutParams = this.f10786a.getLayoutParams();
                layoutParams.height = iK;
                this.f10786a.setLayoutParams(layoutParams);
            }
            int iD = lS.d(i.f17881f, -1);
            int iD2 = lS.d(i.f17877e, -1);
            if (iD >= 0 || iD2 >= 0) {
                this.f10786a.F(Math.max(iD, 0), Math.max(iD2, 0));
            }
            int iL2 = lS.l(i.f17925q, 0);
            if (iL2 != 0) {
                Toolbar toolbar2 = this.f10786a;
                toolbar2.H(toolbar2.getContext(), iL2);
            }
            int iL3 = lS.l(i.f17917o, 0);
            if (iL3 != 0) {
                Toolbar toolbar3 = this.f10786a;
                toolbar3.G(toolbar3.getContext(), iL3);
            }
            int iL4 = lS.l(i.f17909m, 0);
            if (iL4 != 0) {
                this.f10786a.setPopupTheme(iL4);
            }
        } else {
            this.f10787b = d();
        }
        lS.u();
        g(i8);
        this.f10795j = this.f10786a.getNavigationContentDescription();
        this.f10786a.setNavigationOnClickListener(new a());
    }

    @Override // o.InterfaceC2449s
    public void setIcon(Drawable drawable) {
        this.f10789d = drawable;
        r();
    }
}
