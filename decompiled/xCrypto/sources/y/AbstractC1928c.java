package y;

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
import v.AbstractC1869a;
import v.AbstractC1875g;

/* JADX INFO: renamed from: y.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1928c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f15809a = new ThreadLocal();

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
        ThreadLocal threadLocal = f15809a;
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
        int i4 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i5 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i4 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayG = g(resources2, theme, attributeSet, AbstractC1875g.f15175b);
                int resourceId = typedArrayG.getResourceId(AbstractC1875g.f15176c, -1);
                if (resourceId == -1 || e(resources2, resourceId)) {
                    color = typedArrayG.getColor(AbstractC1875g.f15176c, -65281);
                } else {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayG.getColor(AbstractC1875g.f15176c, -65281);
                    }
                }
                float f4 = 1.0f;
                if (typedArrayG.hasValue(AbstractC1875g.f15177d)) {
                    f4 = typedArrayG.getFloat(AbstractC1875g.f15177d, 1.0f);
                } else if (typedArrayG.hasValue(AbstractC1875g.f15179f)) {
                    f4 = typedArrayG.getFloat(AbstractC1875g.f15179f, 1.0f);
                }
                float f5 = (Build.VERSION.SDK_INT < 31 || !typedArrayG.hasValue(AbstractC1875g.f15178e)) ? typedArrayG.getFloat(AbstractC1875g.f15180g, -1.0f) : typedArrayG.getFloat(AbstractC1875g.f15178e, -1.0f);
                typedArrayG.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i6 = 0;
                for (int i7 = 0; i7 < attributeCount; i7++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i7);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != AbstractC1869a.f15112a && attributeNameResource != AbstractC1869a.f15113b) {
                        int i8 = i6 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i7, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i6] = attributeNameResource;
                        i6 = i8;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i6);
                iArrA = AbstractC1930e.a(iArrA, i5, f(color, f4, f5));
                iArr = (int[][]) AbstractC1930e.b(iArr, i5, iArrTrimStateSet);
                i5++;
            }
            i4 = 1;
            resources2 = resources;
        }
        int[] iArr3 = new int[i5];
        int[][] iArr4 = new int[i5][];
        System.arraycopy(iArrA, 0, iArr3, 0, i5);
        System.arraycopy(iArr, 0, iArr4, 0, i5);
        return new ColorStateList(iArr4, iArr3);
    }

    public static boolean e(Resources resources, int i4) {
        TypedValue typedValueC = c();
        resources.getValue(i4, typedValueC, true);
        int i5 = typedValueC.type;
        return i5 >= 28 && i5 <= 31;
    }

    public static int f(int i4, float f4, float f5) {
        boolean z4 = f5 >= 0.0f && f5 <= 100.0f;
        if (f4 == 1.0f && !z4) {
            return i4;
        }
        int iA = C.a.a((int) ((Color.alpha(i4) * f4) + 0.5f), 0, 255);
        if (z4) {
            C1926a c1926aC = C1926a.c(i4);
            i4 = C1926a.m(c1926aC.j(), c1926aC.i(), f5);
        }
        return (i4 & 16777215) | (iA << 24);
    }

    public static TypedArray g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
