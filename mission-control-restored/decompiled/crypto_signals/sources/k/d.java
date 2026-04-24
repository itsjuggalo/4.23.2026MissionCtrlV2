package k;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import h.AbstractC0616a;
import java.io.IOException;
import l.i;
import m.N;
import org.xmlpull.v1.XmlPullParserException;
import u.AbstractC1193h;

/* JADX INFO: loaded from: classes.dex */
public final class d extends MenuInflater {
    public static final Class[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f7809f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f7810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f7811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f7812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f7813d;

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f7809f = clsArr;
    }

    public d(Context context) {
        super(context);
        this.f7812c = context;
        Object[] objArr = {context};
        this.f7810a = objArr;
        this.f7811b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [k.d] */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        ?? r42;
        int i;
        XmlResourceParser xmlResourceParser2;
        ?? r8;
        ColorStateList colorStateList;
        int resourceId;
        c cVar = new c(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            r42 = 1;
            i = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z6 = false;
        boolean z7 = false;
        String str = null;
        while (!z6) {
            if (eventType == r42) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i) {
                if (eventType != 3) {
                    xmlResourceParser2 = xmlResourceParser;
                    r8 = r42;
                    z6 = z6;
                } else {
                    String name2 = xmlResourceParser.getName();
                    if (z7 && name2.equals(str)) {
                        xmlResourceParser2 = xmlResourceParser;
                        r8 = r42;
                        z7 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            cVar.f7787b = 0;
                            cVar.f7788c = 0;
                            cVar.f7789d = 0;
                            cVar.e = 0;
                            cVar.f7790f = r42;
                            cVar.f7791g = r42;
                        } else if (name2.equals("item")) {
                            if (!cVar.f7792h) {
                                cVar.f7792h = r42;
                                cVar.b(cVar.f7786a.add(cVar.f7787b, cVar.i, cVar.f7793j, cVar.f7794k));
                            }
                        } else if (name2.equals("menu")) {
                            xmlResourceParser2 = xmlResourceParser;
                            ?? r82 = r42;
                            z6 = r82 == true ? 1 : 0;
                            r8 = r82;
                        }
                        xmlResourceParser2 = xmlResourceParser;
                        r8 = r42;
                        z6 = z6;
                    }
                }
                eventType = xmlResourceParser2.next();
                r42 = r8;
                i = 2;
                z6 = z6;
                z7 = z7;
            } else {
                if (!z7) {
                    String name3 = xmlResourceParser.getName();
                    boolean zEquals = name3.equals("group");
                    d dVar = cVar.f7785D;
                    if (zEquals) {
                        ?? ObtainStyledAttributes = dVar.f7812c.obtainStyledAttributes(attributeSet, AbstractC0616a.f6582l);
                        cVar.f7787b = ObtainStyledAttributes.getResourceId(r42, 0);
                        cVar.f7788c = ObtainStyledAttributes.getInt(3, 0);
                        cVar.f7789d = ObtainStyledAttributes.getInt(4, 0);
                        cVar.e = ObtainStyledAttributes.getInt(5, 0);
                        cVar.f7790f = ObtainStyledAttributes.getBoolean(2, r42);
                        cVar.f7791g = ObtainStyledAttributes.getBoolean(0, r42);
                        ObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            Context context = dVar.f7812c;
                            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0616a.f6583m);
                            cVar.i = typedArrayObtainStyledAttributes.getResourceId(2, 0);
                            cVar.f7793j = (typedArrayObtainStyledAttributes.getInt(5, cVar.f7788c) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(6, cVar.f7789d) & 65535);
                            cVar.f7794k = typedArrayObtainStyledAttributes.getText(7);
                            cVar.f7795l = typedArrayObtainStyledAttributes.getText(8);
                            cVar.f7796m = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes.getString(9);
                            cVar.f7797n = string == null ? (char) 0 : string.charAt(0);
                            cVar.f7798o = typedArrayObtainStyledAttributes.getInt(16, 4096);
                            String string2 = typedArrayObtainStyledAttributes.getString(10);
                            cVar.f7799p = string2 == null ? (char) 0 : string2.charAt(0);
                            cVar.f7800q = typedArrayObtainStyledAttributes.getInt(20, 4096);
                            if (typedArrayObtainStyledAttributes.hasValue(11)) {
                                cVar.f7801r = typedArrayObtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
                            } else {
                                cVar.f7801r = cVar.e;
                            }
                            cVar.f7802s = typedArrayObtainStyledAttributes.getBoolean(3, false);
                            cVar.f7803t = typedArrayObtainStyledAttributes.getBoolean(4, cVar.f7790f);
                            cVar.f7804u = typedArrayObtainStyledAttributes.getBoolean(1, cVar.f7791g);
                            cVar.f7805v = typedArrayObtainStyledAttributes.getInt(21, -1);
                            cVar.y = typedArrayObtainStyledAttributes.getString(12);
                            cVar.f7806w = typedArrayObtainStyledAttributes.getResourceId(13, 0);
                            cVar.f7807x = typedArrayObtainStyledAttributes.getString(15);
                            String string3 = typedArrayObtainStyledAttributes.getString(14);
                            boolean z8 = string3 != null;
                            if (z8 && cVar.f7806w == 0 && cVar.f7807x == null) {
                                if (cVar.a(string3, f7809f, dVar.f7811b) != null) {
                                    throw new ClassCastException();
                                }
                            } else if (z8) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            cVar.f7808z = typedArrayObtainStyledAttributes.getText(17);
                            cVar.f7782A = typedArrayObtainStyledAttributes.getText(22);
                            if (typedArrayObtainStyledAttributes.hasValue(19)) {
                                cVar.f7784C = N.c(typedArrayObtainStyledAttributes.getInt(19, -1), cVar.f7784C);
                            } else {
                                cVar.f7784C = null;
                            }
                            if (typedArrayObtainStyledAttributes.hasValue(18)) {
                                if (!typedArrayObtainStyledAttributes.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(18, 0)) == 0 || (colorStateList = AbstractC1193h.getColorStateList(context, resourceId)) == null) {
                                    colorStateList = typedArrayObtainStyledAttributes.getColorStateList(18);
                                }
                                cVar.f7783B = colorStateList;
                            } else {
                                cVar.f7783B = null;
                            }
                            typedArrayObtainStyledAttributes.recycle();
                            cVar.f7792h = false;
                            xmlResourceParser2 = xmlResourceParser;
                            r8 = 1;
                        } else if (name3.equals("menu")) {
                            r8 = 1;
                            cVar.f7792h = true;
                            SubMenu subMenuAddSubMenu = cVar.f7786a.addSubMenu(cVar.f7787b, cVar.i, cVar.f7793j, cVar.f7794k);
                            cVar.b(subMenuAddSubMenu.getItem());
                            xmlResourceParser2 = xmlResourceParser;
                            b(xmlResourceParser2, attributeSet, subMenuAddSubMenu);
                        } else {
                            xmlResourceParser2 = xmlResourceParser;
                            r8 = 1;
                            str = name3;
                            z7 = true;
                        }
                        eventType = xmlResourceParser2.next();
                        r42 = r8;
                        i = 2;
                        z6 = z6;
                        z7 = z7;
                    }
                }
                xmlResourceParser2 = xmlResourceParser;
                r8 = r42;
                z6 = z6;
            }
            eventType = xmlResourceParser2.next();
            r42 = r8;
            i = 2;
            z6 = z6;
            z7 = z7;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof i)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f7812c.getResources().getLayout(i);
                    b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (XmlPullParserException e6) {
                throw new InflateException("Error inflating menu XML", e6);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
