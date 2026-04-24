package O;

import java.util.Locale;
import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f3994a = new e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f3995b = new e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f3996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f3997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f3998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n f3999f;

    public static class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4000b = new a(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f4001a;

        public a(boolean z7) {
            this.f4001a = z7;
        }

        @Override // O.o.c
        public int a(CharSequence charSequence, int i7, int i8) {
            int i9 = i8 + i7;
            boolean z7 = false;
            while (i7 < i9) {
                int iA = o.a(Character.getDirectionality(charSequence.charAt(i7)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i7++;
                        z7 = z7;
                    } else if (!this.f4001a) {
                        return 1;
                    }
                } else if (this.f4001a) {
                    return 0;
                }
                z7 = true;
                i7++;
                z7 = z7;
            }
            if (z7) {
                return this.f4001a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4002a = new b();

        @Override // O.o.c
        public int a(CharSequence charSequence, int i7, int i8) {
            int i9 = i8 + i7;
            int iB = 2;
            while (i7 < i9 && iB == 2) {
                iB = o.b(Character.getDirectionality(charSequence.charAt(i7)));
                i7++;
            }
            return iB;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i7, int i8);
    }

    public static abstract class d implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f4003a;

        public d(c cVar) {
            this.f4003a = cVar;
        }

        @Override // O.n
        public boolean a(CharSequence charSequence, int i7, int i8) {
            if (charSequence == null || i7 < 0 || i8 < 0 || charSequence.length() - i8 < i7) {
                throw new IllegalArgumentException();
            }
            return this.f4003a == null ? b() : c(charSequence, i7, i8);
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i7, int i8) {
            int iA = this.f4003a.a(charSequence, i7, i8);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return b();
            }
            return false;
        }
    }

    public static class e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f4004b;

        public e(c cVar, boolean z7) {
            super(cVar);
            this.f4004b = z7;
        }

        @Override // O.o.d
        public boolean b() {
            return this.f4004b;
        }
    }

    public static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f4005b = new f();

        public f() {
            super(null);
        }

        @Override // O.o.d
        public boolean b() {
            return p.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f4002a;
        f3996c = new e(bVar, false);
        f3997d = new e(bVar, true);
        f3998e = new e(a.f4000b, false);
        f3999f = f.f4005b;
    }

    public static int a(int i7) {
        if (i7 != 0) {
            return (i7 == 1 || i7 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i7) {
        if (i7 != 0) {
            if (i7 == 1 || i7 == 2) {
                return 0;
            }
            switch (i7) {
                case 14:
                case 15:
                    break;
                case com.amazon.c.a.a.c.f10119g /* 16 */:
                case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
