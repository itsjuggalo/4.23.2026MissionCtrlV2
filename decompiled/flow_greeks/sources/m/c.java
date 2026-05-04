package m;

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
import o.j0;
import o.v;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t0.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends MenuInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class[] f15703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f15704f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f15705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f15706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f15707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f15708d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Class[] f15709c = {MenuItem.class};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f15711b;

        public a(Object obj, String str) {
            this.f15710a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f15711b = cls.getMethod(str, f15709c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f15711b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f15711b.invoke(this.f15710a, menuItem)).booleanValue();
                }
                this.f15711b.invoke(this.f15710a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b {
        public CharSequence A;
        public CharSequence B;
        public ColorStateList C = null;
        public PorterDuff.Mode D = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Menu f15712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f15715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15716e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f15717f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f15718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f15719h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f15720i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f15721j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public CharSequence f15722k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f15723l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f15724m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public char f15725n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f15726o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public char f15727p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f15728q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f15729r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f15730s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f15731t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f15732u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f15733v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f15734w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f15735x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f15736y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f15737z;

        public b(Menu menu) {
            this.f15712a = menu;
            h();
        }

        public void a() {
            this.f15719h = true;
            i(this.f15712a.add(this.f15713b, this.f15720i, this.f15721j, this.f15722k));
        }

        public SubMenu b() {
            this.f15719h = true;
            SubMenu subMenuAddSubMenu = this.f15712a.addSubMenu(this.f15713b, this.f15720i, this.f15721j, this.f15722k);
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
            return this.f15719h;
        }

        public final Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, c.this.f15707c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        public void f(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = c.this.f15707c.obtainStyledAttributes(attributeSet, i.F0);
            this.f15713b = typedArrayObtainStyledAttributes.getResourceId(i.H0, 0);
            this.f15714c = typedArrayObtainStyledAttributes.getInt(i.J0, 0);
            this.f15715d = typedArrayObtainStyledAttributes.getInt(i.K0, 0);
            this.f15716e = typedArrayObtainStyledAttributes.getInt(i.L0, 0);
            this.f15717f = typedArrayObtainStyledAttributes.getBoolean(i.I0, true);
            this.f15718g = typedArrayObtainStyledAttributes.getBoolean(i.G0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            j0 j0VarR = j0.r(c.this.f15707c, attributeSet, i.M0);
            this.f15720i = j0VarR.l(i.P0, 0);
            this.f15721j = (j0VarR.i(i.S0, this.f15714c) & (-65536)) | (j0VarR.i(i.T0, this.f15715d) & 65535);
            this.f15722k = j0VarR.n(i.U0);
            this.f15723l = j0VarR.n(i.V0);
            this.f15724m = j0VarR.l(i.N0, 0);
            this.f15725n = c(j0VarR.m(i.W0));
            this.f15726o = j0VarR.i(i.f9776d1, 4096);
            this.f15727p = c(j0VarR.m(i.X0));
            this.f15728q = j0VarR.i(i.f9792h1, 4096);
            if (j0VarR.p(i.Y0)) {
                this.f15729r = j0VarR.a(i.Y0, false) ? 1 : 0;
            } else {
                this.f15729r = this.f15716e;
            }
            this.f15730s = j0VarR.a(i.Q0, false);
            this.f15731t = j0VarR.a(i.R0, this.f15717f);
            this.f15732u = j0VarR.a(i.O0, this.f15718g);
            this.f15733v = j0VarR.i(i.f9796i1, -1);
            this.f15737z = j0VarR.m(i.Z0);
            this.f15734w = j0VarR.l(i.f9764a1, 0);
            this.f15735x = j0VarR.m(i.f9772c1);
            String strM = j0VarR.m(i.f9768b1);
            this.f15736y = strM;
            boolean z10 = strM != null;
            if (z10 && this.f15734w == 0 && this.f15735x == null) {
                android.support.v4.media.session.b.a(e(strM, c.f15704f, c.this.f15706b));
            } else if (z10) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.A = j0VarR.n(i.f9780e1);
            this.B = j0VarR.n(i.f9800j1);
            if (j0VarR.p(i.f9788g1)) {
                this.D = v.d(j0VarR.i(i.f9788g1, -1), this.D);
            } else {
                this.D = null;
            }
            if (j0VarR.p(i.f9784f1)) {
                this.C = j0VarR.c(i.f9784f1);
            } else {
                this.C = null;
            }
            j0VarR.u();
            this.f15719h = false;
        }

        public void h() {
            this.f15713b = 0;
            this.f15714c = 0;
            this.f15715d = 0;
            this.f15716e = 0;
            this.f15717f = true;
            this.f15718g = true;
        }

        public final void i(MenuItem menuItem) {
            boolean z10 = false;
            menuItem.setChecked(this.f15730s).setVisible(this.f15731t).setEnabled(this.f15732u).setCheckable(this.f15729r >= 1).setTitleCondensed(this.f15723l).setIcon(this.f15724m);
            int i10 = this.f15733v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f15737z != null) {
                if (c.this.f15707c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(c.this.b(), this.f15737z));
            }
            if (this.f15729r >= 2 && (menuItem instanceof e)) {
                ((e) menuItem).s(true);
            }
            String str = this.f15735x;
            if (str != null) {
                menuItem.setActionView((View) e(str, c.f15703e, c.this.f15705a));
                z10 = true;
            }
            int i11 = this.f15734w;
            if (i11 > 0) {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i11);
                }
            }
            o.b(menuItem, this.A);
            o.f(menuItem, this.B);
            o.a(menuItem, this.f15725n, this.f15726o);
            o.e(menuItem, this.f15727p, this.f15728q);
            PorterDuff.Mode mode = this.D;
            if (mode != null) {
                o.d(menuItem, mode);
            }
            ColorStateList colorStateList = this.C;
            if (colorStateList != null) {
                o.c(menuItem, colorStateList);
            }
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f15703e = clsArr;
        f15704f = clsArr;
    }

    public c(Context context) {
        super(context);
        this.f15707c = context;
        Object[] objArr = {context};
        this.f15705a = objArr;
        this.f15706b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public Object b() {
        if (this.f15708d == null) {
            this.f15708d = a(this.f15707c);
        }
        return this.f15708d;
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
        boolean z10 = false;
        boolean z11 = false;
        String str = null;
        while (!z10) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z11 && name2.equals(str)) {
                        z11 = false;
                        str = null;
                    } else if (name2.equals("group")) {
                        bVar.h();
                    } else if (name2.equals("item")) {
                        if (!bVar.d()) {
                            bVar.a();
                        }
                    } else if (name2.equals("menu")) {
                        z10 = true;
                    }
                }
            } else if (!z11) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    bVar.f(attributeSet);
                } else if (name3.equals("item")) {
                    bVar.g(attributeSet);
                } else if (name3.equals("menu")) {
                    c(xmlPullParser, attributeSet, bVar.b());
                } else {
                    str = name3;
                    z11 = true;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof n0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z10 = false;
        try {
            try {
                layout = this.f15707c.getResources().getLayout(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof d) {
                    d dVar = (d) menu;
                    if (dVar.B()) {
                        dVar.W();
                        z10 = true;
                    }
                }
                c(layout, attributeSetAsAttributeSet, menu);
                if (z10) {
                    ((d) menu).V();
                }
                if (layout != null) {
                    layout.close();
                }
            } catch (IOException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (z10) {
                ((d) menu).V();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
