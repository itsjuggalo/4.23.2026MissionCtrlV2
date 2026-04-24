package androidx.appcompat.widget;

import Q.N;
import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import h.AbstractC1656a;
import h.AbstractC1659d;
import h.AbstractC1662g;
import h.AbstractC1664i;
import j.AbstractC2040a;
import o.C2279a;
import p.InterfaceC2362x;
import p.S;

/* JADX INFO: loaded from: classes.dex */
public class d implements InterfaceC2362x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toolbar f6959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f6962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f6963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f6966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f6967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f6968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Window.Callback f6969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6971m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f6973o;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2279a f6974a;

        public a() {
            this.f6974a = new C2279a(d.this.f6959a.getContext(), 0, R.id.home, 0, 0, d.this.f6966h);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = d.this;
            Window.Callback callback = dVar.f6969k;
            if (callback == null || !dVar.f6970l) {
                return;
            }
            callback.onMenuItemSelected(0, this.f6974a);
        }
    }

    public d(Toolbar toolbar, boolean z7) {
        this(toolbar, z7, AbstractC1662g.f14460a, AbstractC1659d.f14406n);
    }

    @Override // p.InterfaceC2362x
    public void a(CharSequence charSequence) {
        if (this.f6965g) {
            return;
        }
        o(charSequence);
    }

    @Override // p.InterfaceC2362x
    public void b(int i7) {
        i(i7 != 0 ? AbstractC2040a.b(e(), i7) : null);
    }

    @Override // p.InterfaceC2362x
    public void c(Window.Callback callback) {
        this.f6969k = callback;
    }

    public final int d() {
        if (this.f6959a.getNavigationIcon() == null) {
            return 11;
        }
        this.f6973o = this.f6959a.getNavigationIcon();
        return 15;
    }

    public Context e() {
        return this.f6959a.getContext();
    }

    public void f(View view) {
        View view2 = this.f6961c;
        if (view2 != null && (this.f6960b & 16) != 0) {
            this.f6959a.removeView(view2);
        }
        this.f6961c = view;
        if (view == null || (this.f6960b & 16) == 0) {
            return;
        }
        this.f6959a.addView(view);
    }

    public void g(int i7) {
        if (i7 == this.f6972n) {
            return;
        }
        this.f6972n = i7;
        if (TextUtils.isEmpty(this.f6959a.getNavigationContentDescription())) {
            j(this.f6972n);
        }
    }

    @Override // p.InterfaceC2362x
    public CharSequence getTitle() {
        return this.f6959a.getTitle();
    }

    public void h(int i7) {
        View view;
        int i8 = this.f6960b ^ i7;
        this.f6960b = i7;
        if (i8 != 0) {
            if ((i8 & 4) != 0) {
                if ((i7 & 4) != 0) {
                    p();
                }
                q();
            }
            if ((i8 & 3) != 0) {
                r();
            }
            if ((i8 & 8) != 0) {
                if ((i7 & 8) != 0) {
                    this.f6959a.setTitle(this.f6966h);
                    this.f6959a.setSubtitle(this.f6967i);
                } else {
                    this.f6959a.setTitle((CharSequence) null);
                    this.f6959a.setSubtitle((CharSequence) null);
                }
            }
            if ((i8 & 16) == 0 || (view = this.f6961c) == null) {
                return;
            }
            if ((i7 & 16) != 0) {
                this.f6959a.addView(view);
            } else {
                this.f6959a.removeView(view);
            }
        }
    }

    public void i(Drawable drawable) {
        this.f6963e = drawable;
        r();
    }

    public void j(int i7) {
        k(i7 == 0 ? null : e().getString(i7));
    }

    public void k(CharSequence charSequence) {
        this.f6968j = charSequence;
        p();
    }

    public void l(Drawable drawable) {
        this.f6964f = drawable;
        q();
    }

    public void m(CharSequence charSequence) {
        this.f6967i = charSequence;
        if ((this.f6960b & 8) != 0) {
            this.f6959a.setSubtitle(charSequence);
        }
    }

    public void n(CharSequence charSequence) {
        this.f6965g = true;
        o(charSequence);
    }

    public final void o(CharSequence charSequence) {
        this.f6966h = charSequence;
        if ((this.f6960b & 8) != 0) {
            this.f6959a.setTitle(charSequence);
            if (this.f6965g) {
                N.o0(this.f6959a.getRootView(), charSequence);
            }
        }
    }

    public final void p() {
        if ((this.f6960b & 4) != 0) {
            if (TextUtils.isEmpty(this.f6968j)) {
                this.f6959a.setNavigationContentDescription(this.f6972n);
            } else {
                this.f6959a.setNavigationContentDescription(this.f6968j);
            }
        }
    }

    public final void q() {
        if ((this.f6960b & 4) == 0) {
            this.f6959a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f6959a;
        Drawable drawable = this.f6964f;
        if (drawable == null) {
            drawable = this.f6973o;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void r() {
        Drawable drawable;
        int i7 = this.f6960b;
        if ((i7 & 2) == 0) {
            drawable = null;
        } else if ((i7 & 1) == 0 || (drawable = this.f6963e) == null) {
            drawable = this.f6962d;
        }
        this.f6959a.setLogo(drawable);
    }

    @Override // p.InterfaceC2362x
    public void setIcon(int i7) {
        setIcon(i7 != 0 ? AbstractC2040a.b(e(), i7) : null);
    }

    public d(Toolbar toolbar, boolean z7, int i7, int i8) {
        Drawable drawable;
        this.f6971m = 0;
        this.f6972n = 0;
        this.f6959a = toolbar;
        this.f6966h = toolbar.getTitle();
        this.f6967i = toolbar.getSubtitle();
        this.f6965g = this.f6966h != null;
        this.f6964f = toolbar.getNavigationIcon();
        S sT = S.t(toolbar.getContext(), null, AbstractC1664i.f14580a, AbstractC1656a.f14336c, 0);
        this.f6973o = sT.g(AbstractC1664i.f14622j);
        if (z7) {
            CharSequence charSequenceO = sT.o(AbstractC1664i.f14646p);
            if (!TextUtils.isEmpty(charSequenceO)) {
                n(charSequenceO);
            }
            CharSequence charSequenceO2 = sT.o(AbstractC1664i.f14638n);
            if (!TextUtils.isEmpty(charSequenceO2)) {
                m(charSequenceO2);
            }
            Drawable drawableG = sT.g(AbstractC1664i.f14630l);
            if (drawableG != null) {
                i(drawableG);
            }
            Drawable drawableG2 = sT.g(AbstractC1664i.f14626k);
            if (drawableG2 != null) {
                setIcon(drawableG2);
            }
            if (this.f6964f == null && (drawable = this.f6973o) != null) {
                l(drawable);
            }
            h(sT.j(AbstractC1664i.f14614h, 0));
            int iM = sT.m(AbstractC1664i.f14610g, 0);
            if (iM != 0) {
                f(LayoutInflater.from(this.f6959a.getContext()).inflate(iM, (ViewGroup) this.f6959a, false));
                h(this.f6960b | 16);
            }
            int iL = sT.l(AbstractC1664i.f14618i, 0);
            if (iL > 0) {
                ViewGroup.LayoutParams layoutParams = this.f6959a.getLayoutParams();
                layoutParams.height = iL;
                this.f6959a.setLayoutParams(layoutParams);
            }
            int iE = sT.e(AbstractC1664i.f14605f, -1);
            int iE2 = sT.e(AbstractC1664i.f14600e, -1);
            if (iE >= 0 || iE2 >= 0) {
                this.f6959a.H(Math.max(iE, 0), Math.max(iE2, 0));
            }
            int iM2 = sT.m(AbstractC1664i.f14650q, 0);
            if (iM2 != 0) {
                Toolbar toolbar2 = this.f6959a;
                toolbar2.J(toolbar2.getContext(), iM2);
            }
            int iM3 = sT.m(AbstractC1664i.f14642o, 0);
            if (iM3 != 0) {
                Toolbar toolbar3 = this.f6959a;
                toolbar3.I(toolbar3.getContext(), iM3);
            }
            int iM4 = sT.m(AbstractC1664i.f14634m, 0);
            if (iM4 != 0) {
                this.f6959a.setPopupTheme(iM4);
            }
        } else {
            this.f6960b = d();
        }
        sT.u();
        g(i7);
        this.f6968j = this.f6959a.getNavigationContentDescription();
        this.f6959a.setNavigationOnClickListener(new a());
    }

    @Override // p.InterfaceC2362x
    public void setIcon(Drawable drawable) {
        this.f6962d = drawable;
        r();
    }
}
