package k0;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0249d[] f14439a;

        public c(C0249d[] c0249dArr) {
            this.f14439a = c0249dArr;
        }

        public C0249d[] a() {
            return this.f14439a;
        }
    }

    /* JADX INFO: renamed from: k0.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0249d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f14442c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f14443d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f14444e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f14445f;

        public C0249d(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f14440a = str;
            this.f14441b = i10;
            this.f14442c = z10;
            this.f14443d = str2;
            this.f14444e = i11;
            this.f14445f = i12;
        }

        public String a() {
            return this.f14440a;
        }

        public int b() {
            return this.f14445f;
        }

        public int c() {
            return this.f14444e;
        }

        public String d() {
            return this.f14443d;
        }

        public int e() {
            return this.f14441b;
        }

        public boolean f() {
            return this.f14442c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q0.e f14446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q0.e f14447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f14450e;

        public e(q0.e eVar, q0.e eVar2, int i10, int i11, String str) {
            this.f14446a = eVar;
            this.f14447b = eVar2;
            this.f14449d = i10;
            this.f14448c = i11;
            this.f14450e = str;
        }

        public q0.e a() {
            return this.f14447b;
        }

        public int b() {
            return this.f14449d;
        }

        public q0.e c() {
            return this.f14446a;
        }

        public String d() {
            return this.f14450e;
        }

        public int e() {
            return this.f14448c;
        }
    }

    public static int a(TypedArray typedArray, int i10) {
        return a.a(typedArray, i10);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) {
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

    public static List c(Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < typedArrayObtainTypedArray.length(); i11++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
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
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), g0.g.f9916h);
        String string = typedArrayObtainAttributes.getString(g0.g.f9917i);
        String string2 = typedArrayObtainAttributes.getString(g0.g.f9922n);
        String string3 = typedArrayObtainAttributes.getString(g0.g.f9923o);
        String string4 = typedArrayObtainAttributes.getString(g0.g.f9919k);
        int resourceId = typedArrayObtainAttributes.getResourceId(g0.g.f9918j, 0);
        int integer = typedArrayObtainAttributes.getInteger(g0.g.f9920l, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(g0.g.f9921m, 500);
        String string5 = typedArrayObtainAttributes.getString(g0.g.f9924p);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            List listC = c(resources, resourceId);
            return new e(new q0.e(string, string2, string3, listC), string4 != null ? new q0.e(string, string2, string4, listC) : null, integer, integer2, string5);
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
        return new c((C0249d[]) arrayList.toArray(new C0249d[0]));
    }

    public static C0249d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), g0.g.f9925q);
        int i10 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(g0.g.f9934z) ? g0.g.f9934z : g0.g.f9927s, RCHTTPStatusCodes.BAD_REQUEST);
        boolean z10 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(g0.g.f9932x) ? g0.g.f9932x : g0.g.f9928t, 0);
        int i11 = typedArrayObtainAttributes.hasValue(g0.g.A) ? g0.g.A : g0.g.f9929u;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(g0.g.f9933y) ? g0.g.f9933y : g0.g.f9930v);
        int i12 = typedArrayObtainAttributes.getInt(i11, 0);
        int i13 = typedArrayObtainAttributes.hasValue(g0.g.f9931w) ? g0.g.f9931w : g0.g.f9926r;
        int resourceId = typedArrayObtainAttributes.getResourceId(i13, 0);
        String string2 = typedArrayObtainAttributes.getString(i13);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0249d(string2, i10, z10, string, i12, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
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
