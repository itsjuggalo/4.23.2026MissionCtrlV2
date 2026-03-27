package m;

import T.AbstractC0934p;
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
import androidx.appcompat.view.menu.d;
import androidx.appcompat.view.menu.e;
import g.i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import o.L;
import o.x;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class c extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class[] f21183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f21184f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f21185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f21186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f21187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f21188d;

    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class[] f21189c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f21190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f21191b;

        public a(Object obj, String str) {
            this.f21190a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f21191b = cls.getMethod(str, f21189c);
            } catch (Exception e8) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e8);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f21191b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f21191b.invoke(this.f21190a, menuItem)).booleanValue();
                }
                this.f21191b.invoke(this.f21190a, menuItem);
                return true;
            } catch (Exception e8) {
                throw new RuntimeException(e8);
            }
        }
    }

    public class b {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public CharSequence f21192A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public CharSequence f21193B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public ColorStateList f21194C = null;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public PorterDuff.Mode f21195D = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f21197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21200d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f21201e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f21202f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f21203g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f21204h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f21205i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f21206j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f21207k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f21208l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f21209m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f21210n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f21211o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f21212p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f21213q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f21214r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f21215s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f21216t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f21217u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f21218v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f21219w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f21220x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f21221y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f21222z;

        public b(Menu menu) {
            this.f21197a = menu;
            h();
        }

        public void a() {
            this.f21204h = true;
            i(this.f21197a.add(this.f21198b, this.f21205i, this.f21206j, this.f21207k));
        }

        public SubMenu b() {
            this.f21204h = true;
            SubMenu subMenuAddSubMenu = this.f21197a.addSubMenu(this.f21198b, this.f21205i, this.f21206j, this.f21207k);
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
            return this.f21204h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, c.this.f21187c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e8) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e8);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = c.this.f21187c.obtainStyledAttributes(attributeSet, i.f17793F0);
            this.f21198b = typedArrayObtainStyledAttributes.getResourceId(i.f17801H0, 0);
            this.f21199c = typedArrayObtainStyledAttributes.getInt(i.f17809J0, 0);
            this.f21200d = typedArrayObtainStyledAttributes.getInt(i.f17813K0, 0);
            this.f21201e = typedArrayObtainStyledAttributes.getInt(i.f17817L0, 0);
            this.f21202f = typedArrayObtainStyledAttributes.getBoolean(i.f17805I0, true);
            this.f21203g = typedArrayObtainStyledAttributes.getBoolean(i.f17797G0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(AttributeSet attributeSet) {
            L lR = L.r(c.this.f21187c, attributeSet, i.f17820M0);
            this.f21205i = lR.l(i.f17829P0, 0);
            this.f21206j = (lR.i(i.f17838S0, this.f21199c) & (-65536)) | (lR.i(i.f17841T0, this.f21200d) & 65535);
            this.f21207k = lR.n(i.f17844U0);
            this.f21208l = lR.n(i.f17847V0);
            this.f21209m = lR.l(i.f17823N0, 0);
            this.f21210n = c(lR.m(i.f17850W0));
            this.f21211o = lR.i(i.f17875d1, 4096);
            this.f21212p = c(lR.m(i.f17853X0));
            this.f21213q = lR.i(i.f17891h1, 4096);
            this.f21214r = lR.p(i.f17856Y0) ? lR.a(i.f17856Y0, false) : this.f21201e;
            this.f21215s = lR.a(i.f17832Q0, false);
            this.f21216t = lR.a(i.f17835R0, this.f21202f);
            this.f21217u = lR.a(i.f17826O0, this.f21203g);
            this.f21218v = lR.i(i.f17895i1, -1);
            this.f21222z = lR.m(i.f17859Z0);
            this.f21219w = lR.l(i.f17863a1, 0);
            this.f21220x = lR.m(i.f17871c1);
            String strM = lR.m(i.f17867b1);
            this.f21221y = strM;
            boolean z7 = strM != null;
            if (z7 && this.f21219w == 0 && this.f21220x == null) {
                android.support.v4.media.session.b.a(e(strM, c.f21184f, c.this.f21186b));
            } else if (z7) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f21192A = lR.n(i.f17879e1);
            this.f21193B = lR.n(i.f17899j1);
            if (lR.p(i.f17887g1)) {
                this.f21195D = x.d(lR.i(i.f17887g1, -1), this.f21195D);
            } else {
                this.f21195D = null;
            }
            if (lR.p(i.f17883f1)) {
                this.f21194C = lR.c(i.f17883f1);
            } else {
                this.f21194C = null;
            }
            lR.u();
            this.f21204h = false;
        }

        public void h() {
            this.f21198b = 0;
            this.f21199c = 0;
            this.f21200d = 0;
            this.f21201e = 0;
            this.f21202f = true;
            this.f21203g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z7 = false;
            menuItem.setChecked(this.f21215s).setVisible(this.f21216t).setEnabled(this.f21217u).setCheckable(this.f21214r >= 1).setTitleCondensed(this.f21208l).setIcon(this.f21209m);
            int i8 = this.f21218v;
            if (i8 >= 0) {
                menuItem.setShowAsAction(i8);
            }
            if (this.f21222z != null) {
                if (c.this.f21187c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(c.this.b(), this.f21222z));
            }
            if (this.f21214r >= 2 && (menuItem instanceof e)) {
                ((e) menuItem).s(true);
            }
            String str = this.f21220x;
            if (str != null) {
                menuItem.setActionView((View) e(str, c.f21183e, c.this.f21185a));
                z7 = true;
            }
            int i9 = this.f21219w;
            if (i9 > 0) {
                if (z7) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i9);
                }
            }
            AbstractC0934p.b(menuItem, this.f21192A);
            AbstractC0934p.f(menuItem, this.f21193B);
            AbstractC0934p.a(menuItem, this.f21210n, this.f21211o);
            AbstractC0934p.e(menuItem, this.f21212p, this.f21213q);
            PorterDuff.Mode mode = this.f21195D;
            if (mode != null) {
                AbstractC0934p.d(menuItem, mode);
            }
            ColorStateList colorStateList = this.f21194C;
            if (colorStateList != null) {
                AbstractC0934p.c(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f21183e = clsArr;
        f21184f = clsArr;
    }

    public c(Context context) {
        super(context);
        this.f21187c = context;
        Object[] objArr = {context};
        this.f21185a = objArr;
        this.f21186b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f21188d == null) {
            this.f21188d = a(this.f21187c);
        }
        return this.f21188d;
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
    public void inflate(int i8, Menu menu) {
        if (!(menu instanceof N.a)) {
            super.inflate(i8, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z7 = false;
        try {
            try {
                layout = this.f21187c.getResources().getLayout(i8);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof d) {
                    d dVar = (d) menu;
                    if (dVar.B()) {
                        dVar.W();
                        z7 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z7) {
                    ((d) menu).V();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e8) {
                throw new InflateException("Error inflating menu XML", e8);
            } catch (XmlPullParserException e9) {
                throw new InflateException("Error inflating menu XML", e9);
            }
        } catch (Throwable th) {
            if (z7) {
                ((d) menu).V();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
