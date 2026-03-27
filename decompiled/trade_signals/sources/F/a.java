package F;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f1052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1053b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1054c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray f1055d = new SparseArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray f1056e = new SparseArray();

    /* JADX INFO: renamed from: F.a$a, reason: collision with other inner class name */
    public static class C0021a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f1058b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f1060d;

        public C0021a(Context context, XmlPullParser xmlPullParser) {
            this.f1059c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.f1106E6);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == d.f1114F6) {
                    this.f1057a = typedArrayObtainStyledAttributes.getResourceId(index, this.f1057a);
                } else if (index == d.f1122G6) {
                    this.f1059c = typedArrayObtainStyledAttributes.getResourceId(index, this.f1059c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1059c);
                    context.getResources().getResourceName(this.f1059c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        this.f1060d = dVar;
                        dVar.d(context, this.f1059c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f1058b.add(bVar);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f1061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f1062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f1064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1065e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f1066f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f1061a = Float.NaN;
            this.f1062b = Float.NaN;
            this.f1063c = Float.NaN;
            this.f1064d = Float.NaN;
            this.f1065e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.f1301c7);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == d.f1310d7) {
                    this.f1065e = typedArrayObtainStyledAttributes.getResourceId(index, this.f1065e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1065e);
                    context.getResources().getResourceName(this.f1065e);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        this.f1066f = dVar;
                        dVar.d(context, this.f1065e);
                    }
                } else if (index == d.f1319e7) {
                    this.f1064d = typedArrayObtainStyledAttributes.getDimension(index, this.f1064d);
                } else if (index == d.f1328f7) {
                    this.f1062b = typedArrayObtainStyledAttributes.getDimension(index, this.f1062b);
                } else if (index == d.f1337g7) {
                    this.f1063c = typedArrayObtainStyledAttributes.getDimension(index, this.f1063c);
                } else if (index == d.f1346h7) {
                    this.f1061a = typedArrayObtainStyledAttributes.getDimension(index, this.f1061a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i8) {
        this.f1052a = constraintLayout;
        a(context, i8);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r1 = 0
        Ld:
            r2 = 1
            if (r0 == r2) goto L8d
            if (r0 == 0) goto L7e
            r3 = 2
            if (r0 == r3) goto L17
            goto L81
        L17:
            java.lang.String r0 = r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            int r4 = r0.hashCode()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L50;
                case 80204913: goto L46;
                case 1382829617: goto L3d;
                case 1657696882: goto L33;
                case 1901439077: goto L25;
                default: goto L24;
            }     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
        L24:
            goto L5a
        L25:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r6
            goto L5b
        L2f:
            r8 = move-exception
            goto L86
        L31:
            r8 = move-exception
            goto L8a
        L33:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = 0
            goto L5b
        L3d:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            goto L5b
        L46:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r3
            goto L5b
        L50:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r5
            goto L5b
        L5a:
            r2 = -1
        L5b:
            if (r2 == r3) goto L71
            if (r2 == r6) goto L66
            if (r2 == r5) goto L62
            goto L81
        L62:
            r7.b(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L66:
            F.a$b r0 = new F.a$b     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r0.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r1 == 0) goto L81
            r1.a(r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L71:
            F.a$a r1 = new F.a$a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r1.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            android.util.SparseArray r0 = r7.f1055d     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            int r2 = r1.f1057a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r0.put(r2, r1)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L7e:
            r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
        L81:
            int r0 = r9.next()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto Ld
        L86:
            r8.printStackTrace()
            goto L8d
        L8a:
            r8.printStackTrace()
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: F.a.a(android.content.Context, int):void");
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i8 = 0; i8 < attributeCount; i8++) {
            String attributeName = xmlPullParser.getAttributeName(i8);
            String attributeValue = xmlPullParser.getAttributeValue(i8);
            if (attributeName != null && attributeValue != null && DiagnosticsEntry.ID_KEY.equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), DiagnosticsEntry.ID_KEY, context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.i(context, xmlPullParser);
                this.f1056e.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(F.b bVar) {
    }
}
