package f0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f9037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9038b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9039c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray f9040d = new SparseArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray f9041e = new SparseArray();

    /* JADX INFO: renamed from: f0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0170a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f9043b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f9045d;

        public C0170a(Context context, XmlPullParser xmlPullParser) {
            this.f9044c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.E6);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == d.F6) {
                    this.f9042a = typedArrayObtainStyledAttributes.getResourceId(index, this.f9042a);
                } else if (index == d.G6) {
                    this.f9044c = typedArrayObtainStyledAttributes.getResourceId(index, this.f9044c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f9044c);
                    context.getResources().getResourceName(this.f9044c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        this.f9045d = dVar;
                        dVar.d(context, this.f9044c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f9043b.add(bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f9046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f9047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f9048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f9049d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9050e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.constraintlayout.widget.d f9051f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f9046a = Float.NaN;
            this.f9047b = Float.NaN;
            this.f9048c = Float.NaN;
            this.f9049d = Float.NaN;
            this.f9050e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), d.f9078c7);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == d.f9087d7) {
                    this.f9050e = typedArrayObtainStyledAttributes.getResourceId(index, this.f9050e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f9050e);
                    context.getResources().getResourceName(this.f9050e);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
                        this.f9051f = dVar;
                        dVar.d(context, this.f9050e);
                    }
                } else if (index == d.f9096e7) {
                    this.f9049d = typedArrayObtainStyledAttributes.getDimension(index, this.f9049d);
                } else if (index == d.f9105f7) {
                    this.f9047b = typedArrayObtainStyledAttributes.getDimension(index, this.f9047b);
                } else if (index == d.f9114g7) {
                    this.f9048c = typedArrayObtainStyledAttributes.getDimension(index, this.f9048c);
                } else if (index == d.f9123h7) {
                    this.f9046a = typedArrayObtainStyledAttributes.getDimension(index, this.f9046a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public a(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f9037a = constraintLayout;
        a(context, i10);
    }

    public final void a(Context context, int i10) {
        String str;
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            C0170a c0170a = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b(context, xml);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c0170a = new C0170a(context, xml);
                                this.f9040d.put(c0170a.f9042a, c0170a);
                            }
                            break;
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b bVar = new b(context, xml);
                                if (c0170a != null) {
                                    c0170a.a(bVar);
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public final void b(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10);
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
                this.f9041e.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(f0.b bVar) {
    }
}
