package n;

import Q.AbstractC0683y;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;
import h.AbstractC1664i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p.AbstractC2334C;
import p.S;

/* JADX INFO: renamed from: n.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2248d extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class[] f19013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f19014f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f19015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f19016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f19017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f19018d;

    /* JADX INFO: renamed from: n.d$a */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class[] f19019c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f19021b;

        public a(Object obj, String str) {
            this.f19020a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f19021b = cls.getMethod(str, f19019c);
            } catch (Exception e7) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e7);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f19021b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f19021b.invoke(this.f19020a, menuItem)).booleanValue();
                }
                this.f19021b.invoke(this.f19020a, menuItem);
                return true;
            } catch (Exception e7) {
                throw new RuntimeException(e7);
            }
        }
    }

    /* JADX INFO: renamed from: n.d$b */
    public class b {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public CharSequence f19022A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public CharSequence f19023B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public ColorStateList f19024C = null;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public PorterDuff.Mode f19025D = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f19027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19030d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19031e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19033g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19034h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19035i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19036j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f19037k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f19038l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19039m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f19040n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f19041o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f19042p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f19043q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f19044r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f19045s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f19046t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f19047u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f19048v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f19049w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f19050x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f19051y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f19052z;

        public b(Menu menu) {
            this.f19027a = menu;
            h();
        }

        public void a() {
            this.f19034h = true;
            i(this.f19027a.add(this.f19028b, this.f19035i, this.f19036j, this.f19037k));
        }

        public SubMenu b() {
            this.f19034h = true;
            SubMenu subMenuAddSubMenu = this.f19027a.addSubMenu(this.f19028b, this.f19035i, this.f19036j, this.f19037k);
            i(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        public final char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        public boolean d() {
            return this.f19034h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, C2248d.this.f19017c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e7) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e7);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C2248d.this.f19017c.obtainStyledAttributes(attributeSet, AbstractC1664i.f14513J0);
            this.f19028b = typedArrayObtainStyledAttributes.getResourceId(AbstractC1664i.f14521L0, 0);
            this.f19029c = typedArrayObtainStyledAttributes.getInt(AbstractC1664i.f14529N0, 0);
            this.f19030d = typedArrayObtainStyledAttributes.getInt(AbstractC1664i.f14533O0, 0);
            this.f19031e = typedArrayObtainStyledAttributes.getInt(AbstractC1664i.f14537P0, 0);
            this.f19032f = typedArrayObtainStyledAttributes.getBoolean(AbstractC1664i.f14525M0, true);
            this.f19033g = typedArrayObtainStyledAttributes.getBoolean(AbstractC1664i.f14517K0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            S s7 = S.s(C2248d.this.f19017c, attributeSet, AbstractC1664i.f14541Q0);
            this.f19035i = s7.m(AbstractC1664i.f14553T0, 0);
            this.f19036j = (s7.j(AbstractC1664i.f14565W0, this.f19029c) & (-65536)) | (s7.j(AbstractC1664i.f14569X0, this.f19030d) & 65535);
            this.f19037k = s7.o(AbstractC1664i.f14573Y0);
            this.f19038l = s7.o(AbstractC1664i.f14577Z0);
            this.f19039m = s7.m(AbstractC1664i.f14545R0, 0);
            this.f19040n = c(s7.n(AbstractC1664i.f14582a1));
            this.f19041o = s7.j(AbstractC1664i.f14616h1, 4096);
            this.f19042p = c(s7.n(AbstractC1664i.f14587b1));
            this.f19043q = s7.j(AbstractC1664i.f14632l1, 4096);
            if (s7.q(AbstractC1664i.f14592c1)) {
                this.f19044r = s7.a(AbstractC1664i.f14592c1, false) ? 1 : 0;
            } else {
                this.f19044r = this.f19031e;
            }
            this.f19045s = s7.a(AbstractC1664i.f14557U0, false);
            this.f19046t = s7.a(AbstractC1664i.f14561V0, this.f19032f);
            this.f19047u = s7.a(AbstractC1664i.f14549S0, this.f19033g);
            this.f19048v = s7.j(AbstractC1664i.f14636m1, -1);
            this.f19052z = s7.n(AbstractC1664i.f14597d1);
            this.f19049w = s7.m(AbstractC1664i.f14602e1, 0);
            this.f19050x = s7.n(AbstractC1664i.f14612g1);
            String strN = s7.n(AbstractC1664i.f14607f1);
            this.f19051y = strN;
            boolean z7 = strN != null;
            if (z7 && this.f19049w == 0 && this.f19050x == null) {
                android.support.v4.media.session.b.a(e(strN, C2248d.f19014f, C2248d.this.f19016b));
            } else if (z7) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f19022A = s7.o(AbstractC1664i.f14620i1);
            this.f19023B = s7.o(AbstractC1664i.f14640n1);
            if (s7.q(AbstractC1664i.f14628k1)) {
                this.f19025D = AbstractC2334C.e(s7.j(AbstractC1664i.f14628k1, -1), this.f19025D);
            } else {
                this.f19025D = null;
            }
            if (s7.q(AbstractC1664i.f14624j1)) {
                this.f19024C = s7.c(AbstractC1664i.f14624j1);
            } else {
                this.f19024C = null;
            }
            s7.u();
            this.f19034h = false;
        }

        public void h() {
            this.f19028b = 0;
            this.f19029c = 0;
            this.f19030d = 0;
            this.f19031e = 0;
            this.f19032f = true;
            this.f19033g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z7 = false;
            menuItem.setChecked(this.f19045s).setVisible(this.f19046t).setEnabled(this.f19047u).setCheckable(this.f19044r >= 1).setTitleCondensed(this.f19038l).setIcon(this.f19039m);
            int i7 = this.f19048v;
            if (i7 >= 0) {
                menuItem.setShowAsAction(i7);
            }
            if (this.f19052z != null) {
                if (C2248d.this.f19017c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(C2248d.this.b(), this.f19052z));
            }
            if (this.f19044r >= 2 && (menuItem instanceof e)) {
                ((e) menuItem).s(true);
            }
            String str = this.f19050x;
            if (str != null) {
                menuItem.setActionView((View) e(str, C2248d.f19013e, C2248d.this.f19015a));
                z7 = true;
            }
            int i8 = this.f19049w;
            if (i8 > 0) {
                if (z7) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i8);
                }
            }
            AbstractC0683y.b(menuItem, this.f19022A);
            AbstractC0683y.f(menuItem, this.f19023B);
            AbstractC0683y.a(menuItem, this.f19040n, this.f19041o);
            AbstractC0683y.e(menuItem, this.f19042p, this.f19043q);
            PorterDuff.Mode mode = this.f19025D;
            if (mode != null) {
                AbstractC0683y.d(menuItem, mode);
            }
            ColorStateList colorStateList = this.f19024C;
            if (colorStateList != null) {
                AbstractC0683y.c(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f19013e = clsArr;
        f19014f = clsArr;
    }

    public C2248d(Context context) {
        super(context);
        this.f19017c = context;
        Object[] objArr = {context};
        this.f19015a = objArr;
        this.f19016b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f19018d == null) {
            this.f19018d = a(this.f19017c);
        }
        return this.f19018d;
    }

    public final void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z7 = false;
        boolean z8 = false;
        String str = null;
        while (!z7) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z8 && name2.equals(str)) {
                        z8 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            bVar.a();
                        }
                    } else if (name2.equals("menu")) {
                        z7 = true;
                    }
                }
            } else if (!z8) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z8 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i7, Menu menu) {
        if (!(menu instanceof K.a)) {
            super.inflate(i7, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f19017c.getResources().getLayout(i7);
                    c(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e7) {
                    throw new InflateException("Error inflating menu XML", e7);
                }
            } catch (XmlPullParserException e8) {
                throw new InflateException("Error inflating menu XML", e8);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
