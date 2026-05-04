package zd;

import cf.a;
import df.d;
import gf.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import zd.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Field f25801a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            kotlin.jvm.internal.t.f(field, "field");
            this.f25801a = field;
        }

        @Override // zd.p
        public String a() {
            StringBuilder sb2 = new StringBuilder();
            String name = this.f25801a.getName();
            kotlin.jvm.internal.t.e(name, "getName(...)");
            sb2.append(oe.h0.b(name));
            sb2.append("()");
            Class<?> type = this.f25801a.getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            sb2.append(le.f.f(type));
            return sb2.toString();
        }

        public final Field b() {
            return this.f25801a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f25802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f25803b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method getterMethod, Method method) {
            super(null);
            kotlin.jvm.internal.t.f(getterMethod, "getterMethod");
            this.f25802a = getterMethod;
            this.f25803b = method;
        }

        @Override // zd.p
        public String a() {
            return g3.d(this.f25802a);
        }

        public final Method b() {
            return this.f25802a;
        }

        public final Method c() {
            return this.f25803b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fe.y0 f25804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ze.n f25805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a.d f25806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final bf.c f25807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final bf.g f25808e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f25809f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(fe.y0 descriptor, ze.n proto, a.d signature, bf.c nameResolver, bf.g typeTable) {
            String str;
            super(null);
            kotlin.jvm.internal.t.f(descriptor, "descriptor");
            kotlin.jvm.internal.t.f(proto, "proto");
            kotlin.jvm.internal.t.f(signature, "signature");
            kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.t.f(typeTable, "typeTable");
            this.f25804a = descriptor;
            this.f25805b = proto;
            this.f25806c = signature;
            this.f25807d = nameResolver;
            this.f25808e = typeTable;
            if (signature.G()) {
                str = nameResolver.getString(signature.B().x()) + nameResolver.getString(signature.B().w());
            } else {
                d.a aVarD = df.i.d(df.i.f8111a, proto, nameResolver, typeTable, false, 8, null);
                if (aVarD == null) {
                    throw new x2("No field signature for property: " + descriptor);
                }
                String strB = aVarD.b();
                str = oe.h0.b(strB) + c() + "()" + aVarD.c();
            }
            this.f25809f = str;
        }

        @Override // zd.p
        public String a() {
            return this.f25809f;
        }

        public final fe.y0 b() {
            return this.f25804a;
        }

        public final String c() {
            String string;
            fe.m mVarB = this.f25804a.b();
            kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.t.b(this.f25804a.getVisibility(), fe.t.f9510d) && (mVarB instanceof vf.m)) {
                ze.c cVarE1 = ((vf.m) mVarB).e1();
                i.f classModuleName = cf.a.f4058i;
                kotlin.jvm.internal.t.e(classModuleName, "classModuleName");
                Integer num = (Integer) bf.e.a(cVarE1, classModuleName);
                if (num == null || (string = this.f25807d.getString(num.intValue())) == null) {
                    string = "main";
                }
                return '$' + ef.g.b(string);
            }
            if (!kotlin.jvm.internal.t.b(this.f25804a.getVisibility(), fe.t.f9507a) || !(mVarB instanceof fe.n0)) {
                return "";
            }
            fe.y0 y0Var = this.f25804a;
            kotlin.jvm.internal.t.d(y0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            vf.s sVarC0 = ((vf.n0) y0Var).c0();
            if (!(sVarC0 instanceof xe.r)) {
                return "";
            }
            xe.r rVar = (xe.r) sVarC0;
            if (rVar.f() == null) {
                return "";
            }
            return '$' + rVar.h().b();
        }

        public final bf.c d() {
            return this.f25807d;
        }

        public final ze.n e() {
            return this.f25805b;
        }

        public final a.d f() {
            return this.f25806c;
        }

        public final bf.g g() {
            return this.f25808e;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n.e f25810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n.e f25811b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(n.e getterSignature, n.e eVar) {
            super(null);
            kotlin.jvm.internal.t.f(getterSignature, "getterSignature");
            this.f25810a = getterSignature;
            this.f25811b = eVar;
        }

        @Override // zd.p
        public String a() {
            return this.f25810a.a();
        }

        public final n.e b() {
            return this.f25810a;
        }

        public final n.e c() {
            return this.f25811b;
        }
    }

    public /* synthetic */ p(kotlin.jvm.internal.k kVar) {
        this();
    }

    public abstract String a();

    public p() {
    }
}
