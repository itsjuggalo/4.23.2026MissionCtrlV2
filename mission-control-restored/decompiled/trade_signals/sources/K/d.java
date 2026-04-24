package K;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public static class a {
        public static int a(TypedArray typedArray, int i8) {
            return typedArray.getType(i8);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0065d[] f4696a;

        public c(C0065d[] c0065dArr) {
            this.f4696a = c0065dArr;
        }

        public C0065d[] a() {
            return this.f4696a;
        }
    }

    /* JADX INFO: renamed from: K.d$d, reason: collision with other inner class name */
    public static final class C0065d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f4700d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f4701e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f4702f;

        public C0065d(String str, int i8, boolean z7, String str2, int i9, int i10) {
            this.f4697a = str;
            this.f4698b = i8;
            this.f4699c = z7;
            this.f4700d = str2;
            this.f4701e = i9;
            this.f4702f = i10;
        }

        public String a() {
            return this.f4697a;
        }

        public int b() {
            return this.f4702f;
        }

        public int c() {
            return this.f4701e;
        }

        public String d() {
            return this.f4700d;
        }

        public int e() {
            return this.f4698b;
        }

        public boolean f() {
            return this.f4699c;
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Q.e f4703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f4706d;

        public e(Q.e eVar, int i8, int i9, String str) {
            this.f4703a = eVar;
            this.f4705c = i8;
            this.f4704b = i9;
            this.f4706d = str;
        }

        public int a() {
            return this.f4705c;
        }

        public Q.e b() {
            return this.f4703a;
        }

        public String c() {
            return this.f4706d;
        }

        public int d() {
            return this.f4704b;
        }
    }

    public static int a(TypedArray typedArray, int i8) {
        return a.a(typedArray, i8);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i8) {
        if (i8 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i8);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i9 = 0; i9 < typedArrayObtainTypedArray.length(); i9++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i9, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i8)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    public static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), G.g.f1991h);
        String string = typedArrayObtainAttributes.getString(G.g.f1992i);
        String string2 = typedArrayObtainAttributes.getString(G.g.f1996m);
        String string3 = typedArrayObtainAttributes.getString(G.g.f1997n);
        int resourceId = typedArrayObtainAttributes.getResourceId(G.g.f1993j, 0);
        int integer = typedArrayObtainAttributes.getInteger(G.g.f1994k, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(G.g.f1995l, 500);
        String string4 = typedArrayObtainAttributes.getString(G.g.f1998o);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new e(new Q.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((C0065d[]) arrayList.toArray(new C0065d[0]));
    }

    public static C0065d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), G.g.f1999p);
        int i8 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(G.g.f2008y) ? G.g.f2008y : G.g.f2001r, RCHTTPStatusCodes.BAD_REQUEST);
        boolean z7 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(G.g.f2006w) ? G.g.f2006w : G.g.f2002s, 0);
        int i9 = typedArrayObtainAttributes.hasValue(G.g.f2009z) ? G.g.f2009z : G.g.f2003t;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(G.g.f2007x) ? G.g.f2007x : G.g.f2004u);
        int i10 = typedArrayObtainAttributes.getInt(i9, 0);
        int i11 = typedArrayObtainAttributes.hasValue(G.g.f2005v) ? G.g.f2005v : G.g.f2000q;
        int resourceId = typedArrayObtainAttributes.getResourceId(i11, 0);
        String string2 = typedArrayObtainAttributes.getString(i11);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0065d(string2, i8, z7, string, i10, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i8 = 1;
        while (i8 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i8++;
            } else if (next == 3) {
                i8--;
            }
        }
    }

    public static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
