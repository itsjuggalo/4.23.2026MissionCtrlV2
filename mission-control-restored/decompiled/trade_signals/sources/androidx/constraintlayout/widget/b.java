package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EnumC0176b f10919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f10921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10924h;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10925a;

        static {
            int[] iArr = new int[EnumC0176b.values().length];
            f10925a = iArr;
            try {
                iArr[EnumC0176b.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10925a[EnumC0176b.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10925a[EnumC0176b.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10925a[EnumC0176b.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10925a[EnumC0176b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10925a[EnumC0176b.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10925a[EnumC0176b.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10925a[EnumC0176b.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    public enum EnumC0176b {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public b(b bVar, Object obj) {
        this.f10917a = false;
        this.f10918b = bVar.f10918b;
        this.f10919c = bVar.f10919c;
        d(obj);
    }

    public static HashMap a(HashMap map, View view) {
        HashMap map2 = new HashMap();
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            b bVar = (b) map.get(str);
            try {
                map2.put(str, str.equals("BackgroundColor") ? new b(bVar, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())) : new b(bVar, cls.getMethod("getMap" + str, null).invoke(view, null)));
            } catch (IllegalAccessException e8) {
                e = e8;
                e.printStackTrace();
            } catch (NoSuchMethodException e9) {
                e = e9;
                e.printStackTrace();
            } catch (InvocationTargetException e10) {
                e = e10;
                e.printStackTrace();
            }
        }
        return map2;
    }

    public static void b(Context context, XmlPullParser xmlPullParser, HashMap map) {
        EnumC0176b enumC0176b;
        int resourceId;
        Object string;
        float dimension;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), F.d.f1370k4);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string2 = null;
        Object objValueOf = null;
        EnumC0176b enumC0176b2 = null;
        boolean z7 = false;
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            if (index == F.d.f1379l4) {
                string2 = typedArrayObtainStyledAttributes.getString(index);
                if (string2 != null && string2.length() > 0) {
                    string2 = Character.toUpperCase(string2.charAt(0)) + string2.substring(1);
                }
            } else if (index == F.d.f1461v4) {
                string2 = typedArrayObtainStyledAttributes.getString(index);
                z7 = true;
            } else if (index == F.d.f1388m4) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                enumC0176b2 = EnumC0176b.BOOLEAN_TYPE;
            } else {
                if (index == F.d.f1405o4) {
                    enumC0176b = EnumC0176b.COLOR_TYPE;
                } else if (index == F.d.f1397n4) {
                    enumC0176b = EnumC0176b.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == F.d.f1437s4) {
                        enumC0176b = EnumC0176b.DIMENSION_TYPE;
                        dimension = TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == F.d.f1413p4) {
                        enumC0176b = EnumC0176b.DIMENSION_TYPE;
                        dimension = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == F.d.f1421q4) {
                        enumC0176b = EnumC0176b.FLOAT_TYPE;
                        dimension = typedArrayObtainStyledAttributes.getFloat(index, Float.NaN);
                    } else {
                        if (index == F.d.f1429r4) {
                            enumC0176b = EnumC0176b.INT_TYPE;
                            resourceId = typedArrayObtainStyledAttributes.getInteger(index, -1);
                        } else if (index == F.d.f1453u4) {
                            enumC0176b = EnumC0176b.STRING_TYPE;
                            string = typedArrayObtainStyledAttributes.getString(index);
                            Object obj = string;
                            enumC0176b2 = enumC0176b;
                            objValueOf = obj;
                        } else if (index == F.d.f1445t4) {
                            enumC0176b = EnumC0176b.REFERENCE_TYPE;
                            resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            if (resourceId == -1) {
                                resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                        }
                        string = Integer.valueOf(resourceId);
                        Object obj2 = string;
                        enumC0176b2 = enumC0176b;
                        objValueOf = obj2;
                    }
                    string = Float.valueOf(dimension);
                    Object obj22 = string;
                    enumC0176b2 = enumC0176b;
                    objValueOf = obj22;
                }
                resourceId = typedArrayObtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(resourceId);
                Object obj222 = string;
                enumC0176b2 = enumC0176b;
                objValueOf = obj222;
            }
        }
        if (string2 != null && objValueOf != null) {
            map.put(string2, new b(string2, enumC0176b2, objValueOf, z7));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void c(View view, HashMap map) {
        StringBuilder sb;
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            b bVar = (b) map.get(str);
            String str2 = bVar.f10917a ? str : "set" + str;
            try {
                switch (a.f10925a[bVar.f10919c.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(bVar.f10920d));
                        break;
                    case 2:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(bVar.f10923g));
                        break;
                    case 3:
                        cls.getMethod(str2, CharSequence.class).invoke(view, bVar.f10922f);
                        break;
                    case 4:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(bVar.f10924h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(bVar.f10924h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(bVar.f10920d));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(bVar.f10921e));
                        break;
                    case 8:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(bVar.f10921e));
                        break;
                }
            } catch (IllegalAccessException e8) {
                e = e8;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e9) {
                Log.e("TransitionLayout", e9.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(str2);
                Log.e("TransitionLayout", sb2.toString());
            } catch (InvocationTargetException e10) {
                e = e10;
                sb = new StringBuilder();
                sb.append(" Custom Attribute \"");
                sb.append(str);
                sb.append("\" not found on ");
                sb.append(cls.getName());
                Log.e("TransitionLayout", sb.toString());
                e.printStackTrace();
            }
        }
    }

    public void d(Object obj) {
        switch (a.f10925a[this.f10919c.ordinal()]) {
            case 1:
            case 6:
                this.f10920d = ((Integer) obj).intValue();
                break;
            case 2:
                this.f10923g = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.f10922f = (String) obj;
                break;
            case 4:
            case 5:
                this.f10924h = ((Integer) obj).intValue();
                break;
            case 7:
            case 8:
                this.f10921e = ((Float) obj).floatValue();
                break;
        }
    }

    public b(String str, EnumC0176b enumC0176b, Object obj, boolean z7) {
        this.f10918b = str;
        this.f10919c = enumC0176b;
        this.f10917a = z7;
        d(obj);
    }
}
