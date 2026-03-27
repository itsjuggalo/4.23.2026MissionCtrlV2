package y;

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
import v.AbstractC1875g;

/* JADX INFO: renamed from: y.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1929d {

    /* JADX INFO: renamed from: y.d$a */
    public static class a {
        public static int a(TypedArray typedArray, int i4) {
            return typedArray.getType(i4);
        }
    }

    /* JADX INFO: renamed from: y.d$b */
    public interface b {
    }

    /* JADX INFO: renamed from: y.d$c */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0257d[] f15810a;

        public c(C0257d[] c0257dArr) {
            this.f15810a = c0257dArr;
        }

        public C0257d[] a() {
            return this.f15810a;
        }
    }

    /* JADX INFO: renamed from: y.d$d, reason: collision with other inner class name */
    public static final class C0257d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f15813c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f15814d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f15815e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f15816f;

        public C0257d(String str, int i4, boolean z4, String str2, int i5, int i6) {
            this.f15811a = str;
            this.f15812b = i4;
            this.f15813c = z4;
            this.f15814d = str2;
            this.f15815e = i5;
            this.f15816f = i6;
        }

        public String a() {
            return this.f15811a;
        }

        public int b() {
            return this.f15816f;
        }

        public int c() {
            return this.f15815e;
        }

        public String d() {
            return this.f15814d;
        }

        public int e() {
            return this.f15812b;
        }

        public boolean f() {
            return this.f15813c;
        }
    }

    /* JADX INFO: renamed from: y.d$e */
    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E.e f15817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f15820d;

        public e(E.e eVar, int i4, int i5, String str) {
            this.f15817a = eVar;
            this.f15819c = i4;
            this.f15818b = i5;
            this.f15820d = str;
        }

        public int a() {
            return this.f15819c;
        }

        public E.e b() {
            return this.f15817a;
        }

        public String c() {
            return this.f15820d;
        }

        public int d() {
            return this.f15818b;
        }
    }

    public static int a(TypedArray typedArray, int i4) {
        return a.a(typedArray, i4);
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

    public static List c(Resources resources, int i4) {
        if (i4 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i4);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i5 = 0; i5 < typedArrayObtainTypedArray.length(); i5++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i5, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i4)));
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
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), AbstractC1875g.f15181h);
        String string = typedArrayObtainAttributes.getString(AbstractC1875g.f15182i);
        String string2 = typedArrayObtainAttributes.getString(AbstractC1875g.f15186m);
        String string3 = typedArrayObtainAttributes.getString(AbstractC1875g.f15187n);
        int resourceId = typedArrayObtainAttributes.getResourceId(AbstractC1875g.f15183j, 0);
        int integer = typedArrayObtainAttributes.getInteger(AbstractC1875g.f15184k, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(AbstractC1875g.f15185l, 500);
        String string4 = typedArrayObtainAttributes.getString(AbstractC1875g.f15188o);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new e(new E.e(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
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
        return new c((C0257d[]) arrayList.toArray(new C0257d[0]));
    }

    public static C0257d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), AbstractC1875g.f15189p);
        int i4 = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(AbstractC1875g.f15198y) ? AbstractC1875g.f15198y : AbstractC1875g.f15191r, RCHTTPStatusCodes.BAD_REQUEST);
        boolean z4 = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(AbstractC1875g.f15196w) ? AbstractC1875g.f15196w : AbstractC1875g.f15192s, 0);
        int i5 = typedArrayObtainAttributes.hasValue(AbstractC1875g.f15199z) ? AbstractC1875g.f15199z : AbstractC1875g.f15193t;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(AbstractC1875g.f15197x) ? AbstractC1875g.f15197x : AbstractC1875g.f15194u);
        int i6 = typedArrayObtainAttributes.getInt(i5, 0);
        int i7 = typedArrayObtainAttributes.hasValue(AbstractC1875g.f15195v) ? AbstractC1875g.f15195v : AbstractC1875g.f15190q;
        int resourceId = typedArrayObtainAttributes.getResourceId(i7, 0);
        String string2 = typedArrayObtainAttributes.getString(i7);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0257d(string2, i4, z4, string, i6, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i4 = 1;
        while (i4 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i4++;
            } else if (next == 3) {
                i4--;
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
