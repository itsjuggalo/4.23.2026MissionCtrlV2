package H;

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
        public static int a(TypedArray typedArray, int i7) {
            return typedArray.getType(i7);
        }
    }

    public interface b {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0021d[] f2515a;

        public c(C0021d[] c0021dArr) {
            this.f2515a = c0021dArr;
        }

        public C0021d[] a() {
            return this.f2515a;
        }
    }

    /* JADX INFO: renamed from: H.d$d, reason: collision with other inner class name */
    public static final class C0021d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f2519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f2521f;

        public C0021d(String str, int i7, boolean z7, String str2, int i8, int i9) {
            this.f2516a = str;
            this.f2517b = i7;
            this.f2518c = z7;
            this.f2519d = str2;
            this.f2520e = i8;
            this.f2521f = i9;
        }

        public String a() {
            return this.f2516a;
        }

        public int b() {
            return this.f2521f;
        }

        public int c() {
            return this.f2520e;
        }

        public String d() {
            return this.f2519d;
        }

        public int e() {
            return this.f2517b;
        }

        public boolean f() {
            return this.f2518c;
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final N.e f2522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f2525d;

        public e(N.e eVar, int i7, int i8, String str) {
            this.f2522a = eVar;
            this.f2524c = i7;
            this.f2523b = i8;
            this.f2525d = str;
        }

        public int a() {
            return this.f2524c;
        }

        public N.e b() {
            return this.f2522a;
        }

        public String c() {
            return this.f2525d;
        }

        public int d() {
            return this.f2523b;
        }
    }

    public static int a(TypedArray typedArray, int i7) {
        return a.a(typedArray, i7);
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

    public static List c(Resources resources, int i7) {
        if (i7 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i7);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i8 = 0; i8 < typedArrayObtainTypedArray.length(); i8++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i8, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i7)));
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
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), E.g.f1557h);
        String string = typedArrayObtainAttributes.getString(E.g.f1558i);
        String string2 = typedArrayObtainAttributes.getString(E.g.f1562m);
        String string3 = typedArrayObtainAttributes.getString(E.g.f1563n);
        int resourceId = typedArrayObtainAttributes.getResourceId(E.g.f1559j, 0);
        int integer = typedArrayObtainAttributes.getInteger(E.g.f1560k, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(E.g.f1561l, 500);
        String string4 = typedArrayObtainAttributes.getString(E.g.f1564o);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new e(new N.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
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
        return new c((C0021d[]) arrayList.toArray(new C0021d[0]));
    }

    public static C0021d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), E.g.f1565p);
        int i7 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(E.g.f1574y) ? E.g.f1574y : E.g.f1567r, RCHTTPStatusCodes.BAD_REQUEST);
        boolean z7 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(E.g.f1572w) ? E.g.f1572w : E.g.f1568s, 0);
        int i8 = typedArrayObtainAttributes.hasValue(E.g.f1575z) ? E.g.f1575z : E.g.f1569t;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(E.g.f1573x) ? E.g.f1573x : E.g.f1570u);
        int i9 = typedArrayObtainAttributes.getInt(i8, 0);
        int i10 = typedArrayObtainAttributes.hasValue(E.g.f1571v) ? E.g.f1571v : E.g.f1566q;
        int resourceId = typedArrayObtainAttributes.getResourceId(i10, 0);
        String string2 = typedArrayObtainAttributes.getString(i10);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0021d(string2, i7, z7, string, i9, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i7 = 1;
        while (i7 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i7++;
            } else if (next == 3) {
                i7--;
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
