package k0;

import S.i;
import Z.P;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.j;
import s3.AbstractC1024h;
import s3.I0;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static final void a(int i, View view, ViewGroup container) {
        j.e(view, "view");
        j.e(container, "container");
        int iC = i.c(i);
        if (iC == 0) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                if (P.K(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iC == 1) {
            if (P.K(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            ViewParent parent2 = view.getParent();
            if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                if (P.K(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                }
                container.addView(view);
            }
            view.setVisibility(0);
            return;
        }
        if (iC == 2) {
            if (P.K(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iC != 3) {
            return;
        }
        if (P.K(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static int b(String str) throws NoSuchFieldException {
        String str2;
        for (int i : i.d(2)) {
            if (i == 1) {
                str2 = "Brightness.light";
            } else {
                if (i != 2) {
                    throw null;
                }
                str2 = "Brightness.dark";
            }
            if (str2.equals(str)) {
                return i;
            }
        }
        throw new NoSuchFieldException(AbstractC1024h.b("No such Brightness: ", str));
    }

    public static int c(String str) throws NoSuchFieldException {
        for (int i : i.d(5)) {
            String str2 = null;
            if (i != 1) {
                if (i == 2) {
                    str2 = "HapticFeedbackType.lightImpact";
                } else if (i == 3) {
                    str2 = "HapticFeedbackType.mediumImpact";
                } else if (i == 4) {
                    str2 = "HapticFeedbackType.heavyImpact";
                } else {
                    if (i != 5) {
                        throw null;
                    }
                    str2 = "HapticFeedbackType.selectionClick";
                }
            }
            if ((str2 == null && str == null) || (str2 != null && str2.equals(str))) {
                return i;
            }
        }
        throw new NoSuchFieldException(AbstractC1024h.b("No such HapticFeedbackType: ", str));
    }

    public static int d(String str) throws NoSuchFieldException {
        String str2;
        for (int i : i.d(3)) {
            if (i == 1) {
                str2 = "SystemSoundType.click";
            } else if (i == 2) {
                str2 = "SystemSoundType.tick";
            } else {
                if (i != 3) {
                    throw null;
                }
                str2 = "SystemSoundType.alert";
            }
            if (str2.equals(str)) {
                return i;
            }
        }
        throw new NoSuchFieldException(AbstractC1024h.b("No such SoundType: ", str));
    }

    public static /* synthetic */ int e(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return -1;
        }
        throw null;
    }

    public static String f(String str, long j4) {
        return str + j4;
    }

    public static HashMap g(Class cls, I2.a aVar) {
        HashMap map = new HashMap();
        map.put(cls, aVar);
        return map;
    }

    public static Map h(HashMap map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static /* synthetic */ void i(int i, String str) {
        if (i == 0) {
            throw new NullPointerException(String.valueOf(str));
        }
    }

    public static /* synthetic */ String j(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return "NULL";
            case I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }
}
