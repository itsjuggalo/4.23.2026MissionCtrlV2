package m;

import H.AbstractC0283q;
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
import g.i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import o.G;
import o.a0;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: m.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1594c extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class[] f13445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f13446f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f13447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f13448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f13449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f13450d;

    /* JADX INFO: renamed from: m.c$a */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class[] f13451c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f13453b;

        public a(Object obj, String str) {
            this.f13452a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f13453b = cls.getMethod(str, f13451c);
            } catch (Exception e4) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e4);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f13453b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f13453b.invoke(this.f13452a, menuItem)).booleanValue();
                }
                this.f13453b.invoke(this.f13452a, menuItem);
                return true;
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    /* JADX INFO: renamed from: m.c$b */
    public class b {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public CharSequence f13454A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public CharSequence f13455B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public ColorStateList f13456C = null;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public PorterDuff.Mode f13457D = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f13459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13461c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13462d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13463e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f13464f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f13465g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f13466h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f13467i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f13468j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f13469k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f13470l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f13471m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f13472n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f13473o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f13474p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f13475q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f13476r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f13477s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f13478t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f13479u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f13480v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f13481w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f13482x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f13483y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f13484z;

        public b(Menu menu) {
            this.f13459a = menu;
            h();
        }

        public void a() {
            this.f13466h = true;
            i(this.f13459a.add(this.f13460b, this.f13467i, this.f13468j, this.f13469k));
        }

        public SubMenu b() {
            this.f13466h = true;
            SubMenu subMenuAddSubMenu = this.f13459a.addSubMenu(this.f13460b, this.f13467i, this.f13468j, this.f13469k);
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
            return this.f13466h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, C1594c.this.f13449c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e4) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e4);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C1594c.this.f13449c.obtainStyledAttributes(attributeSet, i.f11723L0);
            this.f13460b = typedArrayObtainStyledAttributes.getResourceId(i.f11731N0, 0);
            this.f13461c = typedArrayObtainStyledAttributes.getInt(i.f11739P0, 0);
            this.f13462d = typedArrayObtainStyledAttributes.getInt(i.f11743Q0, 0);
            this.f13463e = typedArrayObtainStyledAttributes.getInt(i.f11747R0, 0);
            this.f13464f = typedArrayObtainStyledAttributes.getBoolean(i.f11735O0, true);
            this.f13465g = typedArrayObtainStyledAttributes.getBoolean(i.f11727M0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            a0 a0VarQ = a0.q(C1594c.this.f13449c, attributeSet, i.f11751S0);
            this.f13467i = a0VarQ.l(i.f11763V0, 0);
            this.f13468j = (a0VarQ.i(i.f11775Y0, this.f13461c) & (-65536)) | (a0VarQ.i(i.f11779Z0, this.f13462d) & 65535);
            this.f13469k = a0VarQ.n(i.f11784a1);
            this.f13470l = a0VarQ.n(i.f11789b1);
            this.f13471m = a0VarQ.l(i.f11755T0, 0);
            this.f13472n = c(a0VarQ.m(i.f11794c1));
            this.f13473o = a0VarQ.i(i.f11829j1, 4096);
            this.f13474p = c(a0VarQ.m(i.f11799d1));
            this.f13475q = a0VarQ.i(i.f11846n1, 4096);
            if (a0VarQ.o(i.f11804e1)) {
                this.f13476r = a0VarQ.a(i.f11804e1, false) ? 1 : 0;
            } else {
                this.f13476r = this.f13463e;
            }
            this.f13477s = a0VarQ.a(i.f11767W0, false);
            this.f13478t = a0VarQ.a(i.f11771X0, this.f13464f);
            this.f13479u = a0VarQ.a(i.f11759U0, this.f13465g);
            this.f13480v = a0VarQ.i(i.f11850o1, -1);
            this.f13484z = a0VarQ.m(i.f11809f1);
            this.f13481w = a0VarQ.l(i.f11814g1, 0);
            this.f13482x = a0VarQ.m(i.f11824i1);
            String strM = a0VarQ.m(i.f11819h1);
            this.f13483y = strM;
            boolean z4 = strM != null;
            if (z4 && this.f13481w == 0 && this.f13482x == null) {
                android.support.v4.media.session.b.a(e(strM, C1594c.f13446f, C1594c.this.f13448b));
            } else if (z4) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f13454A = a0VarQ.n(i.f11834k1);
            this.f13455B = a0VarQ.n(i.f11854p1);
            if (a0VarQ.o(i.f11842m1)) {
                this.f13457D = G.d(a0VarQ.i(i.f11842m1, -1), this.f13457D);
            } else {
                this.f13457D = null;
            }
            if (a0VarQ.o(i.f11838l1)) {
                this.f13456C = a0VarQ.c(i.f11838l1);
            } else {
                this.f13456C = null;
            }
            a0VarQ.s();
            this.f13466h = false;
        }

        public void h() {
            this.f13460b = 0;
            this.f13461c = 0;
            this.f13462d = 0;
            this.f13463e = 0;
            this.f13464f = true;
            this.f13465g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z4 = false;
            menuItem.setChecked(this.f13477s).setVisible(this.f13478t).setEnabled(this.f13479u).setCheckable(this.f13476r >= 1).setTitleCondensed(this.f13470l).setIcon(this.f13471m);
            int i4 = this.f13480v;
            if (i4 >= 0) {
                menuItem.setShowAsAction(i4);
            }
            if (this.f13484z != null) {
                if (C1594c.this.f13449c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(C1594c.this.b(), this.f13484z));
            }
            boolean z5 = menuItem instanceof e;
            if (z5) {
            }
            if (this.f13476r >= 2 && z5) {
                ((e) menuItem).s(true);
            }
            String str = this.f13482x;
            if (str != null) {
                menuItem.setActionView((View) e(str, C1594c.f13445e, C1594c.this.f13447a));
                z4 = true;
            }
            int i5 = this.f13481w;
            if (i5 > 0) {
                if (z4) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i5);
                }
            }
            AbstractC0283q.b(menuItem, this.f13454A);
            AbstractC0283q.f(menuItem, this.f13455B);
            AbstractC0283q.a(menuItem, this.f13472n, this.f13473o);
            AbstractC0283q.e(menuItem, this.f13474p, this.f13475q);
            PorterDuff.Mode mode = this.f13457D;
            if (mode != null) {
                AbstractC0283q.d(menuItem, mode);
            }
            ColorStateList colorStateList = this.f13456C;
            if (colorStateList != null) {
                AbstractC0283q.c(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f13445e = clsArr;
        f13446f = clsArr;
    }

    public C1594c(Context context) {
        super(context);
        this.f13449c = context;
        Object[] objArr = {context};
        this.f13447a = objArr;
        this.f13448b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f13450d == null) {
            this.f13450d = a(this.f13449c);
        }
        return this.f13450d;
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
        boolean z4 = false;
        boolean z5 = false;
        String str = null;
        while (!z4) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z5 && name2.equals(str)) {
                        z5 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            bVar.a();
                        }
                    } else if (name2.equals("menu")) {
                        z4 = true;
                    }
                }
            } else if (!z5) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z5 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i4, Menu menu) {
        if (!(menu instanceof B.a)) {
            super.inflate(i4, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f13449c.getResources().getLayout(i4);
                    c(layout, Xml.asAttributeSet(layout), menu);
                } catch (IOException e4) {
                    throw new InflateException("Error inflating menu XML", e4);
                }
            } catch (XmlPullParserException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            }
        } finally {
            if (layout != null) {
                layout.close();
            }
        }
    }
}
