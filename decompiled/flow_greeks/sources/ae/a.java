package ae;

import ae.h;
import dd.a0;
import dd.o0;
import dd.s;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC0010a f752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f754e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f755f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f756g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: ae.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class EnumC0010a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0010a f757a = new EnumC0010a("CALL_BY_NAME", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0010a f758b = new EnumC0010a("POSITIONAL_CALL", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumC0010a[] f759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ jd.a f760d;

        static {
            EnumC0010a[] enumC0010aArrA = a();
            f759c = enumC0010aArrA;
            f760d = jd.b.a(enumC0010aArrA);
        }

        public EnumC0010a(String str, int i10) {
        }

        public static final /* synthetic */ EnumC0010a[] a() {
            return new EnumC0010a[]{f757a, f758b};
        }

        public static EnumC0010a valueOf(String str) {
            return (EnumC0010a) Enum.valueOf(EnumC0010a.class, str);
        }

        public static EnumC0010a[] values() {
            return (EnumC0010a[]) f759c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f761a = new b("JAVA", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f762b = new b("KOTLIN", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ b[] f763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ jd.a f764d;

        static {
            b[] bVarArrA = a();
            f763c = bVarArrA;
            f764d = jd.b.a(bVarArrA);
        }

        public b(String str, int i10) {
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f761a, f762b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f763c.clone();
        }
    }

    public a(Class jClass, List parameterNames, EnumC0010a callMode, b origin, List methods) {
        t.f(jClass, "jClass");
        t.f(parameterNames, "parameterNames");
        t.f(callMode, "callMode");
        t.f(origin, "origin");
        t.f(methods, "methods");
        this.f750a = jClass;
        this.f751b = parameterNames;
        this.f752c = callMode;
        this.f753d = methods;
        ArrayList arrayList = new ArrayList(s.u(methods, 10));
        Iterator it = methods.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.f754e = arrayList;
        List list = this.f753d;
        ArrayList arrayList2 = new ArrayList(s.u(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            t.c(returnType);
            Class<?> clsK = le.f.k(returnType);
            if (clsK != null) {
                returnType = clsK;
            }
            arrayList2.add(returnType);
        }
        this.f755f = arrayList2;
        List list2 = this.f753d;
        ArrayList arrayList3 = new ArrayList(s.u(list2, 10));
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.f756g = arrayList3;
        if (this.f752c == EnumC0010a.f758b && origin == b.f761a && !a0.p0(this.f751b, "value").isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // ae.h
    public List a() {
        return this.f754e;
    }

    @Override // ae.h
    public /* bridge */ /* synthetic */ Member b() {
        return (Member) e();
    }

    @Override // ae.h
    public boolean c() {
        return h.a.b(this);
    }

    @Override // ae.h
    public Object call(Object[] args) {
        t.f(args, "args");
        d(args);
        ArrayList arrayList = new ArrayList(args.length);
        int length = args.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            Object obj = args[i10];
            int i12 = i11 + 1;
            Object objQ = (obj == null && this.f752c == EnumC0010a.f757a) ? this.f756g.get(i11) : f.q(obj, (Class) this.f755f.get(i11));
            if (objQ == null) {
                f.p(i11, (String) this.f751b.get(i11), (Class) this.f755f.get(i11));
                throw new cd.h();
            }
            arrayList.add(objQ);
            i10++;
            i11 = i12;
        }
        return f.g(this.f750a, o0.t(a0.S0(this.f751b, arrayList)), this.f753d);
    }

    public void d(Object[] objArr) {
        h.a.a(this, objArr);
    }

    public Void e() {
        return null;
    }

    @Override // ae.h
    public Type getReturnType() {
        return this.f750a;
    }

    public /* synthetic */ a(Class cls, List list, EnumC0010a enumC0010a, b bVar, List list2, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 16) != 0) {
            list2 = new ArrayList(s.u(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                list2.add(cls.getDeclaredMethod((String) it.next(), null));
            }
        }
        this(cls, list, enumC0010a, bVar, list2);
    }
}
