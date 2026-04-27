package a0;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    public interface a {
        void a(Object obj, Rect rect);
    }

    /* JADX INFO: renamed from: a0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0111b {
        Object a(Object obj, int i7);

        int b(Object obj);
    }

    public static class c implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f6070a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f6071b = new Rect();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f6072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f6073d;

        public c(boolean z7, a aVar) {
            this.f6072c = z7;
            this.f6073d = aVar;
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Rect rect = this.f6070a;
            Rect rect2 = this.f6071b;
            this.f6073d.a(obj, rect);
            this.f6073d.a(obj2, rect2);
            int i7 = rect.top;
            int i8 = rect2.top;
            if (i7 < i8) {
                return -1;
            }
            if (i7 > i8) {
                return 1;
            }
            int i9 = rect.left;
            int i10 = rect2.left;
            if (i9 < i10) {
                return this.f6072c ? 1 : -1;
            }
            if (i9 > i10) {
                return this.f6072c ? -1 : 1;
            }
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if (i11 < i12) {
                return -1;
            }
            if (i11 > i12) {
                return 1;
            }
            int i13 = rect.right;
            int i14 = rect2.right;
            if (i13 < i14) {
                return this.f6072c ? 1 : -1;
            }
            if (i13 > i14) {
                return this.f6072c ? -1 : 1;
            }
            return 0;
        }
    }

    public static boolean a(int i7, Rect rect, Rect rect2, Rect rect3) {
        boolean zB = b(i7, rect, rect2);
        if (b(i7, rect, rect3) || !zB) {
            return false;
        }
        return !j(i7, rect, rect3) || i7 == 17 || i7 == 66 || k(i7, rect, rect2) < m(i7, rect, rect3);
    }

    public static boolean b(int i7, Rect rect, Rect rect2) {
        if (i7 != 17) {
            if (i7 != 33) {
                if (i7 != 66) {
                    if (i7 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static Object c(Object obj, InterfaceC0111b interfaceC0111b, a aVar, Object obj2, Rect rect, int i7) {
        Rect rect2 = new Rect(rect);
        if (i7 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i7 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i7 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i7 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int iB = interfaceC0111b.b(obj);
        Rect rect3 = new Rect();
        Object obj3 = null;
        for (int i8 = 0; i8 < iB; i8++) {
            Object objA = interfaceC0111b.a(obj, i8);
            if (objA != obj2) {
                aVar.a(objA, rect3);
                if (h(i7, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    obj3 = objA;
                }
            }
        }
        return obj3;
    }

    public static Object d(Object obj, InterfaceC0111b interfaceC0111b, a aVar, Object obj2, int i7, boolean z7, boolean z8) {
        int iB = interfaceC0111b.b(obj);
        ArrayList arrayList = new ArrayList(iB);
        for (int i8 = 0; i8 < iB; i8++) {
            arrayList.add(interfaceC0111b.a(obj, i8));
        }
        Collections.sort(arrayList, new c(z7, aVar));
        if (i7 == 1) {
            return f(obj2, arrayList, z8);
        }
        if (i7 == 2) {
            return e(obj2, arrayList, z8);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    public static Object e(Object obj, ArrayList arrayList, boolean z7) {
        int size = arrayList.size();
        int iLastIndexOf = (obj == null ? -1 : arrayList.lastIndexOf(obj)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z7 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    public static Object f(Object obj, ArrayList arrayList, boolean z7) {
        int size = arrayList.size();
        int iIndexOf = (obj == null ? size : arrayList.indexOf(obj)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z7 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    public static int g(int i7, int i8) {
        return (i7 * 13 * i7) + (i8 * i8);
    }

    public static boolean h(int i7, Rect rect, Rect rect2, Rect rect3) {
        if (!i(rect, rect2, i7)) {
            return false;
        }
        if (i(rect, rect3, i7) && !a(i7, rect, rect2, rect3)) {
            return !a(i7, rect, rect3, rect2) && g(k(i7, rect, rect2), o(i7, rect, rect2)) < g(k(i7, rect, rect3), o(i7, rect, rect3));
        }
        return true;
    }

    public static boolean i(Rect rect, Rect rect2, int i7) {
        if (i7 == 17) {
            int i8 = rect.right;
            int i9 = rect2.right;
            return (i8 > i9 || rect.left >= i9) && rect.left > rect2.left;
        }
        if (i7 == 33) {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            return (i10 > i11 || rect.top >= i11) && rect.top > rect2.top;
        }
        if (i7 == 66) {
            int i12 = rect.left;
            int i13 = rect2.left;
            return (i12 < i13 || rect.right <= i13) && rect.right < rect2.right;
        }
        if (i7 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i14 = rect.top;
        int i15 = rect2.top;
        return (i14 < i15 || rect.bottom <= i15) && rect.bottom < rect2.bottom;
    }

    public static boolean j(int i7, Rect rect, Rect rect2) {
        if (i7 == 17) {
            return rect.left >= rect2.right;
        }
        if (i7 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i7 == 66) {
            return rect.right <= rect2.left;
        }
        if (i7 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static int k(int i7, Rect rect, Rect rect2) {
        return Math.max(0, l(i7, rect, rect2));
    }

    public static int l(int i7, Rect rect, Rect rect2) {
        int i8;
        int i9;
        if (i7 == 17) {
            i8 = rect.left;
            i9 = rect2.right;
        } else if (i7 == 33) {
            i8 = rect.top;
            i9 = rect2.bottom;
        } else if (i7 == 66) {
            i8 = rect2.left;
            i9 = rect.right;
        } else {
            if (i7 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i8 = rect2.top;
            i9 = rect.bottom;
        }
        return i8 - i9;
    }

    public static int m(int i7, Rect rect, Rect rect2) {
        return Math.max(1, n(i7, rect, rect2));
    }

    public static int n(int i7, Rect rect, Rect rect2) {
        int i8;
        int i9;
        if (i7 == 17) {
            i8 = rect.left;
            i9 = rect2.left;
        } else if (i7 == 33) {
            i8 = rect.top;
            i9 = rect2.top;
        } else if (i7 == 66) {
            i8 = rect2.right;
            i9 = rect.right;
        } else {
            if (i7 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i8 = rect2.bottom;
            i9 = rect.bottom;
        }
        return i8 - i9;
    }

    public static int o(int i7, Rect rect, Rect rect2) {
        if (i7 != 17) {
            if (i7 != 33) {
                if (i7 != 66) {
                    if (i7 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
