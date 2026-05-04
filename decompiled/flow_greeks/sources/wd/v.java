package wd;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements ParameterizedType, Type {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f23923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f23924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f23925c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class a extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23926a = new a();

        public a() {
            super(1, x.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final String invoke(Type p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return x.h(p02);
        }
    }

    public v(Class rawType, Type type, List typeArguments) {
        kotlin.jvm.internal.t.f(rawType, "rawType");
        kotlin.jvm.internal.t.f(typeArguments, "typeArguments");
        this.f23923a = rawType;
        this.f23924b = type;
        this.f23925c = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        return kotlin.jvm.internal.t.b(this.f23923a, parameterizedType.getRawType()) && kotlin.jvm.internal.t.b(this.f23924b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f23925c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f23924b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f23923a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Type type = this.f23924b;
        if (type != null) {
            sb2.append(x.h(type));
            sb2.append("$");
            sb2.append(this.f23923a.getSimpleName());
        } else {
            sb2.append(x.h(this.f23923a));
        }
        Type[] typeArr = this.f23925c;
        if (!(typeArr.length == 0)) {
            dd.n.T(typeArr, sb2, (50 & 2) != 0 ? ", " : null, (50 & 4) != 0 ? "" : "<", (50 & 8) == 0 ? ">" : "", (50 & 16) != 0 ? -1 : 0, (50 & 32) != 0 ? "..." : null, (50 & 64) != 0 ? null : a.f23926a);
        }
        return sb2.toString();
    }

    public int hashCode() {
        int iHashCode = this.f23923a.hashCode();
        Type type = this.f23924b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
