package b5;

import V4.a;
import android.util.Log;
import b5.AbstractC1001c0;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b5.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1001c0 {

    /* JADX INFO: renamed from: b5.c0$A */
    public static final class A {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public B f8664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r f8665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f8666c;

        /* JADX INFO: renamed from: b5.c0$A$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public B f8667a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public r f8668b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public s f8669c;

            public A a() {
                A a7 = new A();
                a7.d(this.f8667a);
                a7.b(this.f8668b);
                a7.c(this.f8669c);
                return a7;
            }

            public a b(r rVar) {
                this.f8668b = rVar;
                return this;
            }

            public a c(s sVar) {
                this.f8669c = sVar;
                return this;
            }

            public a d(B b7) {
                this.f8667a = b7;
                return this;
            }
        }

        public static A a(ArrayList arrayList) {
            A a7 = new A();
            a7.d((B) arrayList.get(0));
            a7.b((r) arrayList.get(1));
            a7.c((s) arrayList.get(2));
            return a7;
        }

        public void b(r rVar) {
            this.f8665b = rVar;
        }

        public void c(s sVar) {
            this.f8666c = sVar;
        }

        public void d(B b7) {
            this.f8664a = b7;
        }

        public ArrayList e() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8664a);
            arrayList.add(this.f8665b);
            arrayList.add(this.f8666c);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$B */
    public static final class B {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C f8670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f8671b;

        /* JADX INFO: renamed from: b5.c0$B$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public C f8672a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public List f8673b;

            public B a() {
                B b7 = new B();
                b7.e(this.f8672a);
                b7.d(this.f8673b);
                return b7;
            }

            public a b(List list) {
                this.f8673b = list;
                return this;
            }

            public a c(C c7) {
                this.f8672a = c7;
                return this;
            }
        }

        public static B a(ArrayList arrayList) {
            B b7 = new B();
            b7.e((C) arrayList.get(0));
            b7.d((List) arrayList.get(1));
            return b7;
        }

        public List b() {
            return this.f8671b;
        }

        public C c() {
            return this.f8670a;
        }

        public void d(List list) {
            if (list == null) {
                throw new IllegalStateException("Nonnull field \"providerData\" is null.");
            }
            this.f8671b = list;
        }

        public void e(C c7) {
            if (c7 == null) {
                throw new IllegalStateException("Nonnull field \"userInfo\" is null.");
            }
            this.f8670a = c7;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8670a);
            arrayList.add(this.f8671b);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$C */
    public static final class C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8678e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f8679f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f8680g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8681h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f8682i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f8683j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Long f8684k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Long f8685l;

        /* JADX INFO: renamed from: b5.c0$C$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f8686a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f8687b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f8688c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f8689d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f8690e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Boolean f8691f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Boolean f8692g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f8693h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public String f8694i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public String f8695j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public Long f8696k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public Long f8697l;

            public C a() {
                C c7 = new C();
                c7.m(this.f8686a);
                c7.d(this.f8687b);
                c7.c(this.f8688c);
                c7.i(this.f8689d);
                c7.h(this.f8690e);
                c7.e(this.f8691f);
                c7.f(this.f8692g);
                c7.j(this.f8693h);
                c7.l(this.f8694i);
                c7.k(this.f8695j);
                c7.b(this.f8696k);
                c7.g(this.f8697l);
                return c7;
            }

            public a b(Long l7) {
                this.f8696k = l7;
                return this;
            }

            public a c(String str) {
                this.f8688c = str;
                return this;
            }

            public a d(String str) {
                this.f8687b = str;
                return this;
            }

            public a e(Boolean bool) {
                this.f8691f = bool;
                return this;
            }

            public a f(Boolean bool) {
                this.f8692g = bool;
                return this;
            }

            public a g(Long l7) {
                this.f8697l = l7;
                return this;
            }

            public a h(String str) {
                this.f8690e = str;
                return this;
            }

            public a i(String str) {
                this.f8689d = str;
                return this;
            }

            public a j(String str) {
                this.f8694i = str;
                return this;
            }

            public a k(String str) {
                this.f8686a = str;
                return this;
            }
        }

        public static C a(ArrayList arrayList) {
            Long lValueOf;
            C c7 = new C();
            c7.m((String) arrayList.get(0));
            c7.d((String) arrayList.get(1));
            c7.c((String) arrayList.get(2));
            c7.i((String) arrayList.get(3));
            c7.h((String) arrayList.get(4));
            c7.e((Boolean) arrayList.get(5));
            c7.f((Boolean) arrayList.get(6));
            c7.j((String) arrayList.get(7));
            c7.l((String) arrayList.get(8));
            c7.k((String) arrayList.get(9));
            Object obj = arrayList.get(10);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            c7.b(lValueOf);
            Object obj2 = arrayList.get(11);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            c7.g(lValueOf2);
            return c7;
        }

        public void b(Long l7) {
            this.f8684k = l7;
        }

        public void c(String str) {
            this.f8676c = str;
        }

        public void d(String str) {
            this.f8675b = str;
        }

        public void e(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isAnonymous\" is null.");
            }
            this.f8679f = bool;
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isEmailVerified\" is null.");
            }
            this.f8680g = bool;
        }

        public void g(Long l7) {
            this.f8685l = l7;
        }

        public void h(String str) {
            this.f8678e = str;
        }

        public void i(String str) {
            this.f8677d = str;
        }

        public void j(String str) {
            this.f8681h = str;
        }

        public void k(String str) {
            this.f8683j = str;
        }

        public void l(String str) {
            this.f8682i = str;
        }

        public void m(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.f8674a = str;
        }

        public ArrayList n() {
            ArrayList arrayList = new ArrayList(12);
            arrayList.add(this.f8674a);
            arrayList.add(this.f8675b);
            arrayList.add(this.f8676c);
            arrayList.add(this.f8677d);
            arrayList.add(this.f8678e);
            arrayList.add(this.f8679f);
            arrayList.add(this.f8680g);
            arrayList.add(this.f8681h);
            arrayList.add(this.f8682i);
            arrayList.add(this.f8683j);
            arrayList.add(this.f8684k);
            arrayList.add(this.f8685l);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$D */
    public static final class D {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f8700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f8701d;

        public static D a(ArrayList arrayList) {
            D d7 = new D();
            d7.f((String) arrayList.get(0));
            d7.h((String) arrayList.get(1));
            d7.g((Boolean) arrayList.get(2));
            d7.i((Boolean) arrayList.get(3));
            return d7;
        }

        public String b() {
            return this.f8698a;
        }

        public Boolean c() {
            return this.f8700c;
        }

        public String d() {
            return this.f8699b;
        }

        public Boolean e() {
            return this.f8701d;
        }

        public void f(String str) {
            this.f8698a = str;
        }

        public void g(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"displayNameChanged\" is null.");
            }
            this.f8700c = bool;
        }

        public void h(String str) {
            this.f8699b = str;
        }

        public void i(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"photoUrlChanged\" is null.");
            }
            this.f8701d = bool;
        }

        public ArrayList j() {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(this.f8698a);
            arrayList.add(this.f8699b);
            arrayList.add(this.f8700c);
            arrayList.add(this.f8701d);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$E */
    public static final class E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f8703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f8704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8706e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f8707f;

        public static E a(ArrayList arrayList) {
            Long lValueOf;
            E e7 = new E();
            e7.l((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long lValueOf2 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            e7.m(lValueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 != null) {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            e7.i(lValueOf2);
            e7.h((String) arrayList.get(3));
            e7.j((String) arrayList.get(4));
            e7.k((String) arrayList.get(5));
            return e7;
        }

        public String b() {
            return this.f8705d;
        }

        public Long c() {
            return this.f8704c;
        }

        public String d() {
            return this.f8706e;
        }

        public String e() {
            return this.f8707f;
        }

        public String f() {
            return this.f8702a;
        }

        public Long g() {
            return this.f8703b;
        }

        public void h(String str) {
            this.f8705d = str;
        }

        public void i(Long l7) {
            this.f8704c = l7;
        }

        public void j(String str) {
            this.f8706e = str;
        }

        public void k(String str) {
            this.f8707f = str;
        }

        public void l(String str) {
            this.f8702a = str;
        }

        public void m(Long l7) {
            if (l7 == null) {
                throw new IllegalStateException("Nonnull field \"timeout\" is null.");
            }
            this.f8703b = l7;
        }

        public ArrayList n() {
            ArrayList arrayList = new ArrayList(6);
            arrayList.add(this.f8702a);
            arrayList.add(this.f8703b);
            arrayList.add(this.f8704c);
            arrayList.add(this.f8705d);
            arrayList.add(this.f8706e);
            arrayList.add(this.f8707f);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$F */
    public interface F {
        void a(Object obj);

        void b(Throwable th);
    }

    /* JADX INFO: renamed from: b5.c0$G */
    public interface G {
        void a();

        void b(Throwable th);
    }

    /* JADX INFO: renamed from: b5.c0$a, reason: case insensitive filesystem */
    public enum EnumC1002a {
        UNKNOWN(0),
        PASSWORD_RESET(1),
        VERIFY_EMAIL(2),
        RECOVER_EMAIL(3),
        EMAIL_SIGN_IN(4),
        VERIFY_AND_CHANGE_EMAIL(5),
        REVERT_SECOND_FACTOR_ADDITION(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8716a;

        EnumC1002a(int i7) {
            this.f8716a = i7;
        }
    }

    /* JADX INFO: renamed from: b5.c0$b, reason: case insensitive filesystem */
    public static final class C1003b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8719c;

        public static C1003b a(ArrayList arrayList) {
            C1003b c1003b = new C1003b();
            c1003b.e((String) arrayList.get(0));
            c1003b.g((String) arrayList.get(1));
            c1003b.f((String) arrayList.get(2));
            return c1003b;
        }

        public String b() {
            return this.f8717a;
        }

        public String c() {
            return this.f8719c;
        }

        public String d() {
            return this.f8718b;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appName\" is null.");
            }
            this.f8717a = str;
        }

        public void f(String str) {
            this.f8719c = str;
        }

        public void g(String str) {
            this.f8718b = str;
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8717a);
            arrayList.add(this.f8718b);
            arrayList.add(this.f8719c);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$c, reason: case insensitive filesystem */
    public interface InterfaceC1004c {

        /* JADX INFO: renamed from: b5.c0$c$a */
        public class a implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8720a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8721b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f8720a = arrayList;
                this.f8721b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8721b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8720a.add(0, a7);
                this.f8721b.a(this.f8720a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$b */
        public class b implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8722a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8723b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f8722a = arrayList;
                this.f8723b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8723b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8722a.add(0, a7);
                this.f8723b.a(this.f8722a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$c, reason: collision with other inner class name */
        public class C0145c implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8724a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8725b;

            public C0145c(ArrayList arrayList, a.e eVar) {
                this.f8724a = arrayList;
                this.f8725b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8725b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8724a.add(0, a7);
                this.f8725b.a(this.f8724a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$d */
        public class d implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8726a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8727b;

            public d(ArrayList arrayList, a.e eVar) {
                this.f8726a = arrayList;
                this.f8727b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8727b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8726a.add(0, a7);
                this.f8727b.a(this.f8726a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$e */
        public class e implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8728a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8729b;

            public e(ArrayList arrayList, a.e eVar) {
                this.f8728a = arrayList;
                this.f8729b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8728a.add(0, null);
                this.f8729b.a(this.f8728a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8729b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$f */
        public class f implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8730a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8731b;

            public f(ArrayList arrayList, a.e eVar) {
                this.f8730a = arrayList;
                this.f8731b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8731b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                this.f8730a.add(0, list);
                this.f8731b.a(this.f8730a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$g */
        public class g implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8732a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8733b;

            public g(ArrayList arrayList, a.e eVar) {
                this.f8732a = arrayList;
                this.f8733b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8732a.add(0, null);
                this.f8733b.a(this.f8732a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8733b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$h */
        public class h implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8734a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8735b;

            public h(ArrayList arrayList, a.e eVar) {
                this.f8734a = arrayList;
                this.f8735b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8734a.add(0, null);
                this.f8735b.a(this.f8734a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8735b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$i */
        public class i implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8736a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8737b;

            public i(ArrayList arrayList, a.e eVar) {
                this.f8736a = arrayList;
                this.f8737b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8737b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8736a.add(0, str);
                this.f8737b.a(this.f8736a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$j */
        public class j implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8738a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8739b;

            public j(ArrayList arrayList, a.e eVar) {
                this.f8738a = arrayList;
                this.f8739b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8738a.add(0, null);
                this.f8739b.a(this.f8738a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8739b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$k */
        public class k implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8740a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8741b;

            public k(ArrayList arrayList, a.e eVar) {
                this.f8740a = arrayList;
                this.f8741b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8741b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8740a.add(0, str);
                this.f8741b.a(this.f8740a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$l */
        public class l implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8742a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8743b;

            public l(ArrayList arrayList, a.e eVar) {
                this.f8742a = arrayList;
                this.f8743b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8743b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8742a.add(0, str);
                this.f8743b.a(this.f8742a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$m */
        public class m implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8744a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8745b;

            public m(ArrayList arrayList, a.e eVar) {
                this.f8744a = arrayList;
                this.f8745b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8745b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8744a.add(0, str);
                this.f8745b.a(this.f8744a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$n */
        public class n implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8746a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8747b;

            public n(ArrayList arrayList, a.e eVar) {
                this.f8746a = arrayList;
                this.f8747b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8746a.add(0, null);
                this.f8747b.a(this.f8746a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8747b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$o */
        public class o implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8748a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8749b;

            public o(ArrayList arrayList, a.e eVar) {
                this.f8748a = arrayList;
                this.f8749b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8748a.add(0, null);
                this.f8749b.a(this.f8748a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8749b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$p */
        public class p implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8750a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8751b;

            public p(ArrayList arrayList, a.e eVar) {
                this.f8750a = arrayList;
                this.f8751b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8751b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8750a.add(0, str);
                this.f8751b.a(this.f8750a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$q */
        public class q implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8752a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8753b;

            public q(ArrayList arrayList, a.e eVar) {
                this.f8752a = arrayList;
                this.f8753b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8752a.add(0, null);
                this.f8753b.a(this.f8752a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8753b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$r */
        public class r implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8754a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8755b;

            public r(ArrayList arrayList, a.e eVar) {
                this.f8754a = arrayList;
                this.f8755b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8754a.add(0, null);
                this.f8755b.a(this.f8754a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8755b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$s */
        public class s implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8756a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8757b;

            public s(ArrayList arrayList, a.e eVar) {
                this.f8756a = arrayList;
                this.f8757b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8757b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(o oVar) {
                this.f8756a.add(0, oVar);
                this.f8757b.a(this.f8756a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$t */
        public class t implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8758a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8759b;

            public t(ArrayList arrayList, a.e eVar) {
                this.f8758a = arrayList;
                this.f8759b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8758a.add(0, null);
                this.f8759b.a(this.f8758a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8759b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$u */
        public class u implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8760a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8761b;

            public u(ArrayList arrayList, a.e eVar) {
                this.f8760a = arrayList;
                this.f8761b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8761b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8760a.add(0, a7);
                this.f8761b.a(this.f8760a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$v */
        public class v implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8762a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8763b;

            public v(ArrayList arrayList, a.e eVar) {
                this.f8762a = arrayList;
                this.f8763b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8763b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8762a.add(0, a7);
                this.f8763b.a(this.f8762a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$c$w */
        public class w implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8764a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8765b;

            public w(ArrayList arrayList, a.e eVar) {
                this.f8764a = arrayList;
                this.f8765b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8765b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8764a.add(0, a7);
                this.f8765b.a(this.f8764a);
            }
        }

        static /* synthetic */ void A(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.r0((C1003b) arrayList.get(0), (String) arrayList.get(1), new f(new ArrayList(), eVar));
        }

        static /* synthetic */ void B(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.t((C1003b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new u(new ArrayList(), eVar));
        }

        static void I(V4.b bVar, InterfaceC1004c interfaceC1004c) {
            t0(bVar, "", interfaceC1004c);
        }

        static /* synthetic */ void L(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.z((C1003b) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new g(new ArrayList(), eVar));
        }

        static /* synthetic */ void M(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.r((C1003b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new C0145c(new ArrayList(), eVar));
        }

        static /* synthetic */ void U(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            interfaceC1004c.i((C1003b) ((ArrayList) obj).get(0), new v(new ArrayList(), eVar));
        }

        static /* synthetic */ void V(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.s0((C1003b) arrayList.get(0), (y) arrayList.get(1), new d(new ArrayList(), eVar));
        }

        static /* synthetic */ void W(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            interfaceC1004c.k((C1003b) ((ArrayList) obj).get(0), new k(new ArrayList(), eVar));
        }

        static /* synthetic */ void Y(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            interfaceC1004c.j0((C1003b) ((ArrayList) obj).get(0), new e(new ArrayList(), eVar));
        }

        static /* synthetic */ void Z(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.s((C1003b) arrayList.get(0), (Map) arrayList.get(1), new w(new ArrayList(), eVar));
        }

        static V4.h a() {
            return C1005d.f8766d;
        }

        static /* synthetic */ void b(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.H((C1003b) arrayList.get(0), (E) arrayList.get(1), new m(new ArrayList(), eVar));
        }

        static /* synthetic */ void b0(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            interfaceC1004c.p0((C1003b) ((ArrayList) obj).get(0), new o(new ArrayList(), eVar));
        }

        static /* synthetic */ void d0(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            interfaceC1004c.R((C1003b) ((ArrayList) obj).get(0), new p(new ArrayList(), eVar));
        }

        static /* synthetic */ void e0(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.l0((C1003b) arrayList.get(0), (t) arrayList.get(1), new j(new ArrayList(), eVar));
        }

        static /* synthetic */ void f(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.G((C1003b) arrayList.get(0), (String) arrayList.get(1), new r(new ArrayList(), eVar));
        }

        static /* synthetic */ void h0(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.f0((C1003b) arrayList.get(0), (String) arrayList.get(1), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void k0(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.j((C1003b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new b(new ArrayList(), eVar));
        }

        static /* synthetic */ void m0(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            C1003b c1003b = (C1003b) arrayList2.get(0);
            String str = (String) arrayList2.get(1);
            Number number = (Number) arrayList2.get(2);
            interfaceC1004c.T(c1003b, str, number == null ? null : Long.valueOf(number.longValue()), new q(arrayList, eVar));
        }

        static /* synthetic */ void n(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.v((C1003b) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new h(new ArrayList(), eVar));
        }

        static /* synthetic */ void o(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.e((C1003b) arrayList.get(0), (String) arrayList.get(1), new n(new ArrayList(), eVar));
        }

        static /* synthetic */ void p(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.K((C1003b) arrayList.get(0), (String) arrayList.get(1), new s(new ArrayList(), eVar));
        }

        static /* synthetic */ void q(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.h((C1003b) arrayList.get(0), (String) arrayList.get(1), new i(new ArrayList(), eVar));
        }

        static /* synthetic */ void q0(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.c((C1003b) arrayList.get(0), (String) arrayList.get(1), new l(new ArrayList(), eVar));
        }

        static void t0(V4.b bVar, String str, final InterfaceC1004c interfaceC1004c) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.registerIdTokenListener" + str2, a());
            if (interfaceC1004c != null) {
                aVar.e(new a.d() { // from class: b5.d0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.W(this.f8904a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.registerAuthStateListener" + str2, a());
            if (interfaceC1004c != null) {
                aVar2.e(new a.d() { // from class: b5.f0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.d0(this.f8908a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.useEmulator" + str2, a());
            if (interfaceC1004c != null) {
                aVar3.e(new a.d() { // from class: b5.j0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.m0(this.f8916a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.applyActionCode" + str2, a());
            if (interfaceC1004c != null) {
                aVar4.e(new a.d() { // from class: b5.k0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.f(this.f8918a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.checkActionCode" + str2, a());
            if (interfaceC1004c != null) {
                aVar5.e(new a.d() { // from class: b5.l0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.p(this.f8920a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.confirmPasswordReset" + str2, a());
            if (interfaceC1004c != null) {
                aVar6.e(new a.d() { // from class: b5.m0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.u(this.f8923a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.createUserWithEmailAndPassword" + str2, a());
            if (interfaceC1004c != null) {
                aVar7.e(new a.d() { // from class: b5.n0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.B(this.f8925a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInAnonymously" + str2, a());
            if (interfaceC1004c != null) {
                aVar8.e(new a.d() { // from class: b5.p0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.U(this.f8929a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithCredential" + str2, a());
            if (interfaceC1004c != null) {
                aVar9.e(new a.d() { // from class: b5.q0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.Z(this.f8931a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            V4.a aVar10 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithCustomToken" + str2, a());
            if (interfaceC1004c != null) {
                aVar10.e(new a.d() { // from class: b5.r0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.h0(this.f8933a, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            V4.a aVar11 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithEmailAndPassword" + str2, a());
            if (interfaceC1004c != null) {
                aVar11.e(new a.d() { // from class: b5.o0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.k0(this.f8927a, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
            V4.a aVar12 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithEmailLink" + str2, a());
            if (interfaceC1004c != null) {
                aVar12.e(new a.d() { // from class: b5.s0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.M(this.f8935a, obj, eVar);
                    }
                });
            } else {
                aVar12.e(null);
            }
            V4.a aVar13 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signInWithProvider" + str2, a());
            if (interfaceC1004c != null) {
                aVar13.e(new a.d() { // from class: b5.t0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.V(this.f8936a, obj, eVar);
                    }
                });
            } else {
                aVar13.e(null);
            }
            V4.a aVar14 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.signOut" + str2, a());
            if (interfaceC1004c != null) {
                aVar14.e(new a.d() { // from class: b5.u0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.Y(this.f8938a, obj, eVar);
                    }
                });
            } else {
                aVar14.e(null);
            }
            V4.a aVar15 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.fetchSignInMethodsForEmail" + str2, a());
            if (interfaceC1004c != null) {
                aVar15.e(new a.d() { // from class: b5.v0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.A(this.f8948a, obj, eVar);
                    }
                });
            } else {
                aVar15.e(null);
            }
            V4.a aVar16 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.sendPasswordResetEmail" + str2, a());
            if (interfaceC1004c != null) {
                aVar16.e(new a.d() { // from class: b5.w0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.L(this.f8949a, obj, eVar);
                    }
                });
            } else {
                aVar16.e(null);
            }
            V4.a aVar17 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.sendSignInLinkToEmail" + str2, a());
            if (interfaceC1004c != null) {
                aVar17.e(new a.d() { // from class: b5.x0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.n(this.f8951a, obj, eVar);
                    }
                });
            } else {
                aVar17.e(null);
            }
            V4.a aVar18 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.setLanguageCode" + str2, a());
            if (interfaceC1004c != null) {
                aVar18.e(new a.d() { // from class: b5.y0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.q(this.f8954a, obj, eVar);
                    }
                });
            } else {
                aVar18.e(null);
            }
            V4.a aVar19 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.setSettings" + str2, a());
            if (interfaceC1004c != null) {
                aVar19.e(new a.d() { // from class: b5.z0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.e0(this.f8958a, obj, eVar);
                    }
                });
            } else {
                aVar19.e(null);
            }
            V4.a aVar20 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.verifyPasswordResetCode" + str2, a());
            if (interfaceC1004c != null) {
                aVar20.e(new a.d() { // from class: b5.e0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.q0(this.f8906a, obj, eVar);
                    }
                });
            } else {
                aVar20.e(null);
            }
            V4.a aVar21 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.verifyPhoneNumber" + str2, a());
            if (interfaceC1004c != null) {
                aVar21.e(new a.d() { // from class: b5.g0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.b(this.f8910a, obj, eVar);
                    }
                });
            } else {
                aVar21.e(null);
            }
            V4.a aVar22 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.revokeTokenWithAuthorizationCode" + str2, a());
            if (interfaceC1004c != null) {
                aVar22.e(new a.d() { // from class: b5.h0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.o(this.f8912a, obj, eVar);
                    }
                });
            } else {
                aVar22.e(null);
            }
            V4.a aVar23 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthHostApi.initializeRecaptchaConfig" + str2, a());
            if (interfaceC1004c != null) {
                aVar23.e(new a.d() { // from class: b5.i0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1004c.b0(this.f8914a, obj, eVar);
                    }
                });
            } else {
                aVar23.e(null);
            }
        }

        static /* synthetic */ void u(InterfaceC1004c interfaceC1004c, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1004c.d((C1003b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new t(new ArrayList(), eVar));
        }

        void G(C1003b c1003b, String str, G g7);

        void H(C1003b c1003b, E e7, F f7);

        void K(C1003b c1003b, String str, F f7);

        void R(C1003b c1003b, F f7);

        void T(C1003b c1003b, String str, Long l7, G g7);

        void c(C1003b c1003b, String str, F f7);

        void d(C1003b c1003b, String str, String str2, G g7);

        void e(C1003b c1003b, String str, G g7);

        void f0(C1003b c1003b, String str, F f7);

        void h(C1003b c1003b, String str, F f7);

        void i(C1003b c1003b, F f7);

        void j(C1003b c1003b, String str, String str2, F f7);

        void j0(C1003b c1003b, G g7);

        void k(C1003b c1003b, F f7);

        void l0(C1003b c1003b, t tVar, G g7);

        void p0(C1003b c1003b, G g7);

        void r(C1003b c1003b, String str, String str2, F f7);

        void r0(C1003b c1003b, String str, F f7);

        void s(C1003b c1003b, Map map, F f7);

        void s0(C1003b c1003b, y yVar, F f7);

        void t(C1003b c1003b, String str, String str2, F f7);

        void v(C1003b c1003b, String str, q qVar, G g7);

        void z(C1003b c1003b, String str, q qVar, G g7);
    }

    /* JADX INFO: renamed from: b5.c0$d, reason: case insensitive filesystem */
    public static class C1005d extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C1005d f8766d = new C1005d();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -128:
                    return C1003b.a((ArrayList) f(byteBuffer));
                case -127:
                    return o.a((ArrayList) f(byteBuffer));
                case -126:
                    return p.a((ArrayList) f(byteBuffer));
                case -125:
                    return q.a((ArrayList) f(byteBuffer));
                case -124:
                    return r.a((ArrayList) f(byteBuffer));
                case -123:
                    return s.a((ArrayList) f(byteBuffer));
                case -122:
                    return t.a((ArrayList) f(byteBuffer));
                case -121:
                    return u.a((ArrayList) f(byteBuffer));
                case -120:
                    return v.a((ArrayList) f(byteBuffer));
                case -119:
                    return w.a((ArrayList) f(byteBuffer));
                case -118:
                    return x.a((ArrayList) f(byteBuffer));
                case -117:
                    return y.a((ArrayList) f(byteBuffer));
                case -116:
                    return z.a((ArrayList) f(byteBuffer));
                case -115:
                    return A.a((ArrayList) f(byteBuffer));
                case -114:
                    return B.a((ArrayList) f(byteBuffer));
                case -113:
                    return C.a((ArrayList) f(byteBuffer));
                case -112:
                    return D.a((ArrayList) f(byteBuffer));
                case -111:
                    return E.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof C1003b) {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((C1003b) obj).h());
                return;
            }
            if (obj instanceof o) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((o) obj).d());
                return;
            }
            if (obj instanceof p) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((p) obj).d());
                return;
            }
            if (obj instanceof q) {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, ((q) obj).r());
                return;
            }
            if (obj instanceof r) {
                byteArrayOutputStream.write(132);
                p(byteArrayOutputStream, ((r) obj).g());
                return;
            }
            if (obj instanceof s) {
                byteArrayOutputStream.write(133);
                p(byteArrayOutputStream, ((s) obj).f());
                return;
            }
            if (obj instanceof t) {
                byteArrayOutputStream.write(134);
                p(byteArrayOutputStream, ((t) obj).k());
                return;
            }
            if (obj instanceof u) {
                byteArrayOutputStream.write(135);
                p(byteArrayOutputStream, ((u) obj).i());
                return;
            }
            if (obj instanceof v) {
                byteArrayOutputStream.write(136);
                p(byteArrayOutputStream, ((v) obj).g());
                return;
            }
            if (obj instanceof w) {
                byteArrayOutputStream.write(137);
                p(byteArrayOutputStream, ((w) obj).c());
                return;
            }
            if (obj instanceof x) {
                byteArrayOutputStream.write(138);
                p(byteArrayOutputStream, ((x) obj).f());
                return;
            }
            if (obj instanceof y) {
                byteArrayOutputStream.write(139);
                p(byteArrayOutputStream, ((y) obj).h());
                return;
            }
            if (obj instanceof z) {
                byteArrayOutputStream.write(140);
                p(byteArrayOutputStream, ((z) obj).g());
                return;
            }
            if (obj instanceof A) {
                byteArrayOutputStream.write(141);
                p(byteArrayOutputStream, ((A) obj).e());
                return;
            }
            if (obj instanceof B) {
                byteArrayOutputStream.write(142);
                p(byteArrayOutputStream, ((B) obj).f());
                return;
            }
            if (obj instanceof C) {
                byteArrayOutputStream.write(143);
                p(byteArrayOutputStream, ((C) obj).n());
            } else if (obj instanceof D) {
                byteArrayOutputStream.write(144);
                p(byteArrayOutputStream, ((D) obj).j());
            } else if (!(obj instanceof E)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(145);
                p(byteArrayOutputStream, ((E) obj).n());
            }
        }
    }

    /* JADX INFO: renamed from: b5.c0$e, reason: case insensitive filesystem */
    public interface InterfaceC1006e {

        /* JADX INFO: renamed from: b5.c0$e$a */
        public class a implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8767a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8768b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f8767a = arrayList;
                this.f8768b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8768b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(B b7) {
                this.f8767a.add(0, b7);
                this.f8768b.a(this.f8767a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$b */
        public class b implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8769a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8770b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f8769a = arrayList;
                this.f8770b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8770b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(B b7) {
                this.f8769a.add(0, b7);
                this.f8770b.a(this.f8769a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$c */
        public class c implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8771a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8772b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f8771a = arrayList;
                this.f8772b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8772b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(B b7) {
                this.f8771a.add(0, b7);
                this.f8772b.a(this.f8771a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$d */
        public class d implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8773a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8774b;

            public d(ArrayList arrayList, a.e eVar) {
                this.f8773a = arrayList;
                this.f8774b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8774b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(B b7) {
                this.f8773a.add(0, b7);
                this.f8774b.a(this.f8773a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$e, reason: collision with other inner class name */
        public class C0146e implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8775a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8776b;

            public C0146e(ArrayList arrayList, a.e eVar) {
                this.f8775a = arrayList;
                this.f8776b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8775a.add(0, null);
                this.f8776b.a(this.f8775a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8776b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$f */
        public class f implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8777a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8778b;

            public f(ArrayList arrayList, a.e eVar) {
                this.f8777a = arrayList;
                this.f8778b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8777a.add(0, null);
                this.f8778b.a(this.f8777a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8778b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$g */
        public class g implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8779a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8780b;

            public g(ArrayList arrayList, a.e eVar) {
                this.f8779a = arrayList;
                this.f8780b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8780b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(u uVar) {
                this.f8779a.add(0, uVar);
                this.f8780b.a(this.f8779a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$h */
        public class h implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8781a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8782b;

            public h(ArrayList arrayList, a.e eVar) {
                this.f8781a = arrayList;
                this.f8782b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8782b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8781a.add(0, a7);
                this.f8782b.a(this.f8781a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$i */
        public class i implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8783a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8784b;

            public i(ArrayList arrayList, a.e eVar) {
                this.f8783a = arrayList;
                this.f8784b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8784b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8783a.add(0, a7);
                this.f8784b.a(this.f8783a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$j */
        public class j implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8785a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8786b;

            public j(ArrayList arrayList, a.e eVar) {
                this.f8785a = arrayList;
                this.f8786b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8786b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8785a.add(0, a7);
                this.f8786b.a(this.f8785a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$k */
        public class k implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8787a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8788b;

            public k(ArrayList arrayList, a.e eVar) {
                this.f8787a = arrayList;
                this.f8788b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8788b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8787a.add(0, a7);
                this.f8788b.a(this.f8787a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$l */
        public class l implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8789a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8790b;

            public l(ArrayList arrayList, a.e eVar) {
                this.f8789a = arrayList;
                this.f8790b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8790b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(B b7) {
                this.f8789a.add(0, b7);
                this.f8790b.a(this.f8789a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$m */
        public class m implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8791a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8792b;

            public m(ArrayList arrayList, a.e eVar) {
                this.f8791a = arrayList;
                this.f8792b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8791a.add(0, null);
                this.f8792b.a(this.f8791a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8792b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$e$n */
        public class n implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8793a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8794b;

            public n(ArrayList arrayList, a.e eVar) {
                this.f8793a = arrayList;
                this.f8794b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8794b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8793a.add(0, a7);
                this.f8794b.a(this.f8793a);
            }
        }

        static /* synthetic */ void A(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.J((C1003b) arrayList.get(0), (Map) arrayList.get(1), new c(new ArrayList(), eVar));
        }

        static /* synthetic */ void B(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.n((C1003b) arrayList.get(0), (q) arrayList.get(1), new m(new ArrayList(), eVar));
        }

        static /* synthetic */ void E(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.u((C1003b) arrayList.get(0), (y) arrayList.get(1), new k(new ArrayList(), eVar));
        }

        static /* synthetic */ void K(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            interfaceC1006e.S((C1003b) ((ArrayList) obj).get(0), new l(new ArrayList(), eVar));
        }

        static /* synthetic */ void O(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.I((C1003b) arrayList.get(0), (String) arrayList.get(1), (q) arrayList.get(2), new C0146e(new ArrayList(), eVar));
        }

        static /* synthetic */ void P(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.D((C1003b) arrayList.get(0), (Map) arrayList.get(1), new j(new ArrayList(), eVar));
        }

        static V4.h a() {
            return C1007f.f8795d;
        }

        static /* synthetic */ void c(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.e((C1003b) arrayList.get(0), (y) arrayList.get(1), new i(new ArrayList(), eVar));
        }

        static void d(V4.b bVar, InterfaceC1006e interfaceC1006e) {
            j(bVar, "", interfaceC1006e);
        }

        static /* synthetic */ void f(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.C((C1003b) arrayList.get(0), (Map) arrayList.get(1), new h(new ArrayList(), eVar));
        }

        static /* synthetic */ void i(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.H((C1003b) arrayList.get(0), (Boolean) arrayList.get(1), new g(new ArrayList(), eVar));
        }

        static void j(V4.b bVar, String str, final InterfaceC1006e interfaceC1006e) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.delete" + str2, a());
            if (interfaceC1006e != null) {
                aVar.e(new a.d() { // from class: b5.A0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.p(this.f8580a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.getIdToken" + str2, a());
            if (interfaceC1006e != null) {
                aVar2.e(new a.d() { // from class: b5.J0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.i(this.f8604a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.linkWithCredential" + str2, a());
            if (interfaceC1006e != null) {
                aVar3.e(new a.d() { // from class: b5.K0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.f(this.f8606a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.linkWithProvider" + str2, a());
            if (interfaceC1006e != null) {
                aVar4.e(new a.d() { // from class: b5.L0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.c(this.f8608a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reauthenticateWithCredential" + str2, a());
            if (interfaceC1006e != null) {
                aVar5.e(new a.d() { // from class: b5.M0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.P(this.f8610a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
            V4.a aVar6 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reauthenticateWithProvider" + str2, a());
            if (interfaceC1006e != null) {
                aVar6.e(new a.d() { // from class: b5.N0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.E(this.f8613a, obj, eVar);
                    }
                });
            } else {
                aVar6.e(null);
            }
            V4.a aVar7 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.reload" + str2, a());
            if (interfaceC1006e != null) {
                aVar7.e(new a.d() { // from class: b5.B0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.K(this.f8583a, obj, eVar);
                    }
                });
            } else {
                aVar7.e(null);
            }
            V4.a aVar8 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.sendEmailVerification" + str2, a());
            if (interfaceC1006e != null) {
                aVar8.e(new a.d() { // from class: b5.C0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.B(this.f8586a, obj, eVar);
                    }
                });
            } else {
                aVar8.e(null);
            }
            V4.a aVar9 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.unlink" + str2, a());
            if (interfaceC1006e != null) {
                aVar9.e(new a.d() { // from class: b5.D0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.v(this.f8588a, obj, eVar);
                    }
                });
            } else {
                aVar9.e(null);
            }
            V4.a aVar10 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updateEmail" + str2, a());
            if (interfaceC1006e != null) {
                aVar10.e(new a.d() { // from class: b5.E0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.r(this.f8591a, obj, eVar);
                    }
                });
            } else {
                aVar10.e(null);
            }
            V4.a aVar11 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updatePassword" + str2, a());
            if (interfaceC1006e != null) {
                aVar11.e(new a.d() { // from class: b5.F0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.l(this.f8594a, obj, eVar);
                    }
                });
            } else {
                aVar11.e(null);
            }
            V4.a aVar12 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updatePhoneNumber" + str2, a());
            if (interfaceC1006e != null) {
                aVar12.e(new a.d() { // from class: b5.G0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.A(this.f8597a, obj, eVar);
                    }
                });
            } else {
                aVar12.e(null);
            }
            V4.a aVar13 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.updateProfile" + str2, a());
            if (interfaceC1006e != null) {
                aVar13.e(new a.d() { // from class: b5.H0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.t(this.f8600a, obj, eVar);
                    }
                });
            } else {
                aVar13.e(null);
            }
            V4.a aVar14 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.FirebaseAuthUserHostApi.verifyBeforeUpdateEmail" + str2, a());
            if (interfaceC1006e != null) {
                aVar14.e(new a.d() { // from class: b5.I0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.InterfaceC1006e.O(this.f8602a, obj, eVar);
                    }
                });
            } else {
                aVar14.e(null);
            }
        }

        static /* synthetic */ void l(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.s((C1003b) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar));
        }

        static /* synthetic */ void p(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            interfaceC1006e.R((C1003b) ((ArrayList) obj).get(0), new f(new ArrayList(), eVar));
        }

        static /* synthetic */ void r(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.q((C1003b) arrayList.get(0), (String) arrayList.get(1), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void t(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.G((C1003b) arrayList.get(0), (D) arrayList.get(1), new d(new ArrayList(), eVar));
        }

        static /* synthetic */ void v(InterfaceC1006e interfaceC1006e, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            interfaceC1006e.k((C1003b) arrayList.get(0), (String) arrayList.get(1), new n(new ArrayList(), eVar));
        }

        void C(C1003b c1003b, Map map, F f7);

        void D(C1003b c1003b, Map map, F f7);

        void G(C1003b c1003b, D d7, F f7);

        void H(C1003b c1003b, Boolean bool, F f7);

        void I(C1003b c1003b, String str, q qVar, G g7);

        void J(C1003b c1003b, Map map, F f7);

        void R(C1003b c1003b, G g7);

        void S(C1003b c1003b, F f7);

        void e(C1003b c1003b, y yVar, F f7);

        void k(C1003b c1003b, String str, F f7);

        void n(C1003b c1003b, q qVar, G g7);

        void q(C1003b c1003b, String str, F f7);

        void s(C1003b c1003b, String str, F f7);

        void u(C1003b c1003b, y yVar, F f7);
    }

    /* JADX INFO: renamed from: b5.c0$f, reason: case insensitive filesystem */
    public static class C1007f extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C1007f f8795d = new C1007f();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -128:
                    return C1003b.a((ArrayList) f(byteBuffer));
                case -127:
                    return o.a((ArrayList) f(byteBuffer));
                case -126:
                    return p.a((ArrayList) f(byteBuffer));
                case -125:
                    return q.a((ArrayList) f(byteBuffer));
                case -124:
                    return r.a((ArrayList) f(byteBuffer));
                case -123:
                    return s.a((ArrayList) f(byteBuffer));
                case -122:
                    return t.a((ArrayList) f(byteBuffer));
                case -121:
                    return u.a((ArrayList) f(byteBuffer));
                case -120:
                    return v.a((ArrayList) f(byteBuffer));
                case -119:
                    return w.a((ArrayList) f(byteBuffer));
                case -118:
                    return x.a((ArrayList) f(byteBuffer));
                case -117:
                    return y.a((ArrayList) f(byteBuffer));
                case -116:
                    return z.a((ArrayList) f(byteBuffer));
                case -115:
                    return A.a((ArrayList) f(byteBuffer));
                case -114:
                    return B.a((ArrayList) f(byteBuffer));
                case -113:
                    return C.a((ArrayList) f(byteBuffer));
                case -112:
                    return D.a((ArrayList) f(byteBuffer));
                case -111:
                    return E.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof C1003b) {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((C1003b) obj).h());
                return;
            }
            if (obj instanceof o) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((o) obj).d());
                return;
            }
            if (obj instanceof p) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((p) obj).d());
                return;
            }
            if (obj instanceof q) {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, ((q) obj).r());
                return;
            }
            if (obj instanceof r) {
                byteArrayOutputStream.write(132);
                p(byteArrayOutputStream, ((r) obj).g());
                return;
            }
            if (obj instanceof s) {
                byteArrayOutputStream.write(133);
                p(byteArrayOutputStream, ((s) obj).f());
                return;
            }
            if (obj instanceof t) {
                byteArrayOutputStream.write(134);
                p(byteArrayOutputStream, ((t) obj).k());
                return;
            }
            if (obj instanceof u) {
                byteArrayOutputStream.write(135);
                p(byteArrayOutputStream, ((u) obj).i());
                return;
            }
            if (obj instanceof v) {
                byteArrayOutputStream.write(136);
                p(byteArrayOutputStream, ((v) obj).g());
                return;
            }
            if (obj instanceof w) {
                byteArrayOutputStream.write(137);
                p(byteArrayOutputStream, ((w) obj).c());
                return;
            }
            if (obj instanceof x) {
                byteArrayOutputStream.write(138);
                p(byteArrayOutputStream, ((x) obj).f());
                return;
            }
            if (obj instanceof y) {
                byteArrayOutputStream.write(139);
                p(byteArrayOutputStream, ((y) obj).h());
                return;
            }
            if (obj instanceof z) {
                byteArrayOutputStream.write(140);
                p(byteArrayOutputStream, ((z) obj).g());
                return;
            }
            if (obj instanceof A) {
                byteArrayOutputStream.write(141);
                p(byteArrayOutputStream, ((A) obj).e());
                return;
            }
            if (obj instanceof B) {
                byteArrayOutputStream.write(142);
                p(byteArrayOutputStream, ((B) obj).f());
                return;
            }
            if (obj instanceof C) {
                byteArrayOutputStream.write(143);
                p(byteArrayOutputStream, ((C) obj).n());
            } else if (obj instanceof D) {
                byteArrayOutputStream.write(144);
                p(byteArrayOutputStream, ((D) obj).j());
            } else if (!(obj instanceof E)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(145);
                p(byteArrayOutputStream, ((E) obj).n());
            }
        }
    }

    /* JADX INFO: renamed from: b5.c0$g, reason: case insensitive filesystem */
    public static class C1008g extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f8797b;

        public C1008g(String str, String str2, Object obj) {
            super(str2);
            this.f8796a = str;
            this.f8797b = obj;
        }
    }

    /* JADX INFO: renamed from: b5.c0$h */
    public interface h {

        /* JADX INFO: renamed from: b5.c0$h$a */
        public class a implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8798a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8799b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f8798a = arrayList;
                this.f8799b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8799b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(A a7) {
                this.f8798a.add(0, a7);
                this.f8799b.a(this.f8798a);
            }
        }

        static V4.h a() {
            return i.f8800d;
        }

        static void h(V4.b bVar, h hVar) {
            j(bVar, "", hVar);
        }

        static void j(V4.b bVar, String str, final h hVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactoResolverHostApi.resolveSignIn" + str2, a());
            if (hVar != null) {
                aVar.e(new a.d() { // from class: b5.O0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.h.k(this.f8615a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
        }

        static /* synthetic */ void k(h hVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            hVar.e((String) arrayList.get(0), (x) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
        }

        void e(String str, x xVar, String str2, F f7);
    }

    /* JADX INFO: renamed from: b5.c0$i */
    public static class i extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final i f8800d = new i();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -128:
                    return r.a((ArrayList) f(byteBuffer));
                case -127:
                    return s.a((ArrayList) f(byteBuffer));
                case -126:
                    return x.a((ArrayList) f(byteBuffer));
                case -125:
                    return A.a((ArrayList) f(byteBuffer));
                case -124:
                    return B.a((ArrayList) f(byteBuffer));
                case -123:
                    return C.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof r) {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((r) obj).g());
                return;
            }
            if (obj instanceof s) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((s) obj).f());
                return;
            }
            if (obj instanceof x) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((x) obj).f());
                return;
            }
            if (obj instanceof A) {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, ((A) obj).e());
            } else if (obj instanceof B) {
                byteArrayOutputStream.write(132);
                p(byteArrayOutputStream, ((B) obj).f());
            } else if (!(obj instanceof C)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(133);
                p(byteArrayOutputStream, ((C) obj).n());
            }
        }
    }

    /* JADX INFO: renamed from: b5.c0$j */
    public interface j {

        /* JADX INFO: renamed from: b5.c0$j$a */
        public class a implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8801a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8802b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f8801a = arrayList;
                this.f8802b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8802b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(z zVar) {
                this.f8801a.add(0, zVar);
                this.f8802b.a(this.f8801a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$j$b */
        public class b implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8803a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8804b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f8803a = arrayList;
                this.f8804b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8804b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8803a.add(0, str);
                this.f8804b.a(this.f8803a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$j$c */
        public class c implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8805a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8806b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f8805a = arrayList;
                this.f8806b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8806b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8805a.add(0, str);
                this.f8806b.a(this.f8805a);
            }
        }

        static V4.h a() {
            return k.f8807d;
        }

        static /* synthetic */ void e(j jVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            jVar.k((String) arrayList.get(0), (String) arrayList.get(1), new c(new ArrayList(), eVar));
        }

        static /* synthetic */ void f(j jVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            jVar.b((String) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar));
        }

        static void g(V4.b bVar, j jVar) {
            l(bVar, "", jVar);
        }

        static /* synthetic */ void i(j jVar, Object obj, a.e eVar) {
            jVar.j((String) ((ArrayList) obj).get(0), new a(new ArrayList(), eVar));
        }

        static void l(V4.b bVar, String str, final j jVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.generateSecret" + str2, a());
            if (jVar != null) {
                aVar.e(new a.d() { // from class: b5.P0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.j.i(this.f8617a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForEnrollment" + str2, a());
            if (jVar != null) {
                aVar2.e(new a.d() { // from class: b5.Q0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.j.f(this.f8619a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpHostApi.getAssertionForSignIn" + str2, a());
            if (jVar != null) {
                aVar3.e(new a.d() { // from class: b5.R0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.j.e(this.f8620a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
        }

        void b(String str, String str2, F f7);

        void j(String str, F f7);

        void k(String str, String str2, F f7);
    }

    /* JADX INFO: renamed from: b5.c0$k */
    public static class k extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final k f8807d = new k();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            return b7 != -128 ? super.g(b7, byteBuffer) : z.a((ArrayList) f(byteBuffer));
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof z)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((z) obj).g());
            }
        }
    }

    /* JADX INFO: renamed from: b5.c0$l */
    public interface l {

        /* JADX INFO: renamed from: b5.c0$l$a */
        public class a implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8808a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8809b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f8808a = arrayList;
                this.f8809b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8809b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(String str) {
                this.f8808a.add(0, str);
                this.f8809b.a(this.f8808a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$l$b */
        public class b implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8810a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8811b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f8810a = arrayList;
                this.f8811b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8810a.add(0, null);
                this.f8811b.a(this.f8810a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8811b.a(AbstractC1001c0.a(th));
            }
        }

        static V4.h a() {
            return new V4.o();
        }

        static /* synthetic */ void b(l lVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            lVar.e((String) arrayList.get(0), (String) arrayList.get(1), new b(new ArrayList(), eVar));
        }

        static void c(V4.b bVar, String str, final l lVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.generateQrCodeUrl" + str2, a());
            if (lVar != null) {
                aVar.e(new a.d() { // from class: b5.S0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.l.h(this.f8622a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorTotpSecretHostApi.openInOtpApp" + str2, a());
            if (lVar != null) {
                aVar2.e(new a.d() { // from class: b5.T0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.l.b(this.f8624a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
        }

        static void g(V4.b bVar, l lVar) {
            c(bVar, "", lVar);
        }

        static /* synthetic */ void h(l lVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            lVar.f((String) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
        }

        void e(String str, String str2, G g7);

        void f(String str, String str2, String str3, F f7);
    }

    /* JADX INFO: renamed from: b5.c0$m */
    public interface m {

        /* JADX INFO: renamed from: b5.c0$m$a */
        public class a implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8812a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8813b;

            public a(ArrayList arrayList, a.e eVar) {
                this.f8812a = arrayList;
                this.f8813b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8812a.add(0, null);
                this.f8813b.a(this.f8812a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8813b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$m$b */
        public class b implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8814a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8815b;

            public b(ArrayList arrayList, a.e eVar) {
                this.f8814a = arrayList;
                this.f8815b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8814a.add(0, null);
                this.f8815b.a(this.f8814a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8815b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$m$c */
        public class c implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8816a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8817b;

            public c(ArrayList arrayList, a.e eVar) {
                this.f8816a = arrayList;
                this.f8817b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8817b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(w wVar) {
                this.f8816a.add(0, wVar);
                this.f8817b.a(this.f8816a);
            }
        }

        /* JADX INFO: renamed from: b5.c0$m$d */
        public class d implements G {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8818a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8819b;

            public d(ArrayList arrayList, a.e eVar) {
                this.f8818a = arrayList;
                this.f8819b = eVar;
            }

            @Override // b5.AbstractC1001c0.G
            public void a() {
                this.f8818a.add(0, null);
                this.f8819b.a(this.f8818a);
            }

            @Override // b5.AbstractC1001c0.G
            public void b(Throwable th) {
                this.f8819b.a(AbstractC1001c0.a(th));
            }
        }

        /* JADX INFO: renamed from: b5.c0$m$e */
        public class e implements F {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f8820a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a.e f8821b;

            public e(ArrayList arrayList, a.e eVar) {
                this.f8820a = arrayList;
                this.f8821b = eVar;
            }

            @Override // b5.AbstractC1001c0.F
            public void b(Throwable th) {
                this.f8821b.a(AbstractC1001c0.a(th));
            }

            @Override // b5.AbstractC1001c0.F
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                this.f8820a.add(0, list);
                this.f8821b.a(this.f8820a);
            }
        }

        static V4.h a() {
            return n.f8822d;
        }

        static /* synthetic */ void b(m mVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            mVar.l((C1003b) arrayList.get(0), (String) arrayList.get(1), new d(new ArrayList(), eVar));
        }

        static void d(V4.b bVar, m mVar) {
            v(bVar, "", mVar);
        }

        static /* synthetic */ void f(m mVar, Object obj, a.e eVar) {
            mVar.m((C1003b) ((ArrayList) obj).get(0), new e(new ArrayList(), eVar));
        }

        static /* synthetic */ void r(m mVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            mVar.n((C1003b) arrayList.get(0), (x) arrayList.get(1), (String) arrayList.get(2), new a(new ArrayList(), eVar));
        }

        static /* synthetic */ void s(m mVar, Object obj, a.e eVar) {
            ArrayList arrayList = (ArrayList) obj;
            mVar.g((C1003b) arrayList.get(0), (String) arrayList.get(1), (String) arrayList.get(2), new b(new ArrayList(), eVar));
        }

        static /* synthetic */ void u(m mVar, Object obj, a.e eVar) {
            mVar.w((C1003b) ((ArrayList) obj).get(0), new c(new ArrayList(), eVar));
        }

        static void v(V4.b bVar, String str, final m mVar) {
            String str2;
            if (str.isEmpty()) {
                str2 = "";
            } else {
                str2 = "." + str;
            }
            V4.a aVar = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollPhone" + str2, a());
            if (mVar != null) {
                aVar.e(new a.d() { // from class: b5.U0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.m.r(this.f8626a, obj, eVar);
                    }
                });
            } else {
                aVar.e(null);
            }
            V4.a aVar2 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.enrollTotp" + str2, a());
            if (mVar != null) {
                aVar2.e(new a.d() { // from class: b5.V0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.m.s(this.f8628a, obj, eVar);
                    }
                });
            } else {
                aVar2.e(null);
            }
            V4.a aVar3 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getSession" + str2, a());
            if (mVar != null) {
                aVar3.e(new a.d() { // from class: b5.W0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.m.u(this.f8630a, obj, eVar);
                    }
                });
            } else {
                aVar3.e(null);
            }
            V4.a aVar4 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.unenroll" + str2, a());
            if (mVar != null) {
                aVar4.e(new a.d() { // from class: b5.X0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.m.b(this.f8632a, obj, eVar);
                    }
                });
            } else {
                aVar4.e(null);
            }
            V4.a aVar5 = new V4.a(bVar, "dev.flutter.pigeon.firebase_auth_platform_interface.MultiFactorUserHostApi.getEnrolledFactors" + str2, a());
            if (mVar != null) {
                aVar5.e(new a.d() { // from class: b5.Y0
                    @Override // V4.a.d
                    public final void a(Object obj, a.e eVar) {
                        AbstractC1001c0.m.f(this.f8637a, obj, eVar);
                    }
                });
            } else {
                aVar5.e(null);
            }
        }

        void g(C1003b c1003b, String str, String str2, G g7);

        void l(C1003b c1003b, String str, G g7);

        void m(C1003b c1003b, F f7);

        void n(C1003b c1003b, x xVar, String str, G g7);

        void w(C1003b c1003b, F f7);
    }

    /* JADX INFO: renamed from: b5.c0$n */
    public static class n extends V4.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final n f8822d = new n();

        @Override // V4.o
        public Object g(byte b7, ByteBuffer byteBuffer) {
            switch (b7) {
                case -128:
                    return C1003b.a((ArrayList) f(byteBuffer));
                case -127:
                    return v.a((ArrayList) f(byteBuffer));
                case -126:
                    return w.a((ArrayList) f(byteBuffer));
                case -125:
                    return x.a((ArrayList) f(byteBuffer));
                default:
                    return super.g(b7, byteBuffer);
            }
        }

        @Override // V4.o
        public void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof C1003b) {
                byteArrayOutputStream.write(128);
                p(byteArrayOutputStream, ((C1003b) obj).h());
                return;
            }
            if (obj instanceof v) {
                byteArrayOutputStream.write(129);
                p(byteArrayOutputStream, ((v) obj).g());
            } else if (obj instanceof w) {
                byteArrayOutputStream.write(130);
                p(byteArrayOutputStream, ((w) obj).c());
            } else if (!(obj instanceof x)) {
                super.p(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(131);
                p(byteArrayOutputStream, ((x) obj).f());
            }
        }
    }

    /* JADX INFO: renamed from: b5.c0$o */
    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public EnumC1002a f8823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p f8824b;

        /* JADX INFO: renamed from: b5.c0$o$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public EnumC1002a f8825a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public p f8826b;

            public o a() {
                o oVar = new o();
                oVar.c(this.f8825a);
                oVar.b(this.f8826b);
                return oVar;
            }

            public a b(p pVar) {
                this.f8826b = pVar;
                return this;
            }

            public a c(EnumC1002a enumC1002a) {
                this.f8825a = enumC1002a;
                return this;
            }
        }

        public static o a(ArrayList arrayList) {
            o oVar = new o();
            oVar.c(EnumC1002a.values()[((Integer) arrayList.get(0)).intValue()]);
            oVar.b((p) arrayList.get(1));
            return oVar;
        }

        public void b(p pVar) {
            if (pVar == null) {
                throw new IllegalStateException("Nonnull field \"data\" is null.");
            }
            this.f8824b = pVar;
        }

        public void c(EnumC1002a enumC1002a) {
            if (enumC1002a == null) {
                throw new IllegalStateException("Nonnull field \"operation\" is null.");
            }
            this.f8823a = enumC1002a;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            EnumC1002a enumC1002a = this.f8823a;
            arrayList.add(enumC1002a == null ? null : Integer.valueOf(enumC1002a.f8716a));
            arrayList.add(this.f8824b);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$p */
    public static final class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8828b;

        /* JADX INFO: renamed from: b5.c0$p$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f8829a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f8830b;

            public p a() {
                p pVar = new p();
                pVar.b(this.f8829a);
                pVar.c(this.f8830b);
                return pVar;
            }

            public a b(String str) {
                this.f8829a = str;
                return this;
            }

            public a c(String str) {
                this.f8830b = str;
                return this;
            }
        }

        public static p a(ArrayList arrayList) {
            p pVar = new p();
            pVar.b((String) arrayList.get(0));
            pVar.c((String) arrayList.get(1));
            return pVar;
        }

        public void b(String str) {
            this.f8827a = str;
        }

        public void c(String str) {
            this.f8828b = str;
        }

        public ArrayList d() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8827a);
            arrayList.add(this.f8828b);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$q */
    public static final class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f8833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8834d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8835e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f8836f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f8837g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8838h;

        public static q a(ArrayList arrayList) {
            q qVar = new q();
            qVar.q((String) arrayList.get(0));
            qVar.m((String) arrayList.get(1));
            qVar.n((Boolean) arrayList.get(2));
            qVar.o((String) arrayList.get(3));
            qVar.l((String) arrayList.get(4));
            qVar.j((Boolean) arrayList.get(5));
            qVar.k((String) arrayList.get(6));
            qVar.p((String) arrayList.get(7));
            return qVar;
        }

        public Boolean b() {
            return this.f8836f;
        }

        public String c() {
            return this.f8837g;
        }

        public String d() {
            return this.f8835e;
        }

        public String e() {
            return this.f8832b;
        }

        public Boolean f() {
            return this.f8833c;
        }

        public String g() {
            return this.f8834d;
        }

        public String h() {
            return this.f8838h;
        }

        public String i() {
            return this.f8831a;
        }

        public void j(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"androidInstallApp\" is null.");
            }
            this.f8836f = bool;
        }

        public void k(String str) {
            this.f8837g = str;
        }

        public void l(String str) {
            this.f8835e = str;
        }

        public void m(String str) {
            this.f8832b = str;
        }

        public void n(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"handleCodeInApp\" is null.");
            }
            this.f8833c = bool;
        }

        public void o(String str) {
            this.f8834d = str;
        }

        public void p(String str) {
            this.f8838h = str;
        }

        public void q(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"url\" is null.");
            }
            this.f8831a = str;
        }

        public ArrayList r() {
            ArrayList arrayList = new ArrayList(8);
            arrayList.add(this.f8831a);
            arrayList.add(this.f8832b);
            arrayList.add(this.f8833c);
            arrayList.add(this.f8834d);
            arrayList.add(this.f8835e);
            arrayList.add(this.f8836f);
            arrayList.add(this.f8837g);
            arrayList.add(this.f8838h);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$r */
    public static final class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map f8843e;

        /* JADX INFO: renamed from: b5.c0$r$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Boolean f8844a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f8845b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f8846c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f8847d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Map f8848e;

            public r a() {
                r rVar = new r();
                rVar.c(this.f8844a);
                rVar.e(this.f8845b);
                rVar.f(this.f8846c);
                rVar.b(this.f8847d);
                rVar.d(this.f8848e);
                return rVar;
            }

            public a b(Boolean bool) {
                this.f8844a = bool;
                return this;
            }

            public a c(Map map) {
                this.f8848e = map;
                return this;
            }

            public a d(String str) {
                this.f8845b = str;
                return this;
            }

            public a e(String str) {
                this.f8846c = str;
                return this;
            }
        }

        public static r a(ArrayList arrayList) {
            r rVar = new r();
            rVar.c((Boolean) arrayList.get(0));
            rVar.e((String) arrayList.get(1));
            rVar.f((String) arrayList.get(2));
            rVar.b((String) arrayList.get(3));
            rVar.d((Map) arrayList.get(4));
            return rVar;
        }

        public void b(String str) {
            this.f8842d = str;
        }

        public void c(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"isNewUser\" is null.");
            }
            this.f8839a = bool;
        }

        public void d(Map map) {
            this.f8843e = map;
        }

        public void e(String str) {
            this.f8840b = str;
        }

        public void f(String str) {
            this.f8841c = str;
        }

        public ArrayList g() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(this.f8839a);
            arrayList.add(this.f8840b);
            arrayList.add(this.f8841c);
            arrayList.add(this.f8842d);
            arrayList.add(this.f8843e);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$s */
    public static final class s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f8851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8852d;

        /* JADX INFO: renamed from: b5.c0$s$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f8853a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f8854b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f8855c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f8856d;

            public s a() {
                s sVar = new s();
                sVar.d(this.f8853a);
                sVar.e(this.f8854b);
                sVar.c(this.f8855c);
                sVar.b(this.f8856d);
                return sVar;
            }

            public a b(String str) {
                this.f8856d = str;
                return this;
            }

            public a c(Long l7) {
                this.f8855c = l7;
                return this;
            }

            public a d(String str) {
                this.f8853a = str;
                return this;
            }

            public a e(String str) {
                this.f8854b = str;
                return this;
            }
        }

        public static s a(ArrayList arrayList) {
            Long lValueOf;
            s sVar = new s();
            sVar.d((String) arrayList.get(0));
            sVar.e((String) arrayList.get(1));
            Object obj = arrayList.get(2);
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            sVar.c(lValueOf);
            sVar.b((String) arrayList.get(3));
            return sVar;
        }

        public void b(String str) {
            this.f8852d = str;
        }

        public void c(Long l7) {
            if (l7 == null) {
                throw new IllegalStateException("Nonnull field \"nativeId\" is null.");
            }
            this.f8851c = l7;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.f8849a = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"signInMethod\" is null.");
            }
            this.f8850b = str;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(this.f8849a);
            arrayList.add(this.f8850b);
            arrayList.add(this.f8851c);
            arrayList.add(this.f8852d);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$t */
    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Boolean f8861e;

        public static t a(ArrayList arrayList) {
            t tVar = new t();
            tVar.f((Boolean) arrayList.get(0));
            tVar.j((String) arrayList.get(1));
            tVar.h((String) arrayList.get(2));
            tVar.i((String) arrayList.get(3));
            tVar.g((Boolean) arrayList.get(4));
            return tVar;
        }

        public Boolean b() {
            return this.f8857a;
        }

        public Boolean c() {
            return this.f8861e;
        }

        public String d() {
            return this.f8859c;
        }

        public String e() {
            return this.f8860d;
        }

        public void f(Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"appVerificationDisabledForTesting\" is null.");
            }
            this.f8857a = bool;
        }

        public void g(Boolean bool) {
            this.f8861e = bool;
        }

        public void h(String str) {
            this.f8859c = str;
        }

        public void i(String str) {
            this.f8860d = str;
        }

        public void j(String str) {
            this.f8858b = str;
        }

        public ArrayList k() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(this.f8857a);
            arrayList.add(this.f8858b);
            arrayList.add(this.f8859c);
            arrayList.add(this.f8860d);
            arrayList.add(this.f8861e);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$u */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f8863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f8864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f8865d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8866e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map f8867f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f8868g;

        /* JADX INFO: renamed from: b5.c0$u$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f8869a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f8870b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f8871c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Long f8872d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f8873e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Map f8874f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f8875g;

            public u a() {
                u uVar = new u();
                uVar.h(this.f8869a);
                uVar.d(this.f8870b);
                uVar.b(this.f8871c);
                uVar.e(this.f8872d);
                uVar.f(this.f8873e);
                uVar.c(this.f8874f);
                uVar.g(this.f8875g);
                return uVar;
            }

            public a b(Long l7) {
                this.f8871c = l7;
                return this;
            }

            public a c(Map map) {
                this.f8874f = map;
                return this;
            }

            public a d(Long l7) {
                this.f8870b = l7;
                return this;
            }

            public a e(Long l7) {
                this.f8872d = l7;
                return this;
            }

            public a f(String str) {
                this.f8873e = str;
                return this;
            }

            public a g(String str) {
                this.f8875g = str;
                return this;
            }

            public a h(String str) {
                this.f8869a = str;
                return this;
            }
        }

        public static u a(ArrayList arrayList) {
            Long lValueOf;
            Long lValueOf2;
            u uVar = new u();
            uVar.h((String) arrayList.get(0));
            Object obj = arrayList.get(1);
            Long lValueOf3 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            uVar.d(lValueOf);
            Object obj2 = arrayList.get(2);
            if (obj2 == null) {
                lValueOf2 = null;
            } else {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            uVar.b(lValueOf2);
            Object obj3 = arrayList.get(3);
            if (obj3 != null) {
                lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            uVar.e(lValueOf3);
            uVar.f((String) arrayList.get(4));
            uVar.c((Map) arrayList.get(5));
            uVar.g((String) arrayList.get(6));
            return uVar;
        }

        public void b(Long l7) {
            this.f8864c = l7;
        }

        public void c(Map map) {
            this.f8867f = map;
        }

        public void d(Long l7) {
            this.f8863b = l7;
        }

        public void e(Long l7) {
            this.f8865d = l7;
        }

        public void f(String str) {
            this.f8866e = str;
        }

        public void g(String str) {
            this.f8868g = str;
        }

        public void h(String str) {
            this.f8862a = str;
        }

        public ArrayList i() {
            ArrayList arrayList = new ArrayList(7);
            arrayList.add(this.f8862a);
            arrayList.add(this.f8863b);
            arrayList.add(this.f8864c);
            arrayList.add(this.f8865d);
            arrayList.add(this.f8866e);
            arrayList.add(this.f8867f);
            arrayList.add(this.f8868g);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$v */
    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f8877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8879d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8880e;

        /* JADX INFO: renamed from: b5.c0$v$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f8881a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Double f8882b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f8883c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f8884d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f8885e;

            public v a() {
                v vVar = new v();
                vVar.b(this.f8881a);
                vVar.c(this.f8882b);
                vVar.d(this.f8883c);
                vVar.f(this.f8884d);
                vVar.e(this.f8885e);
                return vVar;
            }

            public a b(String str) {
                this.f8881a = str;
                return this;
            }

            public a c(Double d7) {
                this.f8882b = d7;
                return this;
            }

            public a d(String str) {
                this.f8883c = str;
                return this;
            }

            public a e(String str) {
                this.f8885e = str;
                return this;
            }

            public a f(String str) {
                this.f8884d = str;
                return this;
            }
        }

        public static v a(ArrayList arrayList) {
            v vVar = new v();
            vVar.b((String) arrayList.get(0));
            vVar.c((Double) arrayList.get(1));
            vVar.d((String) arrayList.get(2));
            vVar.f((String) arrayList.get(3));
            vVar.e((String) arrayList.get(4));
            return vVar;
        }

        public void b(String str) {
            this.f8876a = str;
        }

        public void c(Double d7) {
            if (d7 == null) {
                throw new IllegalStateException("Nonnull field \"enrollmentTimestamp\" is null.");
            }
            this.f8877b = d7;
        }

        public void d(String str) {
            this.f8878c = str;
        }

        public void e(String str) {
            this.f8880e = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"uid\" is null.");
            }
            this.f8879d = str;
        }

        public ArrayList g() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(this.f8876a);
            arrayList.add(this.f8877b);
            arrayList.add(this.f8878c);
            arrayList.add(this.f8879d);
            arrayList.add(this.f8880e);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$w */
    public static final class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8886a;

        /* JADX INFO: renamed from: b5.c0$w$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f8887a;

            public w a() {
                w wVar = new w();
                wVar.b(this.f8887a);
                return wVar;
            }

            public a b(String str) {
                this.f8887a = str;
                return this;
            }
        }

        public static w a(ArrayList arrayList) {
            w wVar = new w();
            wVar.b((String) arrayList.get(0));
            return wVar;
        }

        public void b(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"id\" is null.");
            }
            this.f8886a = str;
        }

        public ArrayList c() {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.f8886a);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$x */
    public static final class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8889b;

        public static x a(ArrayList arrayList) {
            x xVar = new x();
            xVar.e((String) arrayList.get(0));
            xVar.d((String) arrayList.get(1));
            return xVar;
        }

        public String b() {
            return this.f8889b;
        }

        public String c() {
            return this.f8888a;
        }

        public void d(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationCode\" is null.");
            }
            this.f8889b = str;
        }

        public void e(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"verificationId\" is null.");
            }
            this.f8888a = str;
        }

        public ArrayList f() {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(this.f8888a);
            arrayList.add(this.f8889b);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$y */
    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f8891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map f8892c;

        public static y a(ArrayList arrayList) {
            y yVar = new y();
            yVar.f((String) arrayList.get(0));
            yVar.g((List) arrayList.get(1));
            yVar.e((Map) arrayList.get(2));
            return yVar;
        }

        public Map b() {
            return this.f8892c;
        }

        public String c() {
            return this.f8890a;
        }

        public List d() {
            return this.f8891b;
        }

        public void e(Map map) {
            this.f8892c = map;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"providerId\" is null.");
            }
            this.f8890a = str;
        }

        public void g(List list) {
            this.f8891b = list;
        }

        public ArrayList h() {
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(this.f8890a);
            arrayList.add(this.f8891b);
            arrayList.add(this.f8892c);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b5.c0$z */
    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f8893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f8894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f8895c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8896d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8897e;

        /* JADX INFO: renamed from: b5.c0$z$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Long f8898a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f8899b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f8900c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f8901d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f8902e;

            public z a() {
                z zVar = new z();
                zVar.b(this.f8898a);
                zVar.c(this.f8899b);
                zVar.d(this.f8900c);
                zVar.e(this.f8901d);
                zVar.f(this.f8902e);
                return zVar;
            }

            public a b(Long l7) {
                this.f8898a = l7;
                return this;
            }

            public a c(Long l7) {
                this.f8899b = l7;
                return this;
            }

            public a d(Long l7) {
                this.f8900c = l7;
                return this;
            }

            public a e(String str) {
                this.f8901d = str;
                return this;
            }

            public a f(String str) {
                this.f8902e = str;
                return this;
            }
        }

        public static z a(ArrayList arrayList) {
            Long lValueOf;
            Long lValueOf2;
            z zVar = new z();
            Object obj = arrayList.get(0);
            Long lValueOf3 = null;
            if (obj == null) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            zVar.b(lValueOf);
            Object obj2 = arrayList.get(1);
            if (obj2 == null) {
                lValueOf2 = null;
            } else {
                lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            zVar.c(lValueOf2);
            Object obj3 = arrayList.get(2);
            if (obj3 != null) {
                lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
            }
            zVar.d(lValueOf3);
            zVar.e((String) arrayList.get(3));
            zVar.f((String) arrayList.get(4));
            return zVar;
        }

        public void b(Long l7) {
            this.f8893a = l7;
        }

        public void c(Long l7) {
            this.f8894b = l7;
        }

        public void d(Long l7) {
            this.f8895c = l7;
        }

        public void e(String str) {
            this.f8896d = str;
        }

        public void f(String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"secretKey\" is null.");
            }
            this.f8897e = str;
        }

        public ArrayList g() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(this.f8893a);
            arrayList.add(this.f8894b);
            arrayList.add(this.f8895c);
            arrayList.add(this.f8896d);
            arrayList.add(this.f8897e);
            return arrayList;
        }
    }

    public static ArrayList a(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        if (th instanceof C1008g) {
            C1008g c1008g = (C1008g) th;
            arrayList.add(c1008g.f8796a);
            arrayList.add(c1008g.getMessage());
            arrayList.add(c1008g.f8797b);
        } else {
            arrayList.add(th.toString());
            arrayList.add(th.getClass().getSimpleName());
            arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        }
        return arrayList;
    }
}
