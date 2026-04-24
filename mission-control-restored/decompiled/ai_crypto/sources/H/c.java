package H;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2514a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return d(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static TypedValue c() {
        ThreadLocal threadLocal = f2514a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        Resources resources2 = resources;
        int i7 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i8 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i7 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayG = g(resources2, theme, attributeSet, E.g.f1551b);
                int resourceId = typedArrayG.getResourceId(E.g.f1552c, -1);
                if (resourceId == -1 || e(resources2, resourceId)) {
                    color = typedArrayG.getColor(E.g.f1552c, -65281);
                } else {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayG.getColor(E.g.f1552c, -65281);
                    }
                }
                float f7 = 1.0f;
                if (typedArrayG.hasValue(E.g.f1553d)) {
                    f7 = typedArrayG.getFloat(E.g.f1553d, 1.0f);
                } else if (typedArrayG.hasValue(E.g.f1555f)) {
                    f7 = typedArrayG.getFloat(E.g.f1555f, 1.0f);
                }
                float f8 = (Build.VERSION.SDK_INT < 31 || !typedArrayG.hasValue(E.g.f1554e)) ? typedArrayG.getFloat(E.g.f1556g, -1.0f) : typedArrayG.getFloat(E.g.f1554e, -1.0f);
                typedArrayG.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i9 = 0;
                for (int i10 = 0; i10 < attributeCount; i10++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i10);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != E.a.f1486a && attributeNameResource != E.a.f1487b) {
                        int i11 = i9 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i10, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i9] = attributeNameResource;
                        i9 = i11;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i9);
                iArrA = e.a(iArrA, i8, f(color, f7, f8));
                iArr = (int[][]) e.b(iArr, i8, iArrTrimStateSet);
                i8++;
            }
            i7 = 1;
            resources2 = resources;
        }
        int[] iArr3 = new int[i8];
        int[][] iArr4 = new int[i8][];
        System.arraycopy(iArrA, 0, iArr3, 0, i8);
        System.arraycopy(iArr, 0, iArr4, 0, i8);
        return new ColorStateList(iArr4, iArr3);
    }

    public static boolean e(Resources resources, int i7) {
        TypedValue typedValueC = c();
        resources.getValue(i7, typedValueC, true);
        int i8 = typedValueC.type;
        return i8 >= 28 && i8 <= 31;
    }

    public static int f(int i7, float f7, float f8) {
        boolean z7 = f8 >= 0.0f && f8 <= 100.0f;
        if (f7 == 1.0f && !z7) {
            return i7;
        }
        int iB = L.a.b((int) ((Color.alpha(i7) * f7) + 0.5f), 0, 255);
        if (z7) {
            a aVarC = a.c(i7);
            i7 = a.m(aVarC.j(), aVarC.i(), f8);
        }
        return (i7 & 16777215) | (iB << 24);
    }

    public static TypedArray g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
